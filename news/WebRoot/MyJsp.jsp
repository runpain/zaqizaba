<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
        
     	<form method= "post" action = "regist001" >
     		<input type="hidden" name="flag" value="regist" />
    	<table border="0" style="background-color:#C9C">

		<tr><td>注册表</td></tr>
      	<tr>
        	<td>姓名：</td>
        	<td><input type="text" name = "name"></td>
      	</tr>
      	<tr>
        	<td>密码：</td>
        	<td><input type="password" name = "password" ></td>
      	</tr>
      	<tr>
        	<td><input type="radio" name="sex" value="1">男</td>
        	<td><input type="radio" name="sex" value="0">女</td>
        	</tr>
      	<tr>
 
        	<td><input type="checkbox" name="hobby" value="足球">足球</td>
        	<td><input type="checkbox" name="hobby" value="跑步">跑步
        		<input type="checkbox" name="hobby" value="音乐">音乐
        		<input type="checkbox" name="hobby" value="绘画">绘画</td>
      	</tr>
      	<tr>
	  	<tr>
      		<td><input type="submit" value="提交"></td>
        	<td><input type="reset" value="重置" ></td>
      	</tr>
        
</table>
</form>
  
  </body>
</html>
