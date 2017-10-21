package br.com.bonfimsoft.nossolar.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.controller.PacienteController;
import br.com.bonfimsoft.nossolar.model.TipoTratamento;
import br.com.bonfimsoft.nossolar.repositories.TipoTratamentoRepository;
import br.com.bonfimsoft.nossolar.service.TipoTratamentoService;

@Transactional
public class TipoTratamentoServiceImpl implements TipoTratamentoService {

	@Inject
	private TipoTratamentoRepository tipoTratamentoRepository;

	private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

	public void setTipoTratamentoRepository(TipoTratamentoRepository tipoTratamentoRepository) {
		this.tipoTratamentoRepository = tipoTratamentoRepository;
	}

	@Override
	public void save(TipoTratamento tipoTratamento) {
		logger.info("Salvando entrevista...");
		if (tipoTratamento.getId() != null) {
			final TipoTratamento tipoTratamentoPersistido = this.tipoTratamentoRepository.findOne(tipoTratamento.getId());
			tipoTratamento = this.atualizaDadosTipoTratamentoPersistido(tipoTratamento, tipoTratamentoPersistido);
		}

		this.tipoTratamentoRepository.save(tipoTratamento);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(TipoTratamento tipoTratamento) {
		return tipoTratamentoRepository.exists(tipoTratamento.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public TipoTratamento findOne(Long id) {
		return tipoTratamentoRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoTratamento> findAll() {
		return tipoTratamentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return tipoTratamentoRepository.count();
	}

	@Override
	public void delete(TipoTratamento tipoTratamento) {
		tipoTratamentoRepository.delete(tipoTratamento);
	}

	@Override
	public void delete(Long id) {
		tipoTratamentoRepository.delete(id);
	}

	@Override
	public void delete(Iterable<TipoTratamento> tipoTratamento) {
		tipoTratamentoRepository.delete(tipoTratamento);
	}

	@Override
	public void deleteAll() {
		tipoTratamentoRepository.deleteAll();
	}

	private TipoTratamento atualizaDadosTipoTratamentoPersistido(TipoTratamento tipoTratamentoNovo, TipoTratamento tipoTratamentoPersistido) {

		tipoTratamentoPersistido.setFormatoTratamento(tipoTratamentoNovo.getFormatoTratamento());
		tipoTratamentoPersistido.setNome(tipoTratamentoNovo.getNome());

		return tipoTratamentoPersistido;
	}

}
