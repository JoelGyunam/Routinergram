<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<header class="bg-success d-flex justify-content-between align-items-center">
		<div class="col-1 ml-3">
		</div>
		<div id="productTitle">루티너그램</div>
		<button id="heartBtn" class="col-1 mr-3 btn btn-transparent" onclick="location.href=`/main/myinfo/notification`">
			<h5><i id="heartIcon" class="bi bi-heart-fill text-white"></i></h5>
		</button>
	</header>
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function(){
			
			$("#productTitle").on("click",function(){
				location.href="/greeting";				
			});
			
			$.ajax({
				type:"post"
				,url:"/rest/myinfo/notification/unseenCheck"
				,data:{"UID":${UID}}
				,success:function(data){
					if(data.result==false){
						$("#heartIcon").removeClass("bi-heart-fill");
						$("#heartIcon").addClass("bi-heart");
					} else{
						$("#heartIcon").addClass("bi-heart-fill");
						$("#heartIcon").removeClass("bi-heart");
					}
				}
			})
		})
	</script>