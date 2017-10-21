package br.com.bonfimsoft.nossolar.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.controller.PacienteController;
import br.com.bonfimsoft.nossolar.model.TipoProblema;
import br.com.bonfimsoft.nossolar.repositories.TipoProblemaRepository;
import br.com.bonfimsoft.nossolar.service.TipoProblemaService;

@Transactional
public class TipoProblemaServiceImpl implements TipoProblemaService {

	@Inject
	private TipoProblemaRepository tipoProblemaRepository;

	private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

	public void setTipoProblemaRepository(TipoProblemaRepository tipoProblemaRepository) {
		this.tipoProblemaRepository = tipoProblemaRepository;
	}

	@Override
	public void save(TipoProblema tipoProblema) {
		logger.info("Salvando entrevista...");
		if (tipoProblema.getId() != null) {
			final TipoProblema tipoProblemaPersistido = this.tipoProblemaRepository.findOne(tipoProblema.getId());
			tipoProblema = this.atualizaDadosTipoProblemaPersistido(tipoProblema, tipoProblemaPersistido);
		}

		this.tipoProblemaRepository.save(tipoProblema);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(TipoProblema tipoProblema) {
		return tipoProblemaRepository.exists(tipoProblema.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public TipoProblema findOne(Long id) {
		return tipoProblemaRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoProblema> findAll() {
		return tipoProblemaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return tipoProblemaRepository.count();
	}

	@Override
	public void delete(TipoProblema tipoProblema) {
		tipoProblemaRepository.delete(tipoProblema);
	}

	@Override
	public void delete(Long id) {
		tipoProblemaRepository.delete(id);
	}

	@Override
	public void delete(Iterable<TipoProblema> tipoProblema) {
		tipoProblemaRepository.delete(tipoProblema);
	}

	@Override
	public void deleteAll() {
		tipoProblemaRepository.deleteAll();
	}

	private TipoProblema atualizaDadosTipoProblemaPersistido(TipoProblema tipoProblemaNovo, TipoProblema tipoProblemaPersistido) {

		tipoProblemaPersistido.setAberto(tipoProblemaNovo.isAberto());
		tipoProblemaPersistido.setNome(tipoProblemaNovo.getNome());

		return tipoProblemaPersistido;
	}

}
