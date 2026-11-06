package d_inherit.p20_board;

/**
 * ============================================================
 * 문제 20. 게시판 인터페이스 3종
 * ============================================================
 *
 * [내용]
 *   인터페이스는 규격서 역할을 합니다. 같은 규격을 서로 다르게 구현하는 클래스 3개를 만들고
 *   인터페이스 변수 하나로 바꿔 끼우는 연습을 합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) BoardService 인터페이스: insert(Board), update(Board),
 *         selectByNo(int)
 *   [ ] 2) FreeBoardService, QaBoardService,
 *         UploadBoardService 가 각각 구현하고 호출 시 자기 이름을 출력합니다.
 *   [ ] 3) 인터페이스에 default int delete(int no) 와 static void
 *         selectAll() 을 추가합니다. default 는 구현 객체로 호출, static 은
 *         BoardService.selectAll() 로 호출해 보세요.
 *   [ ] 4) 인터페이스 안에 private 메서드를 두어 default 메서드가 공통 로직을 쓰게 해
 *         보세요.
 *   [ ] 5) main 에서 BoardService 타입 변수 하나로 세 구현체를 차례로 교체하며 같은
 *         호출을 하세요.
 *
 * [사용할 개념]
 *   인터페이스, implements, default/static/private 메서드, 다형성
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) default 메서드는 구현체가 선택적으로 재정의할 수 있습니다.
 * 2) static 메서드는 구현 객체 없이 인터페이스 이름으로 호출합니다.
 * 3) 인터페이스는 new 할 수 없지만 구현체를 담는 변수 타입으로는 쓸 수 있습니다.
 */
