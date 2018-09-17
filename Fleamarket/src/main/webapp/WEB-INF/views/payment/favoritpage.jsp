<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
 <script type="text/javascript">
  window.onload = function() {
	  var header = document.getElementById('purchaseDetermin');
		 header.onclick = function (){
		  var con_test = confirm("찜 항목을 삭제 하시겠습니까?");
		  if(con_test == true){
		    alert("삭제 되었습니다.");
		  }
		  else if(con_test == false){
		    alert("취소 되었습니다.");
		    return false;
		  }
		};
	  
  };
  
  </script>
</head>
<body>
	<table id="favorit_list_table" frame="void" class="table">
	
		<c:forEach var="p" items="${list}">
		<tr>
			<td>
			<img alt="물품임시이미지"
					src="/fleamarket/resources/payment/img/${p.thum_img}.jpg"
					width="200px" height="150px" style="margin-left: 50px;"></td>
					
					
				<td>
					<!-- 구매 상점으로 이동하기  --> <!-- 상품명 클릭시 해당 하는 상품글 이동 --> <a
					href="/fleamarket/maindetail/detail?itemboard_no=${p.item_no }">
						<h2>제목(상품명) ${p.itemboard_title}</h2>
				</a> <%-- <h2> ${p.itemboard_no }</h2> --%>
					<h3>가격:	${p.item_price}</h3>
					<h2>거래 가능 지역 : ${p.itemboard_local }</h2>
				</td>
				
			<td>
				<form action="/fleamarket/payment/favoritpage" method="post">
						<!-- style="display: none;"  나중에 넣어서 추가 할것-->
						<input type="text" name="itemboard_no" value="${p.itemboard_no }" style="display: none">
							<input type="submit" id="purchaseDetermin" class="btn"
								value="찜 삭제">
					</form>
			</td>
			</tr>
		</c:forEach>
		
		</table>
		
		<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a
					href="favoritpage${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="favoritpage${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="favoritpage${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>