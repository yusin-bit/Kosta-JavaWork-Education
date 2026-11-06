package sample06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * @Component : <bean class="sample06.EmpDTO" id="empDTO"/> 와 동일
 *              id 를 생략하면 클래스 이름의 camelCase(empDTO)가 기본 id
 */
@Component
public class EmpDTO {
	// @Value : 단순 값 주입 (XML 의 <property name="" value=""/> 와 동일)
	@Value("7788")
	private int empno;

	@Value("scott")
	private String ename;

	@Value("analyst")
	private String job;

	public EmpDTO() {
		System.out.println("EmpDTO 기본 생성자 호출 됨 (확인용)");
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + "]";
	}

}
