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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/memmanage/js/address.js"></script>
<script src="../resources/memmanage/js/member.js"></script>

<title>정보 수정</title>

</head>
<body>
  <div class="container">
    <article class="container">
    <div class="page-header text-center">
      <h1>정보수정</h1>
    </div>
    <div class="col-md-6 col-md-offset-3">
      <form action="/fleamarket/memmanage/update" method="post"
        name="frm" id="frm_id" onsubmit="return check();">  
        
        <!-- 이메일 넘길거 -->
        <div class="form-group">
          <label for="InputEmail">이메일 주소</label>
          <div class="input-group">
            <input type="email" name="member_email" id="member_email" class="form-control"
              value="${memManageDTO.member_email }" readonly="readonly">
          </div>
        </div>
        <!-- 비밀번호 -->
        <div class="form-group">
          <label for="InputPassword1">비밀번호</label> <input
            type="password" name="member_pw" id="mpw"
            class="form-control">
        </div>
        <!-- 이름 -->
        <div class="form-group">
          <label for="username">이름</label> <input type="text"
            name="member_name" id="mname" class="form-control"
            value="${memManageDTO.member_name}">
        </div>
        <!-- 연락처 -->
        <div class="form-group">
          <label for="username">전화번호</label> <input type="text"
            name="member_phone" id="mphone" class="form-control"
            value="${memManageDTO.member_phone }">
        </div>
        <!-- 주소 -->
        <div class="form-group">
          <label for="username">주소</label>
          <div class="input-group">
            <input type="text" class="form-control" id="address"
              name="member_address" placeholder="주소"
              value="${memManageDTO.member_address }">
              <span class="input-group-btn">
                <button class="btn btn-success" onclick="Postcode()">
                주소 찾기
                </button>
              </span>
          </div><br>
          <!-- 상세주소 -->
          <div class="form-group">
            <label for="username">상세주소</label>
            <input type="text"
              class="form-control" id="address2" name="member_address2"
              placeholder="상세주소"
              value="${memManageDTO.member_address2 }"> <br>
          </div>
          
          <div class="form-group text-center">
            <input type="submit" value="확인" class="btn btn-info">
            <input type="reset" value="다시 작성" class="btn btn-warning">
          </div>
        </div>
      </form>
    </div>
    </article>
  </div>
</body>
</html>