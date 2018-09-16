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

<script>
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
// 				if(data.code > 0){	// 아이디 사용 가능
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
 	
/* 	
	$("#member_email").blur(function(){
		console.log($(this).val());
	}); */
});	 
</script>

</head>
<body>
<div clss="container">
    <!-- 입력한 값을 전송하기 위해 form 태그를 사용  -->
    <!-- 값 전송은 post방식, 전송할 페이지는 login페이지 -->
  <article class="container">
  <div class="page-header  text-center">
    <h1> 회원가입 </h1>
  
  </div>
  <div class="col-md-6 col-md-offset-3">
    <form role="form" action="/fleamarket/memmanage/register" 
    method="post" name="frm" id="frm_id" onsubmit="return check();">
    <input type="hidden" id=checkedId" value="N">
       <!-- 이메일주소 -->
       <div class="form-group">
         <label for="InputEmail">이메일 주소</label>
         <div class="input-group">
           <input type="email" class="form-control"
          id="member_email" name="member_email" placeholder="이메일 주소를 입력하세요">
           <a href ="javascript:;" id="btnCheckId" class="checkId">중복확인</a>
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