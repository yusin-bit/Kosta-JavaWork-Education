package app;

/**
 * ============================================================
 * 문제 58. 도서 대여 프로그램(파일 저장 버전)
 * ============================================================
 *
 * [내용]
 *   여러 클래스를 계층별로 나누고, 데이터를 파일로 영속화하는 콘솔 프로그램입니다. 미니프로젝트의
 *   축소판입니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 패키지 구성: dto(Book, Member, Rental),
 *         service(인터페이스+Impl), controller, view, exception
 *   [ ] 2) 도서/회원 DTO 는 record 로, 대여 상태는 enum(REQUESTED,
 *         RENTED, RETURNED)으로 만듭니다.
 *   [ ] 3) 기능: 회원 가입·로그인(Session 싱글톤), 도서 등록, 도서 목록(카테고리별
 *         정렬), 대여, 반납, 내 대여 내역
 *   [ ] 4) 오류 상황은 사용자 정의 예외로 표현합니다: 중복 가입, 이미 대여 중인 도서, 없는 도서
 *         번호, 로그인 필요 등
 *   [ ] 5) 프로그램 종료 시 모든 데이터를 직렬화로 저장하고, 시작 시 불러옵니다. 파일은 프로젝트
 *         루트의 data 폴더에 둡니다.
 *   [ ] 6) 초기 데이터는 properties 에서 읽어 최초 실행 때만 채웁니다.
 *
 * [사용할 개념]
 *   MVC, 싱글톤, enum, record, 예외, 직렬화, ResourceBundle
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 문제 58 (파일 저장 버전). 문제 59 는 repository/db/P59_Guide.java, 문제 60 은 report/P60_Guide.java 를 보세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) View → Controller → Service 순서로 호출하고, 예외는 Service 가
 *    던지고 Controller 가 잡아 View 에 전달합니다.
 * 2) 서비스는 싱글톤으로 만들면 데이터 컬렉션이 공유됩니다.
 * 3) Session 에는 로그인한 회원의 id 만 저장하세요.
 */
