<%@ page language="java" import="java.util.*,cn.zucc.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Topic topic = (Topic)request.getAttribute("topic");

List <Topic> topicList=(List)request.getAttribute("topicList");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>添加主题--管理后台</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
    <base href="<%=basePath%>">
    
    <title>My JSP 'press.jsp' starting page</title>
    
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
  <%@include file="jsp/left.jsp"%>
	<form method= "post" action = "topic.do" >
	<input type="hidden" name="id" value="<%=topic.getId() %>"/>
	<input type="hidden" name = "flag" value="update"/>
    <table border="0" style="background-color:#C9C">
    	<tr>
        	<td colspan="2" align="center">修改主题</td>
      	</tr>
      	<tr>
        	<td>主题：</td>
        	<td><input type="text" name="name" value="<%=topic.getName() %>"/></td>   
      	</tr>
      	
	  	<tr>
      		<td><input type="submit" value="提交"></td>
        	<td><input type="reset" value="重置" ></td>
      	</tr>

</table>
</form>
<%@include file="jsp/bottem.jsp"%>
 </body>
 
</html>