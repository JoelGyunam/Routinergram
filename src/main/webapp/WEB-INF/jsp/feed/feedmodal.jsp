<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 모달 영역 --%>	
		
<!-- Button trigger modal -->
<button id="modalBtn" type="button" class="btn btn-primary d-none" data-toggle="modal" data-target="#modalUnit">
  Launch demo modal
</button>


<!-- Modal -->

<div class="modal fade" id="modalUnit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <div id="modalFeedText"></div>
		<div id="feedModalUnit" class="my-1">
			<div class="d-flex align-items-center m-1">
				<div class="mr-2 small-box d-flex justify-content-center align-items-center">
					<img id="modalProfileImage" class="small-profile" height="24" src="${data.profileImage }">
				</div>
				<div id="modalNickname" class="mr-2">${data.nickname}</div>
				<div id="modalCountedDate" class="ml-auto p-2">${feed.countedDate }</div>
			</div>
			<img id="modalImage" class="rounded" width="100%" src="${data.image}">
			<div class="p-2">
				<div class="d-flex align-items-center mb-1">
					<div id="modalInterestsName" class="small text-white bg-success rounded p-1 px-3 text-center">${data.text}</div>
					<div id="modalLevelValue" class="small text-white bg-success rounded p-1 px-3 text-center ml-1">${data.levelValue }</div>
				</div>
				<div id="modalText">${data.text}</div>
			</div>
			<div id="modalLikeReply" class="d-flex ml-3 align-items-center">
				<div id="modalLikeBtnArea" class="text-center p-1">
				<div id="modalIfILiked"></div>
					<div>좋아요 <b id = "modalLikeCount">${data.likeCount }</b> 개</div>
				</div>
				<div class="text-center p-1">
					<h5 id="modalGoToReplyPage" class="mx-2 fw-bold bi bi-chat-left text-center"  onclick="location.href='/main/feed/reply?FID=${data.FID }';"></h5>
					<div>댓글 <b id = "modalReplyCount">${data.replyCount }</b> 개</div>
				</div>
			</div>
			<div id="modalReplyList">
				<div id="replyLine">
				</div>
			</div>
			<hr>
		</div>        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>



<%-- 모달 영역 --%>	