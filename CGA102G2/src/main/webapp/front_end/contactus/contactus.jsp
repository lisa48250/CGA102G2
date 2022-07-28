<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

	<title>關於我們</title>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	
	<style>

		footer{
		position : absolute;
		top: 1550px;
		margin-top: 780px;	
		}

		.bell{
		width: 1227px;
    	height: 300px;
    	object-fit: cover;
		/* position: relative; */
		margin-top: 150px;
		margin: 130px 35px 0px 35px;
		top:100px;
		margin-left: 30px;
		}

		.color_2 {
    		color: rgb(var(--color_2));
			position : absolute;
			top: 630px;
			left: 190px;
			font-size: 30px;
			font-weight: bold;

		}

		.color_3 {
			font-size: 40px;
			font-weight: bold;
			text-align: center;
			line-height: 2em;
			/* border: solid 1px red; */
			margin-top: 50px;
		}

		.color_4 {
			font-size: 25px;
			text-align: center;
			list-style: 1em;
			margin-top: -20px;
		}
 
		.color_5 {
			font-size: 25px;
			text-align: center;
			list-style: 1em;
			margin-top: -5px;
		}
		
		.south{
			font-size: 20px;
			margin-left: 250px;
			font-weight: bold;
		}

		.route {
			font-size: 20px;
			margin-left: 300px;
		}

		.north{
			font-size: 20px;
			margin-left: 250px;
			font-weight: bold;
		}
		.route1 {
			font-size: 20px;
			margin-left: 300px;
		}
		.route2 {
			font-size: 20px;
			margin-left: 250px;
			margin-top: 50px;
			font-weight: bold;
		}
		.route3{
			font-size: 20px;
			margin-left: 300px;
			margin-top: 10px;
		}
		.name {
			margin-left: 730px;
			margin-top: 80px;
			padding :13px;
			width: 23%;
		}
		.mail1 {
			margin-left: 730px;
			margin-top: 10px;
			padding :13px;
			width: 23%;
		}
		.title1 {
			margin-left: 730px;
			margin-top: 10px;
			padding :13px;
			width: 23%;
		}
		.content1 {
			margin-left: 730px;
			margin-top: 10px;
			padding :30px;
			width: 23%;
			height: 100px;
		}
		.send {
			font-size: 17px;
			margin-left: 980px;
			margin-top: 10px;
			font-weight: bold;
		}
		.send:hover{
			color: #fc3a63; 
			position: relative; 
			top: 1px;
			left: 1px;
		}
		.map {
			position: relative;
			margin-top: 20px;
			margin-left: 280px;
			height: 400px;
			width: 700px;
			border: solid 3px black;
		}
		.map > img {
			width: 100%;
			height: 100%;
		}

		.pic1{
			position: relative;
			margin-top: 40px;
			margin-left: 50px;
			height: 350px;
			width: 550px;
			border-radius: 2%;
		}
		.pic1 > img {
 			width: 100%;
 			height: 100%;
			border-radius: 2%;
			max-width: 100%;
			min-height: 100%;
			display: block;
		}

		.pic2{
			position: relative;
			margin-top: 20px;
			margin-left: 620px;
			height: 350px;
			width: 550px;
/* 			border: solid 3px gray; */
			border-radius: 2%;
			overflow: hidden;
		}
		.pic2 > img {
			width: 100%;
			height: 100%;
			border-radius: 2%;
			max-width: 100%;
			min-height: 100%;
			display: block;
			box-shadow: 12px 12px 7px rgba(0, 1, 0, 1);
		}

		.word1{
				position: relative;
				color: gray;
				width:500px;
				margin-left: 650px;
				margin-top: -650px;
				font-size: 22px;
				line-height :40px;
		}

		.word2{
				
				position: relative;
				color: gray;
				width:500px;
				margin-left: 60px;
				margin-top: 240px;
				font-size: 22px;
				line-height :40px;
		}


div.slide-down {
	width:100%;
	overflow:hidden;
	position: absolute;
	left: 490px;
	top: 320px;
	z-index: -100px;

}
div.slide-down p {
	animation: 1.5s slide-down;
	margin-top:0%;
	font-size: 80px;
	color: #fbf9f9;
	text-shadow: black 0.1em 0.1em 0.2em;
	z-index: -100px;
}

@keyframes slide-down {
	from {
		margin-top: -8%;
		height: 300%; 
	}
	to {
		margin-top: 0%;
		height: 100%;
	}
}

		

	</style>
</head>

<body onload="connect();" onunload="disconnect();">
		<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
	
	<body>
		
		<section class="section">
			<div class="slide-down"><p>關於我們<p></div>
			</section>

		
		<div class="pic"><img class="bell" src="${pageContext.request.contextPath}/images/bell.jpg" alt=""></div>

		<div>
			<p style="color: gray;" class = "color_3">雲  淡  風  輕  溫  泉  酒  店</p>
	 	</div>

		<div>
			<p style="color: gray;" class = "color_4">花蓮縣雲淡鄉風輕路一段77號</p>
		</div>

		<div>
			<p style="color: gray;" class = "color_5">03-777777</p>
		</div>	

		<p class="mail" style="line-height:2em; text-align:center; font-size:23px; margin-top:-5px;"><span><a href="mailto:hotspringtibami@gmail.com">hotspringtibami@gmail.com</a></span></p>

		<p style="color: gray;" class="south">​南下</p>
		
		<p style="color: gray;" class="route">由蘇花公路接台10線(瑞穗)(約77.5公里) → 右轉過溫泉路二段(約2公里) → 抵達</p>

		<p style="color: gray;" class="north">北上</p>

		<p style="color: gray;" class="route1">由蘇花公路接台10線(瑞穗)(約77.5公里) → 左轉過雲淡路二段(約2公里) → 右轉建國路(約17公里) → 抵達</p>

		<div>
			<p style="color: gray;" class = "route2">從瑞穗火車站 - 騎車約10分鐘</p>

			<p style="color: gray;" class = "route3">瑞穗火車站 → 往北朝成功北路前進12 公里 → 於溫泉路一段向右轉7.1 公里 → 抵達</p>
		</div>

		
		<div class="map">
			<img src="${pageContext.request.contextPath}/images/飯店地址.JPG" alt="">	
		</div>

		<div  class="pic1">
			<img src="${pageContext.request.contextPath}/images/戶外休息區 01.jpg">
		</div>

		<div class="pic2">
			<img src="${pageContext.request.contextPath}/images/包廂溫泉 01.jpg">
		</div>

		<div class="word1">
			<p>
				世俗的雜亂紛擾催促著每個人的腳步，踏下無數疲憊的足跡，回首來路，已記不得曾在何處歇息。
				浮雲淡薄，微風輕拂，自然的美好消失在生命之中，寧靜及恬然亦在腦海中淡去，欲喚回記憶卻也無從下手。
			</p>
		</div>

		<div class="word2">
			<p>
				「雲淡風輕」是一種態度、是一種嚮往、更是本飯店接待每位貴賓時心中的期望，
				期望您停留在此處時，能忘卻憂愁與煩惱，進而感受心曠神怡、悠然自得，願本飯店成為貴賓之助力，再見人生旅途中的柳暗花明。
			</p>
		</div>





	</body>

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
		<h3 id="statusOutput" class="statusOutput">sdfsdfdsfs</h3>
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