package k_modern.p54_shape;

/**
 * ============================================================
 * 문제 54. 도형 면적 계산기(sealed + switch)
 * ============================================================
 *
 * [내용]
 *   sealed 로 허용된 하위 타입을 제한하고, switch 패턴 매칭으로 모든 경우를
 *   컴파일러가 검사하게 합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) sealed interface Shape permits Circle, Rectangle,
 *         Triangle 를 만들고 세 도형을 record 로
 *         구현합니다(Circle(radius), Rectangle(width,height),
 *         Triangle(base,height)).
 *   [ ] 2) static double area(Shape s) 를 switch (s) { case
 *         Circle c -> ...; case Rectangle r -> ...; case
 *         Triangle t -> ...; } 로 작성합니다. default 가 없어도 컴파일되는지
 *         확인하세요.
 *   [ ] 3) permits 에서 Triangle 을 빼거나 switch 에서 Triangle case
 *         를 지우면 어떤 오류가 나는지 확인하세요.
 *   [ ] 4) sealed class 버전도 만들어 보세요: 하위 클래스를 final, sealed,
 *         non-sealed 로 각각 선언하고 의미를 비교합니다.
 *   [ ] 5) Shape 배열을 만들어 총 면적을 구하고, Circle 이 반지름이 음수면 예외를 던지게
 *         하세요(compact 생성자).
 *
 * [사용할 개념]
 *   sealed, permits, final/sealed/non-sealed, record,
 *   switch 패턴 매칭
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) 허용된 하위 타입은 같은 패키지(또는 모듈)에 있어야 합니다.
 * 2) record 는 암묵적으로 final 이라 sealed 인터페이스의 구현체로 알맞습니다.
 * 3) c.radius() 처럼 getter 형태로 필드에 접근합니다.
 */
