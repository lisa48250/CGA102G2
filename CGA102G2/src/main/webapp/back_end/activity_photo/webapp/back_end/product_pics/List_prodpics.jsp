<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="p.com.productpics.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <% --%> 
<!-- Product_picsVO prodVO = (Product_picsVO) request.getAttribute("prodVO"); //EmpServlet.java(Concroller), 存入req的empVO物件 -->
<%-- %> --%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/backend_product.css">
<title>Product_order_detail</title>
<style>

/* =============================================== */
</style>

<style>
table {
	border-radius: 5px;
	position: relative;
	top:20px;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 900px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 3px;
	text-align: center;
}

/* thead.thead>tr th:nth-child(2), thead.thead>tr th:nth-child(3) {
	width: 250px;
} */

/* tbody.tbody tr:hover {
	content: attr(title);
	background-color: rgb(208, 255, 255);
} */

.table {
	text-align: center;
	margin-top:-30px;
}

th, td, tr {
	border: 1px solid darkgray;
}


.Img{
	width:2%;
	height:5%;
	position:absolute;
	margin-top:-10px;
	margin-left:-11px;
}
.Img:hover{
	width:2.5%;
	height:5.5%;
}

a {
  color: blue;
  text-decoration:underline;
}

.id_1 {
  width: 60px;
}

.id_2 {
  width: 100px;
}

input{
	border: 1px solid black;
	width:100px;
	background-color:white;
	cursor:pointer;
}
input:hover{
	background-color:black;
	color:white;
}
.back:hover{
	color:blue;
}
td> img{
	position:relative;
	width:200px;
/* 	height:200px; */
/* 	left:70px; */
/* 	top:45px;  */
	height:200px;
	left:80px;
	top:0px; 
	
}
/* #product-img{
	position:relative;
	top:10px;
} */

/* table { */
/* 	size: 20px; */
/* 	background-color: white; */
/* 	margin-top: 5px; */
/* 	margin-bottom: 5px; */
/* 	margin-left: 40px; */
/* 	margin-right: auto; */
/* } */

/* table, th, td { */
/* 	border: 1px solid #CCCCFF; */
/* } */

/* th, td { */
/* 	padding: 5px; */
/* 	text-align: center; */
/* } */

/* #search_pic { */
/* 	margin-top: -30px; */
/* 	margin-bottom: 5px; */
/* 	margin-left: 50px; */
/* 	margin-right: auto; */
/* } */
</style>
</head>
<!-- -----------------------------------  公版頁面  ----------------------------------- -->
<body>
    <header>
        <nav class="nav">

            <div class="logo">

                <a href="" class="logo_a">
                    <img src="<%=request.getContextPath() %>/images/logo.png" alt=""><!--  ../../images/logo.png-->
                </a>

                <a class="nav-top-a" href=""><img class="nav-top-chat" src="<%=request.getContextPath() %>/images/chat.png" alt=""></a>

                <a href="${pageContext.request.contextPath}/LogoutEmp" class="nav-top-sighout">${jobVO.job_name}/登出</a>
            </div>
            <div class="line"></div>

        </nav>
    </header>

    <aside class="aside">
        <nav class="nav">
            <div>
                <img src="<%=request.getContextPath() %>/images/group.png">
                <p>${employeeVO.emp_name}</p>
                <hr style="background-color:#757575 ;height:2px;">
            </div>
            <ul class="nav_list">
                
<!--                 <li> -->
<%--                     <img src="<%=request.getContextPath() %>/images/group (1).png"><a href="#">員工管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>員工資料</a></li> -->
<!--                         <li><a href=''>員工權限</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
<!--                 <li> -->
<%--                     <img src="<%=request.getContextPath() %>/images/social-group.png"><a href="#">會員管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>會員資料</a></li> -->
<!--                         <li><a href=''>會員通知管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="<%=request.getContextPath() %>/images/talking.png"><a href="#">消息管理</a> --%>
                
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>媒體報導管理</a></li> -->
<!--                         <li><a href=''>最新消息發布</a></li> -->
<!--                     </ul>                 -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="<%=request.getContextPath() %>/images/bed.png"><a href="#">房務管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>住宿訂單管理</a></li> -->
<!--                         <li><a href=''>訂單明細管理</a></li> -->
<!--                         <li><a href=''>房型管理</a></li> -->
<!--                         <li><a href=''>房間管理</a></li> -->
<!--                         <li><a href=''>房型圖片管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="<%=request.getContextPath() %>/images/camping.png"><a href="#">活動管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>活動項目管理</a></li> -->
<!--                         <li><a href=''>活動訂單管理</a></li> -->
<!--                         <li><a href=''>活動場次管理</a></li> -->

<!--                     </ul> -->
<!--                 </li> -->
                
                <li>
                    <img src="<%=request.getContextPath() %>/images/gift.png"><a href="#">伴手禮管理</a>
                     <ul id="list">
                        <li><a href='<%=request.getContextPath() %>/back_end/product_order_detail/homepage.jsp'>查詢全部訂單</a></li> 
                        <li><a href="<%=request.getContextPath() %>/back_end/product_category/Select_page.jsp">商品類別管理</a></li>
                        <li><a href="<%=request.getContextPath() %>/back_end/product/Select_page.jsp">商品管理</a></li>
                        <li><a href="<%=request.getContextPath() %>/back_end/product_pics/Select_page.jsp">商品圖片管理</a></li>
                    </ul>
                
                </li>
                
               
            </ul>
        </nav>
    </aside>
    
 <!-- ---------------------------------  公版頁面結束  --------------------------------- -->     

<main>
		<div id="search_pic" class="search-form">
<!-- 			<p class="title">商品圖片查詢</p> -->
<!-- 			<table id="table-1"> -->
<!-- 	<tr><td> -->
<!-- 		 <h3>商品類別資料 - ListOneProdCat.jsp</h3> -->
<!-- 		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4> -->
<!-- 	</td></tr> -->
<!-- </table> -->
<h1><a class="back" style="color:black;" href="<%=request.getContextPath() %>/back_end/product_pics/Select_page.jsp">商品圖片管理首頁</a></h1>
<table id="distable-table" style="width:900px;height:50px;border:3px #cccccc;">
	<tr style="">
		<th style="length=50px; width=10px">商品圖片編號</th>		
		<th style="length=50px; width=10px">商品編號</th>
		<th style="length=50px; width=10px">商品名稱</th>
		<th style="length=50px; width=10px">商品圖片</th>
		<th style="length=50px; width=10px">修改</th>
		<th style="length=50px; width=10px">刪除</th>
	</tr>
	<c:forEach var="prodVO" items="${prodVOs}">
	<tr>
		<td style="height:100px">${prodVO.product_photo_id}</td>
		<td style="height:100px">${prodVO.product_id}</td>
		<td style="height:100px">${prodVO.getProduct_VO().product_name}</td>
		<td><img class ="product-img" src="<%=request.getContextPath()%>/prodpics_reader?product_photo_id=${prodVO.product_photo_id}" width=100px height=100px></td>
<%-- 			<td><img width="50px" height="50px" id ="product-img" src="<%=request.getContextPath()%>/prodpics_reader?product_photo_id=${prodVO.product_photo_id}"></td> --%>
<%-- 			<td><img width="50px" height="50px" id ="product-img" src="<%=request.getContextPath()%>/prodpic_reader?product_photo_id=${prodVO.product_photo_id}"></td> --%>
<%-- 		<td align="center"><img id ="product-img" src="<%=request.getContextPath()%>/prodpics_reader?product_photo_id=${prodVO.product_photo_id}"></td> --%>


<%-- 		<td style="height:100px">${prodVO.product_photo}</td> --%>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/prodpics_Servlet" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="product_photo_id"  value="${prodVO.product_photo_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/prodpics_Servlet" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="product_photo_id"  value="${prodVO.product_photo_id}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
	</tr>
	</c:forEach>
</table>
			<div class="errorMsg">
				<c:if test="${not empty errorMsgs}">
					<font style="color: red">請修正以下錯誤:</font>
					<ul>
						<c:forEach var="message" items="${errorMsgs}">
							<li style="color: red">${message.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>



		<!------------------- 這裡是listALL -------------->
<%-- 		<jsp:include page="listAllProdpics.jsp" /> --%>



	</main>


</body>
</html>