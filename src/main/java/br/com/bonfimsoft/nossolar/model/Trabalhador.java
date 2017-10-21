package br.com.bonfimsoft.nossolar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.bonfimsoft.nossolar.enumerator.Estado;
import br.com.bonfimsoft.nossolar.enumerator.Sexo;

/**
 * Created by c090347 on 27/08/2014.
 */
@Entity
@Table(name = "tb002_trabalhador")
public class Trabalhador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private int versao;
	private String matricula;
	private String senha;
	private String nome;
	private String cracha;
	private String endereco;
	private String bairro;
	private String cidade;
	private Estado uf;
	private String cep;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String profissao;
	private Sexo sexo;
	private byte[] foto;
	private String email1;
	private String email2;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	/**/
	private List<Perfil> perfis;

	public Trabalhador() {
		this.perfis = new ArrayList<Perfil>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trabalhador")
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

	@Column(name = "co_matricula", length = 20, nullable = false)
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Column(name = "co_senha", length = 20, nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "no_trabalhador", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "no_cracha", length = 20, nullable = false)
	public String getCracha() {
		return cracha;
	}

	public void setCracha(String cracha) {
		this.cracha = cracha;
	}

	@Column(name = "ed_trabalhador", length = 255, nullable = false)
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

	@Column(name = "co_cpf", length = 11, nullable = false, unique = true)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "co_rg", length = 15, nullable = true)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "de_profissao", length = 80, nullable = false)
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ic_sexo", length = 1, nullable = false)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "im_foto", nullable = true)
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Column(name = "de_email1", length = 80, nullable = false)
	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	@Column(name = "de_email2", length = 80, nullable = true)
	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
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

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Perfil.class)
	@JoinTable(name = "tr001_trabalhador_perfil", joinColumns = { @JoinColumn(name = "id_trabalhador", referencedColumnName = "id_trabalhador") }, inverseJoinColumns = { @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil") })
	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Trabalhador))
			return false;

		Trabalhador that = (Trabalhador) o;

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

	public Trabalhador addPerfil(Perfil perfil) {
		if (this.perfis.add(perfil)) {
			return this;
		}
		throw new IllegalArgumentException(
				"TB002-001: Falha ao adicionar o perfil ao trabalhador - "
						+ perfil.toString());
	}

	public Trabalhador removePerfil(Perfil perfil) {
		if (this.perfis.remove(perfil)) {
			return this;
		}
		throw new IllegalArgumentException(
				"TB002-002: Falha ao remover o perfil do trabalhador - "
						+ perfil.toString());
	}
}
