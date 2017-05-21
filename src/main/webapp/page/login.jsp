<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>我的小管家</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../static/css/min.css" rel="stylesheet">
<link href="../static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#login').click(function() {
			var username = $('#username').val();
			var password = $('#password').val();
			if (username == '') {
				alert("账号不能为空，请输入您的账号！");
				$('#username').focus();
				return false;
			}
			if (password == '') {
				alert("密码不能为空，请输入您的密码！");
				$('#password').focus();
				return false;
			}
			$.ajax({
				url : '/xgj/user/login',
				type : 'post',
				dataType : 'json',
				data : {
					username : $('#username').val(),
					password : $('#password').val()
				},
				success : function(data) {
					localStorage.clear();
					location.href = 'main.jsp';
				},
				error : function() {
					alert("登录失败，账号或密码错误");
				},
				beforeSend: function ()
	            {
					$.messager.progress({
				　　　　　   　　title:'消息',
				　　　　　　 　　msg:'正在登陆中,请稍后....',
				　　　　　　　　iconCls:'icon-search'
				　　　　});
	            },
	            complete: function ()
	            {
	            	setInterval(function(){
	            		  $.messager.progress('close');}, 2400);
	            }
			});
		});
			
	    $('#dd').dialog('close');
		$('#mima').click(function(){
			$('#dd').dialog('open');
		});
	
		$('#tj').click(function(){
			
			 var jm = $('#jm').val();
			 alert(jm);
			if(jm == data.password){
				alert("dsadas");
			} 
			/* alert('dsadsa'); */
		});
	});
</script>

</head>

<body id='aa'>
	<div id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		
			<div class="loginmodal-container">
				<h1>我的小管家</h1>
				<br>
				<form 
					onsubmit="return false" name="loginForm">
					<input type="text" name="username" placeholder="用户名" id="username">
					<input type="password" name="password" placeholder="密码"
						id="password"> 
						<input type="submit" id="login" name="login" class="login loginmodal-submit"  value="登录" >
				</form>
				<div class="login-help">
					<a href="register.jsp" class="glyphicon glyphicon-th-list">注册</a> - <a class="glyphicon glyphicon-lock" id="mima">忘记密码</a>
				</div>
			</div>
		</div>
	</div>
	
	
	<div id="dd" class="easyui-dialog" title="修改密码" style="width:400px;height:200px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true">   
   			<form>
		&emsp;<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span id="jm" class="glyphicon glyphicon-lock"></span>旧密码:&emsp; <input type="text" name="CustomerName" style="width: 150px" /></p>
		<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span id="xm" class="glyphicon glyphicon-lock"></span>新密码:&emsp; <input type="text" name="CustomerTel" style="width: 150px" /></p>
		<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span id="qjm" class="glyphicon glyphicon-lock"></span>确认密码:<input type="text" name="CustomerTel" style="width: 150px" /></p>
		<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<button id="tj" >提交</button></p>
			</form>
	</div> 
	
	
</body>
</html>