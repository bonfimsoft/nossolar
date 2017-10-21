package br.com.bonfimsoft.nossolar.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Problema;

public interface ProblemaRepository extends CrudRepository<Problema, Long> {

	public Iterable<Problema> findAllByAtendimentoOrderByIdAsc(Atendimento atendimento);

}
