$(document).ready(function() {

	$('#btn-novo-trabalhador').click(function() {
		//window.location.replace("cadastro_trabalhador");
		//window.location.href = "cadastro_trabalhador";
		$(location).attr('href', 'trabalhador_incluir');
	});

});
