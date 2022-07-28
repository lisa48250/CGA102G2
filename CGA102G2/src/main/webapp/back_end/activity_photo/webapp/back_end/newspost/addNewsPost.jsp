<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.news_post.model.*"%>
<%
NewsPostVO newspostVO = (NewsPostVO) request.getAttribute("newspostVO");
NewsPostService newsSvc = new NewsPostService();
List<NewsPostVO> list = newsSvc.getAll();
pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/back_select_page.css">
<title>新增媒體</title>
</head>
<body bgcolor='white'>
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

    <aside class="aside" >
        <nav class="nav">
            <div>
                <img src="${pageContext.request.contextPath}/images/group.png" style="top: 20px;">
                <p>${employeeVO.emp_name}</p>
                <hr class="hr">
            </div>
            <ul class="nav_list">
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/group (1).png"><a href="#">員工管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>員工資料</a></li> -->
<!--                         <li><a href=''>員工權限</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
<!--                 <li> -->
<%--                     <img src="${pageContext.request.contextPath}/images/social-group.png"><a href="#">會員管理</a> --%>
<!--                     <ul id="list"> -->
<!--                         <li><a href=''>會員資料</a></li> -->
<!--                         <li><a href=''>會員通知管理</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
               
                <li> 
                    <img src="${pageContext.request.contextPath}/images/talking.png"><a href="#">消息管理</a>
                
                    <ul id="list">
                        <li><a href='${pageContext.request.contextPath}/back_end/newspost/select_page_news.jsp'>媒體報導管理</a></li>
                        <li><a href='${pageContext.request.contextPath}/back_end/news/NewsBackselectAll.jsp'>最新消息管理</a></li>
                        
                    </ul>  
                    </li>
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
<main style="top: 100px;">

<div id = "tableall">

	<table id="table-1">
   <tr><td height="50px"></td></tr>
	</table>
	<table id="table-2">
   <tr><td height="70px"></td></tr>
	</table>
	
 	<h2 class="newspostp">媒體報導管理</h2>
<div class=addroomtype><a href='${pageContext.request.contextPath}/back_end/newspost/addNewsPost.jsp'>新增媒體</a></div>


 
<%-- 錯誤表列 --%>
<div class="error">
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
</div>

   
 <div class="newsPostId">
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/newspost/newspost.do" >
       <b>選擇媒體編號:</b>
       <select size="1" name="newsPostId">
         <c:forEach var="newspostVO" items="${list}" > 
          <option value="${newspostVO.newsPostId}">${newspostVO.newsPostId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
 </div>
  
 <div class="newsstatus">
     <FORM class="Status" METHOD="post" ACTION="${pageContext.request.contextPath}/newspost/newspost.do" class="form1">
       <b>選擇媒體狀態:</b>
       <select size="1" name="newsStatus">
       <option value="1">上架
       <option value="0">下架
       </select>
       <input type="hidden" name="action" value="getOne_For_Status">
       <input type="submit" value="送出">
     </FORM>
</div>
<div class=addroometyp02 style="
	position: relative;
    top: -490px;
    left: 200px;
    width: 130px;">
    <a style="    
    position:relative;
    color: white;
    text-decoration:none;
    font-family: 'Anek Malayalam', sans-serif;
    left:27px;" href='${pageContext.request.contextPath}/back_end/newspost/select_page_news.jsp'>回媒體報導</a>
</div> 
	
<!-- 	=================================tableall======================================== -->
		
		
		<div class="body">
			<FORM id="addform" METHOD="post"
				ACTION="<%=request.getContextPath()%>/newspost/newspost.do"
				name="form1" enctype="multipart/form-data">


				<!-- <----------------------add標格------------------------>
				<table class="addnewspost">


					<div class="title" >
						標題: <input type="TEXT" name="title" size="45" placeholder="請輸入標題"
							value="<%=(newspostVO == null) ? "" : newspostVO.getTitle()%>" />
					</div>
					<div class="summary">
						摘要: <input type="TEXT" name="summary" size="45" placeholder="請輸入摘要"
							value="<%=(newspostVO == null) ? "" : newspostVO.getSummary()%>" />
					</div>

					<div class="date">
						報導日期: <input autocomplete="off"  name="newsPostDate" id="f_date1" type="text" placeholder="請輸入媒體日期"
							value="<%=(newspostVO == null) ? "" : newspostVO.getNewsPostDate()%>">
					</div>
					
					<div class="comefrom">
						報導出處: <input type="TEXT" name="postComeFrom" size="45" placeholder="請輸入報導出處"
							value="<%=(newspostVO == null) ? "" : newspostVO.getPostComeFrom()%>">
					</div>
					<div class="status">
						狀態: <select size="1" name="newsStatus" size="45"> 
							<option value="1" ${newspostVO.newsStatus=='1'? 'selected':''}>上架
								<option value="0" ${newspostVO.newsStatus=='0'? 'selected':''}>下架
						
						</select>
					</div>
					<div class="addimg">媒體圖片檔: </div>
					<input class="up" type="file" name="newsPhotoFile"size="45" accept="image/*"> 
					<img class="add_news_img" name="newsPostId" src="${pageContext.request.contextPath}/NewsPost_Reader?newsPostId=${newspostVO.newsPostId}">	
				
					<div class="editor1">
						<div for="editor1">內容:</div>
						<textarea name="editor1" id="editor1" cols="50" rows="10"></textarea>
						<script>
							CKEDITOR.replace('editor1');
						</script>
					</div>

				
							</table>
				<br> <input type="hidden" name="action" value="insert">
				<input type="hidden" name="newsPostId"
					value="<%=(newspostVO == null) ? "-1" : newspostVO.getNewsPostId()%>">
				<input id="submit" type="submit" value="送出新增"
				>
			</FORM>
		</div>

<!-- 	=================================tableall======================================== -->

	</main>

</body>

<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<% 
  java.sql.Date newsPostDate = null;
  try {
	  newsPostDate = newspostVO.getNewsPostDate();
   } catch (Exception e) {
	   newsPostDate = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
           maxDate:               '+1970-01-01'  // 去除今日(不含)之後

        });
        
        
  
</script>
<script>
 const { body } = document;
 const photo = document.querySelector(".up");
 photo.addEventListener("change", function(e) {
  if (e.target.nextElementSibling.nextElementSibling !== null) {
   const img = document.getElementsByClassName("add_news_img")[0];
   let file = e.target.files[0];
   let url = window.URL.createObjectURL(file);
   img.src = url;
  }
 });

	  
 </script>
</html>