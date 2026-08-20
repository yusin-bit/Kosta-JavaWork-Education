package ex0807.sample02;

public class FullTime extends Employee {
	private int salary;
	private int bonus;

	public FullTime(int empNo, String eName, String job, int mgr, String hiredate,
			String deptName, int salary, int bonus) {
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.salary = salary;
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "FullTime [" + super.toString() + ", 급여=" + salary + ", 보너스=" + bonus + "]";
	}

}
