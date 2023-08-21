$(document).ready(function() {
	

	$(".callModal").on("click",function(){
		var getFeedID = $(this).data("get-feedid");
		$.ajax({
			url:"/rest/getFeedData"
			,type:"post"
			,data:{"FID":getFeedID}
			,success:function(data){

				var modalIfILiked = modalIfILiked(data.ifILiked);
				var modalReplyList = modalReplyList(data.replyList);
				console.log(data.replyList);
				
				$("#modalProfileImage").attr('src',data.profileImage);
				$("#modalGoToReplyPage").attr('onclick',"location.href='/main/feed/reply?FID=" + getFeedID + "'");
				
				$("#modalCountedDate").html(data.countedDate);
				$("#modalNickname").html(data.nickname);
				$("#modalImage").attr('src',data.image);
				$("#modalInterestsName").html(data.interestsName);
				$("#modalLevelValue").html(data.levelValue);
				$("#modalText").html(data.text);
				$("#modalLikeCount").html(data.likeCount);
				$("#modalReplyCount").html(data.replyCount);
				$("#modalIfILiked").html(modalIfILiked);
				$("#modalReplyList").html(modalReplyList);
				
				var modalReplyList = data.replyList;
				
				function modalIfILiked(ifILiked){
					var html = "";
					if(ifILiked){
						html = "<h5 id='modalHeart' data-feed-fid='"+getFeedID+"' data-feed-ifliked='"+ifILiked+"' class='like-btn mx-2 bi bi-heart-fill text-center text-danger'></h5>";
						$("#modalIfILiked").on("click",function(){
							$.ajax({
								type:"post"
								,url:"/rest/feed/like"
								,data:{
									"FID":getFeedID
									,"likeCount":-1
								}
								,success:function(data) {
									if(data.result == "success") {
										location.reload();
									} else {
										alert("좋아요 실패");
									}
								}
								,error:function() {
									alert("좋아요 에러");
								}
							})
						});
					} else{
						html = "<h5 id='modalHeart' data-feed-fid='"+getFeedID+"' data-feed-ifliked='"+ifILiked+"' class='like-btn mx-2 bi bi-heart text-center'></h5>";
						$("#modalIfILiked").on("click",function(){
							$.ajax({
								type:"post"
								,url:"/rest/feed/like"
								,data:{
									"FID":getFeedID
									,"likeCount":1
								}
								,success:function(data) {
									if(data.result == "success") {
										location.reload();
									} else {
										alert("좋아요 실패");
									}
								}
								,error:function() {
									alert("좋아요 에러");
								}
							})
						});
					}
					return html;
				}
				
				function modalReplyList(replyList){
					var html = "";
					for(var i = 0; i < replyList.length; i++){
						var eachReply = replyList[i];
						var eachFID = eachReply.fid;
						var eachReplyProfileImage = eachReply.replyProfileImage;
						var eachReplyNickname = eachReply.replyNickname;
						var eachReplyText = eachReply.replyText;
						var eachCountedDate = eachReply.countedDate;
						
						html += "<div id='replyLine" + i + "' class='d-flex p-2' onclick='location.href='/main/feed/reply?FID=" + eachFID +"'>";
						html += "\n";
						html += "	<div class='small-box d-flex justify-content-center align-items-center'>";
						html += "\n";
						html += "		<img class='small-profile m-1' height='24' src='" + eachReplyProfileImage + "'>";
						html += "\n";
						html += "	</div>";
						html += "\n";
						html += "	<div class='col-9'><b class='mr-1'>"+eachReplyNickname+"</b>" + eachReplyText +"</div>";
						html += "\n";
						html += "	<div class='small ml-auto text-right font-weight-bold'>" + eachCountedDate + "</div>";
						html += "\n";
						html += "</div>";
						html += "\n";
					}
					return html;
				}
				
				$("#modalBtn").click();
			}
		})
	});
});
