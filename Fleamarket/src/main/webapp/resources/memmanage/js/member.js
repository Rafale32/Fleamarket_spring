
function validate() {
	var passwordCheck = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
	var emailCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 이메일이 적합한지 검사할 정규식

	var mail = document.getElementById("email");
	var pw = document.getElementById("pw");
	var num1 = document.getElementById("unum1");
	var num2 = document.getElementById("unum2");

	// ------------ 이메일 까지 -----------

	if (!check(emailCheck, email, "아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
		return false;
	}

	if (!check(re, pw, "패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
		return false;
	}

	if (frm.mpw.value != frm.chpw.value) {
		alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
		join.chpw.value = "";
		join.chpw.focus();
		return false;
	}

	if (frm.mname.value == "") {
		alert("이름을 입력해 주세요");
		join.mname.focus();
		return false;
	}
	
	if (frm.mphone.value == "") {
		alert("전화번호를 입력해 주세요");
		join.mphone.focus();
		return false;
	}
	
	if(frm.maddress.value == ""){
		alert("주소를 입력해 주세요");
		join.maddress.focus();
		return false;
	}
	
	if(join.maddress2.value == ""){
		alert("주소를 입력해 주세요");
		join.maddress2.focus();
		return false;
	}

}

function check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
	// return false;
}