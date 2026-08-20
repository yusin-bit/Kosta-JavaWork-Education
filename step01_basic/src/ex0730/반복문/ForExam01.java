package ex0730.반복문;

public class ForExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 1~ 100가지 한줄로 출력

		//2. A ~Z 까지 한줄로 출력

		//3. 1~ 10 까지  합 구해서 출력

		//4. 1 ~ 100 사이의 7의 배수만 출력 

		//5. 100 ~ 1 사이의 5 의 배수만 출력 
	
		/////////////////////////////////////////////////////////////////////////////

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
		
		
	for (int num=1; num<=100; ++num) {
		System.out.print(num+" ");
	  }  
	
	System.out.println();

	for (int word=65; word<91; ++word) {
	char edu=(char)(word);
	System.out.print(edu+"\t");
	}
	System.out.println();
	
	int cat = 0;
   for (int number=1; number<=10; ++number) {
	  cat+=number;
	}
   System.out.print(cat+"\t") ;
   
   System.out.println();
   
   int count=1;
   for(int multiply=1; multiply<=100; ++multiply) {
	if(multiply%7==0) {count=multiply;
	 System.out.print(count+"\t") ;
 }
   }
   System.out.println();
   int love=1;
	for(int sum=100; sum>=1; --sum) {
		if(sum%5==0) {love=sum;
		 System.out.print(love+"\t") ;
}
}
}
}
