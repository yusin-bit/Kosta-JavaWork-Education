package g_lambda.p35_grouping;

/**
 * ============================================================
 * 문제 35. 전공별로 묶기(groupingBy)
 * ============================================================
 *
 * [내용]
 *   데이터를 어떤 기준으로 묶어서 통계를 낼 때 Collectors.groupingBy 를
 *   사용합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 문제 34 의 학생 리스트를 재사용합니다.
 *   [ ] 2) 전공별 학생 목록(Map<String,List<Student>>)을 출력합니다.
 *   [ ] 3) 전공별 학생 수(counting), 전공별 평균 점수(averagingDouble),
 *         전공별 최고 점수 학생(maxBy)을 각각 구합니다.
 *   [ ] 4) 성별(또는 합격 여부) 두 그룹으로 나누는 partitioningBy 도 사용해 보세요.
 *   [ ] 5) 결과 Map 을 forEach((k,v) -> ...) 로 보기 좋게 출력하세요.
 *
 * [사용할 개념]
 *   Collectors.groupingBy, counting, averagingDouble,
 *   maxBy, partitioningBy
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) groupingBy(분류 함수, 하위 Collector) 형태입니다.
 * 2) maxBy 의 결과는 Optional 입니다.
 * 3) Map.forEach 는 BiConsumer 를 받습니다.
 */
