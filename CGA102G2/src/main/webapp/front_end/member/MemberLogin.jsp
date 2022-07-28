<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<title>會員登入</title>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<style>

.div{
	height:0px;
	position: relative;
	top: -150px;
/* 	margin-top:-130px; */
	
	
	}

.div-top {
	width: 600px;
	height: 110px;
	background-color: red;
	border-radius: 20px 20px 0px 0px;
	position: absolute;
	margin-bottom: -80px;
	left: 335px; /*雲淡風輕往左*/
	top: 300px;
	background-color: #3B413B;
}

.div-bottom {
	background-color: rgb(59, 65, 59, 0.5);
	position: absolute;
	top: 400px;
	left: 335px;
	width: 600px;
	height: 300px;
	border-radius: 0px 0px 20px 20px;
}

.div-img img {
	width: 350px;
	height: 80px;
	position: relative;
	top: 20px;
	left: 0px;
}

.div-span span {
	font-size: 30px;
	color: white;
	position: relative;
	top: -35px;
	right: -390px;
	letter-spacing: 2px;
}

.input1 input {
	background-color: white;
	padding: 15px 30px 15px 30px;
	border-radius: 30px;
	width: 360px;
	border-color: transparent;
	position: relative;
	top: 30px;
	font-size: 25px;
	letter-spacing: 2px;
	left: 120px;
	color: #3B413B;
	text-align: center;
}

.input2 input {
	width: 360px;
	padding: 15px 30px 15px 30px;
	border-radius: 30px;
	border-color: transparent;
	background-color: white;
	position: relative;
	top: 68px;
	font-size: 25px;
	letter-spacing: 2px;
	left: 120px;
	color: #3B413B;
	text-align: center;
}

.input3 input {
	width: 280px;
	padding: 15px 30px 15px 30px;
	border-radius: 45px;
	border-color: transparent;
	background-color: white;
	position: relative;
	top: 100px;
	font-size: 25px;
	left: 155px;
	background-color: #3B413B;
	color: white;
}

.input4 input {
	width: 120px;
	padding: 15px 30px 15px 30px;
	border-radius: 45px;
	border-color: transparent;
	background-color: white;
	position: relative;
	top: 45px;
	font-size: 16px;
	left: 470px;
	background-color: white;
	color: black;
}

.R{
	position: relative;
	left:470px;
	top:60px;
	font-size:25px;
	}
	
.forget{
		position: relative;
		left:475px;
/* 		margin-top:-100px; */
		top:70px;
		font-size:18px;	
		color: white;
			}
.error{
	position: relative;
	left:940px;
	top:350px;	

	}
</style>

	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
</head>

<body background="">

<!-- 	<header> -->
<!-- 		<nav> -->
<%-- 			<img class="nav-logo" src="${pageContext.request.contextPath}/images/logo.png" alt=""> --%>
<!-- 			<table class="weather-div"> -->
<!-- 				<tbody class="weather-tbody"> -->
<!-- 					<tr class="weather-tr"> -->
<!-- 					</tr> -->
<!-- 					<tr class="weather-tr-1"> -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
<!-- 			</table> -->
<!-- 			<div class="icon"></div> -->
<%-- 			<img class="nav-top-img" src="${pageContext.request.contextPath}/images/wheather.png" alt="">  --%>
<!-- 			<a href="" class="text">會員登入/註冊</a> <a href="" class="nav-top-a"> <img -->
<%-- 				class="nav-top-img-1" src="${pageContext.request.contextPath}/images/shopping-cart.png" alt=""> --%>
<!-- 			</a> -->
<!-- 			<div class="nav-top-bot"> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>首頁</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>最新消息</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>房型介紹</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>關於我們</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>活動商城</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>伴手禮商城</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>媒體報導</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 				<ul class="nav-ul-bot"> -->
<!-- 					<li class="nav-li"> -->
<!-- 						<a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>會員中心</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</nav> -->
<!-- 	</header> -->
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
<c:if test="${not empty errorMsgs}">
<div class="error">	
<font style="color:red"></font>

		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>

</div>
</c:if>

		<form action="${pageContext.request.contextPath}/loginhandler"method="post">

			<div class="div">
				<div class=" div-top">
					<div class="div-img">
						<img src="${pageContext.request.contextPath}/images/1.png" alt="">
					</div>
					<div class="div-span">
						<span>會員登入</span>
					</div>
				</div>
				<div class="div-bottom">
					<div class="input1">
						<input type="text" name="account" value="${memberVO.member_email}" placeholder="請輸入會員帳號">

					</div>
					<div class="input2"> 
						<input type="password" name="password" value="${memberVO.member_password}" placeholder="請輸入會員密碼">

					</div>
					<div class="input3">
						<input type="hidden" name="action" value="Login">
						<input style="cursor:pointer;" type="submit" value="登入">
					</div>

					<div class="input4">
						<a class="R" href="${pageContext.request.contextPath}/front_end/member/Registered_Member.jsp">
						註冊會員
						</a>
					</div>
					
					<div class="input5">
						<a class="forget" href="${pageContext.request.contextPath}/front_end/member/forgetpassword.jsp">
						忘記密碼
						</a>
					</div>

				</div>
			</div>
	</form>
	<br>
	<br>
</body>

</html>