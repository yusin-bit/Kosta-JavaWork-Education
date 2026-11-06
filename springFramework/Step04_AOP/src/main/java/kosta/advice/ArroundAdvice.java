package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;

// 사전 사후 공통 기능 담당 
public class ArroundAdvice {

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[around 시작] " + joinPoint.getSignature().getName());
		try {
			return joinPoint.proceed();
		} finally {
			System.out.println("[around 종료] " + joinPoint.getSignature().getName());
		}
	}
}
