<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<title>My JSP 'index.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript"> 
    var xmlHttp; //ajax初始化对象
    var arrOptions = new Array(); //初始化数组元素
    var currentValueSelected = -1;//表示当前选中的某项 
   
    //判断输入的字符是否超过5个  
    function querybylength(){
     var woId = document.getElementById("woId").value;
     if(woId.length>=5){
      //判断做什么动作
      var intKey = -1;   
           if(window.event){    
           intKey = event.keyCode;       
           } 
           //alert(intKey);
           if(intKey == 38){//按向上键 
           //alert(currentValueSelected);
       if(currentValueSelected != -1){ //保证当前有用到SPAN      
                MoveHighlight(-1);    
                return false; 
            }   
           }else if(intKey == 40){ //按向下键    
       if(currentValueSelected != -1){ //保证当前有用到SPAN 
                MoveHighlight(1);    
                return false; 
            }      
           }else {
           ajaxTest(woId); //初始化SPAN
           }
     }else {
      HideTheBox();
      currentValueSelected = -1;
     }
    }
   
    //AJAX查询工单资料
    function ajaxTest(name){
     create();
       if (xmlHttp==null){
        alert ("您的浏览器不支持AJAX！");
           return;
       }
    var url = "/spnewmes/servlet/QueryWOId?woId="+name;
       xmlHttp.open("post",url,true);
       xmlHttp.onreadystatechange = stateChanged;
       xmlHttp.send(null);
    }
    function create(){
     if (window.XMLHttpRequest) {        
          this.xmlHttp = new XMLHttpRequest();    
       }else if (window.ActiveXObject) {        
          this.xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");    
       }
    }
    function stateChanged(){ //运行它进行ajax调用
         if (xmlHttp.readyState==4){ 
          var msg = xmlHttp.responseText; //获取返回值
         arrOptions = msg.split(";"); 
         //alert(arrOptions.length+":"+arrOptions);
         if(arrOptions[0]!="")
          Bulid(arrOptions); //给SPAN赋值
         else
          HideTheBox(); //隐藏SPAN
         }
       }
   
    //创建并赋值span标签   
    function creatSpan(){    
       var elemSpan = document.createElement("span");//在页面创建span标签    
       elemSpan.id = "spanOutput";    
       elemSpan.className = "spanTextDropdown";    
       document.body.appendChild(elemSpan); //将上面创建的elemSpan元素加入到BODY的尾部
    }
    function Bulid(arrOptions){ //给SPAN赋值 
          var inner="";    
          SetElementPosition();//设置下拉框出现的位置    
          for(var i=0; i < arrOptions.length; i++){
          //alert(i+":"+arrOptions[i]);    
          inner+="<span id=arr_"+i+" class='spanNormalElement' onmouseover='SetHighColor(this)' onclick='SetText()'><font color=red>"+arrOptions[i]+"</font></span><br>";    
          }    
          document.getElementById("spanOutput").innerHTML = inner; 
          if(inner!=""){ 
          //alert('init');   
              document.getElementById("arr_0").className ="spanHighElement";//设置第一个顶为默认选中    
              currentValueSelected=0;    
          }   
    }    
    function SetElementPosition(){ //设置下拉框出现的位置   
      var selectedPosX = 0;    
       var selectedPosY = 0;    
       var theElement = document.form1.woId;     
      
       if (!theElement) return;
           
       var theElemHeight = theElement.offsetHeight;    
       var theElemWidth = theElement.offsetWidth;    
   
       while(theElement != null){    
        selectedPosX += theElement.offsetLeft;    
        selectedPosY += theElement.offsetTop;    
        theElement = theElement.offsetParent;    
       }    
       xPosElement = document.getElementById("spanOutput");    
       xPosElement.style.left = selectedPosX;    
       xPosElement.style.width = theElemWidth;    
       xPosElement.style.top = selectedPosY + theElemHeight    
       xPosElement.style.display = "block";    
    } 
    function HideTheBox(){//隐藏下拉框    
       document.getElementById("spanOutput").style.display = "none";    
       currentValueSelected = -1;    
    } 
    function SetHighColor(theTextBox){//当鼠标划过变为选中状态 
     document.getElementById('arr_' + currentValueSelected).className ='spanNormalElement'; 
       if(theTextBox){    
           currentValueSelected = theTextBox.id.slice(theTextBox.id.indexOf("_")+1, theTextBox.id.length);    
       }
       //alert('SetHighColor:'+currentValueSelected); 
       document.getElementById('arr_'+currentValueSelected).className = 'spanHighElement';    
    } 
    function SetText(){//选中下拉框中的某个值    
       var theTextBox = document.form1.woId;    
       theTextBox.value = arrOptions[currentValueSelected];       
       document.getElementById("woId").value = theTextBox.value;    
       HideTheBox();     
    } 
    function MoveHighlight(xDir){//设置上下移动键    
          var currnum=parseInt(parseInt(currentValueSelected)+parseInt(xDir)); 
          //alert('MoveHighlight:'+currentValueSelected+'+'+xDir+'='+currnum); 
         if(currnum >= 0 && currnum<arrOptions.length ){    
           document.getElementById("arr_"+currentValueSelected).className ="spanNormalElement";    
           document.getElementById("arr_"+currnum).className ="spanHighElement";    
           currentValueSelected=currnum;    
           }else if(currnum==arrOptions.length){    
             document.getElementById("arr_"+currentValueSelected+"").className ="spanNormalElement";    
             currentValueSelected=0;    
             document.getElementById("arr_"+currentValueSelected+"").className ="spanHighElement";    
           }else if(currnum==-1){    
             document.getElementById("arr_"+currentValueSelected+"").className ="spanNormalElement";    
             currentValueSelected=arrOptions.length-1;    
             document.getElementById("arr_"+currentValueSelected+"").className ="spanHighElement";    
           }    
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
				<form method="post" action="car.do">
					<input type="hidden" name="flag" value="intocar" />
					<table>
						<tr class="title">
							<th class="checker"></th>
							<th>
								书名
							</th>
							<th class="price">
								价格
							</th>
							<th class="store">
								库存
							</th>
							<th class="view">
								图片预览
							</th>
						</tr>
						<c:forEach items="${bookList}" var= "book">
						<tr>
							<td>
								<input type="checkbox" name="bookId" value="${book.bid }" />
							</td>
						
							<td class="title">
								${book.bookName }
							</td>
							<td>
								${book.price }
							</td>
							<td>
								${book.stock }
							</td>
							<td class="thumb">
								<img src="${book.images }"/>
							</td>	
						</tr>
					</c:forEach>
					</table>
					<div class="page-spliter">
					
						当前页数:[${pageNo } / ${totalPage }]&nbsp;
						<a href="book.do?flag=${flag }&pageNo=1">首页</a>
						<c:if test="${pageNo > 1}">
							<a href="book.do?flag=${flag }&pageNo=${ pageNo-1 }">上一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNo < totalPage }">
							<a href="book.do?flag=${flag }&pageNo=${ pageNo+1 }">下一页</a>&nbsp;
						</c:if>
						<a href="book.do?flag=${flag }&pageNo=${totalPage}">尾页</a>
						
					</div>
					<div class="button">
						<input class="input-btn" type="submit" name="submit" value="" />
					</div>
				</form>
			</div>
		</div>
		<div id="footer" class="wrap">
			网上书城 &copy; 版权所有

		</div>
	</body>
</html>
