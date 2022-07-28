<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="p.com.product.model.*"%>
<%-- <%@ page import="com.productcategory.model.*"%> --%>

<% 
  // EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/backend_product.css">
<title>修改商品資料 - update_product.jsp</title>

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

td {
    height:100px;
    width:100px;
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
.input{
	width:250px;

}
.inputText{
	width:350px;
}
.sub{
	border:1px solid black;
	background-color:white;
	position:relative;
	left:40px;
	bottom:-10px;
	color:blue;
}
.sub:hover{
	border:1px solid black;
	background-color:black;
	color:white;
}
.error{
	position:relative;
	left:40px;
	bottom:90px;
	font-size:20px;
}
select{
	border:1px solid black;
	font-size:14px;
	
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
<%--                     <img src="<%=request.getContextPath() %>/images/group (1).png"><a href="#">員工管理</a><!-- ../../images/ --> --%>
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

<div class="form-1">
<a href="<%=request.getContextPath()%>/back_end/product/Select_page.jsp"><font style="color:blue"><h1>回商品管理首頁</h1></font></a>
<h2>資料修改:</h2>

<!-- 00000000000000000000000000000 -->
<!--
<FORM METHOD="post" ACTION="<%=request.getContextPath() %>/product.do" name="form1">
<table>

    <tr>
		<td height="60px">商品編號:</td>
		<td height="60px"><font color=red><b>${param.product_id}</b></font>

	</tr>
<jsp:useBean id="ProdCatSvc" scope="page" class="p.com.productcategory.model.Product_category_Service" />
	<tr>
		<td height="60px">商品類別:</td>
 		<td height="60px">
 
 		<select style="font-size:16px" size='1' name='product_category_id'>		
				 <c:forEach var='prod' items='${ProdCatSvc.all }'>
		         		<option value='${prod.product_category_id }'> ${prod.product_category_name}
		         </c:forEach>
        </select>		

		</td>
	</tr>
	
	<tr>
		<td>商品簡介:</td>
		

		
		<td><input class="inputText" type="TEXT" name="product_describtion" size="45"
			 value="${param.product_describtion}"/></td>
	
	
	</tr>


	<tr>
		<td  height="60px">商品價格:</td>
		<td  height="60px"><input class="input" type="TEXT" name="product_price" size="45"
			 value="${param.product_price}"/></td>

	</tr>
	<tr>
		<td height="60px">商品名稱:</td>
		<td  height="60px"><input class="input" type="TEXT" name="product_name" size="45"
			 value="${param.product_name}"/></td>

	</tr>
	<tr>
		<td height="60px">商品數量:</td>
		<td height="60px"><input type="TEXT" name="product_quantity" size="45"
			 value="${param.product_quantity}"/></td>

	</tr>
	<tr>
		<td height="60px">商品狀態:</td>
	 	<td height="60px">
	 	<select size="1" name="product_status">
				<option value="false">下架
				<option value="true">上架			
		</select> 

		</td>
	</tr>


</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="product_id" value="${param.product_id}">
<input class="sub" type="submit" value="送出修改"></FORM> -->
<!-- 00000000000000000000000000000 -->


<!-- 111111111111111111111111111111 -->
<h3>
<FORM METHOD="post" ACTION="<%=request.getContextPath() %>/product.do" name="form1">
<ul style="list-style:none;">
<%--      <jsp:useBean id="ProdSvc" scope="page" class="com.product.model.Product_Service" /> --%>
    <div>
		<li>商品編號:      <font color=blue><b>${param.product_id}</b></font></li>
	</div>
<!-- 		<select size='1' name='product_id'> -->
		
<%-- 		         <c:forEach var='prod' items='${ProdSvc.all }'> --%>
<%--          <option value='${prod.product_id }'> ${prod.product_id} --%>
<%--          </c:forEach> --%>
<!--          </select> -->
		
<%-- 		<c:forEach var="prodVO" items="${ProdSvc.all}" >  --%>
<%--           <option value="${prodVO.product_id}">${prodVO.product_id} --%>
<%--          </c:forEach>   --%>
         

		
<%-- 		<c: forEach var="prod" items="${ProdSvc.all }"> --%>
<%-- 		<option value='${prod.product_id }'></option> --%>
<%-- 		</c: forEach></select>${param.product_id}</td> --%>

	
	
		<jsp:useBean id="ProdCatSVC" scope="page" class="p.com.productcategory.model.Product_category_Service" />	
<%-- 	<jsp:useBean id="ProdCatSvc" scope="page" class="p.com.productcategory.model.Product_category_Service" /> --%>
<div><br>
		<li>商品類別：
 
 		<select style="font-size:16px" size='1' name='product_category_id'>		
				 <c:forEach var='prod' items='${ProdCatSvc.all }'>
		         		<option value='${prod.product_category_id }'> ${prod.product_category_name}
		         </c:forEach>
        </select>		

		</li>
</div>

<div><br>		
		<li>商品簡介：<font style="color:red; font-size:16px;">${errorMsgs.product_describtion}</font>
		<br>
										<!-- 		<td> -->
		<textarea name="product_describtion" id="editor1" cols="30" rows="10">${param.product_describtion}</textarea>
            <script>
              CKEDITOR.replace( 'editor1' ); 
            </script>
										<!-- 		</td> -->
		
		
<%-- 		<td>${errorMsgs.product_describtion}</td> --%>
		
<!-- 	<input class="inputText" type="TEXTAREA" name="product_describtion" size="45" -->
<%-- 			 value="${param.product_describtion}"/> --%>
			 
		</li>
<%-- 			 <td>${errorMsgs.product_describtion}</td> --%>
</div>	
	


<div><br>
		<li>商品價格： <input class="input" type="TEXT" name="product_price" size="10"
			 value="${param.product_price}"/><font style="color:red; font-size:16px;">${errorMsgs.product_price}</font></li>
<%-- 			 <td>${errorMsgs.product_price}</td> --%>
</div>
<div><br>
		<li>商品名稱： <input class="input" type="TEXT" name="product_name" size="10"
			 value="${param.product_name}"/><font style="color:red; font-size:16px;">${errorMsgs.product_name}</font></li>
<%-- 			 <td>${errorMsgs.product_name}</td> --%>
</div>
<div><br>
		<li>商品數量： <input class="input"  type="TEXT" name="product_quantity" size="10"
			 value="${param.product_quantity}"/><font style="color:red; font-size:16px;">${errorMsgs.product_quantity}</font></li>
<%-- 			 <td>${errorMsgs.product_quantity}</td> --%>
</div>
<div><br>
		<li>商品狀態：
<!-- 		<td><input type="TEXT" name="product_status" size="45" -->
<%-- 			 value="${param.product_status}"/></td><td>${errorMsgs.product_status}</td> --%>
	 	
	 	<select style="font-size:16px" size="1" name="product_status">
				<option value="false">下架
				<option value="true">上架			
		</select> 
		<%-- ${param.product_status} --%>
		</li>
</div>

</ul>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="product_id" value="${param.product_id}">
<input class="sub" type="submit" value="送出修改">
</FORM></h3>
<!-- 111111111111111111111111111111 -->
<!-- <br><br><br><br> -->
<!-- <div class="error"> -->
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red"><h2>請修正以下錯誤:</h2></font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red"><h2>${message.value}</h2></li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<!-- </div> -->
	</div>

</main>
</body>

</html>