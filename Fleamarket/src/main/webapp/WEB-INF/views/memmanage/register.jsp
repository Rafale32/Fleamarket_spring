<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet"
  type="text/css" />
<title>회원가입 화면</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
  function Postcode() {
    new daum.Postcode({
      oncomplete : function(data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        var fullAddr = ''; // 최종 주소 변수
        var extraAddr = ''; // 조합형 주소 변수

        // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
          fullAddr = data.roadAddress;

        } else { // 사용자가 지번 주소를 선택했을 경우(J)
          fullAddr = data.jibunAddress;
        }

        // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
        if (data.userSelectedType === 'R') {
          //법정동명이 있을 경우 추가한다.
          if (data.bname !== '') {
            extraAddr += data.bname;
          }
          // 건물명이 있을 경우 추가한다.
          if (data.buildingName !== '') {
            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
                : data.buildingName);
          }
          // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
          fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.getElementById('address').value = fullAddr;

        // 커서를 상세주소 필드로 이동한다.
        document.getElementById('address2').focus();
      }
    }).open();
  }
</script>

</head>
<body>
    <!-- 입력한 값을 전송하기 위해 form 태그를 사용  -->
    <!-- 값 전송은 post방식, 전송할 페이지는 login페이지 -->
  <article class="container">
  <div class="page-header">
    <h1> 회원가입 </h1>
  </div>
  <div class="col-md-6 col-md-offset-3">
    <form role="form" action="/fleamarket/memmanage/register" method="post" name="frm">
       
       <!-- 이메일주소 -->
       <div class="form-group">
         <label for="InputEmail">이메일 주소</label>
         <div class="input-group">
           <input type="email" class="form-control"
          id="InputEmail" name="member_email" placeholder="이메일 주소">
          <span class="input-group-btn">
            <button class="btn btn-success">
              	중복 확인
            </button>
          </span>
        </div>
      </div>
      
      <input type="hidden" name="emailDuplication">
      
      <!-- 비밀번호 -->
      <div class="form-group">
        <label for="InputPassword1">비밀번호</label>
        <input type="password" class="form-control"
          id="InputPassword1" name="member_pw" placeholder="비밀번호"
          onkeyup="passwordCheckFunction();">
      </div>
      
      <!-- 비밀번호 확인 -->
      <div class="form-group">
        <label for="InputPassword2">비밀번호 확인</label>
        <input type="password" class="form-control"
          id="InputPassword2" name="member_pw2" placeholder="비밀번호 확인"
          onkeyup="passwordCheckFunction();">
        <h5 style="color: red;" id="passwordCheckMessage"></h5>
        <p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
      </div>
      
      <!-- 이름 -->
      <div class="form-group">
        <label for="username">이름</label>
        <input type="text" class="form-control"
          id="username" name="member_name" placeholder="이름을 입력해 주세요">
      </div>
      
      <!-- 연락처 -->
      <div class="form-group">
        <label for="username">연락처</label>
        <input type="text" class="form-control"
          id="" name="member_phone" placeholder="연락처를 입력해 주세요">
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
        <button type="submit" class="btn btn-info">회원가입</button>

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
  <script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>