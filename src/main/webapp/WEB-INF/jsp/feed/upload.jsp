<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피드 업로드</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/headerBack.jsp"/>

	<section>
		<div class="container">
			<h5 class="text-center pt-3 font-weight-bold">피드 올리기</h5><hr>
			<div id="fileUploadBtn"><img id="imagePlace" width="100%" src="/static/img/imageUploadPlaceholder.png"></div>
			<input type="file" id="fileInput" accept="image/*" class="d-none">
		</div>
		<div class="px-2 m-1">
			<label class="font-weight-bold">설명을 입력해 주세요.</label>
			<textarea id="textInput" rows="6" class="form-control" maxlength="2200" placeholder="자세한 설명은 더 많은 공감을 얻을 수 있어요!"></textarea>
		</div>
		<div class="d-flex justify-content-center">
			<button id="submitBtn" type="button" class="btn btn-primary col-10 my-5 p-3" disabled>올리기</button>
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
			
			var textValue = "";
			
			$("#fileUploadBtn").on("click",function(){
				$("#fileInput").click();
			});
			
			$("#fileInput").on("change",function(){
				var $input = $(this);
				
				var maxFileSize = 5 * 1024 * 1024;
				
				if($input[0].files[0].size > maxFileSize){
					alert("업로드 가능한 최대 이미지 크기는 5MB입니다.\n다른 이미지를 올려주세요.");
					return;
				}
				
				var reader = new FileReader();
				reader.onload = function(){
					$("#imagePlace").attr("src",reader.result);
				}
				reader.readAsDataURL($input[0].files[0]);
				
				var textValue = $("#textInput").val();
				var inputLength = $("#fileInput")[0].files.length;
				if(inputLength!=0 && textValue!=""){
					$("#submitBtn").prop("disabled",false);
				} else{
					$("#submitBtn").prop("disabled",true);
				}
			});
			
			$("#submitBtn").on("click",function(){
				
				var text = $("#textInput").val();
				var image = $("#fileInput")[0];
				
				var maxFileSize = 5 * 1024 * 1024;
				if(image.files[0].size > maxFileSize){
					alert("업로드 가능한 최대 이미지 크기는 5MB입니다.\n다른 이미지를 올려주세요.");
					return;
				} else {
					var formData = new FormData();
					formData.append("text",text);
					formData.append("image",image.files[0]);
				};
				
				confirm("피드를 올릴까요?");
				$.ajax({
					type:"post"
					,url:"/rest/myfeed/upload/submit"
					,data:formData
					,enctype:"multipart/form-data"
					,processData:false
					,contentType:false
					,success:function(data){
						if(data.result == "success"){
							window.location.replace("/main/feed");
							$.ajax({
								type:"post"
								,url:"/rest/activity/upload-up"
								,data:{
									"UID":${UID}
								}
							})
						} else{
							alert("피드를 올리지 못했어요.");
						}
					}
					,error:function(){
						alert("오류가 발생했습니다.");
					}
				});
			});
			
			$("#textInput").on("keyup",function(){
				textValue = $("#textInput").val();
				var inputLength = $("#fileInput")[0].files.length;
				if(textValue!=""&&inputLength!==0){
					$("#submitBtn").prop("disabled",false);
				} else{
					$("#submitBtn").prop("disabled",true);
				}
			});
			
		});
	</script>
</body>
</html>