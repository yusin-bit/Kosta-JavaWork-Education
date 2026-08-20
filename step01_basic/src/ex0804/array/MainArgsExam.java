package ex0804.array;

public class MainArgsExam {

	public static void main(String[] args) {
		for(int k = 0; k < args.length ; ++k) {
			System.out.println(args[k]);
		
		}
		System.out.println("---------개선된 for-------------");
		for(String s : args ) {
			System.out.println(s);
		}

		//args 배열방에 있는 값을 출력해 보자 
	}
}
