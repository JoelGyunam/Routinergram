<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 피드보기, 루티너그램</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/header.jsp"/>

	<section>
		<div class="container">
		
			<div id="filterBox">
				<div class="d-flex justify-content-around">
					<div class = "col-3 small rounded p-1 m-1 text-center font-weight-bold text-white bg-success">전체보기</div>
					<div class = "col-3 small rounded p-1 m-1 text-center border border-success text-dark bg-white">걷기</div>
					<div class = "col-3 small rounded p-1 m-1 text-center border border-success text-dark bg-white">독서</div>
				</div>
				<div class="d-flex justify-content-around mb-1">
					<div class = "col-3 small rounded p-1 m-1 text-center border border-success text-dark bg-white">운동</div>
					<div class = "col-3 small rounded p-1 m-1 text-center border border-success text-dark bg-white">식사</div>
					<div class = "col-3 small rounded p-1 m-1 text-center border border-success text-dark bg-white">자기개발</div>
				</div>
				<hr>
			</div>
			
		<c:forEach var="feed" items="${feedList }"> 
			<div id="feedUnit" class="my-1">
				<div class="d-flex align-items-center m-1">
					<img class="mr-2" height="24" src="/static/img/People_circle.png">
					<div class="mr-2" >${feed.nickname}</div>
					<div class="ml-auto p-2">3분 전</div>
				</div>
				<img class="rounded" width="100%" src="/static/img/wallpaper for a search.png">
				<div class="p-2">
					<div class="d-flex align-items-center mb-1">
						<div class="small text-white bg-success rounded p-1 px-3 text-center">독서 루틴</div>
						<div class="small text-white bg-success rounded p-1 px-3 text-center ml-1">${feed.levelValue }</div>
						<div id="ifMine" class="small text-danger ml-auto d-none">수정 | 삭제</div>
					</div>
					<div>${feed.text}</div>
				</div>
				<div class="d-flex ml-3 align-items-center">
					<img height="22" src="/static/img/Heart.png">
					<img height="22" src="/static/img/Chat.png" style="margin-bottom:3px" class="ml-3" >
				</div>
				<div id="reply" class="d-flex p-2">
					<img class="m-1" height="24" src="/static/img/People_circle.png">
					<div><b class="m-1">abc123</b>피드 댓글 여기에 이렇게 들어가게 됨</div>
					<div class="small ml-auto text-right col-3 font-weight-bold">1분 전</div>
				</div>
				<hr>
			</div>
		</c:forEach>
			
			
			
			
			<div id="feedEnding" style="height:60px"></div>
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
</body>
</html>