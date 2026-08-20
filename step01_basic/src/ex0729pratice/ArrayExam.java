package ex0729pratice;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr = {1, 5, 3, 8, 2};
		int max = arr[0];
		
		for(int a = 0 ; a < arr.length ; ++a) {
			if(max < arr[a]) {
				max = arr[a];
				
			}
			
		}
		System.out.print(max);
	}

}
