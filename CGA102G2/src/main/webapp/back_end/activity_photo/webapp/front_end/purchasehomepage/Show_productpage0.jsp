<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="d.com.productpics.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
// Product_Service posvc = new Product_Service();
// Product_VO poVO = null;
// /* List<Product_pics_VO> ppVOList = null; */
// List<Product_VO> povoList = posvc.getAll();

// for (Product_VO povo : povoList) {
// 	if (povo.getProduct_name().equals("幸福茶葉包")) {
// 		poVO = povo;
// 	}
// }
Product_VO poVO = (Product_VO)request.getAttribute("poVO");
Product_pics_Service ppsvc = new Product_pics_Service();
System.out.println(poVO.getProduct_id());
List<Product_pics_VO> ppVOList = ppsvc.getAllPicsbyId(poVO.getProduct_id());
pageContext.setAttribute("ppVOList",ppVOList); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳情</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Oneprodct.css">
<!--   <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script> -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body  onload="connect();" onunload="disconnect();">
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
  
 <main>
   <div id="product-aside">
      <c:forEach var="eachPhoto" items="${ppVOList}">
      <img id="product-img1" src="<%=request.getContextPath()%>/prodpics_readerD?product_photo_id=${eachPhoto.product_photo_id}" onclick='changes("${pageContext.request.contextPath}/prodpics_reader?product_photo_id=${eachPhoto.product_photo_id}")'>
      </c:forEach>
    </div>



    <img id="photo" src="${pageContext.request.contextPath}/Product_reader?product_id=<%=poVO.getProduct_id()%>">

  </main>
  <div class="product-title-all">
    <h1 class="product-name" name="product_name" value="${poVO.product_name }">${poVO.product_name }</h1>
<%--     <h1 class="product-name" name="product-name" value="${prodVO.product_name }">${prodVO.product_name }</h1> --%>
    <div class="product-content">
      <h2>商品詳情</h2>
      <p>${poVO.product_describtion }</p>
      <!-- 這段文字再評估如何處理 -->
   <%--   <p><%=poVO.getProduct_describtion().substring(0, poVO.getProduct_describtion().indexOf(";"))%></p>
     	<%=poVO.getProduct_describtion().substring(poVO.getProduct_describtion().substring(0, poVO.getProduct_describtion().indexOf(";")).length()+1, poVO.getProduct_describtion().length())%> --%>
    </div>
    <h1 class="hr1"></h1>
    <form class="deleteForm" method="post" action="${pageContext.request.contextPath}/CartServlet">
      <span id="number-text">數量:</span>
      <div class="select-area">
        <span class="down" onclick='decreaseCount(event, this)'><img class="arrow-pic" src="${pageContext.request.contextPath}/images/arrow-down-sign-to-navigate.png"></span>
        <input  id="input-amount" type="number" name="product_amount" value="1">
        <span class="up" onclick='increaseCount(event, this)'><img class="arrow-pic" src="${pageContext.request.contextPath}/images/navigate-up-arrow.png"></span>
      </div>
      <div class="purchase-area">
        <input type="hidden" name="action" value="buy_now"> 
        
<%--         <input type="hidden" name="productId" value="${prodVO.product_id }"> --%>
         <input type="hidden" name="productId" value="<%=poVO.getProduct_id()%>">
        <input type="hidden" name="product_describtion" value="<%=poVO.getProduct_describtion()%>">
        <input type="hidden" name="product_price" value="<%=poVO.getProduct_price()%>">
        <input type="hidden" name="product_name" value="<%=poVO.getProduct_name()%>">
        
<!--         <input class="purchase-btn" name="payNow" type="submit" value="前往付款"> -->
<!--         <input class="addcar-btn" name="goCar" type="submit"   value="加入購物車"> -->
        
        <button class="delete" id="addcar-btn" name="goCar" value="加入購物車">加入購物車</button>
        <!-- <input class="purchase-btn" name="actionA" type="submit" value="buy_now">
		
<!--         <input class="addcar-btn" name="actionA" type="submit"   value="goCar"> --> 
        
<!--        <input class="purchase-btn" name="actionA"" type="submit" value="payNow"> --> 
        <!-- <input type="hidden" name="action" value="order-list">
        <input type="hidden" name="action" value="car-list"> -->
      </div>
    </form>
  </div>


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
  <script src="${pageContext.request.contextPath}/js/date.js"></script>
  <script src="${pageContext.request.contextPath}/js/weather.js"></script>
  <script src="${pageContext.request.contextPath}/js/hidden.js"></script>
  <script src="${pageContext.request.contextPath}/js/icon.js"></script>
  <script src="${pageContext.request.contextPath}/js/Oneproduct.js"></script>
  <script>
$(".delete").click(function(e){
	 e.preventDefault();
	 let that = $(this);
	  swal({
 	     title: "成功加入!",
	     icon: "success",
	     showConfirmButton: false,
	     timer: 1500
// 	     buttons: {
// 	         Btn: false,
// 	         cancel: {
// 	           text: "取消",
// 	           visible: true
// 	         },
// 	         confirm: {
// 	           text: "確定",
// 	           visible: true
// 	         }
// 	       }
	  }).then(function(value) {
	   if(value) {
		  $(that).closest('.deleteForm').submit();
	   }
	  });
	})
</script>
</body>
</html>