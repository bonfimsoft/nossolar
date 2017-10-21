package br.com.bonfimsoft.nossolar.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-18T16:18:35.447-0300")
@StaticMetamodel(Livro.class)
public class Livro_ {
	public static volatile SingularAttribute<Livro, Long> id;
	public static volatile SingularAttribute<Livro, Integer> versao;
	public static volatile SingularAttribute<Livro, String> titulo;
	public static volatile SingularAttribute<Livro, String> autor;
	public static volatile SingularAttribute<Livro, Boolean> ativo;
	public static volatile ListAttribute<Livro, Tratamento> tratamentos;
}
