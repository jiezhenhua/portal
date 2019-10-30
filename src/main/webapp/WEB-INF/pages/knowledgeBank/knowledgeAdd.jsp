<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String contentPagePath = basePath + "ithenticate/ithenticateContent";
	String maintainPath = basePath+"maintain/maintain/portal";
%>
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/common/kindeditor/themes/default/default.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<textarea id="editor_id" name="content" style="width:700px;height:300px;"> 这里输入内容...</textarea>
</body>
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/knowledgeBank/js/knowledgeAdd.js"></script>
<script type="text/javascript" charset="utf-8" src="static/common/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="static/common/kindeditor/lang/zh-CN.js"></script>
<script>     
KindEditor.ready(function(K) {    
	window.editor = K.create('#editor_id');   
	});
</script>

</script>
</html>