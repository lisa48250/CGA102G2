<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>

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
	<header>
		<nav>
			<img class="nav-logo"
				src="${pageContext.request.contextPath}/images/logo.png" alt="">
			<table class="weather-div">
				<tbody class="weather-tbody">
					<tr class="weather-tr">
					</tr>
					<tr class="weather-tr-1">
					</tr>
				</tbody>
			</table>
			<div class="icon"></div>
			<img class="nav-top-img"
				src="${pageContext.request.contextPath}/images/wheather.png" alt="">
			<a href="" class="text">會員登入/註冊</a> <a href="" class="nav-top-a">
				<img class="nav-top-img-1"
				src="${pageContext.request.contextPath}/images/shopping-cart.png"
				alt="">
			</a>
			<div class="nav-top-bot">
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>首頁</p>
							</div>
					</a></li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>最新消息</p>
							</div>
					</a></li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>房型介紹</p>
							</div>
					</a></li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>關於我們</p>
							</div>
					</a></li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>活動商城</p>
							</div>
					</a></li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>伴手禮商城</p>
							</div>
					</a></li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>媒體報導</p>
							</div>
					</a></li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li"><a href="" class="">
							<div class="nav-left-div">
								<p>會員中心</p>
							</div>
					</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<div>
		<div class="body1">
			<div class="name">吳永志</div>
			<div class="avatardiv">
				<img src="${pageContext.request.contextPath}/images/camera.png"
					alt="">
			</div>
		</div>
	</div>

	<aside>
		<ul>
			<li><span><a href="" style="color: white;">會員資料</a></span></li>
			<li><span><a href="" style="color: white;">資料管理</a></span></li>
			<li><span><a href="" style="color: white;">訊息通知</a></span></li>
			<li><span><a
					href="${pageContext.request.contextPath}/SelectRoomOrderServlet"
					style="color: white;">查看住宿訂單</a></span></li>
			<li><span><a href="" style="color: white;">查看活動訂單</a></span></li>
			<li><span><a href="" style="color: white;">查看購物訂單</a></span></li>
		</ul>
	</aside>

	<!-- ===============================================main區================================================= -->
	<%-- <main class="">
		<div class="div-p ">
			<h1 class="p1">訂房訂單</h1>
		</div>
		<div class="card w-100 detail">
			<div class="card-body">
				<p class="order">訂房訂單</p>
				<div class="card-body card3 " style="height: 290px;">
					<table class="table table-sm"
						style="position: absolute; top: -2px; left: -1px;">
						<tbody>
							<tr>
								<td>訂單日期:</td>
								<td>2022-2-2</td>
								<td>入住日期:</td>
								<td>2022-2-2</td>
								<td>退房日期:</td>
								<td>2022-2-2</td>
								<td>訂單總金額:</td>
								<td>2000 元</td>
								<td><a><img
										src="${pageContext.request.contextPath}/images/查看訂單.png"
										style: width="50px" ; height="50px"></a></img></td>
							</tr>


						</tbody>
					</table>

				</div>
			</div>
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
						<th>訂單日期</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>訂單總金額</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">

					<c:forEach var="actOrder" items="${list}" varStatus="d">
						<tr align="center" valign="middle">
							<td>${actOrder.activityOrderId}</td>
							<td>${actOrder.activityName}</td>
							<td>${actOrder.orderAmount}</td>
							<td><fmt:formatDate value="${actOrder.activitySessionStart}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<button class="see" style="border: 0px; background: transparent"
									onclick="detail(this)">
									<img src="${pageContext.request.contextPath}/images/查看訂單.png"
										alt="" width="50" height="50">
								</button>
							</td>
							<td>

								<FORM method="post"
									action="<%=request.getContextPath()%>/activityJoin/activityJoin.do">
									<button type="button" data-bs-toggle="modal"
										data-bs-target="#exampleModal"
										style="border: 0px; background: transparent">
										<img src="${pageContext.request.contextPath}/images/取消訂單.png"
											alt="" width="45" height="45">
									</button>
									<div class="modal fade" id="exampleModal" tabindex="-1"
										aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog modal-dialog-centered">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">確定要取消該活動嗎?</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-footer">
													<input type="submit" class="btn btn-secondary"
														data-bs-dismiss="modal" value="忍痛取消"> <input
														type="hidden" name="action" value="update"> <input
														type="hidden" name="id"
														value="${actOrder.activityOrderId}">

													<button type="button" class="btn btn-primary"
														data-bs-dismiss="modal">我按好玩的</button>
												</div>
											</div>
										</div>
									</div>
								</FORM>

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
						<th>訂單日期</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>訂單總金額</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">
					<c:forEach var="actOrder" items="${listOne}" varStatus="d">
						<tr>
							<td>${actOrder.activityOrderId}</td>
							<td>${actOrder.activityName}</td>
							<td>${actOrder.orderAmount}</td>
							<td><fmt:formatDate value="${actOrder.activitySessionStart}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<button class="see" style="border: 0px; background: transparent">
									<img src="${pageContext.request.contextPath}/images/查看訂單.png"
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
			<table class="table table-striped table-hover ">
				<thead class="text-black" style="font-size: 20px;">
					<tr>
						<th>訂單日期</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>訂單總金額</th>
					</tr>
				</thead>
				<tbody style="font-size: 18px;">
					<c:forEach var="actOrder" items="${listTwo}" varStatus="d">
						<tr>
							<td>${actOrder.activityOrderId}</td>
							<td>${actOrder.activityName}</td>
							<td>${actOrder.orderAmount}</td>
							<td><fmt:formatDate value="${actOrder.activitySessionStart}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<button class="see" style="border: 0px; background: transparent"
									onclick="detail(this)">
									<img src="${pageContext.request.contextPath}/images/查看訂單.png"
										alt="" width="50" height="50">
								</button>
							</td>
							<td>${actOrder.refundState == 1 ? "尚未退款":"退款完成"}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main> --%>

	<footer>
		<div>
			<p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved.
				Designed by</p>
			<p>DREAMCENTER</p>
		</div>
	</footer>
	<div class="textinfo">
		<p>文字客服</p>
	</div>
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

		/* $(".close").click(function() {
			$(".detail").slideToggle(500);
		})

		$(".see").click(function() {
			$(".detail").slideDown(500);
		}) */
	</script>

</body>

</html>