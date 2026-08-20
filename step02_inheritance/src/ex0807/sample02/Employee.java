package ex0807.sample02;

public class Employee {

	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	
	public Employee() {
		
	}
	
public Employee(int empNo,String eName, String job, int mgr, String hiredate, String deptName) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "사번=" + empNo + ", 이름=" + eName + ", 직업=" + job
				+ ", 관리자번호=" + mgr + ", 입사일=" + hiredate + ", 부서=" + deptName;
	}

}
