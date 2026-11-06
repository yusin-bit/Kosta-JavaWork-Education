package f_collection.p27_wildcard;

/**
 * ============================================================
 * 문제 27. 와일드카드 세 가지
 * ============================================================
 *
 * [내용]
 *   제네릭 타입 인수의 범위를 유연하게 지정하는 와일드카드 ?, ? extends, ? super
 *   를 각각 써 보고 언제 컴파일되는지 표로 정리합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) Person ← Worker ← Student ← HighStudent /
 *         MiddleStudent 상속 구조를 만듭니다.
 *   [ ] 2) Applicant<T> 클래스(필드 kind)를 만듭니다.
 *   [ ] 3) Course 클래스에 register01(Applicant<?>) 모두 허용,
 *         register02(Applicant<? super Worker>) Worker 이상만,
 *         register03(Applicant<? extends Student>) Student
 *         이하만 허용하는 메서드를 만듭니다.
 *   [ ] 4) 각 메서드에 Applicant<Person>, <Worker>, <Student>,
 *         <HighStudent> 를 넘겨 보고, 컴파일되는 경우와 안 되는 경우를 표로
 *         정리합니다(주석).
 *   [ ] 5) List<? extends Number> 에는 왜 add 를 할 수 없는지 이유를
 *         설명하세요.
 *
 * [사용할 개념]
 *   와일드카드(?, extends, super), 상속 계층과 제네릭
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) extends 는 상한(그 타입과 자식들), super 는 하한(그 타입과 부모들)입니다.
 * 2) 읽기 전용으로 쓰면 extends, 넣기 위해 쓰면 super 가 어울립니다.
 * 3) 컴파일 안 되는 줄은 주석으로 막아 두고 이유를 적으세요.
 */
