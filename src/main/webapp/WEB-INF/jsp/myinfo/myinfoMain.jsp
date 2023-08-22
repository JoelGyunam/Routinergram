<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보, 루티너그램</title>
    <link href="https://cdn.jsdelivr.net/gh/sunn-us/SUITE/fonts/variable/woff2/SUITE-Variable.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body class="d-flex justify-content-center">

<div id="wrap">
	<jsp:include page="/WEB-INF/jsp/gnb/header.jsp"/>

	<section>
		<div class="p-3">
			<h5 class="font-weight-bold text-center">내 정보</h5>
			<hr>
		</div>
		<div>
			<div class="d-flex justify-content-center p-2">
				<div class="box">
					<img class="profile" src="${profileImage }">
				</div>
			
			</div>
			<div class="d-flex justify-content-center p-2"><button id="changeProfileImageBtn" class="btn btn-primary">프로필 사진 변경하기</button></div>
			<input id="fileInput" type="file" accept="image/*" class="d-none">
		</div>
	
		<div class="mt-3">
			<div>
				<div>
					<h5 class="font-weight-bold">닉네임</h5>
					<div class="d-flex align-items-center justify-content-between">
						<div>${nickname}</div>
						<button class="font-size-small btn btn-primary" data-toggle="modal" data-target="#editNicknameModal">닉네임 변경하기</button>
					</div>
					<hr>
				</div>
				
				<div id="emailBtn">
					<h5 class="font-weight-bold">이메일</h5>
					<div>${email}</div>
					<hr>
				</div>
				
				<div id="removeProfileImage">
					<h5>프로필사진 삭제하기</h5>
					<hr>
				</div>
				
				<div id="editRoutine">
					<h5>목표 루틴 변경하기</h5>
					<hr>
				</div>
				
				<div id="editPassword">
					<h5>비밀번호 변경하기</h5>
					<hr>
				</div>
				
				<div id="logoutBtn">
					<h5>로그아웃</h5>
					<hr>
				</div>
				
				<div id="withdrwalBtn">
					<h5>회원탈퇴</h5>
					<hr>
				</div>
			</div>
		</div>
	
	</section>
	
	<!-- 닉네임 변경 모달 -->
	<div class="modal fade" id="editNicknameModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	<div>
	      		<label class="small font-weight-bold">변경할 닉네임을 입력해 주세요!</label>
	      		<div class="d-flex">
		      		<input id="newNickname" type="text" class="form-control">
		      		<button id="nicknameDupCheckBtn" class="btn btn-success small p-1 ml-3">중복 확인</button>
	      		</div>
	      		<div id="nicknameAvailableAlert" class="text-success">사용 가능한 닉네임이에요!</div>
	      		<div id="nicknameUnavailableAlert" class="text-danger">이미 사용 중인 닉네임이에요 :(</div>
	      	</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	        <button id="editNicknameSubmit" type="button" class="btn btn-primary">변경하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 닉네임 변경 모달 끝 -->
	
	<!-- 프로필사진 삭제 모달 -->
	<button id="removeProfileImageBtn" class="d-none" type="button" class="btn btn-primary" data-toggle="modal" data-target="#removeProfileImageModal">
	  Launch demo modal
	</button>
	
	<!-- Modal -->
	<div class="modal fade" id="removeProfileImageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	<div class="text-center pt-2">삭제된 프로필사진은 복구할 수 없어요.</div>
	      	<div class="text-center font-weight-bold p-2">정말 프로필사진을 삭제할까요?</div>
	      	<hr>
	      	<div class="d-flex justify-content-center">
		      	<button id="deleteImageSubmit" class="btn btn-warning">네, 프로필사진을 삭제할게요.</button><br>
	      	</div>
	      	<div class="d-flex justify-content-center  p-2">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	      	</div>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 프로필사진 삭제 모달 끝-->
	
	
	<!-- 목표루틴 변경 모달 -->
	<button id="editITRBtn" class="d-none" type="button" class="btn btn-primary" data-toggle="modal" data-target="#editITRModal">
	  Launch demo modal
	</button>
	
	<!-- Modal -->
	<div class="modal fade" id="editITRModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	<div class="text-center">현재 나의 목표 루틴</div>
	      	<div id="currentITR" class="text-center font-weight-bold">${ITRname}</div>
	      	<hr>
			  <select id="ITROptions" name="ITR" class="select form-control p-2">
			    <option disabled selected>변경할 목표 루틴 선택</option>
			    <option value="1">독서</option>
			    <option value="2">걷기</option>
			    <option value="3">운동</option>
			    <option value="4">먹기</option>
			  </select>
			  <div class="d-flex justify-content-center p-2">
				 <button id="changeITRsubmit" class="btn btn-primary">변경하기</button>
			  </div>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 프로필사진 삭제 모달 끝-->
	
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
			
			$("#changeITRsubmit").on("click",function(){
				var result = $("#ITROptions").val();
				if(result==null){
					alert("변경할 목표루틴을 선택해 주세요.");
					return;
				}
				$.ajax({
					url:"/rest/myinfo/edit-routine/submit"
					,type:"put"
					,data:{
						"ITRID":result
					}
					,success:function(data){
						if(data.result == "success"){
							alert("목표루틴을 변경했어요!");
							location.href="/main/myinfo"
						} else{
							alert("목표루틴을 변경하지 못했어요.");
						}
					}
					,error:function(){
						alert("목표루틴 변경 중에 오류가 발생헀어요.");
					}
				})
			});
			
			function ITRLister(listSize,ITRList){
				var html = "<option disabled selected>변경할 목표 루틴 선택</option>";
				for(var i = 1; i <= listSize; i++){
					html += "<option value='" + i + "'>" + ITRList[i] + "</option>";
				}
				return html;
			}
			
			$("#editRoutine").on("click",function(){
				$("#editITRBtn").click();
			});
			
			$("#editITRBtn").on("click",function(){
				$.ajax({
					url:"/rest/itr/list"
					,type:"get"
					,success:function(data){
						var ITRObject = data[1];
						var listSize = Object.keys(ITRObject).length;
						var ITRList = ITRLister(listSize,ITRObject);
						$("#ITROptions").html(ITRList);
					}
				})
			});
			
			$("#removeProfileImage").on("click",function(){
				$("#removeProfileImageBtn").click();
			});
			
			$("#deleteImageSubmit").on("click",function(){
				$.ajax({
					url:"/rest/myinfo/delete-image"
					,type:"post"
					,data:{"UID":${UID}}
					,success:function(data){
						if(data.result=="success"){
							alert("프로필이미지를 삭제했어요.");
							location.href="/main/myinfo";
						} else{
							alert("프로필이미지가 삭제되지 않았어요.");
						}
					}
					,error:function(){
						alert("프로필이미지 삭제 중에 에러가 발생했어요.");
					}
				})
			});
			

			var nicknameDupCheck = false;
			var newNickID = "";
			
			$("#nicknameAvailableAlert").hide();
			$("#nicknameUnavailableAlert").hide();


			$("#editNicknameSubmit").on("click",function(){
				if(!nicknameDupCheck){
					alert("닉네임 중복 확인을 해주세요");
					return;
				}
				$.ajax({
					url:"/reg/submit/set-nickname"
					,type:"post"
					,data:{
						"UID":${UID}
						,"NickID":newNickID
					}
					,success:function(data){
						if(data.result == "success"){
							$.ajax({
								type:"get"
								,url:"/rest/myinfo/updateNickID"
								,data:{
									"UID":${UID}
									,"NickID":newNickID
								}
								,success:function(data){
									if(data.result=="success"){
										$.ajax({
											type:"get"
											,url:"/reg/deletePrevNicksWhenChangesNick"
											,success:function(data){
												if(data.deletedCounts >= 1){
													alert("닉네임을 변경했어요!");
												} else{
													alert("기존 닉네임이 남아있어요.");
												}
											}
											,error:function(){
												alert("닉네임 변경 중 오류가 발생했어요.");
											}
										});
									} else{
										alert("새 닉네임이 설정되지 않았어요.");
									}
								}
								,error:function(){
									alert("새로운 닉네임을 설정하는데 오류가 발생했어요.");
								}
							})
							location.href="/main/myinfo";
						} else{
							alert("닉네임 변경에 실패했어요.");
						}
					}
					,error:function(){
						alert("닉네임 변경 중 오류가 발생했어요.");
					}
				})
			})
			
			
			$("#newNickname").on("focus",function(){
				if(newNickID != ""){
					$.ajax({
						type:"get"
						,url:"/reg/submit/reset-nickname-at-dupCheck"
						,data:{
							"NickID":newNickID
						}
						,success:function(){
							nicknameDupCheck = false;
							newNickID="";
							$("#nicknameAvailableAlert").hide();
						}
					})
				}
			});
			
			$("#nicknameDupCheckBtn").on("click",function(){
				
				var newNickname = $("#newNickname").val()
				nicknameDupCheck = false;

				if(newNickname != ""){
					$.ajax({
						type:"post"
						,url:"/reg/submit/if-nickname-duplicated"
						,data:{
							"nickname":newNickname
						}
						,success:function(data){
							if(data.isDuplicated == "false"){
								alert("사용 가능한 닉네임입니다.");
								nicknameDupCheck = true;
								newNickID = data.NickID;
								$("#nicknameUnavailableAlert").hide();
								$("#nicknameAvailableAlert").show();
							} else{
								alert("이미 사용중인 닉네임입니다.\다른 닉네임을 사용해 주세요");
								$("#nicknameUnavailableAlert").show();
								$("#nicknameAvailableAlert").hide();
								}
							}
						,error:function(){
							alert("닉네임 중복확인에 실패했습니다.\n다시 시도해 주세요.");
						}
					})
				}
			});
			
			var image = "";
			
			$("#logoutBtn").on("click",function(){
				location.href="/main/login/logout";
			});
			
			$("#editPassword").on("click",function(){
				location.href="/main/myinfo/editPW";
			});
			
			$("#changeProfileImageBtn").on("click",function(){
				$("#fileInput").click();
				var image = $("#fileInput")[0];
			});
			
			$("#fileInput").on("change",function(){
				var image = $("#fileInput")[0];
				var formData = new FormData();
				formData.append("image",image.files[0]);
				
				if(confirm("새로운 사진이 선택되었어요.\n프로필사진을 변경할까요?")){
					$.ajax({
						type:"post"
						,url:"/rest/myinfo/change-image"
						,data:formData
						,enctype:"multipart/form-data"
						,processData:false
						,contentType:false
						,success:function(data){
							if(data.result=="success"){
								alert("프로필 사진을 변경했어요!");
								location.reload();
							} else{
								alert("프로필 사진 변경을 실패했어요.");
							}
						}
						,error:function(){
							alert("프로필 사진 변경 중에 오류가 발생했습니다.");
						}
					})
				}
			});
			
			
			
		});
	</script>
</body>





</html>