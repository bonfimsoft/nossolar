package br.com.bonfimsoft.nossolar.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.controller.PacienteController;
import br.com.bonfimsoft.nossolar.model.Paciente;
import br.com.bonfimsoft.nossolar.repositories.PacienteRepository;
import br.com.bonfimsoft.nossolar.service.PacienteService;

@Transactional
public class PacienteServiceImpl implements PacienteService {

	@Inject
	private PacienteRepository pacienteRepository;

	private static final Logger logger = LoggerFactory
			.getLogger(PacienteController.class);

	public void setPacienteRepository(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	@Override
	public void save(Paciente paciente) {
		logger.info("Salvando paciente...");
		if (paciente.getId() != null) {
			final Paciente pacientePersistido = this.pacienteRepository
					.findOne(paciente.getId());
			paciente = this.atualizaDadosPacientePersistido(paciente,
					pacientePersistido);
		}

		this.pacienteRepository.save(paciente);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Paciente paciente) {
		return pacienteRepository.exists(paciente.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente findOne(Long id) {
		return pacienteRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> findAllOrderByNomeAsc() {
		return pacienteRepository.findAllOrderByNomeAsc();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return pacienteRepository.count();
	}

	@Override
	public void delete(Paciente paciente) {
		pacienteRepository.delete(paciente);
	}

	@Override
	public void delete(Long id) {
		pacienteRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Paciente> pacientes) {
		pacienteRepository.delete(pacientes);
	}

	@Override
	public void deleteAll() {
		pacienteRepository.deleteAll();
	}

	private Paciente atualizaDadosPacientePersistido(Paciente pacienteNovo,
			Paciente pacientePersistido) {
		pacientePersistido.setBairro(pacienteNovo.getBairro());
		pacientePersistido.setCep(pacienteNovo.getCep());
		pacientePersistido.setCidade(pacienteNovo.getCidade());
		pacientePersistido.setDataNascimento(pacienteNovo.getDataNascimento());
		pacientePersistido.setEmail(pacienteNovo.getEmail());
		pacientePersistido.setEndereco(pacienteNovo.getEndereco());
		pacientePersistido.setNome(pacienteNovo.getNome());
		pacientePersistido.setProfissao(pacienteNovo.getProfissao());
		pacientePersistido.setReligiao(pacienteNovo.getReligiao());
		pacientePersistido.setSexo(pacienteNovo.getSexo());
		pacientePersistido.setTelefone1(pacienteNovo.getTelefone1());
		pacientePersistido.setTelefone2(pacienteNovo.getTelefone2());
		pacientePersistido.setTelefone3(pacienteNovo.getTelefone3());
		pacientePersistido.setUf(pacienteNovo.getUf());

		return pacientePersistido;
	}

}
