package c_oop;

/**
 * ============================================================
 * 문제 16. 상태 코드 enum 과 fromCode
 * ============================================================
 *
 * [내용]
 *   데이터베이스에는 숫자 코드로 저장되어 있는 상태를 enum 으로 바꿔 쓰는 패턴을 연습합니다.
 *   미니프로젝트의 RentalStatus 와 같은 구조입니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) RentalStatus enum: REQUESTED(100,"신청 중"),
 *         APPROVED(101,"승인"), REJECTED(102,"거절"),
 *         RENTED(110,"대여 중"), COMPLETED(211,"반납 완료")
 *   [ ] 2) code, name 필드와 getter 를 만듭니다.
 *   [ ] 3) public static RentalStatus fromCode(int code) 를
 *         작성합니다. 없는 코드는 IllegalArgumentException 을 던집니다.
 *   [ ] 4) main 에서 110, 211, 999 를 변환해 보고 999 는 예외 메시지를
 *         출력합니다.
 *
 * [사용할 개념]
 *   enum, static 메서드, values() 순회, 예외 던지기
 */
public class P16_RentalStatusEnum {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 4) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) values() 로 모든 상수를 돌면서 code 가 같은 것을 찾습니다.
 * 2) 찾지 못하면 반복문이 끝난 뒤에 throw 합니다.
 * 3) int 와 String 필드를 모두 가지는 enum 생성자를 만드는 것에 익숙해지세요.
 */
