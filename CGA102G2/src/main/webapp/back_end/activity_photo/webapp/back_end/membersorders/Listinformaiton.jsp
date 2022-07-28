<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
		//以session取得該會員的編號
		// HttpSession session = request.getSession();
		request.getAttribute("memberID");
		request.getAttribute("time");
		request.getAttribute("productName");
		request.getAttribute("price");
		request.getAttribute("amounts");
		request.getAttribute("payMethod");
		request.getAttribute("status");
		request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member_Centre.css">
<title>Insert title here</title>
	<style>
.body1{
	border: solid 1px white;
	margin-top : 150px;
	height: 255px;
	width: 200px;
	position: relative;
	margin-left: 0px;
	background-color: rgb(180, 178, 178);
	
}
.name{
    position: relative;
    top:35px;
    left: 50px;
    max-width: 150px;
    font-size: 30px;
    color: black;
	margin-top: 160px;
    /* border: solid 2px yellow;  */	
}
.avatardiv{
  position:relative;
  margin-top: -165px;
  height: 140px;
  width: 160px;
  left:15px;
  /* border: solid 3px black; */
}
.avatardiv > img{
    width: 100%;
    height: 100%;
}

#table-2 {
	border-bottom-left-radius: 20px;
	border-bottom-right-radius: 20px;
	border-collapse: collapse;
	table-layout: fixed;
	align-items: center;
}

table {
	border-top-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	/* border: solid red; */
}



tr {
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	width:100%;
	text-align: center;
	align-items: center;
}



th, td {
	padding: 10px;
	text-align: center;
	width: 80px;
	font-size:14px;
	align-items: center;
}



#table-2 > th, td {
	font-size:14px;
	text-align: center;
	align-items: center;
}




/* .search-form{
	
	position: relative;
	text-align: left; 
	
}



 .errorMsg{
	display:inline-block;
	position:relative;
	left:10px;
	bottom:90px;
	font-size: 16px;
} 
.errorMsg > ul > li{
	list-style:none;
}

.form-list{
	list-style:none;
	position: relative;
	left:30px;
	display:inline-block;
	
}
.form-list > li > form{
	margin-top: 20px;
} */

.inputFile{
	position:relative;
	left:150px;
}
@keyframes  swing  {
		15% { transform:  translateX(5px); }
		40% { transform:  translateX(-5px); }
		65% { transform:  translateX(2px); }
		85% { transform:  translateX(-2px); }
		100% { transform:  translateX(0px); }
	}
.Img:hover{
	animation : swing 1s 1;
}

#table-2{
	margin-bottom:100px;
	
} 
table {
	border-radius: 5px;
	position: relative;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 1010px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 3px;
	text-align: center;
}
	
/* thead.thead>tr th:nth-child(2), thead.thead>tr th:nth-child(3) {
	width: 250px;
}

tbody.tbody tr:hover {
	content: attr(title);
	background-color: rgb(208, 255, 255);
} */


.table {
	text-align: center;
}

th, td, tr {
	border: 1px solid darkgray;
}
.Img{
	width:2.4%;
	height:2.2%;
	position:absolute;
	margin-top:-10px;
	margin-left:-11px;
}

h3{
	border:1px solid red;
	position:relative;
	text-align: center;
	height:50px;
	
}
.order-informations{
	
	border-radius: 5px;
	position: relative;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 300px;
	font-size:12px;
}
.order-informations > div{
	padding:3px;
}
.order-informations > span{
	padding:3px;
}

#tableall2{
	
	position:relative;
	right:200px;
}
</style>
</head>
<body>
	<div id="tableall2">
		<h1 style="font-size:16px;">商品詳情</h1>
		<div class="order-informations">
			<div>訂購時間</div><fmt:formatDate
							value="${time}"
							pattern="yyyy-MM-dd HH:mm:ss" />
			<hr style="border: 0.5px solid gray;">
			<div>會員編號</div>${memberID}
			<hr style="border: 0.5px solid gray;">
			<div>商品名稱</div>${productName}
			<hr style="border: 0.5px solid gray;">
			<div>商品單價</div>${price}
			<hr style="border: 0.5px solid gray;">
			<div >訂購數量</div>${amounts}
			<hr style="border: 0.5px solid gray;">
			<div>付款方式</div>
			<c:if test="${payMethod == 0}">
				信用卡
			</c:if>
			<c:if test="${payMethod == 1}">
				現金付款
			</c:if>
			<hr>
			<div>訂單狀態</div>
			<c:if test="${status == 0}">
				已付款
			</c:if>
			<c:if test="${status == 1}">
				完成
			</c:if>
			<c:if test="${status == 2}">
				取消
			</c:if>
			<hr style="border: 0.5px solid gray;">
			<span>總價格$<span style="color : red;">${total}</span></span>
		
		</div>

</div>
</body>
</html>