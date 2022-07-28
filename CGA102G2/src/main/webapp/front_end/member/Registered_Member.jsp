<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.members.model.*"%>

<%
MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Registered_Member.css">
<title>會員註冊</title>

 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-twzipcode@1.7.14/jquery.twzipcode.min.js"></script>
<!-- <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script> -->


<style>
.error {
	text-align: center;
	top: 300px;
	position: relative;
	left: 430px;
	/* 	margin-top:200px; */
}

select, .zipcode {
	position: relative;
	margin-top: 310px;
	margin-left: 65px;
	/* margin-left: 80px; */
	width: 190px;
	/* display:inline; */
	/* height: calc(1.5em + .75rem + 2px); */
	padding: 6px 0px;
	font-size: 19px;
	/* font-weight: 100; */
	/* line-height: 10px; */
	color: #495057;
	background-color: #fff;
	/* background-clip: padding-box; */
	border: 1px solid #ced4da;
	border-radius: .25rem;
	/* transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out; */
}

.logo1 {
	position: absolute;
	height: 100px;
	width: 400px;
	margin-left: 90px;
	margin-top: 20px;
}

 footer { 
	position: absolute;
	top: 1450px;
	}

.a2 {
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	position: relative;
	top: 140px;
}

.input1 input {
	background-color: white;
	width: 300px;
	padding: 5px 5px 5px 5px;
	border-radius: .25rem;
	border-color: transparent;
	position: relative;
	top: 150px;
	font-size: 20px;
	letter-spacing: 2px;
	left: 140px;
	color: #3B413B;
	text-align: center;
}

.input2 input {
	background-color: white;
	width: 300px;
	padding: 5px 5px 5px 5px;
	border-radius: .25rem;
	border-color: transparent;
	position: relative;
	top: 190px;
	font-size: 20px;
	letter-spacing: 2px;
	left: 140px;
	color: #3B413B;
	text-align: center;
}

.input3 input {
	background-color: white;
	width: 300px;
	padding: 5px 5px 5px 5px;
	border-radius: .25rem;
	border-color: transparent;
	position: relative;
	top: 230px;
	font-size: 20px;
	letter-spacing: 2px;
	left: 140px;
	color: #3B413B;
	text-align: center;
}

.input4 input {
	background-color: white;
	width: 300px;
	padding: 5px 5px 5px 5px;
	border-radius: .25rem;
	border-color: transparent;
	position: relative;
	top: 260px;
	font-size: 20px;
	letter-spacing: 2px;
	left: 140px;
	color: #3B413B;
	text-align: center;
}

.input5 input {
	background-color: white;
	width: 300px;
	padding: 5px 5px 5px 5px;
	border-radius: .25rem;
	border-color: transparent;
	position: relative;
	top: 270px;
	font-size: 20px;
	letter-spacing: 2px;
	left: 140px;
	color: #3B413B;
	text-align: center;
}

.input6 input {
	background-color: white;
	width: 300px;
	padding: 5px 5px 5px 5px;
	border-radius: .25rem;
	border-color: transparent;
	position: relative;
	top: 310px;
	font-size: 20px;
	letter-spacing: 2px;
	left: 140px;
	color: #3B413B;
	text-align: center;
}

.input7 input {
	background-color: white;
	width: 445px;
	padding: 5px 5px 5px 5px;
	border-radius: .25rem;
	border-color: transparent;
	position: relative;
	top: 410px;
	font-size: 20px;
	letter-spacing: 2px;
	left: 65px;
	color: #3B413B;
	text-align: center;
}

.confirm {
	position: relative;
	top: 100px;
	left: 245px;
	/* padding: 10px 15px; */
	padding: 15px 35px 15px 35px;
	border-radius: 45px;
	border-color: transparent;
	background-color: white;
	position: relative;
	background-color: #3B413B;
	color: white;
}

.confirm1 {
	position: relative;
	top: -400px;
	left: 355px;
	/* padding: 10px 15px; */
	padding: 9px 20px 9px 20px;
	border-radius: 10px;
	border-color: transparent;
	background-color: white;
	position: relative;
	background-color: #3B413B;
	color: white;
}

.pic {
	width: 1263px;
	height: 325px;
	/* border: solid 1px red; */
	margin-top: 150px;
}

.pic1 {
	height: 100%;
	width: 100%;
}

.backgroundcolor {
	position: relative;
	/* border: 1px solid red; */
	border-radius: 1%;
	top: 130px;
	height: 770px;
	width: 570px;
	margin-left: 350px;
	background-color: rgb(176, 176, 176)
}
</style>
</head>
<body  onload="connect();" onunload="disconnect();">
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
<!-- 			<a href="" class="text">會員登入/註冊</a> <a href="" class="nav-top-a"> -->
<!-- 				<img class="nav-top-img-1" -->
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
<!-- 					<li class="nav-li"><a href="" class=""> -->
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>會員中心</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</nav> -->
<!-- 	</header> -->

<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
	<c:if test="${not empty errorMsgs}">
		<div class="error">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
<body>
	<div class="backgroundcolor">
		<div>
			<img class="logo1"
				src="${pageContext.request.contextPath}/images/logo.png" alt="">
			<!-- <p class="a1">雲 淡 風 輕 溫 泉 酒 店</p> -->
			<p class="a2">會員註冊</p>


			<FORM METHOD="post"
				ACTION="${pageContext.request.contextPath}/Member_Servlet" name="">

				<div class="div-bottom">
					<div class="input1">
						<input type="text" name="member_email" placeholder="請輸入註冊信箱"
							value="<%=(memberVO == null) ? "" : memberVO.getMember_email()%>"
							required>
					</div>
					<div class="input2">
						<input type="password" name="member_password" placeholder="請輸入密碼"
							value=""
							<%=(memberVO == null) ? "" : memberVO.getMember_password()%>" required
							id="password1">
					</div>

					<div class="input3">
						<input type="password" placeholder="再次輸入密碼" value=""
							id="password2">
					</div>

					<div class="input5">
						<input type="text" name="member_name" placeholder="請輸入姓名"
							value="<%=(memberVO == null) ? "" : memberVO.getMember_name()%>"
							required>
					</div>

					<div class="input6">
						<input type="text" name="member_phone" placeholder="請輸入電話"
							value="<%=(memberVO == null) ? "" : memberVO.getMember_phone()%>"
							required>
					</div>

					<div class="input7">
						<input type="text" name="member_address" placeholder="請輸入地址"
							value="<%=(memberVO == null) ? "" : memberVO.getMember_address()%>"
							required>
					</div>

					<div id="zipcode2"></div>
					<script>
						$("#zipcode2").twzipcode({
							zipcodeIntoDistrict : true
						});
					</script>

					<div id="zipcode2"></div>

					<div id="zipcode2"></div>

					<script>
						$("#zipcode2").twzipcode({
							countySel : "臺北市", // 城市預設值, 字串一定要用繁體的 "臺", 否則抓不到資料
							districtSel : "大安區", // 地區預設值
							zipcodeIntoDistrict : true, // 郵遞區號自動顯示在地區
							css : [ "city form-control", "town form-control" ], // 自訂 "城市"、"地區" class 名稱
							countyName : "city", // 自訂城市 select 標籤的 name 值
							districtName : "town" // 自訂地區 select 標籤的 name 值
						});
					</script>

					<a> <input type="hidden" name="action" value="register">
						<input class="confirm" type="submit" value="註冊">
			</FORM>
			</a>

			<!-- 			<a> -->
			<!-- 			<input type="hidden" name="action" value="verify"> -->
			<!-- 			<input class="confirm1" type="button" value="驗證信箱"> 	 -->
			<!-- 			</a> -->

			<script>
				let input2 = document.getElementById('password1');
				let input3 = document.getElementById('password2');
				input3.addEventListener('blur', function() { //設置一個監聽器 如果'blur'離開了input2 則執行函式
					if (input2.value != input3.value) {
						alert("請確認密密碼");
					}
				})
			</script>
</body>

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

	/* 	webSocket.onclose = function(event) {
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