package ex0729.report;

public class Calculator02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int korean = (int)(Math.random()*55)+45;
		int math = (int)(Math.random()*55)+45;
		int english = (int)(Math.random()*55)+45;
		int totalSum = korean+math+english;
		double average =totalSum/3.0;
		int nextAverage=(int)((average*100));
		average=(double)(nextAverage)/100;
		int grade=(int)(average);
		System.out.println("평균"+average +"점");
		switch(grade/10) {
		case 10 : System.out.print("A+ 학점"); break;
		case 9 : System.out.print("A 학점"); break;
		case 8 : System.out.print("B 학점"); break;
		case 7 : System.out.print("C 학점"); break;
		case 6 : System.out.print("D 학점"); break;
		default : System.out.print("F 학점"); break;
		}
	}

}
