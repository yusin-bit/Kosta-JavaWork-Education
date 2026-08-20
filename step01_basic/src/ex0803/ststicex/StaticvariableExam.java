package ex0803.ststicex;

class Test{
	int a;
	static int b;
	
	public void aa() {
		System.out.println();
		System.out.println(this.a);
		
		System.out.println(b);
		System.out.println(this.b);
		System.out.println(Test.b);
		// 메소드 호출
		this.bb();
		bb();
		
		dd();
		this.dd();
		// Test.dd(); // dd는 인스턴스 메소드이므로 클래스명으로 호출할 수 없다.
	}
	public void bb() {
		
	}
	public static void cc() {
		System.out.println();
		// a는 인스턴스 변수이므로 static 메소드에서 객체 없이 접근할 수 없다.
		
		System.out.println(b);
		System.out.println(b);
		System.out.println(Test.b);
	}
	public void dd() {
	}
}
//////////////////////////////////
/// 
public class StaticvariableExam {
	public static void main(String[] args) {
		System.out.println("**static 변수 **");
		
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		
		System.out.println("**non-static 변수**" );
		System.out.println("t1 .a = " + t1.a);
		System.out.println("t2 .a = " + t2 .a);
		System.out.println("t3 .a= " + t3 .a);
		
		
		t2.a=100;
		System.out.println("**non-static 변수(후)**" );
		System.out.println("t1 .a = " + t1.a);
		System.out.println("t2 .a = " + t2.a);
		System.out.println("t3 .a = " + t3.a);

		System.out.println("**non-static 변수**" );
		System.out.println("t1 .b = " + t1.b);
		System.out.println("t2 .b = " + t2 .b);
		System.out.println("t3 .b = " + t3 .b);
		System.out.println("Test .b = " + Test .b);
		
		Test.b=70;
		System.out.println("**static 변수(후)**" );
		System.out.println("t1 .b = " + t1.b);
		System.out.println("t2 .b = " + t2 .b);
		System.out.println("t3 .b = " + t3 .b);
		System.out.println("Test .b = " + Test .b);


	}

}
