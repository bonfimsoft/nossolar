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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by c090347 on 13/09/2014.
 */
@Entity
@Table(name = "tb005_livro")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private String titulo;
	private String autor;
	private boolean ativo;
	/***********************/
	private List<Tratamento> tratamentos;

	public Livro() {
		this.tratamentos = new ArrayList<Tratamento>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro")
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

	@Column(name = "no_titulo", length = 80, nullable = false, unique = true)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "no_autor", length = 80, nullable = false)
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Column(name = "ic_ativo", nullable = false)
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@OneToMany(targetEntity = Tratamento.class, fetch = FetchType.EAGER, mappedBy = "livro")
	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public List<Tratamento> addTratamento(Tratamento tratamento) {
		if (this.tratamentos.add(tratamento)) {
			return this.tratamentos;
		}
		throw new IllegalArgumentException(
				"TB005-001: Falha ao adicionar o tratamento ao livro - "
						+ tratamento.toString());
	}

	public List<Tratamento> removeTratamento(Tratamento tratamento) {
		if (this.tratamentos.remove(tratamento)) {
			return this.tratamentos;
		}
		throw new IllegalArgumentException(
				"TB005-002: Falha ao remover o tratamento do livro - "
						+ tratamento.toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Livro))
			return false;

		Livro livro = (Livro) o;

		if (versao != livro.versao)
			return false;
		if (id != null ? !id.equals(livro.id) : livro.id != null)
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
