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
</head>
<body>

<div id="wrap">

	<jsp:include page="/WEB-INF/jsp/gnb/header.jsp"/>
	
	<section class="bg-white container d-flex align-items-center justify-content-center">
		<div>
			<div class="text-center">
				<div><b>루티너그램</b>은 자기관리를 행동으로 실천하는</div>
				<div>루티너를 위해 태어났어요!</div>
				<br>
				<div>이제 루티너그램에서 목표를 설정하고,</div>
				<div>나의 <b>목표와 행동을 공유</b>할 수 있어요!</div>
				<br>
				<div class="font-weight-bold">내일보다 더 발전된 내 모습을</div>
				<div class="font-weight-bold">함께 공유해 볼까요?</div>
			</div>
		</div>
			<button id="greetingBtn" class="btn col-9 btn-primary my-5 mx-auto d-block text-center">루티너그램 시작하기</button>
	</section>
	
</div>

		<jsp:include page="/WEB-INF/jsp/gnb/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>
		$(document).ready(function(){
			
			$("#greetingBtn").on("click",function(){
				location.href="/main/login";
			});
			
			
		});
	</script>
</body>
</html>