package report;

/**
 * ============================================================
 * 문제 60. 대여 통계 리포트(Stream)
 * ============================================================
 *
 * [내용]
 *   저장된 대여 데이터를 읽어 Stream 으로 통계를 만드는 리포트 화면입니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 대여 목록을 List<Rental> 로 읽어 옵니다(파일 또는 DB).
 *   [ ] 2) 연체 중인 회원 이름 목록(중복 제거, 가나다순)
 *   [ ] 3) 카테고리별 대여 건수(Map)와 가장 많이 빌린 도서 Top 3
 *   [ ] 4) 회원별 총 대여 횟수와 평균 대여 기간
 *   [ ] 5) 상태별 건수를 enum 이름으로 출력
 *   [ ] 6) 각 통계 메서드를 Service 에 두고 View 에서 보기 좋게 출력하세요. 같은 코드를
 *         for 문 버전과 Stream 버전으로 각각 만들어 길이와 가독성을 비교하는 한 줄 소감도
 *         적으세요.
 *
 * [사용할 개념]
 *   Stream, groupingBy, sorted, limit, Optional,
 *   Comparator
 */
// 이 파일은 문제 60 설명용입니다. 실제 구현은 RentalReport 클래스에 하세요.
final class P60_Guide {
    private P60_Guide() {}
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) Top N 은 sorted(...).limit(N) 입니다.
 * 2) Map 을 값 기준으로 정렬하려면
 *    entrySet().stream().sorted(Map.Entry.comparingByValue(...))
 *    를 사용합니다.
 * 3) 날짜 계산은 java.time.LocalDate 와 ChronoUnit.DAYS.between
 *    이 편합니다.
 */
