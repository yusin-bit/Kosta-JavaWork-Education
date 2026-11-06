package kosta.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"kosta.service", "kosta.advice"})
@EnableAspectJAutoProxy
public class AppConfig {
}
