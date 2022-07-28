<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="m.com.room_type.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>

<%
    Room_TypeService room_typeSvc = new Room_TypeService();
    List<Room_TypeVO> list = room_typeSvc.getAll();
    pageContext.setAttribute("list",list);
    Integer id = (Integer)request.getAttribute("id");
    
//     for(Room_TypeVO list1 : list){
//     	list1.getRoom_type_pic();
//     	Blob b = null;
//     	byte[] buf = b.getBytes(1, (int)b.length());
//     }
    
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/listAllRoomType.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>所有房型資料</title>
<style>
	aside.aside {
	background-color: rgb(179, 188, 190);
	width: 240px;
	left: 0;
	top: 0px;
	height: 100%;
	padding: 20px 0;
	padding: 0px;
	margin: 0px;
}

.line {
    height: 5px;
    width: 100%;
   margin-top: -8px; 
    background-color: #757575;
}
aside.aside nav.nav div img {
    display: inline;
    position: relative;
    height: auto;
    width: 10%;
    bottom: 15px;
    left: 10px;
    margin-bottom:20px;
}
.nav-top-sighout {
    border-radius: 20px;
    border: 1px;
    background-color: #757575;
    font-size: 20px;
    padding: 7px 22px 7px 22px;
    color: #ffffff;
    position: relative;
    top: 15px;
    text-align: center;
    right: 70px;
    margin-right: 50px;
    text-decoration: none;
}
.nav-top-sighout {
    border-radius: 20px;
    border: 1px;
    background-color: #757575;
    font-size: 20px;
    padding: 7px 22px 7px 22px;
    color: #ffffff;
    position: relative;
    top: 15px;
    text-align: center;
    right: 50px;
    margin-right: 50px;
    text-decoration: none;
}
.nav-top-a {
    display: inline-block;
    height: 45px;
    width: 45px;
    position: relative;
    margin-right: 80px;
    top: 10px;
}
</style>
</head>

<body bgcolor='white'>
	<!--  =================== * 後台框架區 * =================== -->
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
                <hr style="background-color:#757575 ;height:2px;">
            </div>
            <ul class="nav_list">
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/group (1).png"><a href="#">員工管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>員工資料</a></li> -->
<!--                         <li><a href=''>員工權限</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/social-group.png"><a href="#">會員管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>會員資料</a></li> -->
<!--                         <li><a href=''>會員通知管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a> --%>
                
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>媒體報導管理</a></li> -->
<!--                         <li><a href=''>最新消息發布</a></li> -->
<!--                     </ul>                 -->
<!--                 </li> -->
               
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
               
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/camping.png"><a href="#">活動管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>活動項目管理</a></li> -->
<!--                         <li><a href=''>活動訂單管理</a></li> -->
<!--                         <li><a href=''>活動場次管理</a></li> -->
                        
<!--                     </ul> -->
<!--                 </li> -->
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/gift.png"><a href="#">伴手禮管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>查詢全部訂單</a></li> -->
<!--                         <li><a href=''>新增商品訂單</a></li> -->
<!--                         <li><a href=''>商品類別管理</a></li> -->
<!--                         <li><a href=''>商品管理</a></li> -->
<!--                         <li><a href=''>商品圖片管理</a></li> -->
<!--                     </ul> -->
                
<!--                 </li> -->
                
               
            </ul>
        </nav>
    </aside>
	<!--  =================== * 主畫面區 * =================== -->

	<div id="tableall2">
		<table id="table-1">
			<tr id="topline" style="border:none;">
				<td>
					<h3 style="font-size:18px;">所有房型資料</h3>
					<h4>
						<a
							href="${pageContext.request.contextPath}/back_end/room_type/select_page.jsp"><img
							src="${pageContext.request.contextPath}/images/home.png"
							width="50" height="50" border="0"></a>
					</h4>
				</td>
			</tr>
		</table>

		<table id="table-2" cellspacing="0">
			<tr id="tr-1">
				<th>房型編號</th>
				<th>房型名稱</th>
				<th>房型數量</th>
				<th>房型說明</th>
				<th>上下架狀態</th>
				<th>評價總覽</th>
				<th>房型照片</th>
				<th>房型價格</th>
				<th>修改</th>
				<th>刪除</th>
			</tr>
			<%@ include file="page1.file"%>
			<c:forEach var="room_typeVO" items="${list}" begin="<%=pageIndex%>"
				end="<%=pageIndex+rowsPerPage-1%>">

				<tr style="border-bottom: none;">
					<td>${room_typeVO.room_type_id}</td>
					<td>${room_typeVO.room_type_name}</td>
					<td>${room_typeVO.room_type_amount}</td>
					<td>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModalLong">Click</button> <!-- Modal -->
						<div class="modal fade" id="exampleModalLong" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLongTitle"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle">Contents of Room Type
											</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">${room_typeVO.room_type_content}</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</td>
					
					<%-- <td>${room_typeVO.room_type_sale_status}</td> --%>
					<c:set var="method" value="${room_typeVO.room_type_sale_status}" />
					<c:if test="${method == 0 }">
						<td>上架</td>
					</c:if>
					<c:if test="${method == 1 }">
						<td>下架</td>
					</c:if>
					
					<td>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModalLong1">Click</button> <!-- Modal -->
						<div class="modal fade" id="exampleModalLong1" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLongTitle"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle">Room Reviews</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">${room_typeVO.room_total_review}</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</td>
					
					<td><img id="room-img"
						src="<%=request.getContextPath()%>/Room_Type_Reader?id=${room_typeVO.room_type_id}"></td>
					<%-- <td><img src="${pageContext.request.contextPath}/Room_Type_Reader?id=${room_typeVO.room_type_id}"></td> --%>
					<td>${room_typeVO.room_type_price}</td>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/room_type.do"
							style="margin-bottom: 0px;">
							<input class="icon" type="image"
								src="${pageContext.request.contextPath}/images/school-material.png"
								width="25" height="25" border="0" onclick="submit()"> 
								<input
								type="hidden" name="room_type_id"
								value="${room_typeVO.room_type_id}"> <input
								type="hidden" name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/room_type.do"
							style="margin-bottom: 0px;">
							<input class="icon" type="image" src="${pageContext.request.contextPath}/images/recycle.png"
								width="25" height="25" border="0" onclick="submit()"> 
							<input type="hidden" name="room_type_id"
								value="${room_typeVO.room_type_id}">
							<input
								type="hidden" name="action" value="delete">
						</FORM>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="page2.file"%>
<body>
<!-- modal script -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>