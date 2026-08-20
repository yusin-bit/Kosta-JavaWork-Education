package ex0728.제어문;

public class SwitchExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int mounth = (int)(Math.random()*12)+1;
		 int day = 28; 
       // 월과 마지막 일수를 적는다
		switch(mounth)  {
		case 1,3,5,7,8,10,12 : day=31; break;
		case 4,6,9,11 : day=30; break;
		default : day=28;
		}
	System.out.print(mounth + "월의 마지막 날 수는"+ day + "일 입니다" );
	}

}
