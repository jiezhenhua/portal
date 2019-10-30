var maintain = new Vue({
	el: '#maintain',
	  methods: {
		  doMaintain: function (maintainPath) {
			  window.location.href = maintainPath;
	    }
	  }
})
var knowledgeAdd = new Vue({
	el: '#knowledgeadd',
	  methods: {
		  doKnowledgeAdd: function (knowledgeAddPath) {
			  window.location.href = knowledgeAddPath;
	    }
	  }
})