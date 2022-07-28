<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.car_product_category.model.*"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	List<CarpdVO> carVOlist = (List<CarpdVO>)request.getAttribute("carList");
	
	/* int total = 0;
	for(CarpdVO carVO : carVOlist){
		ProductVO poVO = carVO.getProductVo();
		total += carVO.getQuantity() * poVO.getProduct_price();
	} */
	pageContext.setAttribute("carVOlist", carVOlist);
	/* pageContext.setAttribute("total", total); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href=""> 
<%-- ${pageContext.request.contextPath}/product_order_detail --%>
<title>CarHomepage</title>
<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
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
</style>
</head>
<body>
	<h3>Carhomepage.jsp</h3>
			

	<table>
		<tr>
			<!-- <th>會員編號</th> -->
			<th>商品編號</th>
			<th>商品名稱</th>
			<th>單價價格</th>
			<th>總數量</th>
			<th>總金額</th> <!-- //這裡要join -->	
			<th>移除商品</th>
		</tr>
		
		<c:forEach var="carVO" items="${carVOlist}">
		<tr>
		<%-- <td>${carVO.member_id}</td> --%>
		
		<td>${carVO.product_id}</td>
		<td>${carVO.productVo.product_name}</td>
		<td>${carVO.productVo.product_price}</td>
		<td>${carVO.quantity}</td>
		<td>${carVO.productVo.product_price * carVO.quantity}</td> <!-- 單件總金額 -->
		<td>
			<form action="<%=request.getContextPath()%>/CarpdServlet">
				<input type="submit" value="Ｘ">
				<input type="hidden" name="carVO_product_id" value="${carVO.product_id}">
				<input type="hidden" name="carVO_member_id" value="${carVO.member_id}">
				<input type="hidden" name="action" value="delete">
			</form>
		</td>
		</tr>
		</c:forEach> 
	</table>
	<%-- <div style="color:red">總金額：${total}</div> --%>
		<%-- <%@ include file="page1.file" %> --%>
		<%-- begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%> --%>
		<a href="${pageContext.request.contextPath}/purchase_car/Mainpage.jsp">Back</a>
</body>
</html>