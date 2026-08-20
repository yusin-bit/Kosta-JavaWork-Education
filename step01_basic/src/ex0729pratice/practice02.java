package ex0729pratice;
import java.util.Scanner;
public class practice02 {
	protected int score(int kor, int eng, int math) {
		return kor+eng+math;
		}
	protected double avg(int score, int subject) {
		return (double)score/subject;
	}
		protected char grade(double avg) {
			switch((int)avg/10) {
			case 10, 9 :
				return 'A';
			case 8 : 
				return 'B';
			case 7 : 
				return 'C';
			case 6 : 
				return 'D';
			default : 
				return 'F';				
			}
	}
		public void printScore(String name, int kor, int eng, int math) {
			int score = score(kor, eng, math);
			double avg = avg(score,3);
			char grade = grade(avg);
			
			  System.out.println("=======================");
		        System.out.println("이름 : " + name);
		        System.out.println("국어 : " + kor);
		        System.out.println("영어 : " + eng);
		        System.out.println("수학 : " + math);
		        System.out.println("총점 : " + score);
		        System.out.printf("평균 : %.2f\n", avg);
		        System.out.println("등급 : " + grade);
		        System.out.println("=======================");
			
					
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 practice02 program = new practice02();
		while(true) {
		System.out.println("===========성적 프로그램===========");
		System.out.println("1. 성적 구하기     2. 종료");
		System.out.println("==================================");
		int menu = sc.nextInt();
			switch(menu) {
			case 1 : 
				System.out.println("이름");
				String name=sc.next();
				System.out.println("국어 점수");
				int kor=sc.nextInt();
				System.out.println("영어 점수");
				int eng=sc.nextInt();
				System.out.println("수학 점수");
				int math=sc.nextInt();
			
				
				program.printScore(name, kor, eng, math);
				
				break;
				
			case 2 : 
				System.out.print("감사합니다. 다음에 다시 이용해 주세요");
				
			default : 
				System.out.println("1번과 2번중에 선택하여 주세요");
				
				
			}
				                  
	}

}
}