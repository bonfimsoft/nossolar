package br.com.bonfimsoft.nossolar.view.converter;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import br.com.bonfimsoft.nossolar.model.Entrevista;
import br.com.bonfimsoft.nossolar.repositories.EntrevistaRepository;

public class StringEntrevistaConverter implements Converter<String, Entrevista> {

	@Inject
	EntrevistaRepository entrevistaRepository;

	@Override
	public Entrevista convert(String id) {
		try {
			return entrevistaRepository.findOne(Long.valueOf(id));
		} catch (final Exception e) {
			return new Entrevista();
		}
	}

}
