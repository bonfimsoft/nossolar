package br.com.bonfimsoft.nossolar.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-18T16:18:35.451-0300")
@StaticMetamodel(Perfil.class)
public class Perfil_ {
	public static volatile SingularAttribute<Perfil, Long> id;
	public static volatile SingularAttribute<Perfil, Integer> versao;
	public static volatile SingularAttribute<Perfil, String> nome;
	public static volatile ListAttribute<Perfil, Trabalhador> trabalhadores;
}
