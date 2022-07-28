<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>房型資料修改</title>

<!-- ==================* 後台框架區 *================== -->
</head>
<body bgcolor='white'>
<header>
        <nav class="nav">

            <div class="logo">

                <a href="" class="logo_a">
                    <img src="${pageContext.request.contextPath}/images/logo.png" alt="">
                </a>

                <a class="nav-top-a" href=""><img class="nav-top-chat" src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>

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
                <hr style="background-color:#757575 ;height:2px;">
            </div>
            <ul class="nav_list">
                
                <li>
                    <img src="${pageContext.request.contextPath}/images/group (1).png"><a href="#">員工管理</a>
                    <ul id="list">
                        <li><a href=''>員工資料</a></li>
                        <li><a href=''>員工權限</a></li>
                    </ul>
                </li>
                
                <li>
                    <img src="${pageContext.request.contextPath}/images/social-group.png"><a href="#">會員管理</a>
                    <ul id="list">
                        <li><a href=''>會員資料</a></li>
                        <li><a href=''>會員通知管理</a></li>
                    </ul>
                </li>
               
                <li> 
                    <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a>
                
                    <ul id="list">
                        <li><a href=''>媒體報導管理</a></li>
                        <li><a href=''>最新消息發布</a></li>
                    </ul>                
                </li>
               
                <li> 
                    <img src="${pageContext.request.contextPath}/images/bed.png"><a href="#">房務管理</a>
                    <ul id="list">
                        <li><a href="${pageContext.request.contextPath}/back_end/room_order/select_room_order_page.jsp">住宿訂單管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_order_list/listAllRoom_Order_List.jsp">訂單明細管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_type/select_page.jsp">房型管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room/select_room_page.jsp">房間管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_type_photo/select_room_type_photo_page.jsp">房型圖片管理</a></li>
                   
                    </ul>
                </li>
               
                <li> 
                    <img src="${pageContext.request.contextPath}/images/camping.png"><a href="#">活動管理</a>
                    <ul id="list">
                        <li><a href=''>活動項目管理</a></li>
                        <li><a href=''>活動訂單管理</a></li>
                        <li><a href=''>活動場次管理</a></li>
                        
                    </ul>
                </li>
                
                <li>
                    <img src="${pageContext.request.contextPath}/images/gift.png"><a href="#">伴手禮管理</a>
                    <ul id="list">
                        <li><a href=''>查詢全部訂單</a></li>
                        <li><a href=''>新增商品訂單</a></li>
                        <li><a href=''>商品類別管理</a></li>
                        <li><a href=''>商品管理</a></li>
                        <li><a href=''>商品圖片管理</a></li>
                    </ul>
                
                </li>
                
               
            </ul>
        </nav>
    </aside>

	<!-- ===================* 主畫面區 *=================== -->
	<main>

		<div id="tableall" style="height: 616px;">
			<table id="table-1">
				<tr>
					<td style="left: 281px;">
						<h3>訂單明細資料修改</h3>
						<h4>
							<a
								href="${pageContext.request.contextPath}/back_end/room_order_list/listAllRoom_Order_List.jsp"><img
								src="${pageContext.request.contextPath}/images/home.png"
								width="50" height="50" border="0"></a>
						</h4>
					</td>
				</tr>
			</table>

		

			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>

			<FORM METHOD="post"
				action="${pageContext.request.contextPath}/RoomOrderListServlet"
				id="form1">
				<table id="table-2" style="margin-left: 156px;">
					<tr>
						<td class="name">住宿訂單明細編號:<font color=red><b>*</b></font></td>
						
						<td class="value" id="roomtypeid"><%=room_order_listVO.getRoom_order_list_id()%></td>
					</tr>
					<tr>
						<td class="name">住宿訂單編號:<font color=red><b>*</b></font></td>

						<td class="value"><%=room_order_listVO.getRoom_order_id()%></td>
					</tr>
					<tr>
						<td class="name">房型編號:<font color=red><b>*</b></font></td>

						<td class="value"><%=room_order_listVO.getRoom_order_id()%></td>
					</tr>
					<tr>
						<td class="name">房間編號:<font color=red><b>*</b></font></td>

						<td class="value"><%=room_order_listVO.getRoom_id()%></td>
					</tr>
					<tr>
						<td class="name">人數:<font color=red><b>*</b></font></td>

						<td class="value"><%=room_order_listVO.getNumber_of_people()%></td>
					</tr>
					<tr>
						<td class="name">房間價格:<font color=red><b>*</b></font></td>
						<td class="value"><%=room_order_listVO.getRoom_price()%></td>
					</tr>
					<tr>
						<td class="name">特殊要求:<font color=red><b>*</b></font></td>
						<td class="value" id="room_type_conten-td"><textarea id="room_type_content"
								name="special_req" rows="4" style="width: 295px; left:-93px"><%=room_order_listVO.getSpecial_req()%></textarea></td>
					</tr>

				</table>
				<br> 
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="room_order_list_id"
					value="<%=room_order_listVO.getRoom_order_list_id()%>"> 
					<input type="hidden" name="room_order_id"
					value="<%=room_order_listVO.getRoom_order_id()%>">
					<input type="hidden" name="room_type_id"
					value="<%=room_order_listVO.getRoom_type_id()%>">
					<input type="hidden" name="room_id"
					value="<%=room_order_listVO.getRoom_id()%>">
					<input type="hidden" name="number_of_people"
					value="<%=room_order_listVO.getNumber_of_people()%>">
					<input type="hidden" name="room_price"
					value="<%=room_order_listVO.getRoom_price()%>">
				<!-- 	<input id="submit" type="submit" value="修改"> -->
			</FORM>
			
			<!-- ============*submit button*================= -->
<div class="wrapper">
  <button id="submit"  type="submit" form="form1" style="    top: 623px;">
    <span>Submit</span>
    <div class="success">
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"  viewBox="0 0 29.756 29.756" style="enable-background:new 0 0 29.756 29.756;" xml:space="preserve">
      
	<path d="M29.049,5.009L28.19,4.151c-0.943-0.945-2.488-0.945-3.434,0L10.172,18.737l-5.175-5.173   c-0.943-0.944-2.489-0.944-3.432,0.001l-0.858,0.857c-0.943,0.944-0.943,2.489,0,3.433l7.744,7.752   c0.944,0.943,2.489,0.943,3.433,0L29.049,8.442C29.991,7.498,29.991,5.953,29.049,5.009z"/>
 </svg>
      </div>
  </button>
</div>
		</div>
	</main>
</body>
</html>