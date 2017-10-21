package br.com.bonfimsoft.nossolar.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

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

import br.com.bonfimsoft.nossolar.enumerator.SituacaoAtendimento;
import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Entrevista;
import br.com.bonfimsoft.nossolar.model.Paciente;
import br.com.bonfimsoft.nossolar.model.Problema;
import br.com.bonfimsoft.nossolar.model.Tratamento;
import br.com.bonfimsoft.nossolar.service.AtendimentoService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "paciente" })
public class AtendimentoController {

	@Inject
	private AtendimentoService atendimentoService;

	@Inject
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory.getLogger(AtendimentoController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute()
	public void loadEnums(Model model) {
		model.addAttribute("situacoesAtendimento", SituacaoAtendimento.values());
	}

	@RequestMapping(value = { "/atendimento_novo" }, method = RequestMethod.GET)
	public String novoAtendimento(@ModelAttribute Atendimento atendimento, Locale locale, Model model, HttpSession session) {
		logger.info("Novo atendimento - Locale {}", locale);

		session.removeAttribute("atendimento");
		session.removeAttribute("entrevista");
		session.removeAttribute("tratamentosNovos");
		session.removeAttribute("problemasNovos");

		atendimento.setDataInicio(new Date());
		atendimento.setSituacaoAtendimento(SituacaoAtendimento.A);
		atendimento.setProprio(true);
		session.setAttribute("atendimento", atendimento);
		return "nossolar.atendimento.form";
	}

	@RequestMapping(value = { "/atendimento_editar" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String editarAtendimento(@RequestParam("id") @ModelAttribute Atendimento atendimento, Locale locale, Model model, HttpSession session) {
		model.addAttribute("atendimento", atendimento);
		session.setAttribute("atendimento", atendimento);
		return "nossolar.atendimento.form";
	}

	@RequestMapping(value = { "/atendimento_salvar" }, method = RequestMethod.POST)
	public String salvarAtendimento(@ModelAttribute Atendimento atendimento, Locale locale, Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("atendimento", atendimento);
		session.setAttribute("atendimento", atendimento);

		if (atendimento.getId() == null) {
			final Entrevista entrevista = new Entrevista();
			model.addAttribute("entrevista", entrevista);
			session.setAttribute("entrevista", entrevista);
			return "nossolar.entrevista.form";
		} else {
			this.atendimentoService.save(atendimento);

			session.setAttribute("atendimento", atendimento);
			model.addAttribute("atendimento", atendimentoService.findOne(atendimento.getId()));
			model.addAttribute("mensagemSucesso", messageSource.getMessage("atendimento.action.edit.sucess", null, locale));
		}

		return "nossolar.atendimento.form";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/atendimento_novo_finalizar" }, method = RequestMethod.POST)
	public String finalizarAtendimento(@ModelAttribute Paciente paciente, Locale locale, Model model, HttpSession session, HttpServletRequest request) {

		final Atendimento atendimento = (Atendimento) session.getAttribute("atendimento");
		final Entrevista entrevista = (Entrevista) session.getAttribute("entrevista");
		final Map<Long, Problema> problemasNovos = (Map<Long, Problema>) session.getAttribute("problemasNovos");
		final Map<Long, Tratamento> tratamentosNovos = (Map<Long, Tratamento>) session.getAttribute("tratamentosNovos");

		atendimento.setPaciente(paciente);
		atendimento.addEntrevista(entrevista);
		entrevista.setAtendimento(atendimento);
		for (final Problema problema : problemasNovos.values()) {
			problema.setId(null);
			atendimento.addProblema(problema);
			problema.setAtendimento(atendimento);
			problema.setDataRegistro(new Date());
		}
		for (final Tratamento tratamento : tratamentosNovos.values()) {
			tratamento.setId(null);
			atendimento.addTratamento(tratamento);
			tratamento.setAtendimento(atendimento);
			tratamento.setDataRegistro(new Date());
		}

		atendimentoService.save(atendimento);

		paciente.addAtendimento(atendimento);

		session.removeAttribute("atendimento");
		session.removeAttribute("entrevista");
		session.removeAttribute("tratamentosNovos");
		session.removeAttribute("problemasNovos");

		session.setAttribute("atendimento", atendimento);

		model.addAttribute("mensagemSucesso", messageSource.getMessage("atendimento.action.save.sucess", null, locale));

		return "nossolar.paciente.form";
	}

	@RequestMapping(value = { "/atendimento_excluir" }, method = RequestMethod.POST)
	public String excluirAtendimento(@RequestParam("id") @ModelAttribute Atendimento atendimento, Model model, Locale locale) {
		logger.info("Removendo Paciente {}", atendimento.getId());
		final Paciente paciente = atendimento.getPaciente();
		atendimentoService.delete(atendimento);
		model.addAttribute("paciente", paciente);
		model.addAttribute("mensagemSucesso", messageSource.getMessage("atendimento.action.remove.sucess", null, locale));
		return "nossolar.paciente.form";
	}

}
