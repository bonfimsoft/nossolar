package br.com.bonfimsoft.nossolar.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Problema;
import br.com.bonfimsoft.nossolar.repositories.ProblemaRepository;
import br.com.bonfimsoft.nossolar.repositories.TipoProblemaRepository;
import br.com.bonfimsoft.nossolar.service.ProblemaService;

@Transactional
public class ProblemaServiceImpl implements ProblemaService {

	@Inject
	private ProblemaRepository problemaRepository;
	@Inject
	private TipoProblemaRepository tipoProblemaRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProblemaServiceImpl.class);

	public void setProblemaRepository(ProblemaRepository problemaRepository) {
		this.problemaRepository = problemaRepository;
	}

	public void setTipoProblemaRepository(TipoProblemaRepository tipoProblemaRepository) {
		this.tipoProblemaRepository = tipoProblemaRepository;
	}

	@Override
	public void save(Problema problema) {
		logger.info("Salvando problema...");
		final long idTipoProblema = problema.getIdTipoProblema();

		if (problema.getId() != null) {
			final Problema problemaPersistido = this.problemaRepository.findOne(problema.getId());
			problema = this.atualizaDadosProblemaPersistido(problema, problemaPersistido);
		}

		problema.setDataRegistro(new Date());
		problema.setTipoProblema(tipoProblemaRepository.findOne(idTipoProblema));
		this.problemaRepository.save(problema);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Problema problema) {
		return problemaRepository.exists(problema.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Problema findOne(Long id) {
		return problemaRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Problema> findByAtendimento(Atendimento atendimento) {
		return problemaRepository.findAllByAtendimentoOrderByIdAsc(atendimento);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Problema> findAll() {
		return problemaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return problemaRepository.count();
	}

	@Override
	public void delete(Problema problema) {
		problemaRepository.delete(problema);
	}

	@Override
	public void delete(Long id) {
		problemaRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Problema> problema) {
		problemaRepository.delete(problema);
	}

	@Override
	public void deleteAll() {
		problemaRepository.deleteAll();
	}

	private Problema atualizaDadosProblemaPersistido(Problema problemaNovo, Problema problemaPersistido) {

		problemaPersistido.setDetalheProblema(problemaNovo.getDetalheProblema());
		problemaPersistido.setEscala(problemaNovo.getEscala());
		problemaPersistido.setObservacao(problemaNovo.getObservacao());
		problemaPersistido.setIdTipoProblema(problemaNovo.getIdTipoProblema());

		return problemaPersistido;
	}

}
