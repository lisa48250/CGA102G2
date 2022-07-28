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

System.out.println("成功轉來這裡");
Product_Service posvc = new Product_Service();
Product_VO poVO = null;
/* List<Product_pics_VO> ppVOList = null; */
List<Product_VO> povoList = posvc.getAll();

for (Product_VO povo : povoList) {
	if (povo.getProduct_name().equals("黑白曲奇餅")) {
		poVO = povo;
	}
}
pageContext.setAttribute("poVO", poVO);
System.out.println(poVO.getProduct_id());
Product_pics_Service ppsvc = new Product_pics_Service();
List<Product_pics_VO> ppVOList = ppsvc.getAllPicsbyId(poVO.getProduct_id());
pageContext.setAttribute("ppVOList", ppVOList);
System.out.println(ppVOList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Oneprodct.css">
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
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
      <a href="${pageContext.request.contextPath}/front_end/purchasehomepage/Cart.jsp" class="nav-top-a">
        <img class="nav-top-img-1" src="${pageContext.request.contextPath}/images/shopping-cart.png" alt="">
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
            <a href="${pageContext.request.contextPath}/front_end/purchasehomepage/PurchaseHomePage.jsp" class="">
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
              <div class="nav-left-div">
                <p>會員中心</p>
              </div>
            </a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  
  <main>
    <div id="product-aside">
    <c:forEach var="eachPhoto" items="${ppVOList}">
      <img id="product-img1" src="<%=request.getContextPath()%>/prodpics_reader?product_photo_id=${eachPhoto.product_photo_id}" onclick='changes("${pageContext.request.contextPath}/prodpics_reader?product_photo_id=${eachPhoto.product_photo_id}")'>
      </c:forEach>
    </div>



    <img id="photo" src="${pageContext.request.contextPath}/Product_reader?product_id=${poVO.product_id}">

  </main>
  <div class="product-title-all">
    <h1 class="product-name" name="product-name" value="<%=poVO.getProduct_name()%>"><%=poVO.getProduct_name()%></h1>
    <div class="product-content">
      <h2>商品詳情</h2>
      <p>選用紐西蘭天然發酵奶油 香濃酥綿入口即化</p>
      健康配比　嚴選極品
      減油、減糖、無添加， 良心用料， 食安為上。
      烘焙美學，極致御賞
      獨特口味卓然出眾，更在包裝上呈現視覺美感幸福品味，自賞送禮都能達到味蕾饗宴與窩心溫度。
    </div>
    <h1 class="hr1"></h1>
    <form method="post" action="${pageContext.request.contextPath}/CartServlet">
      <span id="number-text">數量:</span>
      <div class="select-area">
        <span class="down" onclick='decreaseCount(event, this)'><img class="arrow-pic" src="${pageContext.request.contextPath}/images/arrow-down-sign-to-navigate.png"></span>
        <input  id="input-amount" type="number" name="input-amounts" value="1">
        
        <span class="up" onclick='increaseCount(event, this)'><img class="arrow-pic" src="${pageContext.request.contextPath}/images/navigate-up-arrow.png"></span>
      </div> 
      <div class="purchase-area">
        <input type="hidden" name="action" value="buy_now"> 
        <input type="hidden" name="productId" value="<%=poVO.getProduct_id()%>">
        <input type="hidden" name="product_describtion" value="<%=poVO.getProduct_describtion()%>">
        <input type="hidden" name="product_price" value="<%=poVO.getProduct_price()%>">
        <input type="hidden" name="product_name" value="<%=poVO.getProduct_name()%>">
        <!-- <input class="purchase-btn" name="payNow" type="submit" value="前往付款"> -->
        <input class="addcar-btn" name="goCar" type="submit"  value="加入購物車">
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

  <script src="${pageContext.request.contextPath}/js/date.js"></script>
  <script src="${pageContext.request.contextPath}/js/weather.js"></script>
  <script src="${pageContext.request.contextPath}/js/hidden.js"></script>
  <script src="${pageContext.request.contextPath}/js/icon.js"></script>
  <script src="${pageContext.request.contextPath}/js/Oneproduct.js"></script>
</body>
</html>