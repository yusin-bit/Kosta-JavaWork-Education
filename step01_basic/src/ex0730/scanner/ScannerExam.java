package ex0730.scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("이름은?");
	String name=sc.next();
		System.out.print("국어 점수 입력?");
		int kor=sc.nextInt();
		System.out.print("영어 점수 입력?");
		int eng=sc.nextInt();
		System.out.print("수학 점수 입력?");
		int math=sc.nextInt();
		System.out.println("국어 점수 ="+ kor);
		System.out.println("영어 점수 ="+ kor);
		System.out.println("수학 점수 ="+ kor);
		
		
		
	} 

}
