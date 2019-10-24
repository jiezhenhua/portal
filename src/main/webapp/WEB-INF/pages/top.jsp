<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String empHomePagePath = basePath+"emp/empHome";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"></base>  <!-- 绝对路径  有这个之后 后面的都可以是相对路径 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css"
	href="static/portal/home/css/top.css" />
</head>
<body>
<div class="top_div">
	<div class="logo">这里是logo</div>
	<div class="navigationbar">
		<ul>
            <li><a href="" target="iframeContent">首页</a></li>
            <li><a href="" >个人信息修改</a></li>
            <li><a href="">退出登录</a></li>
        </ul>
	</div>
</div>
</body>
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/portal/home/js/top.js"></script>
</html>