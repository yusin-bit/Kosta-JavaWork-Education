import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 클라우드 MySQL(Aiven) 초기화: deploy/aiven.properties 의 접속 정보로 deploy/cloud-init.sql 을 실행한다.
 * - 이미 User 테이블이 있으면 아무것도 하지 않는다 (중복 실행 방지).
 * - 접속 정보는 출력하지 않는다.
 *
 * 실행 (프로젝트 폴더에서):
 *   java -cp <mysql-connector-j.jar> deploy/tools/CloudInit.java          → 상태 확인만
 *   java -cp <mysql-connector-j.jar> deploy/tools/CloudInit.java --apply  → 초기화 실행
 */
public class CloudInit {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        try (FileInputStream in = new FileInputStream("deploy/aiven.properties")) {
            p.load(in);
        }
        String url = p.getProperty("url", "").trim();
        String user = p.getProperty("userName", "").trim();
        String pass = p.getProperty("userPass", "").trim();
        if (url.isEmpty() || user.isEmpty() || pass.isEmpty())
            throw new IllegalStateException("deploy/aiven.properties 의 url / userName / userPass 를 채워주세요.");
        String multiUrl = url + (url.contains("?") ? "&" : "?") + "allowMultiQueries=true";

        try (Connection c = DriverManager.getConnection(multiUrl, user, pass); Statement s = c.createStatement()) {
            System.out.println("연결 성공: database=" + c.getCatalog() + ", server=" + c.getMetaData().getDatabaseProductVersion());
            try (ResultSet rs = s.executeQuery("SHOW VARIABLES LIKE 'lower_case_table_names'")) {
                if (rs.next()) System.out.println("lower_case_table_names=" + rs.getString(2));
            }
            boolean exists;
            try (ResultSet rs = c.getMetaData().getTables(c.getCatalog(), null, "User", new String[] { "TABLE" })) {
                exists = rs.next();
            }
            if (exists) {
                System.out.println("User 테이블이 이미 있습니다. 초기화를 건너뜁니다.");
            } else if (args.length > 0 && args[0].equals("--apply")) {
                s.execute(Files.readString(Path.of("deploy/cloud-init.sql"), StandardCharsets.UTF_8));
                System.out.println("초기화 완료");
            } else {
                System.out.println("빈 DB 입니다. --apply 로 실행하면 초기화합니다.");
                return;
            }
            for (String t : new String[] { "User", "BigCategory", "SmallCategory", "Item", "Post", "Rental", "Admin",
                    "View_Available_Post", "View_Rental_LenderID", "View_Rental_Info" }) {
                try (ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM " + t)) {
                    rs.next();
                    System.out.println("  " + t + " = " + rs.getInt(1));
                }
            }
        }
    }
}
