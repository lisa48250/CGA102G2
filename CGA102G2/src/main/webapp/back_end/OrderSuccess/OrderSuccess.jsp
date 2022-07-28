<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動報名稱成功</title>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/success.css" />
	<style>
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
<!-- =======================main區========================== -->

<div class="div1">
	<div class="div2">
		<div class="div3">
			<!-- ========== -->
			<div class="success-checkmark">
				<div class="check-icon">
				  <span class="icon-line line-tip"></span>
				  <span class="icon-line line-long"></span>
				  <div class="icon-circle"></div>
				  <div class="icon-fix"></div>
				</div>
			  </div>
			<!-- ========= -->
			<p class="p2">付款成功，期待您的到來!</p>
		</div>
		
		<a href="${pageContext.request.contextPath}/front_end/frontpage/FrontPage.jsp" class="front-page">回首頁</a>

	</div>
</div>

<!-- =======================footer區========================== -->	
	<footer>
		<div>
			<p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
			<p>DREAMCENTER</p>
		</div>
	</footer>
	<div class="textinfo">
		<a href=""><img class="textinfo" src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>
	</div>
	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
</body>
</html>