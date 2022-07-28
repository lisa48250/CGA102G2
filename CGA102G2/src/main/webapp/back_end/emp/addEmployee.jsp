<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.employee.model.*"%>

<!DOCTYPE html>

<%
  EmployeeVO employeeVO = (EmployeeVO) request.getAttribute("employeeVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>



<html lang="en">

<style>

.div-bottom{
            border-radius: 3%;
            margin-top: 60px;
            margin-left: 130px;
            background-color: rgb(173, 172, 172);
            width: 500px;
            height: 480px;
        }

 .background{
            position: relative;
            border-radius: 1%;
            top: -280px;
		    height: 800px;
		    width: 600px;
		    margin-left: 380px;
		    background-color:#b0adad
        }
  .employee_no{
            position: relative;
           
            text-align: center;
            top:30px;
            font-size: 20px;  

        }
        .input1 {
			background-color: white;
            width: 260px;
            padding: 3px 3px 3px 3px;
			border-radius: .45rem;
			border-color: transparent;
			position: relative;
			top: 65px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 115px;
			color: #3B413B;
			text-align: center;
		}

        .input2 input {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 85px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 115px;
			color: #3B413B;
			text-align: center;
		}

        .input3 {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 105px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 115px;
			color: #3B413B;
			text-align: center;
		}

        .input4 input {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 125px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 115px;
			color: #3B413B;
			text-align: center;
		}

        .input5 input {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 145px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 115px;
			color: #3B413B;
			text-align: center;
		}

        .confirm1{
 		    border-radius: 45px; 
	    	position: relative;
	    	color: white;
            margin-left: 190px;
            margin-top: 170px;
        }
        .p1{
        	position: relative;
        	
        	margin-top: 65px;
        	top:50px;
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
    
    <c:if test="${not empty errorMsgs}">
<div class="error">	
<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</div>
</c:if>

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

  <jsp:useBean id="JobSvc" scope="page" class="com.job.model.JobService" />
    <jsp:useBean id="empSvc" scope="page" class="com.employee.model.EmployeeService" />
        
 <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Employee_Servlet" enctype="multipart">       


	<div class="div-bottom">
	  
     <div class="input1">
           <b class="p1"></b>
	   <select size="1" name="job_id"  style="width:250px; height:35px; text-align:center; text-align-last:center; font-size:22px; ">
	   <c:forEach var="JobVO" items="${JobSvc.all }">
	   		<option value="${JobVO.job_id }">${JobVO.job_name }
	   </c:forEach>
	   </select>
    </div>
	
	<div class="input2">
	<input type="text" name="emp_name" placeholder="請輸入員工姓名" 
	value="<%= (employeeVO==null)? "" : employeeVO.getEmp_name()%>" required>
	</div>
	
    <div class="input3">
	    <b class="p3"></b>
	   <select size="1" name="emp_status" style="width:250px; height:35px; text-align:center; text-align-last:center; font-size:22px; ">

			<option value="0">離職

			<option value="1">在職	
	   </select>
    </div>

	<div class="input4">
	<input type="text" name="emp_account" placeholder="請設定員工帳號" 
	value="<%= (employeeVO==null)? "" : employeeVO.getEmp_account()%>" required>
	</div>
	
	<div class="input5">
	<input type="text" name="emp_password" placeholder="請設定員工密碼" 
	value="<%= (employeeVO==null)? "" : employeeVO.getEmp_password()%>" required>
	</div>

<div class="confirm1">
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</div>
</body>  
        
    </main>
</body>

</html>

