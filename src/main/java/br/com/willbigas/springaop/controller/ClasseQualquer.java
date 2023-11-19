package br.com.willbigas.springaop.controller;

import br.com.willbigas.springaop.executiontime.ExecutionTimeLogger;
import br.com.willbigas.springaop.log.Log;
import org.springframework.stereotype.Component;

@Component
public class ClasseQualquer {

	@Log
	public String retornarAlgoBaseadoNoParametro(String teste) {
		return teste + " Bigas Mauro";
	}


	@Log
	@ExecutionTimeLogger
	public int soma(int a , int b) {
		return a + b;
	}

	@ExecutionTimeLogger
	public int calculaLista(int numero) throws InterruptedException {
		for (int i = 0; i < 500; i++) {
			numero += numero;
			Thread.sleep(1);
		}
		return numero;
	}


}
