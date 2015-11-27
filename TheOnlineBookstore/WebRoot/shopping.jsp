<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<title>My JSP 'shopping.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
	function disClick(obj) {
		var k = $(obj).next().val()
		if (k <= 1) {
			alert("不能小于1");
		} else {
			var num = k - 1;
			$(obj).next().val(num);
			$.ajax( {
				type : 'post',
				url : 'servlet/ShoppingServlet',
				data : {
					money : $(obj).parent().next().children().first().html(),
					num : $(obj).next().val(),
					flag : 'ajax',
					state : '-1'
				},
				dataType : 'json',
				success : function(conrtl) {
					$('#all').html(conrtl.allmoney);
				}
			});
		}

	}
	function addClick(obj) {
		var num = parseFloat($(obj).prev().val()) + 1;
		$(obj).prev().val(num);
		$.ajax( {
			type : 'post',
			url : 'servlet/ShoppingServlet',
			data : {
				money : $(obj).parent().next().children().first().html(),
				num : $(obj).prev().val(),
				flag : 'ajax',
				state : '1'
			},
			dataType : 'json',
			success : function(conrtl) {
				$('#all').html(conrtl.allmoney);
			}
		});
	}
</script>
	</head>


	<body>
		<div id="header" class="wrap">
			<div id="logo">
				网上书城
			</div>
			<%@include file="jsp/top.jsp"%>
		</div>
		<div id="content" class="wrap">
			<div class="list bookList">
				<form method="post" name="shoping" action="order.do">
				<input type="hidden" name="flag" value="intoorder" />
					<table>
						<tr class="title">
							<th class="view">
								图片预览
							</th>
							<th>
								书名
							</th>
							<th class="nums">
								数量
							</th>
							<th class="price">
								价格
							</th>
						</tr>
						<c:forEach items="${carlist}" var="book">
							<tr>
								<td class="thumb">
									<img src="${book.images}" />
								</td>
								<td class="title">
									${book.bookName }
								</td>
								<td>
									<input id="dis" onclick="disClick(this)" type="button"
										value="-" />
									<input class="input-text" type="text" name="nums" value="1" />
									<input id="add" onclick="addClick(this)" type="button"
										value="+" />
								</td>
								<td>
									￥
									<span>${book.price }</span>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="button">
						<h4>
							总价：￥
							<span>100.00</span>元
						</h4>
						<input class="input-chart" type="submit" name="submit" value="" />
					</div>
				</form>
			</div>
		</div>
		<div id="footer" class="wrap">
			网上书城 &copy; 版权所有

		</div>
	</body>
</html>
