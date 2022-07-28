<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity.model.*" %>
<%@ page import="com.activity_join.model.*" %>
<%@ page import="com.activity_session.model.*" %>

<%
	ActivityJoinVO activityJoinVO = (ActivityJoinVO) request.getAttribute("activityJoinVO");

	ActivitySessionService activitySessionService = new ActivitySessionService();
	List<ActivitySessionVO> list = activitySessionService.getActivitySessionsWhereStateIsOne();
	pageContext.setAttribute("list",list);
	
	ActivityService activityService = new ActivityService();
	List<ActivityVO> list2 = activityService.getActivitiesWhereStateIsOne();
	pageContext.setAttribute("list2",list2);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>飯店管理後台頁面-活動管理-活動訂單管理</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/staff_activity_page.css">
    <link rel="stylesheet"
 		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
    <script src="https://cdn.ckeditor.com/4.7.3/standard-all/ckeditor.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
    <style>
	  .xdsoft_datetimepicker .xdsoft_datepicker {
	           width:  300px;   /* width:  300px; */
	  }
	  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	           height: 151px;   /* height:  151px; */
	  }
	</style>
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
                        <h4 class="h4">活動訂單管理-新增活動訂單</h4>
                    </div>
                </div>
                <div class="row justify-content-end">
                    <div class="col-md-auto">
                        <a href="${pageContext.request.contextPath}/back_end/activity_order/listAllActivityOrder.jsp">
                            <button type="button" class="btn btn-info"><i class="fa-solid fa-circle-left"></i>回到活動訂單列表</button>
                        </a>
                    </div>
                </div>

                <%-- 錯誤表列 --%>
<%-- 				<c:if test="${not empty errorMsgs}"> --%>
<!-- 					<font style="color:red">請修正以下錯誤:</font> -->
<!-- 					<ul> -->
<%-- 						<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 							<li style="color:red">${message}</li> --%>
<%-- 						</c:forEach> --%>
<!-- 					</ul> -->
<%-- 				</c:if> --%>
				
                <div class="addblock border border-light bg-light rounded">                

                    <form method="post"
                        action="${pageContext.request.contextPath}/activityJoin/activityJoin.do" name="form1" onsubmit="this.orderState.disabled=false" onsubmit="this.refundState.disabled=false">
                        
                        <jsp:useBean id="memberService" scope="page" class="com.members.model.MemberService" />
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectMember">會員編號：</label>
                                    <select size="1" name="member_id" class="form-control" id="selectMember">
										<c:forEach var="memberVO" items="${memberService.all}">
											<option value="${memberVO.member_id}">${memberVO.member_id} - [${memberVO.member_name}]
										</c:forEach>
									</select>
                                </div>
                            </div>
                        </div>                        
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectActivitySession">活動場次：</label>
                                    <select size="1" name="activitySessionID" class="form-control" id="selectActivitySession">
										<c:forEach var="activitySessionVO" items="${list}">
											<option value="${activitySessionVO.activity_session_ID}" data-act-id="${activitySessionVO.activityVO.activity_ID}"> 
											${activitySessionVO.activity_session_ID} - [${activitySessionVO.activityVO.activity_name}] - [<fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${activitySessionVO.activity_session_start}"/>] - [<fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${activitySessionVO.activity_session_end}"/>]
											</option>
										</c:forEach>
									</select>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="insertEnrollNumber">報名人數：</label><div><font color=red>${errorMsgs.enrollNumber}</font></div>
                                    <input type="number" class="form-control" id="insertEnrollNumber"
                                        placeholder="請輸入報名人數" name="enrollNumber" 
                                        value="${param.enrollNumber == null ? 0 : param.enrollNumber}">                                    
                                </div>
                            </div>
                        </div>

						<div class="row justify-content-center">
                            <div class="col-6 border border-info">
                                <div class="form-group form">
                                	
                                	<table class="table table-sm table-hover">
									  <thead>
									    <tr class="text-center">
									      <th scope="col">活動編號</th>
									      <th scope="col">活動名稱</th>
									      <th scope="col">價格</th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach var="activityVO" items="${list2}">
									    <tr class="text-center">
									      <td>${activityVO.activity_ID}</td>
									      <td>${activityVO.activity_name}</td>
									      <td>${activityVO.activity_price}</td>
									    </tr>									    
									    </c:forEach>
									  </tbody>
									</table>
									
                                </div>
                            </div>
                        </div>   
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="insertOrderAmount">訂單總額：</label><div><font color=red>${errorMsgs.orderAmount}</font></div>
                                    <input type="number" class="form-control" id="insertOrderAmount"
                                        placeholder="請輸入訂單總額" name="orderAmount" 
                                        value="${param.orderAmount == null ? 0 : param.orderAmount}">                                   
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="inputOrderMemo">備註：</label><div><font color=red>${errorMsgs.orderMemo}</font></div>
                                    <textarea name="editor1" class="form-control" id="inputOrderMemo">${param.orderMemo}</textarea>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectOrderState">訂單狀態：</label>
                                	<select size="1" name="orderState" class="form-control" id="selectOrderState" disabled>
										<option value="0" selected>已繳費</option>
										<option value="1">完成訂單</option>
										<option value="2">取消訂單</option>
									</select>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectRefundState">退款狀態：</label>
                                	<select size="1" name="refundState" class="form-control" id="selectRefundState" disabled>
										<option value="0" selected>無須退款</option>
										<option value="1">尚未退款</option>
										<option value="2">完成退款</option>
									</select>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <div class="form-group form-inline">
                                    <input type="hidden" name="action" value="staff_insert">
                                    <button type="submit" class="btn btn-dark" value="送出新增"><i class="fa-solid fa-square-check"></i>送出新增</button>
                                </div>
                            </div>
                        </div>
                    </form>

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
	<script>CKEDITOR.replace("editor1");</script>  
	<script>
	
		var mapTable = {}
		<%
			for(ActivityVO activityVO: list2) {
		%>
				mapTable[<%=activityVO.getActivity_ID()%>] = <%=activityVO.getActivity_price() %>
		<%
			}
		%>
// 		console.log(mapTable);
		
		$('#selectActivitySession').on('change', function(){
			var act_id = $('#selectActivitySession option:selected').attr('data-act-id');
			var enroll_no = $('#insertEnrollNumber').val();
			var price = mapTable[act_id];
			$('#insertOrderAmount').val(price * enroll_no);
		});
		$('#insertEnrollNumber').on('keyup', function(){
			var act_id = $('#selectActivitySession option:selected').attr('data-act-id');
			var enroll_no = $('#insertEnrollNumber').val();
			var price = mapTable[act_id];
			$('#insertOrderAmount').val(price * enroll_no);
		});
		$('#insertEnrollNumber').on('change', function(){
			var act_id = $('#selectActivitySession option:selected').attr('data-act-id');
			var enroll_no = $('#insertEnrollNumber').val();
			var price = mapTable[act_id];
			$('#insertOrderAmount').val(price * enroll_no);
		});
		
	</script>  
</body>

</html>