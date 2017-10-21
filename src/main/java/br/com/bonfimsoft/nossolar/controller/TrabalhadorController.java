package br.com.bonfimsoft.nossolar.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import br.com.bonfimsoft.nossolar.model.Trabalhador;
import br.com.bonfimsoft.nossolar.service.TrabalhadorService;
import br.com.bonfimsoft.nossolar.view.validator.TrabalhadorValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TrabalhadorController {

	@Inject
	private TrabalhadorService trabalhadorService;

	private static final Logger logger = LoggerFactory
			.getLogger(TrabalhadorController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.addValidators(new TrabalhadorValidator());
	}

	@ModelAttribute()
	public void loadEnums(Model model) {
		model.addAttribute("sexos", Sexo.values());
		model.addAttribute("estados", Estado.values());
	}

	@RequestMapping(value = { "/trabalhador_listar" }, method = RequestMethod.GET)
	public String relacaoTrabalhador(Locale locale, Model model) {
		logger.info("Listagem Trabalhador page is Loading....");
		final Iterable<Trabalhador> trabalhadores = trabalhadorService.findAllOrderByNomeAsc();
		model.addAttribute("trabalhadores", trabalhadores);
		return "nossolar.trabalhador.list";
	}

	@RequestMapping(value = { "/trabalhador_incluir" }, method = RequestMethod.GET)
	public String novoTrabalhador(@ModelAttribute Trabalhador trabalhador, Model model) {
		return "nossolar.trabalhador.form";
	}

	@RequestMapping(value = { "/trabalhador_editar" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String cadastroTrabalhador(
			@RequestParam("id") @ModelAttribute Trabalhador trabalhador, Model model) {
		logger.info("Cadastro Trabalhador ID={}", trabalhador.getId());
		model.addAttribute("trabalhador", trabalhador);

		return "nossolar.trabalhador.form";
	}

	@RequestMapping(value = { "/trabalhador_salvar" }, method = RequestMethod.POST)
	public String salvarTrabalhador(@Valid @ModelAttribute Trabalhador trabalhador, BindingResult bindingResult, Model model) {
		logger.info("Salvando novo Trabalhador....");
		if(bindingResult.hasErrors()){
			model.addAttribute("mensagemErro", "true");
			return "nossolar.trabalhador.form";
		}
		this.removeMascaras(trabalhador);
		final boolean novo = trabalhador.getId() == null ? true : false;
		trabalhadorService.save(trabalhador);
		if (novo) {
			model.addAttribute("mensagemSucesso", "Trabalhador cadastrado com sucesso!");
		} else {
			model.addAttribute("mensagemSucesso", "Trabalhador atualizado com sucesso!");
		}
		final Iterable<Trabalhador> trabalhadores = trabalhadorService.findAllOrderByNomeAsc();
		model.addAttribute("trabalhadores", trabalhadores);
		return "nossolar.trabalhador.list";
	}

	@RequestMapping(value = { "/trabalhador_excluir" }, method = RequestMethod.POST)
	public String excluirTrabalhador(
			@RequestParam("id") @ModelAttribute Trabalhador trabalhador, Model model) {
		logger.info("Removendo Paciente {}", trabalhador.getId());
		trabalhadorService.delete(trabalhador);
		model.addAttribute("mensagemSucesso", "Trabalhador excluido com sucesso!");
		final Iterable<Trabalhador> trabalhadores = trabalhadorService.findAllOrderByNomeAsc();
		model.addAttribute("trabalhadores", trabalhadores);
		return "nossolar.trabalhador.list";
	}

	private void removeMascaras(Trabalhador trabalhador) {
		trabalhador.setCep(trabalhador.getCep().replaceAll("-", ""));
		trabalhador.setCpf(trabalhador.getCpf().replaceAll("[-\\.]", ""));
		trabalhador.setTelefone1((trabalhador.getTelefone1() == null)
				|| trabalhador.getTelefone1().equals("") ? null : trabalhador
						.getTelefone1().replaceAll("[\\s()\\-]", ""));
		trabalhador.setTelefone2((trabalhador.getTelefone2() == null)
				|| trabalhador.getTelefone2().equals("") ? null : trabalhador
						.getTelefone2().replaceAll("[\\s()\\-]", ""));
		trabalhador.setTelefone3((trabalhador.getTelefone3() == null)
				|| trabalhador.getTelefone3().equals("") ? null : trabalhador
						.getTelefone3().replaceAll("[\\s()\\-]", ""));
	}

}
