package kosta.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("springAOP.xml")) {
            System.out.println("AopPractice: Spring 환경 준비 완료 (Player 빈 "
                    + context.getBeansOfType(kosta.test.service.Player.class).size() + "개)");
            // TODO: Player 빈을 조회하여 start(), pause(), stop()을 호출하세요.
        }
    }
}