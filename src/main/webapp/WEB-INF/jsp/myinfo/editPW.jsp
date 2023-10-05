<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/headerBack.jsp"/>

	<section>
		
		<div class="container p-3">
			<h5 class="text-center font-weight-bold">비밀번호 변경하기</h5><hr>
			
			<div class="mx-2">
				<label class="mt-1">현재 비밀번호를 입력해 주세요.</label>
				<input id="currentPW" type="text" class="form-control">
				<div id="wrongPWnotice" class="text-danger small d-none">현재 비밀번호를 다시 확인해 주세요.</div>
			</div>
			<div class="mx-2">
				<label class="mt-1">새로운 비밀번호를 설정해 주세요</label>
				<input id="changePWinput" type="text" class="form-control">
				<div class="text-dark small">8~16자의 대소문자, 숫자, 특수문자로 조합할 수 있어요.</div>
			</div>
			<div class="mx-2">
				<label class="mt-1">비밀번호 확인</label>
				<input id="checkPWinput" type="text" class="form-control">
				<div id="notMatchedNotice" class="text-danger small d-none">비밀번호가 일치하지 않습니다.</div>
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<button id="editReqBtn" class="my-2 btn btn-primary text-white" disabled>비밀번호 변경하기</button>
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
			
			var currentPW = $("#currentPW").val();
			var currentMatch = false;
			var changePW = $("#changePWinput").val();
			var checkPW = $("#checkPWinput").val();
			
	        function pwRegCheck(password) {
	        	var regex = /^[A-Za-z\d@$!%*?&]{8,16}$/;
				if (!regex.test(password)){
					return false;
				}
				else {
					return true;
				}
	        };
			
			 $("#changePWinput, #checkPWinput").on("change",function(){
				changePW = $("#changePWinput").val();
				checkPW = $("#checkPWinput").val();
				
				if(changePW!=checkPW){
					$("#notMatchedNotice").removeClass("d-none");
					$("#editReqBtn").prop("disabled",true);
				}else{
					$("#notMatchedNotice").addClass("d-none");
					$("#editReqBtn").prop("disabled",false);
				}
			})
			
			
			$("#currentPW").on("change",function(){
				currentPW = $("#currentPW").val();
				$.ajax({
					type:"post"
					,url:"/rest/myinfo/editPW/pwChecker"
					,data:{"password":currentPW}
					,success:function(data){
						if(data.ifMatch){
							$("#wrongPWnotice").addClass("d-none");
							currentMatch = true;
						} else{
							$("#wrongPWnotice").removeClass("d-none");
							currentMatch = false;
						}
					}
				})
			})
			
			$("#editReqBtn").on("click",function(){
				
				if(!currentMatch){
					alert("현재 비밀번호를 확인해 주세요.");
					return;
				}
				
				if(changePW != checkPW){
					alert("새 비밀번호가 일치하지 않아요.");
					return;
				}
				
				if(changePW == currentPW){
					alert("현재 사용중인 비밀번호로는 바꿀 수 없어요.");
					return;
				}
				
				if(!pwRegCheck(changePW)){
					alert("새로운 비밀번호의 형식을 확인해 주세요");
					return;
				}
				
				if(confirm("비밀번호를 변경할까요?")){
					
					$.ajax({
						type:"put"
						,url:"/rest/myinfo/editPW/submit"
						,data:{
							"currentPW":currentPW
							,"changePW":changePW
						}
						,success:function(data){
							if(data.result=="success"){
								alert("비밀번호가 성공적으로 변경되었어요.");
								location.reload();
							} else{
								alert("비밀번호 변경에 실패했어요.");
							}
						}
						,error:function(){
							alert("비밀번호 변경 중 오류가 발생했어요.");
						}
					})
					
				}
				
			})
		})
	</script>
	
</body>
</html>