<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String contentPagePath = basePath + "ithenticate/ithenticateContent";
	String maintainPath = basePath+"maintain/maintain/portal";
	String knowledgeAddPath = basePath+"maintain/knowledgeAdd/portal";
%>
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<div id="maintain" v-on:click="doMaintain('<%=maintainPath%>')">题目维护</div>
<div id="knowledgeadd" v-on:click="doKnowledgeAdd('<%=knowledgeAddPath%>')">新增</div>
<div>学习</div>
<div>答题</div>
</div>
</body>
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/knowledgeBank/js/knowledge.js"></script>
</html>