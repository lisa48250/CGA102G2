<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Member_Centre.css">
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
	position:relative;
	left:300px;
	display:inline-block;
}
.order-informations{
	
	border-radius: 5px;
	position: relative;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	width: 600px;
	font-size:24px;
}
.order-informations > div{
	padding:5px;
}
.order-informations > span{
	padding:5px;
}
	</style>
</head>
<body>
	<header>
		<nav>
			<img class="nav-logo" src="${pageContext.request.contextPath}/images/logo.png" alt="">
			<table class="weather-div">
				<tbody class="weather-tbody">
					<tr class="weather-tr">
					</tr>
					<tr class="weather-tr-1">
					</tr>
				</tbody>	
			</table>
			<div class="icon"></div>
			<img class="nav-top-img" src="${pageContext.request.contextPath}/images/wheather.png" alt="">
			<a href="" class="text">會員登入/註冊</a>
			<a href="" class="nav-top-a">
				<img class="nav-top-img-1"src="${pageContext.request.contextPath}/images/shopping-cart.png" alt="">
			</a>
			<div class="nav-top-bot">
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>首頁</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>最新消息</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>房型介紹</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>關於我們</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>活動商城</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>伴手禮商城</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>媒體報導</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div" >
								<p>會員中心</p>
							</div>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

	<body>
		<div class="body1">
        <div class="name">吳永志</div>
        
        <div class="avatardiv">
            <img src="${pageContext.request.contextPath}/images/camera.png" alt="">
        </div>
		</div>
    </body>

	<aside>
		<ul >
			<li>
				<a href="" class="p1"> 
					<div class="p1div">
						<p>會員資料</p>
					</div>
				</a>
			</li>

		<li>
			<a href="" class="p2"> 
				<div class="p2div">
					<p>資料管理</p>
				</div>
			</a>
		</li>

		<li>
			<a href="" class="p5"> 
				<div class="p5div">
					<p>訊息通知</p>
				</div>
			</a>
		</li>

		<li>
			<a href="" class="p6"> 
				<div class="p6div">
					<p>查看住宿訂單</p>
				</div>
			</a>
		</li>

		<li>
			<a href="" class="p7"> 
				<div class="p7div">
					<p>查看活動訂單</p>
				</div>
			</a>
		</li>

		<li>
			<a href="${pageContext.request.contextPath}/front_end/membersorders/Member_home_page.jsp" class="p8"> 
				<div class="p8div">
					<p>查看商品訂單</p>
				</div>
			</a>
		</li>
	</ul>
</aside>
<main id="main">
	<div id="tableall2">
		<h1 >購物訂單</h1>
			<table id="table-2">
			<tr>
				<th>訂單編號</th>
				<th>會員編號</th>
				<th>訂購日期</th>
				<th>購買數量</th>
				<th>付款方式</th>
				<th>訂單狀態</th>
				<th>查看詳情</th>
				<th>取消訂單</th>

			</tr>

			
			
			<%
			List<Product_order_detailVO> listOrder_ByCompositeQuery = (List<Product_order_detailVO>)request.getAttribute("listOrders_byCompsiteQuery");
			pageContext.setAttribute("listOrder_ByCompositeQuery", listOrder_ByCompositeQuery);
			%>
			<c:forEach var="eachOrderListVO" items="${listOrder_ByCompositeQuery}" 
				varStatus="d">
				<tr>
					<td>${eachOrderListVO.product_order_id}</td>
					<td>${eachOrderListVO.member_id}</td>
					<td><fmt:formatDate
							value="${eachOrderListVO.product_order_date}"
							pattern="yyyy-MM-dd" /></td>
					<td>${eachOrderListVO.getProduct_amount()}</td>
					<c:set var="method" value="${eachOrderListVO.payment_method}" />
					<c:if test="${method == 0}">
						<td>信用卡</td>
					</c:if>
					<c:if test="${method == 1}">
						<td>現場付款</td>
					</c:if>

					<c:set var="status" value="${eachOrderListVO.order_status}" />
					<c:if test="${status == 0}">
						<td>已付款</td>
					</c:if>
					<c:if test="${status == 1}">
						<td>完成</td>
					</c:if>
					<c:if test="${status == 2}">
						<td>取消</td>
					</c:if>

					<td>
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/Product_order_detailServlet"
							style="margin-bottom: 0px; position:relative;width:20px;">
							<input class="information" type="submit" name="action" value="查看詳情" style="border:1px solid black; cursor:pointer; border-radius:5px; background-color:white; color:gray; font-size:19px; position:relative; left:15px">
							<input type="hidden" name="product_order_listID" value="${eachOrderListVO.product_order_id}">
						</FORM>
					</td>
					<td>
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/Product_order_detailServlet"
							style="margin-bottom: 0px; width:20px;">
							<input class="delete" type="submit" name="action" value="取消" style="border:1px solid black; cursor:pointer; border-radius:5px;background-color:white; color:gray; font-size:19px; position:relative; left:30px">
							<input type="hidden" name="product_order_listID" value="${eachOrderListVO.product_order_id}">
						</FORM>
					</td>
				</tr>
			</c:forEach>
			
		</table>
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