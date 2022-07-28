<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
		//以session取得該會員的編號
		// HttpSession session = request.getSession();
		request.getAttribute("memberID");
		request.getAttribute("time");
		request.getAttribute("productName");
		request.getAttribute("price");
		request.getAttribute("amounts");
		request.getAttribute("payMethod");
		request.getAttribute("status");
		request.getAttribute("total");
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>會員商品訂單</title>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerByD.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member_Centre.css">
	<style>
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

#table-2 {
	border-bottom-left-radius: 20px;
	border-bottom-right-radius: 20px;
	border-collapse: collapse;
	table-layout: fixed;
	align-items: center;
}

table {
	border-top-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	/* border: solid red; */
}



tr {
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	width:100%;
	text-align: center;
	align-items: center;
}



th, td {
	padding: 10px;
	text-align: center;
	width: 80px;
	font-size:14px;
	align-items: center;
}



#table-2 > th, td {
	font-size:14px;
	text-align: center;
	align-items: center;
}




/* .search-form{
	
	position: relative;
	text-align: left; 
	
}



 .errorMsg{
	display:inline-block;
	position:relative;
	left:10px;
	bottom:90px;
	font-size: 16px;
} 
.errorMsg > ul > li{
	list-style:none;
}

.form-list{
	list-style:none;
	position: relative;
	left:30px;
	display:inline-block;
	
}
.form-list > li > form{
	margin-top: 20px;
} */

.inputFile{
	position:relative;
	left:150px;
}
@keyframes  swing  {
		15% { transform:  translateX(5px); }
		40% { transform:  translateX(-5px); }
		65% { transform:  translateX(2px); }
		85% { transform:  translateX(-2px); }
		100% { transform:  translateX(0px); }
	}
.Img:hover{
	animation : swing 1s 1;
}

#table-2{
	margin-bottom:100px;
	
} 
table {
	border-radius: 5px;
	position: relative;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 1010px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 3px;
	text-align: center;
}
	
/* thead.thead>tr th:nth-child(2), thead.thead>tr th:nth-child(3) {
	width: 250px;
}

tbody.tbody tr:hover {
	content: attr(title);
	background-color: rgb(208, 255, 255);
} */


.table {
	text-align: center;
}

th, td, tr {
	border: 1px solid darkgray;
}
.Img{
	width:2.4%;
	height:2.2%;
	position:absolute;
	margin-top:-10px;
	margin-left:-11px;
}

h3{
	border:1px solid red;
	position:relative;
	text-align: center;
	height:50px;
	
}
#tableall2{
	text-align:left;
	position:absolute;
/* 	left:-200px; */
	top:-500px;
	display:inline-block;
	
}
.order-informations{
	
	border-radius: 5px;
	position: relative;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	left:172px;
	width: 600px;
	font-size:18px;
	top:35px;
	text-align:center;
}
.order-informations > div{
	padding:3px;
}
.order-informations > span{
	padding:3px;
}
.information:hover{
	background-color:black;
	color:white;
}
main{
	position:relative;
	left:200px;
}



	</style>
</head>

<body  onload="connect();" onunload="disconnect();">
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
<main>
	<div id="tableall2">
		<h1 style="margin-left:400px;top:30px; position:relative;">商品訂單詳情</h1>
		<div class="order-informations">
			<div>訂購時間</div><fmt:formatDate
							value="${time}"
							pattern="yyyy-MM-dd" />
			<hr>
			<div>會員編號</div>${memberID}
			<hr>
			<div>商品名稱</div>${productName}
			<hr>
			<div>商品單價</div>${price}
			<hr>
			<div>訂購數量</div>${amounts}
			<hr>
			<div>付款方式</div>
			<c:if test="${payMethod == 0}">
				信用卡
			</c:if>
			<c:if test="${payMethod == 1}">
				現金付款
			</c:if>
			<hr>
			<div>訂單狀態</div>
			<c:if test="${status == 0}">
				已付款
			</c:if>
			<c:if test="${status == 1}">
				訂購完成
			</c:if>
			<c:if test="${status == 2}">
				取消
			</c:if>
			<hr>
			<span>總價格$<span style="color : red;">${total}</span></span>
		
		</div>

</div>
	
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
	<script src="${pageContext.request.contextPath}/js/weather.js"></script>
	<script src="${pageContext.request.contextPath}/js/hidden.js"></script>
	<script src="${pageContext.request.contextPath}/js/date.js"></script>
	<script src="${pageContext.request.contextPath}/js/icon.js"></script>
</body>

</html>