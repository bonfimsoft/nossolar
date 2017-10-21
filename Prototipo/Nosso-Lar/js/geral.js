// JavaScript Document


/*****************************| jquery-mask-plugin |**********************************************/

$(document).ready(function(){
  $('.date').mask('00/00/0000');
  $('.time').mask('00:00:00');
  $('.date_time').mask('00/00/0000 00:00:00');
  $('.cep').mask('00000-000');
  $('.phone').mask('0000-0000');
  $('.phone_with_ddd').mask('(00) 0000-0000');
  $('.phone_us').mask('(000) 000-0000');
  $('.mixed').mask('AAA 000-S0S');
  $('.cpf').mask('000.000.000-00');
  $('.rg').mask('000.000.000-00');
  $('.money').mask('000.000.000.000.000,00', {reverse: true});
  $('.money2').mask("#.##0,00", {reverse: true});
  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
    translation: {
      'Z': {
        pattern: /[0-9]/, optional: true
      }
    }
  });
  $('.ip_address').mask('099.099.099.099');
  $('.percent').mask('##0,00%', {reverse: true});
  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
  $('.fallback').mask("00r00r0000", {
      translation: {
        'r': {
          pattern: /[\/]/, 
          fallback: '/'
        }, 
        placeholder: "__/__/____"
      }
    });
});








$(document).ready(function(){
   
	$('.meuTooltip').tooltip();
	
	$('.datepicker').datepicker({
		format: "dd/mm/yyyy",
    	language: "pt-BR"
	});
	
});


var Internationalisation = {
	
		"sEmptyTable": "Nenhum registro encontrado",
		"sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
		"sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
		"sInfoFiltered": "(Filtrados de _MAX_ registros)",
		"sInfoPostFix": "",
		"sInfoThousands": ".",
		"sLengthMenu": "_MENU_ resultados por página",
		"sLoadingRecords": "Carregando...",
		"sProcessing": "Processando...",
		"sZeroRecords": "Nenhum registro encontrado",
		"sSearch": "Pesquisar",
		"oPaginate": {
			"sNext": "Próximo",
			"sPrevious": "Anterior",
			"sFirst": "Primeiro",
			"sLast": "Último"
		},
		"oAria": {
			"sSortAscending": ": Ordenar colunas de forma ascendente",
			"sSortDescending": ": Ordenar colunas de forma descendente"
		}
	
}
/*============== | DataTable |===========================*/

$(document).ready( function () {
		
		$('#full').DataTable({
			"language": Internationalisation,
			responsive:true,
			"aoColumnDefs": [
      		{ "bSortable": false, "aTargets": [ -2, -1 ] }
    			],
			});
			
		$('#atendimento').DataTable({
			"language": Internationalisation,
			responsive:true,
			"aoColumnDefs": [
      		{ "bSortable": false, "aTargets": [-3, -2, -1 ] }
    			],
			});	
	
		$('#vertical').dataTable( {
			"language": Internationalisation,
			"scrollY":        "200px",
			"scrollCollapse": true,
			"paging":         false
		} );
		
		$('#horizontal').dataTable( {
			"scrollX": true
		} );
		
	
} );



/*******************| Bootstrap Validator |**********************************************************/

$(document).ready(function() {
    $('#containerForm').bootstrapValidator({
        /*container: 'tooltip',*/
		container: '#messages',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            firstName: {
                validators: {
                    notEmpty: {
                        message: 'The first name is required'
                    }
                }
            },
            lastName: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required'
                    }
                }
            },
            phone: {
                validators: {
                    digits: {
                        message: 'O número de telefone pode conter apenas dígitos'
                    },
                    notEmpty: {
                        message: 'É necessário o número de telefone'
                    }
                }
            }
        }
    });
});
