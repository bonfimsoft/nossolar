package br.com.bonfimsoft.nossolar.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-18T16:18:35.457-0300")
@StaticMetamodel(TipoProblema.class)
public class TipoProblema_ {
	public static volatile SingularAttribute<TipoProblema, Long> id;
	public static volatile SingularAttribute<TipoProblema, Integer> versao;
	public static volatile SingularAttribute<TipoProblema, String> nome;
	public static volatile SingularAttribute<TipoProblema, Boolean> aberto;
	public static volatile ListAttribute<TipoProblema, Problema> problemas;
}
