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
@Table(name = "tb011_problema")
public class Problema implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer versao;
	private Atendimento atendimento;
	private TipoProblema tipoProblema;
	private String detalheProblema;
	private String observacao;
	private int escala;
	private Date dataRegistro;
	/******************************/
	private transient Long idTipoProblema;
	/******************************/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_problema")
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

	@ManyToOne(targetEntity = Atendimento.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_atendimento", nullable = false)
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	@ManyToOne(targetEntity = TipoProblema.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_problema", nullable = false)
	public TipoProblema getTipoProblema() {
		return tipoProblema;
	}

	public void setTipoProblema(TipoProblema tipoProblema) {
		this.tipoProblema = tipoProblema;
	}

	@Column(name = "de_problema", length = 255, nullable = true)
	public String getDetalheProblema() {
		return detalheProblema;
	}

	public void setDetalheProblema(String detalheProblema) {
		this.detalheProblema = detalheProblema;
	}

	@Column(name = "de_observacao", nullable = true, columnDefinition = "text")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "vr_escala", nullable = false)
	public int getEscala() {
		return escala;
	}

	public void setEscala(int escala) {
		this.escala = escala;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_registro", nullable = true)
	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Transient
	public Long getIdTipoProblema() {
		if (tipoProblema != null) {
			this.idTipoProblema = tipoProblema.getId();
		}
		return idTipoProblema;
	}

	public void setIdTipoProblema(Long idTipoProblema) {
		this.idTipoProblema = idTipoProblema;
	}

}
