<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="h.com.new_list.model.*"%>
<jsp:useBean id="News_list" scope="request"
	class="h.com.new_list.model.News_listService" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/backendnews.css">
</head>
<body>
	<header>
		<nav class="nav">

			<div class="logo">

				<a href="" class="logo_a"> <img
					src="${pageContext.request.contextPath}/images/logo.png" alt="">
				</a> <a class="nav-top-a" href="${pageContext.request.contextPath}/front_end/chat/chat.jsp"><img class="nav-top-chat"
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
				<hr style="background-color: #757575; height: 2px;">
			</div>
			<ul class="nav_list">

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images//group (1).png"><a --%>
<!-- 					href="#">員工管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>員工資料</a></li> -->
<!-- 						<li><a href=''>員工權限</a></li> -->
<!-- 					</ul></li> -->

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/social-group.png"><a --%>
<!-- 					href="#">會員管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>會員資料</a></li> -->
<!-- 						<li><a href=''>會員通知管理</a></li> -->
<!-- 					</ul></li> -->

				<li><img
					src="${pageContext.request.contextPath}/images/talking.png"><a
					href="#">消息管理</a>

					<ul id="list">
                        <li><a href='${pageContext.request.contextPath}/back_end/newspost/select_page_news.jsp'>媒體報導管理</a></li>
                        <li><a href='${pageContext.request.contextPath}/back_end/news/NewsBackselectAll.jsp'>最新消息管理</a></li>
                        
                    </ul>  
</li>
<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/bed.png"><a --%>
<!-- 					href="#">房務管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>住宿訂單管理</a></li> -->
<!-- 						<li><a href=''>訂單明細管理</a></li> -->
<!-- 						<li><a href=''>房型管理</a></li> -->
<!-- 						<li><a href=''>房間管理</a></li> -->
<!-- 						<li><a href=''>房型圖片管理</a></li> -->
<!-- 					</ul></li> -->

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/camping.png"><a --%>
<!-- 					href="#">活動管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>活動類別管理</a></li> -->
<!-- 						<li><a href=''>活動項目管理</a></li> -->
<!-- 						<li><a href=''>活動場次管理</a></li> -->
<!-- 						<li><a href=''>活動訂單管理</a></li> -->
<!-- 					</ul></li> -->

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/gift.png"><a --%>
<!-- 					href="#">伴手禮管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>查詢全部訂單</a></li> -->
<!-- 						<li><a href=''>新增商品訂單</a></li> -->
<!-- 						<li><a href=''>商品類別管理</a></li> -->
<!-- 						<li><a href=''>商品管理</a></li> -->
<!-- 						<li><a href=''>商品圖片管理</a></li> -->
<!-- 					</ul></li> -->
			</ul>
		</nav>
	</aside>
	<main>
		<h1 class="p">最新消息查詢</h1>
		<div class="right-1">
			<a
				href="${pageContext.request.contextPath}/back_end/news/NewsBackInsert.jsp"><span
				class="span-1">新增最新消息</span></a> <span class="span-2">/</span> <a
				href="${pageContext.request.contextPath}/back_end/news/NewsBackselectAll.jsp"><span
				class="span-3">查詢最新消息</span></a>
		</div>
		<div class="control">
			<table class="back1" cellspacing="4" cellpadding="4" border="2">
				<tr>
					<th class="id">編號</th>
					<th class="title">標題</th>
					<th>內容</th>
					<th class="date">日期</th>
					<th class="photo">圖片</th>
					<th class="update">修改</th>
					<th class="delete">刪除</th>
				</tr>

				<c:forEach var="data" items="${News_list.all}">
					<tr>
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/News">

							<td>${data.news_id}</td>
							<td>${data.news_id_title}</td>
							<td>${data.news_id_description}</td>
							<td>${data.news_id_date}</td>
							<td><img
								src="${pageContext.request.contextPath}/NewsReader?news_id=${data.news_id}"
								alt=""></td>
						</FORM>

						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/NewsBackUpdate">
							<td><input type="submit" value="修改"></td> <input
								type="hidden" name="news_id" value="${data.news_id}"> <input
								type="hidden" name="action" value="forward">

						</FORM>
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/NewsBackUpdate">
							<td><input type="submit" value="刪除"></td> <input
								type="hidden" name="news_id" value="${data.news_id}"> <input
								type="hidden" name="action" value="delete">
						</FORM>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>
</body>
</html>