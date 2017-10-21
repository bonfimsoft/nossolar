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
@Table(name = "tb007_tipo_problema")
public class TipoProblema implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private String nome;
	private boolean aberto;
	/******************************/
	private List<Problema> problemas;

	public TipoProblema() {
		this.problemas = new ArrayList<Problema>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_problema")
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

	@Column(name = "no_tipo_problema", length = 80, nullable = false, unique = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "ic_aberto", nullable = false)
	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	@OneToMany(targetEntity = Problema.class, fetch = FetchType.LAZY, mappedBy = "tipoProblema")
	public List<Problema> getProblemas() {
		return problemas;
	}

	public void setProblemas(List<Problema> problemas) {
		this.problemas = problemas;
	}

	public List<Problema> addProblema(Problema problema) {
		if (this.problemas.add(problema)) {
			return this.problemas;
		}
		throw new IllegalArgumentException(
				"TB007-001: Falha ao adicionar o problema ao tipo de problema - "
						+ problema.toString());
	}

	public List<Problema> removeEntrevista(Problema problema) {
		if (this.problemas.remove(problema)) {
			return this.problemas;
		}
		throw new IllegalArgumentException(
				"TB007-002: Falha ao remover o problema do tipo de problema - "
						+ problema.toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TipoProblema))
			return false;

		TipoProblema that = (TipoProblema) o;

		if (versao != that.versao)
			return false;
		if (id != null ? !id.equals(that.id) : that.id != null)
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
