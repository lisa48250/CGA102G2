<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="p.com.product.model.*"%>
<%-- <%@ page import="com.productcategory.model.*"%> --%>

<% 
//ProductVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/backend_product.css">
<title>新增商品資料 - addProduct.jsp</title>

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
    width:100px
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
	padding:2px;
	
}
td > input{
	border: 1px solid black;
	width:100px;
}
td > select {
	border: 1px solid black;
	width:100px;
	font-size:22px;
}

input{
	background-color:white;	
}
.inputText{
	width:350px;


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
.error{
	position:relative;
	left:750px;
	bottom:300px;
}
.back:hover{
	color:blue;
}
.sub{
	position:relative; 
	bottom: 20px; 
	left:500px; 
	border:1px solid black; 
	cursor:pointer;
}
.sub:hover{
	background-color:black;
	color:white;
}
.mainTable{
	width:800px;
	position:relative; 
	bottom: 20px; 
	left:-30px; 
	border:1px solid black; 
	cursor:pointer;
}
.mainId{
width:1000px;}

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
                    <img src="<%=request.getContextPath() %>/images/logo.png" alt="">
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

<main id="mainId">


<h1><a width="400px" href="<%=request.getContextPath() %>/back_end/product/Select_page.jsp"><font style="color:blue; font-size:13px;"><h1 class="back"style=" border-bottom:1px solid black; display:inline-block;">回商品管理首頁</h1></font></a>
<!-- <img src="<%=request.getContextPath()%>/images/back1.gif" width="10" height="32" border="0">回首頁</a> -->
</h1>
<div width="400px">
<h2>新增商品資料:</h2>
</div>



<%-- <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/product.do" name="form1"> --%>

<!-- <table> -->
<!--     <tr> -->
<!-- 		<td>商品編號</td> -->
<%-- 		<td><font color=red><b>系統產生</b></font>${param.product_id}</td> --%>
<!-- 	</tr> -->
<%--<jsp:useBean id="ProdSvc" scope="page" class="com.product.model.Product_Service" /> --%>
<%-- 		<jsp:useBean id="ProdCatSVC" scope="page" class="p.com.productcategory.model.Product_category_Service" /> --%>
<!-- 	<tr> -->
<!-- 		<td >商品類別:</td> -->
<!--  		<td> -->
<!-- 			<select style="font-size:16px" size="1" name="product_category_id"> -->
<%-- 			<c:forEach var="ProdCSvc" items="${ProdCatSVC.all}"> --%>
<%-- 			<option value="${ProdCSvc.product_category_id}" } >${ProdCSvc.product_category_name} --%>
			
<%--<option value="${ProdCSvc.product_category_id}" ${(param.product_category_id==ProdCSvc.product_category_id)? 'selected':'' } >${ProdCSvc.product_category_id} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select> -->
		
<!--<select size="1" name="product_category_id"> -->
<%-- <c:forEach var="Prod" items="${ProdCSvc.All }"> --%>
<%--<option value="${Prod.product_category_id}">${Prod.product_category_name} --%>
<%--</c:forEach>		 --%>
<!--</select> -->
		
		
		
<!--<select name="product_category_id"> -->
<!--<option value="1">1 -->
<!-- 				<option value="2">2 -->
<!-- 				<option value="3">3 -->
<%-- 			</select> ${param.product_category_id} --%>
<!-- 		</td> -->
<!-- 	</tr> -->
	
<!-- 	<tr> -->
<!-- 		<td>商品簡介:</td> -->
		
		
<!-- 		<td><input class="inputText" type="TEXT" name="product_describtion" size="45" -->
<%-- 			 value="${param.product_describtion}"/></td> --%>
<%-- 			 <td>${errorMsgs.product_describtion}</td> --%>
	
	
<!-- 	</tr> -->
		
<!-- 		<td> -->
<!-- 		<textarea name="product_describtion" id="editor1" cols="70" rows="5" ></textarea> -->
<!--              <script> -->
<!--              CKEDITOR.replace( 'editor1' ); --> 
<!--              </script> -->
<!-- 		</td height="60px" width="60px"> -->
<%--  		<td>${errorMsgs.product_describtion}</td> --%>
		
		
<!-- 		<td><input type="TEXTAREA" name="product_describtion" -->
<%-- 			 value="${param.product_describtion}"/></td> --%>
<%-- 		<td>${errorMsgs.product_describtion}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>商品價格:</td> -->
<%-- 		<td><input name="hiredate" id="f_date1" type="text"/></td><td>${errorMsgs.hiredate}</td> --%>
<!--  	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>商品價格:</td> -->
<!-- 		<td><input type="TEXT" name="product_price"  size="45" -->
<%-- 			 value="${param.product_price}"  /></td> --%>
<%--  			 <td>${errorMsgs.product_price}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>商品名稱:</td> -->
<!-- 		<td><input type="TEXT" name="product_name" -->
<%-- 			 value="${param.product_name}"/></td> --%>
<%--<td>${errorMsgs.product_name}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>商品數量:</td> -->
<!-- 		<td><input type="TEXT" name="product_quantity" -->
<%-- 			 value="${param.product_quantity}"/></td> --%>
<%--<td>${errorMsgs.product_quantity}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>商品狀態:</td> -->
<!-- 		<td><input type="TEXT" name="product_status" size="45" -->
<%--  			 value="${param.product_status}"/></td><td>${errorMsgs.product_status}</td> --%>
<!-- 	 	<td> -->
<!-- 	 	<select size="1" name="product_status"> -->
<!-- 				<option value="false">下架 -->
<!-- 				<option value="true">上架			 -->
<!-- 		</select> -->
<!-- 		</td> -->
<!-- 	</tr> -->

<%--  	<jsp:useBean id="ProdSvc" scope="page" class="com.product.model.ProductService" /> --%>
<!-- 	<tr> -->
<!-- <!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- <!-- 		<td><select size="1" name="deptno"> -->
<%-- <%-- 			<c:forEach var="ProdSvc" items="${deptSvc.all}"> --%>
<%-- 			<option value="${ProdSvc.deptno}" ${(param.deptno==ProdSvc.deptno)? 'selected':'' } >${ProdSvc.dname} --%>
<%--  			</c:forEach> --%>
<!-- <!-- 		</select></td> -->
<!-- <!-- 	</tr> -->

<!-- </table> -->
<!-- ==== -->

<div id="mainTable">
<FORM id="form" METHOD="post" ACTION="<%=request.getContextPath() %>/product.do" name="form1">
<h3>
<ul style="list-style:none;">
    
<%-- <li>商品編號</li><font color=red><b>系統產生</b></font>${param.product_id} --%>
	
<%-- 		<jsp:useBean id="ProdSvc" scope="page" class="com.product.model.Product_Service" /> --%>
		<jsp:useBean id="ProdCatSVC" scope="page" class="p.com.productcategory.model.Product_category_Service" />
	
	<div>
		<li >商品類別: 
			<select style="font-size:16px" size="1" name="product_category_id">
				<c:forEach var="ProdCSvc" items="${ProdCatSVC.all}">
					<option value="${ProdCSvc.product_category_id}" } >${ProdCSvc.product_category_name}			
				</c:forEach>
			</select>

		</li>
    </div>
	
	<div>
	<br>
		<li>商品簡介: <font color=red>${errorMsgs.product_describtion}</font><br>
		
		
<!-- 		<input class="inputText" type="TEXTAREA" name="product_describtion" size="45" -->
<%-- 			 value="${param.product_describtion}"/>${errorMsgs.product_describtion} --%>
			 
		<textarea name="product_describtion" id="editor1" cols="70" rows="5" ></textarea>
	              <script>
	               	CKEDITOR.replace( 'editor1' );  
	              </script>
			 
			 </li>
<%-- 			 <td>${errorMsgs.product_describtion}</td> --%>
	
	
	
		
<!-- 		<td> -->
<!-- 		<textarea name="product_describtion" id="editor1" cols="70" rows="5" ></textarea> -->
<!--             <script> -->
<!--               CKEDITOR.replace( 'editor1' ); -->  
<!--              </script> -->
<!-- 		</td height="60px" width="60px"> -->
<%-- 		<td>${errorMsgs.product_describtion}</td> --%>
		
		
<!-- 		<td><input type="TEXTAREA" name="product_describtion" -->
<%-- 			 value="${param.product_describtion}"/></td> --%>
<%-- 		<td>${errorMsgs.product_describtion}</td> --%>

<!-- 	<tr> -->
<!-- 		<td>商品價格:</td> -->
<%-- 		<td><input name="hiredate" id="f_date1" type="text"/></td><td>${errorMsgs.hiredate}</td> --%>
<!-- 	</tr> -->
</div>


<div>
<br>
		<li>商品價格: <input type="TEXT" name="product_price"  size="10"
			 value="${param.product_price}"  /><font color=red>${errorMsgs.product_price}</font></li>
</div>
<br>	
		<li>商品名稱: <input type="TEXT" name="product_name"  size="10"
			 value="${param.product_name}"/><font color=red>${errorMsgs.product_name}</font></li>
<%-- 			 <td>${errorMsgs.product_name}</td> --%>
	
<br>
		<li>商品數量: <input type="TEXT" name="product_quantity"  size="10"
			 value="${param.product_quantity}"/><font color=red>${errorMsgs.product_quantity}</font></li>
<%-- 			 <td>${errorMsgs.product_quantity}</td> --%>

<br>	
		<li>商品狀態: 
<!-- 		<td><input type="TEXT" name="product_status" size="45" -->
<%-- 			 value="${param.product_status}"/></td><td>${errorMsgs.product_status}</td> --%>
	 	
	 	<select style="font-size:16px"  size="1" name="product_status">
				<option value="false">下架
				<option value="true">上架			
		</select>
		</li>
	

<%-- 	<jsp:useBean id="ProdSvc" scope="page" class="com.product.model.ProductService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="ProdSvc" items="${deptSvc.all}"> --%>
<%-- 				<option value="${ProdSvc.deptno}" ${(param.deptno==ProdSvc.deptno)? 'selected':'' } >${ProdSvc.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</ul>

<!-- ==== -->

<br>
<input type="hidden" name="action" value="insert">
<%-- <input type="hidden" name="product_id" value="${param.product_id}"> --%>
<input class="sub" type="submit" value="送出新增">
</h3>
</FORM>
</div>

	
<!-- <div > -->
<%-- <c:if test="${not empty errorMsgs}"> --%>
	
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li  class="error" style="color:red"><h2>${message.value}</h2></li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<!-- </div> -->
</main>
</body>
</html>