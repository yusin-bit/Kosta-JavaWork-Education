package ex0803.overloading;

public class VariableArgsExam {

		public void aa(int ... i) {
			System.out.println("i ="+i);
			
			System.out.println("\n************");
		}
			public void bb(int i, String ... s) {
				
		}
	public static void main(String[] args) {
		System.out.println("-----메소드를 출력해 보자-----");
		VariableArgsExam ve = new VariableArgsExam();
		ve.aa(5);
		
		ve.aa(5,3,1);
		ve.aa();
		ve.aa(5,1,2,3,4,5,6,7);
	}

}
