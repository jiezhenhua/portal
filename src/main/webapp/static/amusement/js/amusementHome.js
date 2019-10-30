var personCount = 0;
var count = 0;
var addperson = new Vue({
	el: '#addperson',
	methods: {
		doAddPerson: function () {
			var personId = new Date().getTime();
			personCount += 1;
			count +=1;
			$("#hbCount").val(count);
			var person = "<div id='person"+personCount+"'>"+personCount+"：<input type='text' id='person"+personCount+"' value='"+personId+"'/>"
				+"&nbsp;&nbsp;<input type='button' onclick=doDelPerson('person"+personCount+"') value='删除'/></div>";
			$("#personShow").append(person);
		}
	}
});

function doDelPerson(id){
	$("#"+id).remove();
	count -=1;
	$("#hbCount").val(count);
}

var doSend = new Vue({
	el: '#doSend',
	methods: {
		doSend: function(){
			$(".showMessage").html("");
			var hbSumMoney = $("#hbSumMoney").val();
			var hbCount = $("#hbCount").val();
			var personArr = new Array();
			var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
			if(hbCount == 0 || hbCount == "" || hbCount < 0){
				 $(".showMessage").html("红包个数必须大于0");
				 return;
			 }
			 if(!reg.test(hbSumMoney)){
				 $(".showMessage").html("请输入金额格式");
				 return;
			 }else if(hbSumMoney == 0){
				 $(".showMessage").html("金额必须大于0");
				 return;
			 }
			$("#personShow input[type=text]").each(function () {
				personArr.push(this.value);
				})
			if(personArr.length == 0){
				 $(".showMessage").html("请添加人员");
				 return;
			}
			var param = {hbSumMoney:hbSumMoney,hbCount:hbCount,personArr:personArr};
			ajaxHttp({
				url:"amusement/doSendHb",
		     	type:"post",
		     	contentType : "application/json",
		     	data:JSON.stringify(param),
		     	dataType : "json",
		     	success:function(data){
		     		console.log(data);
		     		var html = "";
		     		$.each(data, function (key, value) {
		     		    html += "<span>"+key+":  "+value+"</span><br/>";
		     		});
		     		$("#hbResult").html(html);
		     	},
		     	error:function(data){
		     		
		     	}
			})
		}
	}
})