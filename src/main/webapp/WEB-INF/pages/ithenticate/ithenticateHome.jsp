<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String contentPagePath = basePath + "ithenticate/ithenticateContent";
	String topPagePath = basePath + "ithenticate/ithenticateTop";
	String leftPagePath = basePath + "ithenticate/ithenticateLeft";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	#iframeTop{
		width: 100%;
		height: 70px;
	}
	#iframeLeft{
		width: 15%;
		height: 600px;
		float: left;
	}
	#iframeContent{
		width: 84%;
		height: 500px;
	}
</style>
</head>
<body>
<div>
		<iframe id="iframeTop" name="iframeTop" frameborder="0" src="<%=topPagePath %>"></iframe>
		<iframe id="iframeLeft" name="iframeLeft" frameborder="0" src="<%=leftPagePath %>"></iframe>
		<iframe id="iframeContent" name="iframeContent" frameborder="0" src="<%=contentPagePath %>"></iframe>
	</div>
</body>
</html>