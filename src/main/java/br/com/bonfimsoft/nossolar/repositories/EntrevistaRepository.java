package br.com.bonfimsoft.nossolar.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Entrevista;

public interface EntrevistaRepository extends CrudRepository<Entrevista, Long> {

	public Iterable<Entrevista> findAllByAtendimentoOrderByIdAsc(Atendimento atendimento);

}
