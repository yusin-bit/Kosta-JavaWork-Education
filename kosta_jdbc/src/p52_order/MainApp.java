package p52_order;

/**
 * ============================================================
 * 문제 52. 주문과 재고 감소
 * ============================================================
 *
 * [내용]
 *   주문서 + 주문 상세 + 재고 감소를 하나의 트랜잭션으로 처리하는 실전 시나리오입니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) goods(goods_id, name, price, stock),
 *         orders(order_id auto_increment, user_id,
 *         order_date, total_amount), order_line(order_id,
 *         goods_id, qty, amount) 테이블을 만듭니다.
 *   [ ] 2) 주문 한 건: ① 총 금액 계산(재고 부족이면 예외) ② orders insert ③ 방금
 *         만든 order_id 를 getGeneratedKeys() 로 받음 ④ order_line
 *         여러 건을 Batch 로 insert ⑤ 각 상품 재고 감소 ⑥ commit
 *   [ ] 3) 어느 단계에서든 실패하면 모든 변경이 취소되어야 합니다. 재고 부족·존재하지 않는 상품
 *         번호 시나리오로 확인하세요.
 *   [ ] 4) finally 에서 commit 을 호출하면 실패한 경우에도 일부가 저장되는 문제가 생길
 *         수 있는 이유를 설명하고, 올바른 구조(try 안 commit, catch 에서
 *         rollback, finally 에서 close)로 작성하세요.
 *   [ ] 5) 로그인한 사용자의 장바구니(Map<Goods,Integer>)를 세션 객체에 보관해 주문
 *         시 사용하세요.
 *
 * [사용할 개념]
 *   트랜잭션, getGeneratedKeys, Batch, 세션, 재고 관리
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) prepareStatement(sql,
 *    Statement.RETURN_GENERATED_KEYS) 로 생성 키를 받을 수 있습니다.
 * 2) 재고 감소 update 는 where 에서 stock >= ? 조건을 주면 한 번 더
 *    안전합니다.
 * 3) 여러 DAO 메서드가 같은 Connection 을 공유해야 합니다.
 */
