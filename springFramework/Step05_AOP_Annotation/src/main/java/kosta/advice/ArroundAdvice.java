package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 사전 사후 공통 기능 담당 
@Aspect
@Component
@Order(0)
public class ArroundAdvice {
	@Around("execution(public * kosta.service..*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[around 시작] " + joinPoint.getSignature().getName());
		try {
			return joinPoint.proceed();
		} finally {
			System.out.println("[around 종료] " + joinPoint.getSignature().getName());
		}
	}
}
