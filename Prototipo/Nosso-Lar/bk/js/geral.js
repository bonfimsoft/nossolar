// JavaScript Document

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


$(document).ready(function() {
    $('#registrationForm').bootstrapValidator({
        
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                validators: {
                    notEmpty: {
                    },
                    stringLength: {
                        min: 6,
                        max: 30
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]+$/
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                    },
                    emailAddress: {
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                    },
                    stringLength: {
                        min: 8
                    }
                }
            },
            birthday: {
                validators: {
                    notEmpty: {
                    },
                    date: {
                        format: 'YYYY/MM/DD'
                    }
                }
            },
            gender: {
                validators: {
                    notEmpty: {
                    }
                }
            }
        }
    });
});
