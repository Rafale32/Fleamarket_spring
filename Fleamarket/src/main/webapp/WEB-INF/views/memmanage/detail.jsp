<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet" xtype="text/css" />
<title>내 정보보기</title>
<script type="text/javascript">
	
function deleteCheck(e){
	if (confirm("삭제 하시겠습니까?")) {
		var url = "/fleamarket/memmanage/delete?member_email="+member_email;
		location.href = url;
		return true;
	} else {
		alert("삭제 취소 되었습니다.");	
		return false;
	}
}

</script>
</head>
<body>
	<form action="/fleamarket/memmanage/detail" method="post" name="frm" >
	<h3>상세보기</h3>
	<table width="500" border="2" cellpadding="0.5" cellspacing="0">
		<tr> 
			<th>이메일</th>	
		 	<td>${memManageDTO.member_email }</td>
		</tr>
		<tr>
			<th> 이   름</th> 
		 	<td> ${memManageDTO.member_name}</td>
		</tr>
		<tr> 
			<th>전화번호</th>
			<td> ${memManageDTO.member_phone }</td>
		</tr>
		<tr> 
			<th>주소</th>
		 	<td>${memManageDTO.member_address }</td>
		</tr>
		<tr> 
			<th>상세주소</th>
		 	<td>${memManageDTO.member_address2 }</td>
		</tr> 
	</table>
	
	
	<a href="/fleamarket/maindetail/mmain"><input type="button" value="메인" ></a>
 	<a href="/fleamarket/memmanage/update?member_email=${memManageDTO.member_email }"> 
	<input type="button" value="회원정보수정 "></a>
	<a href="/fleamarket/memmanage/delete?member_email=${memManageDTO.member_email }" onclick="return deleteCheck();">
	<input type="button" value="회원탈퇴"> </a>

	</form> 
	
</body>
</html>