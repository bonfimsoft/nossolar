package br.com.bonfimsoft.nossolar.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-18T16:18:35.395-0300")
@StaticMetamodel(Compromisso.class)
public class Compromisso_ {
	public static volatile SingularAttribute<Compromisso, Long> id;
	public static volatile SingularAttribute<Compromisso, Integer> versao;
	public static volatile SingularAttribute<Compromisso, String> nome;
	public static volatile ListAttribute<Compromisso, Tratamento> tratamentos;
}
