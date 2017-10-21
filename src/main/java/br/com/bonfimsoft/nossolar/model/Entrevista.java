package br.com.bonfimsoft.nossolar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import br.com.bonfimsoft.nossolar.enumerator.TipoEntrevista;

/**
 * Created by c090347 on 14/09/2014.
 */
@Entity
@Table(name = "tb010_entrevista")
public class Entrevista implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private Atendimento atendimento;
	private Date dataEntrevista;
	private String entrevistador;
	private TipoEntrevista tipoEntrevista;
	private String observacao;
	private boolean apresentaMelhoras;

	public Entrevista() {
		this.tipoEntrevista = TipoEntrevista.I;
		this.apresentaMelhoras = false;
		this.dataEntrevista = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_entrevista")
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

	@ManyToOne(targetEntity = Atendimento.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_atendimento", nullable = false)
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_entrevista", nullable = false)
	public Date getDataEntrevista() {
		return dataEntrevista;
	}

	public void setDataEntrevista(Date dataEntrevista) {
		this.dataEntrevista = dataEntrevista;
	}

	@Column(name = "no_entrevistador", length = 80, nullable = false)
	public String getEntrevistador() {
		return entrevistador;
	}

	public void setEntrevistador(String entrevistador) {
		this.entrevistador = entrevistador;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ic_tipo_entrevista", length = 1, nullable = false)
	public TipoEntrevista getTipoEntrevista() {
		return tipoEntrevista;
	}

	public void setTipoEntrevista(TipoEntrevista tipoEntrevista) {
		this.tipoEntrevista = tipoEntrevista;
	}

	@Column(name = "de_observacao", nullable = true, columnDefinition = "text")
	@Basic(fetch = FetchType.LAZY)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "ic_apresenta_melhoras", nullable = false)
	public boolean isApresentaMelhoras() {
		return apresentaMelhoras;
	}

	public void setApresentaMelhoras(boolean apresentaMelhoras) {
		this.apresentaMelhoras = apresentaMelhoras;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Entrevista)) {
			return false;
		}

		final Entrevista that = (Entrevista) o;

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
