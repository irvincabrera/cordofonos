(function(){
	var createOrden ={

		init: function () {
			this.loadDom();
			this.binder();
			this.render();
		},
		loadDom: function () {
			this.$formOrden				= $('#formOrdenServicio');
			
			this.$numOrden				= this.$formOrden.find('#numOrden');
			this.$fechaRecepcion		= this.$formOrden.find('#fechaRecepcion');
			
			this.$radiosInstrumento		= this.$formOrden.find('input[name=instrument]');
			this.$divOtroInstrumento	= $('#divOtroInstrumento');
			this.$instrumentoInput		= $('#instrumentoInput');

			this.$radiosRecibido		= this.$formOrden.find('input[name=recibido]');
			this.$divOtroContenedor		= $('#divOtroContenedor');
			this.$contenedorInput		= $('#contenedorInput');

			this.$checkboxInspeccion	= this.$formOrden.find('input[name=inspeccion]');
			this.$clearCheck			= this.$formOrden.find('.clearCheck');
			
			this.$tabla 				= this.$formOrden.find('#tabla-prueba');

			// Elemtentos Nav Pills
			
		},
		binder: function () {
			this.$radiosInstrumento.on('click',this.showOtro.bind(this));
			this.$radiosRecibido.on('click',this.showOtro.bind(this));
			this.$checkboxInspeccion.on('click',this.showInspeccion.bind(this));
		},
		render: function () {
			this.$tabla.DataTable();
			this.renderCount();
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
			 	this.$clearCheck.prop('checked',false);
			}
		},
		renderCount: function(){
			var that = this;
			$.ajax({
				url: '/count-ordenes-servicio',
				type: 'GET',
				dataType: 'json',
				data: {}
			})
			.done(function(data) {
				console.log("success");
				if( data == 0 ) {
					that.$numOrden.text('1000');
				} else {
					that.$numOrden.text(data+1000);
				}
			})
			.fail(function() {
				console.log("error");
			})
			.always(function() {
				console.log("/count-ordenes-servicio: complete");
			});
			this.$fechaRecepcion.text(this.formatDate(currentdate));
		 },
		 formatDate: function(date){
			var fechaFormateada = date.getDay()+"-"+date.getMonth()+"-"+date.getFullYear()+" "+date.getHours()+":"+date.getMinutes();
			return fechaFormateada;
		 }
	} 	
	createOrden.init();
})();