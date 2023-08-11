$(document).ready(function(){


    if (UID != "null") {
        $.ajax({
            method: "post",
            url: "/rest/activity/visit-up",
            data: {
                "UID": UID
            }
        });
    } else {
        alert("루티너그램은 로그인 후 사용할 수 있어요!\n로그인 화면으로 이동합니다.");
        window.location.replace("/greeting");    
    }
});