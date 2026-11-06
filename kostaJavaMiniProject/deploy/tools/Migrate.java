import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 스키마 마이그레이션 실행기: 이미 있는 컬럼/테이블은 건너뛰고 없는 것만 만든다 (여러 번 실행해도 안전).
 * 접속 정보는 출력하지 않는다.
 *
 * 실행 (프로젝트 폴더에서):
 *   java -cp <mysql-connector-j.jar> deploy/tools/Migrate.java local deploy/migrations/002_admin_features.sql
 *   java -cp <mysql-connector-j.jar> deploy/tools/Migrate.java aiven deploy/migrations/002_admin_features.sql
 */
public class Migrate {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        String file = args[0].equals("aiven") ? "deploy/aiven.properties" : "resources/dbmanager.properties";
        try (FileInputStream in = new FileInputStream(file)) {
            p.load(in);
        }
        String sqlText = Files.readString(Path.of(args[1]), StandardCharsets.UTF_8).replaceAll("(?m)^\\s*--.*$", "");
        try (Connection c = DriverManager.getConnection(p.getProperty("url").strip(), p.getProperty("userName").strip(), p.getProperty("userPass").strip());
                Statement s = c.createStatement()) {
            DatabaseMetaData meta = c.getMetaData();
            Pattern addColumn = Pattern.compile("(?is)ALTER\\s+TABLE\\s+(\\w+)\\s+ADD\\s+COLUMN\\s+(\\w+).*");
            Pattern createTable = Pattern.compile("(?is)CREATE\\s+TABLE\\s+(\\w+).*");
            for (String raw : sqlText.split(";")) {
                String sql = raw.strip();
                if (sql.isEmpty()) continue;
                Matcher col = addColumn.matcher(sql), table = createTable.matcher(sql);
                boolean exists = false;
                String label = sql.lines().findFirst().orElse(sql);
                if (col.matches()) {
                    try (ResultSet rs = meta.getColumns(c.getCatalog(), null, col.group(1), col.group(2))) { exists = rs.next(); }
                } else if (table.matches()) {
                    try (ResultSet rs = meta.getTables(c.getCatalog(), null, table.group(1), new String[] { "TABLE" })) { exists = rs.next(); }
                }
                if (exists) {
                    System.out.println("  건너뜀(이미 있음): " + label);
                } else {
                    s.execute(sql);
                    System.out.println("  적용: " + label);
                }
            }
            System.out.println(args[0] + " 마이그레이션 완료 (database=" + c.getCatalog() + ")");
        }
    }
}
