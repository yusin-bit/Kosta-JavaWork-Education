package g_lambda.p33_methodref;

/**
 * ============================================================
 * 문제 33. 메서드 참조 4종 비교
 * ============================================================
 *
 * [내용]
 *   메서드 참조는 람다식을 더 짧게 쓴 문법입니다. 네 가지 형태를 같은 기능의 람다와 나란히
 *   놓고 비교합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) static 메서드 참조: Function<Integer,Integer> f =
 *         Utils::square;
 *   [ ] 2) 특정 객체의 인스턴스 메서드 참조: Function<String,Integer> g =
 *         utils::getLength;
 *   [ ] 3) 임의 객체의 인스턴스 메서드 참조:
 *         BiFunction<String,String,Boolean> h =
 *         String::equals;
 *   [ ] 4) 생성자 참조: Supplier<Person> s = Person::new;
 *         Function<String,User> u = User::new;
 *   [ ] 5) 각각을 람다식으로 바꾼 코드와 익명 클래스 코드까지 세 줄씩 나란히 써서 비교하세요.
 *   [ ] 6) list.stream().sorted(Comparator::reverseOrder) 가
 *         컴파일 오류인 이유를 설명하세요(Comparator.reverseOrder() 와의
 *         차이).
 *
 * [사용할 개념]
 *   메서드 참조, 생성자 참조, Supplier/Function/BiFunction
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 6) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) 메서드 참조는 "함수형 인터페이스가 필요한 자리"에서만 쓸 수 있습니다.
 * 2) String::equals 는 (a,b) -> a.equals(b) 입니다.
 * 3) Comparator::reverseOrder 는 인수를 받지 않고 Comparator 를
 *    만들어 주는 함수가 됩니다.
 */
