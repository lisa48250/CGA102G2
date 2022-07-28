<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="m.com.room.model.*"%>
<%@ page import="m.com.room_type.model.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%-- <%@ page import="java.util.ArrayList"%> --%>
<%-- <%@ page import="java.util.Arrays"%> --%>
<%-- <%@page import="java.util.List" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*"%>

<%
Integer room_type_id = (Integer) request.getAttribute("room_type_id");
RoomService rsvc = new RoomService();
List<RoomVO> roomlist = rsvc.getAllRoomType(room_type_id);
pageContext.setAttribute("roomlist", roomlist);

//Join房型名稱
Room_TypeService rtsvc = new Room_TypeService();
Room_TypeVO roomtype = rtsvc.getOneRoom_Type(room_type_id);
pageContext.setAttribute("roomtype", roomtype);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/listonephoto.css">
<title>房間資料</title>
<!-- ==================* 後台框架區 *================== -->
</head>
<body bgcolor='white'>
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
<%-- 					src="${pageContext.request.contextPath}/images/group (1).png"><a --%>
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

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/talking.png"><a --%>
<!-- 					href="#">消息管理</a> -->

<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>媒體報導管理</a></li> -->
<!-- 						<li><a href=''>最新消息發布</a></li> -->
<!-- 					</ul></li> -->

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

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/camping.png"><a --%>
<!-- 					href="#">活動管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>活動項目管理</a></li> -->
<!-- 						<li><a href=''>活動訂單管理</a></li> -->
<!-- 						<li><a href=''>活動場次管理</a></li> -->

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
	<!-- ==================* 主畫面區 *================== -->
	<main>
		<div id="tableall" style="height: 580px;left: 242px;width:900px">
			<table id="table-1" style="width:900px">
				<tr>
					<td style="left: 407px">
						<h3>房間資料</h3>
						<h4>
							<a
								href="${pageContext.request.contextPath}/back_end/room/select_room_page.jsp"><img
								src="${pageContext.request.contextPath}/images/home.png"
								width="50" height="50" border="0"></a>
						</h4>
					</td>
				</tr>
			</table>

			<table id="table-2" style="width: 900px">
				<tr>
					<th style="width: 400px">房間編號</th>
					<!-- <th style="width: 400px">房型編號</th> -->
					<th style="width: 510px">房型名稱</th>
				<!-- 	<th style="width: 400px">住客名單</th> -->
					<th style="width: 510px">上下架狀態</th>
					<th style="width: 400px">房間狀態</th>
				</tr>
				<c:forEach var="roomVO" items="${roomlist }">
					<tr>
						<td style="width: 400px">${roomVO.room_id}</td>
						<%-- <td style="width: 400px">${roomVO.room_type_id}</td> --%>
						<td style="width: 510px">${roomtype.room_type_name}</td>
						<%-- <td style="width: 400px">${roomVO.room_guest_name}</td> --%>
						<%-- <td style="width:300px">${roomVO.room_sale_status}</td> --%>
						<c:set var="method" value="${roomVO.room_sale_status}" />
						<c:if test="${method == 0 }">
							<td style="width: 400px">上架</td>
						</c:if>
						<c:if test="${method == 1 }">
							<td style="width: 400px">下架</td>
						</c:if>

						<%-- <td style="width:300px">${roomVO.room_status}</td> --%>

						<c:set var="method" value="${roomVO.room_status}" />
						<c:if test="${method == 1 }">
							<td style="width: 400px">已入住</td>
						</c:if>
						<c:if test="${method == 2 }">
							<td style="width: 400px">未入住</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>
</body>
</html>