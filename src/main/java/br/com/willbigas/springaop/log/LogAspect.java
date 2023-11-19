package br.com.willbigas.springaop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {


	@Around("@annotation(Log)")
	public Object retornarAlgoBaseadoNoParametro(ProceedingJoinPoint jp) throws Throwable {
		log.info("Entrou [{}] -> Parametros: {} ", jp.getSignature().toShortString(), Arrays.toString(jp.getArgs()));
		var result = jp.proceed();
		log.info("Saiu [{}] -> Retorno: {}", jp.getSignature().toShortString(), result);
		return result;
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
