	$(document).ready(function(){
		var UID = "${UID}";
		
		$.ajax({
			method:"post"
			,url:"/rest/activity/visit-up"
			,data:{
				"UID":UID
			}
			,success:function(data){
				if(data.result=="success"){
					alert("방문 1 올렸음");
				} else{
					alert("방문 안올렸음");
				}
			}
			,error:function(){
				alert("루티너그램은 로그인 후 사용할 수 있어요!\n로그인 화면으로 이동합니다.");
				window.location.replace("/greeting");	
			}
		})
		
	});