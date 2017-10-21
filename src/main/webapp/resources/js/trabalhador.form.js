$(document).ready(function() {

	//$("#tb003_co_cpf").mask("99/99/9999",{placeholder:"mm/dd/yyyy"});
	
	$("#tb002-co-cep").mask("99999-999");
	$("#tb002-dt-nascimento").mask("99/99/9999",{placeholder:"__/__/____"});
	$("#tb002-de-telefone1, #tb002-de-telefone2, #tb002-de-telefone3").mask("(99) 9999-9999?9");
	$("#tb002-co-cpf").mask("999.999.999-99");
	
	
});
