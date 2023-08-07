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

	<section class="bg-white container d-flex align-items-center justify-content-center">
		<div class="container">
			<div>
				<form id="loginForm">
					<div class="mt-2">
						<label><b>이메일 주소</b></label>
						<div class="d-flex align-items-center">
							<input id="email" type="text" class="form-control">
							<div id="atSymbol" class="ml-1">@</div>
							<select id="emailSelect" class="form-control col-5 ml-1">
								<option value="manual" selected>직접 입력</option>
								<option value="@gmail.com">gmail.com</option>
								<option value="@naver.com">naver.com</option>
								<option value="@kakao.com">kakao.com</option>
							</select>
						</div>
						<div id="emailValidAlert" class="small text-danger">잘못된 이메일 형식입니다.</div>
					</div>
					<div class="mt-2">
						<label><b>비밀번호</b></label>
						<input id="password" type="password" class="form-control">
					</div>
					<button id="loginBtn" type="submit" class="btn btn-success btn-block text-white mt-3">로그인</button>
				</form>
				<div class="text-right small mt-2">비밀번호 찾기</div>
			</div>
			
			<div class="container mt-5">
				<div class="font-weight-bold">루티너그램이 처음이신가요?</div>
				<button id="regBtn" type="button" class="btn btn-primary btn-block text-white mt-3">5초만에 루티너그램 시작하기</button>
			</div>
		</div>
	
	</section>



</div>


	<jsp:include page="/WEB-INF/jsp/gnb/footer.jsp"/>





	<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>
		$(document).ready(function(){
			
			var emailValue = "";
			$("#atSymbol").hide();
			$("#emailValidAlert").hide();
			
			function IsEmail(emailValue) {
	            var regex =
	/^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	            if (!regex.test(emailValue)) {
	                return false;
	            }
	            else {
	                return true;
	            }
	        };
	        
	        $("#email").on("keyup",function(){
	        	var emailSelect = $("#emailSelect").val();
	        	if(emailSelect == "manual"){
					emailValue = $("#email").val();
				} else {
					emailValue = $("#email").val()+$("#emailSelect").val();
				}
	        	if(!IsEmail(emailValue)){
	        		$("#emailValidAlert").show();
	        	} else $("#emailValidAlert").hide();
	        });
			

			$("#emailSelect").on("change",function(){
				var emailSelect = $("#emailSelect").val();
				if(emailSelect == "manual"){
					$("#atSymbol").hide();
					emailValue = $("#email").val();
				} else {
					$("#atSymbol").show();
					emailValue = $("#email").val()+$("#emailSelect").val();
				}
	        	if(!IsEmail(emailValue)){
	        		$("#emailValidAlert").show();
	        	} else $("#emailValidAlert").hide();
			});
			
			
			$("#loginForm").on("submit",function(e){
				
				e.preventDefault();
				
				var email = $("#email").val();
				var emailSelect = $("#emailSelect").val();
				var password = $("#password").val();
				
				
				if(email==""){
					alert("이메일을 입력해 주세요.");
					return;
				}
				if(!IsEmail(emailValue)){
					alert("잘못된 이메일 형식입니다.");
					return;
				}
				if(password==""){
					alert("비밀번호를 입력해 주세요.");
					return;
				}	
				
				$.ajax({
					type:"post"
					,url:"/login/enter"
					,data:{
						"email":emailValue
						,"password":password
					}
					,success:function(data){
						if(data.result=="success"){
							location.href="/main/feed"
						} else{
							alert("로그인 정보를 다시 확인해 주세요.");
						}
					}
					,error:function(){
						alert("로그인에 문제가 발생했어요.\n다시 시도해 주세요.");
					}
				});
				
			});
			
			
			$("#regBtn").on("click",function(){
				location.href="/reg";
			})
			
			
			
		});
	</script>
</body>
</html>