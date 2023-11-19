package br.com.willbigas.springaop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Sucesso");
	}
}
