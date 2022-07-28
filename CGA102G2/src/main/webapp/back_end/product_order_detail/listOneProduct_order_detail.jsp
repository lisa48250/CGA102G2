<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
Product_order_detailVO poVO = (Product_order_detailVO) request.getAttribute("poVO");
//EmpServlet.java(Controller), 存入req的empVO物件

%>
<%-- <%=poVO.get %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomePageCss.css">
<title>訂單查詢結果</title>


<style>
 table {
	border-radius: 5px;
	position: relative;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 1010px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
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
}

th, td, tr {
	border: 1px solid darkgray;
}
.Img{
	width:27px;
	height:27px;
	position:absolute;
	margin-top:-13px;
	margin-left:-11px;
}
.homeclick{
	position:relative;
	display:inline-block;
	top:0px;
	right:5px;

}
#delete{
	position:relative;
	bottom:5px;
	right:5px;
}
</style>
</head>
<body>
<header>
		<nav class="nav">

			<div class="logo">

				<a href="" class="logo_a"> <img src="${pageContext.request.contextPath}/images/logo.png" alt="">
				</a> <a class="nav-top-a" href=""><img class="nav-top-chat"
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
               
<!--                  <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/bed.png"><a href="#">房務管理</a> --%>
<!--                     <ul id="list"> -->
<!--                        	<li><a href=''>住宿訂單管理</a></li> -->
<!--                         <li><a href=''>訂單明細管理</a></li> -->
<!--                         <li><a href=''>房型管理</a></li> -->
<!--                         <li><a href=''>房間管理</a></li> -->
<!--                         <li><a href=''>房型圖片管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/camping.png"><a href="#">活動管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>活動類別管理</a></li> -->
<!--                         <li><a href=''>活動項目管理</a></li> -->
<!--                         <li><a href=''>活動場次管理</a></li> -->
<!--                         <li><a href=''>活動訂單管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
                <li>
                    <img src="${pageContext.request.contextPath}/images/gift.png"><a href="${pageContext.request.contextPath}/back_end/product_order_detail/homepage.jsp">伴手禮管理</a>
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
<main>    
<table id="table-1">
	<tr><td>
		 <h3>訂單查詢資料</h3>
		 <a
								href="${pageContext.request.contextPath}/back_end/product_order_detail/homepage.jsp"><img
								src="${pageContext.request.contextPath}/images/home.png"
								width="50" height="50" border="0" class="homeclick"></a>
	</td></tr>
</table>
<table>
	<tr>
		<th>訂單編號</th>
		<th>會員編號</th>
		<th>訂單日期</th>
		<th>訂單總價</th>
		<th>付款方式</th>
		<th>訂單狀態</th>
		<th>修改訂單</th>
		
	</tr>
	
	<tr>
		<td><%=poVO.getProduct_order_id()%></td>
		<td><%=poVO.getMember_id()%></td>
		<td><%=poVO.getProduct_order_date()%></td>
		<td><%=poVO.getProduct_amount()%></td>
		<c:set var="method" value="${poVO.payment_method}"/>
				<c:if test="${method == 0}">
					<td>信用卡</td>
				</c:if>
				<c:if test="${method == 1}">
					<td>現場付款</td>
				</c:if>
		<c:set var="status" value="${poVO.order_status}"/>
				<c:if test="${status == 0}">
					<td>已付款</td>
				</c:if>
				<c:if test="${status == 1}">
					<td>訂購完成</td>
				</c:if>
				<c:if test="${status == 2}">
					<td style="color:red;">取消</td>
				</c:if>
				
				<td>
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/Product_order_detailServlet"
							style="margin-bottom: 0px;">
							<input  class="Img" type="image" src="<%=request.getContextPath()%>/images/update.png" alt="Submit">
							<!-- <input type="submit" value="修改"> --> 
							<input type="hidden" name="product_order_id" value="<%=poVO.getProduct_order_id()%>"> 
							<input type="hidden" name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<c:if test="${status == 2}">
					<td>
						<FORM class="deleteForm" METHOD="post" 
							ACTION="${pageContext.request.contextPath}/Product_order_detailServlet" 
							style="margin-bottom: 0px;"> 
							<button class="delete" id="delete" style="z-index:1; border:none; cursor:pointer;"><img  class="Img" src="<%=request.getContextPath()%>/images/delete.png" style="z-index:0;"></button> 
							
<!-- 							<input type="submit" value="刪除">   -->
							<input type="hidden"
								name="product_order_id" 
								value="<%=poVO.getProduct_order_id()%>"> <input
								type="hidden" name="action" value="delete">
<%-- 								<input type="hidden" name="memberId" value="${eachOrderListVO.member_id}">  --%>
 						</FORM> 
					</td> 
					</c:if>
	</tr>
</table>
</main>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$(".delete").click(function(e){
	 e.preventDefault();
	 let that = $(this);
	  swal({
	     title: "確定要刪除嗎?",
	     icon: "warning",
	     buttons: {
	         Btn: false,
	         cancel: {
	           text: "取消",
	           visible: true
	         },
	         confirm: {
	           text: "確定",
	           visible: true
	         }
	       }
	  }).then(function(value) {
	   if(value) {
		  $(that).closest('.deleteForm').submit();
	   }
	  });
	})
</script>

</body>
</html>