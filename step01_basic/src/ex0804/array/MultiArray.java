package ex0804.array;

	public class MultiArray{
		//정수형 2차원 배열 8*9
		int [][] k = new int [8][9];
		//메소드이름 :array99
			public void array99() {
				for(int a = 0; a < k.length ; ++a) {
					for(int b=0 ; b < k[a].length ; ++b) {
						  int dan = a + 2;
			                int number = b + 1;
			                int c = dan*number;
			                k[a][b]=c;
			                System.out.printf("%4d", k[a][b]);
					}
					System.out.println();
				}			
			}
	
			//for loop 를 사용하여 
			//배열에 곱한 (구구단)결과저장
			//배열에 결과를 꺼내출력
				
			
				
				
		//main메소드에서 
		//MultiArray객체의 array99메소드호출
			


	    public static void main(String[] args) {

	        MultiArray m = new MultiArray(); // 객체 생성
	        m.array99();                     // 메소드 실행
	    }
	}


