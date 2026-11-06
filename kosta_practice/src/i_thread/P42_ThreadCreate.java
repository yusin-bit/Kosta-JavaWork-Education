package i_thread;

/**
 * ============================================================
 * 문제 42. 쓰레드 세 가지 생성 방법
 * ============================================================
 *
 * [내용]
 *   쓰레드를 만드는 세 방식(상속, Runnable, 람다)을 모두 써 보고 start() 와
 *   run() 의 차이를 눈으로 확인합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 1부터 5까지 1초 간격으로 출력하는 작업을 Thread 상속, Runnable 구현,
 *         람다 세 가지로 구현합니다. 출력할 때
 *         Thread.currentThread().getName() 도 함께 출력하세요.
 *   [ ] 2) start() 대신 run() 을 직접 호출한 경우 쓰레드 이름이 어떻게 나오는지 확인하고
 *         이유를 설명하세요.
 *   [ ] 3) 쓰레드가 1~100 합계를 계산해 필드에 저장하게 하고, main 에서 join() 으로
 *         기다린 뒤 결과를 출력합니다. join() 을 빼면 결과가 어떻게 되는지도 확인하세요.
 *   [ ] 4) setPriority 로 우선순위를 바꿔도 실행 순서가 보장되지 않는 것을 여러 번
 *         실행해서 확인합니다.
 *   [ ] 5) getState() 로 NEW, RUNNABLE, TIMED_WAITING,
 *         TERMINATED 상태를 각 시점에 출력하세요.
 *
 * [사용할 개념]
 *   Thread, Runnable, start/run, join, sleep, 쓰레드 상태
 */
public class P42_ThreadCreate {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) start() 는 새 쓰레드를 만들어 run() 을 실행시키고, run() 직접 호출은 현재
 *    쓰레드가 일반 메서드처럼 실행합니다.
 * 2) sleep 은 InterruptedException 을 처리해야 합니다.
 * 3) Runnable 이 상속 문제 때문에 더 권장됩니다.
 */
