package br.com.bonfimsoft.nossolar.enumerator;

/**
 * Created by c090347 on 27/08/2014.
 */
public enum SituacaoAtendimento {
    A("Em Andamento"), C("Concluido"), I("Interrompido");

    private String descricao;

    SituacaoAtendimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
