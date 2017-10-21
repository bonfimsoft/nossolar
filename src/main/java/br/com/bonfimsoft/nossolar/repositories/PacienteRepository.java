package br.com.bonfimsoft.nossolar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.bonfimsoft.nossolar.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {

	@Query("SELECT p FROM Paciente p Order By p.nome")
	public Iterable<Paciente> findAllOrderByNomeAsc();

}
