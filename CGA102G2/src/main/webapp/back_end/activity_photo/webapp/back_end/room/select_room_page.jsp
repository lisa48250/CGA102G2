<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select_page.css">
<title>房間管理</title>
</head>
<body bgcolor='white'>
 <!-- ==================* 後台框架區 *================== -->
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
    <div id = "tableall">
<table id="table-1" style="width: 537px;">
   <tr><td><h3>房間管理</h3></td></tr>
</table>




	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li class=selectall><a  href='${pageContext.request.contextPath}/back_end/room/listAllRoom.jsp'>查詢所有房間</a>  <br><br></li>
  
  <li>
    <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Roomservlet" >
        <b>輸入房間編號 (如1):</b>
        <input type="text" name="room_id"value="${param.room_id}">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>
  
   <jsp:useBean id="roomSvc" scope="page" class="m.com.room.model.RoomService" />
<li>
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Roomservlet" >
       <b>選擇房間編號:</b>
       <select size="1" name="room_id">
         <c:forEach var="roomVO" items="${roomSvc.all}" > 
          <option value="${roomVO.room_id}">${roomVO.room_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <jsp:useBean id="room_typeSvc" scope="page" class="m.com.room_type.model.Room_TypeService" />
  <li>
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Roomservlet" >
       <b>選擇房型編號:</b>
       <select size="1" name="room_type_id">
         <c:forEach var="room_typeVO" items="${room_typeSvc.all}" > 
          <option value="${room_typeVO.room_type_id}">${room_typeVO.room_type_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_DisplayRT">
       <input type="hidden" name="room_type_id" value="${room_typeVO.room_type_id }">
       <input type="submit" value="送出">
     </FORM>
  </li>
  
  </ul>


<br>

<ul>
  <li class=addroomtype><a href='${pageContext.request.contextPath}/back_end/room/addRoom.jsp'>新增房間</a></li>
</ul>

</div></main>
</body>
</html>