package e_exception.p25_account;

/**
 * ============================================================
 * 문제 25. 계좌 출금과 예외 분리
 * ============================================================
 *
 * [내용]
 *   서비스는 문제 상황을 예외로 알리고, 화면(View)은 그 예외를 잡아 메시지로 보여주는 역할
 *   분리를 연습합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) AccountService 에 withdraw(int accountNo, int
 *         amount) 를 만듭니다. 계좌가 없으면 AccountNotFoundException,
 *         잔액이 부족하면 BalanceLackException 을 던집니다.
 *   [ ] 2) AccountService 는 계좌 정보를 List<Account> 에 가지고
 *         있습니다(3개 정도 초기 데이터).
 *   [ ] 3) AccountView 에서 사용자에게 계좌번호와 금액을 입력받아 서비스를 호출하고, 예외
 *         종류별로 다른 메시지를 출력합니다.
 *   [ ] 4) 출금 성공 시에는 출금 후 잔액을 반환해서 출력합니다.
 *   [ ] 5) 금액이 0 이하이면 IllegalArgumentException 을 던지는 검증도
 *         추가하세요.
 *
 * [사용할 개념]
 *   throw/throws, 사용자 정의 예외, 서비스/뷰 역할 분리, 컬렉션 검색
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) 서비스에서는 try-catch 로 삼키지 말고 메서드 선언에 throws 를 붙여 알립니다.
 * 2) 예외 클래스는 목적별로 나눠야 catch 에서 구분하기 쉽습니다.
 * 3) 검증에 쓰는 IllegalArgumentException 은 언체크 예외입니다.
 */
