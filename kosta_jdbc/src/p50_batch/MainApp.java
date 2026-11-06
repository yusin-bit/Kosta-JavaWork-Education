package p50_batch;

/**
 * ============================================================
 * 문제 50. 대량 등록 속도 비교(Batch)
 * ============================================================
 *
 * [내용]
 *   SQL 을 하나씩 보내는 것과 모아서 보내는 것의 차이를 시간으로 확인합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 테이블에 학생 1000건을 넣는 시간을 ① 반복문에서 executeUpdate ②
 *         addBatch 후 한 번에 executeBatch ③ 500건마다 executeBatch
 *         + clearBatch 세 방식으로 비교합니다.
 *   [ ] 2) 각 방식 전에 테이블을 비우고(연습용 테이블에서만 delete) autoCommit 을
 *         끄고 마지막에 commit 합니다.
 *   [ ] 3) executeBatch 의 반환 배열을 검사해 실패한 건이 있으면 rollback 합니다.
 *   [ ] 4) 건수를 1만 건으로 늘리면 차이가 어떻게 달라지는지 확인합니다.
 *   [ ] 5) BatchUpdateException 이 어떤 상황에서 발생하는지 일부러 중복 PK 를
 *         넣어서 확인하세요.
 *
 * [사용할 개념]
 *   PreparedStatement.addBatch/executeBatch, 트랜잭션과 Batch
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) addBatch() 후에 clearParameters() 로 파라미터를 지우는 패턴이
 *    있습니다.
 * 2) 메모리를 아끼려고 500~1000건 단위로 나눠서 실행합니다.
 * 3) 시간은 nanoTime 으로 재고 ms 로 변환하세요.
 */
