<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="com.members.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	
		
	HttpSession session11 = request.getSession();
MemberVO memberVO = (MemberVO)session11.getAttribute("memberVO");
 	
	Product_VO poVO = (Product_VO)(request.getAttribute("poVo")); /* 取得該筆產品 */
	
	Integer amounts = (Integer)request.getAttribute("amounts");  /* 取得數量 */
	
	/* 該筆訂單  */
	Product_order_detailVO podVO = (Product_order_detailVO)request.getAttribute("podVO");
	pageContext.setAttribute("podVO", podVO);
	pageContext.setAttribute("poVO", poVO);
	pageContext.setAttribute("amounts", amounts);
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
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/payment.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/headerByD.css">
<style>
#card-number-input:hover{
	border: 3px solid #5B5B5B;
}
#card-holder-input:hover{
	border: 3px solid #5B5B5B;
}


#product-aside>img {
  /* display: inline-block; */
  height: 50px;
  width: 70px;
  filter: brightness(0.8);
  border: 0.5px solid #757575;
}

#product-aside>img:hover {
  border: 0px;
  filter: brightness(1.2);

}
#photo{
  /* border: 2px solid red; */
  filter: brightness(0.8);
  position: relative;
  left: 60px;
  top: 100px;
  width: 450px;
  height: 300px;
  display: inline-block;

}
#photo:hover{
	border: 0px;
  	filter: brightness(1);
}
.information{
	
	position:relative;
	top:120px;
	width:450px;
	height:100px;
	left:60px;
	font-size:22px;
}



</style>
</head>
<body  onload="connect();" onunload="disconnect();">
 
<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
  
  <main class="detail_list">
    <%-- <span class="confirm-words">商品訂單</span>
    <div class="display-area">
      <span class="span">會員編號</span><span class="display-data">${podVO.member_id}</span><br>
      <span class="span">商品名稱</span><span class="display-data"><%=poVO.getProduct_name()%></span><br>
      <span class="span">商品數量</span><span class="display-data">${amounts}</span><br>
      <span class="span">商品單價</span><span class="display-data"><%=poVO.getProduct_price()%></span><br>
      <span class="span">總價</span><span class="display-data">${amounts * poVO.product_price}</span><br>
    </div> --%>
    
   <!-- 顯示該商品圖片 -->
   <div id="Allphoto">
    <img id="photo" src="${pageContext.request.contextPath}/Product_reader?product_id=<%=poVO.getProduct_id()%>">
    </div>
    <div class="information">
    <h2>商品介紹</h2>
      <p style="color:orange;"><%=poVO.getProduct_describtion().substring(0, poVO.getProduct_describtion().indexOf(";"))%></p>
      <%=poVO.getProduct_describtion().substring(poVO.getProduct_describtion().substring(0, poVO.getProduct_describtion().indexOf(";")).length()+1, poVO.getProduct_describtion().length())%>
      
     </div>
    <div class="info">
			<div class="accordion" id="accordionExample">
				<div class="accordion-item">
					<h2 class="accordion-header" id="headingOne">
						<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							<span>①您的商品詳情</span>
						</button>
					</h2>
					<div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<div class="info-1">
								會員編號:<input type="text"  class="p" name="phoneNumber" disabled value="${memberVO.member_id}"><br>
								商品名稱:<input type="text"  placeholder="" class="n" name="firstName" disabled value="<%=poVO.getProduct_name()%>"><br>
								商品單價:<input type="text"  class="t" name="lastName" disabled value="<%=poVO.getProduct_price()%>"><br>
								商品數量:<input type="text"  class="m" name="e-mail" disabled value="${amounts}"><br>
								<span style="margin-left:200px">總價</span><span style="color:red;"> $${amounts * poVO.product_price}</span>
							</div>
						</div>
					</div>
				</div> 
				<div class="accordion-item">
					<h2 class="accordion-header" id="headingTwo">
						<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
							<span>付款方式</span>
						</button>
					</h2>
					<div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
						<div class="accordion-body">
						
							<div class="container">
								<h1 class="cho">請選擇付款方式:</h1>
								
								<!-- 針對現金流 -->
								<div class="cah">
									<%--  <form action="${pageContext.request.contextPath}/Product_order_detailServlet" class="form-1"> --%>  
									<label for="cash" id="cashlabel">現金付款</label>
									<input type="radio"   id="cash"  name="same">
									<label for="cr" id="crlabel">信用卡付款</label>
									<input type="radio"  id="cr" name="same">
									<%-- <form action="${pageContext.request.contextPath}/Product_order_detailServlet"> --%> 
									<input type="submit" value="送出訂單" class="submit-top" >
									<input type="hidden" name="action" value="選擇現金付款">
									<input type="hidden" name="product" value="${poVO}">
									<input type="hidden" name="amounts" value="${amounts}">
									 <!-- </form> -->
								</div>
								<div class="card-container">
								
								
									<div id="front">
										<div class="image">
											<img src="${pageContext.request.contextPath}/images/chip.png" alt="">
											<img src="${pageContext.request.contextPath}/images/visa.png" alt="">
										</div>
										<div id="card-number-box">################</div>
										<div class="flexbox">
											<div class="box">
												<span>姓名</span>
												<div id="card-holder-name">card holder</div>
											</div>
											<div class="box">
												<span>到期日</span>
												<div class="expiration">
													<span class="exp-year">yy</span>
													<span class="exp-month">mm</span>
												</div>
											</div>
										</div>
									</div>

									<div id="back">
										<div class="stripe"></div>
										<div class="box">
											<span>cvv</span>
											<div id="cvv-box"></div>
											<img src="${pageContext.request.contextPath}/images/visa.png" alt="">
										</div>
									</div>

								</div>
									
									<form action="${pageContext.request.contextPath}/Product_order_detailServlet">
									<div class="inputBox">
										<span>信用卡卡號</span>
										<input type="text" maxlength="16" id="card-number-input">
									</div>
									<div class="inputBox">
										<span>姓名</span>
										<input type="text" id="card-holder-input" name="input-name" value="">
									</div>
									<div class="flexbox">
										<div class="inputBox">
											<span>到期年</span>
											<select name="" id="" class="year-input">
												<option value="year" selected disabled>請選擇</option>
												<option value="2021">2021</option>
												<option value="2022">2022</option>
												<option value="2023">2023</option>
												<option value="2024">2024</option>
												<option value="2025">2025</option>
												<option value="2026">2026</option>
												<option value="2027">2027</option>
												<option value="2028">2028</option>
												<option value="2029">2029</option>
												<option value="2030">2030</option>
											</select>
										</div>
										<div class="inputBox">
											<span>到期月</span>
											<select name="" id="" class="month-input">
												<option value="month" selected disabled>請選擇</option>
												<option value="01">01</option>
												<option value="02">02</option>
												<option value="03">03</option>
												<option value="04">04</option>
												<option value="05">05</option>
												<option value="06">06</option>
												<option value="07">07</option>
												<option value="08">08</option>
												<option value="09">09</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
											</select>
										</div>
										<div class="inputBox">
											<span>cvv</span>
											<input type="text" maxlength="4" id="cvv-input">
										</div>
									</div>
									
									<input type="hidden" value="${poVO.product_id}" name="productId">
									<input type="hidden" value="${amounts}" name="amounts">
									<input type="hidden" name="action" value="來自信用卡付款">
									<input type="submit" value="付款" class="submit-btn">
									</form>
							</div>
							
						</div>
							
					</div>
				</div>
				
      <!-- <form class="client-input-area">
      sadsdad<input>
      sadd<input>
      das<input>
      dasda<input>
     asdsa <input>
    </form> -->
  </main>
  	
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
  <footer>
    <div>
      <p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
      <p>DREAMCENTER</p>
    </div>
  </footer>

  



  
  <script>
    document.querySelector('#card-number-input').oninput = () => {
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
    } 

  </script>
<script src="${pageContext.request.contextPath}/js/date.js"></script>
  <script src="${pageContext.request.contextPath}/js/weather.js"></script>
  <script src="${pageContext.request.contextPath}/js/hidden.js"></script>
  <script src="${pageContext.request.contextPath}/js/icon.js"></script>
 <%--  <script src="${pageContext.request.contextPath}/js/Oneproduct.js"></script> --%>
 <%-- <script src="${pageContext.request.contextPath}/js/page.js"></script> --%>
</body>
</html>