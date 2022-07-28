<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="h.com.room_order.model.*"%>
<%@ page import="h.com.room_order_list.model.*"%>
<%@ page import="com.members.model.*"%>
<%

Room_OrderService ros = new Room_OrderService();
MemberVO memberVO =(MemberVO) session.getAttribute("memberVO");
//查詢會員訂單狀態
List<Room_orderVO> list0 = ros.getAll0(0, memberVO.getMember_id());
pageContext.setAttribute("list0", list0);
List<Room_orderVO> list1 = ros.getAll1(1, memberVO.getMember_id());
pageContext.setAttribute("list1", list1);
List<Room_orderVO> list2 = ros.getAll2(2, memberVO.getMember_id());
pageContext.setAttribute("list2", list2);
//查詢訂單明細
Room_Order_ListService rols = new Room_Order_ListService();
List<Room_order_listVO> roomorderlist0 =new ArrayList<Room_order_listVO>();
for(int i =0 ; i<list0.size(); i++){
/* 	list0.get(i).getRoom_order_id(); */
	roomorderlist0 = rols.getAllDetail(list0.get(i).getRoom_order_id());
}
List<Room_order_listVO> roomorderlist1 =new ArrayList<Room_order_listVO>();
for(int j =0 ; j<list1.size(); j++){
/* 	list0.get(i).getRoom_order_id(); */
	roomorderlist1 = rols.getAllDetail(list1.get(j).getRoom_order_id());
}
List<Room_order_listVO> roomorderlist2 =new ArrayList<Room_order_listVO>();
for(int k =0 ; k<list2.size(); k++){
/* 	list0.get(i).getRoom_order_id(); */
	roomorderlist2 = rols.getAllDetail(list2.get(k).getRoom_order_id());
}
pageContext.setAttribute("roomorderlist0", roomorderlist0);
pageContext.setAttribute("roomorderlist1", roomorderlist1);
pageContext.setAttribute("roomorderlist2", roomorderlist2);

%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<title>Document</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/selectroomorder.css" />

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
	<div>
		<div class="body1">
			 <div class="name">${memberVO.member_name}</div>
			<div class="avatardiv">
				<img src="${pageContext.request.contextPath}/Member_reader?member_id=${memberVO.member_id}"
					alt="">
			</div>
		</div>
	</div>

	<aside>
		<ul>
			<li><span><a
					href="${pageContext.request.contextPath}/front_end/protect/Member_Data.jsp"
					style="color: white;">會員資料</a></span></li>
			<li><span><a href="${pageContext.request.contextPath}/front_end/protect/Member_Data_Update.jsp" style="color: white;">資料管理</a></span></li>
			<li><span><a href="${pageContext.request.contextPath}/front_end/memberselect/selcetroomorder.jsp" style="color: white;">查看住宿訂單</a></span></li>
			<li><span><a href="${pageContext.request.contextPath}/front_end/activity_order/ActivityOrder_State.jsp" style="color: white;">查看活動訂單</a></span></li>
			<li><span><a href="${pageContext.request.contextPath}/front_end/membersorders/Member_home_page.jsp" style="color: white;">查看購物訂單</a></span></li>
		</ul>
	</aside>

	<!-- ===============================================main區================================================= -->
	<main class="">
		<div class="div-p ">
			<h1 class="p1">訂房訂單</h1>
		</div>

		<!-- ============================================state0-未開始===================================================== -->
		<div class="div-state0">


			<ul class="nav nav-tabs justify-content-end ">
				<li class="nav-item col-2 ">
					<button
						class="nav-link active text-center border border-3 border-bottom-0 s0"
						style="margin-left: 10px; width: 150px; background-color: #ffffff; font-weight: bold; font-size: 20px;"
						aria-current="page">未入住</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s1"
						style="margin-left: 5px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">已入住</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s2"
						style="margin-left: 1px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">已結單</button>
				</li>
			</ul>
			<table class="table table-striped table-hover ">
				<thead class="text-black" style="font-size: 20px;">
					<tr>
						<th>訂單日期</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>訂單總金額</th>
						<th>查看明細</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">

					<c:forEach var="status2" items="${list2}">
						<tr align="center" valign="middle">
							<input type="hidden" value="${status2.room_order_id}"
								name="roomorderid">
							<td><fmt:formatDate value="${status2.order_date}"
									pattern="yyyy-MM-dd" /></td>
							<td>${status2.check_in_date}</td>
							<td>${status2.check_out_date}</td>
							<td>${status2.room_charge}</td>
							<%-- <td><a><img
									src="${pageContext.request.contextPath}/images/查看訂單.png" alt=""
									width="50" height="50"></a></td>
							</td> --%>

							<td><p>
									<button class="btn btn-primary" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#collapseWidthExample" aria-expanded="false"
										aria-controls="collapseWidthExample"><img style="width:40px; heigh:40px;" src="${pageContext.request.contextPath}/images/check.png"></img></button>
								</p>

								<div class="collapse collapse-horizontal"
									id="collapseWidthExample">
									<div class="card card-body" style="width: 860px;">
										<table>
											<tr>
												<th style="font-size: 30px"; >訂房訂單明細</th>
											</tr>
											<c:forEach var="room2" items="${roomorderlist2}">
												<tr>
												<%-- 	<td>房型名稱:${room2.room_type_name}</td> --%>
													<td>房間編號:${room2.room_id}</td>
													<td>人數:${room2.number_of_people}</td>
													<td>特殊要求:${room2.special_req}</td>
													<td>房間價格:${room2.room_price}</td>
													</td>
														</tr>
											</c:forEach>
										</table>
									</div>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- =================================================state1已完成-============================================================ -->

		<div class="div-state1">
			<ul class="nav nav-tabs justify-content-end ">
				<li class="nav-item col-2 ">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s0"
						style="margin-left: 10px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">未入住</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link active text-center border border-3 border-bottom-0 s1"
						style="margin-left: 5px; width: 150px; background-color: #ffffff; font-weight: bold; font-size: 20px;"
						aria-current="page">已入住</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s2"
						style="margin-left: 1px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">已結單</button>
				</li>
			</ul>
			<table class="table table-striped table-hover ">
				<thead class="text-black" style="font-size: 20px;">
					<tr>
						<th>訂單日期</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>訂單總金額</th>
						<th>查看明細</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">
					<c:forEach var="status1" items="${list1}" varStatus="d">
						<tr align="center" valign="middle">
							<td><fmt:formatDate value="${status1.order_date}"
									pattern="yyyy-MM-dd" /></td>
							<td>${status1.check_in_date}</td>
							<td>${status1.check_out_date}</td>
							<td>${status1.room_charge}</td>
							<%-- <td><a><img
									src="${pageContext.request.contextPath}/images/查看訂單.png" alt=""
									width="50" height="50"></a></td>
							</td> --%>

							<td><p>
									<button class="btn btn-primary" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#collapseWidthExample" aria-expanded="false"
										aria-controls="collapseWidthExample"><img style="width:40px; heigh:40px;" src="${pageContext.request.contextPath}/images/check.png"></img></button>
								</p>

								<div class="collapse collapse-horizontal"
									id="collapseWidthExample">
									<div class="card card-body" style="width: 860px;">
										<table>
											<tr>
												<th style="font-size: 30px"; >訂房訂單明細</th>
											</tr>
											<c:forEach var="room1" items="${roomorderlist1}">
												<tr>
													<td>房間編號:${room1.room_id}</td>
													<td>人數:${room1.number_of_people}</td>
													<td>特殊要求:${room1.special_req}</td>
													<td>房間價格:${room1.room_price}</td>
													</td>
														</tr>
											</c:forEach>
										</table>
									</div>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- =================================================state2已取消-============================================================ -->
		<div class="div-state2">
			<ul class="nav nav-tabs justify-content-end ">
				<li class="nav-item col-2 ">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s0"
						style="margin-left: 10px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">未入住</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s1"
						style="margin-left: 5px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;"
						aria-current="page">已入住</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link  active  text-center border border-3 border-bottom-0 s2"
						style="margin-left: 1px; width: 150px; background-color: #ffffff; font-weight: bold; font-size: 20px;">已結單</button>
				</li>
			</ul>
			<table class="table table-striped table-hover ">
				<thead class="text-black" style="font-size: 20px;">
					<tr>
						<th>訂單日期</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>訂單總金額</th>
						<th>查看明細</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">
					<c:forEach var="status0" items="${list0}" varStatus="d">
						<tr align="center" valign="middle">
							<td><fmt:formatDate value="${status0.order_date}"
									pattern="yyyy-MM-dd" /></td>
							<td>${status0.check_in_date}</td>
							<td>${status0.check_out_date}</td>
							<td>${status0.room_charge}</td>
							<%-- <td><a><img
									src="${pageContext.request.contextPath}/images/查看訂單.png" alt=""
									width="50" height="50"></a></td>
							</td> --%>

							<td><p>
									<button class="btn btn-primary" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#collapseWidthExample" aria-expanded="false"
										aria-controls="collapseWidthExample">
										<img style="width:40px; heigh:40px;" src="${pageContext.request.contextPath}/images/check.png"></img>
										</button>
								</p>

								<div class="collapse collapse-horizontal"
									id="collapseWidthExample">
									<div class="card card-body" style="width: 860px;">
										<table>
											<tr>
												<th style="font-size: 30px" >訂房訂單明細</th>
											</tr>
											<c:forEach var="room0" items="${roomorderlist0}">
												<tr>
													<td>房間編號:${room0.room_id}</td>
													<td>人數:${room0.number_of_people}</td>
													<td>特殊要求:${room0.special_req}</td>
													<td>房間價格:${room0.room_price}</td>
													</td>
														</tr>
											</c:forEach>
										</table>
									</div>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>

	<script>
		// $("button").click(function(){
		//   $(".div-state1").show();
		// });

		//  $('#state1').click(function () {
		//  $(".div-state0").toggle();
		// $(".div-state1").toggle();
		//  })

		$(document).ready(function() {
			$(".s2").click(function() {
				$(".div-state0").hide();
				$(".div-state1").hide();
				$(".div-state2").show();
			});

			$(".s0").click(function() {
				$(".div-state1").hide();
				$(".div-state2").hide();
				$(".div-state0").show();
			});

			$(".s1").click(function() {
				$(".div-state0").hide();
				$(".div-state2").hide();
				$(".div-state1").show();
			});
		});
 
	</script>
	<script>
		
	</script>

</body>


</html>