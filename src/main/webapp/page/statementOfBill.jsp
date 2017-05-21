<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html ; charset=utf-8">
<link rel="stylesheet"
	href="../js/jquery-easyui-1.5.2/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css"
	type="text/css"></link>
<link href="../static/css/bootstrap.min.css" rel="stylesheet">
<link href="../static/css/main.css" rel="stylesheet">
<script type="text/javascript"
	src="../js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.5.2/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<link rel='stylesheet prefetch'
	href="../static/css/font-awesome.min.css">
<!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
<title>我的小管家</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		page_init();
		$.extend($.messager.defaults,{
            ok:"确定",
            cancel:"取消"
        });
	});
	function page_init() {

		$("#dataTable").datagrid({
			url : "../sob/page", //actionName
			queryParams : {
				pageNumber : 1,
				pageSize : 10
			},//查询参数
			title : '收入支出信息',
			iconCls : 'icon-sz',//图标 
			width : 830,
			height : 670,
			nowrap : false,
			striped : true,
			border : true,
			singleSelect : true,
			collapsible : false,//是否可折叠的 
			fit : false,//自动大小 
			loadMsg : "正在加载数据...",
			rownumbers : true,//查询结果在表格中显示行号
			fitColumns : true,//列的宽度填满表格，防止下方出现滚动条。
			pageNumber : 2, //初始页码，得在这设置才效果，pagination设置没效果。
			pagination : true,
			columns : [ [ {
				field : 'startTime',
				title : '开始日期',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			},

			{
				field : 'endTime',
				title : '结束日期',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}, {
				field : 'id',
				title : '编号',
				width : 80,
				align : 'center'
			}, {
				field : 'shouru',
				title : '收入',
				width : 80,
				align : 'center'
			}, {
				field : 'zhichu',
				title : '支出',
				width : 80,
				align : 'center'
			}, {
				field : 'yue',
				title : '余额',
				width : 80,
				align : 'center'
			}, {
				field : 'zhichuzong',
				title : '支出总额',
				width : 80,
				align : 'center'
			}, {
				field : 'shouruzong',
				title : '收入总额',
				width : 80,
				align : 'center'
			}, {
				field : 'neirong',
				title : '内容',
				width : 280
			}, {
				field : 'yusuan',
				title : '预算',
				width : 80,
				align : 'center'
			} ] ],
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$('#dd').dialog({
						title : '添加收支',
						iconCls : 'icon-sz',//图标 
						width : 500,
						height : 400,
						closed : false,
						cache : false,
						modal : true
					});
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					openDialog("add_dialog", "edit");
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
							f_delete();
				}
			}, '-', {
				text : '下载',
				iconCls : 'icon-down',
				handler : function() {
					var url = "../exsport";
					/* var url ="../user/export"; */
					window.location.href = url;
					/* $.messager.alert('消息','正在开发中。。。');     */
				}
			} ],

		//分页控件
		//如果后端返回的json的格式直接是data={total:xx,rows:{xx}},不需要设置loadFilter了，
		//如果有多层封装，比如data.jsonMap = {total:xx,rows:{xx}}，则需要在loadFilter处理一下。
		/*
		loadFilter: function(data){
		    if(data.jsonMap) {
		        return data.jsonMap;
		    }
		}*/
		});

		var p = $('#dataTable').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10
			pageList : [ 10, 20, 30, 40, 50, 100 ],//可以设置每页记录条数的列表
			beforePageText : '第',//页数文本框前显示的汉字
			afterPageText : '页        共 {pages} 页',
			displayMsg : '共 {total} 条记录',
			onSelectPage : function(pageNumber, pageSize) {//分页触发
				find(pageNumber, pageSize);
			}
		});
		function f_delete() {
			var grid = $('#dataTable').datagrid('getSelected');
			if(grid){
				var param = {};
		    	param.id = grid.id;
				$.messager.confirm('确认','您确认想要删除记录吗？',function(grid){   
				    if (grid){ 
				    	$.ajax({
							url : '../sob/del',
							type:'post',
							data : param,
							success : function() {
								$.messager.alert('消息','删除成功');
								$('#dataTable').datagrid('load');
							},
							error : function(message) {
								$.messager.alert('消息','删除不成功');   
							}
						});
				    }   
				});
			}else{
		    	$.messager.alert('消息','选择一行');    
		    } 
		}

	}

	function find(pageNumber, pageSize) {
		$("#dataTable").datagrid('getPager').pagination({
			pageSize : pageSize,
			pageNumber : pageNumber
		});//重置
		$("#dataTable").datagrid("loading"); //加屏蔽
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "../sob/page",
			data : {
				pageNumber : pageNumber,
				pageSize : pageSize
			},
			success : function(data) {
				$("#dataTable").datagrid('loadData', data);
				$("#dataTable").datagrid("loaded"); //移除屏蔽
			},
			error : function(err) {
				$.messager.alert('操作提示', '获取信息失败...请联系管理员!', 'error');
				$("#dataTable").datagrid("loaded"); //移除屏蔽
			}
		});

	}
</script>
</head>
<body>
	<div class="container">
		<div class="mail-box">
			<aside class="sm-side">
			<div class="user-head">
				<a class="inbox-avatar" href="javascript:;"> <img width="64"
					hieght="60" src="../imgs/mzd.jpg">
				</a>
				<div class="user-name">
					<h5>
						<a href="page_init()">毛超杰</a>
					</h5>
					<span><a href="#">136642169@qq.com</a></span>
				</div>
				<a class="mail-dropdown pull-right" href="javascript:;"> <i
					class="fa fa-chevron-down"></i>
				</a>
			</div>
			<div class="inbox-body">
				<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
					tabindex="-1" id="myModal" class="modal fade"
					style="display: none;">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button aria-hidden="true" data-dismiss="modal" class="close"
									type="button">×</button>
								<h4 class="modal-title">Compose</h4>
							</div>
							<div class="modal-body">
								<form role="form" class="form-horizontal">
									<div class="form-group">
										<label class="col-lg-2 control-label">To</label>
										<div class="col-lg-10">
											<input type="text" placeholder="" id="inputEmail1"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">Cc / Bcc</label>
										<div class="col-lg-10">
											<input type="text" placeholder="" id="cc"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">Subject</label>
										<div class="col-lg-10">
											<input type="text" placeholder="" id="inputPassword1"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">Message</label>
										<div class="col-lg-10">
											<textarea rows="10" cols="30" class="form-control" id=""
												name=""></textarea>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<span class="btn green fileinput-button"> <i
												class="fa fa-plus fa fa-white"></i> <span>Attachment</span>
												<input type="file" name="files[]" multiple="">
											</span>
											<button class="btn btn-send" type="submit">Send</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
			</div>
			<ul class="inbox-nav inbox-divider">
				<li class="active"><a href="main.jsp"><i
						class="fa fa-inbox"></i>用户信息<span
						class="label label-danger pull-right">2</span></a></li>
				<li><a href=""><i class="fa fa-envelope-o"></i>收入支出信息</a></li>
				<li><a href="#"><i class="fa fa-bookmark-o"></i> Important</a>
				</li>
				<li><a href="#"><i class=" fa fa-external-link"></i> Drafts
						<span class="label label-info pull-right">30</span></a></li>
				<li><a href="#"><i class=" fa fa-trash-o"></i> Trash</a></li>
			</ul>
			</aside>
			<aside class="lg-side">
			<div class="inbox-head">
				<h3>我的小管家</h3>
				 <div style="float:right;color:red"><span>[<a style="color:black">切换用户</a>]</span>&emsp;<span>[<a style="color:black">注销</a>]</span></div>
				<form action="#" class="pull-right position">
					<div class="input-append"></div>
				</form>
			</div>
			<div class="inbox-body">
				<table id="dataTable" style="width: 400px; height: 250px">
					<div id="dd" href="sh.html"></div>
				</table>

			</div>
</body>
</html>