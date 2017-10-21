package br.com.bonfimsoft.nossolar.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.bonfimsoft.nossolar.enumerator.Estado;
import br.com.bonfimsoft.nossolar.enumerator.Sexo;
import br.com.bonfimsoft.nossolar.model.Paciente;
import br.com.bonfimsoft.nossolar.service.PacienteService;
import br.com.bonfimsoft.nossolar.view.validator.PacienteValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PacienteController {

	@Inject
	private PacienteService pacienteService;

	@Inject
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory
			.getLogger(PacienteController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.addValidators(new PacienteValidator());
	}

	@ModelAttribute()
	public void loadEnums(Model model) {
		model.addAttribute("sexos", Sexo.values());
		model.addAttribute("estados", Estado.values());
	}

	@RequestMapping(value = { "/paciente_listar" }, method = RequestMethod.GET)
	public String relacaoPaciente(Locale locale, Model model) {
		logger.info("Listagem Paciente page is Loading....");
		final Iterable<Paciente> pacientes = pacienteService.findAllOrderByNomeAsc();
		model.addAttribute("pacientes", pacientes);
		return "nossolar.paciente.list";
	}

	@RequestMapping(value = { "/paciente_incluir" }, method = RequestMethod.GET)
	public String novoPaciente(@ModelAttribute Paciente paciente, Model model) {
		return "nossolar.paciente.form";
	}

	@RequestMapping(value = { "/paciente_editar" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String cadastroPaciente(
			@RequestParam("id") @ModelAttribute Paciente paciente, Model model, HttpSession session) {
		logger.info("Cadastro Paciente ID={}", paciente.getId());
		model.addAttribute("paciente", paciente);
		session.setAttribute("paciente", paciente);

		return "nossolar.paciente.form";
	}

	@RequestMapping(value = { "/paciente_salvar" }, method = RequestMethod.POST)
	public String salvarPaciente(@Valid @ModelAttribute Paciente paciente, BindingResult bindingResult, Model model, Locale locale, HttpSession session) {
		logger.info("Salvando novo Paciente....");
		if(bindingResult.hasErrors()){
			model.addAttribute("mensagemErro", "true");
			return "nossolar.paciente.form";
		}
		this.removeMascaras(paciente);
		final boolean novo = paciente.getId() == null ? true : false;
		pacienteService.save(paciente);
		if (novo) {
			model.addAttribute("mensagemSucesso", messageSource.getMessage("paciente.action.save.sucess", null, locale));
		} else {
			model.addAttribute("mensagemSucesso", messageSource.getMessage("paciente.action.edit.sucess", null, locale));
		}
		session.setAttribute("paciente", paciente);
		return "nossolar.paciente.form";
	}

	@RequestMapping(value = { "/paciente_excluir" }, method = RequestMethod.POST)
	public String excluirPaciente(
			@RequestParam("id") @ModelAttribute Paciente paciente, Model model, Locale locale) {
		logger.info("Removendo Paciente {}", paciente.getId());
		pacienteService.delete(paciente);
		model.addAttribute("mensagemSucesso", messageSource.getMessage("paciente.action.remove.sucess", null, locale));
		final Iterable<Paciente> pacientes = pacienteService.findAllOrderByNomeAsc();
		model.addAttribute("pacientes", pacientes);
		return "nossolar.paciente.list";
	}

	private void removeMascaras(Paciente paciente) {
		paciente.setCep(paciente.getCep().replaceAll("-", ""));
		paciente.setTelefone1((paciente.getTelefone1() == null)
				|| paciente.getTelefone1().equals("") ? null : paciente
						.getTelefone1().replaceAll("[\\s()\\-]", ""));
		paciente.setTelefone2((paciente.getTelefone2() == null)
				|| paciente.getTelefone2().equals("") ? null : paciente
						.getTelefone2().replaceAll("[\\s()\\-]", ""));
		paciente.setTelefone3((paciente.getTelefone3() == null)
				|| paciente.getTelefone3().equals("") ? null : paciente
						.getTelefone3().replaceAll("[\\s()\\-]", ""));
	}
}
