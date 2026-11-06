package p51_board;

/**
 * ============================================================
 * 문제 51. 게시판과 댓글(1:N)
 * ============================================================
 *
 * [내용]
 *   부모 글 하나에 댓글이 여러 개 달리는 1:N 관계를 JDBC 로 다룹니다. 외래키 제약
 *   때문에 생기는 문제를 직접 풀어 봅니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) board(board_no PK auto_increment, subject, writer,
 *         content, board_date), reply(reply_no,
 *         reply_content, board_no FK, reply_regdate) 를 만듭니다.
 *   [ ] 2) 등록/전체조회/번호조회/제목 검색(like)/수정/삭제와 댓글 등록, 부모글의 댓글 목록
 *         조회를 구현합니다.
 *   [ ] 3) 댓글이 있는 글을 삭제하면 외래키 오류가 나는 것을 확인하고, 댓글을 먼저 삭제한 뒤 글을
 *         삭제하는 로직을 하나의 트랜잭션으로 묶습니다.
 *   [ ] 4) BoardDTO 에 List<ReplyDTO> 필드를 두고 부모글 조회 시 댓글을 함께
 *         채웁니다.
 *   [ ] 5) DAO 는 인터페이스+구현체, Service 는 결과가 없으면 사용자 정의 예외를 던지고
 *         Controller 가 잡아 View 로 전달합니다.
 *
 * [사용할 개념]
 *   1:N 관계, 외래키, 트랜잭션, MVC + DAO 계층, like 검색
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) like 검색은 setString(1, "%"+word+"%") 로 값 쪽에 % 를 붙입니다.
 * 2) 두 DELETE 가 같은 Connection 을 쓰도록 메서드 시그니처에 Connection
 *    을 추가합니다.
 * 3) auto_increment 컬럼은 insert 할 때 생략합니다.
 */
