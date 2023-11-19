package br.com.willbigas.springaop.controller;

import br.com.willbigas.springaop.executiontime.ExecutionTimeLogger;
import br.com.willbigas.springaop.executiontime.TimeUnit;
import br.com.willbigas.springaop.log.Log;
import org.springframework.stereotype.Component;

@Component
public class ClasseQualquer {

	@Log
	public String retornarAlgoBaseadoNoParametro(String teste) {
		return teste + " Bigas Mauro";
	}


	@Log
	@ExecutionTimeLogger(TimeUnit.NANOSECONDS)
	public int soma(int a , int b) {
		return a + b;
	}

	@ExecutionTimeLogger(TimeUnit.SECONDS)
	public int calculaLista(int numero) throws InterruptedException {
		for (int i = 0; i < 1_500; i++) {
			numero += numero;
			Thread.sleep(1);
		}
		return numero;
	}

	@ExecutionTimeLogger
	public int calculaListaMenor(int numero) throws InterruptedException {
		for (int i = 0; i < 500; i++) {
			numero += numero;
			Thread.sleep(1);
		}
		return numero;
	}


}
