package h_io.p40_serial;

/**
 * ============================================================
 * 문제 40. 직렬화 주소록
 * ============================================================
 *
 * [내용]
 *   객체를 통째로 파일에 저장하려면 직렬화가 필요합니다. 저장과 복원 과정에서 일어나는 일을
 *   실험합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) Member(id, age, addr) 가 Serializable 을 구현하게 하고,
 *         List<Member> 를 ObjectOutputStream 으로 저장하고
 *         ObjectInputStream 으로 복원합니다.
 *   [ ] 2) Serializable 을 빼고 저장을 시도해서
 *         NotSerializableException 을 확인합니다.
 *   [ ] 3) addr 필드를 transient 로 바꾸고 저장→복원했을 때 addr 값이 어떻게 되는지
 *         확인합니다.
 *   [ ] 4) 저장 후 Member 에 필드를 추가하고 serialVersionUID 를 바꾼 상태로
 *         복원해서 InvalidClassException 을 확인합니다. UID 를 명시하지 않았을
 *         때와 명시했을 때를 비교하세요.
 *   [ ] 5) 프로그램 시작 시 저장 파일이 있으면 읽어 오고, 종료 시 저장하는 주소록
 *         메뉴(등록/조회/삭제)를 만들어 보세요.
 *
 * [사용할 개념]
 *   Serializable, ObjectOutputStream/InputStream,
 *   transient, serialVersionUID
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) List 자체를 한 번에 writeObject 할 수 있습니다(ArrayList 는
 *    Serializable).
 * 2) 복원은 readObject() 로 읽고 (List<Member>) 로 캐스팅합니다.
 * 3) static 필드는 직렬화되지 않습니다.
 */
