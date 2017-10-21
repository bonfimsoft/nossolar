package br.com.bonfimsoft.nossolar.view.converter;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import br.com.bonfimsoft.nossolar.model.Trabalhador;
import br.com.bonfimsoft.nossolar.service.TrabalhadorService;

public class StringTrabalhadorConverter implements
		Converter<String, Trabalhador> {

	@Inject
	TrabalhadorService trabalhadorService;

	@Override
	public Trabalhador convert(String id) {
		try {
			return trabalhadorService.findOne(Long.valueOf(id));
		} catch (Exception e) {
			return new Trabalhador();
		}
	}

}
