package c_oop;

/**
 * ============================================================
 * 문제 15. 고객 등급 enum
 * ============================================================
 *
 * [내용]
 *   상수 여러 개를 묶고 각 상수가 값과 기능을 가질 수 있는 enum 을 연습합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) enum Grade { BASIC, SILVER, GOLD } 에 할인율(%)과
 *         적립률(%) 필드를 추가합니다(BASIC 0/1, SILVER 5/3, GOLD 10/5
 *         등).
 *   [ ] 2) Grade 에 int discount(int price) 메서드를 넣어 할인된 가격을
 *         반환하게 합니다.
 *   [ ] 3) switch(grade) 로 등급별 환영 문구를 출력합니다.
 *   [ ] 4) Grade.valueOf("VIP") 를 호출했을 때 발생하는 예외를 확인하고,
 *         values() 로 모든 등급을 순회해 가격 100,000원일 때 할인가를 표로
 *         출력합니다.
 *
 * [사용할 개념]
 *   enum 필드/생성자/메서드, switch, valueOf, values, 상수의 타입 안전성
 */
public class P15_GradeEnum {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 4) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) enum 의 생성자는 자동으로 private 이고 외부에서 new 할 수 없습니다.
 * 2) valueOf 에 없는 이름을 주면 IllegalArgumentException 입니다.
 * 3) static final int 상수와 비교해서 enum 이 잘못된 값을 막아 주는 점을 정리해
 *    보세요.
 */
