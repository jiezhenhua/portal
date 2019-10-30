		//1.初始化Table
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function() {
				$('#tb_maintain')
						.bootstrapTable(
								{
									url : 'maintain/getKnowledges', //请求后台的URL（*）
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
									uniqueId : "id", //每一行的唯一标识，一般为主键列
									showToggle : true, //是否显示详细视图和列表视图的切换按钮
									cardView : false, //是否显示详细视图
									detailView : false, //是否显示父子表
									ajaxOptions:{
								        headers: {"accessToken": localStorage.accessToken}
								    },
								    onLoadSuccess: function () {
								    	alertModal('消息:','数据加成功!');
							        },
								    onLoadError: function (xhr, status) {
								    	alertModal('注意:','数据加载失败!');
							        },
									columns : [
											{
												checkbox : true
											},
											{
												field : 'id',
												title : '序号'
											},
											{
												field : 'zsTitle',
												title : '标题'
											},
											{
												field : 'zsContent',
												title : '内容'
											},
											{
												field : 'zsType',
												title : '类型'
											},
											{
												field : 'createTime',
												title : '新增时间',
												formatter : function(value,
														index, row) {
													if (value != null) {
														return formatDateFromNumber(value);
													}
												}
											},
											{
												field : 'updateTime',
												title : '修改时间',
												formatter : function(value,
														index, row) {
													if (value != null) {
														return formatDateFromNumber(value);
													}
												}
											}]
								});
			};

			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit : params.limit, //页面大小
					offset : params.offset, //偏移量; 就是当前页是从第几个开始的
					zsType : $("#query_type").val(),
					zsTitle : $("#query_title").val(),
					zsContent : $("#query_content").val(),
				};
				return temp;
			};
			return oTableInit;
		};

		// 初始化按钮
		var ButtonInit = function() {
			var oInit = new Object();
			var newKnowledgeData = {};

			oInit.Init = function() {
				
				/* 新增按钮添加click事件   */
				$("#btn_add").click(function() {
					$("#myModalLabel").text("新增");
					newKnowledgeData.id = "";
					$('#myModal').modal()
				});

				/* 编辑按钮 添加click 事件   */
				$("#btn_edit").click(
						function() {
							var arrselections = $("#tb_maintain").bootstrapTable(
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
							$("#new_type").val(arrselections[0].zsType);
							$("#new_content").val(arrselections[0].zsContent);
							$("#new_title").val(arrselections[0].zsTitle);
							newKnowledgeData.id = arrselections[0].id;
							$('#myModal').modal();
						});

				/* 提交按钮添加click 事件   */
				$("#btn_submit").click(function() {
					newKnowledgeData.zsTitle = $("#new_title").val();
					newKnowledgeData.zsContent = $("#new_content").val();
					newKnowledgeData.zsType = $("#new_type").val();
					$('#myModal').modal('hide');
					clean();
					if( ( newKnowledgeData.zsTitle != null && newKnowledgeData.zsTitle != "" ) && ( newKnowledgeData.zsContent != null && newKnowledgeData.zsContent != "" ) && ( newKnowledgeData.zsType != null && newKnowledgeData.zsType != "" )  ){
						ajaxHttp({
							type : "post",
							url : "maintain/updateKnowledge",
							data : newKnowledgeData,
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
								$("#tb_maintain").bootstrapTable('refresh');
							},
							error : function() {
								alertModal('注意:','服务器后台出错了!');
							}
						});
					}else{
						alertModal('注意:','标题不能为空!,内容不能为空!','类型不能为空!');
					}
				});

				/* 删除按钮 添加 click 事件   */
				$("#btn_delete").click(
						function() {
							var arrselections = $("#tb_maintain").bootstrapTable(
									'getSelections');
							if (arrselections.length > 1) {
								alertModal('注意:','只能删除一条数据!');
								return;
							}
							if (arrselections.length <= 0) {
								alertModal('注意:','请选择有效数据!');
								return;
							}
							newKnowledgeData.empno = arrselections[0].empno;
							var b = confirm("确认要删除么?");
							if(b){
								ajaxHttp({
									type : "post",
									url : "maintain/deleteKnowledge",
									data : newKnowledgeData,
									success : function(data, status) {
										if (status == "success") {
											$("#tb_maintain").bootstrapTable('refresh');
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
					$("#tb_maintain").bootstrapTable('refresh');
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