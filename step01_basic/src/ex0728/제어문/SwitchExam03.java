package ex0728.제어문;

public class SwitchExam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mounth = (int)(Math.random()*12)+1;
		int day = 28;
		 if(mounth==2) { day= 28;
        } if(mounth==1||mounth==3||mounth==5||mounth==7||mounth==8||mounth==10||mounth==12 ) {day=31;
        } if(mounth==2||mounth==4||mounth==6||mounth==9||mounth==11) {day=30;
        System.out.print(mounth + "월의 마지막 날 수는"+ day + "일 입니다" );
}
}
}