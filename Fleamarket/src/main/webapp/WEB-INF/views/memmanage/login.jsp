<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = login>
		<acricle class="login">
			<header>
				<h2>로그인</h2>
			</header>
		</acricle>
	<form action="/fleamarket/memmanage/loginpost" method="post" name="frm">
		<table>
			<tr> 
			<td>아이디</td>
			<td><input id="uId" name="member_email" value="${member_email }"></td>
			</tr>
			<tr>
			<td>비번 </td>
			<td><input type="password" name="member_pw"></td>
			</tr>
			<tr>
			<td colspan="2" aling="center">
			<input type="submit" value="로그인" >
			</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>