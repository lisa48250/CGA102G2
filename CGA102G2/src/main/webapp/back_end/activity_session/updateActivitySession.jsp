<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity.model.*" %>
<%@ page import="com.activity_session.model.*"%>   

<%
	//ActivitySessionServlet.java (Concroller) 存入req的activitySessionVO物件 (包括幫忙取出的activitySessionVO, 也包括輸入資料錯誤時的activitySessionVO物件)
	ActivitySessionVO activitySessionVO = (ActivitySessionVO) request.getAttribute("activitySessionVO");

	ActivityService activityService = new ActivityService();
	List<ActivityVO> list = activityService.getActivitiesWhereStateIsOne();
	pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>飯店管理後台頁面-活動管理-活動場次管理</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/staff_activity_page.css">
    <link rel="stylesheet"
 		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
    <script src="https://cdn.ckeditor.com/4.7.3/standard-all/ckeditor.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/datetimepicker/jquery.datetimepicker.css" />
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
                        <h4 class="h4">活動場次管理-修改活動場次</h4>
                    </div>
                </div>
                <div class="row justify-content-end">
                    <div class="col-md-auto">
                        <a href="${pageContext.request.contextPath}/back_end/activity_session/listAllActivitySession.jsp">
                            <button type="button" class="btn btn-info"><i class="fa-solid fa-circle-left"></i>回到活動場次列表</button>
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

                    <form method="post" onsubmit="this.activity_ID.disabled=false"
                        action="${pageContext.request.contextPath}/activity_session/ActivitySessionServlet.do" name="form1">
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="activitySessionID">活動場次編號：</label>
                                    <input type="text" class="form-control col-sm-1" id="activitySessionID"
                                        placeholder="${activitySessionVO.activity_session_ID}"
                                        value="${activitySessionVO.activity_session_ID}"
                                        name="activity_session_ID" readonly>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectActivity">活動：</label>
                                    <select size="1" name="activity_ID" class="form-control" id="selectActivity" disabled>
										<c:forEach var="activityVO" items="${list}">
											<option value="${activityVO.activity_ID}" ${(activitySessionVO.activity_ID == activityVO.activity_ID)? 'selected':'' } >${activityVO.activity_name}
										</c:forEach>
									</select>
                                </div>
                            </div>
                        </div>

						<div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectActivitySessionStart">場次開始日期時間：</label><div><font color=red>${errorMsgs.activity_session_start}</font></div>
                                    <input type="dateNew" id="activity_session_start" class="form-control" id="selectActivitySessionStart"
                                        placeholder="請選擇場次開始日期時間" name="activity_session_start" onkeydown="return false" autocomplete="off"
                                        value="${activitySessionVO.activity_session_start}">                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectActivitySessionEnd">場次結束日期時間：</label><div><font color=red>${errorMsgs.activity_session_end}</font></div>
                                    <input type="dateNew" id="activity_session_end" class="form-control" id="selectActivitySessionEnd"
                                        placeholder="請選擇場次結束日期時間" name="activity_session_end" onkeydown="return false" autocomplete="off"
                                        value="${activitySessionVO.activity_session_end}">                                    
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectEnrollState">報名狀態：</label>
                                	<select size="1" name="activity_enroll_state" class="form-control" id="selectEnrollState">
										<option value="0" ${(0 == activitySessionVO.activity_enroll_state)?'selected':'' }>未開放報名</option>
										<option value="1" ${(1 == activitySessionVO.activity_enroll_state)?'selected':'' }>接受報名</option>
										<option value="2" ${(2 == activitySessionVO.activity_enroll_state)?'selected':'' }>額滿</option>
										<option value="3" ${(3 == activitySessionVO.activity_enroll_state)?'selected':'' }>取消</option>
									</select>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="inputStateNote">場次備註：</label><div><font color=red>${errorMsgs.status_note}</font></div>
                                    <textarea name="editor1" class="form-control" id="inputStateNote">${activitySessionVO.status_note}</textarea>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="insertMaxPart">人數上限：</label><div><font color=red>${errorMsgs.activity_max_part}</font></div>
                                    <input type="number" class="form-control" id="insertMaxPart"
                                        placeholder="請輸入人數上限" name="activity_max_part" 
                                        value="${activitySessionVO.activity_max_part}">                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="insertMinPart">人數下限：</label><div><font color=red>${errorMsgs.activity_min_part}</font></div>
                                    <input type="number" class="form-control" id="insertMinPart"
                                        placeholder="請輸入人數下限" name="activity_min_part" 
                                        value="${activitySessionVO.activity_min_part}">                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="enroll">報名總數：</label><div><font color=red>${errorMsgs.enroll_total}</font></div>
                                    <input type="number" class="form-control" id="enroll"
                                        name="enroll_total" 
                                        value="${activitySessionVO.enroll_total}" readonly>                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectEnrollStart">報名開始日期：</label><div><font color=red>${errorMsgs.enroll_start}</font></div>
                                    <input type="dateNew" id="enroll_start" class="form-control" id="selectEnrollStart"
                                        placeholder="請選擇報名開始日期" name="enroll_start" onkeydown="return false" autocomplete="off"
                                        value="${activitySessionVO.enroll_start}">                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectEnrollEnd">報名結束日期：</label><div><font color=red>${errorMsgs.enroll_end}</font></div>
                                    <input type="dateNew" id="enroll_end" class="form-control" id="selectEnrollEnd"
                                        placeholder="請選擇報名結束日期" name="enroll_end" onkeydown="return false" autocomplete="off"
                                        value="${activitySessionVO.enroll_end}">                                    
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <label for="selectActivitySessionState">場次狀態：</label>
                                	<select size="1" name="activity_session_state" class="form-control" id="selectActivitySessionState">
										<option value="0" ${(0 == activitySessionVO.activity_session_state)?'selected':'' }>下架</option>
										<option value="1" ${(1 == activitySessionVO.activity_session_state)?'selected':'' }>上架</option>
									</select>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <div class="form-group form">
                                    <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="activity_session_ID"
                                        value="${activitySessionVO.activity_session_ID}">
                                    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"> <!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
									<input type="hidden" name="whichPage"  value="<%=request.getParameter("whichPage")%>">  <!--只用於:istAllEmp.jsp-->
                                    <button type="submit" class="btn btn-dark" value="送出修改"><i class="fa-solid fa-square-check"></i>送出修改</button>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>


            </div>

        </main>

    </div>

<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
	
	
	<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>
	<script>
		$.datetimepicker.setLocale('zh');
	    $('#activity_session_start').datetimepicker({
		       theme: '',              //theme: 'dark',
		       timepicker:true,       //timepicker:true,
		       step: 15,                //step: 60 (這是timepicker的預設間隔60分鐘)
		       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
			   value: '',              // value:   new Date(),
	        //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	        //startDate:	            '2017/07/10',  // 起始日
	        //minDate:               '-1970-01-01', // 去除今日(不含)之前
	        //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
			   onShow:function(){
				   this.setOptions({
				    maxDate:$('#activity_session_end').val()?$('#activity_session_end').val():false
				   })
				  },
			  scrollMonth : false,
			  scrollInput : false
	     });
	    
	    $('#activity_session_end').datetimepicker({
		       theme: '',              //theme: 'dark',
		       timepicker:true,       //timepicker:true,
		       step: 15,                //step: 60 (這是timepicker的預設間隔60分鐘)
		       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
			   value: '',              // value:   new Date(),
	        //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	        //startDate:	            '2017/07/10',  // 起始日
	        //minDate:               '-1970-01-01', // 去除今日(不含)之前
	        //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
			   onShow:function(){
				   this.setOptions({
				    minDate:$('#activity_session_start').val()?$('#activity_session_start').val():false
				   })
				  },
			  scrollMonth : false,
			  scrollInput : false
	    });
		
	    $('#enroll_start').datetimepicker({
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
			    minDate:$('#enroll_end').val()?$('#enroll_end').val():false
			   })
			  },
			  scrollMonth : false,
			  scrollInput : false
		});
	    
	    $.datetimepicker.setLocale('zh');
	    $('#enroll_end').datetimepicker({
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
			    minDate:$('#enroll_start').val()?$('#enroll_start').val():false
			   })
			  },
		  scrollMonth : false,
		  scrollInput : false
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
    <script>CKEDITOR.replace("editor1");</script>
    <script>CKEDITOR.replace("editor2");</script>
    <script>CKEDITOR.replace("editor3");</script>
</body>

</html>