<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  <meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>添加主题--管理后台</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  <%@include file="jsp/top.jsp"%>

   <form method= "post" action = "login"  >
   		<input type="hidden" name="flag" value="login" />
    	<table border="0" align="center" style="background-color:#C9C"   >
		<tr><td>登陆界面</td></tr>
		
      	<tr>
        	<td>姓名：</td>
        	<td><input type="text" name = "name"></td>
      	</tr>
      	<tr>
        	<td>密码：</td>
        	<td><input type="password" name = "password" ></td>
      	</tr>
      	<tr>
      		<td><input type="submit" value="登陆"></td>
        	<td><input type="button" value="注册" onclick="location.href='MyJsp.jsp'"></td>
      	</tr>
        
</table>
</form>
<%@include file="jsp/bottem.jsp"%>
  </body>
</html>
