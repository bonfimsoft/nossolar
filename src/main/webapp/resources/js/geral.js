// JavaScript Document

var Internationalisation = {

	"sEmptyTable" : "Nenhum registro encontrado",
	"sInfo" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
	"sInfoEmpty" : "Mostrando 0 até 0 de 0 registros",
	"sInfoFiltered" : "(Filtrados de _MAX_ registros)",
	"sInfoPostFix" : "",
	"sInfoThousands" : ".",
	"sLengthMenu" : "_MENU_ resultados por página",
	"sLoadingRecords" : "Carregando...",
	"sProcessing" : "Processando...",
	"sZeroRecords" : "Nenhum registro encontrado",
	"sSearch" : "Pesquisar",
	"oPaginate" : {
		"sNext" : "Próximo",
		"sPrevious" : "Anterior",
		"sFirst" : "Primeiro",
		"sLast" : "Último"
	},
	"oAria" : {
		"sSortAscending" : ": Ordenar colunas de forma ascendente",
		"sSortDescending" : ": Ordenar colunas de forma descendente"
	}

}
/* ============== | DataTable |=========================== */

// $(document).ready( function () {
//		
// $('#full').datatable({
// "language": Internationalisation,
// responsive:true,
// });
//	
// $('#vertical').dataTable( {
// "language": Internationalisation,
// "scrollY": "200px",
// "scrollCollapse": true,
// "paging": false
// } );
//		
// $('#horizontal').dataTable( {
// "scrollX": true
// } );
//		
//	
// } );
$(document).ready(function() {
	// $('.meuTooltip').tooltip('left');
	
	
	//$("div").has(".has-error").addClass("has-error");
	$(".has-error").parent("div").addClass("has-error");
});

/* =================| Atendimento |========================= */
$(document).ready(function() {
	if ($("#tb010_ic_proprio").val() == "true") {
		$("#div_responsavel").hide();
	}

	$("#tb010_btn_voltar").bind("click", function() {
		var id = $("#id_paciente").val();
		$(location).attr('href', 'paciente_editar?id=' + id);
	});

	$("#tb010_btn_entrevista").bind("click", function() {
		var id = $("#tb008_id_atendimento").val();
		$(location).attr('href', 'entrevista_listar?id=' + id);
	});

	$("#tb010_btn_problemas").bind("click", function() {
		var id = $("#tb008_id_atendimento").val();
		$(location).attr('href', 'problema_listar?id=' + id);
	});

	$("#tb010_btn_tratamento").bind("click", function() {
		var id = $("#tb008_id_atendimento").val();
		$(location).attr('href', 'tratamento_listar?id=' + id);
	});

	$("#tb010_ic_proprio").bind("change", function() {
		if ($(this).val() == "false") {
			$("#div_responsavel").show();
			$("#tb008_no_responsavel").show();
			$("#tb008_de_relacionamento").show();
			$("#tb008_de_telefone").show();
			$("#tb008_de_email").show();

		} else {
			$("#div_responsavel").hide();
			$("#tb008_no_responsavel").val("").hide();
			$("#tb008_de_relacionamento").val("").hide();
			$("#tb008_de_telefone").val("").hide();
			$("#tb008_de_email").val("").hide();
		}

	});
	$("#tb010_ic_uso_medicamentos").bind("change", function() {
		if ($(this).val() == "false") {
			$("#tb010_de_medicamentos").attr("readonly", "readonly").val('');
		} else {
			$("#tb010_de_medicamentos").removeAttr("readonly");
		}
	}).trigger("change");
	

});

/* =================| Entrevista |========================= */
$(document).ready(function() {
	$('#btn-novo-entrevista').click(function() {
		$(location).attr('href', 'entrevista_incluir');
	});
	
	$("#btn_entrevista_lista_voltar").bind("click", function() {
		var id = $("#id_atendimento").val();
		$(location).attr('href', 'atendimento_editar?id=' + id);
	});
	
	$("#btn_entrevista_cadastro_voltar").bind("click", function() {
		var id = $("#id_atendimento").val();
		$(location).attr('href', 'entrevista_listar');
	});
});

/* =================| Problemas |========================= */
$(document).ready(function() {
	$('#btn-novo-problema').click(function() {
		$(location).attr('href', 'problema_incluir');
	});
	
	$("#btn_problema_lista_voltar").bind("click", function() {
		var id = $("#id_atendimento").val();
		$(location).attr('href', 'atendimento_editar?id=' + id);
	});
	
	$("#btn_problema_cadastro_voltar").bind("click", function() {
		var id = $("#id_atendimento").val();
		$(location).attr('href', 'problema_listar');
	});
	
	$("#tb011_tipo_problema").bind("change", function(){
		var obj = $( "#tb011_tipo_problema option:selected" );
		
		if(obj.hasClass("open")){
			$("#descricao_problema").show();
		} else if(obj.hasClass("close")){
			$("#descricao_problema").hide();
			$("#tb011_de_problema").val("");
		}
	}).trigger("change");
	
});

/* =================| Tratamento |========================= */
$(document).ready(function() {
	
	$('#btn-novo-tratamento').click(function() {
		$(location).attr('href', 'tratamento_incluir');
	});
	
	$("#btn_tratamento_lista_voltar").bind("click", function() {
		var id = $("#id_atendimento").val();
		$(location).attr('href', 'atendimento_editar?id=' + id);
	});
	
	$("#btn_tratamento_cadastro_voltar").bind("click", function() {
		var id = $("#id_atendimento").val();
		$(location).attr('href', 'tratamento_listar');
	});
	
	
	$("#tb009_ic_tipo_tratamento").bind("change", function(){
		var obj = $( "#tb009_ic_tipo_tratamento option:selected" );
		
		$("#divPasse").hide();
		$("#divLeitura").hide();
		$("#divCompromisso").hide();
		
		if(obj.hasClass("P")){
			$("#divPasse").show();
		} else if(obj.hasClass("L")){
			$("#divLeitura").show();
		} else if(obj.hasClass("C")){
			$("#divCompromisso").show();
		}
	}).trigger("change");
	
	$("#tb009_qt_passe, #tb009_dt_passe, #tb009_ic_realizado, #tb009_ic_remarcado").attr("readonly", "readonly").val();
	
	if($("#hdn_tratamento_edicao").val() == "true"){
		$("#tb009_dt_passe, #tb009_ic_realizado, #tb009_ic_remarcado").removeAttr("readonly").val();
	}
	
	$("#rdo_quantidade").bind("change", function(){
		$("#tb009_qt_passe").removeAttr("readonly").val();
		$("#tb009_dt_passe, #tb009_ic_realizado, #tb009_ic_remarcado").attr("readonly", "readonly").val();
	});
	$("#rdo_data").bind("change", function(){
		$("#tb009_qt_passe").attr("readonly", "readonly").val();
		$("#tb009_dt_passe, #tb009_ic_realizado, #tb009_ic_remarcado").removeAttr("readonly").val();
	});
	
	
	$("#tb005_no_titulo").bind("change", function(){
		$( "#tb005_no_titulo option:selected" ).each(function() {
			$("#tb005_no_autor").val($(this).attr("autor"));
		});
	}).trigger("change");
});
