package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Trabalhador;

@Service
public interface TrabalhadorService {

	public void save(Trabalhador trabalhador);

	public boolean exists(Trabalhador trabalhador);

	public Trabalhador findOne(Long id);

	public Iterable<Trabalhador> findAll();
	
	public Iterable<Trabalhador> findAllOrderByNomeAsc();
	
	public Trabalhador findByMatricula(String cracha);

	public long count();

	public void delete(Trabalhador trabalhador);

	public void delete(Long id);

	public void delete(Iterable<Trabalhador> trabalhadores);

	public void deleteAll();

}
