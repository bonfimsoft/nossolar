package br.com.bonfimsoft.nossolar.view.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.bonfimsoft.nossolar.model.Paciente;

public class PacienteValidator implements Validator {

	@Override
	public boolean supports(Class<?> classe) {
		return Paciente.class.isAssignableFrom(classe);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final Paciente paciente = (Paciente) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "paciente.validation.required.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco", "paciente.validation.required.endereco");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bairro", "paciente.validation.required.bairro");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cidade", "paciente.validation.required.cidade");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uf", "paciente.validation.required.uf");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexo", "paciente.validation.required.sexo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascimento", "paciente.validation.required.datanascimento");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profissao", "paciente.validation.required.profissao");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefone1", "paciente.validation.required.telefone1");

		if ((!paciente.getNome().isEmpty()) && (paciente.getNome().trim().length() < 10)) {
			errors.rejectValue("nome", "paciente.validation.minimal.nome");
		}

	}

}
