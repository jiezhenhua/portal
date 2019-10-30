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
	href="static/ithenticate/css/ithenticateHome.css" />
</head>
<body>
<ul id="menu">
<li><a href="#" name="myset">提交论文</a></li>
<li><a href="#" name="myset">下载报告</a></li>
<li><a href="#" name="myset">淘宝店铺</a></li>
</ul>
</body>
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/ithenticate/js/ithenticateHome.js"></script>
</html>