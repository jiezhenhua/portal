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
<base href="<%=basePath%>"></base>  <!-- 绝对路径  有这个之后 后面的都可以是相对路径 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<!-- 引入 bootStrap  -->
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap/css/bootstrap.min.css" />
<!-- 引入 bootStrap-table -->	
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap-table/css/bootstrap-table.min.css" />
<!-- 引入 bootStrap-datatimepicker -->	
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
</head>
<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-primary">  <!-- 查询条件 div  start -->
			<div class="panel-heading">查询条件</div>
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="query_type">知识类型</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_type">
						</div>
						<label class="control-label col-sm-1" for="query_title">标题</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_title">
						</div>
						<label class="control-label col-sm-1" for="query_content">内容</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_content">
						</div>
						<div class="col-sm-2" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>  <!-- 查询条件 div  end -->

		<div id="toolbar" class="btn-group">  <!-- 按钮组 div  start -->
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>  <!-- 按钮组 div  end -->
		
		<table id="tb_maintain"></table> <!-- 表格 div  start -->
	</div>

	<!--  新增和修改 都可以使用 -->
	<div class="modal fade  bs-example-modal-lg" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  	<!-- 编辑模态框  start  -->
		<div class="modal-dialog  modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body">
					<div class="panel panel-primary">
						<div class='panel-heading'>
							<h3 class='panel-title'>知识信息:</h3>
						</div>
						<div class="panel-body">
							<form role="form">  <!--  form 表单 start  -->
								<div class="form-group" style="padding: 10px 5px 15px 20px;">
									<div class="col-sm-6">
										<label for="new_type">知识类型</label> <select class="form-control"
											id="new_type">
											<option value="">请选择知识类型</option>
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
										</select>
									</div>
								</div>
								<br /> <br />
								<div class="form-group" style="padding: 10px 5px 15px 20px;">
									<div class="col-sm-12">
										<label for="new_title">标题</label> 
											<textarea rows="3" cols="20"
												class="form-control " id="new_title" placeholder="请输入知识标题">
											</textarea>
									</div>
									<div class="col-sm-12">
										<label for="new_content">内容</label> 
											<textarea rows="3" cols="20"
												class="form-control " id="new_content" placeholder="请输入知识内容描述">
											</textarea>
									</div>
								</div>
								<br /> <br />
								<input type="reset" name="reset" style="display: none;" /> <!-- 隐藏了一个重置按钮,方便清空表单里的内容 -->
							</form>  <!--  form 表单 end  -->
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" onclick="clean()"
						data-dismiss="modal">关闭</button>
					<button type="button" id="btn_submit" class="btn btn-primary">提交更改</button>
				</div>
			</div>
		</div>
	</div> <!-- 编辑模态框  end -->
	
	
	<!--对话模态框 -->
	<div class="modal fade" id="alertModal" tabindex="-1" role="dialog"
		aria-labelledby="alertModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="alertModalLabel">注意:</h4>
				</div>
				<div class="modal-body">
					<div id="alertModalContent"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


	<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>  <!-- 引入jquery.js 必须最先引入Jquery.js  -->
	<script type="text/javascript"
		src="static/common/bootstrap/js/bootstrap.min.js"></script> <!--  引入bootStrap.js -->
	<script type="text/javascript"
		src="static/common/bootstrap-table/js/bootstrap-table.min.js"></script>  <!--  引入bootStrap-table.js -->
	<script type="text/javascript"
		src="static/common/bootstrap-table/js/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript"
		src="static/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>  <!--  引入bootStrap-datetimepicker.js -->
	<script type="text/javascript"
		src="static/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="static/common/vue/vue.js"></script>  <!-- 引入vue.js  -->
	<script type="text/javascript" src="static/knowledgeBank/js/maintain.js"></script>   <!--  引入maintain.js -->
	<script type="text/javascript" src="static/portal/ajax.js"></script>
	<script type="text/javascript">
		$(function() { /* 加载完成就开始执行 */
			
			//1.初始化Table
			var oTable = new TableInit();
			oTable.Init();

			//2.初始化Button的点击事件
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();

		}); 
	</script>
</body>
</html>