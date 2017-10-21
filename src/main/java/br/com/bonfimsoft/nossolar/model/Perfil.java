package br.com.bonfimsoft.nossolar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by c090347 on 26/08/2014.
 */
@Entity
@Table(name = "tb001_perfil")
class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private String nome;
	/**/
	private List<Trabalhador> trabalhadores;

	public Perfil() {
		this.trabalhadores = new ArrayList<Trabalhador>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "nu_versao", nullable = false)
	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	@Column(name = "no_perfil", length = 80, nullable = false, unique = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Trabalhador.class, mappedBy = "perfis")
	public List<Trabalhador> getTrabalhadores() {
		return trabalhadores;
	}

	public void setTrabalhadores(List<Trabalhador> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Perfil))
			return false;

		Perfil perfil = (Perfil) o;

		if (versao != perfil.versao)
			return false;
		if (id != null ? !id.equals(perfil.id) : perfil.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + versao;
		return result;
	}
}
