var maintain = new Vue({
	el: '#maintain',
	  methods: {
		  doMaintain: function (maintainPath) {
			  alert(1);
			  window.location.href = maintainPath;
	    }
	  }
})