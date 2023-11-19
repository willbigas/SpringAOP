package br.com.willbigas.springaop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final ClasseQualquer classeQualquer;

	@GetMapping
	public ResponseEntity<String> hello() throws InterruptedException {
		classeQualquer.soma(2 , 5);
		classeQualquer.calculaLista(1);
		return ResponseEntity.ok(this.classeQualquer.retornarAlgoBaseadoNoParametro("William"));
	}


}
