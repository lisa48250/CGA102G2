<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.car_product_category.model.*"%>
<%@ page import="com.members.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<h1>Mainpage</h1>
	<jsp:useBean id="memSvc" scope="page"
		class="com.members.model.MemberService" />
		
		
	<form method="post" action="<%=request.getContextPath()%>/CarpdServlet">
		
		<select name="memberId">
			<c:forEach var="memVo" items="${memSvc.all}">
				<option value="${memVo.member_id}">${memVo.member_id}</option>
			</c:forEach>
		</select> 
		<a href="<%=request.getContextPath()%>/purchase_car/Carhomepage.jsp">
		<%-- <img src="<%=request.getContextPath()%>/purchase_car/image/shopping-cart.png"> --%>
		<input type="hidden" name="action" value="getOne_memberId_car_list" />
	 	<input type="image" src="<%=request.getContextPath()%>/purchase_car/image/shopping-cart.png" alt="Submit">
	 	</a>
	</form>
	
	
	
	
	<!-- // 配合Modal -->
<form method="post" action="<%=request.getContextPath()%>/CarpdServlet">

		<select name="memberId">
			<c:forEach var="memVo" items="${memSvc.all}">
				<option value="${memVo.member_id}">${memVo.member_id}</option>
			</c:forEach>
		</select> 
		
		<a href="<%=request.getContextPath()%>/purchase_car/Carhomepage.jsp" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong" style="background-color:white; border:1px solid white;" >
  		<%-- <img src="<%=request.getContextPath()%>/purchase_car/image/shopping-cart.png"> --%>
  		<input type="hidden" name="action" value="getOne_memberId_car_list" />
	 	<input type="image" src="<%=request.getContextPath()%>/purchase_car/image/shopping-cart.png" alt="Submit">
	</a>
	</form>


<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
        <jsp:include page="Carhomepage.jsp"/>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


	
	
	


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>