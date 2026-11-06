package sample11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // TODO: Spring 컨테이너 생성 및 실행
    	
    	 AnnotationConfigApplicationContext context =
                 new AnnotationConfigApplicationContext("sample11");
    	 
    	 BookController controller = context.getBean(BookController.class);
    	 
    	 controller.invoker();
    	 
    	 
    	 context.close();
    }
}
