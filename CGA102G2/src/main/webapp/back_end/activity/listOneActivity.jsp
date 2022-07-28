<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.activity.model.*" %>    

<%
	//ActivityCategoryServlet.java(Concroller), 存入req的activityVO物件
	ActivityVO activityVO = (ActivityVO) request.getAttribute("activityVO");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>飯店管理後台頁面-活動管理-活動項目管理</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/staff_activity_page.css">
	<link rel="stylesheet"
 		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
</head>

<body>
    <header class="header">
        <nav class="nav">

            <div class="logo">

                <a href="" class="logo_a">
                    <img src="${pageContext.request.contextPath}/images/common/logo.png" alt="" id="logo">
                </a>

                <a class="nav-top-a" href="">
                    <img class="nav-top-chat" src="${pageContext.request.contextPath}/images/common/chat.png" alt="">
                </a>

                <a href="${pageContext.request.contextPath}/LogoutEmp" class="nav-top-sighout">${jobVO.job_name}/登出</a>
            </div>
            <div class="line"></div>

        </nav>
    </header>

    <!-- ------------------------------------ main_content ------------------------------------ -->

    <div class="main_content">
        <!-- ------------------------------- aside ------------------------------- -->
        <aside class="aside">
            <nav class="nav">
                <div>
                    <img src="${pageContext.request.contextPath}/images/common/group.png">
                    <p>${employeeVO.emp_name}</p>
                    <hr style="background-color:#757575 ;height:2px;">
                </div>
                <ul class="nav_list">

<!--                     <li> -->
<%--                         <img src="${pageContext.request.contextPath}/images/common/group (1).png"> --%>
<!--                         <a href="#">員工管理</a> -->
<!--                         <ul id="list"> -->
<!--                             <li><a href=''>員工資料</a></li> -->
<!--                             <li><a href=''>員工權限</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<%--                         <img src="${pageContext.request.contextPath}/images/common/social-group.png"> --%>
<!--                         <a href="#">會員管理</a> -->
<!--                         <ul id="list"> -->
<!--                             <li><a href=''>會員資料</a></li> -->
<!--                             <li><a href=''>會員通知管理</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<%--                         <img src="${pageContext.request.contextPath}/images/common/talking.png"> --%>
<!--                         <a href="#">消息管理</a> -->

<!--                         <ul id="list"> -->
<!--                             <li><a href=''>媒體報導管理</a></li> -->
<!--                             <li><a href=''>最新消息管理</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<%--                         <img src="${pageContext.request.contextPath}/images/common/bed.png"> --%>
<!--                         <a href="#">房務管理</a> -->
<!--                         <ul id="list"> -->
<!--                             <li><a href=''>住宿訂單管理</a></li> -->
<!--                             <li><a href=''>訂單明細管理</a></li> -->
<!--                             <li><a href=''>房型管理</a></li> -->
<!--                             <li><a href=''>房間管理</a></li> -->
<!--                             <li><a href=''>房型圖片管理</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

                    <li>
                        <img src="${pageContext.request.contextPath}/images/common/camping.png">
                        <a href="#">活動管理</a>
                        <ul id="list">
                            <li><a
                                    href='${pageContext.request.contextPath}/back_end/activity_category/listAllActivityCategory.jsp'>活動類別管理</a>
                            </li>
                            <li><a href='${pageContext.request.contextPath}/back_end/activity/listAllActivity.jsp'>活動項目管理</a>
                            </li>
                            <li><a
                                    href='${pageContext.request.contextPath}/back_end/activity_session/listAllActivitySession.jsp'>活動場次管理</a>
                            </li>
                            <li><a
                                    href='${pageContext.request.contextPath}/back_end/activity_photo/listAllActivityPhoto.jsp'>活動圖片管理</a>
                            </li>
                            <li><a
                                    href='${pageContext.request.contextPath}/back_end/activity_order/listAllActivityOrder.jsp'>活動訂單管理</a>
                            </li>
                        </ul>
                    </li>

<!--                     <li> -->
<%--                         <img src="${pageContext.request.contextPath}/images/common/gift.png"> --%>
<!--                         <a href="#">伴手禮管理</a> -->
<!--                         <ul id="list"> -->
<!--                             <li><a href=''>查詢全部訂單</a></li> -->
<!--                             <li><a href=''>新增商品訂單</a></li> -->
<!--                             <li><a href=''>商品類別管理</a></li> -->
<!--                             <li><a href=''>商品管理</a></li> -->
<!--                             <li><a href=''>商品圖片管理</a></li> -->
<!--                         </ul> -->

<!--                     </li> -->

                </ul>
            </nav>
        </aside>

        <!-- ------------------------------- main ------------------------------- -->
        <main class="main">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <h4 class="h4">活動項目管理-單一活動項目資料</h4>
                    </div>
                </div>
                <div class="row justify-content-end">
                	<div class="col-md-auto">
                        <a href="${pageContext.request.contextPath}/back_end/activity/selectPage.jsp">
                            <button type="button" class="btn btn-success"><i class="fa-solid fa-magnifying-glass"></i>活動項目查詢</button>
                        </a>
                    </div>
                    <div class="col-md-auto">
                        <a href="${pageContext.request.contextPath}/back_end/activity/listAllActivity.jsp">
                            <button type="button" class="btn btn-info"><i class="fa-solid fa-circle-left"></i>回到活動項目列表</button>
                        </a>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <table class="table table-striped table-hover ">
                            <thead class="thead thead-dark">
                                <tr>
                                    <th scope="col">編號</th>
                                    <th scope="col">類別</th>
                                    <th scope="col">名稱</th>
                                    <th scope="col">價格</th>
                                    <th scope="col">開始日期</th>
                                    <th scope="col">結束日期</th>
                                    <th scope="col">描述</th>
                                    <th scope="col">內容</th>
                                    <th scope="col">資訊</th>
                                    <th scope="col">狀態</th>
                                    <th scope="col">編輯</th>
                                </tr>
                            </thead>
                            <tbody class="">
                                <tr class="text-center" ${(activityVO.activity_ID == param.activity_ID) ? 'bgcolor=#CCCCFF':''}>
                                    <td>${activityVO.activity_ID}</td>
									<td>${activityVO.activityCategoryVO.activity_category_name}</td>
									<td>${activityVO.activity_name}</td>
									<td>${activityVO.activity_price}</td>
									<td><fmt:formatDate type="date" value="${activityVO.activity_start}" /></td>
									<td><fmt:formatDate type="date" value="${activityVO.activity_end}" /></td> 
									<td>${activityVO.activity_description}</td> 
									<td>${activityVO.activity_content}</td> 
									<td>${activityVO.activity_info}</td> 
									<td>${(activityVO.activity_state == 0)?'下架':'上架'}</td>
                                    <td>
                                        <div class="editgroup">
                                            <form method="post" action="${pageContext.request.contextPath}/activity/ActivityServlet.do">
<!--                                                 <input class="btn btn-primary" type="submit" value="修改"> -->
                                                <button class="btn btn-primary" type="submit" value="修改"><i class="fa-regular fa-pen-to-square"></i></button>
                                                <input type="hidden" name="activity_ID"  value="${activityVO.activity_ID}">
                                                <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    								<input type="hidden" name="action"	value="getOneForUpdate">
                                            </form>

                                            <form method="post" action="${pageContext.request.contextPath}/activity/ActivityServlet.do">
<!--                                                 <input class="btn btn-danger" type="submit" value="刪除"> -->
                                                <button class="btn btn-danger" type="submit" value="刪除"><i class="fa-regular fa-trash-can"></i></button>
                                                <input type="hidden" name="activity_ID"  value="${activityVO.activity_ID}">
                                                <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     								<input type="hidden" name="action" value="delete">
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </main>

    </div>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
</body>

</html>