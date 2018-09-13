
function check() {
	
	//변수를 선언합니다.
	var emailCh = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
    var memail = document.getElementById("memail");
    var pw = document.getElementById("mpw");
	
	// 이메일이 적합한지 검사할 정규식
	
  	if (frm.memail.value == "") {
		alert("이메일을 입력해 주세요");
		frm.memail.focus();
		return false;
	}

	if(frm.mpw.value ==""){
		alert("비밀번호를 입력해 주세요");
		frm.mpw.focus();
		return false;
	}
	
    if (document.frm.mpw.value.length<4 || document.frm.mpw.value.length>12) {
        alert("비밀번호를 4~12자까지 입력해주세요.")
        document.frm.mpw.focus()
        document.frm.mpw.select()
        return false;
    }
	
  	if (frm.mname.value == "") {
		alert("이름을 입력해 주세요");
		frm.mname.focus();
		return false;
	}
	
	if (frm.mphone.value == "") {
		alert("전화번호를 입력해 주세요");
		frm.mphone.focus();
		return false;
	}
	
	if(frm.address.value == ""){
		alert("주소를 입력해 주세요");
		frm.address.focus();
		return false;
	}
	
	if(frm.address2.value == ""){
		alert("상세 주소를 입력해 주세요");
		frm.address2.focus();
		return false;
	}
} 

function pwCheck(){
	var mpw = $('#mpw').val();
	var chpw = $('#chpw').val();
	if(mpw != chpw){
		$('#passwordCheckMessage').html('비밀번호가 일치하지 않습니다.');
	}else{
		$('#passwordCheckMessage').html('');		
	}	
}


