var emp = new Vue({
  el: '#emp',
  methods: {
	  goToEmp: function (empHomePagePath) {
		  window.location.href = empHomePagePath;
		  //window.open(empHomePagePath);
    }
  }
})

var ithenticate = new Vue({
	  el: '#ithenticate',
	  methods: {
		  goToIthenticate: function (ithenticateHomePagePath) {
			  window.location.href = ithenticateHomePagePath;
			  //window.open(empHomePagePath);
	    }
	  }
	})

var cellPhone = new Vue({
	  el: '#cellPhone',
	  methods: {
		  goToCellPhone: function (cellPhonePagePath) {
			  window.location.href = cellPhonePagePath;
			  //window.open(empHomePagePath);
	    }
	  }
	})
var amusement = new Vue({
	el: '#amusement',
	methods: {
		goToAmusement: function (amusementHoePath) {
			window.location.href = amusementHoePath;
			//window.open(empHomePagePath);
		}
	}
})
var knowledge = new Vue({
	el: '#knowledge',
	methods: {
		goToKnowledge: function (knowledgeHomePath) {
			window.location.href = knowledgeHomePath;
		}
	}
})


/* alert弹出框  */
function alertModal(title,content){
	if('消息:' == title){
		$('#alertModalLabel').html('<button type="button" class="btn btn-success" disabled="disabled" >消息</button>');
		$('#alertModalContent').html('<div class="alert alert-success">'+content+'</div>');
	}else if('注意:' == title ){
		$('#alertModalLabel').html('<button type="button" class="btn btn-danger" disabled="disabled" >注意</button>');
		$('#alertModalContent').html('<div class="alert alert-danger">'+content+'</div>');
	}
	$('#alertModal').modal();
	setTimeout("$('#alertModal').modal('hide')",1000); /* 1 秒 后 模态框 自动 关闭    */
}