package ex0730.반복문;

public class WhileExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.  1 ~ 100가지 10행 10열로 출력 (while문 안에 while문이용)
				//2. 1 ~ 100가지 10행 10열로 출력 (while문 안에  for문이용)

		int b=1;
		int g=1;
		while (g<=10) {
			int e=1;
			while (e<=10) {
				System.out.print(b+" ");
				e++;
			 b++;
			
			} g++;
			System.out.println();
		}
		int u=1;
		for (int t=1; t<=10; t++) {
			int a=1;
		while (a<=10) {
			System.out.print(u+" ");
			a++;
			u++;
		}
		System.out.println();
	} 
}
}	