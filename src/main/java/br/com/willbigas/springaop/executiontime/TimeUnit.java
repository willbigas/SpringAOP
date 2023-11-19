package br.com.willbigas.springaop.executiontime;

public enum TimeUnit {

	NANOSECONDS("nanosegundo(s)"),
	MILLISECONDS("millisegundo(s)"),
	SECONDS("segundo(s)");

	private String texto;

	TimeUnit(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}
}
