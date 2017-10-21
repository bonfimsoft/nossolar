package br.com.bonfimsoft.nossolar.view.converter;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.repositories.AtendimentoRepository;

public class StringAtendimentoConverter implements Converter<String, Atendimento> {

	@Inject
	AtendimentoRepository atendimentoRepository;

	@Override
	public Atendimento convert(String id) {
		try {
			return atendimentoRepository.findOne(Long.valueOf(id));
		} catch (Exception e) {
			return new Atendimento();
		}
	}

}
