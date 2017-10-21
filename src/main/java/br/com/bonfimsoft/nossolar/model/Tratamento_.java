package br.com.bonfimsoft.nossolar.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-31T13:29:41.300-0300")
@StaticMetamodel(Tratamento.class)
public class Tratamento_ {
	public static volatile SingularAttribute<Tratamento, Long> id;
	public static volatile SingularAttribute<Tratamento, Integer> versao;
	public static volatile SingularAttribute<Tratamento, Atendimento> atendimento;
	public static volatile SingularAttribute<Tratamento, TipoTratamento> tipoTratamento;
	public static volatile SingularAttribute<Tratamento, Livro> livro;
	public static volatile SingularAttribute<Tratamento, Compromisso> compromisso;
	public static volatile SingularAttribute<Tratamento, Date> dataRegistro;
	public static volatile SingularAttribute<Tratamento, Date> dataPasse;
	public static volatile SingularAttribute<Tratamento, Boolean> remarcado;
	public static volatile SingularAttribute<Tratamento, Boolean> realizado;
}
