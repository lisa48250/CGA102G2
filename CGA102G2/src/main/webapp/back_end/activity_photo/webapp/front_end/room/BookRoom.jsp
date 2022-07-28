<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="h.com.room_type_photo.model.*"%>
<%@ page import="java.util.*"%>
<%
/* request.getAttribute(room_typeVO); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bookroom.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<%-- 	<script src="${pageContext.request.contextPath}/js/jquery.js"></script> --%>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.js"></script>
<script src="${pageContext.request.contextPath}/js/page.js"></script>
<script>
	$.datetimepicker.setLocale("zh"); // kr ko ja en
	$(function() {
		
	
		$("#start_date").datetimepicker(
				{
					minDate : "-1970-01-01",
					format : "Y-m-d",
					onShow : function() {
						if ($("#end_date").val() === "") {
							this.setOptions({
								maxDate : $("#end_date").val() ? $("#end_date")
										.val() : false
							});
						} else {
							maxDate: $("#end_date").val() === "";
						}
					},
					timepicker : false
				});
		$('#end_date')
				.datetimepicker(
						{
							format : 'Y-m-d',
							onShow : function() {
								let start = Date.parse(document
										.querySelector("#start_date").value) + 86400000 * 32;
								let date = new Date(start);
								let startdate = date.getFullYear() + '-'
										+ date.getMonth() + '-'
										+ date.getDate();
								console.log(startdate);
								this
										.setOptions({
											minDate : $('#start_date').val() ? startdate
													: false
										})
							},
							timepicker : false
						});
		$('#start_date').datetimepicker({
			scrollMonth : false,
			scrollInput : false
		});
		$('#end_date').datetimepicker({
			scrollMonth : false,
			scrollInput : false
		});

	});
</script>
<script>
	$(document).ready(function() {
		const room_type_id = document.querySelector("#room_type_id");

		if (room_type_id.value === "1") {
			$("#select1 option:gt(2)").hide();
		} else {
			$("#select1 option:gt(2)").show();
		}

	});
</script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>
</head>
<body  onload="connect();" onunload="disconnect();">
	<%@ include file="/front_end/frontpage/IncludeHeader.jsp" %>
	<main>
		<div class="date">
			<FORM METHOD="post"
				ACTION="${pageContext.request.contextPath}/SearchRoom">
				<span>選擇日期</span> <label for="start_date" class="checkin">入住日期:</label>
				<input name="start_date" id="start_date" type="text"
					autocomplete="off" onkeydown="return false"> <label
					for="end_date" class="checkout">退房日期:</label><input name="end_date"
					id="end_date" type="text" autocomplete="off"
					onkeydown="return false"> <input class="serach"
					type="submit" value="搜尋空房 "> <select class="roomcount"
					name="select">
					<!-- 			{param}取得到是因為用forward把參數帶到下一個頁面,在input欄位有加屬性name才能指定參數名稱 -->
					<option value="" style="display: none">房間</option>
					<option value="1">1間</option>
					<option value="2">2間</option>
					<option value="3">3間</option>
					<option value="4">4間</option>

				</select> <select class="person" name="select1" id="select1">
					<option value="" style="display: none">人數</option>
					<option value="1">1位</option>
					<option value="2">2位</option>
					<option value="3">3位</option>
					<option value="4">4位</option>

				</select> <input type="hidden" name="action" value="search"> <input
					type="hidden" name="room_type_id"
					value="${room_typeVO.room_type_id}" id="room_type_id">
			</FORM>
		</div>


		<div class="room">
			<h5 class="title">${room_typeVO.room_type_name}</h5>
			<h4 class="price">TWD${room_typeVO.room_type_price}</h4>
			<span class="content">${room_typeVO.room_type_content}</span> <span
				class="free">☑免費取消</span> <span class="pay">☑不需支付訂金</span>
			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">

					<div class="carousel-item active" data-bs-interval="3000">
						<img
							src="${pageContext.request.contextPath}/RoomPhotoReader?room_type_photo_id=${list1.get(0).room_type_photo_id}"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item" data-bs-interval="3000">
						<img
							src="${pageContext.request.contextPath}/RoomPhotoReader?room_type_photo_id=${list1.get(1).room_type_photo_id}"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item" data-bs-interval="3000">
						<img
							src="${pageContext.request.contextPath}/RoomPhotoReader?room_type_photo_id=${list1.get(2).room_type_photo_id}"
							class="d-block w-100" alt="...">
					</div>

				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
		<div class="info">
			<FORM METHOD="post"
				ACTION="${pageContext.request.contextPath}/InsertRoomOrder"
				id="formmm">
				<div class="accordion" id="accordionExample">
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingOne">
							<button class="accordion-button" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">
								<span>①您的詳情</span>
							</button>
						</h2>
						<div id="collapseOne" class="accordion-collapse collapse show"
							aria-labelledby="headingOne" data-bs-parent="#accordionExample">
							<div class="accordion-body">

								<div class="info-1">
									<label for="n">會員編號</label> <input type="text" class="n" id="n"
										name="member" value="${memberVO.member_id}"
										readonly="readonly"> <label for="t">會員名稱</label> <input
										type="text" class="t" id="t" name="name"
										value="${memberVO.member_name}" readonly="readonly"> <label
										for="m">電子信箱</label> <input type="text" class="m" id="m"
										name="mail" value="${memberVO.member_email}"
										readonly="readonly"> <label for="rrr">房間數量</label> <input
										type="text" class="rrr" id="rrr" value="${param.select}"
										name="rcount" readonly="readonly"> <label for="in">入住日期</label>
									<input type="text" class="in" id="in"
										value="${param.start_date}" name="checkin" readonly="readonly">
									<label for="out">退房日期</label> <input type="text" class="out"
										id="out" value="${param.end_date}" name="checkout"
										readonly="readonly"> <label for="p">人數</label> <input
										type="text" class="p" id="p" value="${param.select1}"
										name="pcount" readonly="readonly"> <label for="pho"
										class="pho">電話</label> <input type="text" class="ph" id="pho"
										name="phone" value="${memberVO.member_phone}"
										readonly="readonly"> 
										<span for="sq" class="sq">特殊要求</span>
									<textarea name="content" id="sq" cols="63" rows="8"
										style="resize: none"></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingTwo">
							<button class="accordion-button collapsed" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">
								<span>②完成預定</span>
							</button>
						</h2>
						<div id="collapseTwo" class="accordion-collapse collapse"
							aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<div class="container">
									<h1 class="cho">請選擇付款方式:</h1>
									<div class="cah">
										<label for="cash" id="cashlabel">現金付款</label> <input
											type="radio" id="cash" name="same"> <label for="cr"
											id="crlabel">信用卡付款</label> <input type="radio" id="cr"
											name="same"> <input type="submit" value="送出訂單"
											class="submit-top">
									</div>
									<div class="card-container">
										<div id="front">
											<div class="image">
												<img
													src="${pageContext.request.contextPath}/images/chip.png"
													alt=""> <img
													src="${pageContext.request.contextPath}/images/visa.png"
													alt="">
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
														<span class="exp-year">yy</span> <span class="exp-month">mm</span>
													</div>
												</div>
											</div>
										</div>
										<div id="back">
											<div class="stripe"></div>
											<div class="box">
												<span>cvv</span>
												<div id="cvv-box"></div>
												<img
													src="${pageContext.request.contextPath}/images/visa.png"
													alt="">
											</div>
										</div>

									</div>

									<div class="form">
										<div class="inputBox">
											<span>信用卡卡號</span> <input type="text" maxlength="16"
												id="card-number-input" autocomplete="off">
										</div>
										<div class="inputBox">
											<span>姓名</span> <input type="text" id="card-holder-input"
												autocomplete="off">
										</div>
										<div class="flexbox">
											<div class="inputBox">
												<span>到期年</span> <select name="" id="year-input"
													class="year-input">
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
												<span>到期月</span> <select name="" id="month-input"
													class="month-input">
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
												<span>cvv</span> <input type="text" maxlength="4"
													id="cvv-input" autocomplete="off">
											</div>
										</div>
										<input type="button" value="送出訂單" class="submit-btn"
											onclick="return creditcart();">
									</div>
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="action" value="insert"> <input
						type="hidden" name="room_type_id"
						value="${room_typeVO.room_type_id}" id="room_type_id">
			</FORM>
		</div>

		<div class="list">
			<h2>TWD${room_typeVO.room_type_price*days*select}</h2>
			<h3 class="tot">總計</h3>
			<div class="top">
				<span class="inn">${param.start_date}</span><span class="l">-</span><span
					class="outt">${param.end_date}</span><span class="night">${days}晚</span>
			</div>
			<div class="mid">
				<span class="pe">${param.select1}位貴賓</span><span class="u">，</span><span
					class="ro">${param.select}個房間</span>
			</div>
			<hr>
			<span class="ii">入住資訊</span> <span class="nn">${room_typeVO.room_type_name}</span>
			<hr>
			<img
				src="${pageContext.request.contextPath}/RoomPhotoReader?room_type_photo_id=${list1.get(2).room_type_photo_id}"
				alt="">
			<hr>
			<h3 class="total">總計</h3>
			<span class="prr">TWD${room_typeVO.room_type_price*days*select}</span>
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
	<script>
		function creditcart() {
			const year = document.querySelector("#year-input");
			const month = document.querySelector("#month-input");
			const card = document.querySelector("#card-number-input");
			const name = document.querySelector("#card-holder-input");
			const cvv = document.querySelector("#cvv-input");
			if (card.value === '') {
				alert("請輸入信用卡號碼");
			}
			if (name.value === '') {
				alert("請輸入姓名");
			}
			if (year.value === "year") {
				alert("請選擇到期年");
			}
			if (month.value === "month") {
				alert("請選擇到期月");
			}
			if (cvv.value === '') {
				alert("請輸入安全碼");
			}
			if (card.value !== '' && name.value !== '' && year.value !== "year"
					&& month.value !== "month" && cvv.value !== '') {
				document.querySelector("#formmm").submit();
				return true;

			}
		}
	</script>

</body>
</html>