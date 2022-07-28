<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.members.model.*"%>

<!DOCTYPE html>

<%
    MemberService memberSvc = new MemberService();
    List<MemberVO> list = memberSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<html lang="en">

<style>
.title1{
		background-color: #AAA8AB;
		font-size: 22px;
		}
		
.memberpic{
		width: 100px;
    	height: 100px;
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
                
                <c:choose>
                <c:when test="${employeeVO.job_id == 1001}">	<!-- 如果等於1001 則顯示員工管理 -->
        
                <li>
                    <img src="${pageContext.request.contextPath}/images/group (1).png"><a href="#">員工管理</a>
                    <ul id="list">
                        <li><a href='${pageContext.request.contextPath}/back_end/emp/AllEmployee.jsp'>員工資料</a></li>
                        <li><a href='${pageContext.request.contextPath}/back_end/emp/Employee_Authority.jsp'>員工權限</a></li>
                    </ul>
                </li>
                </c:when>
                </c:choose>

                <c:choose>
                <c:when test="${employeeVO.job_id != 1001}">   <!-- 如果不等於1001 則顯示空 -->                
                </c:when>
                </c:choose>
                
                
                <c:choose>
                <c:when test="${employeeVO.job_id == 1002 || employeeVO.job_id == 1001}">
                <li>
                    <img src="${pageContext.request.contextPath}/images/social-group.png"><a href="#">會員管理</a>
                    <ul id="list">
                        <li><a href='${pageContext.request.contextPath}/back_end/member/AllMember.jsp'>會員資料</a></li>
                       
                    </ul>
                </li>
                </c:when>
                </c:choose>
                
                <c:choose>
                <c:when test="${employeeVO.job_id != 1002}">                   
                </c:when>
                </c:choose>   
                
                <c:choose>
                <c:when test="${employeeVO.job_id == 1006 || employeeVO.job_id == 1001}">
                <li> 
                    <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a>
                
                    <ul id="list">
                        <li><a href=''>媒體報導管理</a></li>
                        <li><a href=''>最新消息管理</a></li>
                    </ul>                
                </li>
                </c:when>
                </c:choose>
                
                <c:choose>
                <c:when test="${employeeVO.job_id != 1002}">	                   
                </c:when>
                </c:choose>
               
           
                <c:choose>
                <c:when test="${employeeVO.job_id == 1003  || employeeVO.job_id == 1001}">    
                <li> 
                    <img src="${pageContext.request.contextPath}/images/bed.png"><a href="#">房務管理</a>
                    <ul id="list">
                        <li><a href=''>住宿訂單管理</a></li>
                        <li><a href=''>訂單明細管理</a></li>
                        <li><a href=''>房型管理</a></li>
                        <li><a href=''>房間管理</a></li>
                        <li><a href=''>房型圖片管理</a></li>
                    </ul>
                </li>
                
                </c:when>
                </c:choose>   
                
                
               <c:choose>
               <c:when test="${employeeVO.job_id != 1003}">         	
         	   </c:when>
               </c:choose>   
 										              
               
                <c:choose>
                <c:when test="${employeeVO.job_id == 1004  || employeeVO.job_id == 1001}"> 
                <li> 
                    <img src="${pageContext.request.contextPath}/images/camping.png"><a href="#">活動管理</a>
                    <ul id="list">
                        <li><a href=''>活動類別管理</a></li>
                        <li><a href=''>活動項目管理</a></li>
                        <li><a href=''>活動場次管理</a></li>
                        <li><a href=''>活動訂單管理</a></li>
                    </ul>
                </li>
               	</c:when>
                </c:choose>  
                
               <c:choose>
               <c:when test="${employeeVO.job_id != 1004}">
               </c:when>
               </c:choose> 
               
                <c:choose>
                <c:when test="${employeeVO.job_id == 1005  || employeeVO.job_id == 1001}"> 
                <li>
                    <img src="${pageContext.request.contextPath}/images/gift.png"><a href="#">伴手禮管理</a>
                    <ul id="list">
                        <li><a href=''>查詢全部訂單</a></li>
                        <li><a href=''>新增商品訂單</a></li>
                        <li><a href=''>商品類別管理</a></li>
                        <li><a href=''>商品管理</a></li>
                        <li><a href=''>商品圖片管理</a></li>
                    </ul>                
                </li>
                </c:when>
               	</c:choose> 
                
               <c:choose>
               <c:when test="${employeeVO.job_id != 1005}">               
               </c:when>
               </c:choose> 
                
            </ul>
        </nav>
    </aside>
    <main>
    
        <table style="width:920px;">

    <tr class="title1">
       <th class="member_id">會員編號</th>
        <th class="member_email">會員信箱</th>
        <th class="member_password">會員密碼</th>
        <th class="member_name">會員姓名</th>
        <th class="member_phone">會員電話</th>
        <th class="member_address">會員地址</th>
        <th class="member_pic">會員照片</th>
<!--         <th class="menber_status">會員狀態</th> -->
<!--         <th class="update">修改</th> -->
        <th class="delete">刪除</th>
    </tr>
    
        <c:forEach var="memberVO" items="${list}" >
    <tr>
			<td>${memberVO.member_id}</td>
			<td>${memberVO.member_email}</td>
			<td>${memberVO.member_password}</td>
			<td>${memberVO.member_name}</td>
			<td>${memberVO.member_phone}</td>
			<td>${memberVO.member_address}</td>
			<td><img class="memberpic" src="${pageContext.request.contextPath}/Member_reader?member_id=${memberVO.member_id}" alt=""></td>
<%-- 			<td>${memberVO.member_status}</td> --%>
			
<!--      <td> -->
<%--         <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Member_Servlet" style="margin-bottom: 0px;"> --%>
<!--         <input type="submit" value="修改" style="cursor:pointer;"> -->
<%--         <input type="hidden" name="member_id"  value="${memberVO.member_id}"> --%>
<!--         <input type="hidden" name="action"	value="getOne_For_Update"></FORM> -->
<!--      </td> -->
        
        <td>
        <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Member_Servlet" style="margin-bottom: 0px;">
        <input type="submit" value="刪除" style="cursor:pointer;">
        <input type="hidden" name="member_id"  value="${memberVO.member_id}">
		<input type="hidden" name="action" value="delete" ></FORM>
        </td>
    </tr>
    </c:forEach>
</table>
    </main>
</body>

</html>