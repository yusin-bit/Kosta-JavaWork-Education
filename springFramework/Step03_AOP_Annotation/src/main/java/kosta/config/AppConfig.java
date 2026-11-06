package kosta.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// XML 대신 이 클래스에서 빈 검색과 @Aspect 프록시 생성을 활성화한다.
@Configuration
@ComponentScan(basePackages = {"kosta.service", "kosta.advice"})
@EnableAspectJAutoProxy
public class AppConfig {
}
