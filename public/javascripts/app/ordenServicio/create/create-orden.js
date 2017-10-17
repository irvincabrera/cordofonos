(function () {
	var createOrden ={

		init: function () {
			this.loadDom;
			this.binder;
			this.render;
		},
		loadDom: function () {
			this
			this.$otroInstrumento		= $('#otroInstrumento');
			//this.$otroInstrumentoInput	= $('#otroInstrumentoInput');
		},
		binder: function () {
			this.$otroInstrumento.on('click',(this.$otroInstrumentoInput.attr('style','display:block;')));
		},
		render: function () {
			// body...
		}
	}
	
	createOrden.init();
})();