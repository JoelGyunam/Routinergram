<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>루틴이 공유되는 곳, 루티너그램</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/header.jsp"/>

	<section>
		<div class="container">
			<div class="mt-2">
				<label>이메일 주소</label>
				<input type="text" class="form-control">
			</div>
			<div class="mt-2">
				<label>비밀번호</label>
				<input type="password" class="form-control">
			</div>
			<button type="button" class="btn btn-success btn-block text-white mt-3">로그인</button>
			<div class="text-right small mt-2">비밀번호 찾기</div>
		</div>
		
		<div class="container mt-5">
			<div class="font-weight-bold">루티너그램이 처음이신가요?</div>
			<button id="regBtn" type="button" class="btn btn-primary btn-block text-white mt-3">5초만에 루티너그램 시작하기</button>
		</div>
	
	
	</section>



</div>


	<jsp:include page="/WEB-INF/jsp/gnb/footer.jsp"/>





	<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>
		$(document).ready(function(){
			
			$("#regBtn").on("click",function(){
				location.href="/reg";
			})
			
			
			
		});
	</script>
</body>
</html>