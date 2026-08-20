package ex080.finalex;
/**
 * final은 반드시 명시적 초기화가 필요하다 
 * -> 초기화를 하는 방법 
 * 	1) 직접 명시적 초기화
 * 	2) 생성자 안에서 초기화
 *  static final 필드는 상수이다 
 *   	1) 직접 명시적 초기화, 생성자 안에서 초기화 못함.
 */
public class FinalFieldExam {
	int i;
	//final int j; // final은 값변경 불가인 고정값이 된다.
	final int j;
	static final int k; // 진정한 상수 
	
	static {
		k=40;
	}
	public  FinalFieldExam() {
		j =50;
	}
	public FinalFieldExam(int j) {
		this.j = j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 FinalFieldExam re = new  FinalFieldExam();
		 re.i=5;
		 // re.j=5; // final 필드는 생성 후 값을 변경할 수 없다.
	}

}
