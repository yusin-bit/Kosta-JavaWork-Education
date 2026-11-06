package a_basic;

/**
 * ============================================================
 * 문제 6. 배열 예외 두 가지 일부러 내기
 * ============================================================
 *
 * [내용]
 *   배열에서 자주 만나는 런타임 예외 두 가지를 의도적으로 발생시키고 try-catch 로
 *   처리하는 프로그램입니다. 에러 메시지를 읽는 연습이기도 합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) int[] 배열(길이 3)에 arr[3] 을 대입해서
 *         ArrayIndexOutOfBoundsException 을 발생시키고,
 *         e.getMessage() 를 출력하세요.
 *   [ ] 2) Student[] 배열을 new Student[3] 만 하고, 첫 칸의 getName()
 *         을 호출해서 NullPointerException 을 발생시키세요.
 *   [ ] 3) 두 예외를 하나의 catch 에서 | 로 묶어 처리하는 버전도 만드세요.
 *   [ ] 4) 두 번째 예외가 왜 발생했는지, 배열에 들어 있는 값이 무엇이었는지 주석으로 설명하세요.
 *
 * [사용할 개념]
 *   배열 기본값, ArrayIndexOutOfBoundsException,
 *   NullPointerException, multi-catch
 */
public class P06_ArrayExceptions {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 4) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) 객체 배열을 만들면 각 칸에는 객체가 아니라 null 이 들어 있습니다.
 * 2) 각 칸에 new Student() 를 해줘야 객체가 생깁니다.
 * 3) multi-catch 의 두 예외는 서로 상속 관계이면 안 됩니다.
 */
