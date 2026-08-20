package ex0813.exam05;

public class MainApp {

	public static void main(String[] args) {
		Course course = new Course();
		// TODO Auto-generated method stub
		System.out.println("---1. ? 모든 타입 허용----");
		course.register01(new Applicant<Person>(new Person()));
		course.register01(new Applicant<Worker>(new Worker()));
		course.register01(new Applicant<Person>(new Student()));
		course.register01(new Applicant<HighStudent>(new HighStudent()));
		course.register01(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		
		
		
		System.out.println("---2. <? super Worker> 허용----");
		course.register02(new Applicant<Person>(new Person()));
		course.register02(new Applicant<Worker>(new Worker()));
		// <? super Worker>는 Worker와 그 상위 타입만 허용한다.
		// Student, HighStudent, MiddleStudent는 허용되지 않는다.
		
		
		
		System.out.println("---3. <? extends Student> 허용----");
		// <? extends Student>는 Student와 그 하위 타입만 허용한다.
		course.register03(new Applicant<Student>(new Student()));
		course.register03(new Applicant<HighStudent>(new HighStudent()));
		course.register03(new Applicant<MiddleStudent>(new MiddleStudent()));

	}

}
