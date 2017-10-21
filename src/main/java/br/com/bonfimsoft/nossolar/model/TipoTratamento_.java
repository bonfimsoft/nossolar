package br.com.bonfimsoft.nossolar.model;

import br.com.bonfimsoft.nossolar.enumerator.FormatoTratamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-18T16:18:35.462-0300")
@StaticMetamodel(TipoTratamento.class)
public class TipoTratamento_ {
	public static volatile SingularAttribute<TipoTratamento, Long> id;
	public static volatile SingularAttribute<TipoTratamento, Integer> versao;
	public static volatile SingularAttribute<TipoTratamento, String> nome;
	public static volatile SingularAttribute<TipoTratamento, FormatoTratamento> formatoTratamento;
	public static volatile ListAttribute<TipoTratamento, Tratamento> tratamentos;
}
