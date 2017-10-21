package br.com.bonfimsoft.nossolar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import br.com.bonfimsoft.nossolar.enumerator.FormatoTratamento;

/**
 * Created by c090347 on 13/09/2014.
 */
@Entity
@Table(name = "tb006_tipo_tratamento")
public class TipoTratamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private String nome;
	private FormatoTratamento formatoTratamento;
	/**************************/
	private List<Tratamento> tratamentos;

	public TipoTratamento() {
		this.tratamentos = new ArrayList<Tratamento>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_tratamento")
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

	@Column(name = "no_tipo_tratamento", length = 80, nullable = false, unique = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ic_formato", length = 1, nullable = false)
	public FormatoTratamento getFormatoTratamento() {
		return formatoTratamento;
	}

	public void setFormatoTratamento(FormatoTratamento formatoTratamento) {
		this.formatoTratamento = formatoTratamento;
	}

	@OneToMany(targetEntity = Tratamento.class, fetch = FetchType.EAGER, mappedBy = "tipoTratamento")
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
				"TB006-001: Falha ao adicionar o tratamento ao tipo de tratamento - "
						+ tratamento.toString());
	}

	public List<Tratamento> removeTratamento(Tratamento tratamento) {
		if (this.tratamentos.remove(tratamento)) {
			return this.tratamentos;
		}
		throw new IllegalArgumentException(
				"TB006-002: Falha ao remover o tratamento do tipo de tratamento - "
						+ tratamento.toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TipoTratamento))
			return false;

		TipoTratamento that = (TipoTratamento) o;

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
