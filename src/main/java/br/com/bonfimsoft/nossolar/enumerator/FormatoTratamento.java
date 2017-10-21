package br.com.bonfimsoft.nossolar.enumerator;

/**
 * Created by c090347 on 27/08/2014.
 */
public enum FormatoTratamento {
	P("Passe"), L("Leitura"), C("Compromisso");

	private String descricao;

	FormatoTratamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
