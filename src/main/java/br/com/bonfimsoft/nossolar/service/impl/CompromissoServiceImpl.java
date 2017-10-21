package br.com.bonfimsoft.nossolar.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.model.Compromisso;
import br.com.bonfimsoft.nossolar.repositories.CompromissoRepository;
import br.com.bonfimsoft.nossolar.service.CompromissoService;

@Transactional
public class CompromissoServiceImpl implements CompromissoService {

	@Inject
	private CompromissoRepository compromissoRepository;

	private static final Logger logger = LoggerFactory.getLogger(CompromissoServiceImpl.class);

	public void setCompromissoRepository(CompromissoRepository compromissoRepository) {
		this.compromissoRepository = compromissoRepository;
	}

	@Override
	public void save(Compromisso compromisso) {
		logger.info("Salvando compromisso...");
		if (compromisso.getId() != null) {
			final Compromisso compromissoPersistido = this.compromissoRepository.findOne(compromisso.getId());
			compromisso = this.atualizaDadosCompromissoPersistido(compromisso, compromissoPersistido);
		}

		this.compromissoRepository.save(compromisso);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Compromisso compromisso) {
		return compromissoRepository.exists(compromisso.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Compromisso findOne(Long id) {
		return compromissoRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Compromisso> findAll() {
		return compromissoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return compromissoRepository.count();
	}

	@Override
	public void delete(Compromisso compromisso) {
		compromissoRepository.delete(compromisso);
	}

	@Override
	public void delete(Long id) {
		compromissoRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Compromisso> compromisso) {
		compromissoRepository.delete(compromisso);
	}

	@Override
	public void deleteAll() {
		compromissoRepository.deleteAll();
	}

	private Compromisso atualizaDadosCompromissoPersistido(Compromisso compromissoNovo, Compromisso compromissoPersistido) {

		compromissoPersistido.setNome(compromissoNovo.getNome());

		return compromissoPersistido;
	}

}
