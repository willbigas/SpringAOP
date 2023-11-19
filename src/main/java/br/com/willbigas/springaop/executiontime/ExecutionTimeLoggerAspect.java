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


	@Around("@annotation(ExecutionTimeLogger)")
	public Object executionTimeLogger(ProceedingJoinPoint joinPoint) throws Throwable {

		try {
			long startTime = System.currentTimeMillis();
			Object proceed = joinPoint.proceed();
			long executionTime = (System.currentTimeMillis() - startTime);
			log.info("{} metodo foi executado em {} millisegundos", joinPoint.getSignature().toShortString(), executionTime);
			return proceed;
		} catch (Throwable e) {
			log.error("Houve um erro ao tentar calcular o tempo de execução para o método {}", joinPoint.getSignature().toShortString(), e);
			return null;
		}
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
