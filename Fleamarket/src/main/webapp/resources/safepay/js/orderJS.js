// 20180816 천재헌
// 결제페이지 주소검색
function search_address() {
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
        // 법정동명이 있을 경우 추가한다.
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
      document.getElementById('delivery_address').value = fullAddr;

      // 커서를 상세주소 필드로 이동한다.
      document.getElementById('delivery_address2').focus();
    }
  }).open();
}// search_address

// 20180818 재헌 포인트전액사용
function allPoint(point) {
  document.getElementById('usePoint').value = point;
  changePoint();
}

// 20180818 재헌 결제 값 계산
function changePoint() {
  // 포인트
  // point => 입력 포인트 가져오기
  // #finalpoint => 문자형으로 포인트 입력
  // final2point => 실제 넘길 숫자형 값 입력
  // havepoint => 현재 보유 포인트
  // 
  var point = document.getElementById('usePoint').value; // 포인트 가져오고
  point = isNaN(point) ? 0 : point; // 숫자인지 확인
  var strPoint = setComma(point);

  $('#finalPoint').text(strPoint + '원'); // 포인트 적고
  document.getElementById('finalPoint2').value = point;// 인풋에 값도 바꿔준다.

  // 보유포인트
  var str = $('#havePoint').text().replace(/\n/g, '');
  str = str.replace(/\s/g, '');
  str = str.replace(/,/g, '');
  str = str.replace(/원/g, '');

  var havePoint = parseInt(str);

  // 현재 가진 포인트보다 많을 경우 경고창 띄우고 0으로 셋팅
  if (point > havePoint) {
    alert('보유하신 포인트보다 많이 입력 하셨습니다.');
    point = 0;
    allPoint(point); // 값 0
    $('#finalPoint').text(0 + '원');
    document.getElementById('finalPoint2').value = point;
  }

  // price => 상품 가격
  // 가격
  var str = $('#price').text().replace(/\n/g, '');
  str = str.replace(/\s/g, '');
  str = str.replace(/,/g, '');
  str = str.replace(/원/g, '');
  var price = parseInt(str);

  // 수수료
  // fee => (상품가격 * 3%) + 1000
  var fee = (price * 0.03) + 1000;

  // 배송비
  // deliFe => 배송비
  // #delivery_fee => 배송비 칸에 텍스트 입력
  var deliFee = 0;
  var str = $('#delivery_fee').text();
  str = str.replace(/\n/g, '');
  str = str.replace(/\s/g, '');
  str = str.replace(/,/g, '');

  if (str != '무료배송') {
    str = str.replace(/,/g, '');
    str = str.replace(/원/g, '');

    deliFee = parseInt(str);
  }

  // 최종결제금액
  // total => 최종금액
  // 
  var total = 0;
  
  total = price + fee + deliFee - point;
  var strTotal = setComma(total);

  // 히든 인풋 넘길 값
  // 총금액

  $('#total').text(strTotal + '원'); //text
  document.getElementById('total2').value = parseInt(total); //int


  // 계산된 포인트
  var totalPoint = havePoint - point + (total * 0.001);
  document.getElementById('point').value = parseInt(totalPoint);
}

// 20180820 재헌 쉼표 세팅 함수
function setComma(n) {
  // 정규표현식 : (+- 존재하거나 존재 안함, 숫자가 1개 이상), (숫자가 3개씩 반복)
  var reg = /(^[+-]?\d+)(\d{3})/;

  n += ''; // 문자변환
  while (reg.test(n)) {
    // replace 정규표현식으로 3자리씩 콤마 처리
    n = n.replace(reg, '$1' + ',' + '$2');
  }
  return n;
}// setComma

// 20180822 재헌 결제시 확인창
function payCheck(e) {

  if ($('input:checkbox[id="chk"]').is(":checked") == true) {
    if (confirm("결제 하시겠습니까?")) {
      alert('결제 되었습니다.');
      return true;
    } else {
      alert("취소하셨습니다.");
      return false;
    }
  } else {
    alert("약관에 동의해주세요.");
    return false;
  }

}
