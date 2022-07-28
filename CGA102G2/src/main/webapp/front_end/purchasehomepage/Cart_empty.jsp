<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%

 	
	/* Product_VO poVO = (Product_VO)(request.getAttribute("poVo")); */ /* 取得該筆產品 */
	
	/* Integer amounts = (Integer)request.getAttribute("amounts"); */  /* 取得數量 */
	
	/* 該筆訂單  */
	/* Product_order_detailVO podVO = (Product_order_detailVO)request.getAttribute("podVO");
	pageContext.setAttribute("podVO", podVO);
	pageContext.setAttribute("poVO", poVO);
	pageContext.setAttribute("amounts", amounts); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	<script src="./jquery.js"></script>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/payment.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/headerByD.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Cart.css">
<style>
.accordion{
	
	
}



</style>
</head>
<body  onload="connect();" onunload="disconnect();">

<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
  
  <main class="detail_list">
  

<%-- <%if (buylist != null && (buylist.size() > 0)) {%> --%>

<div class="car_table1" >
 <font size="+2">全部商品()</font>
	<p size="+2">購物車是空的欸...</p>



				



</div>
  </main>
  	
  
  <footer>
    <div>
      <p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
      <p>DREAMCENTER</p>
    </div>
    
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
    
    
  </footer>

  



  
 <script>
   /*  document.querySelector('#card-number-input').oninput = () => {
      document.querySelector('#card-number-box').innerText = document.querySelector('#card-number-input').value;
    }

    document.querySelector('#card-holder-input').oninput = () => {
      document.querySelector('#card-holder-name').innerText = document.querySelector('#card-holder-input').value;
    }

    document.querySelector('.month-input').oninput = () => {
      document.querySelector('.exp-month').innerText = document.querySelector('.month-input').value;
    }

    document.querySelector('.year-input').oninput = () => {
      document.querySelector('.exp-year').innerText = document.querySelector('.year-input').value;
    }

    document.querySelector('#cvv-input').onclick = () => {
      document.querySelector('#front').style.transform = 'perspective(1000px) rotateY(180deg)';
      document.querySelector('#back').style.transform = 'perspective(1000px) rotateY(0deg)';
    }

    document.querySelector('#cvv-input').onblur = () => {
      document.querySelector('#back').style.transform = 'perspective(1000px) rotateY(180deg)';
      document.querySelector('#front').style.transform = 'perspective(1000px) rotateY(0deg)';
    }

    document.querySelector('#cvv-input').oninput = () => {
      document.querySelector('#cvv-box').innerText = document.querySelector('#cvv-input').value;
    }
    document.querySelector('#cr').onclick = () => {
        document.querySelector('#front').style.visibility = "visible";
        document.querySelector('#back').style.visibility = "visible";
        document.querySelector('form').style.visibility = "visible";
        document.querySelector('.info').style.height = '961px';
        document.querySelector('.submit-top').style.visibility = 'hidden';
        document.querySelector('footer').style.bottom = '-1200px';

    }
     document.querySelector('#cash').onclick = () => {
        document.querySelector('#front').style.visibility = "hidden";
        document.querySelector('#back').style.visibility = "hidden";
        document.querySelector('form').style.visibility = "hidden";
        document.querySelector('.info').style.height = '400px';
        document.querySelector('.submit-top').style.visibility = 'visible';
    } */ 

  </script>
<script src="${pageContext.request.contextPath}/js/date.js"></script>
  <script src="${pageContext.request.contextPath}/js/weather.js"></script>
  <script src="${pageContext.request.contextPath}/js/hidden.js"></script>
  <script src="${pageContext.request.contextPath}/js/icon.js"></script>
 <%--  <script src="${pageContext.request.contextPath}/js/Oneproduct.js"></script> --%>
 <%-- <script src="${pageContext.request.contextPath}/js/page.js"></script> --%>
</body>
</html>