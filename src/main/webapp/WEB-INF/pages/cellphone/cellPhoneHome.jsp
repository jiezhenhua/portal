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
	href="static/cellphone/css/cellphone.css" />
</head>
<body>
<h2>电话号码生成</h2>
<div>
<form id="genCellPhoneForm">
<span>输入11位数字</span>
<input type="text" name="cellphonestr" id="cellphonestr" required="required" pattern="[0-9]{11}" title="请输入11位数字" />
<input type="button" name="submit" onclick="genCellPhone()" value="生成" /><span class="showMessage"></span>
</form>
</div>
<div id="cellphonedel" class="cellphonedel"></div>
<ul id="tab">
	<li class="fli">移动号码</li>
	<li>联通号码</li>
	<li>电信号码</li>
	</ul>

	<div id="tab_con">
	<div class="fdiv" id="yd"></div>
	<div id="lt"></div>
	<div id="dx"></div>
	</div>
<!--弹出层时背景层DIV-->
<div id="fade" class="black_overlay">
</div>
<div id="MyDiv" class="white_content">
正在加载。。。
</div>

<!-- <div id="app">
    <div>
        <button v-for="(ind,key,index) in btn" v-bind:class="{active:(indexs==index)}" v-on:click="a(index)">{{ind}}</button>
    </div>
    <div class="wrap">
        <div v-for="(w,key,index) in box" v-if="indexs == index">{{w}}</div>
    </div>
</div> -->

</body>
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/cellphone/js/cellphone.js"></script>
<script type="text/javascript" src="static/portal/ajax.js"></script>
</html>