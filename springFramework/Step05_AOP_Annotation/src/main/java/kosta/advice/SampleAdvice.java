package kosta.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SampleAdvice {
    @Pointcut("execution(public * kosta.service..*(..))")
    public void customerMethods() {
    }
/*
 * 사전 처리 
 */
	@Before("customerMethods()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object params [] = joinPoint.getArgs();
		for(Object o : params) {
			System.out.println(o);
		}
		System.out.println(method + " before 입니다");
	}
/*
 * 사후 처리 
 */
	@AfterReturning(pointcut = "customerMethods()", returning = "returnObjc",
			argNames = "joinPoint,returnObjc")
	public void afterReturning(JoinPoint joinPoint , Object returnObjc) {
		System.out.println(joinPoint.getSignature().getName()+"의 리턴값 =" + returnObjc);
		System.out.println("메소드 정상 처리 후 사후 처리입니다");
		
	}

/*
 * 사후 처리(예외 발생했을 때)
 */
	
	@AfterThrowing(pointcut = "customerMethods()", throwing = "e", argNames = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("예외 발생 처리시 사후 메소드입니다");
		System.out.println("예외 정보 :" + e + "\n");
	}
	
 /*
  * 사후 처리(정상 이늗 예외가 발생하든 무조건)
  */
	
	@After("customerMethods()")
	public void afterFinally() {
		System.out.println("예외 발생 여부 없이 반드시 실행됩니다 \n");
	}
}
