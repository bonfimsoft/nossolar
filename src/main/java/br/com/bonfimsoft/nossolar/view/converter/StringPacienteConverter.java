package br.com.bonfimsoft.nossolar.view.converter;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import br.com.bonfimsoft.nossolar.model.Paciente;
import br.com.bonfimsoft.nossolar.repositories.PacienteRepository;

public class StringPacienteConverter implements Converter<String, Paciente> {

	@Inject
	PacienteRepository pacienteRepository;
	
	@Override
	public Paciente convert(String id) {
		try{
			return pacienteRepository.findOne(Long.valueOf(id));
		} catch (Exception e) {
			return new Paciente();
		}
	}

}
