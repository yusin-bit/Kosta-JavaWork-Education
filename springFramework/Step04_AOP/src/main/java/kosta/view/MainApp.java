package kosta.view;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.service.CustomerService;

public class MainApp {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("springAOP.xml")) {
            System.out.println("--------------------");

            CustomerService service = context.getBean("service", CustomerService.class);

            int re = service.select();
            System.out.println("re = " + re);

            System.out.println("**************************");
            String result = service.selectById("jang");
            System.out.println("result = " + result);

            // 예외 Advice를 확인하고 다음 실습도 계속한다.
            try {
                service.selectById(null);
            } catch (RuntimeException e) {
                System.out.println("[실행부에서 예외 확인] " + e.getMessage());
            }

            System.out.println("**************************");
            service.update("jang", "희정");
        }
    }
}
