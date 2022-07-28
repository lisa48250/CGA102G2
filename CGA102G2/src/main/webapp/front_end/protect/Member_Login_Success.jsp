<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<style>
		@import url(https://fonts.googleapis.com/earlyaccess/cwtexyen.css);

		body {
			height: 3175px;
			margin: 0;
		}

		html {
			overflow-x: hidden;
		}

		* {
			box-sizing: border-box;
			font-family: "cwTeXYen", sans-serif;
		}

		.nav-ul-bot {
			display: inline;
		}

		.nav-ul-top {
			display: inline;
		}

		.nav-li {
			display: inline-block;
			list-style: none;
		}

		a {
			text-decoration: none;
		}

		.nav-left-div p {
			width: 80px;
			color: black;
			font-size: 20px;
			display: block;
			width: 100%;
			border-right: 2px solid black;
			padding-right: 12px;
			color: #7D7D7D;
			border-color: #7D7D7D;
		}

		.nav-left-div p:hover {
			border-top: solid 3px black;
			margin-top: 3px;
			border-color: #7D7D7D;
		}

		header {
			height: 90px;
		}

		hr {
			height: 3px;
			background-color: gray;
		}

		nav {
			height: 200px;
			width: 1263px;
		}

		.nav-top-a {
			display: block;
			position: absolute;
			top: 40px;
			left: 1150px;
			width: 50px;
		}

		.nav-logo {
			width: 400px;
			height: 100px;
			position: absolute;
			top: 10px;
			left: 10px;
		}

		.nav-left-div {
			margin-top: 10px;
		}

		.nav-top-div {
			display: inline;
			width: 50px;
			position: relative;
			top: -5px;
			right: 120px;
		}

		.nav-top-img {
			width: 50px;
			height: 50px;
			position: absolute;
			top: 40px;
			left: 900px;
		}

		.nav-top-img-1 {
			width: 50px;
			height: 50px;
		}

		.nav-top-top {
			display: inline;
			position: absolute;
			top: 0;
			left: 0;
			width: 1206px;

		}

		.nav-top {
			display: inline;
			position: relative;
			top: 0px;
			right: -280px;

		}

		.text {
			border: 2px;
			border-radius: 20px;
			border: 1px black;
			background-color: #757575;
			font-size: 20px;
			padding: 8px 20px 8px 20px;
			color: white;
			width: 170px;
			position: absolute;
			top: 45px;
			left: 967px;
			text-align: center;
		}

		.nav-top-bot {
			margin-left: 100px;
			margin-top: 0px;
			position: absolute;
			top: 140px;
			height: 50px;
		}

		.weather-div {
			display: inline;
			position: relative;
			top: 20px;
			left: 475px;
		}

		.weather-tr {
			position: absolute;
			left: 95px;
			top: 0px;
			width: 330px;
		}

		.weather-tr-1 {
			position: absolute;
			left: 95px;
			top: 20px;
		}

		.td {
			width: 42px;
			padding-right: 5px;
		}

		.th {
			width: 42px;
			padding-right: 7px;
		}

		.icon-img {
			width: 30px;
			margin-right: 9px;
		}

		.weather-div {
			visibility: hidden;
		}

		.icon {
			visibility: hidden;
			position: absolute;
			left: 575px;
			top: 70px;
			width: 320px;
		}

		main {
			height: 2950px;
		}

		.section1 {
			height: 600px;
			margin-top: 100px;
			margin-left: 26px;
			margin-right: 20px;
		}

		.section1-div img {
			width: 1206px;
			height: 600px;
		}

		.section1-div a {
			color: white;
			border: 5px solid white;
			background-color: transparent;
			padding: 10px 30px 10px 30px;
			position: relative;
			top: -130px;
			left: 505px;
			font-size: 35px;
		}

		.section2 {
			height: 200px;
			width: 1206px;
			background-color: #C2C2C2;
			margin: 20px 20px 2px 26px;
		}

		.section2-div {
			text-align: center;
			padding: 10px;
		}

		.section2-div-div {
			display: inline;
			width: 100px;
			height: 50px;
			padding: 10px 30px 10px 30px;
		}

		.section2-p {
			width: 100px;
			font-size: 45px;
			display: inline;
			text-align: center;
			color: white;
			font-weight: bold;
		}

		.section2-div-div-1 p {
			color: white;
			font-size: 35px;
			margin-top: 3px;
			text-align: center;
			font-weight: bold;
		}

		.section2-div-div-1 {
			margin-top: 14px;
		}

		.section3 {
			background-color: rgb(235, 235, 235);
			width: 1206px;
			height: 380px;
			margin: 20px 20px 2px 26px;
		}

		.section3-1 {
			height: 435px;
			display: flex;
			flex-direction: row;
			margin-left: 100px;
		}

		.section3-2 {
			height: 435px;
			width: 490px;
			display: block;
			margin-left: -10px;
		}

		.section3-3 {
			height: 380px;
			width: 490px;
			display: block;
		}

		.section3-3 img {
			height: 380px;
			width: 626px;
		}

		.section3-div-1 {
			font-size: 40px;
			border-left: 5px solid black;
			font-weight: bold;
			margin: 0px;
			position: relative;
			top: 0px;
			left: 0px;
			width: 300px;
		}

		.section3-div-1 p {
			padding-left: 5px;
		}

		.section3-div-4 a {
			border: 3px solid black;
			background-color: transparent;
			padding: 5px 50px 5px 50px;
			background-color: transparent;
			position: relative;
			top: 10px;
			left: 260px;
			color: black;
			font-size: 20px;
		}

		.section3-div-3 {
			position: relative;
			top: -30px;
		}

		.section3-div-3 p {
			font-size: 20px;
			text-align: justify;
			letter-spacing: 2px;
		}

		.section3-p {
			font-weight: bold;
			position: relative;
			left: 35px;
			top: -20px;
			font-size: 30px;
		}

		.section4 {
			background-color: white;
			width: 1206px;
			height: 380px;
			margin: 20px 20px 2px 26px;
		}

		.section4-1 {
			height: 435px;
			display: flex;
			flex-direction: row;
			margin-left: 60px;
		}

		.section4-2 {
			height: 435px;
			width: 490px;
			display: block;
			margin-left: 50px;
		}

		.section4-3 {
			height: 380px;
			width: 490px;
			display: block;
		}

		.section4-div-2 {
			position: relative;
			top: 35px;
			left: 178px;
			font-weight: bold;
			font-size: 30px;
		}

		.section4-3 img {
			height: 380px;
			width: 626px;
			margin-left: -10px;
			position: relative;
			left: -50px;
		}

		.section4-div-1 p {
			font-size: 40px;
			border-left: 5px solid black;
			font-weight: bold;
			position: relative;
			top: 30px;
			left: 100px;
			margin: 0px;
			padding-left: 5px;
		}

		.section4-div-4 a {
			font-size: 20px;
			border: 3px solid black;
			background-color: transparent;
			padding: 5px 50px 5px 50px;
			position: relative;
			top: 140px;
			left: 300px;
			color: black;
		}

		.section4-div-3 {
			position: relative;
			top: 35px;
			left: 100px;
			font-size: 35px;
		}

		.section4-div-3 p {
			font-size: 20px;
			letter-spacing: 2px;
			text-align: justify;
		}

		.section4-div-4 {
			position: relative;
			top: -75px;
		}

		.section5 {
			background-color: rgb(235, 235, 235);
			width: 1206px;
			height: 380px;
			margin: 20px 20px 2px 26px;
		}

		.section5-1 {
			height: 435px;
			display: flex;
			flex-direction: row;
			margin-left: 100px;
		}

		.section5-2 {
			height: 435px;
			width: 490px;
			display: block;
			margin-left: -10px;
		}

		.section5-3 {
			height: 380px;
			width: 490px;
			display: block;
		}

		.section5-3 img {
			height: 380px;
			width: 626px;
		}

		.section5-div-1 p {
			font-size: 40px;
			border-left: 5px solid black;
			font-weight: bold;
			margin: 0px;
			position: relative;
			top: 40px;
			left: 0px;
			width: 300px;
			padding-left: 5px;
		}

		.section5-div-4 a {
			font-size: 20px;
			border: 3px solid black;
			background-color: transparent;
			padding: 5px 50px 5px 50px;
			position: relative;
			top: 140px;
			left: 300px;
			color: black;
		}

		.section5-div-3 {
			position: relative;
			top: 40px;
			left: 0px;
		}

		.section5-div-3 p {
			font-size: 20px;
			text-align: justify;
			letter-spacing: 2px;
		}

		.section5-p {
			font-weight: bold;
			position: relative;
			left: 25px;
			top: 40px;
			font-size: 30px;
		}

		.section5-div-4 {
			position: relative;
			left: -50px;
			top: -70px;
		}

		footer {
			height: 80px;
			width: 1362px;
			background-color: black;
			margin-top: 20px;
			position: relative;
			top: -48px;
		}

		footer p {
			width: 100vw;
			color: white;
			font-size: 12px;
			text-align: center;
			margin-top: 2px;
			position: relative;
			top: 20px;
		}

		.textinfo {
			color: white;
			background-color: lightblue;
			width: 70px;
			position: fixed;
			bottom: 10px;
			right: 10px;
		}

		.section6 {
			height: 380px;
			width: 1206px;
			margin: 20px 20px 2px 26px;
		}

		.section6-div {
			height: 380px;
		}

		.section6-div img {
			width: 1206px;
		}

		.section7 {
			height: 380px;
			width: 1206px;
			margin: 20px 20px 2px 26px;
			/* background-color: gray; */
			position: relative;
			top: 68px;
		}

		.section7-div {
			position: relative;
			top: -55px;
		}

		.section7-div-1 {
			height: 380px;
			width: 1206px;
			padding: 0px;
			position: relative;
			top: -45px;
		}

		.section7-div-1 img {
			width: 384px;
			height: 300px;
			margin-top: 1%;
		}

		.section7-div p {
			font-size: 40px;
			width: 1206px;
			text-align: center;
			margin: 0px;
			color: #7D7D7D;
		}

		.section7-div-2 p {
			font-size: 35px;
			font-weight: bold;
			display: inline;
			text-align: center;
			position: relative;
			top: 15px;
		}

		.section7-div-2-1 p {
			display: inline;
			position: relative;
			left: 100px;
			top: 15px;
			font-size: 32px;
			color: #7D7D7D;
		}

		.section7-div-2-2 p {
			display: inline;
			position: relative;
			left: 275px;
			top: 15px;
			font-size: 32px;
			color: #7D7D7D;
		}

		.section7-div-2-3 p {
			display: inline;
			position: relative;
			left: 340px;
			top: 15px;
			font-size: 32px;
			color: #7D7D7D;
		}

		.section7-img-2 {
			margin-left: 20px;
		}

		.section7-img-3 {
			margin-left: 20px;
		}
	</style>
</head>

<body onload="connect();" onunload="disconnect();">
<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
	<main>
		<section class=" section1">
			<div class="section1-div">
				<img src="${pageContext.request.contextPath}/images/封面.png" alt="">
			</div>
			<div class="section1-div">
				<a href="">立即訂房</a>
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
							隱身在沈穩內斂的舒活客房中，窗外綠意盎然<br>
							光影交錯遠離都市的塵囂</p>
						<p>
							享受山嵐泉霧下的放鬆，聆聽潺潺流水、蟲鳴<br>
							鳥叫是大自然給我們最好的禮物。
						</p>
					</div>
					<div class="section3-div-4">
						<a href="">房型預覽</a>
					</div>
				</div>
				<div class="section3-3">
					<img src="${pageContext.request.contextPath}/images/雙人房1-3.png" alt="">
				</div>
			</div>
		</section>
		<section class="section4">
			<div class="section4-1">
				<div class="section4-3">
					<img src="${pageContext.request.contextPath}/images/雙人房1-2.png" alt="">
				</div>
				<div class="section4-2">
					<div class="section4-div-1">
						<p>本月活動</p>
					</div>
					<div class="section4-div-2">
						<p class="section4-p">FUN暑假-防疫親子DIY</p>
					</div>
					<div class="section4-div-3">
						<p>雲淡風輕附近有許多旅遊景點，泡溫泉放鬆之餘<br>
							不妨也踏出戶外走走
						</p>
						<p>也可以參加本飯店舉辦的各式活動，讓您體驗特<br>
							有的新奇體驗！</p>
					</div>
					<div class="section4-div-4">
						<a href="">活動詳情</a>
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
						<p>本飯店與在地商家合作提供各式嚴選商品<br>讓旅人當作伴手禮，帶回旅途中的一片風景。
						</p>
						<p>
							品嚐美食之餘，也與親友分享旅遊後的喜悅與<br>
							美好之情讓生活添上美麗面紗。
						</p>
					</div>
					<div class="section5-div-4">
						<a href="">立即選購</a>
					</div>
				</div>
				<div class="section5-3">
					<img src="${pageContext.request.contextPath}/images/雙人房1-1.png" alt="">
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
				<span class="section7-img-1">
					<a href="">
						<img src="${pageContext.request.contextPath}/images/new.jpg" alt="">
					</a>
				</span>
				<span class="section7-img-2">
					<a href="">
						<img src="${pageContext.request.contextPath}/images/new1.jpg" alt="">
					</a>
				</span>
				<span class="section7-img-3">
					<a href="">
						<img src="${pageContext.request.contextPath}/images/new2.jpg" alt="">
					</a>
				</span>
				<span class="section7-div-2-1">
					<p>防範詐騙公告</p>
				</span>
				<span class="section7-div-2-2">
					<p>雲淡風輕相關防疫措施</p>
				</span>
				<span class="section7-div-2-3">
					<p>2022&nbsp住宿/泡湯平假日定義</p>
				</span>
			</div>
			</div>
		</section>
	</main>

	<footer>
		<div>
			<p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
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

	<script src="${pageContext.request.contextPath}/images/date.js"></script>
	<script src="${pageContext.request.contextPath}/images/weather.js"></script>
	<script src="${pageContext.request.contextPath}/images/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/images/icon.js"></script>
</body>

<!-- <br> -->
<!-- 	<table border='1' cellpadding='5' cellspacing='0' width='400'> -->
<!-- 		<tr bgcolor='orange' align='center' valign='middle' height='20'> -->
<!-- 			 <td>    -->
<!-- 			       <h3> 登入成功的頁面 - login_success.jsp           </h3>  -->
<%-- 				     <h3> 歡迎:<font color=red> ${account} </font>您好</h3> --%>
<!-- 			 </td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- 	<b> <br> -->
<!-- 	<br>                以下留空.... -->
</html>