var STATUS_DIALOG_SHOW = true;

/*
 * Arquivo javascript para interação e criação de scripts
 * 
 * @author Ezequiel, Silvanio
 * 
 */
jQuery(document).ready(function() {

	setMasks();

	esconderTabela();

	scrolTop();

});

function setTop(){
	window.scrollTo(0, 0);
}

/**
 * define as mascaras
 */
function setMasks() {

	jQuery(".numerico").keyup(function(e) { 
				
		var texto = jQuery(this).val().replace(/[^0-9]/gi,'');
		
		jQuery(this).val(texto);
	
	});
	
	$(".fone").mask("(99) 9999-9999?9");

	jQuery(".placa").mask('AAA0000');

	jQuery('.money').maskMoney({
		showSymbol : false,
		allowZero : true,
		defaultZero:true,
		decimal : ',',
		thousands : '.',
		precision : 2
	});
	
	jQuery('.peso2').maskMoney({
		showSymbol : false,
		allowZero : true,
		defaultZero:true,
		decimal : ',',
		thousands : '.',
		precision : 3
	});
	

	jQuery('.pesoInteiro').maskMoney({
		showSymbol : false,
		allowZero : true,
		defaultZero:true,
		decimal : '.',
		precision : 3
	});
	
	jQuery(".peso").keyup(function(e) {
			var numero = jQuery(this).val();
			numero=numero.replace(/\D/g,"");//Remove tudo o que não é dígito
			numero = numero.replace(/(\d{1})(\d{9})$/, "$1.$2"); // milhar
		    numero = numero.replace(/(\d{1})(\d{6})$/, "$1.$2"); // centena
		    numero = numero.replace(/(\d{1})(\d{3})$/, "$1.$2"); //dezena
			jQuery(this).val(numero);
	});
	

	//$('.alphanumerico').alphanumeric();
	
	tabularEnter();
	 
	enterFormControl();
	
	jQuery('.alphanumeric').keyup(function(e) {
		
		var texto = jQuery(this).val().replace(/[^a-z0-9]/gi,'');
		
		jQuery(this).val(texto);
	
	});
	
	toUpperCase();

}

function validarPercentual() {

	jQuery(".perc").blur(function() {

		if ($(this).val() > 100) {

			$(this).val(100);
		}

	});
}

function esconderTabela() {

	var tabela = PF('dtTable');

	if (tabela != undefined) {

		PF('dtTable').jq.hide();
	}
}

function mostrarTabela() {

	var tabela = PF('dtTable');

	if (tabela != undefined && PF('dtTable').paginator.cfg.rowCount > 0) {

		PF('dtTable').jq.show();

	} else {

		esconderTabela();
	}
}

/**
 * volta a pagina para o topo
 */
function scrolTop() {

	jQuery('html, body').scrollTop(0);
}

/**
 * Desabilita a exibição do status dialog
 * 
 * @author Ezequiel
 */
function desabilitarStatusDialog() {

	STATUS_DIALOG_SHOW = false;
}

/**
 * Habilita a exibição do status dialog
 * 
 * @author Ezequiel
 */
function habilitarStatusDialog() {

	STATUS_DIALOG_SHOW = true;
}

/**
 * Function responsavel por tabular entre os inputs que contenha a classe
 * "next", através da tecla enter
 * 
 * @author Ezequiel
 */ 
function tabularEnter() {

	$('.next, .next, .form-control input').keypress(function(e) {

		var $tecla = (e.keyCode ? e.keyCode : e.which);

		if ($tecla == 13) {

			$campo = $('.next, .next input');

			indice = $campo.index(this);

			if ($campo[indice + 1] != null) {

				$proximo = $campo[indice + 1];

				$proximo.focus();

			}

			return false;
		}
		;

	});

}


/**
 * Function responsavel por tabular entre os inputs que contenha a classe
 * "next", através da tecla enter
 * 
 * @author Ezequiel
 */ 
function enterFormControl() {

	$('input').keypress(function(e) {

		var $tecla = (e.keyCode ? e.keyCode : e.which);

		if ($tecla == 13) {

			return false;
		}
		
	});

}

function enter(event) {
	
	var tecla = (e.keyCode ? e.keyCode : e.which);

	if (tecla == "13") {

		event.keyCode = 0;

		return false;
	}
}

function toUpperCase(){
	
	jQuery('.upperCase').blur(function(e) {
		
		jQuery(this).val(jQuery(this).val().toUpperCase());
		
	});
}

