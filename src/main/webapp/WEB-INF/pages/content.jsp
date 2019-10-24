<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String empHomePagePath = basePath+"emp/empHome/portal";
	String ithenticateHomePagePath = basePath+"ithenticate/ithenticateHome/portal";
	String cellPhonmePath = basePath+"cellphone/cellPhoneHome/portal";
	String amusementHomePath = basePath+"amusement/amusementHome/portal";
	String knowledgeHomePath = basePath+"knowledge/knowledgeHome/portal";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"></base>  <!-- 绝对路径  有这个之后 后面的都可以是相对路径 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css"
	href="static/portal/home/css/home.css" />
</head>
<body>
<div id="center" class="center">
	<div id="emp" class="emp" v-on:click="goToEmp('<%=empHomePagePath %>')">emp</div>
	<div id="ithenticate" class="emp" v-on:click="goToIthenticate('<%=ithenticateHomePagePath %>')">ithenticate</div>
	<div id="cellPhone" class="emp" v-on:click="goToCellPhone('<%=cellPhonmePath %>')">cellphone</div>
	<div id="amusement" class="emp" v-on:click="goToAmusement('<%=amusementHomePath %>')">amusement</div>
	<div id="knowledge" class="emp" v-on:click="goToKnowledge('<%=knowledgeHomePath %>')">knowledgeBank</div>
</div>
</body>
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/portal/home/js/home.js"></script>
<script type="text/javascript" src="static/portal/ajax.js"></script>
</html>