package br.com.bonfimsoft.nossolar.controller;

import java.security.Principal;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.bonfimsoft.nossolar.model.Trabalhador;
import br.com.bonfimsoft.nossolar.service.TrabalhadorService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("nomeUsuario")
public class HomeController {

	@Inject
	private TrabalhadorService trabalhadorService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("New Client Login! The locale name is {}.", locale);

		return "login";
	}

	@RequestMapping(value = { "/login-error" }, method = RequestMethod.GET)
	public String loginError(Locale locale, Model model) {
		logger.info(
				"New Client CAN'T LOGIN! Max Sessions. The client locale is {}.",
				locale);

		return "login-error";
	}

	@RequestMapping(value = { "/principal", }, method = RequestMethod.GET)
	public String principal(Locale locale, Model model, Principal principal,
			HttpSession session) {
		logger.info(
				"New Client Login on Principal page! The client name is {}.",
				principal.getName());
		Trabalhador trabalhador = trabalhadorService.findByMatricula(principal
				.getName());
		model.addAttribute("nomeUsuario", trabalhador.getNome());
		// session.setAttribute("nomeUsuario", trabalhador.getNome());
		return "nossolar.homepage";
	}

	@RequestMapping(value = { "/retorno", }, method = RequestMethod.GET)
	public String retornoDireto(Locale locale, Model model) {
		logger.info("Cadastro Trabalhador page is Loading....");

		String retorno = "{\"retorno\":\"Objeto\"}";

		model.addAttribute("retorno", retorno);

		return "retorno";
	}

}
