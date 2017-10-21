package br.com.bonfimsoft.nossolar.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Tratamento;

public interface TratamentoRepository extends CrudRepository<Tratamento, Long> {

	public Iterable<Tratamento> findAllByAtendimentoOrderByIdAsc(Atendimento atendimento);

	public Iterable<Tratamento> findAllByAtendimentoOrderByTipoTratamentoAscDataRegistroAscDataPasseAsc(Atendimento atendimento);

	public Tratamento findByAtendimentoAndDataPasse(Atendimento atendimento, Date data);

}
