package br.com.bonfimsoft.nossolar.view.validator;

import java.util.Calendar;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.bonfimsoft.nossolar.model.Trabalhador;
import br.com.bonfimsoft.nossolar.util.NossoLarUtil;

public class TrabalhadorValidator implements Validator {

	@Override
	public boolean supports(Class<?> classe) {
		return Trabalhador.class.isAssignableFrom(classe);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final Trabalhador trabalhador = (Trabalhador) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricula", "trabalhador.validation.required.matricula");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "trabalhador.validation.required.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco", "trabalhador.validation.required.endereco");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bairro", "trabalhador.validation.required.bairro");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cidade", "trabalhador.validation.required.cidade");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uf", "trabalhador.validation.required.uf");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascimento", "trabalhador.validation.required.datanascimento");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "trabalhador.validation.required.cpf");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profissao", "trabalhador.validation.required.profissao");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexo", "trabalhador.validation.required.sexo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email1", "trabalhador.validation.required.email1");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefone1", "trabalhador.validation.required.telefone1");

		if (trabalhador.getId() == null) {
			if ((trabalhador.getSenha().isEmpty()) || ((!trabalhador.getSenha().isEmpty()) && (trabalhador.getSenha().length() < 4))) {
				errors.rejectValue("senha", "trabalhador.validation.minimal.senha");
			}
		} else {
			if ((!trabalhador.getSenha().isEmpty()) && (trabalhador.getSenha().length() < 4)) {
				errors.rejectValue("senha", "trabalhador.validation.minimal.senha");
			}
		}

		if ((!trabalhador.getNome().isEmpty()) && (trabalhador.getNome().trim().length() < 10)) {
			errors.rejectValue("nome", "trabalhador.validation.minimal.nome");
		}

		if ((!trabalhador.getCracha().isEmpty()) && (trabalhador.getCracha().trim().length() < 5)) {
			errors.rejectValue("cracha", "trabalhador.validation.minimal.cracha");
		}

		if (!trabalhador.getRg().isEmpty()) {
			if (trabalhador.getRg().trim().length() < 5) {
				errors.rejectValue("rg", "trabalhador.validation.minimal.rg");
			}

			if (!NossoLarUtil.isValidRG(trabalhador.getRg())) {
				errors.rejectValue("rg", "trabalhador.validation.valid.rg");
			}
		}

		if ((!trabalhador.getCpf().isEmpty()) && (!NossoLarUtil.isValidCPF(trabalhador.getCpf()))) {
			errors.rejectValue("cpf", "trabalhador.validation.valid.cpf");
		}

		if (trabalhador.getDataNascimento() != null) {
			final Calendar dataAtual = Calendar.getInstance();

			final Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(trabalhador.getDataNascimento());

			final int diferencaAnos = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
			final boolean aniversarioCompleto = dataAtual.get(Calendar.DAY_OF_YEAR) >= dataNascimento.get(Calendar.DAY_OF_YEAR);

			if ((diferencaAnos < 16) || ((diferencaAnos == 16) && (!aniversarioCompleto))) {
				errors.rejectValue("dataNascimento", "trabalhador.validation.minimal.datanascimento");
			}
		}

	}

}
