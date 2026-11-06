package kosta.test.advice;

import java.io.FileWriter;
import org.aspectj.lang.ProceedingJoinPoint;

// TODO: 공통 로그 기능을 구현하고 Spring 빈/Aspect로 등록하세요.
public class LogAdvice {
    private FileWriter fw;

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // TODO: 메서드명, 인수 개수, 반환값, 실행 시간을 파일에 기록
        // 환경 준비용 통과 코드입니다. 로그 기능은 아직 구현하지 않았습니다.
        return joinPoint.proceed();
    }
}