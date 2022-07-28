<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="java.util.*"%>
<%-- <%@ page import="org.json.*"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%

 
	/* Product_Service posvc = new Product_Service();	
	
	List<Product_VO> povoList = posvc.getAll();
	/* JSONArray jsarray = new JSONArray(); */
	/* /* pageContext.setAttribute("povoList", povoList); */ 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>伴手禮商城首頁</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/ProductHomePage.css">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<style>
	.car-BTN{
		position:relative;
		top:25px;
		border:1px solid rgb(33, 37, 41);
		background-color:white;
		font-size:20px;
		width:150px;
		color:rgb(33, 37, 41);
	}
.car-BTN:hover{
		background-color:rgb(33, 37, 41);
		color:white;
	}
	.form-1{
		display:inline-block;
	}
</style>
</head>
<body  onload="connect();" onunload="disconnect();">
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>

	<!-- 跑馬頁 -->

	<div id="myCarousel" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active" id="img-id1">
				<img class="img1" src="${pageContext.request.contextPath}/images/跑馬圖片.png" alt="First slide">
				<div class="carousel-caption"></div>
			</div>
			<div class="item" id="img-id2">
				<img class="img2" src="${pageContext.request.contextPath}/images/跑馬圖片2.png" alt="Second slide">
				<div class="carousel-caption"></div>
			</div>
			<div class="item" id="img-id3">
				<img class="img3" src="${pageContext.request.contextPath}/images/跑馬圖片3.jpg" alt="Third slide">
				<div class="carousel-caption"></div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev" id="slide1"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next" id="slide2"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<aside class="aside">
		<nav class="aside_nav">
			<!-- <button type="button" class="btn_hamburger">按鈕</button> -->
			
			<ul class="aside_nav_list">
				<li><a href="${pageContext.request.contextPath}/front_end/purchasehomepage/PurchaseHomePage.jsp">全部商品</a></li>
				<li ><a href="${pageContext.request.contextPath}/front_end/purchasehomepage/Food.jsp">食品</a></li>
				<li><a href="${pageContext.request.contextPath}/front_end/purchasehomepage/Gift.jsp">伴手禮</a></li>
				<li><a href="${pageContext.request.contextPath}/front_end/purchasehomepage/LifePresents.jsp">生活精品</a></li>
				<li><a href="${pageContext.request.contextPath}/front_end/membersorders/Member_home_page.jsp">訂單查詢</a></li>  <!-- 這裡需要filter -->
				
			</ul>
			
		</nav>
	</aside>
	<div class="main">
	
	
	
	
	
	
		<!-- 搜尋區 -->
		
		
		<div class="search-all">
			<form action="${pageContext.request.contextPath}/Product" class="search-form">
			<input type="hidden" name="action" value="searchTyping">
			<lable for="search-form" class="fas fa-search"></lable>
			<input type="search" name="search-bar-string" placeholder="搜尋..." id="search-box"/>
			</form>
			
			<form action="${pageContext.request.contextPath}/Product" class="sort-form">
			<!-- <select class="select-bar" name="show-product-sort" onchange="this.form.submit()">
				<option value="0">熱門商品</option>
				<option value="1">最新上架</option>
				<option value="2">促銷商品</option>
			</select> -->
			
			<select class="select-bar" name="show-product-price-sort" onchange="this.form.submit()">
				<option value="">價格排序</option>
				<option value="0">由高到低</option>
				<option value="1">由低到高</option>
			</select>
			<input type="hidden" name="action" value="sort-bar">
			</form>
		</div>


		<!-- 商品欄 -->
		<ul class="card-list">
		<c:forEach var="poVO" items="${povoList}">
		<form class="form-1" action="${pageContext.request.contextPath}/Product_order_detailServlet">
			<
			
			
			<li class="card">
			
			<a class="card-image" href=""
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${poVO.product_id});"> 
			</a>
			<a class="card-description" href="">
					<h2>${poVO.product_name }</h2>
					<p>$${poVO.product_price }</p> <input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${poVO.product_id}">
					<input type="hidden" name="product_name" value="${poVO.product_name }">
					<input type="hidden" name="product_price" value="${poVO.product_price}">
					<input type="hidden" name="product_describtion" value="${poVO.product_describtion}">
					<input type="hidden" name="action" value="buy_now">	
		
			</a>
			</li>
			
		</form>
	</c:forEach>
		</ul>
		<%-- <form action="${pageContext.request.contextPath}/Product_order_detailServlet">
		<ul class="card-list">
			<c:forEach var="povo" items="${povolist}">
			<li class="card">
			<c:if test="${povo.product_name == '黑白曲奇餅'}">
			<a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage0.jsp"
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${povo.product_id});"> 
			</a>
			
			 <a class="card-description" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage0.jsp">
			
					<h2>${povo.product_name }</h2>
					<p>$${povo.product_price}</p> 
					<input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${povo.product_id}">
			</a>
			</c:if>
			<c:if test="${povo.product_name == '能量陶瓷板'}">
			<a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage6.jsp"
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${povo.product_id});"> 
			</a>
			
			 <a class="card-description" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage6.jsp">
			
					<h2>${povo.product_name }</h2>
					<p>$${povo.product_price}</p> 
					<input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${povo.product_id}">
			</a>
			</c:if>
			<c:if test="${povo.product_name == '風輕沐浴乳'}">
			<a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage4.jsp"
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${povo.product_id});"> 
			</a>
			
			 <a class="card-description" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage4.jsp">
			
					<h2>${povo.product_name }</h2>
					<p>$${povo.product_price}</p> 
					<input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${povo.product_id}">
			</a>
			</c:if>
			<c:if test="${povo.product_name == '奶酥餅禮盒'}">
			<a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage2.jsp"
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${povo.product_id});"> 
			</a>
			
			 <a class="card-description" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage2.jsp">
			
					<h2>${povo.product_name }</h2>
					<p>$${povo.product_price}</p> 
					<input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${povo.product_id}">
			</a>
			</c:if>
			<c:if test="${povo.product_name == '經典茶葉禮盒'}">
			<a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage1.jsp"
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${povo.product_id});"> 
			</a>
			
			 <a class="card-description" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage1.jsp">
			
					<h2>${povo.product_name }</h2>
					<p>$${povo.product_price}</p> 
					<input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${povo.product_id}">
			</a>
			</c:if>
			<c:if test="${povo.product_name == '焦糖烤布丁'}">
			<a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage3.jsp"
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${povo.product_id});"> 
			</a>
			
			 <a class="card-description" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage3.jsp">
			
					<h2>${povo.product_name }</h2>
					<p>$${povo.product_price}</p> 
					<input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${povo.product_id}">
			</a>
			</c:if>
			<c:if test="${povo.product_name == '紀念鑰匙圈'}">
			<a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage5.jsp"
				target="_blank" style="background-image: url(${pageContext.request.contextPath}/Product_reader?product_id=${povo.product_id});"> 
			</a>
			
			 <a class="card-description" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage5.jsp">
			
					<h2>${povo.product_name }</h2>
					<p>$${povo.product_price}</p> 
					<input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="${povo.product_id}">
			</a>
			</c:if>
			</li>
			</c:forEach>

			<li class="card"><a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage1.jsp"
				style="background-image: url(${pageContext.request.contextPath}/images/經典茶葉禮盒.png);"
				data-image-full="${pageContext.request.contextPath}/images/經典茶葉禮盒.png"> <img src="${pageContext.request.contextPath}/images/經典茶葉禮盒.png"
					alt="The Beautiful Game" />
			</a> <a class="card-description" href="#" target="_blank">
					<h2>經典茶葉禮盒</h2>
					<p>$199</p> <input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="6">
					
			</a></li>
			
			<li class="card"><a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage2.jsp" target="_blank"
				style="background-image: url(${pageContext.request.contextPath}/images/奶酥餅禮盒.png);"
				data-image-full="${pageContext.request.contextPath}/images/奶酥餅禮盒.png"> 
			</a> <a class="card-description" href="#" target="_blank">
					<h2>奶酥餅禮盒</h2>
					<p>$299</p> <input class="car-BTN" type="submit" name="goCar" value="查看商品">
			</a></li>

			<li class="card"><a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage3.jsp" target="_blank"
				style="background-image: url(${pageContext.request.contextPath}/images/布丁.jpg);" data-image-full="${pageContext.request.contextPath}/images/布丁.jpg">
					<img src="${pageContext.request.contextPath}/images/布丁.jpg" alt="Jane Doe" />
			</a> <a class="card-description" href="#" target="_blank">
					<h2>焦糖烤布丁</h2>
					<p>$199</p> <input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="7">
			</a></li>

			<li class="card"><a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage4.jsp" target="_blank"
				style="background-image: url(${pageContext.request.contextPath}/images/洗髮精-2.png);"
				data-image-full="${pageContext.request.contextPath}/images/洗髮精-2.png"> <img src="${pageContext.request.contextPath}/images/洗髮精-2.png"
					alt="Jane Doe" />
			</a> <a class="card-description" href="#" target="_blank">
					<h2>雲淡風輕沐浴乳</h2>
					<p>$399</p><input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="3">
			</a></li>

			<li class="card"><a class="card-image" href="${pageContext.request.contextPath}/front_end/purchasehomepage/Showproductpage5.jsp" target="_blank"
				style="background-image: url(${pageContext.request.contextPath}/images/掛錶鑰匙圈-1.jpg);"
				data-image-full="${pageContext.request.contextPath}/images/掛錶鑰匙圈-1.jpg"> <img src="${pageContext.request.contextPath}/images/掛錶鑰匙圈-1.jpg"
					alt="Jane Doe" />
			</a> <a class="card-description" href="#" target="_blank">
					<h2>紀念吊飾</h2>
					<p>$199</p> <input class="car-BTN" type="submit" name="goCar" value="查看商品">
					<input type="hidden" name="product_Id" value="8">
			</a></li>

		</ul>
					<input type="hidden" name="action" value="buy_now">
		</form> --%>
	</div>
	
	<footer>
		<div>
			<p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved.
				Designed by</p>
			<p>DREAMCENTER</p>
		</div>
	</footer>


	<div  class="textinfo">
		<img src="${pageContext.request.contextPath}/images/chat.png" class="textimg">
	</div>
	<div class="chat">
		<h3 id="statusOutput" class="statusOutput"></h3>
		<div id="row"></div>
		<div id="messagesArea" class="panel message-area">
		</div>
		<div class="panel input-area">
			<input id="message" class="text-field" type="text"
				placeholder="Message"
				onkeydown="if (event.keyCode == 13) sendMessage();" /> <input
				type="submit" id="sendMessage" class="button" value="Send"
				onclick="sendMessage();" />

		</div>
	</div>
	<script>
	//亂數當作訪客username
	
	if(localStorage.getItem(1) === null){
		let ID = Math.floor(Math.random() * 1000000);
		localStorage.setItem(1, ID);
	}else{
	let ID = localStorage.getItem(1);
	var MyPoint = "/FriendWS1/" + ID;
	var host = window.location.host;
	var path = window.location.pathname;
	var webCtx = path.substring(0, path.indexOf('/', 1));
	var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;

	var statusOutput = document.getElementById("statusOutput");
	var messagesArea = document.getElementById("messagesArea");
	var self = ID;
	var webSocket;

	function connect() {
		// create a websocket

	

		document.getElementById("statusOutput").textContent = "文字客服";

		webSocket = new WebSocket(endPointURL);

		webSocket.onopen = function(event) {
			console.log("Connect Success!");
			
			document.getElementById('sendMessage').disabled = false;
			/* document.getElementById('connect').disabled = true;
			document.getElementById('disconnect').disabled = false; */
		};

		webSocket.onmessage = function(event) {
		
			var jsonObj = JSON.parse(event.data);

			if ("open" === jsonObj.type) {
				refreshFriendList(jsonObj);
			} else if ("history" === jsonObj.type) {
				messagesArea.innerHTML = '';
				 var ul = document.createElement('ul');
				ul.id = "area"; 
				messagesArea.appendChild(ul);
				// 這行的jsonObj.message是從redis撈出跟好友的歷史訊息，再parse成JSON格式處理

				var messages = JSON.parse(jsonObj.message);
				for (var i = 0; i < messages.length; i++) {
					var historyData = JSON.parse(messages[i]);
					var showMsg = historyData.message;

					var li = document.createElement('li');
					// 根據發送者是自己還是對方來給予不同的class名, 以達到訊息左右區分
					historyData.sender === self ? li.className += 'me'
							: li.className += 'friend';
					li.innerHTML = showMsg;
					ul.appendChild(li);
				}

				messagesArea.scrollTop = messagesArea.scrollHeight;
			} else if ("chat" === jsonObj.type) {
// 				var ul = document.createElement('ul');
// 				ul.id = "area";
				var li = document.createElement('li');
				jsonObj.sender === self ? li.className += 'me'
						: li.className += 'friend';
				li.innerHTML = jsonObj.message;
				document.getElementById("area").appendChild(li);
				messagesArea.scrollTop = messagesArea.scrollHeight;

			}/*  else if ("close" === jsonObj.type) {
				refreshFriendList(jsonObj);
			} */

		};

		/* webSocket.onclose = function(event) {
			console.log("Disconnected!");
		}; */
	}
	}

	function sendMessage() {
		var inputMessage = document.getElementById("message");
		var friend = statusOutput.textContent;
		var message = inputMessage.value.trim();
		friend = "文字客服";
		if (message === "") {
			alert("Input a message");
			inputMessage.focus();
		} else {
			var jsonObj = {
				"type" : "chat",
				"sender" : self,
				"receiver" : friend,
				"message" : message
			};

			webSocket.send(JSON.stringify(jsonObj));
			console.log(JSON.stringify(jsonObj));
			console.log(webSocket);
			inputMessage.value = "";
			inputMessage.focus();
		}
	}
	// 有好友上線或離線就更新列表
	function refreshFriendList(/* jsonObj */) {
		/* var friends = jsonObj.users;
		var row = document.getElementById("row");
		row.innerHTML = ''; */
		addListener();

	}

	//註冊列表點擊事件並抓取好友名字以取得歷史訊息
	function addListener() {
		const container = document.querySelector("#message");

		container.addEventListener("click", function(e) {

			var friend = e.srcElement.textContent;
			friend = "文字客服";
			updateFriendName(friend);
			var jsonObj = {
				"type" : "history",
				"sender" : self,
				"receiver" : friend,
				"message" : ""
			};
			webSocket.send(JSON.stringify(jsonObj));
		});
	}

	function disconnect() {
		webSocket.close();
		document.getElementById('sendMessage').disabled = true;
/* 		document.getElementById('connect').disabled = false;
		document.getElementById('disconnect').disabled = true; */
	}

	function updateFriendName(name) {
		statusOutput.innerHTML = name;
	}
</script>
	<script>
	
	const chaat = document.querySelector(".textimg");
	const chat = document.querySelector(".chat");
	if(chaat){
	chaat.addEventListener("click", function() {
		if(chat.style.display === "none"){
			chat.style.display = "block";
		}else{
			chat.style.display = "none";
		}
		
	})
	};

</script>

	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/purchasepage.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
</body>
</html>