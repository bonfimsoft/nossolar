package br.com.bonfimsoft.nossolar.view.converter;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.bonfimsoft.nossolar.model.Problema;
import br.com.bonfimsoft.nossolar.repositories.ProblemaRepository;

public class StringProblemaConverter implements Converter<String, Problema> {

	@Inject
	ProblemaRepository problemaRepository;

	@SuppressWarnings("unchecked")
	@Override
	public Problema convert(String id) {
		Problema problema = problemaRepository.findOne(Long.valueOf(id));
		if (problema == null) {
			final ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			final HttpSession session = attr.getRequest().getSession(false); // true == allow create

			final Map<Long, Problema> problemasNovos = (Map<Long, Problema>) session.getAttribute("problemasNovos");

			if (problemasNovos.containsKey(Long.valueOf(id))) {
				problema = problemasNovos.get(Long.valueOf(id));
			} else {
				problema = new Problema();
				problema.setId(Long.valueOf(id));
			}

		}
		return problema;
	}
}
