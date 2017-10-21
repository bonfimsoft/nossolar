package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Paciente;

@Service
public interface PacienteService {

	public void save(Paciente paciente);

	public boolean exists(Paciente paciente);

	public Paciente findOne(Long id);

	public Iterable<Paciente> findAll();
	
	public Iterable<Paciente> findAllOrderByNomeAsc();

	public long count();

	public void delete(Paciente paciente);

	public void delete(Long id);

	public void delete(Iterable<Paciente> pacientes);

	public void deleteAll();

}
