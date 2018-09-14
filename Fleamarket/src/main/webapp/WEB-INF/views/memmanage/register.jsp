<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<title>회원가입 화면</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/memmanage/js/member.js"></script>
<script src="../resources/memmanage/js/address.js"></script>

<!-- <script>
$(document).ready(function(){
	var email = $('#checkbtn').unbind("click").click(function(e){
		e.preventDefault();
		fn_emailCheck();	
	});
});

function fn_emailCheck(){
	var emailId = $("#memail").val();
	var userData = {"ID" : emailId}
	
	if(emailId.lenght < 1)
		{
		alert("dldididididi");
		}
	else
	{
		$.ajax({
			type : "POST",
			url : "/memmange/emailcheck",
			data : userData,
			dataType : "json",
			error : function(error){
				alert("서버가 응답하지 않습니다. \n 다시 시도해주시기 바랍니다.");
			},
			success : function(result){
				if(result == 0)
				{
				$("#memail").attr("disabled", true);
				alert("사용이 가능한 아이디입니다.");
				}
				else if(result ==1)
				{
				alert("이미 존재하는 아이디입니다. \n 다른 아이디를 사용해주세요.");	
				}
				else
				{
				alert("에러가 발생하였습니다.");
				}
			}
		});
	}	
}
</script> -->

<script>
$(document).ready(function(){
	$(".dupliId").click(function(){
		var id_frm = $("input[name=id]");
		var b = countId(); //javascript로 아이디에 대한 유효성검증을 먼저한다.
		var check = 0; //중복체크 했는지 나중에 확인할 때 쓸 변수
		if(b==true){   //유효성 검증을 통과하면
			$.ajax({
				type: 'POST',
				url: '/rest/member/checkDupl',
				data: {
					"id" : $(id_frm).val()
				},
				success: function(data){
					if(data==0){
						$('#dupli').html('<font size="2" color="green">사용할 수 있는 아이디</font>');
						check=1;
					}
					else{
						$('#dupli').html('<font size="2" color="red">'+$(id_frm).val()+'는 이미 존재하는 아이디입니다.</font>');
						$(id_frm).val(""); //form의 값을 지운다
						$(id_frm).focus(); //focus를 form에 위치시킨다
						check=0;
					}
				}
			});//end ajax 
		} //end if
	}); //end click event
}); //end jQuery

</script>

</head>
<body>
<div clss="container">
    <!-- 입력한 값을 전송하기 위해 form 태그를 사용  -->
    <!-- 값 전송은 post방식, 전송할 페이지는 login페이지 -->
  <article class="container">
  <div class="page-header">
    <h1> 회원가입 </h1>
  </div>
  <div class="col-md-6 col-md-offset-3">
    <form role="form" action="/fleamarket/memmanage/register" 
    method="post" name="frm" id="frm_id" onsubmit="return check();">
       
       <!-- 이메일주소 -->
       <div class="form-group">
         <label for="InputEmail">이메일 주소</label>
         <div class="input-group">
           <input type="email" class="form-control"
          id="memail" name="member_email" placeholder="이메일 주소를 입력하세요">
           <button type="submit" id="checkbtn" onclick="return emailcheck()" class="btn btn-default">중복확인</button>
           <div id ="checkMsg" class="input-group-btn"></div>
			

        </div>
      </div>
      
      <!-- 비밀번호 -->
      <div class="form-group">
        <label for="InputPassword1">비밀번호</label>
        <input type="password" class="form-control" 
        	id="mpw" name="member_pw" placeholder="비밀번호"
          	onkeyup="pwCheck();">
      </div>
      
      <!-- 비밀번호 확인 -->
      <div class="form-group">
        <label for="InputPassword2">비밀번호 확인</label>
        <p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
        <input type="password" class="form-control"
          id="chpw" name="member_pw2" placeholder="비밀번호 확인"
          onkeyup="pwCheck();">
        <h5 style="color: red;" id="passwordCheckMessage"></h5>
        
      </div>
      
      <!-- 이름 -->
      <div class="form-group">
        <label for="username">이름</label>
        <input type="text" class="form-control"
          id="mname" name="member_name" placeholder="이름을 입력해 주세요">
      </div>
      
      <!-- 연락처 -->
      <div class="form-group">
        <label for="username">전화번호</label>
        <input type="text" class="form-control"
          id="mphone" name="member_phone" placeholder="전화번호를 입력해 주세요">
      </div>
      
            <!-- 주소 -->
      <div class="form-group">
        <label for="username">주소</label>
        <div class="input-group">
          <input type="text" class="form-control"
            id="address" name="member_address" placeholder="주소">
          <span class="input-group-btn">
            <button class="btn btn-success" onclick="Postcode()">
              주소 찾기
            </button>
          </span>
        </div>
      </div>
      
      
      <!-- 상세주소 -->
      <div class="form-group">
      <label for="username">상세주소</label>
        <input type="text" class="form-control"
          id="address2" name="member_address2" placeholder="상세주소">
      </div>
  
      <!-- 버튼 -->
      <div class="form-group text-center">
        <input type="submit" name="submit" class="btn btn-info" value="회원가입">

        <input type="reset" class="btn btn-info" value="다시입력">
        
        <a href="/fleamarket/maindetail/mmain">
          <input type="button" class="btn btn-warning" value="가입취소">
        </a>
        
      </div>
    </form>
  </div>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->

	</div>
</body>
  
</html>