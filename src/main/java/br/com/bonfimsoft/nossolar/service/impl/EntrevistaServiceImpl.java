package br.com.bonfimsoft.nossolar.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.controller.PacienteController;
import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Entrevista;
import br.com.bonfimsoft.nossolar.repositories.EntrevistaRepository;
import br.com.bonfimsoft.nossolar.service.EntrevistaService;

@Transactional
public class EntrevistaServiceImpl implements EntrevistaService {

	@Inject
	private EntrevistaRepository entrevistaRepository;

	private static final Logger logger = LoggerFactory
			.getLogger(PacienteController.class);

	public void setEntrevistaRepository(
			EntrevistaRepository entrevistaRepository) {
		this.entrevistaRepository = entrevistaRepository;
	}

	@Override
	public void save(Entrevista entrevista) {
		logger.info("Salvando entrevista...");
		if (entrevista.getId() != null) {
			final Entrevista entrevistaPersistido = this.entrevistaRepository
					.findOne(entrevista.getId());
			entrevista = this.atualizaDadosEntrevistaPersistido(entrevista,
					entrevistaPersistido);
		}

		this.entrevistaRepository.save(entrevista);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Entrevista entrevista) {
		return entrevistaRepository.exists(entrevista.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Entrevista findOne(Long id) {
		return entrevistaRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Entrevista> findByAtendimento(Atendimento atendimento){
		return entrevistaRepository.findAllByAtendimentoOrderByIdAsc(atendimento);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Entrevista> findAll() {
		return entrevistaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return entrevistaRepository.count();
	}

	@Override
	public void delete(Entrevista entrevista) {
		entrevistaRepository.delete(entrevista);
	}

	@Override
	public void delete(Long id) {
		entrevistaRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Entrevista> entrevista) {
		entrevistaRepository.delete(entrevista);
	}

	@Override
	public void deleteAll() {
		entrevistaRepository.deleteAll();
	}

	private Entrevista atualizaDadosEntrevistaPersistido(
			Entrevista entrevistaNovo, Entrevista entrevistaPersistido) {

		entrevistaPersistido.setApresentaMelhoras(entrevistaNovo.isApresentaMelhoras());
		entrevistaPersistido.setDataEntrevista(entrevistaNovo.getDataEntrevista());
		entrevistaPersistido.setEntrevistador(entrevistaNovo.getEntrevistador());
		entrevistaPersistido.setObservacao(entrevistaNovo.getObservacao());
		entrevistaPersistido.setTipoEntrevista(entrevistaNovo.getTipoEntrevista());

		return entrevistaPersistido;
	}

}
