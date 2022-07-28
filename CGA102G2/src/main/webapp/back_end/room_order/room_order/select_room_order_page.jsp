<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select_page.css">
<title>住宿訂單管理</title>
</head>
<body bgcolor='white'>
 <!-- ==================* 後台框架區 *================== -->
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
    
     <!-- ==================* 主畫面區 *================== -->
   <main>
    <div id = "tableall">


<table id="table-1">
   <tr><td><h3>住宿訂單管理</h3></td></tr>
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

<ul style="margin-left:-15px">
 <li>
    <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Room_OrderServlet" >
        <b>查詢住宿訂單之明細:</b>
        <input type="text" name="room_order_id">
        <input type="hidden" name="action" value="getOne_For_DisplayList">
        <input type="submit" value="送出">
    </FORM>
  </li>
<br>
<br>
  <li class=selectall><a href='${pageContext.request.contextPath}/back_end/room_order/listAllRoom_Order.jsp'>查詢所有訂單</a><br><br></li>
  <br>
  <li class=selectall><a href='${pageContext.request.contextPath}/back_end/room_order/listcheckindate.jsp'>查詢今日訂單</a><br><br></li>
  
  <%-- <jsp:useBean id="room_orderSvc" scope="page" class="com.room_order.model.Room_OrderService" />
   
  <li>
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Room_OrderServlet" >
       <b>選擇入住時間:</b>
       <select size="1" name="check_in_date">
         <c:forEach var="room_orderVO" items="${room_orderSvc.allTime}" > 
          <option value="${room_orderVO.check_in_date}">${room_orderVO.check_in_date}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li> --%>
  
  
  
    <%--<li>
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Room_OrderServlet" >
       <b>選擇會員編號:</b>
       <select size="1" name="room_order_id">
         <c:forEach var="room_orderVO" items="${room_orderSvc.all}" > 
          <option value="${room_orderVO.room_order_id}">${room_orderVO.member_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>


<h3>住宿訂單管理</h3>

<ul>
  <li><a href='addRoom_Order.jsp'>Add</a> a new Room_Order.</li>
</ul> --%>
</ul>
</div>
</main>


</body>
</html>