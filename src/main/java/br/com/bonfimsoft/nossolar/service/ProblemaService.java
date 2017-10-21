package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Problema;

@Service
public interface ProblemaService {

	public void save(Problema problema);

	public boolean exists(Problema problema);

	public Problema findOne(Long id);

	public Iterable<Problema> findByAtendimento(Atendimento atendimento);

	public Iterable<Problema> findAll();

	public long count();

	public void delete(Problema problema);

	public void delete(Long id);

	public void delete(Iterable<Problema> problemas);

	public void deleteAll();

}
