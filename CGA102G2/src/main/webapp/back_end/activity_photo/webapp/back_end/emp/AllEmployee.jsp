<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.employee.model.*"%>
<%@ page import="com.job.model.*"%>

<!DOCTYPE html>

<%
    EmployeeService empSvc = new EmployeeService();
    List<EmployeeVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>
<%
    JobService jobSvc = new JobService();
	pageContext.setAttribute("jobSvc",jobSvc);
    
%>

<%
JobVO jobVO = (JobVO) request.getAttribute("jobVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html lang="en">

<style>

.title1{
		background-color: #AAA8AB;
		font-size: 22px;
		
		}

.change{
	border-radius: 10px;
    border: 1px;
    background-color: #AAA8AB;
   	font-size: 20px;
    padding: 8px 10px 8px 10px;
    color: #ffffff;
    position: relative;
/*  top: 25px; */
    text-align: center;
/*  right: -20px; */
/*  margin-right: 50px; */
    text-decoration: none;

		}

.delete{
	border-radius: 10px;
    border: 1px;
    background-color: #AAA8AB;
    font-size: 20px;
    padding: 8px 10px 8px 10px;
    color: #ffffff;
    position: relative;
/*  top: 25px; */
    text-align: center;
/*  right: -20px; */
/*  margin-right: 50px; */
    text-decoration: none;

		}

.add{
    border-radius: 10px;
    border: 1px;
    background-color: #AAA8AB;
    font-size: 20px;
    padding: 10px 22px 10px 22px;
    color: #ffffff;
    position: relative;
    top: 25px;
    text-align: center;
    right: -20px;
    margin-right: 50px;
    text-decoration: none;
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
    
        <table style="width:920px;" class="back1"  cellspacing="0" cellpadding="0">
        
    <tr class="title1">
        <th class="emp_no">員工編號</th>
        <th class="job_id">職位權限</th>
        <th class="emp_name">員工姓名</th>
        <th class="emp_status">在職狀態</th>
        <th class="emp_account">員工帳號</th>
        <th class="emp_password">員工密碼</th>
        <th class="update">修改</th>
        <th class="delete2">刪除</th>
    </tr>
     <c:forEach var="employeeVO" items="${list}" >
    <tr>
      		<td>${employeeVO.emp_no}</td>
			<c:if test="${employeeVO.job_id == 1001}">
				<td>員工管理</td>
			</c:if>
			<c:if test="${employeeVO.job_id == 1002}">
				<td>會員管理</td>
				
			</c:if>
			<c:if test="${employeeVO.job_id == 1005}">
				<td>商品管理</td>
				
			</c:if>
			<c:if test="${employeeVO.job_id == 1004}">
				<td>活動管理</td>
				
			</c:if>
			<c:if test="${employeeVO.job_id == 1003}">
				<td>訂房管理</td>		
			</c:if>
			
			
			<c:if test="${employeeVO.job_id == 1006}">
				<td>消息管理</td>		
			</c:if>
			
			<td>${employeeVO.emp_name}</td>
	
			<c:if test="${employeeVO.emp_status == 0}">
			<td>離職</td>
			</c:if>
			
			<c:if test="${employeeVO.emp_status == 1}">
			<td>在職</td>
			</c:if>
				
			<td>${employeeVO.emp_account}</td>
			<td>${employeeVO.emp_password}</td>
			
     <td>
        <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Employee_Servlet" style="margin-bottom: 0px;">
        <input class="change" style="cursor:pointer;" type="submit" value="修改">
        <input type="hidden" name="emp_no"  value="${employeeVO.emp_no}">
        <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
     </td>
        
	<td>
        <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Employee_Servlet" style="margin-bottom: 0px;">
        <input class="delete" style="cursor:pointer;" type="submit" value="刪除">
        <input type="hidden" name="emp_no"  value="${employeeVO.emp_no}">
		<input type="hidden" name="action" value="delete"></FORM>
     </td>
     
    </tr>
    </c:forEach>
     

        <a class="add" href="${pageContext.request.contextPath}/back_end/emp/addEmployee.jsp">新增員工</a>

    
</table>
    </main>
</body>

</html>