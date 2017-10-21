package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.TipoProblema;

@Service
public interface TipoProblemaService {

	public void save(TipoProblema tipoProblema);

	public boolean exists(TipoProblema tipoProblema);

	public TipoProblema findOne(Long id);

	public Iterable<TipoProblema> findAll();

	public long count();

	public void delete(TipoProblema tipoProblema);

	public void delete(Long id);

	public void delete(Iterable<TipoProblema> tiposProblema);

	public void deleteAll();

}
