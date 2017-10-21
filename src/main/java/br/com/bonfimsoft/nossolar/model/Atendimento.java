package br.com.bonfimsoft.nossolar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import br.com.bonfimsoft.nossolar.enumerator.SituacaoAtendimento;

/**
 * Created by c090347 on 14/09/2014.
 */
@Entity
@Table(name = "tb008_atendimento")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private Paciente paciente;
	private Date dataInicio;
	private Date dataFim;
	private SituacaoAtendimento situacaoAtendimento;
	private Integer diasAtendimento;
	private boolean tratamentoMedico;
	private boolean tratamentoPsicologico;
	private boolean tratamentoPsiquiatrico;
	private boolean evangelhoLar;
	private boolean leituraLivros;
	private boolean tratamentoEspiritual;
	private boolean usoMedicamentos;
	private String descricaoMedicamentos;
	private boolean proprio;
	private String responsavel;
	private String relacionamento;
	private String telefone;
	private String email;
	/******************************/
	private transient String[] diasSemana;
	/******************************/
	private List<Tratamento> tratamentos;
	private List<Entrevista> entrevistas;
	private List<Problema> problemas;

	public Atendimento() {
		this.diasAtendimento = 0;
		this.tratamentos = new ArrayList<Tratamento>();
		this.entrevistas = new ArrayList<Entrevista>();
		this.problemas = new ArrayList<Problema>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atendimento")
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

	@ManyToOne(targetEntity = Paciente.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente", nullable = false)
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio", nullable = false)
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim", nullable = true)
	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ic_situacao", length = 1, nullable = false)
	public SituacaoAtendimento getSituacaoAtendimento() {
		return situacaoAtendimento;
	}

	public void setSituacaoAtendimento(SituacaoAtendimento situacaoAtendimento) {
		this.situacaoAtendimento = situacaoAtendimento;
	}

	@Column(name = "ic_dias", nullable = true)
	public Integer getDiasAtendimento() {
		return diasAtendimento;
	}

	public void setDiasAtendimento(Integer diasAtendimento) {
		this.diasAtendimento = diasAtendimento;
	}

	@Column(name = "ic_tratamento_medico", nullable = true)
	public boolean isTratamentoMedico() {
		return tratamentoMedico;
	}

	public void setTratamentoMedico(boolean tratamentoMedico) {
		this.tratamentoMedico = tratamentoMedico;
	}

	@Column(name = "ic_tratamento_psicologico", nullable = true)
	public boolean isTratamentoPsicologico() {
		return tratamentoPsicologico;
	}

	public void setTratamentoPsicologico(boolean tratamentoPsicologico) {
		this.tratamentoPsicologico = tratamentoPsicologico;
	}

	@Column(name = "ic_tratamento_psiquiatrico", nullable = true)
	public boolean isTratamentoPsiquiatrico() {
		return tratamentoPsiquiatrico;
	}

	public void setTratamentoPsiquiatrico(boolean tratamentoPsiquiatrico) {
		this.tratamentoPsiquiatrico = tratamentoPsiquiatrico;
	}

	@Column(name = "ic_tratamento_espiritual", nullable = true)
	public boolean isTratamentoEspiritual() {
		return tratamentoEspiritual;
	}

	public void setTratamentoEspiritual(boolean tratamentoEspiritual) {
		this.tratamentoEspiritual = tratamentoEspiritual;
	}

	@Column(name = "ic_evangelho_lar", nullable = true)
	public boolean isEvangelhoLar() {
		return evangelhoLar;
	}

	public void setEvangelhoLar(boolean evangelhoLar) {
		this.evangelhoLar = evangelhoLar;
	}

	@Column(name = "ic_leitura_livros", nullable = true)
	public boolean isLeituraLivros() {
		return leituraLivros;
	}

	public void setLeituraLivros(boolean leituraLivros) {
		this.leituraLivros = leituraLivros;
	}

	@Column(name = "ic_uso_medicamento", nullable = true)
	public boolean isUsoMedicamentos() {
		return usoMedicamentos;
	}

	public void setUsoMedicamentos(boolean usoMedicamentos) {
		this.usoMedicamentos = usoMedicamentos;
	}

	@Column(name = "de_medicamentos", nullable = true, columnDefinition = "text")
	@Basic(fetch = FetchType.LAZY)
	public String getDescricaoMedicamentos() {
		return descricaoMedicamentos;
	}

	public void setDescricaoMedicamentos(String descricaoMedicamentos) {
		this.descricaoMedicamentos = descricaoMedicamentos;
	}

	@Column(name = "ic_proprio", nullable = false)
	public boolean isProprio() {
		return proprio;
	}

	public void setProprio(boolean proprio) {
		this.proprio = proprio;
	}

	@Column(name = "no_responsavel", length = 80, nullable = true)
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@Column(name = "no_relacionamento", length = 40, nullable = true)
	public String getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}

	@Column(name = "de_telefone", length = 20, nullable = true)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "de_email", length = 80, nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public String[] getDiasSemana() {
		Integer valor = diasAtendimento;
		Integer indice = 0;
		Integer resultado = 1;

		while (resultado <= valor) {
			resultado = (int) Math.pow(2, ++indice);
		}
		final ArrayList<String> dias = new ArrayList<String>();
		do {
			resultado = (int) Math.pow(2, --indice);
			if (resultado <= valor) {
				valor -= resultado;
				dias.add(String.valueOf(resultado));
			}
		} while (valor > 0);
		diasSemana = new String[dias.size()];
		diasSemana = dias.toArray(diasSemana);
		return diasSemana;
	}

	public void setDiasSemana(String[] diasSemana) {
		Integer resultado = 0;
		if (diasSemana != null) {
			for (final String dia : diasSemana) {
				resultado += Integer.valueOf(dia);
			}
			this.diasAtendimento = resultado;
		}
		this.diasSemana = diasSemana;
	}

	@OneToMany(targetEntity = Tratamento.class, fetch = FetchType.LAZY, mappedBy = "atendimento", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	public List<Tratamento> getTratamentos() {
		return this.tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public List<Tratamento> addTratamento(Tratamento tratamento) {
		if (this.tratamentos.add(tratamento)) {
			return this.tratamentos;
		}
		throw new IllegalArgumentException("TB008-001: Falha ao adicionar o tratamento ao atendimento - " + tratamento.toString());
	}

	public List<Tratamento> removeTratamento(Tratamento tratamento) {
		if (this.tratamentos.remove(tratamento)) {
			return this.tratamentos;
		}
		throw new IllegalArgumentException("TB008-002: Falha ao remover o tratamento do atendimento - " + tratamento.toString());
	}

	@OneToMany(targetEntity = Entrevista.class, fetch = FetchType.LAZY, mappedBy = "atendimento", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	public List<Entrevista> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(List<Entrevista> entrevistas) {
		this.entrevistas = entrevistas;
	}

	public List<Entrevista> addEntrevista(Entrevista entrevista) {
		if (this.entrevistas.add(entrevista)) {
			return this.entrevistas;
		}
		throw new IllegalArgumentException("TB008-003: Falha ao adicionar a entrevista ao atendimento - " + entrevista.toString());
	}

	public List<Entrevista> removeEntrevista(Entrevista entrevista) {
		if (this.entrevistas.remove(entrevista)) {
			return this.entrevistas;
		}
		throw new IllegalArgumentException("TB008-004: Falha ao remover a entrevista do atendimento - " + entrevista.toString());
	}

	@OneToMany(targetEntity = Problema.class, fetch = FetchType.LAZY, mappedBy = "atendimento", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
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
		throw new IllegalArgumentException("TB010-001: Falha ao adicionar o problema ao atendimento- " + problema.toString());
	}

	public List<Problema> removeProblema(Problema problema) {
		if (this.problemas.remove(problema)) {
			return this.problemas;
		}
		throw new IllegalArgumentException("TB010-002: Falha ao remover o problema do atendimento - " + problema.toString());
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Atendimento)) {
			return false;
		}

		final Atendimento that = (Atendimento) o;

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
