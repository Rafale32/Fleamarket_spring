<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet" xtype="text/css" />
<title>정보 수정</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/memmanage/js/address.js"></script>
<script src="../resources/memmanage/js/member.js"></script>

</head>
<body>
	<h1>정보 수정</h1>
	<form action="/fleamarket/memmanage/update" method="post" name="frm" id="frm_id" onsubmit="return check();">

	<!-- 이메일 넘길거 -->
	<table>
		<tr>
			<th> 이메일  </th>
		 	<td><input type="text" name="member_email" value="${memManageDTO.member_email }" readonly= "readonly"></td>
		</tr>			
		<tr>
			<th> 비밀번호</th>
			<td><input type="password" name="member_pw" id="mpw"></td>
		</tr>
		<tr>
			<th> 이   름</th> 
		 	<td><input type="text" name="member_name" id="mname" value= "${memManageDTO.member_name}"></td>
		</tr>
		<tr> 
			<th>전화번호</th>
			<td><input type="text" name="member_phone" id="mphone" value= "${memManageDTO.member_phone }"></td>
		</tr>
		<tr> 
			<th>주소</th>
			<td><input type="button" onclick="Postcode()" value="주소 찾기">
		 	<input type="text" id="address"  name="member_address" value= "${memManageDTO.member_address }"></td>
		</tr>
		<tr> 
			<th>상세주소</th>
		 	<td><input type="text" id="address2" name="member_address2" value= "${memManageDTO.member_address2 }"></td>
		</tr> 	
	</table>
	<br>
	<input type="submit" value="확인" >
	<!-- </a> -->
	<input type="reset" value="다시 작성">
	
	</form>
</body>
</html>