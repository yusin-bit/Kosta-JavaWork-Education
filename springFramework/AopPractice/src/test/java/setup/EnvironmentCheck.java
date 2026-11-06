package setup;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 과제 정답과 독립적인 Spring/AOP/Lombok 환경 확인용 Java Application. */
public class EnvironmentCheck {
    @Getter @Setter
    public static class Message {
        private String value;
    }

    public interface Echo {
        String echo(String text);
    }

    public static class EchoImpl implements Echo {
        public String echo(String text) { return text; }
    }

    @Aspect
    public static class CheckAspect {
        private int calls;

        @Around("execution(* setup.EnvironmentCheck.Echo.echo(..))")
        public Object check(ProceedingJoinPoint point) throws Throwable {
            calls++;
            return point.proceed();
        }
    }

    public static void main(String[] args) {
        Message message = new Message();
        message.setValue("ready");
        if (!"ready".equals(message.getValue())) {
            throw new IllegalStateException("Lombok getter/setter failed");
        }
        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("springAOP.xml")) {
            if (context.getBeansOfType(kosta.test.service.Player.class).size() != 3) {
                throw new IllegalStateException("Spring component scan failed");
            }
        }
        CheckAspect aspect = new CheckAspect();
        AspectJProxyFactory factory = new AspectJProxyFactory(new EchoImpl());
        factory.addAspect(aspect);
        Echo proxy = factory.getProxy();
        if (!"ready".equals(proxy.echo(message.getValue())) || aspect.calls != 1) {
            throw new IllegalStateException("Spring AOP interception failed");
        }
        System.out.println("PASS: Spring XML / Player beans / AOP around interception / Lombok generated methods");
    }
}