<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="p.com.productpics.model.*"%>
<%@ page import="p.com.product.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/backend_product.css">
<title>Product_order_detail</title>
<style>
.table{
	border-radius: 5px;
	position: relative;
	top:-10px;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 900px;
}
/* =============================================== */


</style>

<style>
table {
	width: 30%;
	height:20%;
	background-color: white;
	margin-top: -50px;
	margin-bottom: 5px;
	margin-left: 40px;
	margin-right: auto;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}

tr, td {
    width: 40px;
}
a {
  color: blue;
  text-decoration:underline;
}
.sub{
	border: 1px solid black;
	width:95px;
	background-color:white;
	cursor:pointer;
	position:relative;
	left:200px;
}
.sub:hover{
	background-color:black;
	color:white;
	
}

.back{
	position:relative;
	right:100px;
}
.back:hover{
	color:blue;
}
.form-1{
	border:1px solid gray;
	border-radius: 10px;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	position:relative;
	display:inline-block;
	left:250px;
	top:50px;
	font-size:20px;
	width:500px;
	height:300px;
}
.a1{
	color:blue;
}
.a1:hover{
	color:blue;
}

</style>
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
	
	<h1><a href="<%=request.getContextPath()%>/back_end/product_pics/Select_page.jsp">商品圖片管理首頁</a></h1>
	<div class="form-1">
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/prodpics_Servlet" name="form1" enctype="multipart/form-data">
<!-- <table>                                              -->
<!--     <tr> -->
<!-- 		<td>商品圖片編號:</td> -->
<%-- 		<td><font color=red><b>*自動生成</b></font>${param.product_photo_id}</td> --%>
<!-- 	</tr> -->
	
<%--<jsp:useBean id="ProdSvc" scope="page" class="com.productcategory.model.ProductcategoryService" /> --%>

<!-- 	<tr> -->
<%-- 	<jsp:useBean id="ProdSvc" scope="page" class="com.product.model.Product_Service" /> --%>
<!-- 		<td>商品編號:<font color=red></font></td> -->
<!-- 		<td> -->
<!-- 			<select size="1" name="product_id"> -->
<%-- 				<c:forEach var="prodVO" items="${ProdSvc.all}"> --%>
<%-- 					<option value="${prodVO.product_id}">${prodVO.product_name} --%>
<%-- 				</c:forEach> --%>
<!-- 			</select> -->
<!-- 		</td> -->
		
<!-- 	 <tr> -->
<!-- 		<td >商品照片:</td> -->
<!-- 		<td><input type="file" name="product_photo" accept="image/*" ></td> -->
<!-- 	 </tr> -->
<!-- </table> -->

<ul>
<!-- <li> -->
<%-- <h2>商品圖片編號:<font color=red><b>*自動生成</b></font>${param.product_photo_id}</h2> --%>
<!-- </li> -->
<jsp:useBean id="ProdSvc" scope="page" class="p.com.product.model.Product_Service" />
<li>
<h2>商品名稱:

<select size="1" name="product_id" style="font-size:30px;">
				<c:forEach var="prodVO" items="${ProdSvc.all}">
					<option value="${prodVO.product_id}">${prodVO.product_name}
				</c:forEach>
			</select></h2>

</li>

<li>
<h2>商品照片:<input type="file" name="product_photo" accept="image/*" ></h2>
</li>

</ul>

<!-- <ul> -->
   
<!-- 		<li>商品圖片編號: -->
<%-- 		<font color=red><b>*自動生成</b></font>${param.product_photo_id}</li> --%>
	
<%-- 不用<jsp:useBean id="ProdSvc" scope="page" class="com.productcategory.model.ProductcategoryService" /> --%>

<%-- 	<jsp:useBean id="ProdS" scope="page" class="com.product.model.Product_Service" /> --%>
<!-- 		<li>選擇商品編號:<font color=red></font> -->
<!-- 			<select size="1" name="product_id"> -->
<%-- 				<c:forEach var="prodVO" items="${ProdS.all}"> --%>
<%-- 					<option value="${prodVO.product_id}" style="font-size:23px">${prodVO.product_id} --%>
<%-- 				</c:forEach> --%>
<!-- 			</select> -->
<!-- 		</li> -->
		

<!-- 		<li>商品照片: -->
<!-- 不用<input type="file" name="product_photo" accept="image/*" ></li> -->
<!-- 		<input type="file" name="product_photo" accept="image/*"> -->
						 


<!-- </ul> -->

<br><br>
<input type="hidden" name="action" value="insert">
<%-- <input type="hidden" name="product_id" value="${param.product_id}"> --%>
<input class="sub" type="submit" value="送出新增"></FORM>





		<!------------------- 這裡是listALL -------------->
<%-- 		<jsp:include page="listAllProdpics.jsp" /> --%>


</div>
	</main>


</body>
</html>