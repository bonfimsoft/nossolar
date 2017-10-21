package br.com.bonfimsoft.nossolar.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Problema;
import br.com.bonfimsoft.nossolar.service.ProblemaService;
import br.com.bonfimsoft.nossolar.service.TipoProblemaService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "paciente", "atendimento", "entrevista" })
public class ProblemaController {

	@Inject
	private ProblemaService problemaService;
	@Inject
	private TipoProblemaService tipoProblemaService;

	@Inject
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory.getLogger(ProblemaController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute()
	public void loadEnums(Model model) {
		model.addAttribute("tiposProblema", tipoProblemaService.findAll());
	}

	@RequestMapping(value = { "/problema_listar" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String relacaoPropblemas(@ModelAttribute("atendimento") Atendimento atendimento, Locale locale, Model model, HttpSession session) {
		logger.info("Listagem Problemas page is Loading....");

		final Iterable<Problema> problemasPersistidos = atendimento.getId() != null ? problemaService.findByAtendimento(atendimento) : atendimento.getProblemas();
		final Map<Long, Problema> problemasNovos = new HashMap<Long, Problema>();
		session.setAttribute("problemasNovos", problemasNovos);

		model.addAttribute("problemasPersistidos", problemasPersistidos);
		model.addAttribute("problemasNovosMap", problemasNovos);
		model.addAttribute("problemasNovosIterator", problemasNovos.values().iterator());

		return "nossolar.problema.list";
	}

	@RequestMapping(value = { "/problema_incluir" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String novoProblema(@ModelAttribute Problema problema, Model model, HttpSession session) {

		return "nossolar.problema.form";
	}

	@RequestMapping(value = { "/problema_editar" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String cadastroProblema(@RequestParam("id") @ModelAttribute Problema problema, Model model, HttpSession session) {
		logger.info("Cadastro Problema ID={}", problema.getId());

		if (problema.getVersao() == null) {
			@SuppressWarnings("unchecked")
			final Map<Long, Problema> problemas = (Map<Long, Problema>) session.getAttribute("problemasNovos");
			final Problema p = problemas.get(problema.getId());
			model.addAttribute("problema", p);
			return "nossolar.problema.form";
		}

		model.addAttribute("problema", problema);
		return "nossolar.problema.form";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/problema_salvar" }, method = RequestMethod.POST)
	public String salvarEntrevista(@ModelAttribute Problema problema, Locale locale, Model model, HttpSession session) {

		final Map<Long, Problema> problemasNovos = (Map<Long, Problema>) session.getAttribute("problemasNovos");
		final Atendimento atendimento = (Atendimento) session.getAttribute("atendimento");

		if (atendimento.getId() == null) {
			long chave = new Date().getTime();
			if (problema.getId() != null) {
				chave = problema.getId();
			}
			problema.setId(chave);
			problema.setTipoProblema(tipoProblemaService.findOne(problema.getIdTipoProblema()));
			problemasNovos.put(chave, problema);
			model.addAttribute("mensagemSucesso", messageSource.getMessage("problema.action.add.sucess", null, locale));
		} else {
			final boolean novo = problema.getId() == null ? true : false;
			problema.setAtendimento(atendimento);
			problemaService.save(problema);
			if (novo) {
				model.addAttribute("mensagemSucesso", messageSource.getMessage("problema.action.save.sucess", null, locale));
			} else {
				model.addAttribute("mensagemSucesso", messageSource.getMessage("problema.action.edit.sucess", null, locale));
			}

		}

		final Iterable<Problema> problemasPersistidos = atendimento.getId() != null ? problemaService.findByAtendimento(atendimento) : atendimento.getProblemas();

		session.setAttribute("problemasNovos", problemasNovos);

		model.addAttribute("problemasPersistidos", problemasPersistidos);
		model.addAttribute("problemasNovosMap", problemasNovos);
		model.addAttribute("problemasNovosIterator", problemasNovos.values().iterator());

		return "nossolar.problema.list";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/problema_excluir" }, method = RequestMethod.POST)
	public String excluirProblema(@RequestParam("id") @ModelAttribute Problema problema, Model model, Locale locale, HttpSession session) {
		logger.info("Removendo Problema {}", problema.getId());

		final Map<Long, Problema> problemasNovos = (Map<Long, Problema>) session.getAttribute("problemasNovos");
		final Atendimento atendimento = (Atendimento) session.getAttribute("atendimento");

		if (problema.getVersao() == null) {
			problemasNovos.remove(problema.getId());
		} else {
			problemaService.delete(problema);
		}

		final Iterable<Problema> problemasPersistidos = atendimento.getId() != null ? problemaService.findByAtendimento(atendimento) : atendimento.getProblemas();

		session.setAttribute("problemasNovos", problemasNovos);

		model.addAttribute("problemasPersistidos", problemasPersistidos);
		model.addAttribute("problemasNovosMap", problemasNovos);
		model.addAttribute("problemasNovosIterator", problemasNovos.values().iterator());
		model.addAttribute("mensagemSucesso", messageSource.getMessage("problema.action.remove.sucess", null, locale));

		return "nossolar.problema.list";
	}
}
