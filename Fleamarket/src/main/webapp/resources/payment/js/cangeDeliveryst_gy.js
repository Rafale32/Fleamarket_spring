/**
 * 
 */
// 구매 확정, 판매 내역 등등의 값을 변경하는 메소드가 있는 자바스크립트 코드입니다.
  window.onload = function() {
	  var header = document.getElementById('purchaseDetermin');
		 header.onclick = function (){
		  var con_test = confirm("구매확정 하시겠습니까?");
		  if(con_test == true){
			  alert("구매 확정 되었습니다.");
		  }
		  else if(con_test == false){
			  alert("취소 되었습니다.");
		    return false;
		  }
		};
	  
  };