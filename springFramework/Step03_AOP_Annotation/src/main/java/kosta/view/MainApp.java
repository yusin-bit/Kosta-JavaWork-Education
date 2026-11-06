package kosta.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import kosta.config.AppConfig;
import kosta.service.GoodsService;
import kosta.service.MemberService;

public class MainApp {
    public static void main(String[] args) {
        // Spring이 만든 프록시를 통해 호출해야 AOP가 적용된다.
        try (AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class)) {
            MemberService memberService = context.getBean("memberService", MemberService.class);
            GoodsService goodsService = context.getBean("goodsService", GoodsService.class);
            memberService.memberInsert("유정현");
            memberService.memberUpdate();
            System.out.println("삭제 반환값: " + memberService.memberDelete(1));
            System.out.println("조회 반환값: " + memberService.select("name", "유정현"));
            goodsService.insert();
            System.out.println("상품 조회 반환값: " + goodsService.goodsSelect(100));
        }
    }
}
