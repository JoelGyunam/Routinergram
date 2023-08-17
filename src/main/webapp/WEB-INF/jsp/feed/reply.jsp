<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 확인</title>
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/header.jsp"/>

	<section>
		<div id="replyarea">
			<div class="pt-1 d-flex justify-content-between align-items-center text-white">
				<h3 id="backBtn" class="col-1">&lt;</h3>
				<h5>댓글</h5>
				<h3 class="col-1"></h3>
			</div>
	<c:choose>
		<c:when test="${replyList eq null}">
				<div class="text-center p-3 text-white"> 아직 작성된 댓글이 없어요.<br> 댓글을 달아 응원해 보세요!</div>
		</c:when>
		<c:otherwise>
			<c:forEach var="eachReply" items="${replyList}">
			<div id="replyLine" class="d-flex p-2 text-white">
				<div class="small-box m-1 d-flex justify-content-center align-items-center">
					<img class="small-profile" src="${eachReply.replyProfileImage }">
				</div>
				<div><b class="m-1">${eachReply.replyNickname }</b>${eachReply.replyText }</div>
			<c:choose>
				<c:when test="${eachReply.UID eq UID}">
				<div class="small ml-auto text-right font-weight-bold">${eachReply.countedDate }<div id="deleteReplyBtn" data-rpid="${eachReply.RPID }">삭제하기</div></div>
				</c:when>
				<c:otherwise>
				<div class="small ml-auto text-right font-weight-bold">${eachReply.countedDate }</div>
				</c:otherwise>
			</c:choose>
			</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
			
			
			<div id="replyWrite">
				<div class="mt-3 ml-2 text-white">댓글을 작성해 주세요.</div>
				<div class="d-flex align-items-center justify-content-between">
					<div class="ml-2 mt-2 small-box m-1 d-flex justify-content-center align-items-center">
						<img class="small-profile" src="${writerProfileImage}">
					</div>
					<textarea id="replyTextarea" class="m-1 form-control"></textarea>
					<div>
						<button id="replySubmitBtn" class="m-1 btn btn-primary">게시</button>
					</div>
				</div>
			</div>

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
			
			var RPID = $("#deleteReplyBtn").data("rpid");
			
			$("#deleteReplyBtn").on("click",function(){
				if(confirm("댓글을 삭제할까요?")){
					$.ajax({
						type:"delete"
						,url:"/rest/reply/delete"
						,data:{
							"RPID":RPID
						}
						,success:function(data){
							if(data.result=="success"){
								location.reload();
							} else{
								alert("댓글 삭제에 실패했어요.");
							}
						}
						,error:function(){
							alert("댓글 삭제 중 오류가 발생했어요.");
						}
					})
				}
			});
			
			$("#backBtn").on("click",function(){
				history.back();
			});
			
			$("#replyTextarea").on("keyup",function(){
				var replyText = $("#replyTextarea").val();

				if(replyText == ""){
					$("#replySubmitBtn").prop("disabled",true);
				} else {
					$("#replySubmitBtn").prop("disabled",false);
				}
			});
			
			$("#replySubmitBtn").on("click",function(){
				
				var FID = ${FID};
				var UID = ${UID};
				var replyText = $("#replyTextarea").val();
				
				if(replyText == ""){
					alert("댓글 내용을 작성해 주세요!");
					return;
				}
				
				$.ajax({
					type:"POST"
					,url:"/rest/reply/post"
					,data:{
						"FID":FID
						,"UID":UID
						,"replyText":replyText
					}
					,success:function(data){
						if(data.result=="success"){
							location.reload();
						} else{
							alert("댓글 삭제에 실패했어요.");
						}
					}
					,error:function(){
						alert("댓글 삭제 중 오류가 발생했어요.");
					}
				})
			});
			
		});
	
	</script>

	
</body>
</html>