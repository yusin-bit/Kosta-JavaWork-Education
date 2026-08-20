package step05_Lamda;

public class MainApp {

	public static void main(String[] args) {
		//1.기본 방식
//		AInterface ai = new Test();
//		ai.aa();
		
		//2.익명의 이너클래스 (AnonymousInnerClass) 타입으로 작성
//		AInterface ai = new AInterface() {
//			
//			@Override
//			public void aa() {
//				System.out.println("익명의 이너클래스 (AnonymousInnerClass) aa 호출");
//			}
//		};//Ainterface end (1회성이라는데 이해 안감 이 말의 의미에 대해 설명 필요)
//		
//		ai.aa();
		
		/*3. 람다식
		 * : 반드시 interface안에 메소드 한개 있을 경우에 사용 할 수있다
		 * FuntionInterFace
		 * 문법
		 * 1) 인수가 없는경우
		 *   () ->{}
		 *
		 * 2) 인수가 있는 경우
		 * 	(변수 이름 ,..)-> {}
		 *
		 * 3) 기능이 한문장인 경우
		 * 	()-> 기능
		 */
		AInterface ai = ()->{
			System.out.println("인수 없는 람다식");
		};
		ai.aa();
		
	}

}
/////////////////////////
class Test implements AInterface{

	@Override
	public void aa() {
		System.out.println("Test의 aa메소드 입니다.");
		
	}
}