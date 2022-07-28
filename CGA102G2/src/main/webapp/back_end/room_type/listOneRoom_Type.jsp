<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="m.com.room_type.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  Room_TypeVO room_typeVO = (Room_TypeVO) request.getAttribute("room_typeVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/listonetype.css">
<title>房型資料</title>

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
						 <li><a href="${pageContext.request.contextPath}/back_end/room_order/select_room_order_page.jsp">住宿訂單管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_order_list/listAllRoom_Order_List.jsp">訂單明細管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_type/select_page.jsp">房型管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room/select_room_page.jsp">房間管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_type_photo/select_room_type_photo_page.jsp">房型圖片管理</a></li>
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
		<div id="tableall">
			<table id="table-1">
				<tr>
					<td>
						<h3>房型資料</h3>
						<h4><a href="${pageContext.request.contextPath}/back_end/room_type/select_page.jsp"><img src="${pageContext.request.contextPath}/images/home.png" width="50" height="50" border="0"></a></h4>					
						</td>
				</tr>
			</table>


			<table id="table-2">
				<tr>
					<td class="name">➕ 房型編號</td>
					<td class="value"><%=room_typeVO.getRoom_type_id()%></td>
				</tr>
				<tr>
					<td class="name">➕ 房型名稱</td>
					<td  class="value"><%=room_typeVO.getRoom_type_name()%></td>
				</tr>
				<tr>
					<td class="name">➕ 房型數量</td>
					<td  class="value"><%=room_typeVO.getRoom_type_amount()%></td>
				</tr>
				<tr>
					<td class="name">➕ 上下架狀態</td>
					<c:set var="method" value="${room_typeVO.room_type_sale_status}" />
					<c:if test="${method == 0 }">
						<td class="value">上架</td>
					</c:if>
					<c:if test="${method == 1 }">
						<td class="value">下架</td>
					</c:if>
					<%-- <td  class="value"><%=room_typeVO.getRoom_type_sale_status()%></td> --%>
				</tr>
				<tr class="pic">
					<td class="name">➕ 房型照片</td>
					<td  class="value"><img  id="room-img" 
						src="<%=request.getContextPath()%>/Room_Type_Reader?id=<%=room_typeVO.getRoom_type_id()%>"></td>
				</tr>
				<tr>
					<td class="name">➕ 房型價格</td>
					<td  class="value"><%=room_typeVO.getRoom_type_price()%></td>
				</tr>
				<tr>
					<td class="name">➕ 評價總覽
					<td  class="value"><%=room_typeVO.getRoom_total_review()%></td>
				</tr>
				<tr>
					<td class="name">➕ 房型說明</td>
					<td  class="value"><%=room_typeVO.getRoom_type_content()%></td>
				</tr>

				<%-- <tr>
		<td><%=room_typeVO.getRoom_type_id()%></td>
		<td><%=room_typeVO.getRoom_type_name()%></td>
		<td><%=room_typeVO.getRoom_type_amount()%></td>
		<td><%=room_typeVO.getRoom_type_content()%></td>
		<td><%=room_typeVO.getRoom_type_sale_status()%></td>
		<td><%=room_typeVO.getRoom_total_review()%></td>
		<td><img src="<%=request.getContextPath()%>/Room_Type_Reader?id=<%=room_typeVO.getRoom_type_id()%>"></td>
		<td><%=room_typeVO.getRoom_type_price()%></td>
	</tr> --%>
			</table>
			
			</div>
			</main>
</body>
</html>