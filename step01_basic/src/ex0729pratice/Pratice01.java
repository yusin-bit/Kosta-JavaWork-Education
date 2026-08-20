package ex0729pratice;

public class Pratice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	// 학생 한 명의국어 영어 수학 점수를 랜덤으로 만들고 
   // 총점, 평균, 학점, 합격 여부를 출력하는 프로그램을 만들어 보는 거야.
	
		int korean= (int)(Math.random()*56)+45;
		int math= (int)(Math.random()*56)+45;
		int english= (int)(Math.random()*56)+45;
		int total= korean+math+english;
		double average= total/3.0;
		int pass=0;
		System.out.println("국어 점수:"+korean);
		System.out.println("영어 점수:"+english);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+total);
		System.out.println("평균:"+average);
		
		
		if(average>=90) {pass=1; System.out.println("A");
		} else if(average>=80) {pass=1; System.out.println("B");
		} else if( average>=70) {pass=0; System.out.println("C");
		} else if(average>=60) {pass=0; System.out.println("D");
		} else {pass=0; System.out.println("F");
		} 
		switch(pass) {
		case 1: System.out.println("합격입니다"); break;
		default: System.out.println("불합격입니다"); 
	

     }
 }
}