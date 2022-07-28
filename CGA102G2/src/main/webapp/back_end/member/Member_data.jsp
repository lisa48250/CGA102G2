<%-- <%@ page language="java" contentType="text/html; charset=BIG5"pageEncoding="BIG5"%> --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.members.model.*"%>
<!DOCTYPE html>

<%
MemberVO memberVO = (MemberVO) request.getAttribute("memberVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>

<body>
	<header>
		<nav>
			<img class="nav-logo" src="./logo.png" alt="">
			<table class="weather-div">
				<tbody class="weather-tbody">
					<tr class="weather-tr">
					</tr>
					<tr class="weather-tr-1">
					</tr>
				</tbody>	
			</table>
			<div class="icon"></div>
			<img class="nav-top-img" src="./wheather.png" alt="">
			<a href="" class="text">會員登入/註冊</a>
			<a href="" class="nav-top-a">
				<img class="nav-top-img-1"src="./shopping-cart.png" alt="">
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
            <img src="camera.png" alt="">
        </div>
		</div>
    </body>

	<aside>
		<ul >
		<li>
			<span>會員資料</span>
		</li>
		<li>
			<span>資料管理</span>
			<ul>
				<li> 更改密碼</li>
				<li> 更改會員資料</li>
			</ul>
		</li>
		<li>
			<span>訊息通知</span>
		</li>
		<li>
			<span>查看住宿訂單</span>
		</li>
		<li>
			<span>查看活動訂單</span>
		</li>
		<li>
			<span>查看購物訂單</span>
		</li>
		</ul>
</aside>
<ul>
 <jsp:useBean id="memberSvc" scope="page" class="com.members.model.MemberService" />
   
  <li>
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Member_Servlet" >
       <b>選擇會員編號:</b>
       <select size="1" name="member_id">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.member_id}">${memberVO.member_id}
         </c:forEach>  
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
</ul>

<div class="data">
<p class="p1">
	基本資料
</p>
<tr>
<p class="Email">
	會員Email: <td>${memberVO.member_email}</td>
</p>

<p class="Member_name">
	會員姓名:	<td>${memberVO.member_name}</td>
</p>

<p class="phone">
	會員電話:	<td>${memberVO.member_phone}</td>
</p>

<p class="address">
	會員地址:	<td>${memberVO.member_address}</td>
</p>
</tr>
</div>
	
	<footer>
		<div>
			<p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
			<p>DREAMCENTER</p>
		</div>
	</footer>
	<div class="textinfo">
		<p>文字客服</p>
	</div>
	<script src="./weather.js"></script>
	<script src="./hidden.js"></script>
	<script src="./date.js"></script>
	<script src="./icon.js"></script>
</body>

</html>