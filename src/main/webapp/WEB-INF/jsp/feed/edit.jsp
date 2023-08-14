<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피드 수정하기</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/headerBack.jsp"/>

	<section>
		<div class="container">
			<h5 class="text-center pt-3 font-weight-bold">피드 수정하기</h5><hr>
			<div id="fileUploadBtn"><img id="imagePlace" width="100%" src="${feed.image }"></div>
		</div>
		<div class="px-2 m-1">
			<label class="font-weight-bold">설명을 입력해 주세요.</label>
			<textarea id="textInput" rows="6" class="form-control" maxlength="2200" >${feed.text }</textarea>
		</div>
		<div class="d-flex justify-content-center">
			<button id="submitBtn" type="button" class="btn btn-primary col-10 my-5 p-3" disabled>수정하기</button>
		</div>
		<div class="my-5">
			<div id="deleteFeedBtn" class="text-danger text-center">이 피드를 삭제할게요.</div>
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
			var beforeText = "${feed.text }";
			var feedEntity = "${feed}";
			
			if(feedEntity===""){
				alert("잘못된 접근입니다.");
				window.history.back();
				window.location.reload();
				return;
			} else {
				$("#deleteFeedBtn").on("click",function(){
					var FID = ${feed.FID }
					confirm("한번 삭제하면 다시 복구할 수 었어요\n그래도 삭제할까요?");
					$.ajax({
						type:"post"
						,url:"/rest/myfeed/edit/del"
						,data:{"FID":FID}
						,success:function(data){
							if(data.result=="success"){
								alert("피드가 삭제되었어요.");
								window.location.replace("/main/feed/myfeed");
							} else{
								alert("피드 삭제에 실패했어요.");
							}
						}
						,error:function(){
							alert("피드 삭제 중 오류가 발생했습니다.");
						}
					})
				})
				
				$("#submitBtn").on("click",function(){
					
					var text = $("#textInput").val();
					
					var formData = new FormData();
					formData.append("text",text);
					formData.append("FID",${feed.FID });
					
					confirm("피드를 수정할까요?");
					$.ajax({
						type:"post"
						,url:"/rest/myfeed/edit/submit"
						,data:formData
						,processData:false
						,contentType:false
						,success:function(data){
							if(data.result == "success"){
								window.location.replace("/main/feed/myfeed/");
							
							} else{
								alert("피드를 수정하지 못했어요.");
							}
						}
						,error:function(){
							alert("오류가 발생했습니다.");
						}
					});
				});
				
				$("#textInput").on("keyup",function(){
					textValue = $("#textInput").val();
					if(textValue!=beforeText){
						$("#submitBtn").prop("disabled",false);
					} else{
						$("#submitBtn").prop("disabled",true);
					}
				});
			}
		});
	</script>
</body>
</html>