<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보, 루티너그램</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/header.jsp"/>

	<section>
		<div class="d-flex justify-content-around align-items-center p-3">
			<img class="mb-2" src="/static/img/Arrow_left_black.png">
			<h5 class="font-weight-bold">내 정보</h5>
			<div style="width:24px;"></div>
		</div>
		<div>
			<div class="d-flex justify-content-center p-2"> <img width="90" src="/static/img/People_circle_big.png"> </div>
			<div class="d-flex justify-content-center p-2"><button class="btn btn-primary">프로필 사진 변경하기</button></div>
		</div>
	
		<div class="mt-3">
			<div>
				<div>
					<h5 class="font-weight-bold">닉네임</h5>
					<div class="d-flex align-items-center justify-content-between">
						<div>${nickname}</div>
						<button class="font-size-small btn btn-primary">닉네임 변경하기</button>
					</div>
					<hr>
				</div>
				
				<div id="emailBtn">
					<h5 class="font-weight-bold">이메일</h5>
					<div>${email}</div>
					<hr>
				</div>
				
				<div id="removeProfileImageBtn">
					<h5>프로필사진 삭제하기</h5>
					<hr>
				</div>
				
				<div id="editRoutineBtn">
					<h5>목표 루틴 변경하기</h5>
					<hr>
				</div>
				
				<div id="editPassword">
					<h5>비밀번호 변경하기</h5>
					<hr>
				</div>
				
				<div id="logoutBtn">
					<h5>로그아웃</h5>
					<hr>
				</div>
				
				<div id="withdrwalBtn">
					<h5>회원탈퇴</h5>
					<hr>
				</div>
			</div>
		</div>
	
	</section>
</div>


	<jsp:include page="/WEB-INF/jsp/gnb/bottomNav.jsp"/>
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="/static/js/only-for-user.js"></script>
	<script>
		$(document).ready(function(){

			
			$("#logoutBtn").on("click",function(){
				location.href="/main/login/logout";
			});
			
		});
	</script>
</body>
</html>