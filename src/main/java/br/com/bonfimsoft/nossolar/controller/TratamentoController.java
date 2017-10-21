package br.com.bonfimsoft.nossolar.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import br.com.bonfimsoft.nossolar.enumerator.FormatoTratamento;
import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Tratamento;
import br.com.bonfimsoft.nossolar.service.CompromissoService;
import br.com.bonfimsoft.nossolar.service.LivroService;
import br.com.bonfimsoft.nossolar.service.TipoTratamentoService;
import br.com.bonfimsoft.nossolar.service.TratamentoService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "paciente", "atendimento", "entrevista" })
public class TratamentoController {

	@Inject
	private TratamentoService tratamentoService;

	@Inject
	private TipoTratamentoService tipoTratamentoService;

	@Inject
	private LivroService livroService;

	@Inject
	private CompromissoService compromissoService;

	@Inject
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory.getLogger(TratamentoController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute()
	public void loadEnums(Model model) {
		model.addAttribute("tiposTratamento", tratamentoService.listTiposTratamento());
		model.addAttribute("livros", tratamentoService.listLivros());
		model.addAttribute("compromissos", tratamentoService.listCompromissos());
	}

	@RequestMapping(value = { "/tratamento_listar" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String relacaoTratamento(@ModelAttribute("atendimento") Atendimento atendimento, Locale locale, Model model, HttpSession session) {
		logger.info("Listagem Tratamento page is Loading....");

		final Iterable<Tratamento> tratamentosPersistidos = atendimento.getId() != null ? tratamentoService.findByAtendimento(atendimento) : atendimento.getTratamentos();
		final Map<Long, Tratamento> tratamentosNovos = new HashMap<Long, Tratamento>();
		session.setAttribute("tratamentosNovos", tratamentosNovos);

		model.addAttribute("tratamentosPersistidos", tratamentosPersistidos);
		model.addAttribute("tratamentosNovosMap", tratamentosNovos);
		model.addAttribute("tratamentosNovosIterator", tratamentosNovos.values().iterator());

		return "nossolar.tratamento.list";
	}

	@RequestMapping(value = { "/tratamento_incluir" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String novoTratamento(@ModelAttribute Tratamento tratamento, Model model, HttpSession session) {
		return "nossolar.tratamento.form";
	}

	@RequestMapping(value = { "/tratamento_editar" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String cadastroTratamento(@RequestParam("id") @ModelAttribute Tratamento tratamento, Model model, HttpSession session) {
		logger.info("Cadastro Tratamento ID={}", tratamento.getId());

		if (tratamento.getVersao() == null) {
			@SuppressWarnings("unchecked")
			final Map<Long, Tratamento> tratamentos = (Map<Long, Tratamento>) session.getAttribute("tratamentosNovos");
			final Tratamento t = tratamentos.get(tratamento.getId());
			model.addAttribute("tratamento", t);
			return "nossolar.tratamento.form";
		}

		model.addAttribute("tratamento", tratamento);
		return "nossolar.tratamento.form";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/tratamento_salvar" }, method = RequestMethod.POST)
	public String salvarTratamento(@ModelAttribute Tratamento tratamento, Locale locale, Model model, HttpSession session, HttpServletRequest request) {

		final Map<Long, Tratamento> tratamentosNovos = (Map<Long, Tratamento>) session.getAttribute("tratamentosNovos");
		final Atendimento atendimento = (Atendimento) session.getAttribute("atendimento");

		tratamento.setTipoTratamento(tipoTratamentoService.findOne(tratamento.getIdTipoTratamento()));
		if (atendimento.getId() == null) {
			long chave = new Date().getTime();
			if (tratamento.getId() != null) {
				chave = tratamento.getId();
			}
			tratamento.setId(chave);
			if (FormatoTratamento.C.equals(tratamento.getTipoTratamento().getFormatoTratamento())) {
				tratamento.setCompromisso(compromissoService.findOne(tratamento.getIdCompromisso()));
				tratamento.setRealizado(null);
				tratamento.setRemarcado(null);
				tratamentosNovos.put(chave, tratamento);
				model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.add.sucess", null, locale));
			} else if (FormatoTratamento.L.equals(tratamento.getTipoTratamento().getFormatoTratamento())) {
				tratamento.setLivro(livroService.findOne(tratamento.getIdLivro()));
				tratamento.setRealizado(null);
				tratamento.setRemarcado(null);
				tratamentosNovos.put(chave, tratamento);
				model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.add.sucess", null, locale));
			} else if (FormatoTratamento.P.equals(tratamento.getTipoTratamento().getFormatoTratamento())) {
				if ("data".equals(request.getParameter("tipo_passe"))) {
					tratamentosNovos.put(chave, tratamento);
					model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.add.sucess", null, locale));
				} else if ("quantidade".equals(request.getParameter("tipo_passe"))) {
					final int quantidade = Integer.valueOf(request.getParameter("qtdePasses"));
					atendimento.setTratamentos(new ArrayList<Tratamento>(tratamentosNovos.values()));
					final List<Tratamento> passes = tratamentoService.geraPassesQuantidade(atendimento, tratamento, quantidade);
					atendimento.setTratamentos(new ArrayList<Tratamento>());
					long ultimaChave = 0;
					for (final Tratamento passe : passes) {
						do {
							chave = Math.round(Math.random() * 1000000);
						} while (chave == ultimaChave);
						ultimaChave = chave;
						passe.setId(chave);
						tratamentosNovos.put(chave, passe);
					}
					model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.add.multiple.sucess", null, locale));
				}
			}

		} else {
			if ((FormatoTratamento.P.equals(tratamento.getTipoTratamento().getFormatoTratamento())) && ("quantidade".equals(request.getParameter("tipo_passe")))) {
				final int quantidade = Integer.valueOf(request.getParameter("qtdePasses"));
				final List<Tratamento> passes = tratamentoService.geraPassesQuantidade(atendimento, tratamento, quantidade);
				for (final Tratamento passe : passes) {
					passe.setAtendimento(atendimento);
					tratamentoService.save(passe);
				}
				model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.add.multiple.sucess", null, locale));
			} else {
				final boolean novo = tratamento.getId() == null ? true : false;
				tratamento.setAtendimento(atendimento);
				tratamentoService.save(tratamento);
				if (novo) {
					model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.save.sucess", null, locale));
				} else {
					model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.edit.sucess", null, locale));
				}
			}
		}

		final Iterable<Tratamento> tratamentosPersistidos = atendimento.getId() != null ? tratamentoService.findByAtendimento(atendimento) : atendimento.getTratamentos();

		session.setAttribute("tratamentosNovos", tratamentosNovos);

		model.addAttribute("tratamentosPersistidos", tratamentosPersistidos);
		model.addAttribute("tratamentosNovosMap", tratamentosNovos);
		model.addAttribute("tratamentosNovosIterator", tratamentosNovos.values().iterator());

		return "nossolar.tratamento.list";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/tratamento_excluir" }, method = RequestMethod.POST)
	public String excluirTratamento(@RequestParam("id") @ModelAttribute Tratamento tratamento, Model model, Locale locale, HttpSession session) {
		logger.info("Removendo Tratamento {}", tratamento.getId());

		final Map<Long, Tratamento> tratamentosNovos = (Map<Long, Tratamento>) session.getAttribute("tratamentosNovos");
		final Atendimento atendimento = (Atendimento) session.getAttribute("atendimento");

		if (tratamento.getVersao() == null) {
			tratamentosNovos.remove(tratamento.getId());
		} else {
			tratamentoService.delete(tratamento);
		}

		final Iterable<Tratamento> tratamentosPersistidos = atendimento.getId() != null ? tratamentoService.findByAtendimento(atendimento) : atendimento.getTratamentos();

		session.setAttribute("tratamentosNovos", tratamentosNovos);

		model.addAttribute("tratamentosPersistidos", tratamentosPersistidos);
		model.addAttribute("tratamentosNovosMap", tratamentosNovos);
		model.addAttribute("tratamentosNovosIterator", tratamentosNovos.values().iterator());
		model.addAttribute("mensagemSucesso", messageSource.getMessage("tratamento.action.remove.sucess", null, locale));

		return "nossolar.tratamento.list";

	}

}
