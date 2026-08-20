package ex0812;

import java.util.Scanner;

public class ThrowsException {
	public void aa(long i) {
	try {
		if(i==0) {
			return;//메소드 빠져나가라.
		}
		System.out.println(i+" 예외 입니다.");
		
	}finally {
		System.out.println("--aa 끝--");
	}
}
	public static void main(String[] args) {
		System.out.println("숫자를 입력해 주세여");
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		// TODO Auto-generated method stub
		System.out.println("***메인 시작***");
		new ThrowsException().aa(e);
		
		System.out.println("***메인 끝***");
	}

}
