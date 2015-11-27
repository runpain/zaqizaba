<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'MyJsp.jsp' starting page</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<div id="header" class="wrap">
			<div id="logo">
				网上书城
			</div>
			<div id="navbar">
				<form method="get" name="search" action="">
					搜索：
					<input class="input-text" type="text" name="keywords" />
					<input class="input-btn" type="submit" name="submit" value="" />
				</form>
			</div>
		</div>
		<div id="register">
			<div class="title">
				<h2>
					欢迎注册网上书城
				</h2>
			</div>
			<div class="steps">
				<ul class="clearfix">
					<li class="current">
						1.填写注册信息
					</li>
					<li class="unpass">
						2.注册成功
					</li>
				</ul>
			</div>
			<form method="post" action="login">
			<input type="hidden" name="flag" value="regist" />
				<dl>
					<dt>
						用 户 名：
					</dt>
					<dd>
						<input class="input-text" type="text" name="userName" />
						<span>当前用户已存在！</span>
					</dd>
					<dt>
						密 码：
					</dt>
					<dd>
						<input class="input-text" type="password" name="password" />
						<span>密码过于简单！</span>
					</dd>
					<dt>
						确认密码：
					</dt>
					<dd>
						<input class="input-text" type="password" name="rePassWord" />
						<span>两次密码输入不一致！</span>
					</dd>
					<dt>
						Email地址：
					</dt>
					<dd>
						<input class="input-text" type="text" name="email" />
						<span>邮箱输入不正确！</span>
					</dd>
					<dt></dt>
					<dd class="button">
						<input class="input-reg" type="submit" name="regist" value="" />
					</dd>
				</dl>
			</form>
		</div>
		<div id="footer" class="wrap">
			网上书城 &copy; 版权所有

		</div>
	</body>
</html>
