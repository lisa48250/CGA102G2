<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="m.com.room_type.model.*"%>

<%
Room_TypeVO room_typeVO = (Room_TypeVO) request.getAttribute("room_typeVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/update_room_type_input.css">
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
<div style="height:760px;"id = "tableall">
<table id="table-1">
	<tr><td>
		 <h3>房型資料修改</h3>
		 <h4><a href="${pageContext.request.contextPath}/back_end/room_type/select_page.jsp"><img src="${pageContext.request.contextPath}/images/home.png" width="50" height="50" border="0"></a></h4>
	</td></tr>
</table>

<!-- <h3>房型資料修改:</h3> -->
<br>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/room_type.do" id="form1" enctype="multipart/form-data">
<table id="table-2">
	<tr>
		<td>房型編號:<font color=red><b>*</b></font></td>
		<td id="roomtypeid"><%=room_typeVO.getRoom_type_id()%></td>
	</tr>
	<tr>
		<td>房型名稱:<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="room_type_name" size="45" value="<%=room_typeVO.getRoom_type_name()%>" /></td>
	</tr>
	<tr>
		<td>房型數量:<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="room_type_amount" size="45" value="<%=room_typeVO.getRoom_type_amount()%>" /></td>
	</tr>
	
	<tr  id=room_type_sale_status-tr>
		<td>上下架狀態:<font color=red><b>*</b></font></td>
		<td><select size="1" name="room_type_sale_status">
			<option value="0" ${(room_typeVO.room_type_sale_status==0) ? 'selected' : ''}>上架</option>
			<option value="1"  ${(room_typeVO.room_type_sale_status==1) ? 'selected' : ''}>下架</option>
		</select></td>
	</tr>
	<tr>
		<td>評論總覽:</td>
		<td><input type="TEXT" name="room_total_review" size="1000" value="<%=room_typeVO.getRoom_total_review()%>" /></td>
	</tr>
	<tr>
		<td>房型照片:<font color=red><b>*</b></font></td>
		<!-- <td><input type="file" name="room_type_pic" accept="image/*"></td> -->
		<td><input class="up" type="file" name="room_type_pic" size="45" accept="image/*" value="<%=room_typeVO.getRoom_type_pic()%>/Room_Type_Reader"/>
		<img class="room_img" name="room_type_pic" src="${pageContext.request.contextPath}/Room_Type_Reader?id=${room_typeVO.room_type_id}" style="height:80px; width:160px; left: 450px; bottom: 50px;  position: absolute; "></td>
	</tr>
	<tr>
		<td>房間價格:<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="room_type_price" size="45" value="<%=room_typeVO.getRoom_type_price()%>" /></td>
	</tr>
	<tr>
		<td>房型說明:<font color=red><b>*</b></font></td>
		<td id="room_type_conten-td"><textarea id="room_type_content"  name="room_type_content"  rows="4"><%=room_typeVO.getRoom_type_content()%></textarea></td>
		<%-- <td id="room_type_conten-td">
		<div class="content">
            <!-- <label for="editor1">內容:</label> -->
            <textarea name="editor1" id="editor1" cols="50" rows="10" ><%=room_typeVO.getRoom_type_content()%></textarea>
            <script>
                CKEDITOR.replace( 'editor1' );
            </script>
        </div>
        </td> --%>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="room_type_id" value="<%=room_typeVO.getRoom_type_id()%>">
<!-- <input id="submit" type="submit" value="送出修改"> -->
</FORM>

<!-- ============*submit button*================= -->
<div class="wrapper">
  <button id="submit"  type="submit" form="form1">
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
</body>
</html>