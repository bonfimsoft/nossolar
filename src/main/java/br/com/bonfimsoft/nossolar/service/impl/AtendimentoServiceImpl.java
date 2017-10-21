package br.com.bonfimsoft.nossolar.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.controller.PacienteController;
import br.com.bonfimsoft.nossolar.enumerator.SituacaoAtendimento;
import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.repositories.AtendimentoRepository;
import br.com.bonfimsoft.nossolar.service.AtendimentoService;

@Transactional
public class AtendimentoServiceImpl implements AtendimentoService {

	@Inject
	private AtendimentoRepository atendimentoRepository;

	private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

	public void setAtendimentoRepository(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}

	@Override
	public void save(Atendimento atendimento) {
		logger.info("Salvando atendimento...");
		if (atendimento.getId() != null) {
			final Atendimento atendimentoPersistido = this.atendimentoRepository.findOne(atendimento.getId());
			atendimento = this.atualizaDadosAtendimentoPersistido(atendimento, atendimentoPersistido);
		}
		
		this.atendimentoRepository.save(atendimento);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Atendimento atendimento) {
		return atendimentoRepository.exists(atendimento.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Atendimento findOne(Long id) {
		return atendimentoRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Atendimento> findAll() {
		return atendimentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return atendimentoRepository.count();
	}

	@Override
	public void delete(Atendimento atendimento) {
		atendimentoRepository.delete(atendimento);
	}

	@Override
	public void delete(Long id) {
		atendimentoRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Atendimento> atendimentos) {
		atendimentoRepository.delete(atendimentos);
	}

	@Override
	public void deleteAll() {
		atendimentoRepository.deleteAll();
	}

	private Atendimento atualizaDadosAtendimentoPersistido(Atendimento atendimentoNovo, Atendimento atendimentoPersistido) {

		boolean atendimentoFinalizado = SituacaoAtendimento.C.equals(atendimentoNovo.getSituacaoAtendimento()) || SituacaoAtendimento.I.equals(atendimentoNovo.getSituacaoAtendimento());

		atendimentoPersistido.setDataFim(atendimentoFinalizado ? new Date() : null);
		atendimentoPersistido.setDataInicio(atendimentoNovo.getDataInicio());
		atendimentoPersistido.setDescricaoMedicamentos(atendimentoNovo.getDescricaoMedicamentos());
		atendimentoPersistido.setDiasAtendimento(atendimentoNovo.getDiasAtendimento());
		atendimentoPersistido.setDiasSemana(atendimentoNovo.getDiasSemana());
		atendimentoPersistido.setEmail(atendimentoNovo.getEmail());
		// atendimentoPersistido.setEntrevistas(atendimentoNovo.getEntrevistas());
		atendimentoPersistido.setEvangelhoLar(atendimentoNovo.isEvangelhoLar());
		atendimentoPersistido.setLeituraLivros(atendimentoNovo.isLeituraLivros());
		// atendimentoPersistido.setPaciente(atendimentoNovo.getPaciente());
		atendimentoPersistido.setProprio(atendimentoNovo.isProprio());
		atendimentoPersistido.setRelacionamento(atendimentoNovo.getRelacionamento());
		atendimentoPersistido.setResponsavel(atendimentoNovo.getResponsavel());
		atendimentoPersistido.setSituacaoAtendimento(atendimentoNovo.getSituacaoAtendimento());
		atendimentoPersistido.setTelefone(atendimentoNovo.getTelefone());
		atendimentoPersistido.setTratamentoEspiritual(atendimentoNovo.isTratamentoEspiritual());
		atendimentoPersistido.setTratamentoMedico(atendimentoNovo.isTratamentoMedico());
		atendimentoPersistido.setTratamentoPsicologico(atendimentoNovo.isTratamentoPsicologico());
		atendimentoPersistido.setTratamentoPsiquiatrico(atendimentoNovo.isTratamentoPsiquiatrico());
		// atendimentoPersistido.setTratamentos(atendimentoNovo.getTratamentos());
		atendimentoPersistido.setUsoMedicamentos(atendimentoNovo.isUsoMedicamentos());

		return atendimentoPersistido;
	}

}
