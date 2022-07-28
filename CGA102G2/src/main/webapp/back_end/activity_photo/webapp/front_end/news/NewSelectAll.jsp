<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="h.com.new_list.model.*"%>
<jsp:useBean id="News_list" scope="request"
	class="h.com.new_list.model.News_listService" />
<%-- <jsp:getProperty name="News_list" property="all"/> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News select</title>
</head>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/news.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<body onload="connect();" onunload="disconnect();">
	<!-- 	<header> -->
	<!-- 		<nav> -->
	<!-- 			<img class="nav-logo" -->
	<%-- 				src="${pageContext.request.contextPath}/images/logo.png" alt=""> --%>
	<!-- 			<table class="weather-div"> -->
	<!-- 				<tbody class="weather-tbody"> -->
	<!-- 					<tr class="weather-tr"> -->
	<!-- 					</tr> -->
	<!-- 					<tr class="weather-tr-1"> -->
	<!-- 					</tr> -->
	<!-- 				</tbody> -->
	<!-- 			</table> -->
	<!-- 			<div class="icon"></div> -->
	<!-- 			<img class="nav-top-img" -->
	<%-- 				src="${pageContext.request.contextPath}/images/wheather.png" alt=""> --%>
	<!-- 			<a -->
	<%-- 				href="${pageContext.request.contextPath}/front_end/member/MemberLogin.jsp" --%>
	<!-- 				class="text">會員登入/註冊</a> <a href="" class="nav-top-a"> <img -->
	<!-- 				class="nav-top-img-1" -->
	<%-- 				src="${pageContext.request.contextPath}/images/shopping-cart.png" --%>
	<!-- 				alt=""> -->
	<!-- 			</a> -->
	<!-- 			<div class="nav-top-bot"> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a -->
	<%-- 						href="${pageContext.request.contextPath}/front_end/frontpage/FrontPage.jsp" --%>
	<!-- 						class=""> -->
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>首頁</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a -->
	<%-- 						href="${pageContext.request.contextPath}/News" class=""> --%>
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>最新消息</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a -->
	<%-- 						href="${pageContext.request.contextPath}/front_end/room_type/room_type_introduce.jsp" --%>
	<!-- 						class=""> -->
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>房型介紹</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a href="" class=""> -->
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>關於我們</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a href="" class=""> -->
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>活動商城</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a href="" class=""> -->
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>伴手禮商城</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a href="" class=""> -->
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>媒體報導</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 				<ul class="nav-ul-bot"> -->
	<!-- 					<li class="nav-li"><a -->
	<%-- 						href="${pageContext.request.contextPath}/front_end/protect/Member_Data.jsp" --%>
	<!-- 						class=""> -->
	<!-- 							<div class="nav-left-div"> -->
	<!-- 								<p>會員中心</p> -->
	<!-- 							</div> -->
	<!-- 					</a></li> -->
	<!-- 				</ul> -->
	<!-- 			</div> -->
	<!-- 		</nav> -->
	<!-- 	</header> -->
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp"%>
	<main>
		<div class="div-4"></div>
		<div class="div-1"></div>
		<div class="div-2"></div>
		<div class="div-3"></div>
		<div class="div-5"></div>
		<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/News">
			<section class="section">
				<div class="slide-down">
					<p>最新消息News
					</p>
				</div>
				<img src="${pageContext.request.contextPath}/images/im.jpg" alt="">
			</section>
			<c:forEach var="data" items="${News_list.all}" varStatus="d">
				<%-- <%
			Object object = request.getAttribute("list");
			List<News_listVO> list = null;
			if (object instanceof List) {
				list = (List<News_listVO>) object;
			}
			if (list != null) {
				for (News_listVO item : list) {
					Date news_id_date = item.getNews_id_date();
					String news_id_description = item.getNews_id_description();
					String news_id_title = item.getNews_id_title();
					Integer news_id = item.getNews_id();
					
			%>  --%>

				<section class="section-${d.count}">
					<img
						src="${pageContext.request.contextPath}/NewsReader?news_id=${data.news_id}"
						alt="">
					<span class="date-${d.count}">${data.news_id_date}</span>
					<ul>
						<p class="title-${d.count}">${data.news_id_title}</p>
						<div class="d-${d.count}">
						${data.news_id_description}
						</div>
					</ul>
				</section>

				<%-- <section class="section-<%=news_id%>">
				<img src="" alt="">
				<p><%=news_id_date%></p>
				<ul>
					<span><%=news_id_title%></span>
					<li><%=news_id_description%></li>
				</ul>
			</section> --%>

				<%-- 	<%
			}
		}
	
			%> --%>

			</c:forEach>
		</FORM>
	</main>
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

			} /* else if ("close" === jsonObj.type) {
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
	

	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
	
	
	


</body>
</html>