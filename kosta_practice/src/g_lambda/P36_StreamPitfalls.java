package g_lambda;

/**
 * ============================================================
 * 문제 36. 스트림 결과의 함정
 * ============================================================
 *
 * [내용]
 *   스트림 결과를 컬렉션으로 모을 때 만나는 작은 함정들을 직접 실행해서 확인합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) collect(Collectors.toList()) 로 만든 리스트와
 *         Stream.toList() 로 만든 리스트에 각각 add 를 호출해서 차이를 확인합니다.
 *   [ ] 2) 같은 이름의 학생이 둘 있을 때 toMap(name, score) 를 호출하면 어떤 예외가
 *         나는지 확인하고, 세 번째 인수(병합 함수)로 해결하세요.
 *   [ ] 3) 스트림 하나로 forEach 를 두 번 호출하면 어떤 예외가 나는지 확인하세요.
 *   [ ] 4) List.of(...) 에 add/remove 를 하면 어떻게 되는지,
 *         Arrays.asList 와 어떻게 다른지 비교하세요.
 *   [ ] 5) IntStream.range(0,10) 과 rangeClosed(1,10) 의 차이로
 *         1~10 합계를 구하세요.
 *
 * [사용할 개념]
 *   Collectors.toMap, 불변 리스트, 스트림 재사용 불가, IntStream
 */
public class P36_StreamPitfalls {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) IllegalStateException: stream has already been
 *    operated upon or closed 메시지를 확인해 보세요.
 * 2) toMap 의 병합 함수는 (기존값, 새값) -> 결정값 입니다.
 * 3) List.of 는 UnsupportedOperationException 입니다.
 */
