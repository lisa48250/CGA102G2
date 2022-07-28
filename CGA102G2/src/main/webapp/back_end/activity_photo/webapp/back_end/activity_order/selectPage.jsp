<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>飯店管理後台頁面-活動管理-活動訂單管理</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/staff_activity_page.css">
	<link rel="stylesheet"
 		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
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
                    <img src="<%=request.getContextPath()%>/images/common/logo.png" alt="" id="logo">
                </a>

                <a class="nav-top-a" href="">
                    <img class="nav-top-chat" src="<%=request.getContextPath()%>/images/common/chat.png" alt="">
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
                    <img src="<%=request.getContextPath()%>/images/common/group.png">
                    <p>${employeeVO.emp_name}</p>
                    <hr style="background-color:#757575 ;height:2px;">
                </div>
                <ul class="nav_list">

<!--                     <li> -->
<%--                         <img src="<%=request.getContextPath()%>/images/common/group (1).png"> --%>
<!--                         <a href="#">員工管理</a> -->
<!--                         <ul id="list"> -->
<!--                             <li><a href=''>員工資料</a></li> -->
<!--                             <li><a href=''>員工權限</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<%--                         <img src="<%=request.getContextPath()%>/images/common/social-group.png"> --%>
<!--                         <a href="#">會員管理</a> -->
<!--                         <ul id="list"> -->
<!--                             <li><a href=''>會員資料</a></li> -->
<!--                             <li><a href=''>會員通知管理</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<%--                         <img src="<%=request.getContextPath()%>/images/common/talking.png"> --%>
<!--                         <a href="#">消息管理</a> -->

<!--                         <ul id="list"> -->
<!--                             <li><a href=''>媒體報導管理</a></li> -->
<!--                             <li><a href=''>最新消息管理</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->

<!--                     <li> -->
<%--                         <img src="<%=request.getContextPath()%>/images/common/bed.png"> --%>
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
                        <img src="<%=request.getContextPath()%>/images/common/camping.png">
                        <a href="#">活動管理</a>
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

<!--                     <li> -->
<%--                         <img src="<%=request.getContextPath()%>/images/common/gift.png"> --%>
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
                        <h4 class="h4">活動訂單管理-活動訂單查詢</h4>
                    </div>
                </div>
                <div class="row justify-content-end">
                    <div class="col-md-auto">
                       <a href="<%=request.getContextPath()%>/back_end/activity_order/listAllActivityOrder.jsp">
                            <button type="button" class="btn btn-info"><i class="fa-solid fa-circle-left"></i>回到活動訂單列表</button>
                        </a>
                    </div>
                </div>
                
                <%-- 錯誤表列 --%>
<%-- 				<c:if test="${not empty errorMsgs}"> --%>
<!-- 					<font style="color:red">請修正以下錯誤:</font> -->
<!-- 					<ul> -->
<%-- 					    <c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 							<li style="color:red">${message}</li> --%>
<%-- 						</c:forEach> --%>
<!-- 					</ul> -->
<%-- 				</c:if> --%>

                <div class="addblock border border-light bg-light rounded">

                    <div class="row">
                        <div class="col">
                            <form method="post"
                                action="<%=request.getContextPath()%>/activityJoin/activityJoin.do">
                                <div class="form-group form-inline">
                                    <label for="inputActivitySessionID">輸入活動訂單編號：</label>
                                    <input type="text" class="form-control" id="inputActivitySessionID"
                                        placeholder="請輸入數字" name="activityOrderId">
                                    <input type="hidden" name="action" value="getOneForDisplay">
                                    <input type="submit" class="btn btn-dark" value="送出">
                                    <div><font color=red>${errorMsgs.activityOrderId}</font></div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <jsp:useBean id="activityJoinService" scope="page"
                        class="com.activity_join.model.ActivityJoinService" />

                    <div class="row">
                        <div class="col">
                            <form method="post"
                                action="<%=request.getContextPath()%>/activityJoin/activityJoin.do">
                                <div class="form-group form-inline">
                                    <label for="selectActivityOrderID">選擇活動訂單編號：</label>
                                    <select size="1" class="form-control" name="activityOrderId"
                                        id="selectActivityOrderID">
                                        <c:forEach var="activityJoinVO" items="${activityJoinService.all}">
                                            <option value="${activityJoinVO.activityOrderId}">
                                                ${activityJoinVO.activityOrderId}
                                        </c:forEach>
                                    </select>
                                    <input type="hidden" name="action" value="getOneForDisplay">
                                    <input type="submit" class="btn btn-dark" value="送出">
                                </div>
                            </form>
                        </div>
                    </div>

<!--                     <div class="row"> -->
<!--                         <div class="col"> -->
<!--                             <form method="post" -->
<%--                                 action="<%=request.getContextPath()%>/activityJoin/activityJoin.do"> --%>
<!--                                 <div class="form-group form-inline"> -->
<!--                                     <label for="selectActivityName">選擇活動名稱：</label> -->
<!--                                     <select size="1" class="form-control" name="activity_ID" -->
<!--                                         id="selectActivityName"> -->
<%--                                         <c:forEach var="activityVO" items="${activityService.all}"> --%>
<%--                                             <option value="${activityVO.activity_ID}"> --%>
<%--                                                 ${activityVO.activity_name} --%>
<%--                                         </c:forEach> --%>
<!--                                     </select> -->
<!--                                     <input type="hidden" name="action" value="getOneForDisplay"> -->
<!--                                     <input type="submit" class="btn btn-dark" value="送出"> -->
<!--                                 </div> -->
<!--                             </form> -->
<!--                         </div> -->
<!--                     </div> -->

<%-- 					<jsp:useBean id="activityCategoryService" scope="page" class="com.activity_category.model.ActivityCategoryService" /> --%>
					
<!-- 					<div class="row"> -->
<!--                         <div class="col"> -->
<!--                             <form method="post" -->
<%--                                 action="<%=request.getContextPath()%>/activity_category/ActivityCategoryServlet.do"> --%>
<!--                                 <div class="form-group form-inline"> -->
<!--                                     <label for="selectActivityCategory">選擇活動類別：</label> -->
<!--                                     <select size="1" class="form-control" name="activity_category_ID" -->
<!--                                         id="selectActivityCategory"> -->
<%--                                     	<c:forEach var="activityCategoryVO" items="${activityCategoryService.all}" >  --%>
<%-- 								        	<option value="${activityCategoryVO.activity_category_ID}">${activityCategoryVO.activity_category_name} --%>
<%-- 								        </c:forEach>   --%>
<!--                                     </select> -->
<!--                                     <input type="hidden" name="action" value="listActivitiesByActivity_category_ID"> -->
<!--                                     <input type="submit" class="btn btn-dark" value="送出"> -->
<!--                                 </div> -->
<!--                             </form> -->
<!--                         </div> -->
<!--                     </div> -->

                </div>
                
               
<%-- 				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/activityJoin/activityJoin.do" name="form1"> --%>
<!-- 	                <div class="addblock border border-light bg-light rounded"> -->
<!-- 	                	<div class="form-group"> -->
<!-- 							<b><font color=blue><i class="fa-solid fa-star"></i>萬用複合查詢<i class="fa-solid fa-star"></i></font></b> -->
<!-- 	                	</div> -->
	                
<!-- 		                <div class="form-group form-inline">							         -->
<!-- 					        <label for="selectActivityID2">選擇活動編號：</label> -->
<!-- 							<select size="1" name="activity_ID" id="selectActivityID2" class="form-control"> -->
<!-- 									<option value=""> -->
<%-- 								<c:forEach var="activityVO" items="${activityService.all}" >  --%>
<%-- 									<option value="${activityVO.activity_ID}">${activityVO.activity_ID} --%>
<%-- 								</c:forEach>    --%>
<!-- 							</select> -->
<!-- 						</div> -->
						
<!-- 						<div class="form-group form-inline"> -->
<!-- 					        <label for="selectActivityCategory2">選擇活動類別：</label> -->
<!-- 					        <select size="1" name="activity_category_ID" id="selectActivityCategory2" class="form-control"> -->
<!-- 					           <option value=""> -->
<%-- 					          <c:forEach var="activityCategoryVO" items="${activityCategoryService.all}" >  --%>
<%-- 					           <option value="${activityCategoryVO.activity_category_ID}">${activityCategoryVO.activity_category_name} --%>
<%-- 					          </c:forEach>    --%>
<!-- 					        </select> -->
<!-- 		                </div> -->
<!-- 						<div class="form-group form-inline"> -->
<!-- 					        <label for="selectActivityName2">輸入活動名稱：</label> -->
<!-- 					        <input type="text" name="activity_name" value="" id="selectActivityName2" class="form-control"> -->
<!-- 		                </div> -->
<!-- 						<div class="form-group form-inline"> -->
<!-- 					        <label for="selectActivityPrice">輸入活動價格：</label> -->
<!-- 					        <input type="number" name="activity_price" value="" id="selectActivityPrice" class="form-control"> -->
<!-- 		                </div> -->
<!-- 						<div class="form-group form-inline"> -->
<!-- 					        <label for="selectActivityStart">活動開始日期：</label> -->
<!-- 						    <input name="activity_start" id="f_date1" type="text" id="selectActivityStart" class="form-control" onkeydown="return false"> -->
<!-- 		                </div> -->
<!-- 						<div class="form-group form-inline"> -->
<!-- 						    <label for="selectActivityEnd">活動結束日期：</label> -->
<!-- 						    <input name="activity_end" id="f_date2" type="text" id="selectActivityEnd" class="form-control" onkeydown="return false"> -->
<!-- 		                </div> -->
<!-- 						<div class="form-group form-inline"> -->
<!-- 						    <label for="selectActivityState">活動狀態：</label> -->
<!-- 						    <select size="1" name="activity_state" id="selectActivityState" class="form-control"> -->
<!-- 						    	<option value=""> -->
<%-- 						    	<option value="0" ${(0 == activityVO.activity_state)?'selected':'' }>下架</option> --%>
<%-- 								<option value="1" ${(1 == activityVO.activity_state)?'selected':'' }>上架</option> --%>
<!-- 						    </select> -->
<!-- 		                </div> -->
<!-- 						<div class="form-group form-inline"> -->
<!-- 					        <input type="hidden" name="action" value="listActivitiesByCompositeQuery"> -->
<!-- 					        <input type="submit" class="btn btn-dark" value="送出"> -->
<!-- 		                </div> -->
	                
<!-- 	                </div> -->

<!-- 				</FORM> -->
            </div>

        </main>

    </div>


	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
	
	
	<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>	
	<script>
	        $.datetimepicker.setLocale('zh');
	        $('#f_date1').datetimepicker({
	 	       theme: '',              //theme: 'dark',
		       timepicker:false,       //timepicker:true,
		       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
		       format:'Y-m-d',         //format:'Y-m-d H:i:s',
			   value: '',              // value:   new Date(),
	           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	           //startDate:	            '2017/07/10',  // 起始日
	           //minDate:               '-1970-01-01', // 去除今日(不含)之前
	           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
			   onShow:function(){
				   this.setOptions({
				    maxDate:$('#f_date2').val()?$('#f_date2').val():false
				   })
				  },
	        });
	        
	        $.datetimepicker.setLocale('zh');
	        $('#f_date2').datetimepicker({
	 	       theme: '',              //theme: 'dark',
		       timepicker:false,       //timepicker:true,
		       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
		       format:'Y-m-d',         //format:'Y-m-d H:i:s',
			   value: '',              // value:   new Date(),
	           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	           //startDate:	            '2017/07/10',  // 起始日
	           //minDate:               '-1970-01-01', // 去除今日(不含)之前
	           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
			   onShow:function(){
				   this.setOptions({
				    minDate:$('#f_date1').val()?$('#f_date1').val():false
				   })
				  },
	        });
	   
	        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------
	
	        //      1.以下為某一天之前的日期無法選擇
	        //      var somedate1 = new Date('2017-06-15');
	        //      $('#f_date1').datetimepicker({
	        //          beforeShowDay: function(date) {
	        //        	  if (  date.getYear() <  somedate1.getYear() || 
	        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	        //              ) {
	        //                   return [false, ""]
	        //              }
	        //              return [true, ""];
	        //      }});
	
	        
	        //      2.以下為某一天之後的日期無法選擇
	        //      var somedate2 = new Date('2017-06-15');
	        //      $('#f_date1').datetimepicker({
	        //          beforeShowDay: function(date) {
	        //        	  if (  date.getYear() >  somedate2.getYear() || 
	        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	        //              ) {
	        //                   return [false, ""]
	        //              }
	        //              return [true, ""];
	        //      }});
	
	
	        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	        //      var somedate1 = new Date('2017-06-15');
	        //      var somedate2 = new Date('2017-06-25');
	        //      $('#f_date1').datetimepicker({
	        //          beforeShowDay: function(date) {
	        //        	  if (  date.getYear() <  somedate1.getYear() || 
	        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	        //		             ||
	        //		            date.getYear() >  somedate2.getYear() || 
	        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	        //              ) {
	        //                   return [false, ""]
	        //              }
	        //              return [true, ""];
	        //      }});
	        
	</script>
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