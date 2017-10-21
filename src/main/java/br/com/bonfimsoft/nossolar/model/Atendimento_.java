package br.com.bonfimsoft.nossolar.model;

import br.com.bonfimsoft.nossolar.enumerator.SituacaoAtendimento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-20T22:11:57.167-0300")
@StaticMetamodel(Atendimento.class)
public class Atendimento_ {
	public static volatile SingularAttribute<Atendimento, Long> id;
	public static volatile SingularAttribute<Atendimento, Integer> versao;
	public static volatile SingularAttribute<Atendimento, Paciente> paciente;
	public static volatile SingularAttribute<Atendimento, Date> dataInicio;
	public static volatile SingularAttribute<Atendimento, Date> dataFim;
	public static volatile SingularAttribute<Atendimento, SituacaoAtendimento> situacaoAtendimento;
	public static volatile SingularAttribute<Atendimento, Integer> diasAtendimento;
	public static volatile SingularAttribute<Atendimento, Boolean> tratamentoMedico;
	public static volatile SingularAttribute<Atendimento, Boolean> tratamentoPsicologico;
	public static volatile SingularAttribute<Atendimento, Boolean> tratamentoPsiquiatrico;
	public static volatile SingularAttribute<Atendimento, Boolean> tratamentoEspiritual;
	public static volatile SingularAttribute<Atendimento, Boolean> evangelhoLar;
	public static volatile SingularAttribute<Atendimento, Boolean> leituraLivros;
	public static volatile SingularAttribute<Atendimento, Boolean> usoMedicamentos;
	public static volatile SingularAttribute<Atendimento, String> descricaoMedicamentos;
	public static volatile SingularAttribute<Atendimento, Boolean> proprio;
	public static volatile SingularAttribute<Atendimento, String> responsavel;
	public static volatile SingularAttribute<Atendimento, String> relacionamento;
	public static volatile SingularAttribute<Atendimento, String> telefone;
	public static volatile SingularAttribute<Atendimento, String> email;
	public static volatile ListAttribute<Atendimento, Tratamento> tratamentos;
	public static volatile ListAttribute<Atendimento, Entrevista> entrevistas;
	public static volatile ListAttribute<Atendimento, Problema> problemas;
}
