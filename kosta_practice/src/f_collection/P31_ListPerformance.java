package f_collection;

/**
 * ============================================================
 * 문제 31. List 구현체 성능 비교
 * ============================================================
 *
 * [내용]
 *   ArrayList 와 LinkedList 는 둘 다 List 지만 내부 구조가 달라서 잘하는
 *   일이 다릅니다. 시간을 직접 재서 확인합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 리스트의 맨 앞에 문자열 1만 개를 삽입하는 시간을 ArrayList 와
 *         LinkedList 로 System.nanoTime() 으로 재서 출력합니다.
 *   [ ] 2) 리스트 가운데 요소를 인덱스로 10만 번 조회하는 시간도 비교합니다.
 *   [ ] 3) 어느 쪽이 어느 작업에 더 빠른지, 왜 그런지 결과를 근거로 주석으로 정리합니다.
 *   [ ] 4) TreeSet<String> 에 Collections.reverseOrder() 를 주고
 *         중복이 포함된 문자열 배열을 넣어 "중복 제거 + 내림차순 정렬" 결과를 출력하세요.
 *   [ ] 5) Vector 와 ArrayList 의 차이(동기화)를 조사해 한 줄로 적으세요.
 *
 * [사용할 개념]
 *   ArrayList/LinkedList 구조, nanoTime, TreeSet,
 *   Collections.reverseOrder
 */
public class P31_ListPerformance {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) ArrayList 는 배열이라 앞에 삽입하면 뒤 요소를 모두 밀어야 합니다.
 * 2) LinkedList 는 인덱스 조회 시 노드를 따라가야 합니다.
 * 3) 측정은 여러 번 해서 평균을 보는 것이 좋습니다.
 */
