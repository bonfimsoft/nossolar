package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Entrevista;

@Service
public interface EntrevistaService {

	public void save(Entrevista entrevista);

	public boolean exists(Entrevista entrevista);

	public Entrevista findOne(Long id);

	public Iterable<Entrevista> findByAtendimento(Atendimento atendimento);

	public Iterable<Entrevista> findAll();

	public long count();

	public void delete(Entrevista entrevista);

	public void delete(Long id);

	public void delete(Iterable<Entrevista> entrevistas);

	public void deleteAll();

}
