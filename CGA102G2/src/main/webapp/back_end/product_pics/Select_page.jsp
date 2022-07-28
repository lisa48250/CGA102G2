<%-- <%@ page language="java" contentType="text/html; charset=BIG5" --%>
<%--     pageEncoding="BIG5"%> --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/backend_product.css">
<title>CGA 102 Product Picture: Home</title>

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

  h4 {
    color: blue;
    display: inline;
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
	font-size:14px;
  	width:350px;
  	height:300px;
  }
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

<!-- <table id="table-1"> -->
<!--    <tr><td><h3>CGA102_2 product picture: Home</h3><h4>( MVC )</h4></td></tr> -->
<!-- </table> -->

<!-- <p>This is the Home page for CGA102 product category: Home</p> -->

<!-- <h3>資料查詢:</h3> -->

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message.value}</li>
		</c:forEach>
	</ul>
</c:if>

<h1>商品圖片:</h1>
<div class="form-1">
<!-- <ul style="list-style:none;"> -->
<%--   <li><h2><a href='<%=request.getContextPath() %>/back_end/product_pics/Add_prodpics.jsp'>新增商品圖片</a></h2> </li> --%>
<!-- </ul> -->
<ul style="list-style:none;">	
  <li><h1><a href='<%=request.getContextPath() %>/back_end/product_pics/List_all_prodpics.jsp'>全部商品圖片</a></h1></li>  
  <li><h1><a href='<%=request.getContextPath() %>/back_end/product_pics/Add_prodpics.jsp'>新增商品圖片</a></h1> </li>
<!--   <li> -->
<%--     <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/prodpics_Servlet" > --%>
<!--         <b>輸入商品類別編號 (如：1, 2, 3...):</b> -->
<%--         <input type="text" name="product_category_id" value="${param.product_category_id}"> --%>
<!--         <input type="hidden" name="action" value="getOne_For_Display"> -->
<%--         <input type="submit" value="送出"><font color=red>${errorMsgs.product_category_id}</font> --%>
<!--     </FORM> -->
<!--   </li> -->

  <jsp:useBean id="ProdSvc" scope="page" class="p.com.product.model.Product_Service" />
   
  <li> 
     <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/prodpics_Servlet" >
       <h1><b>選擇商品:</b></h1>
       <select size="1" name="product_id" style="font-size:30px;">
         <c:forEach var="prodVO" items="${ProdSvc.all}" > 
          <option value="${prodVO.product_id}">${prodVO.product_name}
<!--           <input type="hidden" name></input> -->
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="select_product">
       <br><br>
       <input type="submit" value="送出">
    </FORM>
  </li>
  
<%--   <jsp:useBean id="Pvc" scope="page" class="com.product.model.Product_Service" /> --%>
<!--   <li> -->
<%--      <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/prodpics_Servlet" > --%>
<!--        <b>選擇商品編號:</b> -->
       
<!--        <select size="1" name="product_id"> -->
<%--          <c:forEach var="prodVO" items="${Pvc.all}" >  --%>
<%--           <option value="${prodVO.product_id}">${prodVO.product_name} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
       
<!--   ===      -->
<!--        以上呼叫product_pics_service -->
<!--        <select size="1" name="product_id"> -->
<%--          <c:forEach var="prodVO" items="${ProdSvc.all}" >  --%>
<%--           <option value="${prodVO.product_id}">${prodVO.product_id} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
<!--         === -->
<!-- ------------------------------------------------------ -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="送出"> -->
<!--      </FORM> -->
<!--   </li> -->
</ul>


<!-- <h1>新增商品圖片</h1> -->


</div>
</main>

</body>
</html>