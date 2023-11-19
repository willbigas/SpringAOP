package br.com.willbigas.springaop.executiontime;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class ExecutionTimeLoggerAspect {


	@Around("@annotation(executionTimeLogger)")
	public Object executionTimeLogger(ProceedingJoinPoint joinPoint, ExecutionTimeLogger executionTimeLogger) throws Throwable {

		try {
			TimeUnit timeUnit = executionTimeLogger.value();
			long startTime = getTime(timeUnit);
			Object proceed = joinPoint.proceed();
			long executionTime = (getTime(timeUnit) - startTime);
			log.info("{} metodo foi executado em {} {} ", joinPoint.getSignature().toShortString(), executionTime, timeUnit.getTexto());
			return proceed;
		} catch (Throwable e) {
			log.error("Houve um erro ao tentar calcular o tempo de execução para o método {}", joinPoint.getSignature().toShortString(), e);
			return null;
		}
	}

	private long getTime(TimeUnit timeUnit) {
		if (TimeUnit.NANOSECONDS.equals(timeUnit)) {
			return System.nanoTime();
		}
		if (TimeUnit.SECONDS.equals(timeUnit)) {
			return System.currentTimeMillis() / 1000;
		}
		return System.currentTimeMillis();
	}

//	@Before("@annotation(Log)")
//    public void logBefore() {
//		 System.out.println("Before method execution: Logging...");
//    }
//
//    @After("@annotation(Log)")
//    public void logAfter() {
//        System.out.println("After method execution: Logging...");
//    }
}
