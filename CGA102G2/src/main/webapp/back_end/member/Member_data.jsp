<%-- <%@ page language="java" contentType="text/html; charset=BIG5"pageEncoding="BIG5"%> --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.members.model.*"%>
<!DOCTYPE html>

<%
MemberVO memberVO = (MemberVO) request.getAttribute("memberVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>

<body>
	<header>
		<nav>
			<img class="nav-logo" src="./logo.png" alt="">
			<table class="weather-div">
				<tbody class="weather-tbody">
					<tr class="weather-tr">
					</tr>
					<tr class="weather-tr-1">
					</tr>
				</tbody>	
			</table>
			<div class="icon"></div>
			<img class="nav-top-img" src="./wheather.png" alt="">
			<a href="" class="text">�|���n�J/���U</a>
			<a href="" class="nav-top-a">
				<img class="nav-top-img-1"src="./shopping-cart.png" alt="">
			</a>
			<div class="nav-top-bot">
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>����</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>�̷s����</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>�Ы�����</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>����ڭ�</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>���ʰӫ�</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>���§�ӫ�</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div">
								<p>�C�����</p>
							</div>
						</a>
					</li>
				</ul>
				<ul class="nav-ul-bot">
					<li class="nav-li">
						<a href="" class="">
							<div class="nav-left-div" >
								<p>�|������</p>
							</div>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

	<body>
		<div class="body1">
        <div class="name">�d�ç�</div>
        
        <div class="avatardiv">
            <img src="camera.png" alt="">
        </div>
		</div>
    </body>

	<aside>
		<ul >
		<li>
			<span>�|�����</span>
		</li>
		<li>
			<span>��ƺ޲z</span>
			<ul>
				<li> ���K�X</li>
				<li> ���|�����</li>
			</ul>
		</li>
		<li>
			<span>�T���q��</span>
		</li>
		<li>
			<span>�d�ݦ�J�q��</span>
		</li>
		<li>
			<span>�d�ݬ��ʭq��</span>
		</li>
		<li>
			<span>�d���ʪ��q��</span>
		</li>
		</ul>
</aside>
<ul>
 <jsp:useBean id="memberSvc" scope="page" class="com.members.model.MemberService" />
   
  <li>
     <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/Member_Servlet" >
       <b>��ܷ|���s��:</b>
       <select size="1" name="member_id">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.member_id}">${memberVO.member_id}
         </c:forEach>  
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
</ul>

<div class="data">
<p class="p1">
	�򥻸��
</p>
<tr>
<p class="Email">
	�|��Email: <td>${memberVO.member_email}</td>
</p>

<p class="Member_name">
	�|���m�W:	<td>${memberVO.member_name}</td>
</p>

<p class="phone">
	�|���q��:	<td>${memberVO.member_phone}</td>
</p>

<p class="address">
	�|���a�}:	<td>${memberVO.member_address}</td>
</p>
</tr>
</div>
	
	<footer>
		<div>
			<p>Copyright 2000 , CloudWind HotSpring , All Rights Reserved. Designed by </p>
			<p>DREAMCENTER</p>
		</div>
	</footer>
	<div class="textinfo">
		<p>��r�ȪA</p>
	</div>
	<script src="./weather.js"></script>
	<script src="./hidden.js"></script>
	<script src="./date.js"></script>
	<script src="./icon.js"></script>
</body>

</html>