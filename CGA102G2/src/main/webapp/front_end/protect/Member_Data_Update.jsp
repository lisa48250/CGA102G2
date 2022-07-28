<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member_Update.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member_Centre.css">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>


<title> 會員資料更改 </title>
	
<style>
        .a1{
            text-align: center;
            font-weight: bold;
            font-size: 30px;
            position: relative;
            top:30px;
        }

        .pic1{ 
            position:relative;
            margin-top: 70px;
            left: 200px;
            height: 150px;
            width: 200px;
            border-radius:10px;
        }
        .pic1 > img{
            width: 100%;
            height: 100%;
        }

        .confirm1{
/*          padding: 15px 5px 15px 5px; */
/* 		    border-radius: 45px; */
/* 	    	border-color: transparent; */
/* 	    	background-color: white; */
 	    	position: relative; 
/* 		    background-color: #5a5f5a; */
/* 	    	color: white; */
             margin-left: 270px; 
             margin-top: 30px; 
       		} 
        .confirm2{
		    top:205px;
            margin-left: 245px;
		    /* padding: 10px 15px; */
		    padding: 15px 30px 15px 30px;
		    border-radius: 45px;
	    	border-color: transparent;
	    	background-color: white;
	    	position: relative;
		    background-color: #5a5f5a;
	    	color: white;
        }
        .background_1{
            position: relative; 
            border-radius: 1%; 
            top: -280px;
 		    height: 800px; 
 		    width: 600px; 
 		    margin-left: 380px; 
 		    background-color:rgb(201, 200, 200) 
        }
        .input1 input {
			background-color: white;
            width: 260px;
            padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			position: relative;
			top: 45px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 170px;
			color: #3B413B;
			text-align: center;
		}

		.input2 input {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 75px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 170px;
			color: #3B413B;
			text-align: center;
		}

        .input3 input {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 105px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 170px;
			color: #3B413B;
			text-align: center;
		}

        .input4 input {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 135px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 170px;
			color: #3B413B;
			text-align: center;
		}

        .input5 input {
			width: 260px;
			padding: 5px 5px 5px 5px;
			border-radius: .45rem;
			border-color: transparent;
			background-color: white;
			position: relative;
			top: 165px;
			font-size: 25px;
			letter-spacing: 2px;
			left: 170px;
			color: #3B413B;
			text-align: center;
		}


.body1{
	border: solid 1px white;
	margin-top : 150px;
	height: 255px;
	width: 200px;
	position: relative;
	margin-left: 0px;
	background-color: rgb(180, 178, 178);
	
}
.name{
    position: relative;
    top:35px;
    left: 50px;
    max-width: 150px;
    font-size: 30px;
    color: black;
	margin-top: 160px;
    /* border: solid 2px yellow;  */	
}
.avatardiv{
  position:relative;
  margin-top: -165px;
  height: 140px;
  width: 160px;
  left:15px;
  /* border: solid 3px black; */
}
.avatardiv > img{
    width: 100%;
    height: 100%;
}

.pic2{
	width: 120px;
	height: 120px;
	text-align: center;
	position:relative;
	margin-left:240px;
	margin-top:30px;
}
	
</style>
	
</head>
<body onload="connect();" onunload="disconnect();">

<!-- <header> -->
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
<%-- 			<a href="${pageContext.request.contextPath}/front_end/member/MemberLogin.jsp" class="text">會員登入/註冊</a> <a href="" class="nav-top-a"> --%>
<!-- 				<img class="nav-top-img-1" -->
<%-- 				src="${pageContext.request.contextPath}/images/shopping-cart.png" --%>
<!-- 				alt=""> -->
<!-- 			</a> -->
<!-- 			<div class="nav-top-bot"> -->
<!-- 				<ul class="nav-ul-bot"> -->
<%-- 					<li class="nav-li"><a href="${pageContext.request.contextPath}/front_end/frontpage/FrontPage.jsp" class=""> --%>
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
<%-- 					<li class="nav-li"><a href="${pageContext.request.contextPath}/front_end/room_type/room_type_introduce.jsp" class=""> --%>
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
<%-- 					<li class="nav-li"><a href="${pageContext.request.contextPath}/front_end/protect/Member_Data.jsp" class=""> --%>
<!-- 							<div class="nav-left-div"> -->
<!-- 								<p>會員中心</p> -->
<!-- 							</div> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</nav> -->
<!-- 	</header> -->
<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
	<body>
		<div class="body1">
        <div class="name"> ${memberVO.member_name}</div>
        
        <div class="avatardiv">
            <img src="${pageContext.request.contextPath}/Member_reader?member_id=${memberVO.member_id}" alt="">
        </div>
		</div>
    </body>

	<aside>
		<ul >
			<li>
				<a href="${pageContext.request.contextPath}/front_end/protect/Member_Data.jsp" class="p1"> 
					<div class="p1div">
						<p>會員資料</p>
					</div>
				</a>
			</li>

		<li>
			<a href="${pageContext.request.contextPath}/front_end/protect/Member_Data_Update.jsp" class="p2"> 
			<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Member_Servlet">
			<input type="hidden" name="action" value="getOne_For_Update"></FORM>
				<div class="p2div">
					<p>資料管理</p>
				</div>
			</a>
		</li>

<!-- 		<li> -->
<!-- 			<a href="" class="p5">  -->
<!-- 				<div class="p5div"> -->
<!-- 					<p>訊息通知</p> -->
<!-- 				</div> -->
<!-- 			</a> -->
<!-- 		</li> -->

	
		<li>
			<a href="${pageContext.request.contextPath}/front_end/memberselect/selcetroomorder.jsp" class="p6"> 
				<div class="p6div">
					<p>查看住宿訂單</p>
				</div>
			</a>
		</li>

		<li>
			<a href="${pageContext.request.contextPath}/front_end/activity_order/ActivityOrder_State.jsp" class="p7"> 
				<div class="p7div">
					<p>查看活動訂單</p>
				</div>
			</a>
		</li>

		<li>
			<a href="${pageContext.request.contextPath}/front_end/membersorders/Member_home_page.jsp" class="p8"> 
				<div class="p8div">
					<p>查看購物訂單</p>
				</div>
			</a>
		</li>
	</ul>
</aside>

	
<div class="background_1">


<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Member_Servlet"  enctype="multipart/form-data">
	
    <div>
        <p class="a1">更 改 會 員 資 料</p>
    </div>

    <div class="${pageContext.request.contextPath}/images/pic1">
    <img class="pic2" src="${pageContext.request.contextPath}/Member_reader?member_id=${memberVO.member_id}" alt="">
    </div>

    <div>
    <input class="confirm1" type="file" accept="image/*" name="pic" value="上傳">
    </div>

    <div class="div-bottom">
        <div class="input1">
        
        
            <input type="text" placeholder="更改姓名" value="${memberVO.member_name}" name="member_name" required>
        </div>
          <div class="input2">
            <input type="text" placeholder="更改電話"  value="${memberVO.member_phone}" name="member_phone" required>
        </div>
        <div class="input3">
            <input type="text" placeholder="更改地址" value="${memberVO.member_address}" name="member_address" required>
        </div>
        <div class="input4">
            <input type="password" placeholder="輸入密碼" value="${memberVO.member_password}" name="member_password" required
            id="password1">
        </div>
        <div class="input5">
            <input type="password" placeholder="再次輸入密碼" value="" required id="password2">
        </div>
	
	<input type="hidden" name="member_id" value="${memberVO.member_id}">
	<input type="hidden" name="action" value="update">
    <input style="cursor:pointer;" class="confirm2" name="updating" type="submit" value="確認修改"></FORM> 	
    </div>

 
	<footer >
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


	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
	
		<script>

let input4 = document.getElementById('password1');
let input5 = document.getElementById('password2');
input5.addEventListener('blur',function(){   //設置一個監聽器 如果'blur'離開了input2 則執行函式
	if(input4.value != input5.value){   
		alert("輸入密碼不同");
	}
})

</script>

</body>
</html>