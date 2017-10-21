package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Compromisso;

@Service
public interface CompromissoService {

	public void save(Compromisso compromisso);

	public boolean exists(Compromisso compromisso);

	public Compromisso findOne(Long id);

	public Iterable<Compromisso> findAll();

	public long count();

	public void delete(Compromisso compromisso);

	public void delete(Long id);

	public void delete(Iterable<Compromisso> compromissos);

	public void deleteAll();

}
