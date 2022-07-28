<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity_join.model.ActivityJoinVO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/front_ActivityDetails_Pay.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <title>活動付款</title>
</head>
<body  onload="connect();" onunload="disconnect();">
<!--   <header> -->
<!--     <nav> -->
<%--       <img class="nav-logo" src="<%=request.getContextPath()%>/images/logo.png" alt=""> --%>
<!--       <table class="weather-div"> -->
<!--         <tbody class="weather-tbody"> -->
<!--           <tr class="weather-tr"> -->
<!--           </tr> -->
<!--           <tr class="weather-tr-1"> -->
<!--           </tr> -->
<!--         </tbody> -->
<!--       </table> -->
<!--       <div class="icon"></div> -->
<%--       <img class="nav-top-img" src="<%=request.getContextPath()%>/images/wheather.png" alt=""> --%>
<!--       <a href="" class="text">會員登入/註冊</a> -->
<!--       <a href="" class="nav-top-a"> -->
<%--         <img class="nav-top-img-1" src="<%=request.getContextPath()%>/images/shopping-cart.png" alt=""> --%>
<!--       </a> -->
<!--       <div class="nav-top-bot"> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>首頁</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>最新消息</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>房型介紹</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>關於我們</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>活動商城</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>伴手禮商城</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>媒體報導</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--         <ul class="nav-ul-bot"> -->
<!--           <li class="nav-li"> -->
<!--             <a href="" class=""> -->
<!--               <div class="nav-left-div"> -->
<!--                 <p>會員中心</p> -->
<!--               </div> -->
<!--             </a> -->
<!--           </li> -->
<!--         </ul> -->
<!--       </div> -->
<!--     </nav> -->
<!--   </header> -->
<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
  <main class="detail_list">
    <span class="confirm-words">報名活動資料確認</span>
    <div class="display-area">
      <div style="position: absolute;top:70px ;">
      
      
   <div style="	background-color: rgb(255, 255, 255);color: black;">會員姓名:&nbsp;&nbsp;${memberVO.member_name}</div><br><br>
      <div>活動名稱:&nbsp;&nbsp;${activityJoinVO.activityName}</div><br><br>
      <div>活動開始時間:&nbsp;&nbsp;<fmt:formatDate value="${activityJoinVO.activitySessionStart}" pattern="yyyy-MM-dd HH:mm" /></div><br><br>
      <div>活動結束時間:&nbsp;&nbsp;<fmt:formatDate value="${activityJoinVO.activitySessionEnd}" pattern="yyyy-MM-dd HH:mm" /></div><br><br>
      <div>報名人數:&nbsp;&nbsp;${activityJoinVO.enrollNumber}人</div><br><br>
      <div>訂單金額:&nbsp;&nbsp;${activityJoinVO.orderAmount}元</div><br>
      <div style="position: relative;top: 10px;">活動備註:<input type="text" id="orderMemo" name="orderMemo" maxlength="50" placeholder="若有特殊需求請寫備註(請勿超過50字)" style="border: 1px solid black; height: 70px; width: 500px; margin: 20px 0px;"></div>
     
     
     </div>
    </div>

    <div class="container">
      <div class="card-container">
        <div id="front">
          <div class="image">
            <img src="<%=request.getContextPath()%>/images/chip.png" alt="">
            <img src="<%=request.getContextPath()%>/images/visa.png" alt="">
          </div>
          <div id="card-number-box">&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;-&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;-&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;-&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;-</div>
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
            <span style="position: relative; top: -4px;">cvv</span>
            <div id="cvv-box"></div>
            <img src="<%=request.getContextPath()%>/images/visa.png" alt="">
          </div>
        </div>
      </div>

      <form id="formm" action="<%=request.getContextPath()%>/activityJoin/activityJoin.do" method="post">
      <input type="hidden" name="action" value="insert_2"> 
        <div class="inputBox">
          <span>信用卡卡號</span>
          <input type="number" maxlength="16" id="card-number-input">
        </div>
        <div class="inputBox">
          <span>姓名</span>
          <input type="text" id="card-holder-input">
        </div>
        <div class="flexbox">
          <div class="inputBox">
            <span>到期年</span>
            <select name="" id="year-input" class="year-input">
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
            <select name="" id="month-input" class="month-input">
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
            <span style="position: relative;top: -3px;">cvv</span>
            <input type="number" maxlength="4" id="cvv-input" >
          </div>
        </div>
        <input type="hidden" name="orderMemo" id="orderMemo_sub" value="">
        <input type="button" value="submit" class="submit-btn" onclick="return creditcart();">
      </form>
   
  </main>
  
  <footer>
    <div>
      <p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
      <p>DREAMCENTER</p>
    </div>
  </footer>
  <script src="${pageContext.request.contextPath}/js/date.js"></script>
  <script src="${pageContext.request.contextPath}/js/weather.js"></script>
  <script src="${pageContext.request.contextPath}/js/icon.js"></script>
  <script src="${pageContext.request.contextPath}/js/hidden.js"></script>
  
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


//     $(".submit-btn").click(function(){
//     	const orderMemo = $('<input>')
//         .attr('type', 'hidden')
//         .attr('name', 'orderMemo')
//         .val($('#orderMemo').val());


// 		$('#formm')
// 		.append(orderMemo)
// 		.submit();
//     })
  </script>

<script>
  function creditcart() {
   const year = document.querySelector("#year-input");
   const month = document.querySelector("#month-input");
   const card = document.querySelector("#card-number-input");
   const name = document.querySelector("#card-holder-input");
   const cvv = document.querySelector("#cvv-input");
   if (cvv.value === '') {
//     alert("請輸入安全碼");
    swal("請輸入安全碼", "", "warning");
   }
   if (month.value === "month") {
//     alert("請選擇到期月");
    swal("請選擇到期月", "", "warning");
   }
   if (year.value === "year") {
//     alert("請選擇到期年");
    swal("請選擇到期年", "", "warning");
   }
   if (name.value === '') {
//     alert("請輸入姓名");
    swal("請輸入姓名", "", "warning");
   }
   if (card.value === '') {
//     alert("請輸入信用卡號碼");
    swal("請輸入信用卡號碼", "", "warning");
   }
   
   if (card.value !== '' && name.value !== '' && year.value !== "year"
     && month.value !== "month" && cvv.value !== '') {
	   	document.querySelector('#orderMemo_sub').value = document.querySelector('#orderMemo').value;
    	document.querySelector("#formm").submit();
    return true;

   }
  }
  
 </script>
</body>

</html>