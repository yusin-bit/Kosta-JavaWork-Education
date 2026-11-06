package f_collection;

/**
 * ============================================================
 * 문제 30. 단어 빈도 세기(Map)
 * ============================================================
 *
 * [내용]
 *   Map 은 key 를 중복 없이 value 와 짝지어 저장합니다. 문장 속 단어의 등장 횟수를
 *   세어 보면서 Map 의 기본 사용법을 익힙니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 한 줄의 문장을 입력받아 공백으로 나눈 뒤 단어별 등장 횟수를
 *         HashMap<String,Integer> 에 저장합니다.
 *   [ ] 2) keySet, entrySet 두 가지 방식으로 모든 항목을 출력합니다.
 *   [ ] 3) 등장 횟수가 많은 순서대로 정렬해서 출력합니다(entrySet 을 List 로 옮겨
 *         Comparator 로 정렬).
 *   [ ] 4) HashMap 대신 TreeMap 으로 바꾸면 출력 순서가 어떻게 바뀌는지 확인합니다.
 *   [ ] 5) 같은 key 로 put 을 두 번 하면 어떻게 되는지, 없는 key 를 get 하면 무엇이
 *         반환되는지 확인하세요.
 *
 * [사용할 개념]
 *   Map, HashMap/TreeMap, entrySet, getOrDefault, 정렬
 */
public class P30_WordCount {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) map.put(word, map.getOrDefault(word, 0) + 1) 한 줄로
 *    카운트할 수 있습니다.
 * 2) Map.Entry 는 getKey(), getValue() 를 제공합니다.
 * 3) Map 자체는 정렬할 수 없으므로 List 로 옮깁니다.
 */
