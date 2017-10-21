package br.com.bonfimsoft.nossolar.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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

import br.com.bonfimsoft.nossolar.enumerator.Estado;
import br.com.bonfimsoft.nossolar.enumerator.Sexo;
import br.com.bonfimsoft.nossolar.enumerator.TipoEntrevista;
import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Entrevista;
import br.com.bonfimsoft.nossolar.service.EntrevistaService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "paciente", "atendimento" })
public class EntrevistaController {

	@Inject
	private EntrevistaService entrevistaService;

	@Inject
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory.getLogger(EntrevistaController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute()
	public void loadEnums(Model model) {
		model.addAttribute("sexos", Sexo.values());
		model.addAttribute("estados", Estado.values());
		model.addAttribute("tiposEntrevista", TipoEntrevista.values());
	}

	@RequestMapping(value = { "/entrevista_listar" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String relacaoEntrevista(@ModelAttribute("atendimento") Atendimento atendimento, Locale locale, Model model) {
		logger.info("Listagem Paciente page is Loading....");
		final Iterable<Entrevista> entrevistas = entrevistaService.findByAtendimento(atendimento);
		model.addAttribute("entrevistas", entrevistas);
		return "nossolar.entrevista.list";
	}

	@RequestMapping(value = { "/entrevista_incluir" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String novoEntrevista(@ModelAttribute Entrevista entrevista, Model model, HttpSession session) {
		return "nossolar.entrevista.form";
	}

	@RequestMapping(value = { "/entrevista_editar" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String cadastroEntrevista(@RequestParam("id") @ModelAttribute Entrevista entrevista, Model model, HttpSession session) {
		logger.info("Cadastro Entrevista ID={}", entrevista.getId());
		model.addAttribute("entrevista", entrevista);
		session.setAttribute("entrevista", entrevista);

		return "nossolar.entrevista.form";
	}

	@RequestMapping(value = { "/entrevista_salvar" }, method = RequestMethod.POST)
	public String salvarEntrevista(@ModelAttribute Entrevista entrevista, Locale locale, Model model, HttpSession session, HttpServletRequest request) {
		final Atendimento atendimento = (Atendimento) session.getAttribute("atendimento");
		if (atendimento.getId() == null) {
			session.setAttribute("entrevista", entrevista);
			return "redirect:problema_listar";
		} else {
			final boolean novo = entrevista.getId() == null ? true : false;
			entrevista.setAtendimento(atendimento);
			this.entrevistaService.save(entrevista);
			if (novo) {
				model.addAttribute("mensagemSucesso", messageSource.getMessage("entrevista.action.save.sucess", null, locale));
			} else {
				model.addAttribute("mensagemSucesso", messageSource.getMessage("entrevista.action.edit.sucess", null, locale));
			}
			final Iterable<Entrevista> entrevistas = entrevistaService.findByAtendimento(atendimento);
			model.addAttribute("entrevistas", entrevistas);
			return "nossolar.entrevista.list";
		}
	}

	@RequestMapping(value = { "/entrevista_excluir" }, method = RequestMethod.POST)
	public String excluirAtendimento(@RequestParam("id") @ModelAttribute Entrevista entrevista, Model model, Locale locale, HttpSession session) {
		logger.info("Removendo Entrevista {}", entrevista.getId());
		entrevistaService.delete(entrevista);
		final Atendimento atendimento = (Atendimento) session.getAttribute("atendimento");
		final Iterable<Entrevista> entrevistas = entrevistaService.findByAtendimento(atendimento);
		model.addAttribute("entrevistas", entrevistas);
		model.addAttribute("mensagemSucesso", messageSource.getMessage("entrevista.action.remove.sucess", null, locale));

		return "nossolar.entrevista.list";
	}
}
