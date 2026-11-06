package f_collection.p29_hashset;

/**
 * ============================================================
 * 문제 29. 중복 회원 막기(HashSet)
 * ============================================================
 *
 * [내용]
 *   HashSet 은 "같은 객체"를 중복으로 보고 저장하지 않습니다. 그런데 객체의 "같다"를
 *   누가 정할까요? equals 와 hashCode 의 관계를 실험으로 확인합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) Member(name, age, addr) 를 만들고 equals/hashCode 를
 *         오버라이딩하지 않은 채 같은 이름·나이의 Member 두 개를 HashSet 에 넣고
 *         size() 를 출력합니다.
 *   [ ] 2) name 과 age 가 같으면 같은 회원이라고 보도록 equals 와 hashCode 를
 *         오버라이딩한 뒤 다시 size() 를 출력합니다.
 *   [ ] 3) hashCode 만 오버라이딩하고 equals 는 안 했을 때, 반대의 경우도 각각
 *         실험합니다.
 *   [ ] 4) hashCode()/equals() 안에 System.out.println 을 넣고 add
 *         할 때 어떤 순서로 호출되는지 관찰하세요.
 *   [ ] 5) String 의 hashCode 가 같지만 문자열이 다른 예("Z@S.ME",
 *         "Z@RN.E" 처럼 노션/수업 코드에 있는 예)를 찾아 equals 의 필요성을
 *         설명하세요.
 *
 * [사용할 개념]
 *   HashSet, equals/hashCode 규약, 객체 동등성
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) HashSet 은 hashCode 로 후보를 좁히고 equals 로 최종 확인합니다.
 * 2) 두 객체가 equals 이면 hashCode 도 같아야 합니다.
 * 3) IDE 의 "Generate hashCode() and equals()" 기능으로 만든 코드를
 *    읽어 보세요.
 */
