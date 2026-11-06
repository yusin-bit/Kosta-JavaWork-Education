package sample06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// Spring(IoC) Container 생성 -> component-scan 으로 @Component 계열 클래스를 Bean 으로 등록
		ApplicationContext context = new ClassPathXmlApplicationContext("sample06/springDI_annotation.xml");

		System.out.println("---------------------------------");

		// 기본 id = 클래스 이름의 camelCase
		EmpController controller = context.getBean("empController", EmpController.class);
		controller.test();
	}

}
