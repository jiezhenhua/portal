<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String empHomePagePath = basePath+"emp/empHome";
	String ithenticateHomePagePath = basePath+"ithenticate/ithenticateHome";
	String cellPhonePath = basePath+"cellphone/cellPhoneHome";
	String amusementHoePath = basePath+"amusement/amusementHome";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"></base>  <!-- 绝对路径  有这个之后 后面的都可以是相对路径 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css"
	href="static/portal/home/css/left.css" />
<body>
    <div class="account-l fl">
	<a class="list-title" href="<%=basePath %>welcome/content" target="iframeContent">首页</a>
	<ul id="accordion" class="accordion">
		<li>
			<div class="link"><i class="fa fa-leaf"></i>产品管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li id="shop"><a href="<%=basePath %>amusement/amusementHome" target="iframeContent">查看店铺</a></li>
				<li id="publicproducts"><a>发布产品</a></li>
				<li id="productlists"><a>查看产品</a></li>
				<li id="mysaled"><a>已卖出产品</a></li>
			</ul>
		</li>
		<li>
			<div class="link"><i class="fa fa-shopping-cart"></i>采购管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li id="publishpurchase"><a>发布采购</a></li>
				<li id="postneeds"><a>查看采购</a></li>
				<li id="getneeds"><a>已收到的报价单</a></li>
				<li id="mypricesheet"><a>我的报价单</a></li>
				<li id="concernshop"><a>已关注的店铺</a></li>
				<li id="concerngood"><a>已关注的商品</a></li>
			</ul>
		</li>
	</ul>
	
</div>
</body>
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/portal/home/js/left.js"></script>
</html>