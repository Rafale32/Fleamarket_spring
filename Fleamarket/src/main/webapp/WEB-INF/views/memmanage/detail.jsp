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
<title>내 정보보기</title>
<script type="text/javascript">
  function deleteCheck(e) {
    if (confirm("삭제 하시겠습니까?")) {
      var url = "/fleamarket/memmanage/delete?member_email=" + member_email;
      location.href = url;
      return true;
    } else {
      alert("삭제 취소 되었습니다.");
      return false;
    }
  }
</script>
<style type="text/css">
.centerBtn{
  
  width: 300px;
  margin: 0 auto;
}
h3{
  text-align: center;
}
.infoTable{
width: 300px !important;
margin: 0 auto;
}
.infoTable td{
  text-align: right;
}
.infoTable th{
  text-align: left;
}

</style>
</head>
<body>
  <div class="container">
    <form action="/fleamarket/memmanage/detail" method="post" name="frm">
      <table class="table infoTable">
        <tr>
          <td colspan="2"><h3>내 정보</h3></td>
        </tr>
        <tr>
          <th>이 메 일</th>
          <td>${memManageDTO.member_email }</td>
        </tr>
        <tr>
          <th>이    름</th>
          <td>${memManageDTO.member_name}</td>
        </tr>
        <tr>
          <th>전화번호</th>
          <td>${memManageDTO.member_phone }</td>
        </tr>
        <tr>
          <th>주    소</th>
          <td>${memManageDTO.member_address }</td>
        </tr>
        <tr>
          <th>상세주소</th>
          <td>${memManageDTO.member_address2 }</td>
        </tr>
        <tr>
        <td colspan="2"></td>
        </tr>
      </table>
      
      <div class="centerBtn">
      &nbsp;
        <a href="/fleamarket/memmanage/update?member_email=${memManageDTO.member_email }">
          <input type="button" value="정보수정 " class="btn btn-info">
        </a>&nbsp;&nbsp;&nbsp;
        <a href="/fleamarket/memmanage/delete?member_email=${memManageDTO.member_email }"
           onclick="return deleteCheck();">
          <input type="button" value="회원탈퇴" class="btn btn-danger">
        </a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/fleamarket/maindetail/mmain">
          <input type="button" value="메인가기" class="btn btn-warning">
        </a>
      </div>
    </form>
  </div>
</body>
</html>