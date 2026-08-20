package ex0813.exam05;

//강좌를 등록 할 수 있는 클래스

public class Course {

	// 모든 사람 등록 허용 
	
	public void register01(Applicant<?> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+"신청 완료 - register01");
	}
	
	// 직장인 가능
	
	public void register02(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+"신청 완료 - register02");
	}
	
	
	// 학생 가능 
	public void register03(Applicant<? extends Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+"신청 완료 - register03");
	}
}
