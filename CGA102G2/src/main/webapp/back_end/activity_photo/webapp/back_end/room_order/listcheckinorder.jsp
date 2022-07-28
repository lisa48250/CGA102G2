<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="m.com.room_order.model.*"%>
<%@ page import="m.com.room_order_list.model.*"%>
<%@ page import="m.com.room_type.model.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*"%>
<%@ page import=" java.sql.Date"%>

<%
/* Date check_in_date = (Date)request.getAttribute("check_in_date");
Room_OrderService room_orderSvc = new Room_OrderService();
List<Room_OrderVO> listall = room_orderSvc.getCheckin(check_in_date);
pageContext.setAttribute("listall", listall); */
Integer room_order_id = (Integer)request.getAttribute("room_order_id");
Room_OrderService room_orderSvc = new Room_OrderService();
List<Room_order_listVO> listall = room_orderSvc.getList(room_order_id);
pageContext.setAttribute("listall", listall);


// join房型名稱
Room_TypeService  rtsvc = new Room_TypeService();
Room_TypeVO roomtype;
for(Room_order_listVO list1 : listall){
	Integer room_type_id = list1.getRoom_type_id();
	roomtype = rtsvc.getOneRoom_Type(room_type_id);
	pageContext.setAttribute("roomtype", roomtype );
}


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/listonephoto.css">
<title>住宿訂單之明細資料</title>
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
	<div id="tableall" style="height: 500px;left: 242px;width:900px">
			<table id="table-1" style="width:900px">
		<tr>
			<td style="left: 350px">
				<h3>住宿訂單之明細資料</h3>
				<h4>
					<a
								href="${pageContext.request.contextPath}/back_end/room_order/select_room_order_page.jsp"><img
								src="${pageContext.request.contextPath}/images/home.png"
								width="50" height="50" border="0"></a>
				</h4>
			</td>
		</tr>
	</table>

	<table id= "table-2" style="width: 900px;border-spacing:0px 10px;">
		<tr>
			<th style="width: 400px">明細編號</th>
			<th style="width: 400px">訂單編號</th>
			<!-- <th style="width: 400px">房型編號</th> -->
			<th style="width: 400px">房型名稱</th>
			<th style="width: 400px">房間編號</th>
			<th style="width: 400px">人數</th>
			<th style="width: 400px">特殊要求</th>
			<th style="width: 400px">房間價格</th>
		</tr>
		<c:forEach var="Room_order_listVO" items="${room_order_listVO}">
			<tr>
				<td style="width: 400px">${Room_order_listVO.room_order_list_id}</td>
			<td style="width: 400px">${Room_order_listVO.room_order_id}</td>
			<%-- <td style="width: 400px">${Room_order_listVO.room_type_id}</td> --%>
			<td style="width: 400px">${roomtype.room_type_name}</td>
			<td style="width: 400px">${Room_order_listVO.room_id}</td>
			<td style="width: 400px">${Room_order_listVO.number_of_people}</td>
			<td style="width: 400px">${Room_order_listVO.special_req}</td>
			<td style="width: 400px">${Room_order_listVO.room_price}</td>
			</tr>
		</c:forEach>
	</table>

</div>
</main>
</body>
</html>