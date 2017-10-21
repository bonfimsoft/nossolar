$(document).ready(function() {

	//$("#tb003_co_cpf").mask("99/99/9999",{placeholder:"mm/dd/yyyy"});
	
	$("#tb003_co_cep").mask("99999-999");
	$("#tb003_dt_nascimento").mask("99/99/9999",{placeholder:"__/__/____"});
	$("#tb003_de_telefone1, #tb003_de_telefone2, #tb003_de_telefone3").mask("(99) 9999-9999?9");
	
	$('#btn-novo-atendimento').click(function() {
		$(location).attr('href', 'atendimento_novo');
	});	
});
