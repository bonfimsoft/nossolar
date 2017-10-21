package br.com.bonfimsoft.nossolar.enumerator;

/**
 * Created by c090347 on 27/08/2014.
 */
public enum Sexo {
	M("M", "Masculino"), F("F", "Feminino");

	private String sigla;
	private String descricao;

	Sexo(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
