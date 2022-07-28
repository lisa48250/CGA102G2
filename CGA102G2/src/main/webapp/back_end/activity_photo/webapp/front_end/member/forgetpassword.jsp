<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>忘記密碼</title>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/forgetpassword.css" />
	
	<style>
.p1{
	font-size: 31px;
	font-weight: bold;
	text-align: center;
	line-height: 2em;
	top: 30px;
	position: relative;

}

.confirm2{
	position: relative;
	top:0px;
/* 	left: 250px; */
	padding: 20px 15px;
	text-align: center;

}
.background{
	position: relative;
	border-radius: 2%;
	top: 170px;
	height: 300px;
	width: 600px;
	margin-left: 300px;
	background-color:rgb(176, 176, 176)
}
.input1 input {
	background-color: white;
	width: 260px;
	padding: 5px 5px 5px 5px;
	border-radius: 30px;
	border-color: transparent;
	position: relative;
	top: 15px;
	font-size: 25px;
	letter-spacing: 2px;
	left: 170px;
	color: #3B413B;
	text-align: center;
}

.input2 input {
	width: 260px;
	padding: 5px 5px 5px 5px;
	border-radius: 30px;
	border-color: transparent;
	background-color: white;
	position: relative;
	top: 95px;
	font-size: 25px;
	letter-spacing: 2px;
	left: 170px;
	color: #3B413B;
	text-align: center;
}

.error{
		position: relative;
		margin-left: 220px;
		margin-top: 40px;
		font-size:19px;
		}

.sendemail{
			padding: 15px 30px 15px 30px;
			border-radius: 45px;
			border-color: transparent;
			background-color: black;
			color: white;
			position: relative;
			top:-10px;
			}


	</style>
</head>

	
	<body onload="connect();" onunload="disconnect();">
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
		<div class="background">
			<p class="p1">忘 記 密 碼</p>
		
			<div class="div-bottom">
				<form action="${pageContext.request.contextPath}/Email_Servlet" method="post">
            <div class="input1">
                <input
                    class="email" id="usrEmail" type="text" placeholder="輸入註冊信箱"
                    name="usrEmail" required>
            </div>

            <div class="error" style="color: red">${errorMsgs}</div>
            <br>
            <div class="confirm2">
                <input class="sendemail" style="cursor:pointer;" id= "forgetBtn" type="submit" value="發送驗證信">
            </div>
        </form>
	
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
/* 
		webSocket.onclose = function(event) {
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
<%-- <form action="${pageContext.request.contextPath}/Email_Servlet" method="post"> --%>
<!--             <div class="div1"> -->
<!--                 <input -->
<!--                     class="email" id="usrEmail" type="text" placeholder="Enter Email" -->
<!--                     name="usrEmail" required> -->
<!--             </div> -->

<%--             <div class="error" style="color: red">${errorMsgs}</div> --%>
<!--             <br> -->
<!--             <div class="div2"> -->
<!--                 <input class="btn btn-warning"  id= "forgetBtn" type="submit" value="�e�X"> -->
<!--             </div> -->
<!--         </form> -->