$(document).ready(function() {

	$('#btn-novo-paciente').click(function() {
		//window.location.replace("cadastro_trabalhador");
		//window.location.href = "cadastro_trabalhador";
		$(location).attr('href', 'paciente_incluir');
	});	
	
	/*
	$("button[id*='btn_editar_paciente_']").each(function() {
		var id = $(this).parent().parent().attr('id')
		$(this).click(function(){
			$(location).attr('href', 'paciente_cadastro?id=' + id);
		});
	});
	
	
	$("button[id*='btn_excluir_paciente_']").each(function() {
		var id = $(this).parent().parent().attr('id')
		$(this).click(function(){
			$(location).attr('href', 'paciente_excluir?id=' + id);
		});
	});
	*/
});
