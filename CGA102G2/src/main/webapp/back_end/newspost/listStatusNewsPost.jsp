<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.news_post.model.*"%>
<%
	NewsPostService newsSvc = new NewsPostService();
    List<NewsPostVO> list = newsSvc.getStatus((Integer)session.getAttribute("newsStatus"));
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/back_select_page.css">
<title>修改媒體</title>
<style>

  .addroometyp02{
  	border: 1px solid rgb(104, 64, 152);
    background-color: #757575;
    opacity: 0.5;
    border-radius: 20px;
    height: 30px;
    width: 120px;
    align-items: center;
    position: relative;
    margin-top: 100px;
    line-height: 30px;
    left: 350px;
    top:-490px;
  }
       .addroomtype02 > a{
    position:relative;
    color: white;
    text-decoration:none;
    font-family: 'Anek Malayalam', sans-serif;
    left:27px;
  }
</style>
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
<!--                         <li><a href=''>房間相關管理</a></li> -->
<!--                         <li><a href=''>房間狀態管理</a></li> -->
<!--                         <li><a href=''>房間訂單管理</a></li> -->
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
<!--                         <li><a href=''>查詢商品訂單</a></li> -->
<!--                         <li><a href=''>查詢全部訂單</a></li> -->
<!--                         <li><a href=''>新增商品訂單</a></li> -->
<!--                     </ul> -->
                
<!--                 </li> -->
                
               
            </ul>
        </nav>
    </aside>
   <main style="top:100px;">
<div id = "tableall">

	<table id="table-1">
   <tr><td height="50px"></td></tr>
	</table>
	<table id="table-2">
   <tr><td height="70px"></td></tr>
	</table>
	
 	<h2 class="newspostp">媒體報導管理</h2>
<div class=addroomtype><a href='${pageContext.request.contextPath}/back_end/newspost/addNewsPost.jsp'>新增媒體</a></div>


 

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
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/newspost/newspost.do" >
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
    left:27px;" href='${pageContext.request.contextPath}/back_end/newspost/select_page_news.jsp'>回媒體報導</a></div>

<table class="newspostbody">
	<tr>
		<th width="5%">媒體<br>編號</th>
		<th>媒體圖片檔</th>
		<th>標題</th>
		<th>摘要</th>
		<th>內容</th>
		<th>狀態</th>
		<th>報導日期</th>
		<th>報導出處</th>
		<th>修改</th>
	</tr>
	<jsp:useBean id="newsSV" scope="page" class="com.news_post.model.NewsPostService" />
	<div class="file1"><%@ include file="page1.file" %></div> 
	
	<c:forEach var="newsVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">

	<FORM  method="post" ACTION="<%=request.getContextPath()%>/newspost/newspost.do" enctype="multipart/form-data">
		<tr>
			<td >${newsVO.newsPostId}</td>
			<td><img class="news_img" name="newsPostId" src="${pageContext.request.contextPath}/NewsPost_Reader?newsPostId=${newsVO.newsPostId}"></td>
			<td class="JQellipsis">${newsVO.title}</td>
			<td class="JQellipsis">${newsVO.summary}</td>
			<td class="JQellipsis">${newsVO.content}</td>
			<td class="JQellipsis" style="width:4%;">${newsVO.newsStatus==1?"上架":"下架"}</td> 
			<td style="width: 10%;text-align: center;"><fmt:formatDate value="${newsVO.newsPostDate}" pattern="yyyy-MM-dd"/></td>
			<td>${newsVO.postComeFrom}</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/newspost/newspost.do" style="margin-bottom: 0px;">
		
			     <input class="update" type="submit" value="修改" >
			     <input type="hidden" name="newsPostId"  value="${newsVO.newsPostId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			     
        <FORM class="deleteForm" METHOD="post" ACTION="<%=request.getContextPath()%>/newspost/newspost.do" style="margin-bottom: 0px;">
         <button class="delete" id="delete">刪除</button>
         <input type="hidden" name="newsPostId"  value="${newsVO.newsPostId}">
         <input type="hidden" name="action" value="delete">
        </FORM>
			</td>
		</tr>
	</c:forEach>
</table>


<div class="file2">
<%@ include file="page2.file" %>
</div>
  
</div>
</main>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$(function(){
    var len = 20; // 超過50個字以"..."取代
    $(".JQellipsis").each(function(i){
        if($(this).text().length>len){
            $(this).attr("title",$(this).text());
            var text=$(this).text().substring(0,len-1)+"...";
            $(this).text(text);
        }
    });
});

$(".delete").click(function(e){
	 e.preventDefault();
	 let that = $(this);
	  swal({
	     title: "確定要刪除此媒體消息嗎?",
	     icon: "warning",
	     buttons: {
	         Btn: false,
	         cancel: {
	           text: "取消",
	           visible: true
	         },
	         confirm: {
	           text: "確定",
	           visible: true
	         }
	       }
	  }).then(function(value) {
	   if(value) {
		  $(that).closest('.deleteForm').submit();
	   }
	  });
	})
</script>
</body>
</html>