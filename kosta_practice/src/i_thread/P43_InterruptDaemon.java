package i_thread;

/**
 * ============================================================
 * 문제 43. 쓰레드 멈추기와 데몬
 * ============================================================
 *
 * [내용]
 *   돌고 있는 쓰레드를 안전하게 멈추는 방법과 메인이 끝나면 함께 끝나는 데몬 쓰레드를
 *   실험합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 0.01초마다 "곧 집에 간다"를 출력하는 쓰레드를 3초 뒤 main 에서
 *         interrupt() 로 멈춥니다. sleep 안에서 InterruptedException
 *         을 받는 방식으로 구현하세요.
 *   [ ] 2) sleep 없이 계속 도는 쓰레드는 interrupt() 만으로는 멈추지 않는 것을
 *         확인하고, Thread.interrupted() 를 검사하는 방식으로 바꿉니다.
 *   [ ] 3) 같은 작업을 setDaemon(true) 로 바꾸고 main 이 3초 후 끝나면 쓰레드도
 *         같이 끝나는 것을 확인합니다. setDaemon 은 start 전에 호출해야 합니다.
 *   [ ] 4) GUI(JFrame)에서 시계를 표시하는 쓰레드를 만들어 보세요(선택).
 *   [ ] 5) 인터럽트가 발생했을 때 interrupt 플래그가 초기화되는 시점을 조사해 주석으로
 *         정리하세요.
 *
 * [사용할 개념]
 *   interrupt, InterruptedException, Thread.interrupted,
 *   데몬 쓰레드
 */
public class P43_InterruptDaemon {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) sleep/wait 중에 interrupt 되면 예외가 발생하고 플래그가 초기화됩니다.
 * 2) 데몬 쓰레드는 일반 쓰레드가 모두 끝나면 JVM 이 강제로 끝냅니다.
 * 3) 무한 루프 조건에 !Thread.currentThread().isInterrupted() 를
 *    넣는 방식도 가능합니다.
 */
