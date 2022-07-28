<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
Product_order_detailVO poVo = (Product_order_detailVO) request.getAttribute("poVo");
System.out.println(poVo.getOrder_status());
%>
<%-- <%
String creditCard = null;
if (poVo.getPayment_method() == 0) {
	creditCard = "信用卡";
} else {
	creditCard = "現場付款";
}
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomePageCss.css">
<title>修改商品訂單</title>
</head>
<style>
/* 錯誤提示 */
.errorMsg {
	display: inline-block;
	position: relative;
	left: 280px;
	bottom: -265px;
	font-size: 16px;
}

.errorMsg>ul>li {
	list-style: none;
}
h3{
	font-size:24px;
	position:absolute;
	width:500px;
	/* display:inline-block; */
	text-align:center;
	
	top:20px;
	border-bottom:1px solid gray;
}
 #table-2 > tbody > tr{
	display:inline-block;
	text-align:left;
	padding:10px;
	width:500px;
	border:none;
	
} 
#table-2 > tbody > tr > td{
/* border:1px solid red; */
	width:150px;
	font-size:18px;
	/* display:inline-block; */
} 
.prudctAmount{
	width:50px;
	border:1px solid black;
	border-radius:5px;
	width:100px;
	font-size:18px;
}
.submitBTN{
	background-color:white;
	border:1px solid black;
	position:relative;
	left:200px;	
	cursor: pointer;
	width:100px;
	font-size:18px;
	color:black;
}
.submitBTN:hover{
	background-color:black;
	color:white;
}
#tableall2{
	width:500px;
	left: 300px;
}
#table-2{
	width:500px;
	left: 300px;
}
.select{
	font-size:18px;
	border:1px solid black;
	background-color:white;
	cursor:pointer;
}



</style>
<body>
<header>
		<nav class="nav">

			<div class="logo">

				<a href="" class="logo_a"> <img src="${pageContext.request.contextPath}/images/logo.png" alt="">
				</a> <a class="nav-top-a" href=""><img class="nav-top-chat"
					src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>
					 <a href="${pageContext.request.contextPath}/LogoutEmp" class="nav-top-sighout">${jobVO.job_name}/登出</a>
			</div>
			<div class="line"></div>

		</nav>
	</header>

	 <aside class="aside">
        <nav class="nav">
            <div>
                <img src="${pageContext.request.contextPath}/images/group.png">
                <p>${employeeVO.emp_name}</p>
                <hr style="background-color:#757575 ;height:2px;">
            </div>
            <ul class="nav_list">
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/group (1).png"><a href="#">員工管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>員工資料</a></li> -->
<!--                         <li><a href=''>員工權限</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/social-group.png"><a href="#">會員管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>會員資料</a></li> -->
<!--                         <li><a href=''>會員通知管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a> --%>
                
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>媒體報導管理</a></li> -->
<!--                         <li><a href=''>最新消息發布</a></li> -->
<!--                     </ul>                 -->
<!--                 </li> -->
               
<!--                  <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/bed.png"><a href="#">房務管理</a> --%>
<!--                     <ul id="list"> -->
<!--                        	<li><a href=''>住宿訂單管理</a></li> -->
<!--                         <li><a href=''>訂單明細管理</a></li> -->
<!--                         <li><a href=''>房型管理</a></li> -->
<!--                         <li><a href=''>房間管理</a></li> -->
<!--                         <li><a href=''>房型圖片管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/camping.png"><a href="#">活動管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>活動類別管理</a></li> -->
<!--                         <li><a href=''>活動項目管理</a></li> -->
<!--                         <li><a href=''>活動場次管理</a></li> -->
<!--                         <li><a href=''>活動訂單管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
                <li>
                    <img src="${pageContext.request.contextPath}/images/gift.png"><a href="${pageContext.request.contextPath}/back_end/product_order_detail/homepage.jsp">伴手禮管理</a>
                      <ul id="list">
                        <li><a href='<%=request.getContextPath() %>/back_end/product_order_detail/homepage.jsp'>查詢全部訂單</a></li> 
                        <li><a href="<%=request.getContextPath() %>/back_end/product_category/Select_page.jsp">商品類別管理</a></li>
                        <li><a href="<%=request.getContextPath() %>/back_end/product/Select_page.jsp">商品管理</a></li>
                        <li><a href="<%=request.getContextPath() %>/back_end/product_pics/Select_page.jsp">商品圖片管理</a></li>
                    </ul>
                </li>
                
                
               
            </ul>
        </nav>
    </aside>
   <main> 
	
<div id="tableall2">
<h3 style="position:relative; bottom:20px;">訂單修改</h3>
<table id="table-1">
	<%-- 錯誤表列 --%>
	<div class="errorMsg">
	<c:if test="${not empty errorMsg}">
		<ul>
			<c:forEach var="message" items="${errorMsg}">
				<li style="color: red">*${message}</li>
			</c:forEach>
		</ul>
	</c:if>
</div>	
</table>

	<FORM method="post" ACTION="${pageContext.request.contextPath}/Product_order_detailServlet" name="">
		<table id="table-2">
			<tr>
				<td>訂單編號:<font color=red><b>*</b></font></td>
				<td><%=poVo.getProduct_order_id()%></td>
			</tr>
			<tr>
				<td>員工編號:<font color=red><b>*</b></font></td>
				<td><%=poVo.getMember_id()%></td>
				
			</tr>
			<tr>
				<td>訂單日期:<font color=red><b>*</b></font></td>
				<td><fmt:formatDate value="${poVo.product_order_date}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td>商品數量:<b></b></td>
				<td><input class="prudctAmount" type="text" name="productNums" size="100"
					value="${poVo.getProduct_amount()}" /></td>
			</tr>
			<tr>
				<td>付款方式:<b></b></td>
				<td><select class="select" name="payMethod">
						<option value="0" ${(poVo.payment_method==0)?'selected' :''} >信用卡</option>
						<option value="1" ${(poVo.payment_method==1)?'selected' :''}>現場付款</option>
				</select></td>
			</tr>
			<tr>
				<td>訂單狀態:<b></b></td>
				<td>
				<select class="select" name="orderStatus">
					<option value="0" ${(poVo.order_status==0)?'selected' :''}>已付款</option>
					<option value="1" ${(poVo.order_status==1)?'selected' :''}>訂購完成</option>
					<option value="2" ${(poVo.order_status==2)?'selected' :''}>取消</option>
				</select>
				</td>
			</tr>


		</table>
		<input type="hidden" name="action" value="update"> 
		<input type="hidden" name="product_order_id" value="<%=poVo.getProduct_order_id()%>">
		<input type="hidden" name="memberId" value="<%=poVo.getMember_id()%>"/>
		
		<input type="hidden" name="orderDate" value="<fmt:formatDate value="${poVo.product_order_date}"
						pattern="yyyy-MM-dd" />"/> 
		<input class="submitBTN" type="submit" value="送出修改">
	</FORM>
</div>	
</main>



</body>
</html>