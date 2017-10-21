package br.com.bonfimsoft.nossolar.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-24T11:14:45.457-0300")
@StaticMetamodel(Problema.class)
public class Problema_ {
	public static volatile SingularAttribute<Problema, Long> id;
	public static volatile SingularAttribute<Problema, Integer> versao;
	public static volatile SingularAttribute<Problema, Atendimento> atendimento;
	public static volatile SingularAttribute<Problema, TipoProblema> tipoProblema;
	public static volatile SingularAttribute<Problema, String> detalheProblema;
	public static volatile SingularAttribute<Problema, String> observacao;
	public static volatile SingularAttribute<Problema, Integer> escala;
	public static volatile SingularAttribute<Problema, Date> dataRegistro;
}
