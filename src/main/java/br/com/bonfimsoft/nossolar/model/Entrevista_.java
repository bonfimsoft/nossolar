package br.com.bonfimsoft.nossolar.model;

import br.com.bonfimsoft.nossolar.enumerator.TipoEntrevista;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-04T10:34:21.455-0300")
@StaticMetamodel(Entrevista.class)
public class Entrevista_ {
	public static volatile SingularAttribute<Entrevista, Long> id;
	public static volatile SingularAttribute<Entrevista, Integer> versao;
	public static volatile SingularAttribute<Entrevista, Atendimento> atendimento;
	public static volatile SingularAttribute<Entrevista, Date> dataEntrevista;
	public static volatile SingularAttribute<Entrevista, String> entrevistador;
	public static volatile SingularAttribute<Entrevista, TipoEntrevista> tipoEntrevista;
	public static volatile SingularAttribute<Entrevista, String> observacao;
	public static volatile SingularAttribute<Entrevista, Boolean> apresentaMelhoras;
}
