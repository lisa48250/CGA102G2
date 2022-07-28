<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="m.com.room_order.model.*"%>

<%
Room_OrderVO room_orderVO = (Room_OrderVO) request.getAttribute("room_orderVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
 href="${pageContext.request.contextPath}/css/update_room_type_input.css">
 
<title>住宿訂單資料修改</title>

</head>
<body bgcolor='white'>
 <!-- ==================* 後台框架區 *================== -->
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

<!--     <li><img -->
<%--      src="${pageContext.request.contextPath}/images/group (1).png"><a --%>
<!--      href="#">員工管理</a> -->
<!--      <ul id="list"> -->
<!--       <li><a href=''>員工資料</a></li> -->
<!--       <li><a href=''>員工權限</a></li> -->
<!--      </ul></li> -->

<!--     <li><img -->
<%--      src="${pageContext.request.contextPath}/images/social-group.png"><a --%>
<!--      href="#">會員管理</a> -->
<!--      <ul id="list"> -->
<!--       <li><a href=''>會員資料</a></li> -->
<!--       <li><a href=''>會員通知管理</a></li> -->
<!--      </ul></li> -->

<!--     <li><img -->
<%--      src="${pageContext.request.contextPath}/images/talking.png"><a --%>
<!--      href="#">消息管理</a> -->

<!--      <ul id="list"> -->
<!--       <li><a href=''>媒體報導管理</a></li> -->
<!--       <li><a href=''>最新消息發布</a></li> -->
<!--      </ul></li> -->

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

<!--     <li><img -->
<%--      src="${pageContext.request.contextPath}/images/camping.png"><a --%>
<!--      href="#">活動管理</a> -->
<!--      <ul id="list"> -->
<!--       <li><a href=''>活動項目管理</a></li> -->
<!--       <li><a href=''>活動訂單管理</a></li> -->
<!--       <li><a href=''>活動場次管理</a></li> -->

<!--      </ul></li> -->

<!--     <li><img -->
<%--      src="${pageContext.request.contextPath}/images/gift.png"><a --%>
<!--      href="#">伴手禮管理</a> -->
<!--      <ul id="list"> -->
<!--       <li><a href=''>查詢全部訂單</a></li> -->
<!--       <li><a href=''>新增商品訂單</a></li> -->
<!--       <li><a href=''>商品類別管理</a></li> -->
<!--       <li><a href=''>商品管理</a></li> -->
<!--       <li><a href=''>商品圖片管理</a></li> -->
<!--      </ul></li> -->


   </ul>
  </nav>
 </aside>

 <!-- ===================* 主畫面區 *=================== -->
 <main>

  <div id="tableall" style="height: 500px;">
   <table id="table-1">
    <tr>
     <td style="left: 263px">
      <h3>住宿訂單資料修改</h3>
      <h4>
       <a
        href="${pageContext.request.contextPath}/back_end/room_order/select_room_order_page.jsp"><img
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
    action="${pageContext.request.contextPath}/Room_OrderServlet"
    id="form1">
    <table id="table-2">
     <tr>
      <td>住宿訂單編號:
      <td id="roomtypeid"><%=room_orderVO.getRoom_order_id()%></td>
     </tr>
     <tr>
      <td>會員編號:<font color=red><b>*</b></font></td>
      <td><input type="TEXT" name="member_id" size="45"
       value="<%=room_orderVO.getMember_id()%>" /></td>
     </tr>
     <tr>
      <td>訂單日期:<font color=red><b>*</b></font></td>
      <td><input type="TEXT" name="order_date" size="19"
       value="<%=room_orderVO.getOrder_date()%>" /></td>
      <%-- <td id="order_date" name="order_date"><%=room_orderVO.getOrder_date()%></td> --%>
     </tr>
     <tr id=room_type_sale_status-tr>
      <td>訂單狀態:<font color=red><b>*</b></font></td>
      <td><select size="1" name="room_order_status">
        <option value="0"
         ${(room_orderVO.room_order_status==0) ? 'selected' : ''}>已結單</option>
        <option value="1"
         ${(room_orderVO.room_order_status==1) ? 'selected' : ''}>已入住</option>
        <option value="2"
         ${(room_orderVO.room_order_status==2) ? 'selected' : ''}>未入住</option>
      </select></td>
     </tr>
     <tr>
      <td>訂單總金額:<font color=red><b>*</b></font></td>
      <td><input type="TEXT" name="room_charge" size="45"
       value="<%=room_orderVO.getRoom_charge()%>" /></td>
     </tr>
     <tr>
      <td>入住日期:<font color=red><b>*</b></font></td>
      <td><input name="check_in_date" id="f_date2" type="text"
       onkeydown="return false"></td>
     </tr>
     <tr>
      <td>退房日期:<font color=red><b>*</b></font></td>
      <td><input name="check_out_date" id="f_date3" type="text"
       onkeydown="return false"></td>
     </tr>
    </table>

    <br> <input type="hidden" name="action" value="update">
    <input type="hidden" name="room_order_id"
     value="<%=room_orderVO.getRoom_order_id()%>">
    <!-- <input type="submit" value="送出修改"> -->
   </FORM>

   <!-- ============*submit button*================= -->
   <div class="wrapper">
    <button id="submit" type="submit" form="form1" style="top: 517px;">
     <span>Submit</span>
     <div class="success">
      <svg xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"
       viewBox="0 0 29.756 29.756"
       style="enable-background: new 0 0 29.756 29.756;"
       xml:space="preserve">
      
 <path
        d="M29.049,5.009L28.19,4.151c-0.943-0.945-2.488-0.945-3.434,0L10.172,18.737l-5.175-5.173   c-0.943-0.944-2.489-0.944-3.432,0.001l-0.858,0.857c-0.943,0.944-0.943,2.489,0,3.433l7.744,7.752   c0.944,0.943,2.489,0.943,3.433,0L29.049,8.442C29.991,7.498,29.991,5.953,29.049,5.009z" />
 </svg>
     </div>
    </button>
   </div>
  </div>
 </main>

</body>

<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
<link rel="stylesheet" type="text/css"
 href="<%=request.getContextPath()%>/css/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script
 src="<%=request.getContextPath()%>/js/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
 width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
 height: 151px; /* height:  151px; */
}
</style>

<script>
    

        
        $.datetimepicker.setLocale('zh');
        var picker1 = $('#f_date2').datetimepicker({
           theme: '',              //theme: 'dark',
         timepicker:false,  //timepicker:true,
         step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
         format:'Y-m-d',         //format:'Y-m-d H:i:s',
      value: '<%=room_orderVO.getCheck_in_date()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:             '2017/07/10',  // 起始日
           minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
          scrollMonth : false,  //限制無法使用卷軸
    scrollInput : false     //限制無法使用卷軸
    
        });
        
        $.datetimepicker.setLocale('zh');
        var picker2 = $('#f_date3').datetimepicker({
           theme: '',              //theme: 'dark',
         timepicker:false, //timepicker:true,
         step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
         format:'Y-m-d',         //format:'Y-m-d H:i:s',
      value: '<%=room_orderVO.getCheck_out_date()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:             '2017/07/10',  // 起始日
           minDate: '<%=room_orderVO.getCheck_in_date()%>',            // 去除今日(不含)之前
//            maxDate:               '+1970-01-01'  // 去除今日(不含)之後
          scrollMonth : false,
    scrollInput : false
  });
         
         //動態設定最小值(選擇前面一個日期後：後面一個日期為前面一天＋1,且不能小於前面一個)
           picker1.on('change', function (e) {
            $('#f_date3').datetimepicker({
             value:new Date(new Date(e.target.value).getTime() + 1000 * 60 * 60 * 24),
             minDate: new Date(new Date(e.target.value).getTime() + 1000 * 60 * 60 * 24)
            });

           });
         //動態設定最大值(選擇後面一個日期後：前面一個日期不能大於前面一個）
           picker2.on('change', function (e) {
            $('#f_date2').datetimepicker({
             maxDate: e.target.value
            });
           });

        </script>
</html>