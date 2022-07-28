<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="d.com.product_order_detail.model.*"%>
<%@ page import="d.com.product.model.*"%>
<%@ page import="d.com.product_order_list.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%
/* Product_order_detailService podSVC = new Product_order_detailService();
List<Product_order_detailVO> podVOlist = podSVC.getOrderListByMemberId(1);
												//以session取得該會員的編號
												// HttpSession session = request.getSession();
pageContext.setAttribute("podVOlist", podVOlist); */
%> --%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery.datetimepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/HomePageCss.css">
<title>Insert title here</title>
<style>
.search-form {
	border-radius: 5px;
	position: relative;
	text-align: left;
	background-color: rgb(253, 253, 253);
	box-shadow: 2px 2px 3px 3px #cccccc;
	/* width:45%; */
	height: 200px;
	right: 240px;
	bottom: 100px;
}

.title {
	/* border: 1px solid black; */
	display: inline-block;
	font-size: 30px;
	position: relative;
	left: 30px;
	color: black;
	top: -80px;
}

.errorMsg {
	display: inline-block;
	position: relative;
	left: 10px;
	bottom: 90px;
	font-size: 16px;
}

.errorMsg>ul>li {
	list-style: none;
}

.form-list {
	list-style: none;
	position: relative;
	left: 30px;
	display: inline-block;
}

.form-list>li>form {
	margin-top: 20px;
}
 

</style>
</head>
<body>
	<main>
		<div class="search-form">
			<p class="title">訂單查詢</p>
			<ul class="form-list">
				<li>
					<b style="color:red">*<b>會員編號：這裡取得session</b></b>
				</li>
				<li>
					<FORM METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
						<b>輸入訂單編號 :</b> 
						<input type="text" name="product_id"> 
						<input
							type="hidden" name="action" value="getOne_Product_DetailForMembers">
						<input type="submit" value="送出"><br>
					</FORM>
				</li>
				
				<li>
					<FORM METHOD="post"
						ACTION="${pageContext.request.contextPath}/Product_order_detailServlet">
						<b> 查詢訂單狀態:</b>
						<select onchange="this.form.submit()" name="status" >
							<option value="0">已付款</option>
							<option value="1">完成</option>
							<option value="2">取消</option>
						</select>
						<input type="hidden" name="action" value="status-select"> 
					</FORM>
				
				</li>
			</ul>



			<div class="errorMsg">
				<c:if test="${not empty errorMsg}">
					<ul>
						<c:forEach var="message" items="${errorMsg}">
							<li style="color: red">*${message}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>
	</main>
	<!-- ==datetime pidcker====== -->

<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.datetimepicker.full.js"></script>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
 	       theme: 'dark',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '',              // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>
</body>
</html>