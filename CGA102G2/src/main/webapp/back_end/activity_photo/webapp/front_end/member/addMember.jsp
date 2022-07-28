<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.members.model.*"%>

<%
  MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>會員資料新增 - addMember.jsp</title>

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

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>會員資料新增 - addMember.jsp</h3></td><td>
		 <h4><a href="${pageContext.request.contextPath}/select_member.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Member_Servlet" name="form1">

<table>
	<tr>
		<td>Email:</td>
		<td><input type="TEXT" name="member_email" size="45"
			 value="<%= (memberVO==null)? "12345@gmail.com" : memberVO.getMember_email()%>" /></td>
	</tr>
	
	<tr>
		<td>會員密碼:</td>
		<td><input type="TEXT" name="member_password" size="45" 
			 value="<%= (memberVO==null)? "12345" : memberVO.getMember_password()%>" /></td>
	</tr>
	
	<tr>
		<td>會員姓名:</td>
		<td><input type="TEXT" name="member_name" size="45"
			 value="<%= (memberVO==null)? "吳永志" : memberVO.getMember_name()%>" /></td>
	</tr>
	
	<tr>
		<td>會員電話:</td>
		<td><input type="TEXT" name="member_phone" size="45"
			 value="<%= (memberVO==null)? "0988581089" : memberVO.getMember_phone()%>" /></td>
	</tr>
	
	<tr>
		<td>會員地址:</td>
		<td><input type="TEXT" name="member_address" size="45"
			 value="<%= (memberVO==null)? "桃園市中壢區" : memberVO.getMember_address()%>" /></td>
	</tr>
	
	<tr>
		<td>會員狀態:</td>
		<td><input type="TEXT" name="member_status" size="45"
			 value="<%= (memberVO==null)? "1" : memberVO.getMember_status()%>" /></td>
	</tr>

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>



