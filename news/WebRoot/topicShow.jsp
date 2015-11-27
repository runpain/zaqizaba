<%@ page language="java" import="java.util.*,cn.zucc.entity.Topic" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
List <Topic> topicList=(List)request.getAttribute("topicList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title>添加主题--管理后台</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
		<base href="<%=basePath%>">
		<title>My JSP 'PressShow.jsp' starting page</title>
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
		<div id="main">
			<%@include file="jsp/left.jsp"%>
			<div id="opt_area">
				<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
				<script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
				<ul class="classlist">
				<c:forEach items="${topicList}" var="topic">
					<li>
						${topic.name }
						<span> &#160;&#160;&#160;&#160; <a href='topic.do?flag=edit&id=${topic.id }'>修改</a>
							&#160;&#160;&#160;&#160; <a href='#' >删除</a>
						</span>
					</li>
						</c:forEach>
						<li class='space'></li>
					<p align="right">
						当前页数:[${pageNo } / ${totalPage }]&nbsp;
						<a href="topic.do?flag=list&pageNo=1">首页</a>&nbsp;
						<c:if test="${pageNo}>1">
						<a href="topic.do?flag=list&pageNo=${ pageNo-1 }">上一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNo < totalPage }">
						<a href="topic.do?flag=list&pageNo=${ pageNo+1 }">下一页</a>&nbsp;
						</c:if>
						<a href="topic.do?flag=list&pageNo=${totalPage}">末页</a>
					</p>
				</ul>
			</div>
		</div>
		<%@include file="jsp/bottem.jsp"%>
	</body>
</html>
