(function(){
	var createOrden ={

		init: function () {
			this.loadDom();
			this.binder();
			this.render();
		},
		loadDom: function () {
			this.$formOrden				= $('#formOrdenServicio');
			
			this.$radiosInstrumento		= this.$formOrden.find('input[name=instrument]');
			this.$divOtroInstrumento	= $('#divOtroInstrumento');
			this.$instrumentoInput		= $('#instrumentoInput');

			this.$radiosRecibido		= this.$formOrden.find('input[name=recibido]');
			this.$divOtroContenedor		= $('#divOtroContenedor');
			this.$contenedorInput		= $('#contenedorInput');

			this.$checkboxInspeccion	= this.$formOrden.find('input[name=inspeccion]');
		},
		binder: function () {
			this.$radiosInstrumento.on('click',this.showOtro.bind(this));
			this.$radiosRecibido.on('click',this.showOtro.bind(this));
			this.$checkboxInspeccion.on('click',this.showInspeccion.bind(this));
		},
		render: function () {

		},
		showOtro: function () {
			if (this.$radiosInstrumento.filter(':checked').val() =='Otro') {
				this.$divOtroInstrumento.slideDown('400');
			} else{
			 	this.$instrumentoInput.val('');
			 	this.$divOtroInstrumento.slideUp(400);
			}
			
			if (this.$radiosRecibido.filter(':checked').val() =='Otro') {
				this.$divOtroContenedor.slideDown('400');
			} else{
			 	this.$contenedorInput.val('');
			 	this.$divOtroContenedor.slideUp(400);
			}
		},
		showInspeccion: function (event) {
			var name = event.target.getAttribute('value');
			var $lala = $(event.target);
			
			if ($lala.prop('checked')) {
				console.log("Checado");
				console.log($lala.val());
				$('#' +$lala.val()).slideDown('400');
			} else {
				console.log("NO Checado");
			 	$('#' +$lala.val()).slideUp(400);
			}

			// if ( this.$checkboxInspeccion.filter(':checked').val() == name) {
			// } else{
			// }

		}
	}
	
	createOrden.init();
})();