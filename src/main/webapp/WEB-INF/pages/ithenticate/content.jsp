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
<h2>提交文档检测</h2>
<div>
	<span>请选择系统</span>
	<select>
		<option>请选择</option>
		<option>iThenticate系统</option>
	</select>
	<span>发表SCI/EI请选择"Ithenticate系统"</span>
</div>
<br/>
<div>
	<input type="file" id="file">
	<input type="button" onclick="UpladFile()" value="上传" />
	<input type="button" onclick="cancleUploadFile()" value="取消" />
	
</div>
<form id="upfileForm" enctype="multipart/form-data">
<h1>使用spring mvc提供的类的方法上传文件</h1>
<input type="file" name="file">
<input type="button" onclick='doSubmitForm()' name="提交"/>
</form>
</body>
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/ithenticate/js/upPaper.js"></script>

</html>