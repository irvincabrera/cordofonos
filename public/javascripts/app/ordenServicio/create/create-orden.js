(function () {
	var createOrden ={

		init: function () {
			this.loadDom;
			this.binder;
			this.render;
		},
		loadDom: function () {
			var _this = this;
			this.$otroInstrumento		= $('#otroInstrumento');
			this.$otroInstrumentoInput	= $('#otroInstrumentoInput');
		},
		binder: function () {
			this.$otroInstrumento.on('click',$otroInstrumentoInput.show());
		},
		render: function () {
			// body...
		}
	}
	
	createOrden.init();
})();