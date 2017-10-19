(function () {
	var login = {
		init: function () {
			console.log('init');
			this.load();
			this.bind();
			this.render();
		},
		load: function () {
						console.log('load');

			this.$styleLink	= $('#styleLink');
			this.$stylBtn1	= $('#stylBtn1');
			this.$stylBtn2	= $('#stylBtn2');

		},
		bind: function () {
						console.log('bind');
			this.$stylBtn1.on('click', this.switchStyle.bind(this));
			this.$stylBtn2.on('click', this.switchStyle.bind(this));
		},
		render: function () {

		},
		switchStyle: function (event) {
						console.log('switchStyle');
			console.log(event.target);
			this.$styleLink.attr("href",$(event.target).prop('rel'));
			
	
		}
	}
	login.init();
})();