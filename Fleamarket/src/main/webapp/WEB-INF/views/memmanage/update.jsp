<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet" xtype="text/css" />
<title>정보 수정</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
    function Postcode() {
        new daum.Postcode({
            oncomplete: function(data) {
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
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
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
	<h1>정보 수정</h1>
	<form action="/fleamarket/memmanage/update" method="post" name="frm">
	<input type="hidden" name="command" value="updateMember">
	<!-- 이메일 넘길거 -->
	<input type="hidden" name="member_email" value="${memManageDTO.member_email }">
	<table>
		<tr>
			<th> 이메일  </th>
		 	<td><input type="text" name="member_email" value="${memManageDTO.member_email }" readonly= "readonly"></td>
		</tr>			
		<tr>
			<th> 비밀번호</th>
			<td><input type="password" name="member_pw"></td>
		</tr>
		<tr>
			<th> 이   름</th> 
		 	<td><input type="text" name="member_name" value= "${memManageDTO.member_name}"></td>
		</tr>
		<tr> 
			<th>전화번호</th>
			<td><input type="text" name="member_phone" value= "${memManageDTO.member_phone }"></td>
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
	<%-- <a href="/fleamarket/memmanage/update?member_email=${member_email }">	 --%>
	<input type="submit" value="확인" >
	<!-- </a> -->
	<input type="reset" value="다시 작성">
	
	</form>
</body>
</html>