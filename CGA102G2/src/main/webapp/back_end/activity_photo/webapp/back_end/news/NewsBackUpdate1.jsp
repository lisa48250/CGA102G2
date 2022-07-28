<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="h.com.new_list.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/backendupdate.css">
<script src="https://cdn.ckeditor.com/4.7.3/basic/ckeditor.js"></script>

</head>
<header>
	<nav class="nav">

		<div class="logo">

			<a href="" class="logo_a"> <img
				src="${pageContext.request.contextPath}/images/logo.png" alt="">
			</a> <a class="nav-top-a" href="${pageContext.request.contextPath}/front_end/chat/chat.jsp"><img class="nav-top-chat"
				src="${pageContext.request.contextPath}/images/chat.png" alt=""></a>

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
				<hr style="background-color: #757575; height: 2px;">
			</div>
			<ul class="nav_list">

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images//group (1).png"><a --%>
<!-- 					href="#">員工管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>員工資料</a></li> -->
<!-- 						<li><a href=''>員工權限</a></li> -->
<!-- 					</ul></li> -->

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/social-group.png"><a --%>
<!-- 					href="#">會員管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>會員資料</a></li> -->
<!-- 						<li><a href=''>會員通知管理</a></li> -->
<!-- 					</ul></li> -->

				<li><img
					src="${pageContext.request.contextPath}/images/talking.png"><a
					href="#">消息管理</a>

					<ul id="list">
                        <li><a href='${pageContext.request.contextPath}/back_end/newspost/select_page_news.jsp'>媒體報導管理</a></li>
                        <li><a href='${pageContext.request.contextPath}/back_end/news/NewsBackselectAll.jsp'>最新消息管理</a></li>
                        
                    </ul>  
</li>
<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/bed.png"><a --%>
<!-- 					href="#">房務管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>住宿訂單管理</a></li> -->
<!-- 						<li><a href=''>訂單明細管理</a></li> -->
<!-- 						<li><a href=''>房型管理</a></li> -->
<!-- 						<li><a href=''>房間管理</a></li> -->
<!-- 						<li><a href=''>房型圖片管理</a></li> -->
<!-- 					</ul></li> -->

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/camping.png"><a --%>
<!-- 					href="#">活動管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>活動類別管理</a></li> -->
<!-- 						<li><a href=''>活動項目管理</a></li> -->
<!-- 						<li><a href=''>活動場次管理</a></li> -->
<!-- 						<li><a href=''>活動訂單管理</a></li> -->
<!-- 					</ul></li> -->

<!-- 				<li><img -->
<%-- 					src="${pageContext.request.contextPath}/images/gift.png"><a --%>
<!-- 					href="#">伴手禮管理</a> -->
<!-- 					<ul id="list"> -->
<!-- 						<li><a href=''>查詢全部訂單</a></li> -->
<!--                         <li><a href=''>新增商品訂單</a></li> -->
<!--                         <li><a href=''>商品類別管理</a></li> -->
<!--                         <li><a href=''>商品管理</a></li> -->
<!--                         <li><a href=''>商品圖片管理</a></li> -->
<!-- 					</ul></li> -->
			</ul>
		</nav>
	</aside>
<main>
	<div class="right-1">
		<a
			href="${pageContext.request.contextPath}/back_end/news/NewsBackInsert.jsp"><span>新增最新消息</span></a>
		<span>/</span> <a
			href="${pageContext.request.contextPath}/back_end/news/NewsBackselectAll.jsp"><span>查詢最新消息</span></a>
	</div>



	<div class="font">
		<h1 class="font-1">最新消息修改</h1>
	</div>


	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/NewsBackUpdate"
		enctype="multipart/form-data">
		
		<%-- <div class="error">
	     <c:forEach var="data" items="${errormsg}">
			<span>${data}</span>
		</c:forEach> 
		</div> --%>

		<div class="title">
			<label for="title">標題:</label> <input id="title" type="text"
				name="title" value="${list.news_id_title}">
		</div>

		<p class="titlep">${map.title}</p> 

		<div class="content">
			<label for="editor1">內容:</label>
			<textarea name="editor1" id="editor1" cols="50" rows="10">${list.news_id_description}</textarea>
			<script>
                CKEDITOR.replace( 'editor1' );
            </script>
		</div>
		
		<p class="editor1p">${map.editor1}</p>

		<div class="date">
			<label for="date">日期:</label> <input id="date" type="date"
				name="date" value="${list.news_id_date}">
		</div>

		<p class="datep">${map.date}</p>

		<div class="pic">
			<label for="pic">相片:</label> <img class="newimg"
				src="${pageContext.request.contextPath}/NewsReader?news_id=${list.news_id}">
			<input class="photo" type="file" value="選擇檔案" name="pic">
		</div>
		
		<p class="picp">${map.pic}</p>

		<input class="submit" type="submit" value="確認送出"> <input
			type="hidden" name="id" value="${list.news_id}"> <input
			type="hidden" name="action" value="update">
		<div class="color"></div>
	</FORM>

</main>
<script>
	const { body } = document;
	const photo = document.getElementsByClassName("photo")[0];
	photo.addEventListener("change", function(e) {
		if (e.target.previousElementSibling !== null) {
			const img = document.getElementsByClassName("newimg")[0];
			let file = e.target.files[0];
			let url = window.URL.createObjectURL(file);
			img.src = url;
		}
	});
	</script>
</body>
</html>