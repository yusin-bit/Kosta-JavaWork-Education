package p47_student_dao;

/**
 * ============================================================
 * 문제 47. 학생 CRUD DAO
 * ============================================================
 *
 * [내용]
 *   JDBC 의 6단계(드라이버 로드 → 연결 → 실행 객체 → 실행 → 결과 처리 → 닫기)를
 *   DAO 한 개로 완성합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) student(id, name, age, addr) 테이블을 만들고 StudentDAO 에
 *         insert, selectAll, selectByName, update, delete 를
 *         구현합니다.
 *   [ ] 2) 처음에는 Statement 와 문자열 연결로 구현하고, 모두
 *         PreparedStatement 로 바꿉니다.
 *   [ ] 3) DBManager 클래스를 만들어 로드(static 블록), getConnection,
 *         close(Connection, Statement, ResultSet) 를 모아 둡니다.
 *   [ ] 4) 접속 정보는 properties 파일에서 ResourceBundle 로 읽습니다.
 *   [ ] 5) 닫는 순서는 ResultSet → Statement → Connection 이어야 합니다.
 *         닫지 않고 반복 호출하면 어떤 문제가 생길지 설명하세요.
 *   [ ] 6) executeUpdate 의 반환값(영향받은 행 수)으로 "수정/삭제 대상이 없는 경우"를
 *         구분해서 사용자에게 알려 주세요.
 *
 * [사용할 개념]
 *   JDBC 흐름, PreparedStatement, ResultSet,
 *   executeQuery/executeUpdate, DAO
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 6) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) ? 는 1 번부터 setXxx(1, 값) 으로 채웁니다.
 * 2) SELECT 는 executeQuery, INSERT/UPDATE/DELETE 는
 *    executeUpdate 입니다.
 * 3) rs.next() 는 다음 행으로 이동하고 있으면 true 입니다.
 */
