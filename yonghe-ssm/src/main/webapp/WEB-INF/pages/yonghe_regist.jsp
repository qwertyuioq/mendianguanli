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
	<h4>账号注册</h4>
	<br>
	<form action="register" method="post">
		用户名：<input type="text" name="username" placeholder="用户名" /><br>
		密&emsp;码：<input type="password" name="password" placeholder="密码" /><br>
		<input type="submit" value="提交" />&emsp;&emsp;<a href="yonghe_login">已有账户？请登录</a>
	</form>
	<hr>
</body>
</html>