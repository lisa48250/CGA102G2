<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="m.com.room_type.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>

<%
Room_TypeService room_typeSvc = new Room_TypeService();
List<Room_TypeVO> list = room_typeSvc.getAll();
pageContext.setAttribute("list", list);
/* Integer id = (Integer) request.getAttribute("id"); */
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>房型介紹</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/roomtypeintroduce.css">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<!--  =================== * 前台框架區 * =================== -->
<body onload="connect();" onunload="disconnect();">
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>

	<!--  =================== * 主畫面區 * =================== -->

	<main>
		<img class="head-img"
			src="${pageContext.request.contextPath}/images/header-img.png">
		<div class="slide-down">
			<p>ROOMS</p>
		</div>
		<c:forEach var="room_typeVO" items="${list}">
		<form action="${pageContext.request.contextPath}/room_type.do">
		
		
			<div class="room1">
	
				<img class="room1-img"
					src="<%=request.getContextPath()%>/Room_Type_Reader?id=${room_typeVO.room_type_id}">
				<div class="room1-t">
					<p>
					<h2>${room_typeVO.room_type_name}</h2>
					${room_typeVO.room_type_content}
					</p>
					<hr class="hr1">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_68404e772df640b68b23f21d7da05ff0.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_113deb04a7d04d5c948c0bff965a6e0c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_17d9f856e27b4887afafe7579ced081c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_1c55b17b6ff64692b8905decbadcca9d.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_3a3d4460fd9a472193826a7767fc412c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_6d1e9066aee94005a8afa9f98dda3694.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_7fe4365a9eaf4a8d8d8496166102be28.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_b67d1108005c4dc68d375ac1f9383940.webp">
					<!-- <a
						href="http://localhost:8081/CGA102G2/front_end/room_type/room_type_content1.jsp"
						class="text-more">More</a>  -->

				<%-- 	<c:if test="${room_typeVO.room_type_name eq '標準雙人房'}"> --%>
					<!-- href="http://localhost:8081/CGA102G2/front_end/room_type/room_type_content1.jsp" -->
						<input class="text-more" type="submit" name="action" value="More">
						<input name="a" type="hidden" value="1">
						<input type="hidden"  name="room_type_id" value="${room_typeVO.room_type_id}">	
					<%-- </c:if> --%>
					<%-- <c:if test="${room_typeVO.room_type_name eq '標準四人房'}">
						<input class="text-more" type="submit" name="action2" value="More">
						<input name="b" type="hidden" value="2">
						<input type="hidden" name="room_type_id2" value="${room_typeVO.room_type_id }">
					</c:if>
					<c:if test="${room_typeVO.room_type_name eq '尊爵四人房'}">
						<input class="text-more" type="submit" name="action3" value="More">
						<input name="c" type="hidden" value="3">
						<input type="hidden" name="room_type_id3" value="${room_typeVO.room_type_id }">
					</c:if>
					<c:if test="${room_typeVO.room_type_name eq '總統套房'}">
						<input class="text-more" type="submit" name="action4" value="More">
						<input name="d" type="hidden" value="4">
						<input type="hidden" name="room_type_id4" value="${room_typeVO.room_type_id }">
					</c:if> --%>

				</div>
			</div>

			<%-- <div class="room2">
				<img class="room2-img"
					src="$<%=request.getContextPath()%>/Room_Type_Reader?id=${room_typeVO.room_type_id}">
				<div class="room2-t">
					<p>
					<h2>${room_typeVO.room_type_name}</h2>
					<h4>18坪 兩大床（Queen size）</h4>
					設施 :<br> 吹風機、戶外半露天池、乾濕分離浴室、TV、WIFI、熱水壺、冷暖氣機、礦泉水、泡麵、飲料、<br>
					吊扇、咖啡包、茶包、棉棒、牙籤、浴帽、大小毛巾、牙刷、面膜、電冰箱
					</p>
					<hr class="hr2">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_68404e772df640b68b23f21d7da05ff0.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_113deb04a7d04d5c948c0bff965a6e0c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_17d9f856e27b4887afafe7579ced081c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_1c55b17b6ff64692b8905decbadcca9d.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_3a3d4460fd9a472193826a7767fc412c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_6d1e9066aee94005a8afa9f98dda3694.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_7fe4365a9eaf4a8d8d8496166102be28.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_b67d1108005c4dc68d375ac1f9383940.webp">
					<a href="" class="text-more">More</a>
				</div>
			</div>

			<div class="room3">
				<img class="room3-img"
					src="${pageContext.request.contextPath}/images/四人房2-1.png">
				<div class="room3-t">
					<p>
					<h2>尊爵四人房</h2>
					<h4>20坪 兩大床（Queen size）</h4>
					設施 :<br> 吹風機、戶外半露天池、乾濕分離浴室、TV、WIFI、熱水壺、冷暖氣機、礦泉水、泡麵、飲料、<br>
					吊扇、咖啡包、茶包、棉棒、牙籤、浴帽、大小毛巾、牙刷、面膜、電冰箱
					</p>
					<hr class="hr3">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_68404e772df640b68b23f21d7da05ff0.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_113deb04a7d04d5c948c0bff965a6e0c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_17d9f856e27b4887afafe7579ced081c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_1c55b17b6ff64692b8905decbadcca9d.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_3a3d4460fd9a472193826a7767fc412c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_6d1e9066aee94005a8afa9f98dda3694.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_7fe4365a9eaf4a8d8d8496166102be28.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_b67d1108005c4dc68d375ac1f9383940.webp">
					<a href="" class="text-more">More</a>
				</div>
			</div>

			<div class="room4">
				<img class="room4-img"
					src="${pageContext.request.contextPath}/images/總統房1-1.png">
				<div class="room4-t">
					<p>
					<h2>總統套房</h2>
					<h4>30坪 兩大床（Queen size）</h4>
					設施 :<br> 吹風機、戶外半露天池、乾濕分離浴室、TV、WIFI、熱水壺、冷暖氣機、礦泉水、泡麵、飲料、<br>
					吊扇、咖啡包、茶包、棉棒、牙籤、浴帽、大小毛巾、牙刷、面膜、電冰箱
					</p>
					<hr class="hr4">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_68404e772df640b68b23f21d7da05ff0.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_113deb04a7d04d5c948c0bff965a6e0c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_17d9f856e27b4887afafe7579ced081c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_1c55b17b6ff64692b8905decbadcca9d.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_3a3d4460fd9a472193826a7767fc412c.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_6d1e9066aee94005a8afa9f98dda3694.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_7fe4365a9eaf4a8d8d8496166102be28.webp">
					<img class="room1-img2"
						src="${pageContext.request.contextPath}/images/ba937d_b67d1108005c4dc68d375ac1f9383940.webp">
					<a href="" class="text-more">More</a>
				</div>
			</div> --%>
		
		</form>
		</c:forEach>
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

	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>

</body>

</html>