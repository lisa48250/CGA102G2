<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="m.com.room_type.model.*"%>
<%@ page import="m.com.room_type_photo.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>

<%
//取得room_type的id、物件
Room_TypeService room_typeSvc = new Room_TypeService();
List<Room_TypeVO> list = room_typeSvc.getAll();
pageContext.setAttribute("list", list);

Integer room_type_id = (Integer) request.getAttribute("room_type_id4"); // 取得room_type的id為4的物件
pageContext.setAttribute("room_type_id", room_type_id);
Room_TypeVO room_typeVO = (Room_TypeVO) request.getAttribute("roomtypeVO"); // 取得room_type的物件
pageContext.setAttribute("room_typeVO", room_typeVO);

// 取得room_type_photo的圖片
Room_type_photoService room_type_photoSvc = new Room_type_photoService();
List<Room_type_photoVO> photolist = room_type_photoSvc.getAllType(room_type_id);
pageContext.setAttribute("photolist", photolist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>房型內容</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/roomtypecontent.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/div.css">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<script>
	function changes(e) {
		document.getElementById("photo").src = e;
	}
</script>

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
		<a
			href="${pageContext.request.contextPath}/front_end/room_type/room_type_introduce.jsp"><img
			class="left-arrow"
			src="${pageContext.request.contextPath}/images/left-arrows.png"></a>

		<div id="room-aside">

			<c:forEach var="room_type_photoVO" items="${photolist}">
				<img class="room1-img1"
					src="<%=request.getContextPath()%>/Room_Type_Photo_Reader?id=${room_type_photoVO.room_type_photo_id}"
					onclick='changes("<%=request.getContextPath()%>/Room_Type_Photo_Reader?id=${room_type_photoVO.room_type_photo_id}")'>


				<%-- <img id="room1-img1"
				src="${pageContext.request.contextPath}/images/雙人房1-1.png"
				onclick='changes("${pageContext.request.contextPath}/images/雙人房1-1.png")'>
			<img id="room1-img2"
				src="${pageContext.request.contextPath}/images/雙人房1-2.png"
				onclick='changes("${pageContext.request.contextPath}/images/雙人房1-2.png")'>
			<img id="room1-img3"
				src="${pageContext.request.contextPath}/images/雙人房1-3.png"
				onclick='changes("${pageContext.request.contextPath}/images/雙人房1-3.png")'> --%>
			</c:forEach>
		</div>

		<form action="${pageContext.request.contextPath}/room_type.do"
			id="search_form">
			<a href="javascript:document:search_form.submit();" class="text-book">立即訂房</a>
			<input type="hidden" name="room_type_id4" value="${room_type_id }">
			<input type="hidden" name="action4" value="立即訂房">
		</form>

		<div class="room-title">
			<p>
			<h1>${room_typeVO.room_type_name}</h1>
			</p>
		</div>

		<img id="photo"
			src="${pageContext.request.contextPath}/images/總統房1-1.png">

		<div class="mytabs">
			<input type="radio" id="tabfree" name="mytabs" checked="checked">
			<label for="tabfree">Details</Details> </Details></label>
			<div class="tab">
				<div class="text1">
					<b>房內設施</b>
				</div>

				<div class="text2">
					<ul>
						<li>兩張雙人床</li>
						<li>冷暖氣機</li>
						<li>液晶電視 / 有線頻道</li>
						<li>戶外半露天池</li>
						<li>寬頻上網 (需自備電腦)</li>
						<li>獨立筒床墊 / 羽絨枕 / 羽絨被</li>
						<li>衛浴設備 / 盥洗用具 / 吹風機 / 面膜</li>
						<li>泡麵 / 飲料 / 咖啡包 茶包</li>
					</ul>
				</div>

				<hr class="hr1">

				<div class="text3">
					<b>訂房須知</b>
					<ul>
						<ol>1.民宿位於山區邊，難免會有蚊蟲蜘蛛爬蟲類誤入房內，如果您非常害怕牠們，請斟酌訂房。
						</ol>
						<ol>
							2.入住時間為下午16：00~20:30辦理住宿登記，退房時間為上午11：00。
							<br> 如需延遲退房時間將酌收每小時NT200元費用。
						</ol>
						<ol>3.為確保房客的住宿品質，訪客請於晚間9點以前離開，若逾時則視同住宿收費。
						</ol>
						<ol>4.每間房間為了保持住宿品質，每間房間依房型限定入住人數。
						</ol>
						<ol>5.請勿攜帶任何寵物 入住 及本館全面禁菸。
						</ol>
						<ol>6.露天溫泉開放時間為PM 20:00-21:30。
						</ol>
						<ol>7.客房內設有WIFI免費無限上網。
						</ol>
						<ol>8.晚上１０：００之後請勿大聲喧嘩，以免影響其他客人休息品質。
						</ol>
						<ol>9.退房時請繳交房卡給櫃檯同仁，如有遺失房卡，遺失卡片收費為一張房卡 $500 新台幣 。
						</ol>
					</ul>
				</div>

				<hr class="hr2">

				<div class="text4">
					<b>取消訂房規定</b>
					<p>請來電通知、FB私訊或EAMIL通知取消訂房,謝謝。</p>
				</div>
				<div class="text6">
					<ul>
						<li>於預定住宿日十四天前取消，將不收取取消訂房手續費。</li>
						<li>於預定住宿日十至十三日前取消，退還已付定金70%。</li>
						<li>於預定住宿日七至九日前取消，退還已付定金50%。</li>
						<li>於預定住宿日四至六日前取消，退還已付定金40%。</li>
						<li>於預定住宿日二至三日前取消，退還已付定金30%。</li>
						<li>於預定住宿日一日前取消，退還已付定金20%。</li>
						<li>於預定住宿日當日取消，不退。請於下午15：00前通知。</li>
						<li>於預定住宿日四至六日前取消，退還已付定金40%。</li>
					</ul>
				</div>

				<hr class="hr3">

				<div class="text5">
					<b>住宿須知</b>
					<ul>
						<ol>1.為響應環保，外出請隨手關燈和冷氣。
						</ol>
						<ol>
							2.入住時間為下午16：00~20:30辦理住宿登記，退房時間為上午11：00。
							<br> 如需延遲退房時間將酌收每小時NT200元費用。
						</ol>
						<ol>3.用餐時間：早餐08:00-09:30，請準時用餐。
						</ol>
						<ol>4.為確保房客的住宿品質，訪客請於晚間9點以前離開，若逾時則視同住宿收費。
						</ol>
						<ol>5.每間房間為了保持住宿品質，每間房間依房型限定入住人數。
						</ol>
						<ol>6.請勿攜帶任何寵物 入住 及本館全面禁菸。
						</ol>
						<ol>7.露天溫泉開放時間為PM 20:00-21:30。
						</ol>
						<ol>8.戶外庭園燈將於晚上10:00關閉。
						</ol>
						<ol>9.客房內設有WIFI免費無限上網。
						</ol>
						<ol>10.退房時請繳回房卡給櫃檯同仁，如有遺失房卡，須酌收工本費 $500元 新台幣。
						</ol>
					</ul>
				</div>
			</div>

			<input type="radio" id="tabsilver" name="mytabs"> <label
				for="tabsilver">Comment</label>
			<div class="tab">
				<h2>Comment</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur.</p>
				<br>
				<hr>
				<br>
				<p>Vivamus sit amet lectus aliquam, bibendum tortor vitae,
					maximus nunc. Maecenas nec aliquam ligula. Maecenas eleifend, ipsum
					vitae scelerisque tincidunt, mi mauris laoreet neque, ut faucibus
					orci risus nec ipsum. Sed pulvinar odio felis. Vivamus sodales sem
					non dui vehicula dapibus. Nam pretium nunc eu tincidunt dictum.
					Pellentesque augue nisi, volutpat consequat efficitur venenatis,
					euismod vitae elit. Quisque in enim in turpis pharetra efficitur.
					Aliquam sed finibus nulla. Praesent nisl leo, cursus ac elit sed,
					fermentum placerat ipsum. Vestibulum commodo libero vitae quam
					cursus, at sagittis leo commodo. Aenean pretium rutrum quam et
					egestas.</p>
				<br>
				<hr>
				<br>
				<p>Cras varius, tortor ut varius sollicitudin, leo elit blandit
					augue, consequat euismod risus eros id est. Sed vel scelerisque
					nunc. Vivamus vitae sapien ultrices lectus sagittis sagittis et id
					nisl. Nullam eu tincidunt sem, at venenatis enim. Nam ac facilisis
					lorem, a tempor urna. Mauris accumsan ut ante in dignissim. Nullam
					porttitor felis non ligula congue, vel placerat dui condimentum.</p>
				<br>
				<hr>
				<br>
				<p>Nullam faucibus magna orci, id sodales dui pharetra sed.
					Nulla sit amet elementum velit. Cras vel vulputate tellus, sit amet
					vehicula ligula. In lacinia et metus ut luctus. In a hendrerit
					lorem, eget ullamcorper odio. In gravida dolor et facilisis
					rhoncus. Nullam in porttitor diam, sed molestie nibh. Integer
					turpis erat, suscipit sed fringilla ac, varius in nisi. Suspendisse
					potenti. Aliquam rutrum porta ultricies. Pellentesque ultrices
					tempus ligula vel vulputate. Sed sit amet volutpat augue, a aliquam
					metus. Sed sed nisl lectus.</p>
				<br>
				<hr>
				<br>
				<p>In ac suscipit nisl, eget sagittis velit. Pellentesque mattis
					ex eget aliquam sodales. Cras rutrum dui nisl, vel porttitor velit
					consectetur sed. Cras et luctus leo. Aenean in nisl vel lectus
					pellentesque convallis. Cras eget nisl facilisis, semper ligula sit
					amet, aliquam ligula. Maecenas eu sem at urna auctor volutpat.
					Nulla facilisi. Curabitur rutrum in dolor egestas vulputate. Ut
					aliquet finibus luctus. Donec lacinia nulla ac ante ultricies, non
					rutrum dui suscipit. Praesent porta diam neque, at egestas tortor
					laoreet vitae. Suspendisse et nisl diam. Maecenas ut gravida justo.
					Pellentesque porttitor in nisi at commodo.</p>
				<br>
				<hr>
				<br>
				<p>Cras varius, tortor ut varius sollicitudin, leo elit blandit
					augue, consequat euismod risus eros id est. Sed vel scelerisque
					nunc. Vivamus vitae sapien ultrices lectus sagittis sagittis et id
					nisl. Nullam eu tincidunt sem, at venenatis enim. Nam ac facilisis
					lorem, a tempor urna. Mauris accumsan ut ante in dignissim. Nullam
					porttitor felis non ligula congue, vel placerat dui condimentum.</p>
				<br>
				<hr>
				<br>
				<p>Nullam faucibus magna orci, id sodales dui pharetra sed.
					Nulla sit amet elementum velit. Cras vel vulputate tellus, sit amet
					vehicula ligula. In lacinia et metus ut luctus. In a hendrerit
					lorem, eget ullamcorper odio. In gravida dolor et facilisis
					rhoncus. Nullam in porttitor diam, sed molestie nibh. Integer
					turpis erat, suscipit sed fringilla ac, varius in nisi. Suspendisse
					potenti. Aliquam rutrum porta ultricies. Pellentesque ultrices
					tempus ligula vel vulputate. Sed sit amet volutpat augue, a aliquam
					metus. Sed sed nisl lectus.</p>
			</div>

		</div>

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

	

		document.getElementById("statusOutput").textContent = "customer";

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

			} else if ("close" === jsonObj.type) {
				refreshFriendList(jsonObj);
			}

		};

		webSocket.onclose = function(event) {
			console.log("Disconnected!");
		};
	}
	}

	function sendMessage() {
		var inputMessage = document.getElementById("message");
		var friend = statusOutput.textContent;
		var message = inputMessage.value.trim();
		friend = "customer";
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
			friend = "customer";
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