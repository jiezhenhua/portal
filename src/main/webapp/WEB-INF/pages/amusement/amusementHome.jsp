<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String contentPagePath = basePath + "ithenticate/ithenticateContent";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css"
	href="static/amusement/css/amusementHome.css" />
<link rel="stylesheet" style="text/css"
	href="static/common/jquery/jquery-ui-timepicker-addon.css" />
<link rel="stylesheet" style="text/css"
	href="static/common/jquery/jquery-ui.min.css" />
</head>
<body>
<h2>发红包</h2>
<form id="amusementForm">
<span>红包个数：</span><input type="number" name="hbCount" class="hbCount" id="hbCount"/>
<span>红包总金额：</span><input type="text" name="hbSumMoney" class="hbSumMoney" id="hbSumMoney"/>
<div>
	<input type="button" value="添加人员" id="addperson" v-on:click="doAddPerson()">
	<div id="personShow"></div>
</div>
<input type="button" id="doSend" value="发红包" v-on:click="doSend()">&nbsp;&nbsp;<span class="showMessage"></span>
</form>
<br/>
<span class="resultName">结果:</span><br/>
<div id="hbResult">
</div>
<div><input type="text" id="start_date"/><input type="text" id="end_date"/></div>
</body>
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/amusement/js/amusementHome.js"></script>
<script type="text/javascript" src="static/common/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="static/common/jquery/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="static/common/jquery/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript" src="static/portal/ajax.js"></script>
<script type="text/javascript">
//初始化
jQuery(function () {
            // 时间设置
            $('#start_date').prop("readonly", true).datetimepicker({
          	  timeText: '时间',
          	  hourText: '小时',
          	  minuteText: '分钟',
          	  secondText: '秒',
          	  currentText: '现在',
          	  closeText: '完成',
          	  showSecond: true, //显示秒 
          	  timeFormat: 'HH:mm:ss', //格式化时间 
          	  dateFormat: 'yy-mm-dd',
          	  changeMonth: true,
          	 });
        });

</script>
</html>