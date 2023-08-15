<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

	<div id="reloadArea">
		<c:forEach var="feed" items="${feedList }"> 
			<div id="feedUnit" class="my-1">
				<div class="d-flex align-items-center m-1">
					<img class="mr-2" height="24" src="/static/img/People_circle.png">
					<div class="mr-2" >${feed.nickname}</div>
					<div class="ml-auto p-2">${feed.countedDate }</div>
				</div>
				<img class="rounded" width="100%" src="${feed.image}">
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
					<div>${feed.text}</div>
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
						<div class="d-flex align-items-center"><div>좋아요</div><b class="ml-2">${feed.likeCount }</b><div>개</div></div>
					</div>
					<div class="text-center p-1">
						<h5 class="mx-2 fw-bold bi bi-chat-left text-center"></h5>
						<div>댓글</div>
					</div>
				</div>
				<div id="reply" class="d-flex p-2">
					<img class="m-1" height="24" src="/static/img/People_circle.png">
					<div><b class="m-1">abc123</b>피드 댓글 여기에 이렇게 들어가게 됨</div>
					<div class="small ml-auto text-right col-3 font-weight-bold">1분 전</div>
				</div>
				<hr>
			</div>
		</c:forEach>
		</div>	
		
