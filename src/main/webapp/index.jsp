<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
<style type="text/css">
</style>
</head>
<link rel="stylesheet" href="static/portal/login/login.css" type="text/css">
<body>
	<body>
    <div class='login_div'>
    <div class="login_title">用户登录</div>
    <div  class="login_table">
	    <form name="loginForm">   
	          <table Border="0">
	                    <tr >
	                        <td class="login_name">账号1</td>
	                        <td><input class="login_user" type="text" name="username" id="username"></td>
	                    </tr>
	                    <tr>
	                        <td class="login_name">密码</td>
	                        <td><input class="login_pwd" type="password" name="password" id="password">
	                        </td>
	                    </tr>
	               </table>
	               <span id="msgTip" class="msgTip"></span>
	               <br>
	                <input class="login_btn" type="button" value="登录" onclick="doLogin()">
	    </form>
	 </div>
    </div>

</body>
</body>
<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
<script type="text/javascript" src="static/portal/login/login.js"></script>
<script type="text/javascript" src="static/portal/ajax.js"></script>
<script type="text/javascript" src="static/portal/md5.js"></script>
<script type="text/javascript" src="static/common/rsa/jsencrypt.min.js"></script>
<script type="text/javascript">

</script>
</html>