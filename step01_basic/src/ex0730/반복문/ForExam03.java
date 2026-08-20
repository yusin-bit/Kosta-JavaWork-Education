package ex0730.반복문;

public class ForExam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3. 구구단 출력  -  for 문안에 for문이용
				/*
						 * 
						 *  2*1=2  3*1=3 ..... 9*1=9
						 *  2*2=4  3*2=4  4*2=4
						 *  2*3=6
						 *  ..
						 *  
						 *  2*9=18              9*9=81
						 * */	
		
		for(int k=1;k<=9; k++) {	
			for(int m=2;m<=9; m++) {
		      System.out.print(m+"*"+k+"="+(m*k)+" ");
			
		} System.out.println();
	}

} 
}