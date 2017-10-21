package br.com.bonfimsoft.nossolar.model;

import br.com.bonfimsoft.nossolar.enumerator.Estado;
import br.com.bonfimsoft.nossolar.enumerator.Sexo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-18T16:18:35.448-0300")
@StaticMetamodel(Paciente.class)
public class Paciente_ {
	public static volatile SingularAttribute<Paciente, Long> id;
	public static volatile SingularAttribute<Paciente, Integer> versao;
	public static volatile SingularAttribute<Paciente, String> nome;
	public static volatile SingularAttribute<Paciente, String> endereco;
	public static volatile SingularAttribute<Paciente, String> bairro;
	public static volatile SingularAttribute<Paciente, String> cidade;
	public static volatile SingularAttribute<Paciente, Estado> uf;
	public static volatile SingularAttribute<Paciente, String> cep;
	public static volatile SingularAttribute<Paciente, Date> dataNascimento;
	public static volatile SingularAttribute<Paciente, Sexo> sexo;
	public static volatile SingularAttribute<Paciente, String> religiao;
	public static volatile SingularAttribute<Paciente, String> profissao;
	public static volatile SingularAttribute<Paciente, String> email;
	public static volatile SingularAttribute<Paciente, String> telefone1;
	public static volatile SingularAttribute<Paciente, String> telefone2;
	public static volatile SingularAttribute<Paciente, String> telefone3;
	public static volatile ListAttribute<Paciente, Atendimento> atendimentos;
}
