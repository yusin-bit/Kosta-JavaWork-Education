package sample06;

import org.springframework.stereotype.Service;

/*
 * @Service : 비즈니스 로직 담당 클래스를 Bean 으로 등록 (@Component 의 세분화)
 */
@Service
public class EmpService {
	public EmpService() {
		System.out.println("EmpService 기본 생성자 확인용");
	}

	public void test(EmpDTO dto) {
		System.out.println(dto.getEname() + "(" + dto.getEmpno() + ") 의 직무는 " + dto.getJob());
	}
}
