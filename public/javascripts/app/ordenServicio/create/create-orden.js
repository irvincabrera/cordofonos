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
			this.$spanFechaRecepcion	= this.$formOrden.find('#span-fechaRecepcion');
			
			this.$radiosInstrumento		= this.$formOrden.find('input[name=instrument]');
			this.$divOtroInstrumento	= $('#divOtroInstrumento');
			this.$instrumentoInput		= $('#instrumentoInput');

			this.$radiosRecibido		= this.$formOrden.find('input[name=contenedor]');
			this.$divOtroContenedor		= $('#divOtroContenedor');
			this.$contenedorInput		= $('#contenedorInput');

			this.$checkboxInspeccion	= this.$formOrden.find('input[name=inspeccion]');
			this.$clearCheck			= this.$formOrden.find('.clearCheck');
			this.$optionsServicios		= this.$formOrden.find('#optionsServicios');

			// this.$innerAccion			=$('#inner-'+idaccionEntonacion);
			this.$legendAccion			= $('#legend-'+idaccionEntonacion);
			this.$legendCondiciones		= $('#legend-'+idcondicionesAjuste);
			this.$legendElectronica		= $('#legend-'+idelectronica);
			this.$legendHerrajes		= $('#legend-'+idherrajes);
			this.$legendPlasticos		= $('#legend-'+idplasticos);
			
			this.$tabla 				= this.$formOrden.find('.tabla-prueba');

			this.$saveBtn				= $('#saveBtn');
			this.$cancelBtn				= $('#cancelBtn');
			
		},
		binder: function () {
			this.$radiosInstrumento.on('click',this.showOtro.bind(this));
			this.$radiosRecibido.on('click',this.showOtro.bind(this));
			this.$checkboxInspeccion.on('click',this.showInspeccion.bind(this));
			this.$saveBtn.on('click',this.save.bind(this));
			this.$cancelBtn.on('click',this.cancel.bind(this));
			this.$legendAccion.on('click',this.toggleInner.bind(this));
			this.$legendCondiciones.on('click',this.toggleInner.bind(this));
			this.$legendElectronica.on('click',this.toggleInner.bind(this));
			this.$legendHerrajes.on('click',this.toggleInner.bind(this));
			this.$legendPlasticos.on('click',this.toggleInner.bind(this));
			
			// this.$legendAccion.on('click', this.toggleInner.bind(this));
			
		},
		render: function () {
			this.$tabla.DataTable();
			this.renderCount();
			this.$optionsServicios.tokenInput('/servicios-token-input');
		},
		cancel: function (e) {
			e.preventDefault();
		 	swal({
			  title: "¿Regresar a página de inicio?",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Regresar',
			  cancelButtonText: 'Quedarse'
			}).then(function () {
			  window.location.replace("/");
			})
			.catch(swal.noop);
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
			console.log("name: ",name);
			var $lala = $(event.target);
			
			if ($lala.prop('checked')) {
				console.log("Checado");
				console.log("$lala: ",$lala.val());
				$('#' +$lala.val()).slideDown('400');
			} else {
				console.log("NO Checado");
			 	$('#' +$lala.val()).slideUp(400);
			 	$('#'+$lala.val()+' .clearCheck').prop('checked',false);
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
				console.log("Contador numOrden ==> "+(data+1));
				if( data >= 0 && data < 10) {
					that.$numOrden.text('000'+(data+1));
				} else {
					if (data >= 10 && data <100) {
						that.$numOrden.text('00'+(data+1));
					}else if (data >= 100 && data < 1000) {
						that.$numOrden.text('0'+(data+1));
					};;
				}
			})
			.fail(function() {
				console.log("error del contador de orden");
			});
			this.$fechaRecepcion.val($.format.date(currentdate,'dd/MM/yy HH:mm'));
			this.$spanFechaRecepcion.text($.format.date(currentdate,'dd/MM/yyyy HH:mm'));
		 },
		 toggleInner: function (event) {
		 	var toogleId = (event.target.getAttribute('value'));
		 	console.log("even.target.id",toogleId);

		 	if ($('#inner-'+toogleId).is(':hidden')) {
		 		$('#toggler-'+toogleId).attr('class','glyphicon glyphicon-menu-up');
		 		$('#inner-'+toogleId).slideDown(400);
		 	} else {
		 		$('#toggler-'+toogleId).attr('class','glyphicon glyphicon-menu-down');
		 		$('#inner-'+toogleId).slideUp(400);
		 	}
		 },
		 save: function(){
		 	that = this;
		 	console.log('Entrando a orden save...');
		 	swal({
		 		onOpen: function () {
				    swal.showLoading()
				  },
		 		text: 'Guardando... Espere por favor'
		 		})			
		 	.catch(swal.noop);

			$.ajax({
				url: 'orden-servicio',
				type: 'POST',
				contentType: false, 
				processData: false,
				data: new FormData(that.$formOrden[0])
			})
			.done(function(response) {
				console.log(response);
				swal(
				  '¡Listo!',
				  'Orden de Servicio Guardada',
				  'success'
				)
			})
			.fail(function(error) {
				console.log(error);
				swal(
				  '¡Oops!',
				  'Ha habido un error al guardar la Orden',
				  'error'
				)
			});
		 }
	}
	createOrden.init();
})();