package br.com.willbigas.springaop.controller;

import br.com.willbigas.springaop.log.Log;
import org.springframework.stereotype.Component;

@Component
public class OutraClasse {

	@Log
	public String retornarAlgoBaseadoNoParametro(String teste) {
		return teste + " Bigas Mauro";
	}


	@Log
	public int soma(int a , int b) {
		return a + b;
	}


}
