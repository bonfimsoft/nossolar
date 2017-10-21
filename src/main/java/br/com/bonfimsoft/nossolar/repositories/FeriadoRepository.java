package br.com.bonfimsoft.nossolar.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import br.com.bonfimsoft.nossolar.model.Feriado;

public interface FeriadoRepository extends CrudRepository<Feriado, Long> {

	public Feriado findByData(Date data);

}
