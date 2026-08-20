package ex0728.제어문;

public class SwitchExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 발생한 난수가 1이면 일요일, 2이면 월요일, 3이면 화요일, 4이면 수요일
		//5이면 목요일 6이면 금요일, 이외의 수는 토요일 출력한다.
		   int day = (int)(Math.random()*9)+1;
		   switch(day) {
		   case 1: System.out.println("월요일"); break;
		   case 2: System.out.println("화요일"); break;
		   case 3: System.out.println("수요일"); break;
		   case 4: System.out.println("목요일"); break;
		   case 5: System.out.println("금요일"); break;
		   case 6: System.out.println("토요일"); break;
		   default: System.out.println("없는 요일"); 
		   
		   }
	}

}
