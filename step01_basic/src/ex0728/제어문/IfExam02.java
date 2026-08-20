package ex0728.제어문;

public class IfExam02 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
				// 발생한 난수가 1이면 일요일, 2이면 월요일, 3이면 화요일, 4이면 수요일
				//5이면 목요일 6이면 금요일, 이외의 수는 토요일 출력한다.
				
		    int day = (int)(Math.random()*12)+1;
		    String num = "토";
		    if(day==1) {
		    	num="일" ;
		    } else if(day==2) {
		    	num="월" ;
		    } else if(day==3) {
		    	num="화" ;
		    } else if(day==4) {
		    	num="수" ;   
		    } else if(day==5) {
		    	num="목" ;
		    } else if(day==6) {
		    	num="금" ;
		    } 
		    System.out.println(day+"= "+num+"요일");
	    }    
   }    

 


