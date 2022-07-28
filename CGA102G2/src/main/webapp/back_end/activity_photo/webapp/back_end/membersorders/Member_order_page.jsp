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
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>Document</title>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member_Centre.css">
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
#tableall2{
	text-align:left;
	position:relative;
	left:0px;
	top:-20px;
	display:inline-block;
	
}
.order-informations{
	
	border-radius: 5px;
	position: relative;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	left:200px;
	width: 600px;
	font-size:18px;
}
.order-informations > div{
	padding:3px;
}
.order-informations > span{
	padding:3px;
}
.information:hover{
	background-color:black;
	color:white;
}




	</style>
</head>

<body>
	<header>
		<nav>
			<img class="nav-logo" src="${pageContext.request.contextPath}/images/logo.png" alt="">
			<table class="weather-div">
				<tbody class="weather-tbody">
					<tr class="weather-tr">
					</tr>
					<tr class="weather-tr-1">
					</tr>
				</tbody>	
			</table>
			<div class="icon"></div>
			<img class="nav-top-img" src="${pageContext.request.contextPath}/images/wheather.png" alt="">
			<a href="" class="text">會員登入/註冊</a>
			<a href="" class="nav-top-a">
				<img class="nav-top-img-1"src="${pageContext.request.contextPath}/images/shopping-cart.png" alt="">
			</a>
			<div class="nav-top-bot">
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>首頁</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>最新消息</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>房型介紹</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>關於我們</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>活動商城</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>伴手禮商城</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>媒體報導</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div" >
								<p>會員中心</p>
							</div>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

	<body>
		<div class="body1">
        <div class="name">吳永志</div>
        
        <div class="avatardiv">
            <img src="${pageContext.request.contextPath}/images/camera.png" alt="">
        </div>
		</div>
    </body>

	<aside>
		<ul >
			<li>
				<a href="" class="p1"> 
					<div class="p1div">
						<p>會員資料</p>
					</div>
				</a>
			</li>

		<li>
			<a href="" class="p2"> 
				<div class="p2div">
					<p>資料管理</p>
				</div>
			</a>
		</li>

		<li>
			<a href="" class="p5"> 
				<div class="p5div">
					<p>訊息通知</p>
				</div>
			</a>
		</li>

		<li>
			<a href="" class="p6"> 
				<div class="p6div">
					<p>查看住宿訂單</p>
				</div>
			</a>
		</li>

		<li>
			<a href="" class="p7"> 
				<div class="p7div">
					<p>查看活動訂單</p>
				</div>
			</a>
		</li>

		<li>
			<a href="${pageContext.request.contextPath}/front_end/membersorders/Member_home_page.jsp" class="p8"> 
				<div class="p8div">
					<p>查看商品訂單</p>
				</div>
			</a>
		</li>
	</ul>
</aside>
<main>
	<div id="tableall2">
		<h1 style="margin-left:200px;">商品訂單詳情</h1>
		<div class="order-informations">
			<div>訂購時間</div><fmt:formatDate
							value="${time}"
							pattern="yyyy-MM-dd" />
			<hr>
			<div>會員編號</div>${memberID}
			<hr>
			<div>商品名稱</div>${productName}
			<hr>
			<div>商品單價</div>${price}
			<hr>
			<div>訂購數量</div>${amounts}
			<hr>
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
			<hr>
			<span>總價格$<span style="color : red;">${total}</span></span>
		
		</div>

</div>
	
</main>
	
	<footer>
		<div>
			<p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
			<p>DREAMCENTER</p>
		</div>
	</footer>
	<a href=""><img class="textinfo" src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>
	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
</body>

</html>