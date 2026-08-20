package ex0731.scanner;
import java.util.Scanner;
public class ScannerExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			
			System.out.print("국어 >");
			int kor = sc.nextInt();
			System.out.print("영어 >");
			int eng = sc.nextInt();
			System.out.print("수학 >");
			int math = sc.nextInt();
			System.out.print("이름? >");
			sc.nextLine();
		    String name = sc.nextLine();
			
			System.out.println(name+"님 성적"+ "kor :"+ kor + "eng: " + eng );
			
	}

}
