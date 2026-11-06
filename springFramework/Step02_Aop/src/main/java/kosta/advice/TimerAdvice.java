package kosta.advice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// around 방식: 실제 메서드 호출 전과 후를 감싼다.
public class TimerAdvice {
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.printf("[호출 전] %s | %s | 인수: %s%n",
                LocalDateTime.now().format(format), methodName, Arrays.toString(joinPoint.getArgs()));
        StopWatch sw = new StopWatch();
        sw.start();
        try {
            // 실제 메서드를 실행하고 반환값을 그대로 호출자에게 돌려준다.
            return joinPoint.proceed();
        } finally {
            // 예외가 발생한 경우에도 종료 시각과 소요 시간을 기록한다.
            sw.stop();
            System.out.printf("[호출 후] %s | %s | 소요 시간: %dms (%.3f초)%n%n",
                    LocalDateTime.now().format(format), methodName,
                    sw.getTotalTimeMillis(), sw.getTotalTimeSeconds());
        }
    }
}