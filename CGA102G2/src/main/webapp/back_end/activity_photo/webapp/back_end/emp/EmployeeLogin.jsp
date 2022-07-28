<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>員工登入</title>
	<style>
	
	* {
			box-sizing: border-box;
			font-family: "cwTeXYen", sans-serif;
		}

		body {
			background-size: cover;
			background-repeat: no-repeat;
			width: 100%;
			height: 570px;
			margin: 0;
		}

		.div-top {
			width: 600px;
			height: 110px;
			background-color: red;
			border-radius: 20px 20px 0px 0px;
			position: absolute;
			margin-bottom: -80px;
			left: 370px;
			top: 100px;
			background-color: #3B413B;
		}

		.div-bottom {
			background-color: rgb(59, 65, 59, 0.5);
			position: absolute;
			top: 210px;
			left: 370px;
			width: 600px;
			height: 300px;
			border-radius: 0px 0px 20px 20px;
		}

		.div-img img {
			width: 350px;
			height: 80px;
			position: relative;
			top: 20px;
			left: 0px;

		}

		.div-span span {
			font-size: 30px;
			color: white;
			position: relative;
			top: -35px;
			right: -365px;
			letter-spacing: 2px;
		}

		.input1 input {
			background-color: white;
			padding: 15px 30px 15px 30px;
			border-radius: 30px;
			width: 440px;
			border-color: transparent;
			position: relative;
			top: 30px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 83px;
			color: #3B413B;
			text-align: center;
		}

		.input2 input {
			width: 440px;
			padding: 15px 30px 15px 30px;
			border-radius: 30px;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 68px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 83px;
			color: #3B413B;
			text-align: center;
		}

		.input3 input {
			width: 440px;
			padding: 15px 30px 15px 30px;
			border-radius: 45px;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 100px;
			font-size: 25px;
			left: 83px;
			background-color: #3B413B;
			color: white;
		}
		
		.error{
			position: relative;
			left:970px;
			top:260px;	
	</style>
</head>


<body background="${pageContext.request.contextPath}/images/back.jpg">

<c:if test="${not empty errorMsgs}">
<div class="error">	
<font style="color:red"></font>

		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
</div>
</c:if>

<FORM method="post" action="${pageContext.request.contextPath}/emploginhandler">
	<div class="div">
		<div class=" div-top">
			<div class="div-img">
				<img src="${pageContext.request.contextPath}/images/1.png" alt="">
			</div>
			<div class="div-span">
				<span>後台管理員登入</span>
			</div>
		</div>
		<div class="div-bottom">
			<div class="input1">
				<input type="text" name="account" value="${employeeVO.emp_account}" placeholder="請輸入員工帳號">
			</div>
			<div class="input2">
				<input type="password" name="password" value="${employeeVO.emp_password}" placeholder="請輸入員工密碼">
			</div>
			<div class="input3">
			<input type="hidden" name="action" value="Login_Emp">
			<input style="cursor:pointer;" type="submit" value="登入">
				
			</div>
			
		</div>
	</div>
	</FORM>
</body>

</html>