package k_modern.p55_reflect;

/**
 * ============================================================
 * 문제 55. 리플렉션으로 만드는 미니 DI
 * ============================================================
 *
 * [내용]
 *   클래스 이름 문자열만으로 객체를 만들고 메서드를 호출하는 리플렉션을 사용해, 코드를 고치지
 *   않고 구현체를 바꾸는 구조를 만듭니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) Greeter 인터페이스(String greet(String name)) 와 구현체
 *         2개(KoreanGreeter, EnglishGreeter)를 서로 다른 클래스로
 *         만듭니다.
 *   [ ] 2) app.properties 에 greeter=패키지.KoreanGreeter 를 적고,
 *         프로그램이 이 이름을 읽어
 *         Class.forName(...).getDeclaredConstructor().newInstance()
 *         로 객체를 만들어 Greeter 타입 변수에 담아 호출합니다.
 *   [ ] 3) properties 만 EnglishGreeter 로 바꿔서 재실행하면 코드 수정 없이
 *         결과가 바뀌는 것을 확인합니다.
 *   [ ] 4) getMethod("greet", String.class).invoke(obj, "철수")
 *         로 메서드를 이름으로 호출해 보세요.
 *   [ ] 5) private 필드가 있는 클래스를 만들고 getDeclaredField +
 *         setAccessible(true) 로 읽고 값을 바꿔 보세요. 캡슐화가 깨지는 점을
 *         주석으로 정리합니다.
 *   [ ] 6) 리플렉션이 느리고 컴파일 시 검사가 안 되는 단점을 실행 시간 비교로 확인해 보세요.
 *
 * [사용할 개념]
 *   Reflection(Class, Constructor, Method, Field), 인터페이스
 *   기반 설계, 설정 파일 분리
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 6) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) 패키지가 있으면 전체 이름(예: com.exam.KoreanGreeter)을 써야 합니다.
 * 2) getMethod 는 public 만, getDeclaredMethod 는 접근 제한자와
 *    상관없이 찾습니다.
 * 3) Spring 이 객체를 만들고 연결하는 원리가 이것과 같습니다.
 */
