<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/frontpage.css" />
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>


</head>
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
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
	<main>
		<section class=" section1">
			<div class="section1-div">
				<img src="${pageContext.request.contextPath}/images/logo3.jpg" alt="">
			</div>	
			<div class="section1-div">
				<a
					href="${pageContext.request.contextPath}/front_end/room_type/room_type_introduce.jsp">立即訂房</a>
			</div>
		</section>
		<section class="section2">
			<div class="section2-div">
				<div class="section2-div-div">
					<p class="section2-p">放慢腳步</p>
				</div>
				<div class="section2-div-div">
					<p class="section2-p">放鬆身心</p>
				</div>
				<div class="section2-div-div">
					<p class="section2-p">沈浸在此地</p>
				</div>
			</div>
			<div class="section2-div-1">
				<div class="section2-div-div-1">
					<p>本飯店為了讓您可在此獲得身心靈的祥和</p>
				</div>
				<div class="section2-div-div-1">
					<p>已安排一系列放鬆行程，只要帶著一顆放鬆的心，即可出發。</p>
				</div>
			</div>
		</section>
		<section class="section3">
			<div class="section3-1">
				<div class="section3-2">
					<div class="section3-div-1">
						<p>客房空間</p>
					</div>
					<div class="section3-div-2">
						<p class="section3-p">4&nbsp/&nbsproom types</p>
					</div>
					<div class="section3-div-3">
						<p>
							隱身在沈穩內斂的舒活客房中，窗外綠意盎然<br> 光影交錯遠離都市的塵囂
						</p>
						<p>
							享受山嵐泉霧下的放鬆，聆聽潺潺流水、蟲鳴<br> 鳥叫是大自然給我們最好的禮物。
						</p>
					</div>
					<div class="section3-div-4">
						<a
							href="${pageContext.request.contextPath}/front_end/room_type/room_type_introduce.jsp">房型預覽</a>
					</div>
				</div>
				<div class="section3-3">
					<img src="${pageContext.request.contextPath}/images/雙人房1-3.png"
						alt="">
				</div>
			</div>
		</section>
		<section class="section4">
			<div class="section4-1">
				<div class="section4-3">
					<img src="${pageContext.request.contextPath}/images/activity1.jpg"
						alt="">
				</div>
				<div class="section4-2">
					<div class="section4-div-1">
						<p>本月主打活動</p>
					</div>
					<div class="section4-div-2">
						<p class="section4-p">日本茶道體驗</p>
					</div>
					<div class="section4-div-3">
						<p>
							從茶會的裝置、道具中看到時序的變化透過演示茶室禮儀，身體力行優雅入席的方法點茶演示的流程，學習懷抱著款待之心刷一碗茶。
						</p>
						<p>
							推廣日本茶道的初心。
						</p>
					</div>
					<div class="section4-div-4">
						<a href="${pageContext.request.contextPath}/front_end/activity_details/ActivityDetails_01.jsp">活動詳情</a>
					</div>
				</div>
			</div>
		</section>
		<section class="section5">
			<div class="section5-1">
				<div class="section5-2">
					<div class="section5-div-1">
						<p>伴手禮</p>
					</div>
					<div class="section5-div-2">
						<p class="section5-p">當地特色伴手禮</p>
					</div>
					<div class="section5-div-3">
						<p>
							本飯店與在地商家合作提供各式嚴選商品<br>讓旅人當作伴手禮，帶回旅途中的一片風景。
						</p>
						<p>
							品嚐美食之餘，也與親友分享旅遊後的喜悅與<br> 美好之情讓生活添上美麗面紗。
						</p>
					</div>
					<div class="section5-div-4">
						<a href="${pageContext.request.contextPath}/front_end/purchasehomepage/PurchaseHomePage.jsp">立即選購</a>
					</div>
				</div>
				<div class="section5-3">
					<img src="${pageContext.request.contextPath}/images/黑白曲奇餅.png"
						alt="">
				</div>
			</div>
		</section>
		<section class="section6">
			<div class="section6-div">
				<img src="${pageContext.request.contextPath}/images/設施.jpg" alt="">
			</div>
		</section>
		<section class="section7">
			<div class="section7-div">
				<p>─────────────&nbsp&nbsp&nbsp最新消息&nbsp&nbsp&nbsp─────────────</p>
			</div>
			<div class="section7-div-1">
				<span class="section7-img-1"> <a href="${pageContext.request.contextPath}/front_end/news/NewSelectAll.jsp"> <img
						src="${pageContext.request.contextPath}/images/new.jpg" alt="">
				</a>
				</span> <span class="section7-img-2"> <a href="${pageContext.request.contextPath}/front_end/news/NewSelectAll.jsp"> <img
						src="${pageContext.request.contextPath}/images/new1.jpg" alt="">
				</a>
				</span> <span class="section7-img-3"> <a href="${pageContext.request.contextPath}/front_end/news/NewSelectAll.jsp"> <img
						src="${pageContext.request.contextPath}/images/new2.jpg" alt="">
				</a>
				</span> <span class="section7-div-2-1">
					<p>防範詐騙公告</p>
				</span> <span class="section7-div-2-2">
					<p>雲淡風輕相關防疫措施</p>
				</span> <span class="section7-div-2-3">
					<p>2022&nbsp住宿/泡湯平假日定義</p>
				</span>
			</div>
			</div>
		</section>
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


	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
</body>
</html>