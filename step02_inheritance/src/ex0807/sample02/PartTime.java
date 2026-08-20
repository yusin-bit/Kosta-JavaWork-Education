package ex0807.sample02;

public class PartTime extends Employee {
	private int hourlyPay;

	public PartTime(int empNo, String eName, String job, int mgr, String hiredate,
			String deptName, int hourlyPay) {
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.hourlyPay = hourlyPay;
	}

	@Override
	public String toString() {
		return "PartTime [" + super.toString() + ", 시급=" + hourlyPay + "]";
	}

}
