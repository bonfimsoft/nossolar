package br.com.bonfimsoft.nossolar.model;

import br.com.bonfimsoft.nossolar.enumerator.Estado;
import br.com.bonfimsoft.nossolar.enumerator.Sexo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-18T16:18:35.464-0300")
@StaticMetamodel(Trabalhador.class)
public class Trabalhador_ {
	public static volatile SingularAttribute<Trabalhador, Long> id;
	public static volatile SingularAttribute<Trabalhador, Integer> versao;
	public static volatile SingularAttribute<Trabalhador, String> matricula;
	public static volatile SingularAttribute<Trabalhador, String> senha;
	public static volatile SingularAttribute<Trabalhador, String> nome;
	public static volatile SingularAttribute<Trabalhador, String> cracha;
	public static volatile SingularAttribute<Trabalhador, String> endereco;
	public static volatile SingularAttribute<Trabalhador, String> bairro;
	public static volatile SingularAttribute<Trabalhador, String> cidade;
	public static volatile SingularAttribute<Trabalhador, Estado> uf;
	public static volatile SingularAttribute<Trabalhador, String> cep;
	public static volatile SingularAttribute<Trabalhador, Date> dataNascimento;
	public static volatile SingularAttribute<Trabalhador, String> cpf;
	public static volatile SingularAttribute<Trabalhador, String> rg;
	public static volatile SingularAttribute<Trabalhador, String> profissao;
	public static volatile SingularAttribute<Trabalhador, Sexo> sexo;
	public static volatile SingularAttribute<Trabalhador, byte[]> foto;
	public static volatile SingularAttribute<Trabalhador, String> email1;
	public static volatile SingularAttribute<Trabalhador, String> email2;
	public static volatile SingularAttribute<Trabalhador, String> telefone1;
	public static volatile SingularAttribute<Trabalhador, String> telefone2;
	public static volatile SingularAttribute<Trabalhador, String> telefone3;
	public static volatile ListAttribute<Trabalhador, Perfil> perfis;
}
