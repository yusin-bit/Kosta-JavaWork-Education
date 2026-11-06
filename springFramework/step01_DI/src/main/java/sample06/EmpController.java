package sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * @Controller : 요청 처리 클래스를 Bean 으로 등록 (@Component 의 세분화)
 * @Autowired  : 타입(Type) 기반으로 컨테이너가 관리하는 Bean 을 자동 주입
 *               (setter 가 없어도 필드에 바로 주입 가능)
 */
@Controller
public class EmpController {

	@Autowired
	private EmpDTO empDto;

	@Autowired
	private EmpService empService;

	public EmpController() {
		// 생성자가 호출되는 시점에는 아직 주입 전이므로 null 이 출력된다.
		System.out.println("EmpController 기본 생성자 호출 됨");

		System.out.println("empDto = " + empDto);
		System.out.println("empService = " + empService);
	}

	public void test() {
		System.out.println("---------- 주입 후 ----------");
		System.out.println("empDto = " + empDto);
		System.out.println("empService = " + empService);
		empService.test(empDto);
	}

}
