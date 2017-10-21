package br.com.bonfimsoft.nossolar.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.controller.PacienteController;
import br.com.bonfimsoft.nossolar.enumerator.FormatoTratamento;
import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Compromisso;
import br.com.bonfimsoft.nossolar.model.Livro;
import br.com.bonfimsoft.nossolar.model.TipoTratamento;
import br.com.bonfimsoft.nossolar.model.Tratamento;
import br.com.bonfimsoft.nossolar.repositories.CompromissoRepository;
import br.com.bonfimsoft.nossolar.repositories.FeriadoRepository;
import br.com.bonfimsoft.nossolar.repositories.LivroRepository;
import br.com.bonfimsoft.nossolar.repositories.TipoTratamentoRepository;
import br.com.bonfimsoft.nossolar.repositories.TratamentoRepository;
import br.com.bonfimsoft.nossolar.service.TratamentoService;

@Transactional
public class TratamentoServiceImpl implements TratamentoService {

	@Inject
	private TratamentoRepository tratamentoRepository;

	@Inject
	private TipoTratamentoRepository tipoTratamentoRepository;

	@Inject
	private LivroRepository livroRepository;

	@Inject
	private CompromissoRepository compromissoRepository;

	@Inject
	private FeriadoRepository feriadoRepository;

	private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

	public void setTratamentoRepository(TratamentoRepository tratamentoRepository) {
		this.tratamentoRepository = tratamentoRepository;
	}

	public void setTipoTratamentoRepository(TipoTratamentoRepository tipoTratamentoRepository) {
		this.tipoTratamentoRepository = tipoTratamentoRepository;
	}

	public void setLivroRepository(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public void setCompromissoRepository(CompromissoRepository compromissoRepository) {
		this.compromissoRepository = compromissoRepository;
	}

	public void setFeriadoRepository(FeriadoRepository feriadoRepository) {
		this.feriadoRepository = feriadoRepository;
	}

	@Override
	public void save(Tratamento tratamento) {
		logger.info("Salvando tratamento...");
		if (tratamento.getId() != null) {
			final Tratamento tratamentoPersistido = this.tratamentoRepository.findOne(tratamento.getId());
			tratamento = this.atualizaDadosTratamentoPersistido(tratamento, tratamentoPersistido);
		} else {
			tratamento = this.ajustaDadosTratamentoNovo(tratamento);
		}

		tratamento.setDataRegistro(new Date());
		this.tratamentoRepository.save(tratamento);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Tratamento tratamento) {
		return tratamentoRepository.exists(tratamento.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Tratamento findOne(Long id) {
		return tratamentoRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Tratamento> findByAtendimento(Atendimento atendimento) {
		return tratamentoRepository.findAllByAtendimentoOrderByTipoTratamentoAscDataRegistroAscDataPasseAsc(atendimento);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Tratamento> findAll() {
		return tratamentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoTratamento> listTiposTratamento() {
		return tipoTratamentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Livro> listLivros() {
		return livroRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Compromisso> listCompromissos() {
		return compromissoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return tratamentoRepository.count();
	}

	@Override
	public void delete(Tratamento tratamento) {
		tratamentoRepository.delete(tratamento);
	}

	@Override
	public void delete(Long id) {
		tratamentoRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Tratamento> tratamento) {
		tratamentoRepository.delete(tratamento);
	}

	@Override
	public void deleteAll() {
		tratamentoRepository.deleteAll();
	}

	private Tratamento atualizaDadosTratamentoPersistido(Tratamento tratamentoNovo, Tratamento tratamentoPersistido) {

		final TipoTratamento tipoTratamento = tipoTratamentoRepository.findOne(tratamentoNovo.getIdTipoTratamento());
		if (tipoTratamento.getFormatoTratamento().equals(FormatoTratamento.C)) {
			tratamentoPersistido.setCompromisso(compromissoRepository.findOne(tratamentoNovo.getIdCompromisso()));
		} else if (tipoTratamento.getFormatoTratamento().equals(FormatoTratamento.L)) {
			tratamentoPersistido.setLivro(livroRepository.findOne(tratamentoNovo.getIdLivro()));
		} else if (tipoTratamento.getFormatoTratamento().equals(FormatoTratamento.P)) {
			tratamentoPersistido.setDataPasse(tratamentoNovo.getDataPasse());
			tratamentoPersistido.setRealizado(tratamentoNovo.getRealizado());
			tratamentoPersistido.setRemarcado(tratamentoNovo.getRemarcado());
		}
		tratamentoPersistido.setTipoTratamento(tipoTratamento);

		return tratamentoPersistido;
	}

	private Tratamento ajustaDadosTratamentoNovo(Tratamento tratamento) {

		final TipoTratamento tipoTratamento = tipoTratamentoRepository.findOne(tratamento.getIdTipoTratamento());
		if (tipoTratamento.getFormatoTratamento().equals(FormatoTratamento.C)) {
			tratamento.setCompromisso(compromissoRepository.findOne(tratamento.getIdCompromisso()));
			tratamento.setRealizado(null);
			tratamento.setRemarcado(null);
		} else if (tipoTratamento.getFormatoTratamento().equals(FormatoTratamento.L)) {
			tratamento.setLivro(livroRepository.findOne(tratamento.getIdLivro()));
			tratamento.setRealizado(null);
			tratamento.setRemarcado(null);
		}
		tratamento.setTipoTratamento(tipoTratamento);

		return tratamento;
	}

	@Override
	public List<Tratamento> geraPassesQuantidade(Atendimento atendimento, Tratamento tratamento, int quantidade) {
		final List<Tratamento> tratamentosIncluidos = new ArrayList<Tratamento>();
		final String[] diasSemana = atendimento.getDiasSemana();
		int quantidadeIncluidos = 0;
		final Calendar dataConsulta = Calendar.getInstance();
		do {
			for (int i = 0; i < diasSemana.length; i++) {
				if (Math.pow(2, dataConsulta.get(Calendar.DAY_OF_WEEK) - 1) == Double.valueOf(diasSemana[i])) {

					final boolean encontrouFeriado = feriadoRepository.findByData(dataConsulta.getTime()) == null ? false : true;
					boolean encontrouPersistido = false;
					boolean encontrouNovo = false;

					if (atendimento.getId() != null) {
						encontrouPersistido = tratamentoRepository.findByAtendimentoAndDataPasse(atendimento, dataConsulta.getTime()) == null ? false : true;
					}
					if (atendimento.getId() == null) {
						dataConsulta.set(Calendar.HOUR, 0);
						dataConsulta.set(Calendar.MINUTE, 0);
						dataConsulta.set(Calendar.SECOND, 0);
						dataConsulta.set(Calendar.MILLISECOND, 0);
						for (final Tratamento trat : atendimento.getTratamentos()) {
							if (FormatoTratamento.P.equals(trat.getTipoTratamento().getFormatoTratamento())) {
								final Calendar dataPasse = Calendar.getInstance();
								dataPasse.setTime(trat.getDataPasse());
								dataPasse.set(Calendar.HOUR, 0);
								dataPasse.set(Calendar.MINUTE, 0);
								dataPasse.set(Calendar.SECOND, 0);
								dataPasse.set(Calendar.MILLISECOND, 0);
								if (dataConsulta.compareTo(dataPasse) == 0) {
									encontrouNovo = true;
									break;
								}
							}
						}
					}

					// ACHOU O DIA DA SEMANA
					if ((!encontrouFeriado) && (!encontrouNovo) && (!encontrouPersistido)) {
						// FERIADO NÂO CADASTRADO E TRATAMENTO NÃO REGISTRADO
						// PERSISTIDO OU NOVO
						// PARA A DATA - INCLUIR REGISTRO
						final Tratamento trat = new Tratamento();
						trat.setIdTipoTratamento(tratamento.getIdTipoTratamento());
						trat.setRealizado(tratamento.getRealizado());
						trat.setRemarcado(tratamento.getRemarcado());
						trat.setTipoTratamento(tratamento.getTipoTratamento());
						trat.setDataPasse(dataConsulta.getTime());

						tratamentosIncluidos.add(trat);
						quantidadeIncluidos++;
						break;
					}
				}
			}
			dataConsulta.roll(Calendar.DAY_OF_YEAR, true);
		} while (quantidadeIncluidos < quantidade);
		return tratamentosIncluidos;
	}
}
