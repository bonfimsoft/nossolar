package br.com.bonfimsoft.nossolar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.bonfimsoft.nossolar.enumerator.Estado;
import br.com.bonfimsoft.nossolar.enumerator.Sexo;

/**
 * Created by c090347 on 05/09/2014.
 */
@Entity
@Table(name = "tb003_paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private String nome;
	private String endereco;
	private String bairro;
	private String cidade;
	private Estado uf;
	private String cep;
	private Date dataNascimento;
	private Sexo sexo;
	private String religiao;
	private String profissao;
	private String email;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	/******************************/
	private List<Atendimento> atendimentos;

	public Paciente() {
		this.atendimentos = new ArrayList<Atendimento>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
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

	@Column(name = "no_paciente", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "ed_paciente", length = 255, nullable = false)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "no_bairro", length = 80, nullable = false)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "no_cidade", length = 80, nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Enumerated(EnumType.STRING)
	@Convert(converter = Estado.class)
	@Column(name = "sg_uf", length = 2, nullable = false)
	public Estado getUf() {
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	@Column(name = "co_cep", length = 8, nullable = true)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dt_nascimento", nullable = false)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ic_sexo", length = 1, nullable = false)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Column(name = "de_religiao", length = 80, nullable = true)
	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	@Column(name = "de_profissao", length = 80, nullable = false)
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Column(name = "de_email", length = 80, nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "de_telefone1", length = 20, nullable = false)
	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	@Column(name = "de_telefone2", length = 20, nullable = true)
	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	@Column(name = "de_telefone3", length = 20, nullable = true)
	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	@OneToMany(targetEntity = Atendimento.class, fetch = FetchType.LAZY, mappedBy = "paciente", cascade = { CascadeType.REMOVE })
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public List<Atendimento> addAtendimento(Atendimento atendimento) {
		if (this.atendimentos.add(atendimento)) {
			return atendimentos;
		}
		throw new IllegalArgumentException("TB003-001: Falha ao adicionar o atendimento ao paciente - " + atendimento.toString());
	}

	public List<Atendimento> removeAtendimento(Atendimento atendimento) {
		if (this.atendimentos.remove(atendimento)) {
			return atendimentos;
		}
		throw new IllegalArgumentException("TB003-002: Falha ao remover o atendimento do paciente - " + atendimento.toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Paciente))
			return false;

		Paciente paciente = (Paciente) o;

		if (versao != paciente.versao)
			return false;
		if (id != null ? !id.equals(paciente.id) : paciente.id != null)
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
