<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.employee.model.*"%>
<%@ page import="com.job.model.*"%>
<%@ page import="com.job_authority.model.*" %>

<!DOCTYPE html>

<html lang="en">


<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backend.css">

    <title>飯店管理後台頁面</title>

  <jsp:useBean id="JobSvc" scope="page" class="com.job.model.JobService" />
  <jsp:useBean id="empSvc" scope="page" class="com.employee.model.EmployeeService" />
  
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
                <c:when test="${employeeVO.job_id == 1002 }">
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
                
<%--                 <c:choose> --%>
<%--                 <c:when test="${employeeVO.job_id == 1002 || employeeVO.job_id == 1001}"> --%>
<!--                 <li>  -->
<%--                     <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a> --%>
                
<!--                     <ul id="list"> -->
<%--                         <li><a href='${pageContext.request.contextPath}/back_end/newspost/select_page_news.jsp'>媒體報導管理</a></li> --%>
<%--                         <li><a href='${pageContext.request.contextPath}/back_end/news/NewsBackselectAll.jsp'>最新消息管理</a></li> --%>
<!--                     </ul>                 -->
<!--                 </li> -->
<%--                 </c:when> --%>
<%--                 </c:choose> --%>
                
                <c:choose>
                <c:when test="${employeeVO.job_id != 1002}">	                   
                </c:when>
                </c:choose>              
           
                <c:choose>
                <c:when test="${employeeVO.job_id == 1003}">    
                <li> 
                    <img src="${pageContext.request.contextPath}/images/bed.png"><a href="#">房務管理</a>
                    <ul id="list">
                        <li><a href="${pageContext.request.contextPath}/back_end/room_order/select_room_order_page.jsp">住宿訂單管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_order_list/listAllRoom_Order_List.jsp">訂單明細管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_type/select_page.jsp">房型管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room/select_room_page.jsp">房間管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/back_end/room_type_photo/select_room_type_photo_page.jsp">房型圖片管理</a></li>
                    </ul>
                </li>
                
                </c:when>
                </c:choose>    
                
               <c:choose>
               <c:when test="${employeeVO.job_id != 1003}">         	
         	   </c:when>
               </c:choose>    										              
               
                <c:choose>
                <c:when test="${employeeVO.job_id == 1004 }"> 
                <li> 
                    <img src="${pageContext.request.contextPath}/images/camping.png"><a href="#">活動管理</a>
                    <ul id="list">
                        <li><a
                                    href='<%=request.getContextPath()%>/back_end/activity_category/listAllActivityCategory.jsp'>活動類別管理</a>
                            </li>
                            <li><a href='<%=request.getContextPath()%>/back_end/activity/listAllActivity.jsp'>活動項目管理</a>
                            </li>
                            <li><a
                                    href='<%=request.getContextPath()%>/back_end/activity_session/listAllActivitySession.jsp'>活動場次管理</a>
                            </li>
                            <li><a
                                    href='${pageContext.request.contextPath}/back_end/activity_photo/listAllActivityPhoto.jsp'>活動圖片管理</a>
                            </li>
                            <li><a
                                    href='<%=request.getContextPath()%>/back_end/activity_order/listAllActivityOrder.jsp'>活動訂單管理</a>
                            </li>
                    </ul>
                </li>
               	</c:when>
                </c:choose>  
                
               <c:choose>
               <c:when test="${employeeVO.job_id != 1004}">
               </c:when>
               </c:choose> 
               
                <c:choose>
                <c:when test="${employeeVO.job_id == 1005 }"> 
                <li>
                    <img src="${pageContext.request.contextPath}/images/gift.png"><a href="#">伴手禮管理</a>
                    <ul id="list">
                        <li><a href='<%=request.getContextPath() %>/back_end/product_order_detail/homepage.jsp'>查詢全部訂單</a></li> 
                        <li><a href="<%=request.getContextPath() %>/back_end/product_category/Select_page.jsp">商品類別管理</a></li>
                        <li><a href="<%=request.getContextPath() %>/back_end/product/Select_page.jsp">商品管理</a></li>
                        <li><a href="<%=request.getContextPath() %>/back_end/product_pics/Select_page.jsp">商品圖片管理</a></li>
                    </ul>                
                </li>
                </c:when>
               	</c:choose> 
                
               
               <c:choose>
                <c:when test="${employeeVO.job_id == 1006 }"> 
                <li>
                    <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a>
                   <ul id="list">
                        <li><a href='${pageContext.request.contextPath}/back_end/newspost/select_page_news.jsp'>媒體報導管理</a></li>
                        <li><a href='${pageContext.request.contextPath}/back_end/news/NewsBackselectAll.jsp'>最新消息管理</a></li>
                        
                    </ul>               
                </li>
                </c:when>
               	</c:choose> 
                
               
                
            </ul>
        </nav>
    </aside>
    
    <tr>
      <c:forEach var="autoVO" items="${list}" >
    <td>${autoVO.job_id}</td>
    <td>${autoVO.function_id}</td>
    </c:forEach>
   </tr>
</body>

</html>