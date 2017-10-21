package br.com.bonfimsoft.nossolar.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.model.Trabalhador;
import br.com.bonfimsoft.nossolar.repositories.TrabalhadorRepository;
import br.com.bonfimsoft.nossolar.service.TrabalhadorService;

@Transactional
public class TrabalhadorServiceImpl implements TrabalhadorService {

	@Inject
	private TrabalhadorRepository trabalhadorRepository;

	private static final Logger logger = LoggerFactory
			.getLogger(TrabalhadorServiceImpl.class);

	public void setTrabalhadorRepository(
			TrabalhadorRepository trabalhadorRepository) {
		this.trabalhadorRepository = trabalhadorRepository;
	}

	@Override
	public void save(Trabalhador trabalhador) {
		logger.info("Salvando paciente...");
		if (trabalhador.getId() != null) {
			Trabalhador trabalhadorPersistido = this.trabalhadorRepository
					.findOne(trabalhador.getId());
			trabalhador = this.atualizaDadosPacientePersistido(trabalhador,
					trabalhadorPersistido);
		}
		this.trabalhadorRepository.save(trabalhador);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Trabalhador trabalhador) {
		return trabalhadorRepository.exists(trabalhador.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Trabalhador findOne(Long id) {
		return trabalhadorRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Trabalhador> findAll() {
		return trabalhadorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Trabalhador> findAllOrderByNomeAsc() {
		return trabalhadorRepository.findAllOrderByNomeAsc();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return trabalhadorRepository.count();
	}

	@Override
	public void delete(Trabalhador trabalhador) {
		trabalhadorRepository.delete(trabalhador);
	}

	@Override
	public void delete(Long id) {
		trabalhadorRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Trabalhador> trabalhadores) {
		trabalhadorRepository.delete(trabalhadores);
	}

	@Override
	public void deleteAll() {
		trabalhadorRepository.deleteAll();
	}

	private Trabalhador atualizaDadosPacientePersistido(
			Trabalhador trabalhadorNovo, Trabalhador trabalhadorPersistido) {
		trabalhadorPersistido.setBairro(trabalhadorNovo.getBairro());
		trabalhadorPersistido.setCep(trabalhadorNovo.getCep());
		trabalhadorPersistido.setCidade(trabalhadorNovo.getCidade());
		trabalhadorPersistido.setCpf(trabalhadorNovo.getCpf());
		trabalhadorPersistido.setCracha(trabalhadorNovo.getCracha());
		trabalhadorPersistido.setDataNascimento(trabalhadorNovo
				.getDataNascimento());
		trabalhadorPersistido.setEmail1(trabalhadorNovo.getEmail1());
		trabalhadorPersistido.setEmail2(trabalhadorNovo.getEmail2());
		trabalhadorPersistido.setEndereco(trabalhadorNovo.getEndereco());
		if (trabalhadorNovo.getFoto() != null) {
			trabalhadorPersistido.setFoto(trabalhadorNovo.getFoto());
		}
		trabalhadorPersistido.setMatricula(trabalhadorNovo.getMatricula());
		trabalhadorPersistido.setNome(trabalhadorNovo.getNome());
		trabalhadorPersistido.setProfissao(trabalhadorNovo.getProfissao());
		trabalhadorPersistido.setRg(trabalhadorNovo.getRg());
		if ((trabalhadorNovo.getSenha() != null) && (!trabalhadorNovo.getSenha().equals(""))) {
			trabalhadorPersistido.setSenha(trabalhadorNovo.getSenha());
		}
		trabalhadorPersistido.setSexo(trabalhadorNovo.getSexo());
		trabalhadorPersistido.setTelefone1(trabalhadorNovo.getTelefone1());
		trabalhadorPersistido.setTelefone2(trabalhadorNovo.getTelefone2());
		trabalhadorPersistido.setTelefone3(trabalhadorNovo.getTelefone3());
		trabalhadorPersistido.setUf(trabalhadorNovo.getUf());

		return trabalhadorPersistido;
	}

	@Override
	public Trabalhador findByMatricula(String cracha) {
		return this.trabalhadorRepository.findByMatricula(cracha);
	}

}
