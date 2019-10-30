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
<div style="background-color: gray;">
	<img class="ithenticate-logo" alt="" src="static/ithenticate/image/ith-logo.png">
	<div class="qqservice">              
	<span>QQ客服：</span> 
	<a target="_blank" href="tencent://message/?uin=709751835&Site=qq&Menu=yes">
	<img border="0" src="static/ithenticate/image/qqservice.jpg" alt="点击这里给我发消息"/>
	</a>         
	</div>
	<div class="wwservice">
		<span>旺旺客服：</span> 
		<a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&touid=123123123&siteid=cntaobao&status=1&charset=utf-8"><img border="0" src="http://amos.alicdn.com/online.aw?v=2&uid=123123123&site=cntaobao&s=1&charset=utf-8" alt="点这里给我发消息" /></a>
	</div>
</div>
</body>
</html>