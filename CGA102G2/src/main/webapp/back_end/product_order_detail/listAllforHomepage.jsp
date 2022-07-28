<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="com.members.model.*"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="d.com.car_product_category.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <jsp:useBean id="productsvc"
	class="com.product_order_detail.model.Product_order_detailService" />
<%
List<Product_order_detailVO> productOrderList = productsvc.getAll();
pageContext.setAttribute("productOrderList", productOrderList);

%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>

<style>
table {
	border-radius: 5px;
	position: relative;
	background-color:rgb(253,253,253);
	box-shadow:1px 1px 1px 1px #cccccc;
}

table, th, td {
	border: 0.5px solid #CCCCFF;
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
</style>
</head>
<body>
<jsp:useBean id="productsvc"
	class="d.com.product_order_detail.model.Product_order_detailService" />
	
<%
List<Product_order_detailVO> productOrderList = productsvc.getAll();
int totalPrice = 0;
List<CarpdVO> carpdVOlist = null;
for(Product_order_detailVO pdVO : productOrderList){
	MemberVO memVO = pdVO.getMemberVO();
	/* carpdVOlist =  memVO.getCarpdVO() */; 
	System.out.println(carpdVOlist);
	System.out.println("============");
}
pageContext.setAttribute("carpdVO", carpdVOlist);
pageContext.setAttribute("productOrderList", productOrderList);

%>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有訂單項目</h3>
				
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>訂單編號</th>
			<th>會員編號</th>
			<th>訂單日期</th>
			<th>訂單總數</th>
			<th>付款方式</th>
			<th>訂單狀態</th>
			
		</tr>

		<%-- <%@ include file="page1.file" %> --%>
		<%-- begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%> --%>
		<c:forEach var="eachOrderListVO" items="${productOrderList}"
			varStatus="d">
			<tr>
				<td>${eachOrderListVO.product_order_id}</td>
				<td>${eachOrderListVO.member_id}</td>
				<td><fmt:formatDate
						value="${eachOrderListVO.product_order_date}" pattern="yyyy-MM-dd" /></td>
						
				<td>${eachOrderListVO.product_amount}</td> 
				<!-- joine購物車+會員=取得購買總金額 -->
				<%-- <td><%=totalPrice%></td> --%>
				<c:set var="method" value="${eachOrderListVO.payment_method}"/>
				<c:if test="${method == 0}">
					<td>信用卡</td>
				</c:if>
				<c:if test="${method == 1}">
					<td>現場付款</td>
				</c:if>
				
				<c:set var="status" value="${eachOrderListVO.order_status}"/>
				<c:if test="${status == 0}">
					<td>已付款</td>
				</c:if>
				<c:if test="${status == 1}">
					<td>完成</td>
				</c:if>
				<c:if test="${status == 2}">
					<td style="color:red;">取消</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
		
	 <%-- <%@ forward file="homepage.jsp" %> --%>
</body>
</html>