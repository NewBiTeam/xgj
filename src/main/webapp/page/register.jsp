<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>我的小管家</title>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<link href="../static/css/register.css" rel="stylesheet">
<link href="../static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Website Font style -->
	    <link rel="stylesheet" href="../static/css/font-awesome.min.css">
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
		<title>我的小管家</title>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#register').click(function(){
					var username = $('#username').val();
					var email = $('#email').val();
					var tel = $('#tel').val();
					var address = $('#address').val();
					var password = $('#password').val();
					var confirm = $('#confirm').val();
				
					if(username == ''){
					alert("账号不能为空，请输入您的账号");
					$('#username').focus();
					return false;
					}
					if(email == ''){
					alert("邮箱不能为空，请输入您的邮箱");
					$('#email').focus();
					return false;
					}
					if(password == ''){
						alert("密码不能为空，请输入您的密码");
						$('#password').focus();
						return false;
					}
					if(confirm == ''){
						alert("请确认密码");
						$('#confirm').focus();
						return false;
					}
					if(password != confirm){
						alert("两次密码不一致");
						$('#confirm').focus();
						return false;
					}
					$.ajax({
						url : '../user/add',
						type : 'POST',
						data : {
							username : $('#username').val(),
							email:$('#email').val(),
							tel:$('#tel').val(),
							address:$('#address').val(),
							password : $('#password').val()
						},
						success : function() {
							alert("注册成功！");
						localStorage.clear();
						location.href = 'login.jsp';
					},
						error : function(data) {
							$.messager.alert('消息','注册失败');    
					}
					});
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h2 class="glyphicon glyphicon-user">欢迎注册小管家</h2>
					<form>
						
						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="请输入你的用户名"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="请输入你您邮箱"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-phone" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="tel" id="tel"  placeholder="请输入您的手机号"/>
								</div>
							</div>
						</div><!-- <a href="#" class="btn btn-primary"><span class="glyphicon glyphicon-phone"></span> Default text here</a> -->
						
						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="address" id="address"  placeholder="请输入您的住址"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="请输入您的密码"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="请确认您的密码"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<a  target="_blank" type="button" id="register" class="btn btn-primary btn-lg btn-block login-button">注册</a>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</body>
</html>

</body>
</html>