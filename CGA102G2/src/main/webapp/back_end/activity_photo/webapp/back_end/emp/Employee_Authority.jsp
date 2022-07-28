<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.employee.model.*"%>
<%@ page import="com.job.model.*"%>

<!DOCTYPE html>

<%
  EmployeeVO employeeVO = (EmployeeVO) request.getAttribute("employeeVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<%
JobVO jobVO = (JobVO) request.getAttribute("jobVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html lang="en">

<style>
	.all{
		font-size:20px;		
		}
		
	.background{
	
		height: 600px;
        width: 600px;
        margin-left: 100px;
        margin-top:30px;
        background-color: #b1b0b0;
        border-radius: 2%;
		
		}
		
	.allemp{
		 text-align: center;
		 margin-left:230px;
		 position: relative;
		 font-size: 23px;
		}
		
	.p1{
		 text-align: center;
		 font-size: 19px;
		}
		
	
	.emp_no{
		 text-align: center;
		 margin-top:20px;
		 margin-left:30px;		
		}
		
	.emp_no2{
		margin-top:150px;
		margin-left:30px;		
		}
		
	.p4{
		text-align: center;
		 margin-left:30px;	
		}
		
	.p5{
		text-align: center;
		 margin-left:30px;	
		}
	
	.p6{
		margin-left:30px;	
		}
	.p7{
		margin-left:30px;	
		}
	.select_emp_no{
		margin-top:40px;
		}
		
	.select_emp_name{
		margin-top:40px;
		}
	.select_job_name{
		margin-top:40px;
		}
	.submit1{
	border-radius: 20px;
	color:white;
	background-color: gray;		
		}
		
	.submit2{
	border-radius: 20px;
	color:white;
	background-color: gray;			
		}
		
	.submit3{
	border-radius: 20px;
	color:white;
	background-color: gray;			
		}
		
	.submit4{
	border-radius: 20px;
	color:white;
	background-color: gray;		
		}
</style>

<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backend.css">

    <title>飯店管理後台頁面</title>

</head>

<body>
    <header>
        <nav class="nav">

            <div class="logo">

                <a href="" class="logo_a">
                    <img src="${pageContext.request.contextPath}/images/logo.png" alt="">
                </a>

                <a class="nav-top-a" href=""><img class="nav-top-chat" src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>

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
                
                <li>
                    <img src="${pageContext.request.contextPath}/images/group (1).png"><a href="#">員工管理</a>
                    <ul id="list">
                       <li><a href='${pageContext.request.contextPath}/back_end/emp/AllEmployee.jsp'>員工資料</a></li>
                       <li><a href='${pageContext.request.contextPath}/back_end/emp/Employee_Authority.jsp'>員工權限</a></li>
                    </ul>
                </li>
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/social-group.png"><a href="#">會員管理</a> --%>
<!--                     <ul id="list"> -->
<%--                         <li><a href='${pageContext.request.contextPath}/back_end/member/AllMember.jsp'>會員資料</a></li> --%>
<!--                         <li><a href=''>會員通知管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a> --%>
                
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>媒體報導管理</a></li> -->
<!--                         <li><a href=''>最新消息管理</a></li> -->
<!--                     </ul>                 -->
<!--                 </li> -->
               
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/bed.png"><a href="#">房務管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>住宿訂單管理</a></li> -->
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
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/gift.png"><a href="#">伴手禮管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>查詢全部訂單</a></li> -->
<!--                         <li><a href=''>新增商品訂單</a></li> -->
<!--                         <li><a href=''>商品類別管理</a></li> -->
<!--                         <li><a href=''>商品管理</a></li> -->
<!--                         <li><a href=''>商品圖片管理</a></li> -->
<!--                     </ul> -->
                
<!--                 </li> -->
                
            </ul>
        </nav>
    </aside>
    <main>

<div class="background">
<p class="p1">員工權限查詢</p>

	<c:if test="${not empty errorMsgs}">
	<div class="error">	
	<font style="color:red"></font>

			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>		
	</div>
	</c:if>

<a class="allemp" style="cursor:pointer;" href="${pageContext.request.contextPath}/back_end/emp/AllEmployee.jsp">點此查詢所有</a>

<ul>
  
  <li>
    <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Employee_Servlet" >
        <b class="emp_no">輸入員工編號:</b>
        <input type="text" name="emp_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出" class="submit1" style="cursor:pointer;">
    </FORM>
 </li>


<jsp:useBean id="empSvc" scope="page" class="com.employee.model.EmployeeService" />
   
	<li class="select_emp_no">
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Employee_Servlet" >
       <b class="emp_no2">選擇員工編號:</b>
       <select size="1" name="emp_no" style="font-size:20px;">
         <c:forEach var="employeeVO" items="${empSvc.all}" >
          <option style="font-size:20px;" value="${employeeVO.emp_no}">${employeeVO.emp_no}
         </c:forEach>  
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="查詢" class="submit2" style="cursor:pointer;">
    </FORM>
	</li>
  
  
   <li class="select_emp_name">
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Employee_Servlet" >
       <b class="p4">選擇員工姓名:</b>
       <select size="1" name="emp_no" style="font-size:20px;">
         <c:forEach var="employeeVO" items="${empSvc.all}" > 
          <option style="font-size:20px;" value="${employeeVO.emp_no}">${employeeVO.emp_name}
         </c:forEach>
       </select>
        <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="查詢" class="submit3" style="cursor:pointer;">
       </FORM>
     </li>  
     
     
      <jsp:useBean id="JobSvc" scope="page" class="com.job.model.JobService" />
   
    <li class="select_job_name">
	 <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/Job_Servlet">
	 
	   <b class="p5">選擇職位名稱：</b>
	   <select size="1" name="job_id" style="font-size:20px;">
	   <c:forEach var="JobVO" items="${JobSvc.all }">
	   		<option style="font-size:20px;" value="${JobVO.job_id }">${JobVO.job_name}
	   		<option value="${Authority_FunctionVO.function_id }">${Authority_FunctionVO.function_name }
	   </c:forEach>
	   </select>
	   
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="查詢" class="submit4" style="cursor:pointer;">
	 	
     </FORM>
     </li>
     
<%--       <jsp:useBean id="authority_functionSvc" scope="page" class="com.authority_function.model.Authority_FunctionService" /> --%>
<!--     <li> -->
<%-- 	 <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/Authority_function_Servlet"> --%>
	 
<!-- 	   <b class="p6">請選擇權限功能名稱：</b> -->
<!-- 	   <select size="1" name="function_id"> -->
<%-- 	   <c:forEach var="Authority_FunctionVO" items="${authority_functionSvc.all }"> --%>
<%-- 	   		<option value="${Authority_FunctionVO.function_id }">${Authority_FunctionVO.function_name } --%>
<%-- 	   </c:forEach> --%>
<!-- 	   </select> -->
	   
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="查詢"> -->
<!-- 	   </FORM> -->
<!--      </li>	 -->
     
<%--       <jsp:useBean id="job_authoritySvc" scope="page" class="com.job_authority.model.Job_AuthorityService" /> --%>
<!--      <li> -->
<%-- 	 <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/Job_Authority_Servlet"> --%>
	 
<!-- 	   <b class="p7">請選擇職位編號：</b> -->
<!-- 	   <select size="1" name="job_id"> -->
<%-- 	   <c:forEach var="Job_AuthorityVO" items="${job_authoritySvc.all }"> --%>
<%-- 	   		<option value="${Job_AuthorityVO.job_id }">${Job_AuthorityVO.function_id} --%>
<%-- 	   </c:forEach> --%>
<!-- 	   </select> -->
	   
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="查詢"> -->
<!--        	   </FORM> -->
<!--      </li>	 -->

</ul>
</div>
    </main>
</body>

</html>