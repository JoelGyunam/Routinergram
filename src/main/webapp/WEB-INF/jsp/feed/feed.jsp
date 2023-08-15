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
				<div id="radio-group" class="d-flex flex-wrap justify-content-center">
					<label id="ITRisnonselect" class = "col-3 small rounded p-1 m-1 text-center font-weight-bold text-white bg-success">
						전체보기
						<input type="radio" name="interest" value="nonselect" class="d-none">
					</label>
					<c:forEach var="interest" items="${interestList }">
					<label id="ITRis${interest.ITRID }" class = "col-3 small rounded p-1 m-1 text-center border border-success text-dark bg-white">
						${interest.interestName }
						<input type="radio" name="interest" value="${interest.ITRID }" class="d-none">
					</label>
					</c:forEach>
				</div>
				<hr>
			</div>
			  <%@ include file="/WEB-INF/jsp/feed/feedUniter.jsp" %>
	
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
	<script>
		$(document).ready(function(){
			var feedList = null;
			$("#radio-group").on("change",function(){
		        var interestRadioValue = $("input[type=radio][name=interest]:checked").val();
		        var selectedITRBox = "#ITRis"+interestRadioValue;
		        
				$("#radio-group label").attr("class","col-3 small rounded p-1 m-1 text-center border border-success text-dark bg-white");
				$(selectedITRBox).attr("class","col-3 small rounded p-1 m-1 text-center font-weight-bold text-white bg-success");
				
				updateFeed();
				
			});
			
			$(".like-btn").on("click",function(){
				
				let FID = $(this).data("feed-fid");
				
				let ifLiked = $(this).data("feed-ifliked");
				
				if(!ifLiked){
					$.ajax({
						type:"post"
						,url:"/rest/feed/like"
						,data:{
							"FID":FID
							,"likeCount":1
						}
						,success:function(data) {
							if(data.result == "success") {
								location.reload();
							} else {
								alert("좋아요 실패");
							}
						}
						, error:function() {
							alert("좋아요 에러");
						}
					})
				} else{
					$.ajax({
						type:"post"
						,url:"/rest/feed/like"
						,data:{
							"FID":FID
							,"likeCount":-1
						}
						,success:function(data) {
							if(data.result == "success") {
								location.reload();
							} else {
								alert("좋아요 실패");
							}
						}
						, error:function() {
							alert("좋아요 에러");
						}
					})
				}
				
			});
		});
	</script>
</body>
</html>