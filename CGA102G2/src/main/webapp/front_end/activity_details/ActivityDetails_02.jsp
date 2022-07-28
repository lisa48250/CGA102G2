<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity_join.model.*"%>

<%
ActivityJoinVO activityJoinVO = (ActivityJoinVO) request.getAttribute("activityJoinVO");
%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>日本和服體驗</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/front_ActivityDetails.css">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<style>
.ui-datepicker {
	width: 360px;
}

.ui-datepicker table {
	width: 100%;
	font-size: 20px;
	border-collapse: collapse;
	margin: 0 0 0.4em;
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
<!-- 					<li class="nav-li"><a href="" class=""> -->
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
<%-- 					<li class="nav-li"><a href="${pageContext.request.contextPath}/front_end/activity/view_activity_page.jsp" class=""> --%>
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
<%-- 					<li class="nav-li"><a href="${pageContext.request.contextPath}/front_end/newspost/NewsPost.jsp" class=""> --%>
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
	<!-- ======================main區======================== -->

	<main>
		<div class="maindiv">
			<div class="div1">
				<img class="head-img" src="<%=request.getContextPath()%>/images/02和服首頁.jpg">
				<div class="slide-down">
					<p>日本和服體驗</p>
				</div>
			</div>

	<FORM id="form"
				action="<%=request.getContextPath()%>/activityJoin/activityJoin.do"
				method="post">
				<div class="sticky">
					<div class="div2">
						<p class="p1">NT.&nbsp;&nbsp;2500 元/人</p>
					</div>
					<div class="date" style="left: 40px; top: 60px">
						<div id="datepicker" style="width: 360px;"></div>
					</div>
					<div class="div4">
						<p class="p4">參加人數</p>
						<input class="number"  onKeyDown="return false" type="number" value="1" min="1" max="20"
							name="enrollNumber">
						<p class="p6">人</p>
						<button id="submitBtn" class="button1">報名活動</button>
					</div>
					<input type="hidden" name="action" value="insert_1"> 
					<input type="hidden" name="activityID" value="2">
					<input type="hidden" name="activitySessionDate" id="activitySessionDate">
				</div>
	</FORM>
		
		<div class="href">
			<a class="href2" href="<%=request.getContextPath()%>/front_end/frontpage/FrontPage.jsp">首頁
				> </a> <a class="href3"
				href="<%=request.getContextPath()%>/front_end/activity/view_activity_page.jsp">活動 > </a>
			<p class="href4">活動詳情</p>
		</div>


		<div class="div5">
			<div class="div6">
				<img class="img0"
					src="<%=request.getContextPath()%>/images/black.jpg">
				<p class="p7">日本和服體驗</p>
				<p class="p8">活動期間:</p>
				<p class="p9">2022/08/01 ~ 2022/08/31</p>
				<hr class="div1hr">
			</div>
			<p class="p10">&nbsp; &nbsp;
				&nbsp;和服代表著日本傳統文化，穿和服體驗也是非常夯的行程，一旦換上和服裝扮後，自己彷彿也注入了日本女孩的靈魂，伴隨著紛飛的櫻花，漫步在飯店周遭。</p>
			<img class="img1" src="<%=request.getContextPath()%>/images/activity2.jpg">
		

			<hr class="phr">
			<p class="p11">課程內容</p>
			<p class="p11-1">
				<br>1.在和服內穿上裡衣「肌襦袢」，用「腰捲」包覆，接著腳上套上「足袋」。
				<br>2.穿上第二件裡衣「長襦袢」，這第二件裡衣像是保護層，避免流汗破壞和服的布料。 
				<br>3.穿上外層的和服，多出來的衣服上挪，利用「帶揚」繫在腰下方，然後用腰帶繫在腰上，拿出一條很長的「袋板」以打結方式繫上「袋枕」。
				<br>4.最後完成裝飾的「袋蒂」。 
				<br>5.留下永恆留念的照片。
		
			</p>
	
			<div class="div7">
				<p class="p12">
					<span >活動資訊：</span>
					<br>1.活動報名時間為7/1~8/18。 
					<br>2.本活動僅供7歲以上貴賓報名參加(7歲以下兒童可陪同父母，但無法參與活動)，7歲~13歲兒童需成人陪同才可參加活動。
					
				</p>
			</div>
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


	<script type="text/javascript"></script>
	<script>
	let minDate; 
	let maxDate = new Date(2022, 7, 31);
	debugger;
	if(new Date().getTime() < new Date(2022, 6, 22).getTime()){
    	 minDate = new Date(2022, 7, 1);
    } else {
    	 minDate = "+7d";
    }
	console.log(minDate);
	console.log(maxDate);
    $("#datepicker").datepicker({
    	dateFormat: 'yy-mm-dd',
        firstDay: 1,
        beforeShowDay: date => {
            const day = date.getDay();
            return [day === 0 || day === 6];
        },
        onSelect: date => $("#activitySessionDate").val(date),
        minDate: minDate,
        maxDate: maxDate
    });
    
    $("#submitBtn").click(function(){
    	   var a = jQuery("#activitySessionDate").val();
    	   if(jQuery.trim(a) == ""){
//     	      alert("請選擇活動日期");
	swal("請選擇活動日期", "", "warning");
    	      return false;
    	   }else{
    	$("#form").submit();
  	   }
})
    </script>
</body>

</html>

