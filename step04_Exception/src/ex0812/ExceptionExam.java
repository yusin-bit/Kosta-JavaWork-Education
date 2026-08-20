package ex0812;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("****Exception Test****");
		System.out.println("args =" + args);
		try{
			System.out.println("args[0] =" + args[0]);
			
			int converNo = Integer.parseInt(args[0]);
			System.out.println("숫자로 변환 =" + converNo);
			
			int result = 100/ converNo;
			System.out.println("나눈 결과 = "+ result);
			// 캐치를 여러개 작성 할 때는 반드시 서브 클래스를 먼저 작성한다
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인수의 값을 전달해 주세요 =>" + e);
		}
		catch(NumberFormatException e) {
			System.out.println("숫자만 입력해 주세요 =>" + e);
		}catch(Exception e) {
				System.out.println("오류가 발생했어요~ =>" + e);
				e.printStackTrace();
		}
		finally {
			System.out.println("예외 발생 여부 없이 반드시 실행이 됩니다~~");
		}
		
		
		System.out.println("**** Exeption End ****");
	}

}
