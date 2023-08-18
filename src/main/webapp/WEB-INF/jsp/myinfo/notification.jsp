<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>루티너그램 알림센터</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/headerBack.jsp"/>

	<section>
		
		<div class="container p-3">
		
			<div>
				<h5 class="text-center font-weight-bold">알림센터</h5>
				<c:choose>
				<c:when test="${unseenNumber eq '0'}">
				<div class="text-center">새로운 알림이 없어요.</div>
				</c:when>
				<c:otherwise>
				<div class="text-center">${unseenNumber} 개의 새로운 알림</div>
				</c:otherwise>
				</c:choose>
				<hr>
			</div>
			
			<c:forEach var="eachNoti" items="${notificationList }">
			<div>
				<div class="d-flex justify-content-between">
					<div class="font-weight-bold">${eachNoti.writerNickname }</div>
					<div>${eachNoti.countedDate }</div>
				</div>
				<div class="d-flex justify-content-around">
					<div class="mr-auto"></div>
					<div class="text-center">${eachNoti.message }</div>
					<c:choose>
					<c:when test="${eachNoti.ifSeen eq '1'}">
					<div class="text-danger small ml-auto">New</div>
					</c:when>
					<c:otherwise>
					<div class="text-danger small ml-auto"></div>
					</c:otherwise>
					</c:choose>
				</div>
				<div class="mt-1 px-1 small">${eachNoti.messageBody}</div>
				<hr>
			</div>		
			</c:forEach>
			
		</div>
	
	
	</section>
</div>


	<jsp:include page="/WEB-INF/jsp/gnb/bottomNav.jsp"/>
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
    	var UID = '<%= session.getAttribute("UID") %>';
	</script>
	<script src="/static/js/only-for-user.js"></script>
	
	<script>
		$(document).ready(function(){
			
			var UID = ${UID};
			
			$.ajax({
				type:"put"
				,url:"/rest/myinfo/notification/reset"
				,data:{"UID":UID}
			})
			
		})
	</script>
	
</body>
</html>