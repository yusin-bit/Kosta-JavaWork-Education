package ex0729pratice;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 3 ;
		int minute = 45 ;
		System.out.println(hour + "시간" + minute + "분") ;
		System.out.println("총" +( hour*60 + minute) + "분");
        int age = (int)(Math.random()*100) + 1;
        		
       System.out.println(age);
        String result = age >= 18 ? "성인" : "미성년자" ;
        System.out.println(result);
        
     
        if (age >= 18) { 
        	System.out.println("성인입니다");
        	System.out.println("입장 가능합니다");
        	}
        	else { System.out.println("들어오실 수 없습니다");
        }
        
        Double.isNaN(3.0/0.0);
        
	}
}







