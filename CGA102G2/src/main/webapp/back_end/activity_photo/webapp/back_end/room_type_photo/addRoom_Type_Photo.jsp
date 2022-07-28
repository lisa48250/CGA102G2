<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="m.com.room_type_photo.model.*"%>

<%
Room_type_photoVO room_type_photoVO = (Room_type_photoVO) request.getAttribute("room_type_photoVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/add_room_type_input.css">
<title>房型照片新增</title>

</head>

<!-- ==================* 後台框架區 *================== -->
</head>
<body bgcolor='white'>
<header>
        <nav class="nav">

            <div class="logo">

                <a href="" class="logo_a">
                    <img src="${pageContext.request.contextPath}/images/logo.png" alt="">
                </a>

                <a class="nav-top-a" href="${pageContext.request.contextPath}/front_end/chat/chat.jsp"><img class="nav-top-chat" src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>

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
<!-- ==================* 主畫面區 *================== -->
<main>
<div id = "tableall" style="height:310px">
	<table id="table-1">
		<tr>
			<td>
				<h3>房型照片新增</h3>
				<h4><a href="${pageContext.request.contextPath}/back_end/room_type_photo/select_room_type_photo_page.jsp"><img src="${pageContext.request.contextPath}/images/home.png" width="50" height="50" border="0"></a></h4>
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
	
	<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Room_Type_PhotoServlet" id="form1"
		enctype="multipart/form-data">
		<table id="table-2">
		
			<jsp:useBean id="room_typeSvc" scope="page"
				class="m.com.room_type.model.Room_TypeService" />
				
				<tr>
				<td>➕ 房型編號:<font color=red><b>*</b></font></td>
				<td><select size="1" name="room_type_id">
						<c:forEach var="room_typeVO" items="${room_typeSvc.all}">
							<option value="${room_typeVO.room_type_id}">${room_typeVO.room_type_id}
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>➕ 房型照片:<font color=red><b>*</b></font></td>
				<!-- <td><input type="file" name="room_type_photo" accept="image/*"></td> -->
				 <td><input class="up" type="file" name="room_type_photo" size="45" accept="image/*" />
		        <img class="room_img" name="room_type_photo" src="${pageContext.request.contextPath}/Room_Type_Photo_Reader?id=${room_type_photoVO.room_type_photo_id}" style="height:80px; width:160px; left: 410px; bottom: 0px;  position: absolute; "></td>
			</tr>
			
			</table>
		<br> <input type="hidden" name="action" value="insert"> 
	<!-- 	<input type="submit" value="送出新增"> -->
	</FORM>
	<!-- ============*submit button*================= -->
	<div class="wrapper">
  <button id="submit"  type="submit" form="form1" style="top:526px;">
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
		
		<script>
let btn = document.querySelector("button");

btn.addEventListener("click", active);

function active() {
  btn.classList.toggle("is_active");
}
</script>

<!-- 選擇檔案更換圖片 -->
<script>
 const { body } = document;
 const photo = document.getElementsByClassName("up")[0];
 photo.addEventListener("change", function(e) {
  if (e.target.nextElementSibling !== null) {
   const img = document.getElementsByClassName("room_img")[0];
   let file = e.target.files[0];
   let url = window.URL.createObjectURL(file);
   img.src = url;
  }
 });
 </script>

<body>

</body>
</html>