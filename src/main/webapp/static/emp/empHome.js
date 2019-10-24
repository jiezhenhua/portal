		//1.初始化Table
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function() {
				$('#tb_emp')
						.bootstrapTable(
								{
									url : 'emp/getEmps', //请求后台的URL（*）
									contentType : 'application/json;charset=utf-8',
									method : 'get', //请求方式（*）
									toolbar : '#toolbar', //工具按钮用哪个容器
									striped : true, //是否显示行间隔色
									cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
									pagination : true, //是否显示分页（*）
									sortable : false, //是否启用排序
									sortOrder : "asc", //排序方式
									sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
									// 如果是服务端分页，返回的结果必须包含total、rows两个参数。漏写或错写都会导致表格无法显示数据。相反，如果是客户端分页，这里要返回一个集合对象到前端。
									pageNumber : 1, //初始化加载第一页，默认第一页
									pageSize : 10, //每页的记录行数（*）
									pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
									queryParams : oTableInit.queryParams,//传递参数（*）
									search : false, //是否显示表格搜索，
									strictSearch : false,
									showColumns : true, //是否显示所有的列
									showRefresh : true, //是否显示刷新按钮
									minimumCountColumns : 2, //最少允许的列数
									clickToSelect : true, //是否启用点击选中行
									height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
									uniqueId : "empno", //每一行的唯一标识，一般为主键列
									showToggle : true, //是否显示详细视图和列表视图的切换按钮
									cardView : false, //是否显示详细视图
									detailView : false, //是否显示父子表
									ajaxOptions:{
								        headers: {"accessToken": localStorage.accessToken}
								    },
									columns : [
											{
												checkbox : true
											},
											{
												field : 'empno',
												title : '员工编号'
											},
											{
												field : 'ename',
												title : '员工姓名'
											},
											{
												field : 'job',
												title : '工作岗位'
											},
											{
												field : 'mgr',
												title : '直接领导'
											},
											{
												field : 'hiredate',
												title : '入职日期',
												formatter : function(value,
														index, row) {
													if (value != null) {
														return formatDateFromNumber(value);
													}
												}
											}, {
												field : 'sal',
												title : '薪水'
											}, {
												field : 'comm',
												title : '奖金'
											}, {
												field : 'deptno',
												title : '部门编号'
											} ]
								});
			};

			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit : params.limit, //页面大小
					offset : params.offset, //偏移量; 就是当前页是从第几个开始的
					empno : $("#query_empno").val(),
					ename : $("#query_ename").val(),
					job : $("#query_job").val(),
					deptno : $("#query_deptno").val(),
					mgr : $("#query_mgr").val()
				};
				return temp;
			};
			return oTableInit;
		};

		// 初始化按钮
		var ButtonInit = function() {
			var oInit = new Object();
			var newEmpData = {};

			oInit.Init = function() {
				
				/* 新增按钮添加click事件   */
				$("#btn_add").click(function() {
					$("#myModalLabel").text("新增");
					newEmpData.empno = "";
					$('#myModal').modal()
				});

				/* 编辑按钮 添加click 事件   */
				$("#btn_edit").click(
						function() {
							var arrselections = $("#tb_emp").bootstrapTable(
									'getSelections');
							if (arrselections.length > 1) {
								alertModal('注意:','只能删除一条数据!');
								return;
							}
							if (arrselections.length <= 0) {
								alertModal('注意:','请选择有效数据!');
								return;
							}
							$("#myModalLabel").text("编辑");
							var s = arrselections[0].hiredate;
							var d = formatDateFromNumber(s);
							$("#new_job").val(arrselections[0].job);
							$("#new_ename").val(arrselections[0].ename);
							$("#new_deptno").val(arrselections[0].deptno);
							$("#new_sal").val(arrselections[0].sal);
							$("#new_mgr").val(arrselections[0].mgr);
							$("#new_comm").val(arrselections[0].comm);
							$("#new_hiredate").val(d);
							newEmpData.empno = arrselections[0].empno;
							$('#myModal').modal();
						});

				/* 提交按钮添加click 事件   */
				$("#btn_submit").click(function() {
					newEmpData.ename = $("#new_ename").val();
					newEmpData.job = $("#new_job").val();
					newEmpData.deptno = $("#new_deptno").val();
					newEmpData.mgr = $("#new_mgr").val();
					newEmpData.sal = $("#new_sal").val();
					newEmpData.comm = $("#new_comm").val();
					newEmpData.hiredate = $("#new_hiredate").val();
					$('#myModal').modal('hide');
					clean();
					if( ( newEmpData.ename != null && newEmpData.ename != "" ) && ( newEmpData.deptno != null && newEmpData.deptno != "" )  ){
						ajaxHttp({
							type : "post",
							url : "emp/updateEmp",
							data : newEmpData,
							success : function(data) {
								var z = data;
								switch (z) {
								case "updateOk":
									alertModal('消息:','更新数据成功!');
									break;
								case "updateFail":
									alertModal('注意:','更新数据失败!');
									break;
								case "addOk":
									alertModal('消息:','添加数据成功!');
									break;
								case "addFail":
									alertModal('注意:','添加数据失败!');
									break;
								default:
									alert(data);
									break;
								}
								$("#tb_emp").bootstrapTable('refresh');
							},
							error : function() {
								alertModal('注意:','服务器后台出错了!');
							}
						});
					}else{
						alertModal('注意:','员工的姓名不能为空!,员工的部门不能为空!');
					}
				});

				/* 删除按钮 添加 click 事件   */
				$("#btn_delete").click(
						function() {
							var arrselections = $("#tb_emp").bootstrapTable(
									'getSelections');
							if (arrselections.length > 1) {
								alertModal('注意:','只能删除一条数据!');
								return;
							}
							if (arrselections.length <= 0) {
								alertModal('注意:','请选择有效数据!');
								return;
							}
							newEmpData.empno = arrselections[0].empno;
							var b = confirm("确认要删除么?");
							if(b){
								ajaxHttp({
									type : "post",
									url : "emp/deleteEmp",
									data : newEmpData,
									success : function(data, status) {
										if (status == "success") {
											$("#tb_emp").bootstrapTable('refresh');
											var x = eval('' + data);
											if ('deleteOk' == x) {
												alertModal('消息:','删除数据成功!');
											} else {
												alertModal('注意:','删除数据失败!');
											}
										}
									},
									error : function() {
										alertModal('注意:','服务器后台出错了!');
									},
								});
							}
						});

				/* 查询按钮添加 click 事件   */
				$("#btn_query").click(function() {
					$("#tb_emp").bootstrapTable('refresh');
				});
			};
			return oInit;
		};

		/* 设置 form_date   */
		$('.form_date').datetimepicker({
			format: "yyyy-mm-dd",
			todayBtn : 'linked',
			todayHighlight : true,
			startView : 2,
			minView : 2
		});

		function clean() {
			$("input[type=reset]").trigger("click");
		}
		
		/*  把数字转化为日期      */
		function formatDateFromNumber(value){
			var d = new Date();
			d.setTime(value);
			var y = (d.getMonth() + 1) < 10 ? '0'
					+ (d.getMonth() + 1)
					: (d.getMonth() + 1);
			var t = d.getDate() < 10 ? '0'
					+ d.getDate()
					: d.getDate();
			return d.getFullYear()
					+ "-" + y + "-"
					+ t;
		}
		
		/* alert弹出框  */
		function alertModal(title,content){
			if('消息:' == title){
				$('#alertModalLabel').html('<button type="button" class="btn btn-success" disabled="disabled" >消息</button>');
				$('#alertModalContent').html('<div class="alert alert-success">'+content+'</div>');
			}else if('注意:' == title ){
				$('#alertModalLabel').html('<button type="button" class="btn btn-danger" disabled="disabled" >注意</button>');
				$('#alertModalContent').html('<div class="alert alert-danger">'+content+'</div>');
			}
			$('#alertModal').modal();
			setTimeout("$('#alertModal').modal('hide')",1000); /* 1 秒 后 模态框 自动 关闭    */
		}
		
		var turnback = new Vue({
			  el: '#turnback',
			  methods: {
				  turnback: function (homePagePath) {
					  window.location.href = homePagePath;
					  //window.open(empHomePagePath);
			    }
			  }
			})