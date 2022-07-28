<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="m.com.room_order_list.model.*"%>

<%
Room_order_listVO room_order_listVO = (Room_order_listVO) request.getAttribute("room_order_listVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/listonetype.css">
<title>訂單明細</title>


<!-- ==================* 後台框架區 *================== -->
</head>
<body bgcolor='white'>
	<header>
		<nav class="nav">

			<div class="logo">

				<a href="" class="logo_a"> <img
					src="${pageContext.request.contextPath}/images/logo.png" alt="">
				</a> <a class="nav-top-a" href=""><img class="nav-top-chat"
					src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>

				<a href="" class="nav-top-sighout">登出</a>
			</div>
			<div class="line"></div>

		</nav>
	</header>

	<aside class="aside">
		<nav class="nav">
			<div>
				<img src="${pageContext.request.contextPath}/images/group.png">
				<p>林家玄</p>
				<hr style="background-color: #757575; height: 2px;">
			</div>
			<ul class="nav_list">

				<li><img
					src="${pageContext.request.contextPath}/images/group (1).png"><a
					href="#">員工管理</a>
					<ul id="list">
						<li><a href=''>員工資料</a></li>
						<li><a href=''>員工權限</a></li>
					</ul></li>

				<li><img
					src="${pageContext.request.contextPath}/images/social-group.png"><a
					href="#">會員管理</a>
					<ul id="list">
						<li><a href=''>會員資料</a></li>
						<li><a href=''>會員通知管理</a></li>
					</ul></li>

				<li><img
					src="${pageContext.request.contextPath}/images/talking.png"><a
					href="#">消息管理</a>

					<ul id="list">
						<li><a href=''>媒體報導管理</a></li>
						<li><a href=''>最新消息發布</a></li>
					</ul></li>

				<li><img
					src="${pageContext.request.contextPath}/images/bed.png"><a
					href="#">房務管理</a>
					<ul id="list">
						<li><a
							href="${pageContext.request.contextPath}/back_end/room_order/select_room_order_page.jsp">住宿訂單管理</a></li>
						<li><a
							href="${pageContext.request.contextPath}/back_end/room_order_list/listAllRoom_Order_List.jsp">訂單明細管理</a></li>
						<li><a
							href="${pageContext.request.contextPath}/back_end/room_type/select_page.jsp">房型管理</a></li>
						<li><a
							href="${pageContext.request.contextPath}/back_end/room/select_room_page.jsp">房間管理</a></li>
						<li><a
							href="${pageContext.request.contextPath}/back_end/room_type_photo/select_room_type_photo_page.jsp">房型圖片管理</a></li>
					</ul></li>

				<li><img
					src="${pageContext.request.contextPath}/images/camping.png"><a
					href="#">活動管理</a>
					<ul id="list">
						<li><a href=''>活動項目管理</a></li>
						<li><a href=''>活動訂單管理</a></li>
						<li><a href=''>活動場次管理</a></li>

					</ul></li>

				<li><img
					src="${pageContext.request.contextPath}/images/gift.png"><a
					href="#">伴手禮管理</a>
					<ul id="list">
						<li><a href=''>查詢全部訂單</a></li>
						<li><a href=''>新增商品訂單</a></li>
						<li><a href=''>商品類別管理</a></li>
						<li><a href=''>商品管理</a></li>
						<li><a href=''>商品圖片管理</a></li>
					</ul></li>


			</ul>
		</nav>
	</aside>
	<!-- ==================* 主畫面區 *================== -->
	<main>
		<div id="tableall" style="height: 500px">


			<table id="table-1" style="left: 230px">
				<tr>
					<td>
						<h3>訂單明細資料</h3>
						<h4>
							<a
								href="${pageContext.request.contextPath}/back_end/room_order_list/listAllRoom_Order_List.jsp"><img
								src="${pageContext.request.contextPath}/images/home.png"
								width="50" height="50" border="0"></a>
						</h4>
					</td>
				</tr>
			</table>

			<table id="table-2" style="margin-left: 156px;">
				<tr>
					<td class="name">➕ 住宿訂單明細編號</td>
					<td class="value">${room_order_listVO.room_order_list_id}</td>
				</tr>
				<tr>
					<td class="name">➕ 住宿訂單編號</td>
					<td class="value">${room_order_listVO.room_order_id}</td>
				</tr>
				<tr>
					<td class="name">➕ 房型編號</td>
					<td class="value" >${room_order_listVO.room_type_id}</td>
				</tr>
				<tr>
					<td class="name">➕ 房間編號</td>
					<td class="value">${room_order_listVO.room_id}</td>
				</tr>
				<tr>
					<td class="name">➕ 人數</td>
					<td class="value">${room_order_listVO.number_of_people}</td>
				</tr>
				<tr>
					<td class="name">➕ 房間價格</td>
					<td class="value">${room_order_listVO.room_price}</td>
				</tr>
				<tr>
					<td class="name">➕ 特殊要求</td>
					<td class="value">${room_order_listVO.special_req}</td>
				</tr>


				<%-- <tr>
					<td>${room_order_listVO.room_order_list_id}</td>
					<td>${room_order_listVO.room_order_id}</td>
					<td>${room_order_listVO.room_type_id}</td>
					<td>${room_order_listVO.room_id}</td>
					<td>${room_order_listVO.number_of_people}</td>
					<td>${room_order_listVO.special_req}</td>
					<td>${room_order_listVO.room_price}</td>
				</tr> --%>
			</table>
		</div>
	</main>

</body>
</html>