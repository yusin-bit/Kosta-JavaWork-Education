package ex0803.array;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = null;
		while(true) {
			System.out.println("----------------------------------------");
			System.out.println("1. 학생 수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
			System.out.println("----------------------------------------");
			System.out.println("선택>");
			
			int num = sc.nextInt();
			switch(num) {
			case 1 : 
				System.out.println("학생 수를 입력하세요 : ");
				int stu = sc.nextInt();
				 arr = new int[stu];
               break;
			case 2 :
				for (int i = 0; i < arr.length; i++) {
					System.out.print("arr ["+i+"]> ");
					arr[i] = sc.nextInt(); 
				}
				break;
			case 3 :
				for (int i = 0; i < arr.length; i++) 
				{
					System.out.println("arr ["+i+"]="+arr [i]);
				}
				break ;
			case 4 :
				int sum = 0;
				for (int i = 0; i < arr.length; i++) {
				    sum += arr[i];
				}
				double avg = (double) sum / arr.length;
				System.out.println("평균 : " + avg);
				int max = arr[0];
				for (int i = 1; i < arr.length; i++) {
				    if (arr[i] > max) {
				        max = arr[i];
			   }
			}
				System.out.println("최고 점수 : " + max); 
				break;
				
			case 5 :
				System.out.println("시스템 종료");
				
	}// switch 끝
}// while 끝
}// 메인 메소드 끝
} // 클래스 끝