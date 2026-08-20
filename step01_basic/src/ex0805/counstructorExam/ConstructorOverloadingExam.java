package ex0805.counstructorExam;
class Puppy3{
	/*String 타입 전역 변수 선언
	  int 타입 전역 변수 선언*/
		String a;
		int b = 22;
	
	/*인수가 없는 생성자작성
		String 타입 전역변수에 "메리" 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/		
		 Puppy3(){
			 a = "메리" ;
			 System.out.println("puplic Puppy3()호출되었습니다");
			 System.out.println(b);
			 System.out.println(a);
			 
		 }
	
	/*String 타입의 인수 1개를 받는 생성자작성
		String 타입 전역변수에 인수 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/		
		 Puppy3(String i){
			 a= i;
			 System.out.println("puplic Puppy3()호출되었습니다");
			  }
	
	/*String 타입의 인수 2개를 받는 생성자작성
		인수2개를 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"출력
	*/		
		 Puppy3(String k, String g){
			this(k + g);
			 System.out.println("puplic Puppy3()호출되었습니다");
			  }
	
	
	/*boolean 타입의 인수 1개를 받는 생성자작성
		인수를 "쫑"과 붙여 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"  출력
	*/					
		 Puppy3(boolean l){
			 this(l+"쫑");
			 System.out.println("puplic Puppy3()호출되었습니다");
			  }
	
	
	/*char 타입의 인수 1개를 받는 생성자작성
			인수가 없는 생성자를 호출하고
			인수로 받은 data를 int타입 전역변수에 할당	
			"puplic Puppy3()호출되었습니다"출력
			int형 전역변수출력
	*/			
		 Puppy3(char e){
			this();
			b = e;
			 System.out.println("puplic Puppy3()호출되었습니다");
			  }
	
	
	/*메소드 printMemberVariable
	리턴 없슴
	전역변수를 출력
	*/	
		 void printMemberVariable() {
			 System.out.println(a);
			 System.out.println(b);
		 }

	
}

public class ConstructorOverloadingExam{
		//메인메소드에서
		public static void main(String [] args){
			//Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
			Puppy3 aa = new Puppy3();
			Puppy3 bb =	new Puppy3("배고프다");
			Puppy3 cc =	new Puppy3("진짜", " 배 많이 고프다");
			Puppy3 dd = new Puppy3(true);
			Puppy3 ee =new Puppy3('A');
			
		//각 객체의 printMemberVariable메소드를 한번씩 호출
			aa.printMemberVariable();
			bb.printMemberVariable();
			cc.printMemberVariable();
			dd.printMemberVariable();
			ee.printMemberVariable();
	}
}