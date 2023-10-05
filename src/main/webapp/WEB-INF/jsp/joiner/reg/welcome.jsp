<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영해요, 루티너그램!</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div id="wrap">

	<jsp:include page="/WEB-INF/jsp/gnb/header.jsp"/>
	
	<section class="bg-white container">
		<h1 class="text-center p-3">환영합니다!</h1>
		
		<h3 class="">안녕하세요 ${nickname } 님,</h3>
	
		<div class="mt-3">
			<div class="text-center mt-3">
				<div class="text-dark">루티너그램에서는 내가 루틴을 실천하는 대로</div>
				<div class="text-dark">루틴 점수를 받을 수 있어요.</div>
				<div class="mt-3 font-weight-bold">시작이 반이다!</div>
				<br>
				<div class="font-weight-bold">시작 축하 점수로 50점을 획득했어요!</div>
				<div>이제 다른 루티너들과 함께</div>
				<div>내 루틴을 공유해 볼까요?</div>
			</div>
		</div>
			<button id="startBtn" class="btn col-9 btn-primary my-5 mx-auto d-block text-center">내 첫 루티너그램 시작하기</button>
	</section>
	
</div>

	<jsp:include page="/WEB-INF/jsp/gnb/footer.jsp"/>


    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>
		$(document).ready(function(){
			
			if("${UID}"==""){
				window.location.replace("/main/login");
			};
			
			$("#startBtn").on("click",function(){
				location.href="/main/feed";
			});
			
			
		});
	</script>
</body>
</html>