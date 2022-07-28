<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

	HttpSession session1 = request.getSession();
	session1.getAttribute("memberVO");
%>
	<header>
		<nav>
		<a href="${pageContext.request.contextPath}/front_end/frontpage/FrontPage.jsp" >
			<img class="nav-logo" src="${pageContext.request.contextPath}/images/logo.png" alt="">
			</a>
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
			
			
			
			<c:if test="${memberVO == null }">
			<a href="${pageContext.request.contextPath}/front_end/member/MemberLogin.jsp" class="text">註冊/登入</a>
			</c:if>
			<c:if test="${memberVO != null }">
			<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Logout" id="logout">
			<a   class="text" onclick="document.getElementById('logout').submit();">${memberVO.member_name}/登出</a>
			</FORM>
			</c:if>
			
			
			
			<a href="${pageContext.request.contextPath}/front_end/purchasehomepage/Cart.jsp" class="nav-top-a">
				<img class="nav-top-img-1" src="${pageContext.request.contextPath}/images/shopping-cart.png" alt="">
			</a>
			
			<div class="nav-top-bot">
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/frontpage/FrontPage.jsp" class="">
							<div class="nav-left-div">
								<p>首頁</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/news/NewSelectAll.jsp" class="">
							<div class="nav-left-div">
								<p>最新消息</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/room_type/room_type_introduce.jsp" class="">
							<div class="nav-left-div">
								<p>房型介紹</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/contactus/contactus.jsp" class="">
							<div class="nav-left-div">
								<p>關於我們</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/activity/view_activity_page.jsp" class="">
							<div class="nav-left-div">
								<p>活動商城</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/purchasehomepage/PurchaseHomePage.jsp" class="">
							<div class="nav-left-div">
								<p>伴手禮商城</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/newspost/NewsPost.jsp" class="">
							<div class="nav-left-div">
								<p>媒體報導</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="${pageContext.request.contextPath}/front_end/protect/Member_Data.jsp" class="">
							<div class="nav-left-div">
								<p>會員中心</p>
							</div>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
<script>
const logout = document.querySelector("#logout");
</script>
