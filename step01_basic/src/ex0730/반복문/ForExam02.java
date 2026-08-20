package ex0730.반복문;

public class ForExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.  1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에  if문이용)

		//3. 구구단 출력  -  for 문안에 for문이용
			           /*
						 * 
						 *  2*1=2  3*1=3 ..... 9*1=9
						 *  2*2=4  3*2=4  4*2=4
						 *  2*3=6
						 *  ..
						 *  
						 *  2*9=18              9*9=81
						 * 
						 * */	
		int num=1;
		for(int m=1; m<=10; ++m) {
			for(int n=1; n<=10; ++n) {
			    System.out.print(num+" ");
				num++;
			
		}
		System.out.println();
	}
		System.out.println("-------------------");
		for(int n=1; n<=100; n++) { 
			System.out.print(n+" ");
			 if(n%10==0) {
				System.out.println();
		 }
		}
	}
}


