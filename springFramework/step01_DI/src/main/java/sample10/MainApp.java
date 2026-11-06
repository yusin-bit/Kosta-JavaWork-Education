package sample10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sample10/springDI_annotation.xml");

		System.out.println("---------------------------------");

		BoardController controller = context.getBean("boardController", BoardController.class);
		controller.test();

		System.out.println("--------- Lombok @Builder ---------");

		// new 와 생성자 인자 순서를 몰라도 필드 이름으로 값을 지정해서 객체를 만든다.
		// (Spring 컨테이너가 만든 Bean 이 아니라 직접 만든 객체)
		BoardDTO built = BoardDTO.builder()
				.no(3)
				.subject("빌더로 만든 글")
				.content("builder() -> 값 지정 -> build()")
				.build();
		System.out.println("built = " + built);

		// 값을 지정하지 않은 필드는 @Builder.Default 의 기본값이 사용된다.
		BoardDTO onlyNo = BoardDTO.builder().no(4).build();
		System.out.println("onlyNo = " + onlyNo);
	}

}
