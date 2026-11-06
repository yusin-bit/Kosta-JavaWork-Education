package k_modern;

/**
 * ============================================================
 * 문제 53. record 로 DTO 만들기
 * ============================================================
 *
 * [내용]
 *   데이터를 담는 클래스에 반복되는 코드를 record 가 어떻게 줄여 주는지 비교합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 기존 방식 Person(name, age) 클래스를
 *         필드·생성자·getter·equals·hashCode·toString 까지 직접
 *         작성합니다.
 *   [ ] 2) 같은 내용을 record Person(String name, int age) 한 줄로
 *         바꾸고 두 방식의 코드량과 동작을 비교합니다.
 *   [ ] 3) record 에서 getter 이름(name())을 확인하고, 필드를 바꾸는 setter
 *         가 없는 이유(불변)를 설명합니다.
 *   [ ] 4) compact 생성자로 age 가 음수이면 IllegalArgumentException 을
 *         던지세요.
 *   [ ] 5) 두 record 를 equals 로 비교하고, HashSet 에 넣었을 때 중복이
 *         제거되는지 확인하세요.
 *   [ ] 6) 수업에서 만든 Emp 또는 Student 중 하나를 record 로 바꿨을 때 깨지는
 *         코드(setter, 상속)를 찾아 정리하세요.
 *
 * [사용할 개념]
 *   record, 불변 객체, compact 생성자, equals/hashCode 자동 생성
 */
public class P53_Record {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 6) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) record 는 클래스를 상속할 수 없고(java.lang.Record 를 이미 상속)
 *    인터페이스는 구현할 수 있습니다.
 * 2) 필드는 private final 이고 생성자는 public 으로 자동 생성됩니다.
 * 3) compact 생성자는 괄호 없이 { } 만 씁니다.
 */
