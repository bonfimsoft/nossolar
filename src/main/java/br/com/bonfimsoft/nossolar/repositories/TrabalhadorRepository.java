package br.com.bonfimsoft.nossolar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.bonfimsoft.nossolar.model.Trabalhador;

public interface TrabalhadorRepository extends CrudRepository<Trabalhador, Long> {
	
	@Query("SELECT t FROM Trabalhador t Order By t.nome")
	public Iterable<Trabalhador> findAllOrderByNomeAsc();
	
	@Query("SELECT t FROM Trabalhador t Where t.matricula = ?1")
	public Trabalhador findByMatricula(String cracha);
	
}
