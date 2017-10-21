package br.com.bonfimsoft.nossolar.view.converter;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.bonfimsoft.nossolar.model.Tratamento;
import br.com.bonfimsoft.nossolar.repositories.TratamentoRepository;

public class StringTratamentoConverter implements Converter<String, Tratamento> {

	@Inject
	TratamentoRepository tratamentoRepository;

	@SuppressWarnings("unchecked")
	@Override
	public Tratamento convert(String id) {
		Tratamento tratamento = tratamentoRepository.findOne(Long.valueOf(id));
		if (tratamento == null) {
			final ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			final HttpSession session = attr.getRequest().getSession(false); // true == allow create

			final Map<Long, Tratamento> tratamentosNovos = (Map<Long, Tratamento>) session.getAttribute("tratamentosNovos");

			if (tratamentosNovos.containsKey(Long.valueOf(id))) {
				tratamento = tratamentosNovos.get(Long.valueOf(id));
			} else {
				tratamento = new Tratamento();
				tratamento.setId(Long.valueOf(id));
			}

		}
		return tratamento;
	}
}
