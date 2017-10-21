package br.com.bonfimsoft.nossolar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Created by c090347 on 14/09/2014.
 */
@Entity
@Table(name = "tb009_tratamento")
public class Tratamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer versao;
	private Atendimento atendimento;
	private TipoTratamento tipoTratamento;
	private Livro livro;
	private Compromisso compromisso;
	private Date dataRegistro;
	private Date dataPasse;
	private Boolean remarcado;
	private Boolean realizado;
	/******************************/
	private transient Long idTipoTratamento;
	private transient Long idLivro;
	private transient Long idCompromisso;

	/******************************/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tratamento")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "nu_versao", nullable = false)
	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	@ManyToOne(targetEntity = Atendimento.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_atendimento", nullable = false)
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	@ManyToOne(targetEntity = TipoTratamento.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_tratamento", nullable = false)
	public TipoTratamento getTipoTratamento() {
		return tipoTratamento;
	}

	public void setTipoTratamento(TipoTratamento tipoTratamento) {
		this.tipoTratamento = tipoTratamento;
	}

	@ManyToOne(targetEntity = Livro.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_livro", nullable = true)
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@ManyToOne(targetEntity = Compromisso.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_compromisso", nullable = true)
	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_registro", nullable = true)
	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_passe", nullable = true)
	public Date getDataPasse() {
		return dataPasse;
	}

	public void setDataPasse(Date dataPasse) {
		this.dataPasse = dataPasse;
	}

	@Column(name = "ic_remarcado", nullable = true)
	public Boolean getRemarcado() {
		return remarcado;
	}

	public void setRemarcado(Boolean remarcado) {
		this.remarcado = remarcado;
	}

	@Column(name = "ic_realizado", nullable = true)
	public Boolean getRealizado() {
		return realizado;
	}

	public void setRealizado(Boolean realizado) {
		this.realizado = realizado;
	}

	@Transient
	public Long getIdTipoTratamento() {
		if (tipoTratamento != null) {
			this.idTipoTratamento = tipoTratamento.getId();
		}
		return idTipoTratamento;
	}

	public void setIdTipoTratamento(Long idTipoTratamento) {
		this.idTipoTratamento = idTipoTratamento;
	}

	@Transient
	public Long getIdLivro() {
		if (livro != null) {
			this.idLivro = livro.getId();
		}
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	@Transient
	public Long getIdCompromisso() {
		if (compromisso != null) {
			this.idCompromisso = compromisso.getId();
		}
		return idCompromisso;
	}

	public void setIdCompromisso(Long idCompromisso) {
		this.idCompromisso = idCompromisso;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Tratamento)) {
			return false;
		}

		final Tratamento that = (Tratamento) o;

		if (versao != that.versao) {
			return false;
		}
		if (id != null ? !id.equals(that.id) : that.id != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = (31 * result) + versao;
		return result;
	}
}
