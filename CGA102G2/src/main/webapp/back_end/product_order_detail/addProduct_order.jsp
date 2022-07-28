<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%

 
Product_order_detailVO poVO = (Product_order_detailVO)request.getAttribute("poVO");
Product_Service posvc = new Product_Service();
List<Product_VO> podList = posvc.getAll();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomePageCss.css">
</head>
<style>

h3{
	border-bottom:1px solid gray;
	width:470px;
	position:relative;
	font-size:26px;
	top:50px;
}
.errorMsg {
	display: inline-block;
	position: relative;
	left: 260px;
	bottom: -10px;
	font-size: 16px;
}

.errorMsg>ul>li {
	list-style: none;
}
#tableall2{
	position:relative;
	left:200px;
	width:500px;
}
#table-1{
	position:relative;
	width:500px;
}
#table-2{
	position:relative;
	width:500px; 
}
#table-2 > tbody > tr{
	border:none;
	
}
#table-2 > tbody > tr > td{
	
	font-size:18px;
	poistion:relative;
	width:140px;	
}
#table-2 > tbody > tr > td > input{
	width:100px;
	border:1px solid gray;
}
.submitBTN{
	background-color:white;
	border:1px solid black;
	position:relative;
	left:220px;	
	
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
<table id="table-1">
	<tr><td>
		 <h3>商品訂單資料新增</h3>
	</td></tr>
</table>
<%-- 錯誤表列 --%>
<div class="errorMsg">
<c:if test="${not empty errorMsg}">
	<ul>
		<c:forEach var="message" items="${errorMsg}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
</div>
<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
<table id="table-2">
	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="memberId" size="45" 
			 value="<%=((poVO==null)? 0 : poVO.getMember_id())%>" /></td>
	</tr>
	<tr>
		<td>商品ID:</td>
		<td><select size="1" name="productId">
		<c:forEach var="product" items="${podList}">
			<option value="${product.product_id}">${product.product_id}</option>
		</c:forEach>
		</select>
		
		</td>
	</tr>
	<tr>
		<td>購買商品數量:</td>
		<%-- <td><input type="TEXT" name="productNums" size="45"
			 value="<%( (poVO==null)? 0 : poVO.getProduct_amount())%>" /></td> --%>
	
	
	
 
	<jsp:useBean id="poSvc" scope="page" class="d.com.product_order_detail.model.Product_order_detailService" />
	<tr>
		<!-- 付款方式為 0信用法，１現金 -->
		<td>付款方式:</td>
		<td><select size="1" name="paymentMethod">
			<option value="0">信用法</option>
			<option value="1">現金</option>
		</select>
		</td>
	</tr>	
	<tr>
		<!-- 付款狀態 0 已完成交易，1完成付款 ， 2未完成 -->
		<td>付款狀態:</td>
		<td><select size="1" name="orderStatus">
			<option value="0">交易已完成</option>
			<option value="1">付款已完成</option>
			<option value="2">未完成</option>
		</select></td>
	</tr>

</table>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="hidden" name="product_order_id" value="${poVO.product_order_id}">
	<input class="submitBTN" type="submit" value="送出新增">
	</FORM>
</div>
</main>
</body>
</html>