package ex0730.반복문;

public class ForWhilExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.  1 ~ 100가지 10행 10열로 출력 (do문 안에 while문이용)
		//2. 1 ~ 100가지 10행 10열로 출력 (do문 안에  if문이용)

	
	int f=1;
	int a=1;
	do { System.out.print(a);
	System.out.println();
	    ++a;
	} while (a<=10);
		int q=1;
		while (q<=10) {System.out.print(f);
		++q;
	    ++f;

	}
 }
}