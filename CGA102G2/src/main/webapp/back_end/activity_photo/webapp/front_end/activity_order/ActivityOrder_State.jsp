<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity_join.model.*"%>
<%@ page import="com.members.model.*"%>
<%
MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");

ActivityJoinService newsSvc = new ActivityJoinService();
List<ActivityJoinVO> list = newsSvc.getactStateZero(memberVO.getMember_id());
pageContext.setAttribute("list", list);

List<ActivityJoinVO> listOne = newsSvc.getactStateOne(memberVO.getMember_id());
pageContext.setAttribute("listOne", listOne);

List<ActivityJoinVO> listTwo = newsSvc.getactStateTwo(memberVO.getMember_id());
pageContext.setAttribute("listTwo", listTwo);
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<title>活動訂單</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/front_ActivityOrder.css" />
<script src="<%=request.getContextPath()%>/js/ActivityOrder_Join.js"></script>
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
			<h1 class="p1">活動訂單</h1>
		</div>


		<!-- ============================================state0-未開始===================================================== -->
		<div class="div-state0">


			<ul class="nav nav-tabs justify-content-end ">
				<li class="nav-item col-2 ">
					<button
						class="nav-link active text-center border border-3 border-bottom-0 s0"
						style="margin-left: 10px; width: 150px; background-color: #ffffff; font-weight: bold; font-size: 20px;"
						aria-current="page">尚未開始</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s1"
						style="margin-left: 5px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">已完成</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s2"
						style="margin-left: 1px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">已取消</button>
				</li>
			</ul>
			<table class="table table-striped table-hover ">
				<thead class="text-black" style="font-size: 20px;">
					<tr>
						<th>訂單編號</th>
						<th>活動名稱</th>
						<th>訂單金額</th>
						<th>活動日期</th>
						<th>查看訂單明細</th>
						<th>取消訂單</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">
					<c:forEach var="actOrder" items="${list}" varStatus="d">
						<tr align="center" valign="middle">
							<td id="avtID">${actOrder.activityOrderId}</td>
							<td>${actOrder.activityName}</td>
							<td>${actOrder.orderAmount}元</td>
							<td><fmt:formatDate value="${actOrder.activitySessionStart}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<button class="see" style="border: 0px; background: transparent"
									onclick="detail(this)">
									<img class="see1" src="${pageContext.request.contextPath}/images/查看訂單1.png"
										alt="" width="50" height="50">
								</button>
							</td>
							<td>
								<!--===============================取消訂單判斷=================================== -->
							<c:if test="${!actOrder.canCancel}">

										<img src="${pageContext.request.contextPath}/images/取消訂單.png"
											alt="" width="45" height="45">
							</c:if> 
								
								<c:if test="${actOrder.canCancel}">
									<FORM id="form" method="post"
										action="<%=request.getContextPath()%>/activityJoin/activityJoin.do">
										
									
										
										<button type="button" data-bs-toggle="modal" data-title="${actOrder.activityOrderId}"
											data-bs-target="#exampleModal${actOrder.activityOrderId}"
											style="border: 0px; background: transparent">
											<img src="${pageContext.request.contextPath}/images/X.png"
												alt="" width="45" height="45">
										</button>
										<div class="modal fade" id="exampleModal${actOrder.activityOrderId}" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">確定要取消該活動嗎?</h5>
													<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-footer">
										
													<button id="buttonID" type="submit" 
															class="btn btn-secondary" data-bs-dismiss="modal">忍痛取消</button>
													<input type="hidden" name="action" value="update">
													<input type="hidden" name="id" value="${actOrder.activityOrderId}">

													<button type="button" class="btn btn-primary" data-bs-dismiss="modal">不要取消</button>
													</div>
												</div>
											</div>
										</div>
									</FORM>
								</c:if> <!--=============================取消訂單判斷=================================== -->

							</td>
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
						style="margin-left: 10px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">尚未開始</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link active text-center border border-3 border-bottom-0 s1"
						style="margin-left: 5px; width: 150px; background-color: #ffffff; font-weight: bold; font-size: 20px;"
						aria-current="page">已完成</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s2"
						style="margin-left: 1px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">已取消</button>
				</li>
			</ul>
			<table class="table table-striped table-hover ">
				<thead class="text-black" style="font-size: 20px;">
					<tr>
						<th>訂單編號</th>
						<th>活動名稱</th>
						<th>訂單金額</th>
						<th>活動日期</th>
						<th>查看訂單明細</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">
					<c:forEach var="actOrder" items="${listOne}" varStatus="d">
						<tr>
							<td>${actOrder.activityOrderId}</td>
							<td>${actOrder.activityName}</td>
							<td>${actOrder.orderAmount}元</td>
							<td><fmt:formatDate value="${actOrder.activitySessionStart}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<button class="see" style="border: 0px; background: transparent"
									onclick="detail(this)">
									<img class="see1" src="${pageContext.request.contextPath}/images/查看訂單1.png"
										alt="" width="50" height="50">
								</button>
							</td>

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
						style="margin-left: 10px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;">尚未開始</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link link-secondary text-center border border-3 border-bottom-0 s1"
						style="margin-left: 5px; width: 150px; background-color: #f0f0f0; font-weight: bold; font-size: 20px;"
						aria-current="page">已完成</button>
				</li>
				<li class="nav-item col-2">
					<button
						class="nav-link  active  text-center border border-3 border-bottom-0 s2"
						style="margin-left: 1px; width: 150px; background-color: #ffffff; font-weight: bold; font-size: 20px;">已取消</button>
				</li>
			</ul>
			
			<table class="table table-striped table-hover" style="overflow-y:scroll; height:100%;">
				<thead class="text-black" style="font-size: 20px;">
					<tr>
						<th>訂單編號</th>
						<th>活動名稱</th>
						<th>訂單金額</th>
						<th>活動日期</th>
						<th>查看訂單明細</th>
						<th>退款狀態</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">
					<c:forEach var="actOrder" items="${listTwo}" varStatus="d">
						<tr>
							<td>${actOrder.activityOrderId}</td>
							<td>${actOrder.activityName}</td>
							<td>${actOrder.orderAmount}元</td>
							<td><fmt:formatDate value="${actOrder.activitySessionStart}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<button class="see" style="border: 0px; background: transparent"
									onclick="detail(this)">
									<img class="see1" src="${pageContext.request.contextPath}/images/查看訂單1.png"
										alt="" width="50" height="50">
								</button>
							</td>

							<c:if test="${actOrder.refundState == 1}">
								<td style="color: red;">尚未退款</td>
							</c:if>
							<c:if test="${actOrder.refundState == 2}">
								<td style="color: rgb(20, 205, 20);">退款完成</td>
							</c:if>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>

function xxx(time) {
	let now = new Date();
	now = new Date(now.getFullYear(), now.getMonth(), now.getDate());
	let activityDate = new Date(time);
	activityDate = new Date(activityDate.getFullYear(), activityDate.getMonth(), activityDate.getDate());
	const canCancel = activityDate - now >= 1000 * 60 * 60 * 24 * 14;
	if (canCancel) {
		$("#form").submit();
	}
	return false;
}


$(document).ready(function() {
 $(".s2").click(function () {
 	$(".div-state0").hide();
	$(".div-state1").hide();
	$(".div-state2").show();
 });

 $(".s0").click(function () {
 $(".div-state1").hide();
 $(".div-state2").hide();
$(".div-state0").show();
 });

 $(".s1").click(function () {
 $(".div-state0").hide();
 $(".div-state2").hide();
$(".div-state1").show();
 });
});




$("body").on('click', '#close', function(){
	$(".detail").remove();
});



$(".see").mouseenter(function(){
	 $(this).find('.see1').attr("src","${pageContext.request.contextPath}/images/查看訂單3.png");
	});
	$(".see").mouseleave(function(){
	 $(this).find('.see1').attr("src","${pageContext.request.contextPath}/images/查看訂單1.png");
	});


 	</script>

</body>

</html>