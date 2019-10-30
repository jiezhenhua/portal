<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String empHomePagePath = basePath + "emp/empHome";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>empHomePage</title>
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap-table/css/bootstrap-table.min.css" />
<link rel="stylesheet" style="text/css"
	href="static/common/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
</head>
<body>
	This is empHome page .
	<br />
	<br />
	
	<!-- 查询条件 div -->
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-primary">
			<div class="panel-heading">查询条件</div>
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="query_empno">员工编号</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_empno">
						</div>
						<label class="control-label col-sm-1" for="query_ename">员工姓名</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_ename">
						</div>
						<label class="control-label col-sm-1" for="query_job">工作岗位</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_job">
						</div>
						<label class="control-label col-sm-1" for="query_deptno">部门编号</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_deptno">
						</div>
						<label class="control-label col-sm-1" for="query_mgr">直接领导</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="query_mgr">
						</div>
						<div class="col-sm-2" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="tb_emp"></table>
	</div>

	<div class="modal fade  bs-example-modal-lg" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
							<h3 class='panel-title'>员工信息:</h3>
						</div>
						<div class="panel-body">
							<form role="form">
								<div class="form-group" style="padding: 10px 5px 15px 20px;">
									<div class="col-sm-6">
										<label for="new_ename">员工姓名</label> <input type="text"
											class="form-control " id="new_ename" placeholder="请输入员工姓名">
									</div>
									<div class="col-sm-6">
										<label for="new_job">工作岗位</label> <select class="form-control"
											id="new_job">
											<option value="">请选择工作岗位</option>
											<option>ANALYST</option>
											<option>CEO</option>
											<option>CLERK</option>
											<option>MANAGER</option>
											<option>PRESIDENT</option>
											<option>SALESMAN</option>
										</select>
									</div>
								</div>
								<br /> <br />
								<div class="form-group" style="padding: 10px 5px 15px 20px;">
									<div class="col-sm-6">
										<label for="new_deptno">部门编号</label> <select
											class="form-control" id="new_deptno">
											<option value="">请选择工作部门</option>
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
										</select>
									</div>
									<div class="col-sm-6">
										<label for="new_mgr">直接领导</label> <input type="text"
											class="form-control " id="new_mgr" placeholder="请输入领导编号">
									</div>
								</div>
								<br /> <br />
								<div class="form-group" style="padding: 10px 5px 15px 20px;">
									<div class="col-sm-6">
										<label for="new_sal">薪水</label>
										<div class="input-group">
											<span class="input-group-addon">$</span> <input type="text"
												class="form-control" id="new_sal" placeholder="请输入薪水">
										</div>
									</div>
									<div class="col-sm-6">
										<label for="new_comm">奖金</label>
										<div class="input-group">
											<span class="input-group-addon">$</span> <input type="text"
												class="form-control" id="new_comm" placeholder="请输入奖金">
										</div>
									</div>
								</div>
								<br /> <br />
								<div class="form-group" style="padding: 10px 5px 15px 20px;">
									<div class="col-sm-6">
										<label for="new_hiredate" class="control-label">入职日期</label>
										<div class="input-group date form_date" data-date=""
											data-date-format="yyyy-mm-dd">
											<input id="new_hiredate" class="form-control" size="16"
												type="text" value="" readonly /> <span
												class="input-group-addon"> <span
												class="glyphicon glyphicon-remove"></span>
											</span> <span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"> </span>
											</span>
										</div>
										<!-- <input type="hidden" id="new_hiredate" value="" /> -->
									</div>
								</div>
								<input type="reset" name="reset" style="display: none;" />
							</form>
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
	</div>
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


	<script type="text/javascript" src="static/common/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="static/common/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="static/common/bootstrap-table/js/bootstrap-table.min.js"></script>
	<script type="text/javascript"
		src="static/common/bootstrap-table/js/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript"
		src="static/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
		src="static/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="static/emp/empHome.js"></script>
	<script type="text/javascript" src="static/portal/ajax.js"></script>
	<script type="text/javascript">
		$(function() {

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