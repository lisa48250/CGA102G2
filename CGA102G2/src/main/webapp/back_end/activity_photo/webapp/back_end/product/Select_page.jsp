<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="p.com.productcategory.model.*"%>
    
     
<!DOCTYPE html>
<html>
<head>

 
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/backend_product.css">
<title>CGA 102 Product: Home</title>

<style>
/* main的css */
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
  
  b, a, select {
  font-size: 25px;
  }
  a {
  color: blue;
  text-decoration:underline;
  }
  .form-1{
  	border:1px solid gray;
	border-radius: 10px;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	position:relative;
	display:inline-block;
	left:160px;
	top:50px;
	font-size:20px;
	width:700px;
  }
  .two{
  	position:relative;
  	top:40px;
  	left:170px;
  }
  .allinput{
  	border:1px solid black;
  	font-size:14px;
  }
  .sub{
  	border:1px solid black;
  	background-color:white;
  	color:black;
  	font-size:14px;
  	cursor:pointer;
  }
  .sub:hover{
  	background-color:black;
  	color:white;
  }
  select{
  	font-size:14px;
  	border:1px solid black;
  }
  
</style>

</head>

<!-- -----------------------------------  公版頁面  ----------------------------------- -->
<body>
    <header>
        <nav class="nav">

            <div class="logo">

                <a href="" class="logo_a">
                    <img src="<%=request.getContextPath()%>/images/logo.png" alt="">
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
<!--                     <img src="../../images/group (1).png"><a href="#">員工管理</a> -->
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
<%-- <%include file="backendWindows.html" %> --%>

<main>
<!-- <table id="table-1"> -->
<!--    <tr><td><h3>CGA102_2 product: Home</h3><h4>( MVC )</h4></td></tr> -->
<!-- </table> -->

<!-- <p>This is the Home page for CGA102 product: Home</p> -->

<h1>商品管理:</h1>

<div class="two">
<%-- <a href='<%=request.getContextPath()%>/back_end/product/List_all_prods.jsp'>所有商品清單</a> --%>
</div>
<div  class="two">
<%--  <a style="color:blue" size=20px href='<%=request.getContextPath()%>/back_end/product/Add_product.jsp'>新增商品</a><!-- a new Product --> --%>
 </div>
<div class="form-1">



<ul style="list-style:none;">

  <li>
  <a href='<%=request.getContextPath()%>/back_end/product/List_all_prods.jsp'>所有商品清單</a>
  </li>
  <li>
 <a style="color:blue" size=20px href='<%=request.getContextPath()%>/back_end/product/Add_product.jsp'>新增商品</a><!-- a new Product -->
  </li>
  
  
<!--   <li> -->
<%--     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/product.do" > --%>
<!--         <b>輸入商品編號 (如：1, 2, 3...):</b> -->
<%--         <input class="allinput" type="text" name="product_id" value="${param.product_id}"> --%>
<!--         <input type="hidden" name="action" value="getOne_For_Display"> -->
<%--         <input class="sub" type="submit" value="送出"><font color=red>${errorMsgs.product_id}</font> --%>
<!--     </FORM> -->
<!--   </li> -->

  <jsp:useBean id="ProdSvc" scope="page" class="p.com.product.model.Product_Service" />
   
  <li>          <%--"<%=request.getContextPath() %>/chat.do" method="POST" --%>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/product.do" >
       <b>選擇商品編號:</b>
       <select style="font-size:20px"  size="1" name="product_id">
         <c:forEach var="prodVO" items="${ProdSvc.all}" > 
          <option value="${prodVO.product_id}">${prodVO.product_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input class="sub" type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/product.do" >
       <b>選擇商品名稱:</b>
       <select style="font-size:20px"  size="1" name="product_id">
         <c:forEach var="prodVO" items="${ProdSvc.all}" > 
          	<option value="${prodVO.product_id}">${prodVO.product_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input class="sub" type="submit" value="送出">
     </FORM>
  </li>
  
  
  <jsp:useBean id="ProdCatSvc" scope="page" class="p.com.productcategory.model.Product_category_Service" />
  <li>
	 <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/product.do">
	 <b>選擇商品類型:</b>
	   <select style="font-size:20px"  size="1" name="product_category_id">
	   <c:forEach var="prodCatVO" items="${ProdCatSvc.all }">
	   		<option value="${prodCatVO.product_category_id }">${prodCatVO.product_category_name }
	   </c:forEach>
	   </select>
	   
       <input type="hidden" name="action" value="find_by_category_id">
       <input class="sub" type="submit" value="送出">
	 
	 </FORM>
  
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/product.do" >
       <b>選擇商品名稱:</b>
       <input style="font-size:20px" class="allinput" type="text" name="product_name">
       <input type="hidden" name="action" value="select_like_name">
       <input class="sub" type="submit" value="送出"><front>${errorMsgs.product_name}</front>
     </FORM>
  </li>
  
  
</ul>


<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message.value}</li>
		</c:forEach>
	</ul>
</c:if>
</div>
</main>

</body>
</html>