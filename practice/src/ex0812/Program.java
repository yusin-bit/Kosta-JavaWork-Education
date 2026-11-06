package ex0812;

import java.util.Scanner;

/** 국어, 수학, 영어 성적을 관리하는 콘솔 프로그램입니다. */
public class Program {
    private static final int PASSING_SCORE = 80;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeRecord record = new GradeRecord();

        System.out.println("========================================");
        System.out.println("          성적 관리 프로그램");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1. 성적 입력  2. 성적표 출력  3. 합격 여부  4. 초기화  0. 종료");
            System.out.print("실행할 메뉴 번호: ");

            switch (readInteger(scanner)) {
                case 1:
                    record = new GradeRecord(
                            readScore(scanner, "국어"),
                            readScore(scanner, "수학"),
                            readScore(scanner, "영어"));
                    System.out.println("성적이 저장되었습니다.");
                    break;
                case 2:
                    printReport(record);
                    break;
                case 3:
                    printPassResult(record);
                    break;
                case 4:
                    record = new GradeRecord();
                    System.out.println("저장된 성적을 초기화했습니다.");
                    break;
                case 0:
                    running = false;
                    System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다.");
                    break;
                default:
                    System.out.println("메뉴에 있는 번호를 입력해 주세요.");
            }
        }
        scanner.close();
    }

    private static int readInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("숫자로 입력해 주세요: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int readScore(Scanner scanner, String subject) {
        while (true) {
            System.out.print(subject + " 성적(0~100): ");
            int score = readInteger(scanner);
            if (score >= 0 && score <= 100) {
                return score;
            }
            System.out.println("점수는 0점에서 100점 사이여야 합니다.");
        }
    }

    private static void printReport(GradeRecord record) {
        if (!record.isEntered()) {
            System.out.println("먼저 1번 메뉴에서 성적을 입력해 주세요.");
            return;
        }
        System.out.println("\n[ 성적표 ]");
        System.out.printf("국어: %d점%n수학: %d점%n영어: %d점%n", record.korean, record.math, record.english);
        System.out.printf("총점: %d점%n평균: %.2f점%n", record.getTotal(), record.getAverage());
    }

    private static void printPassResult(GradeRecord record) {
        if (!record.isEntered()) {
            System.out.println("먼저 1번 메뉴에서 성적을 입력해 주세요.");
            return;
        }
        String result = record.getAverage() >= PASSING_SCORE ? "합격" : "불합격";
        System.out.printf("%s입니다. 평균 %.2f점 (합격 기준: %d점)%n", result, record.getAverage(), PASSING_SCORE);
    }

    private static class GradeRecord {
        private final int korean;
        private final int math;
        private final int english;
        private final boolean entered;

        GradeRecord() {
            this(0, 0, 0, false);
        }

        GradeRecord(int korean, int math, int english) {
            this(korean, math, english, true);
        }

        private GradeRecord(int korean, int math, int english, boolean entered) {
            this.korean = korean;
            this.math = math;
            this.english = english;
            this.entered = entered;
        }

        boolean isEntered() { return entered; }
        int getTotal() { return korean + math + english; }
        double getAverage() { return getTotal() / 3.0; }
    }
}
