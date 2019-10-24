
 function genCellPhone(){
	 ShowDiv('MyDiv','fade');
	 $(".showMessage").html("");
	 var cellphonestr = $("#cellphonestr").val();
	 if(cellphonestr == null || cellphonestr == ""){
		 $(".showMessage").html("请输入11位数字");
		 $("#cellphonestr").focus();
		 CloseDiv('MyDiv','fade');
		 return;
	 }else{
		 if(cellphonestr.length != 11){
			 $(".showMessage").html("请输入11位数字");
			 $("#cellphonestr").focus();
			 CloseDiv('MyDiv','fade');
			 return;
		 }
		 var reg = new RegExp("^[0-9]*$");
		 if(!reg.test(cellphonestr)){
			 $(".showMessage").html("请输入数字");
			 $("#cellphonestr").focus();
			 CloseDiv('MyDiv','fade');
			 return;
		 }
	 }
	 $("#yd").html("");
	 $("#lt").html("");
	 $("#dx").html("");
	 var typeList=new Array("yd","lt","dx")
	 ajaxHttp({
	     	url:"cellphone/generateCellPhoneNum",
	     	type:"post",
	     	data:{cellphonestr:cellphonestr},
	     	dataType : "json",
	     	success:function(data){
	     		CloseDiv('MyDiv','fade');
	     		console.log(data.data);
	     		var html = "";
	     		if(data.data.length>0){
	     			var dataList = data.data;
	     			for(var i =0 ; i<dataList.length; i++){
	     				if("yd"==typeList[i]){
	     					var arr = dataList[i].yd;
	     						if(arr != "undefined" && arr != null && arr != ""){
	     							html += "<span>总数："+arr.length+"</span><br/>";
	     							for(var j =1 ; j<=arr.length; j++){
    	    	    	     			html += "<span onclick='doShowDel("+arr[j-1]+")'>"+arr[j-1]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"
    	    	    	     			if(j%6 == 0){
    	    	    	     				html += "<br/>"
    	    	    	     			}
	    	     					}
	     						}else{
	     							html += "无法组合符合要求的号码"
	     						}
	     					$("#yd").append(html);
	     					html = "";
	     				}else if("lt"==typeList[i]){
	     					var arr = dataList[i].lt;
	     						if(arr != "undefined" && arr != null && arr != ""){
	     							html += "<span>总数："+arr.length+"</span><br/>";
	     							for(var j =1 ; j<=arr.length; j++){
    	    	    	     			html += "<span onclick='doShowDel("+arr[j-1]+")'>"+arr[j-1]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"
    	    	    	     			if(j%6 == 0){
    	    	    	     				html += "<br/>"
    	    	    	     			}
	    	     					}
	     						}else{
	     							html += "无法组合符合要求的号码"
	     						}
	    	     				$("#lt").append(html);
	    	     				html = "";
	     				}else if("dx"==typeList[i]){
	     					var arr = dataList[i].dx;
	     						if(arr != "undefined" && arr != null && arr != ""){
	     							html += "<span>总数："+arr.length+"</span><br/>";
	     							for(var j =1 ; j<=arr.length; j++){
    	    	    	     			html += "<span onclick='doShowDel("+arr[j-1]+")'>"+arr[j-1]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"
    	    	    	     			if(j%6 == 0){
    	    	    	     				html += "<br/>"
    	    	    	     			}
	    	     					}
	     						}else{
	     							html += "无法组合符合要求的号码"
	     						}
	    	     				$("#dx").append(html);
	    	     				html = "";
	     				}
	     			}
	     			
	     		}
	     		},
	     	error:function(data){
	     		alert("失败");
	     	}
	     });
 }

 var tabs=document.getElementById("tab").getElementsByTagName("li");
	var divs=document.getElementById("tab_con").getElementsByTagName("div");
	for (var i=0;i<tabs.length;i++)
		{tabs[i].onclick=function(){
			change(this);
		}}
	function change(obj){
		for (var i=0;i<tabs.length;i++){
			if(tabs[i]==obj)
			{tabs[i].className="fli";
			 divs[i].className="fdiv";
			}
		else {
			tabs[i].className="";
			 divs[i].className=""
		}
		}
	
	}	

	/**
	 * 展示电话号码详情
	 * @param cellphoneNum
	 */
	function doShowDel(cellphoneNum){
		if(cellphoneNum == null || cellphoneNum == ""){
			alert("请选择电话号码");
			return;
		}
		ajaxHttp({
			url:"cellphone/getCellPhoneCity",
	     	type:"post",
	     	data:{cellphoneNum:cellphoneNum},
	     	dataType : "json",
	     	success:function(data){
	     		console.log(data);
	     		var html = cellphoneNum+" : "+data.data;
	     		$("#cellphonedel").html(html);
	     	},
	     	error:function(data){
	     		
	     	}
		})
	}
	//弹出隐藏层
	function ShowDiv(show_div,bg_div){
		document.getElementById(show_div).style.display='block';
		document.getElementById(bg_div).style.display='block' ;
		var bgdiv = document.getElementById(bg_div);
		bgdiv.style.width = document.body.scrollWidth;
		// bgdiv.style.height = $(document).height();
		$("#"+bg_div).height($(document).height());
	};
	//关闭弹出层
	function CloseDiv(show_div,bg_div)
	{
		document.getElementById(show_div).style.display='none';
		document.getElementById(bg_div).style.display='none';
	};
