package br.com.bonfimsoft.nossolar.enumerator;

/**
 * Created by c090347 on 27/08/2014.
 */
public enum TipoEntrevista {
    I("Inicial"), F("Final"), C("Complementar");

    private String descricao;

    TipoEntrevista(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
