<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Date data = new Date();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
 
  
    <title>My JSP 'index.jsp' starting page</title>
     <meta charset="utf-8">
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
   <p><%=data %></p>
   
              
            <form>
              <table>
                <tr>
                    <td>name:<input type="text" name="username"></td>
                </tr>
     
                <tr>
                    <td>password: <input type="password" name="password"></td>
                </tr>
 
                <tr>
                    <td>again:    <input type="password" name="repassword"></td>
                </tr>
 
                <tr>
                    <td>put check:<input type="text" name="vcode"></td>
                </tr>
 
                <tr>
                    <td><input type="submit" value="get"><input type="reset" value="restart"></td>
                     
                </tr>
            </table>
     </form>
  


	</body>
</html>
