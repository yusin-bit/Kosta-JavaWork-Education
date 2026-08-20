package ex0729.report;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String userName = "유정현";
int korean = (int)(Math.random()*55)+45;
int math = (int)(Math.random()*55)+45;
int english = (int)(Math.random()*55)+45;
int totalSum = korean+math+english;
int average =totalSum/3;
System.out.println("평균"+ totalSum/3+"점");
if(100>=average && average>=90 ) {System.out.println("A 학점");
}else if(89>=average && average>=80 ) {System.out.println("B 학점");
}else if(79>=average && average>=70 ) {System.out.println("C 학점");
}else if(69>=average && average>=60 ) {System.out.println("D 학점");
} else { System.out.println("F 학점");

}
}
}