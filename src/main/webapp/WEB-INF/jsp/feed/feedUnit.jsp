<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

	<div id="reloadArea">
		
	<c:choose>
	<c:when test="${feedList[0] eq null }">
		<div class="text-center py-5 my-5 font-weight-bold">
			<div>아직 작성된 피드가 없어요.</div>
			<div>피드를 올려 나의 루틴을 공유해 보세요!</div>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach var="feed" items="${feedList }"> 
			<div id="feedUnit" class="my-1">
				<div class="callModal d-flex align-items-center m-1" data-get-feedid="${feed.FID}">
					<div class="mr-2 small-box d-flex justify-content-center align-items-center">
						<img class="small-profile" height="24" src="${feed.profileImage }" data-feed-profileimage="${feed.profileImage }">
					</div>
					<div class="mr-2" >${feed.nickname}</div>
					<div class="ml-auto p-2">${feed.countedDate }</div>
				</div>
				<img class="rounded callModal" width="100%" src="${feed.image}" data-get-feedid="${feed.FID}">
				<div class="p-2">
					<div class="d-flex align-items-center mb-1">
						<div class="small text-white bg-success rounded p-1 px-3 text-center">${feed.interestsName }</div>
						<div class="small text-white bg-success rounded p-1 px-3 text-center ml-1">${feed.levelValue }</div>
					<c:choose>
						<c:when test="${feed.UID eq UID }">
						<div id="ifMine" class="small text-danger ml-auto">
							<a href="/main/feed/myfeed/edit?FID=${feed.FID }">수정 | 삭제</a>
						</div>
						</c:when>
					</c:choose>
					</div>
					<div data-feed-text="${feed.text}">${feed.text}</div>
				</div>
				<div class="d-flex ml-3 align-items-center">
					<div class="text-center p-1">
					<c:choose>
					<c:when test="${feed.ifILiked }">
						<h5 data-feed-fid="${feed.FID }" data-feed-ifliked="${feed.ifILiked }" class="like-btn mx-2 bi bi-heart-fill text-center text-danger"></h5>
					</c:when>
					<c:otherwise>
						<h5 data-feed-fid="${feed.FID }" class="like-btn mx-2 bi bi-heart text-center"></h5>
					</c:otherwise>
					</c:choose>
						<div>좋아요 <b>${feed.likeCount }</b> 개</div>
					</div>
					<div class="text-center p-1">
						<h5 class="mx-2 fw-bold bi bi-chat-left text-center"  onclick="location.href='/main/feed/reply?FID=${feed.FID }';"></h5>
						<div>댓글 <b>${feed.replyCount }</b> 개</div>
					</div>
				</div>
				<c:forEach var="eachReply" items="${feed.replyList}" begin="0" end="2">
				<div id="replyLine" class="d-flex p-2" onclick="location.href='/main/feed/reply?FID=${feed.FID }'">
					<div class="small-box d-flex justify-content-center align-items-center">
						<img class="small-profile m-1" height="24" src="${eachReply.replyProfileImage }">
					</div>
					<div class="col-9"><b class="mr-1">${eachReply.replyNickname }</b>${eachReply.replyText }</div>
					<div class="small ml-auto text-right font-weight-bold">${eachReply.countedDate }</div>
				</div>
				</c:forEach>
				<hr>
			</div>
		</c:forEach>
	</c:otherwise>
	</c:choose>
		</div>	
		

		
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	
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

})
</script>

<script src="/static/js/callModal.js"></script>
<jsp:include page="/WEB-INF/jsp/feed/feedmodal.jsp"/>

