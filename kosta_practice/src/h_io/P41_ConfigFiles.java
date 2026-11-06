package h_io;

/**
 * ============================================================
 * 문제 41. 설정 파일 읽기 세 가지
 * ============================================================
 *
 * [내용]
 *   접속 주소나 이름 같은 설정값을 코드에서 분리해 properties 파일에 두는 방법을
 *   익힙니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) config.properties 에 app.name, app.version,
 *         greeting 같은 키와 값 3~4개를 적습니다(한글은 유니코드 이스케이프 또는
 *         UTF-8 설정 주의).
 *   [ ] 2) ① Properties.load(new FileInputStream(경로)) ②
 *         getClass().getClassLoader().getResourceAsStream("config.properties")
 *         ③ ResourceBundle.getBundle("config") 세 방식으로 같은 값을
 *         읽습니다.
 *   [ ] 3) 없는 키를 요청했을 때 Properties.getProperty 는 null,
 *         ResourceBundle.getString 은
 *         MissingResourceException 인 것을 확인합니다.
 *   [ ] 4) 파일 위치(프로젝트 루트, src, resources 폴더)에 따라 어느 방식이
 *         성공/실패하는지 표로 정리하세요.
 *   [ ] 5) msg.properties / msg_en.properties 를 만들어 Locale 에
 *         따라 메시지가 바뀌는지 확인하세요.
 *
 * [사용할 개념]
 *   Properties, ResourceBundle, 클래스패스, 경로 기준
 */
public class P41_ConfigFiles {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) ResourceBundle 은 확장자를 쓰지 않고 base name 만 줍니다.
 * 2) FileInputStream 경로는 프로젝트 루트 기준이고,
 *    getResourceAsStream 은 클래스패스 기준입니다.
 * 3) Eclipse 에서 src 가 아닌 폴더는 클래스패스에 없을 수 있으니 Build Path 를
 *    확인하세요.
 */
