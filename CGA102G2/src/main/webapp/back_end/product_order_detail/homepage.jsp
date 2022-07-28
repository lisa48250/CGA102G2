<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomePageCss.css"> 
<%-- ${pageContext.request.contextPath}/product_order_detail --%>
<title>後台商成管理首頁</title>
<style>

/* =============================================== */

</style>

<style>
#table-2{
	margin-top:200px;
} 
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
	padding: 3px;
	text-align: center;
}
	
/* thead.thead>tr th:nth-child(2), thead.thead>tr th:nth-child(3) {
	width: 250px;
}

tbody.tbody tr:hover {
	content: attr(title);
	background-color: rgb(208, 255, 255);
} */

.table {
	text-align: center;
}

th, td, tr {
	border: 1px solid darkgray;
}
.Img{
	width:30px;
	height:30px;
	position:absolute;
	margin-top:-13px;
	margin-left:-11px;
}

h3{
	border:1px solid red;
	position:relative;
	text-align: center;
	height:50px;
	
}

#delete{
	position:relative;
	bottom:5px;
	right:5px;
}

</style>

</head>

<body bgcolor='white'>
<jsp:useBean id="productsvc"
		class="d.com.product_order_detail.model.Product_order_detailService" />
	<%
	

	List<Product_order_detailVO> productOrderList = productsvc.getAll();
	pageContext.setAttribute("productOrderList", productOrderList);
	%>
	<header>
		<nav class="nav">

			<div class="logo">

				<a href="" class="logo_a"> <img src="${pageContext.request.contextPath}/images/logo.png" alt="">
				</a> <a class="nav-top-a" href=""><img class="nav-top-chat"
					src="${pageContext.request.contextPath}/images/chat.png" alt="">
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
               
<!--                 <li>  -->
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
		<%-- <div class="search-form">
			<p class="title">訂單查詢</p>
			<ul class="form-list">
				<li>
			  		<FORM METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
						<b>輸入訂單編號 (1):</b> <input type="text" name="product_id"> <input
							type="hidden" name="action" value="getOne_Product_Detail">
						<input type="submit" value="送出"><br>
					</FORM>

				</li>
				<jsp:useBean id="podSvc" scope="page"
					class="com.product_order_detail.model.Product_order_detailService" />
				<li>
					<FORM METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
						<b>查詢訂單編號:</b> <select size="1" name="product_id">
							<c:forEach var="podVo" items="${podSvc.all}">
								<option value="${podVo.product_order_id}">${podVo.product_order_id}
							</c:forEach>
						</select> <input type="hidden" name="action" value="getOne_Product_Detail">
						<input type="submit" value="送出">
					</FORM>
				</li>
				<jsp:useBean id="memSvc" scope="page"
					class="com.members.model.MemberService" />
				<li>
					<FORM METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
						<b>選擇會員編號:</b> <select size="1" name="memId">
							<c:forEach var="memVo" items="${memSvc.all}">
								<option value="${memVo.member_id}">${memVo.member_id}
							</c:forEach>
						</select> <input type="hidden" name="action"
							value="getOne_Product_DetailbyMember"> <input
							type="submit" value="送出">
					</FORM>
				</li>
			</ul>
			
			<!-- 圖片區 -->
			<FORM method="post" enctype="multipart/form-data" ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
			<input type="hidden" name="action" value="upload">
			<img src="${pageContext.request.contextPath}/Product_order_detailServlet?action=upload&test=1">
			same as src = "<%request.getContextPath()%>"
			</FORM> 
			
			<div class="errorMsg">
				<c:if test="${not empty errorMsg}">
					<ul>
						<c:forEach var="message" items="${errorMsg}">
							<li style="color: red">*${message}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div> --%>
<div id="tableall2">
		<%@ include file="searchForm.jsp" %>
			<table id="table-2">
			<tr>
				<th>訂單編號</th>
				<th>會員編號</th>
				<th>訂單日期</th>
				<th>購買數量</th>
				<th>付款方式</th>
				<th>訂單狀態</th>
				<th>修改訂單</th>
				<th>刪除訂單</th>

			</tr>

		<%-- <%@ include file="page1.file" %>  --%>
			<%-- begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%> --%>
			<c:forEach var="eachOrderListVO" items="${productOrderList}"
				varStatus="d">
				<tr>
					<td>${eachOrderListVO.product_order_id}</td>
					<td>${eachOrderListVO.member_id}</td>
					<td><fmt:formatDate
							value="${eachOrderListVO.product_order_date}"
							pattern="yyyy-MM-dd" /></td>
					<td>${eachOrderListVO.getProduct_amount()}</td>
					<c:set var="method" value="${eachOrderListVO.payment_method}" />
					<c:if test="${method == 0}">
						<td>信用卡</td>
					</c:if>
					<c:if test="${method == 1}">
						<td>現場付款</td>
					</c:if>

					<c:set var="status" value="${eachOrderListVO.order_status}" />
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
							<input type="hidden" name="product_order_id" value="${eachOrderListVO.product_order_id}"> 
							<input type="hidden" name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<c:if test="${status == 2}">
					<td>
						<FORM class="deleteForm" METHOD="post"
							ACTION="${pageContext.request.contextPath}/Product_order_detailServlet"
							style="margin-bottom: 0px;">
							<button class="delete" id="delete" style="z-index:1; border:none; cursor:pointer;"><img  class="Img" src="<%=request.getContextPath()%>/images/delete.png" style="z-index:0;"></button>
							
							<!-- <input type="submit" value="刪除"> --> 
							<input type="hidden"
								name="product_order_id"
								value="${eachOrderListVO.product_order_id}"> <input
								type="hidden" name="action" value="delete">
								<input type="hidden" name="memberId" value="${eachOrderListVO.member_id}">
						</FORM>
					</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
</div>

		<!------------------- 這裡是listALL -------------->
		
		
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