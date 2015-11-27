<%@ page language="java" import="java.util.*,cn.zucc.entity.Press"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
List <Press> newsList=(List)request.getAttribute("newsList");
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
	function clickdel() {
		return confirm("删除请点击确认");
	}
</script>
				<ul class="classlist">

					<c:forEach items="${newsList}" var="press">
						<li
							onclick="javascript:location.href='press.do?flag=detail&id=${press.id}'">
							${press.title }
							<span> 作者： ${press.author } &#160;&#160;&#160;&#160; <a
								href='press.do?flag=edit&id=${press.id} '>修改</a>
								&#160;&#160;&#160;&#160; <a href='#'>删除</a> </span>
						</li>
					</c:forEach>
					<li class='space'></li>
					<p align="right">
						当前页数:[${pageNo } / ${totalPage }]&nbsp;
						<a href="press.do?flag=${flag }&pageNo=1">首页</a>&nbsp;
						<c:if test="${pageNo > 1}">
							<a href="press.do?flag=${flag }&pageNo=${ pageNo-1 }">上一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNo < totalPage }">
							<a href="press.do?flag=${flag }&pageNo=${ pageNo+1 }">下一页</a>&nbsp;
						</c:if>
						<a href="press.do?flag=${flag }&pageNo=${totalPage}">末页</a>

					</p>
				</ul>
			</div>
		</div>
		<%@include file="jsp/bottem.jsp"%>
	</body>
</html>
