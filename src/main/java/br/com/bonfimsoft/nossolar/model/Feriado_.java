package br.com.bonfimsoft.nossolar.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-23T19:13:59.763-0300")
@StaticMetamodel(Feriado.class)
public class Feriado_ {
	public static volatile SingularAttribute<Feriado, Long> id;
	public static volatile SingularAttribute<Feriado, Integer> versao;
	public static volatile SingularAttribute<Feriado, String> nome;
	public static volatile SingularAttribute<Feriado, Date> data;
}
