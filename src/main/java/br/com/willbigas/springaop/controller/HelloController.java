package br.com.willbigas.springaop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final OutraClasse outraClasse;

	@GetMapping
	public ResponseEntity<String> hello() {
		outraClasse.soma(2 , 5);
		return ResponseEntity.ok(this.outraClasse.retornarAlgoBaseadoNoParametro("William"));
	}


}
