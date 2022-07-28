<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="p.com.productcategory.model.*"%>

  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/backend_product.css">
<title>修改商品類別資料 - update_product_category.jsp</title>

<style>
table {
	border-radius: 5px;
	position: relative;
	top:-10px;
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

td {
    height:100px;
}

thead.thead>tr th:nth-child(2), thead.thead>tr th:nth-child(3) {
	width: 250px;
}

tbody.tbody tr:hover {
	content: attr(title);
	background-color: rgb(208, 255, 255);
}

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
.table{
	border-radius: 5px;
	position: relative;
	top:20px;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 1010px;
	left:20px;
}

#form{
	border-radius: 5px;
	position: relative;
	top:50px;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 900px;
	padding:20px;
	top:-20px;
}
</style>
<script src="https://cdn.ckeditor.com/4.7.3/basic/ckeditor.js"></script>
</head>
<!-- -----------------------------------  公版頁面  ----------------------------------- -->
<body>
    <header>
        <nav class="nav">

            <div class="logo">

                <a href="" class="logo_a">
                    <img src="<%=request.getContextPath()%>/images/logo.png" alt=""><!--  ../../images/logo.png-->
                </a>

                <a class="nav-top-a" href=""><img class="nav-top-chat" src="<%=request.getContextPath()%>/images/chat.png" alt=""></a>

                <a href="${pageContext.request.contextPath}/LogoutEmp" class="nav-top-sighout">${jobVO.job_name}/登出</a>
            </div>
            <div class="line"></div>

        </nav>
    </header>

    <aside class="aside">
        <nav class="nav">
            <div>
                <img src="<%=request.getContextPath()%>/images/group.png">
                <p>${employeeVO.emp_name}</p>
                <hr style="background-color:#757575 ;height:2px;">
            </div>
            <ul class="nav_list">
                
<!--                 <li> -->
<%--                     <img src="<%=request.getContextPath()%>/images/group (1).png"><a href="#">員工管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>員工資料</a></li> -->
<!--                         <li><a href=''>員工權限</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
<!--                 <li> -->
<%--                     <img src="<%=request.getContextPath()%>/images/social-group.png"><a href="#">會員管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>會員資料</a></li> -->
<!--                         <li><a href=''>會員通知管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="<%=request.getContextPath()%>/images/talking.png"><a href="#">消息管理</a> --%>
                
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>媒體報導管理</a></li> -->
<!--                         <li><a href=''>最新消息發布</a></li> -->
<!--                     </ul>                 -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="<%=request.getContextPath()%>/images/bed.png"><a href="#">房務管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>住宿訂單管理</a></li> -->
<!--                         <li><a href=''>訂單明細管理</a></li> -->
<!--                         <li><a href=''>房型管理</a></li> -->
<!--                         <li><a href=''>房間管理</a></li> -->
<!--                         <li><a href=''>房型圖片管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="<%=request.getContextPath()%>/images/camping.png"><a href="#">活動管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>活動項目管理</a></li> -->
<!--                         <li><a href=''>活動訂單管理</a></li> -->
<!--                         <li><a href=''>活動場次管理</a></li> -->

<!--                     </ul> -->
<!--                 </li> -->
                
                <li>
                    <img src="<%=request.getContextPath()%>/images/gift.png"><a href="#">伴手禮管理</a>
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
<!-- <table id="table-1"> -->
<!-- 	<tr><td> -->
<!-- 		 <h3>商品資料修改 - update_product_category.jsp</h3> -->
<%-- 		 <h4><a href="<%=request.getContextPath() %>/back_end/product_category/Select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4> --%>
<!-- 	</td></tr> -->
<!-- </table> -->
<h1><a href="<%=request.getContextPath()%>/back_end/product_category/Select_page.jsp">回商品類別首頁</a></h1>
<h1>資料修改:</h1>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<FORM id="form" METHOD="post" ACTION="<%=request.getContextPath()%>/product_category.do" name="form1">


<!-- <table> -->
<!--     <tr> -->
<!-- 		<td width="300">類別編號:<font color=red><b>*</b></font></td> -->
<%-- 		<td>${param.product_category_id}</td> --%>
<!-- 	</tr> -->
<%--<jsp:useBean id="ProdSvc" scope="page" class="com.productcategory.model.ProductcategoryService" /> --%>
<!-- 	<tr> -->
<!-- 		<td width="300">類別名稱:<font color=red><b>*</b></font></td> -->
<!-- 		<td><input type="TEXT" name="product_category_name" size="45" -->
<%-- 			 value="${param.product_category_name}"/></td> --%>
<%-- 			 <td>${errorMsgs.product_category_name}</td> --%>
<!-- 	</tr> -->
	
<!-- 	<tr> -->
<!-- 		<td width="300">類別簡介:</td> -->
<!-- 		<td><input type="TEXT" name="product_category_detail" size="500" maxlength="1000" -->
<%-- 			 value="${param.product_category_detail}"/></td> --%>
<%--<td>${errorMsgs.product_category_detail}</td> --%>
<!-- 	</tr> -->
<!-- </table> -->

<ol style="list-style:none;">
		<li><h2>類別編號:        <font color=blue><b>${param.product_category_id}</b></font></h2></li>

		<jsp:useBean id="ProdSvc" scope="page" class="p.com.productcategory.model.Product_category_Service" />

		<li><h2>類別名稱:
<!-- 		<textarea name="product_category_name" rows="6" cols="40">至少二個以上文字</textarea> -->
		<input style="width:100px;" type="TEXT" name="product_category_name" size="45"
			 value="${param.product_category_name}"/><font color=red>${errorMsgs.product_category_name}</font></h2></li>

		<li><h2>商品類別簡介:<font color=red>${errorMsgs.product_category_detail}</font><br>
		<textarea name="product_category_detail" id="editor1" rows="6" cols="100" value="${param.product_category_detail}">${param.product_category_detail}</textarea>
		</h2>
		<script>
	               	CKEDITOR.replace( 'editor1' );  
	              </script>
<!-- 		<input type="TEXT" name="product_category_detail" size="45" -->
<%-- 			 value="${param.product_category_detail}"/>${errorMsgs.product_category_detail}</h2></li> --%>
</ol>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="product_category_id" value="${param.product_category_id}">
<input type="submit" value="送出修改"></FORM>
</body>



	
<!-- <div> -->
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red"><h2>請修正以下錯誤:</h2></font> -->
<!-- 	<ol> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red"><h2>${message.value}</h2></li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ol> -->
<%-- </c:if> --%>
<!-- </div> -->
</main>



</html>