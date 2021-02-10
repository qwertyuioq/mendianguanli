<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<p style="color: red;">${ msg }</p>
	<hr>
	<h4>欢迎使用永和大王门店管理系统，请登录！</h4>
	<br>
	<form action="login" method="post">
		用户名：<input type="text" name="username" placeholder="用户名" /><br>
		密&emsp;码：<input type="password" name="password" placeholder="密码" /><br>
		<input type="submit" value="提交" />&emsp;&emsp;<a href="yonghe_regist">账号注册</a>
	</form>
	<hr>
</body>
</html>