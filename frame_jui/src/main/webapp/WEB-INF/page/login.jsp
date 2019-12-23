<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>权限管理系统</title>
<link href="${applicationScope.basepath}/statics/dwz/themes/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<img src="statics/custom/images/ossjklogo.png" >&nbsp;<a style="font-size: 25px">系统管理</a><br>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#" target="_blank"></a></li>
					</ul>
				</div>
				<h2 class="login_title" style="font-size: 16px">用户登录</h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="/login" method="post">
					<p>
						<label>用户名:</label> <input name="lgnName"   type="text" style="width: 140px; height: 20px;" class="login_input" /> <br />
					</p>
					<p>
						<label>密&nbsp;&nbsp;&nbsp;码:</label> <input name="pwd" type="password" style="width: 140px; height: 20px;" class="login_input"  /> <br />
					</p>
					<p>
						<br /> <span class="info" style="color: red"></span>
					</p>
					<div class="login_bar" style="margin-left: 10px;">
						<input class="sub" type="submit" value="" />
					</div>
				</form>
			</div>
			<div class="login_banner" style="background-image: url('${applicationScope.basepath}/statics/custom/images/login_banner.jpg')">
				<br> <br>
			</div>
			<div class="login_main">
				<ul class="helpList">
				</ul>
			</div>
		</div>
		<div id="login_footer">Copyright &copy; 2019 zzx</div>
	</div>
</body>
<script type="text/javascript" src="${applicationScope.basepath}/statics/dwz/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	var msg =${msg == null ?  "''" : "'".concat(msg).concat("'")};
	if(msg){
		alert(msg);
	}
	
</script>
</html>