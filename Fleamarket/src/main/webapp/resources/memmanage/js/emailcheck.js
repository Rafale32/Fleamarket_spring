
$(document).ready(function(){
	// ID 중복체크
	 	$("#btnCheckId").click(function(){
			var loginId = $("#member_email").val(); //입력한 loginId 값 가져와서 loginId 변수에 저장
			console.log("loginId ======>" + loginId);
			if(loginId==""){ //입력값이 없으면
				alert("ID를 먼저 입력해주세요");
			} else { // 중복검사 실행
				var url = "/fleamarket/memmanage/emailcheck?member_email="+loginId;
				$.get(url,function(data){
					if(data == 0){	// 아이디 사용 가능
						alert("사용 가능한 ID 입니다.");
						$("#checkedId").val("Y");
					} else {
						alert("이미 사용중인 ID 입니다.");
						$("#checkedId").val("N");
					}
				});
			}
		
		});  
	});	 

