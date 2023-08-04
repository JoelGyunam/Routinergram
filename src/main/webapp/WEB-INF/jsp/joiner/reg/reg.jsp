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

	<jsp:include page="/WEB-INF/jsp/gnb/headerBack.jsp"/>
	
	<section class="bg-white">
		<div class="container">
			<h1 class="p-3">회원가입</h1>
			<div>
				<label>이메일을 입력해 주세요</label>
				<div class="d-flex align-items-center">
					<input id="email" type="text" class="form-control">
					<div id="atSymbol" class="ml-1">@</div>
					<select id="emailSelect" class="form-control col-5 ml-1">
						<option value="nonselect" selected>이메일 선택</option>
						<option value="@gmail.com">gmail.com</option>
						<option value="@naver.com">naver.com</option>
						<option value="@kakao.com">kakao.com</option>
						<option value="manual">직접 입력</option>
					</select>
				</div>
				<div id="emailValidAlert" class="small text-danger">잘못된 이메일 형식입니다.</div>
				<div id="emailDupCheckAlert" class="small text-danger">이미 가입된 이메일입니다.</div>
			</div>
			<div class="mt-2">
				<label>비밀번호를 설정해 주세요</label>
				<input id="password" type="password" class="form-control" maxlength="16">
				<div class="small text-dark">8 ~ 16자의 대소문자, 숫자, 특수문자로 조합할 수 있어요.</div>
			</div>
			<div class="mt-2">
				<label>비밀번호를 한번 더 입력해 주세요</label>
				<input id="passwordConfirm" type="password" class="form-control">
				<div id="passwordValidFailAlert" class="small text-danger">비밀번호가 일치하지 않아요.</div>
				<div id="passwordValidSuccessAlert" class="small text-success">비밀번호가 일치해요.</div>
			</div>
			<div class="mt-2">
				<label>닉네임을 입력해 주세요</label>
				<input id="nickname" type="text" class="form-control" maxlength="16">
				<div id="nicknameDupCheckAlert" class="small text-danger">이미 사용중인 닉네임이에요.</div>
				<div class="small text-dark">한글, 영문, 숫자를 최대 16자 까지 입력할 수 있어요.</div>
			</div>
			<div class="mt-2">
				<label>관심 루틴을 선택해 주세요</label>
				<select id="interest" class="form-control">
					<option value="nonselect" selected>목표루틴 선택하기</option>
					<option value="1">걷기</option>
					<option value="2">독서</option>
					<option value="3">운동</option>
					<option value="4">식사</option>
					<option value="5">자기개발</option>
				</select>
				<div class="small text-gray">가입 후에도 언제든지 수정 가능해요.</div>
			</div>
		</div>
			<button id="regSubmitBtn" class="btn col-9 btn-dark my-5 mx-auto d-block text-center">완료하기</button>
	</section>
	
	<jsp:include page="/WEB-INF/jsp/gnb/bottomNav.jsp"/>
	


</div>


    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>
		$(document).ready(function(){
			var emailValue = "";
			$("#passwordValidSuccessAlert").hide();
			$("#passwordValidFailAlert").hide();
			$("#emailValidAlert").hide();
			$("#emailDupCheckAlert").hide();
			$("#nicknameDupCheckAlert").hide();
			
			
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
			
			
			$("#password").on("keyup",function(){
				var password = $("#password").val();
				var passwordConfirm = $("#passwordConfirm").val();
				if(password!=passwordConfirm){
					$("#passwordValidFailAlert").show();
					$("#passwordValidSuccessAlert").hide();
				}
				else{
					$("#passwordValidFailAlert").hide();
					$("#passwordValidSuccessAlert").show();
				}
			});
			
			$("#passwordConfirm").on("keyup",function(){
				password = $("#password").val();
				passwordConfirm = $("#passwordConfirm").val();
				if(password!=passwordConfirm){
					$("#passwordValidFailAlert").show();
					$("#passwordValidSuccessAlert").hide();
				}
				else{
					$("#passwordValidFailAlert").hide();
					$("#passwordValidSuccessAlert").show();
				}
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
			

			
			$("#regSubmitBtn").on("click",function(){

				var email = $("#email").val();
				var emailSelect = $("#emailSelect").val();
				var password = $("#password").val();
				var passwordConfirm = $("#passwordConfirm").val();
				var nickname = $("#nickname").val();
				var interest = $("#interest").val();
				
				if(emailSelect=="nonselect" || email==""){
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
				if(password!=passwordConfirm){
					alert("비밀번호가 일치하지 않습니다. \n다시 확인해 주세요.");
					return;
				}
				if(nickname==""){
					alert("닉네임을 입력해 주세요.");
					return;
				}
				if(interest=="nonselect"){
					alert("목표루틴을 입력해 주세요.");
					return;
				}
				
				$.ajax({
					type:"post"
					,url:"/reg/submit"
					,data:{
						"email":emailValue
						,"password":password
						,"nickname":nickname
						,"ITRID":interest
					}
					,success:function(data){
						if(data.result=="success"){
							location.href="/reg/welcome";
						} else{
							alert("회원가입에 실패했어요. \n다시 시도해 주세요");
						}
					}
					,error:function(){
						alert("문제가 발생했어요.\n다시 시도해 주세요.")
					}
				})
			});
		});
	</script>
</body>
</html>