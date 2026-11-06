package g_lambda.p34_stream;

/**
 * ============================================================
 * 문제 34. 학생 통계(Stream 기본기)
 * ============================================================
 *
 * [내용]
 *   for 문과 if 문으로 하던 일을 Stream 으로 바꿔 쓰는 연습입니다. 중간 연산과 최종
 *   연산이 나뉜다는 점에 주목하세요.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) Student(name, age, score, major) 리스트를 6명 이상 만듭니다.
 *   [ ] 2) ① 80점 이상인 학생의 이름을 점수 오름차순 List 로 ② 전체 평균 점수 ③ 나이가
 *         가장 많은 학생(Optional) ④ 모든 학생 이름을 쉼표로 연결한 문자열 ⑤ 전공이
 *         "컴퓨터" 인 학생이 있는지 여부 ⑥ 모두 60점 이상인지 여부를 구합니다.
 *   [ ] 3) 각각을 먼저 for 문으로 구현하고, 그다음 Stream 으로 구현해 결과가 같은지
 *         비교합니다.
 *   [ ] 4) filter, map, sorted 에는 아무것도 출력되지 않다가 최종 연산을 만나야
 *         실행되는 것을 peek 로 로그를 찍어 확인하세요.
 *   [ ] 5) parallelStream 으로 바꾸면 스레드 이름이 어떻게 바뀌는지 확인하세요.
 *
 * [사용할 개념]
 *   Stream 중간/최종 연산, filter, map, sorted, average, max,
 *   joining, anyMatch/allMatch, Optional
 */
public class MainApp {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
        // 필요한 클래스는 같은 패키지의 다른 파일에 있습니다.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) mapToDouble(Student::getScore).average() 는
 *    OptionalDouble 이라 orElse(0.0) 로 꺼냅니다.
 * 2) Comparator.comparingInt(Student::getAge) 로 max 를 구할
 *    수 있습니다.
 * 3) 스트림은 한 번 소비하면 다시 쓸 수 없습니다.
 */
