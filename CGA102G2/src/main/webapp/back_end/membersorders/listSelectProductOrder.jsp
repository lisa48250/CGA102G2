<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.members.model.*"%>
<%
		
		MemberVO membervo = (MemberVO)session.getAttribute("memberVO");
		Product_order_detailService podSVC = new Product_order_detailService();
		List<Product_order_detailVO> podVOlist = podSVC.getOrderListByMemberId(membervo.getMember_id());
														//以session取得該會員的編號
														// HttpSession session = request.getSession();
		pageContext.setAttribute("podVOlist", podVOlist);
		
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
table {
	width: 1010px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 0px;
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
	margin-bottom:10px;
	
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
	position:relative;
	margin-top:-50px;
}
.search-form {
	border-radius: 5px;
	position: relative;
	display:inline-block;
	text-align: left;
	/* background-color: rgb(253, 253, 253); */
	/* box-shadow: 2px 2px 3px 3px #cccccc; */
	/* width:45%; */
	height: 100px;
	left: 600px;
	/* bottom: 100px; */
	width:300px;
}
.search-form > form{
	display:inline-block;
}

.title {
	/* border: 1px solid black; */
	display: inline-block;
	font-size: 30px;
	position: relative;
	left: 30px;
	color: black;
	top: -80px;
}

.errorMsg {
	position: relative;
	/* right: 500px; */
	left:-220px; 
	bottom: 28px; 
	font-size: 16px;
}

.errorMsg>ul>li {
	list-style: none;
}

.form-list {
	list-style: none;
	position: relative;
	left: 30px;
	display: inline-block;
}

.form-list>li>form {
	margin-top: 20px;
}
.newest{
	position:relative;
	left:20px;
	/* background-color:white; */
	border:1px solid black;
}
.b{
	position:relative;
	right:600px;
	top:40px;
	font-size:24px;
}
.f1{
	position:relative;
	right:280px;
	top:25px;
	font-size:20px;
}
.f2{
	position:relative;
	top:-2px;
	font-size:20px;
}
#f3{
	
	position:relative;
	left:200px;
	top:-30px;
	font-size:20px;
}
.information{

border:1px solid black; 
cursor:pointer; 
border-radius:5px; 
background-color:white; 
color:gray; font-size:19px; 
position:relative; 
left:28px;
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
<main id="main">
	<div class="search-form">
			
			
					<b class="b">會員編號： ${membervo.member_id}<b style="color:red">*</b ></b>
				
					<FORM class="f1" METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
					
						<b>輸入訂單編號 :</b> 
						<input style="border: 1px solid black; width:100px;"type="text" name="product_id"> 
						<input
							type="hidden" name="action" value="getOne_Product_DetailForMembers">
						<input style="border: 1px solid black; cursor:pointer;"  type="submit" value="送出"><br>
					
					</FORM>
					<FORM class="f2" METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
					
						<b> 查詢訂單狀態:</b>
						<select onchange="this.form.submit()" name="status" style="border:1px solid black; cursor:pointer;">
							<option>請選擇</option>
							<option value="0">已付款</option>
							<option value="1">完成</option>
							<option value="2">取消</option>
						</select>
						<input type="hidden" name="action" value="status-select"> 
					</FORM>
					<FORM id="f3" METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
						<b> 查詢最近訂單:</b>
						<select  onchange="this.form.submit()" name="action" style="border:1px solid black; cursor:pointer;">
						<option>請選擇</option> 
						<option value="newest-order">當天訂單</option>
						<option value="yesterday-order">昨天訂單</option>
						<option value="7days-order">7天前的訂單</option>
						<!-- <input style="cursor:pointer;" class="newest" type="submit" value="查詢當天訂單">
						<input type="hidden" name="action" value="newest-order"> -->
						</select>
					</FORM>
				
<div class="errorMsg">
				<c:if test="${not empty errorMsg}">
					<ul>
						<c:forEach var="message" items="${errorMsg}">
							<li style="color: red">*${message}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>


			
		</div>


	<div id="tableall2">
	 
		<h1 >購物訂單</h1>
			<table id="table-2">
			<tbody>
			<tr>
				<th>訂單編號</th>
				<th>會員編號</th>
				<th>訂購日期</th>
				<th>購買數量</th>
				<th>付款方式</th>
				<th>訂單狀態</th>
				<th>查看詳情</th>
				<!-- <th>取消訂單</th> -->

			</tr>

			
			
			
				<tr>
					<td>${poVO.product_order_id}</td>
					<td>${poVO.member_id}</td>
					<td><fmt:formatDate
							value="${poVO.product_order_date}"
							pattern="yyyy-MM-dd" /></td>
					<td>${poVO.getProduct_amount()}</td>
					<c:set var="method" value="${poVO.payment_method}" />
					<c:if test="${method == 0}">
						<td>信用卡</td>
					</c:if>
					<c:if test="${method == 1}">
						<td>現場付款</td>
					</c:if>

					<c:set var="status" value="${poVO.order_status}" />
					<c:if test="${status == 0}">
						<td>已付款</td>
					</c:if>
					<c:if test="${status == 1}">
						<td>完成</td>
					</c:if>
					<c:if test="${status == 2}">
						<td>取消</td>
					</c:if>

					<td>
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/Product_order_detailServlet"
							style="margin-bottom: 0px; position:relative;width:20px;">
							<input class="information" type="submit" name="action" value="查看詳情" >
							<input type="hidden" name="product_order_listID" value="${eachOrderListVO.product_order_id}">
						</FORM>
					</td>
					<%-- <td>
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/Product_order_detailServlet"
							style="margin-bottom: 0px; width:20px;">
							<input class="delete" type="submit" name="action" value="取消" style="border:1px solid black; cursor:pointer; border-radius:5px;background-color:white; color:gray; font-size:19px; position:relative; left:30px">
							<input type="hidden" name="product_order_listID" value="${eachOrderListVO.product_order_id}">
						</FORM>
					</td> --%>
				</tr>
			
			</tbody>
		</table>
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
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script> 
	$('tbody').sortable();
	
	</script>
</body>

</html>