<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	/* SellProductDAO_gy dao = SellProductDAO_gy.getInstance();
	List<SellProductDTO_gy> list = dao.listBoard();
	request.setAttribute("SellModel", list); */
	
 	/* PaymentPagingService_gy daoservice = PaymentPagingService_gy.getInstance();
	PaymentPagingDTO_gy dao2 = new PaymentPagingDTO_gy();
	dao2 = daoservice.listBoardService2(2, request); 
	request.setAttribute("SellModel2", dao2);   */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
 <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link rel="stylesheet" href="../gy_css/buySellTable.css" type="text/css">
<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet"
  type="text/css" />
  
  <script src="/resources/payment/cangeDeliveryst_gy.js" type="text/javascript"> 
  </script>
  <script type="text/javascript">
  window.onload = function() {
	  var header = document.getElementById('purchaseDetermin');
		 header.onclick = function (){
		  var con_test = confirm("판매 승인을 하시겠습니까?");
		  if(con_test == true){
		    alert("승인 확정 되었습니다.");
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


	<table id="sell_list_table" class="table">
		<c:forEach var = "p" items="${list}">
		<tr>
			<td colspan="4" class="date">날자부 :${p.pay_date }  아이템 보드 ${p.itemboard_no }</td>
		</tr>

		
			<!-- 테이블 내용-->
			<tr>
			<!-- 추후 이미지 경로 src 만 수정 하면 됨 -->
				<td> <%-- ${p.thum_img} --%> <img alt="물품임시이미지" src="/fleamarket/resources/payment/img/${p.thum_img}.jpg" width="200px" height="150px"></td>
				
				<td>
				<!-- 거래 상태를 볼수 있는 코드 1~4까지 있고 설명을 적어 놓았고 나중에 이미지 파일로 변경하면 됨  -->
				 <c:choose>
						<c:when test="${p.item_delivery_state == 1}">
						<img alt="배송이미지" src="/fleamarket/resources/payment/img/d1.png">
						
						</c:when>
						<c:when test="${p.item_delivery_state == 2}">
						<img alt="배송이미지" src="/fleamarket/resources/payment/img/d2.png">
					
						</c:when>
						<c:when test="${p.item_delivery_state == 3}">
						<img alt="배송이미지" src="/fleamarket/resources/payment/img/d3.png">
				
						</c:when>
						<c:when test="${p.item_delivery_state == 4}">
						<img alt="배송이미지" src="/fleamarket/resources/payment/img/d4.png">
					
						</c:when>
					<c:otherwise>
					 제대로된 상태가 아닙니다.
					</c:otherwise>

				</c:choose>

				</td>

				<td>
				
				<!-- 판매 = 내 상점으로 이동하기  -->
					<!-- 상품명 클릭시 해당 하는 상품글 이동 -->
					<a href="/fleamarket/maindetail/detail?itemboard_no=${p.item_no }">  <h2>제목(상품명) ${p.itemboard_title}</h2> </a>
					<!-- 상품가격 클릭시 해당 하는 상품결제 상세로 갈것 -->
					<a href="/safepay/order_detail?item_no=${p.item_no }"><h3>판매금액 ${p.item_price}</h3></a>

				</td>

				<td>
					<form action="/fleamarket/payment/sell_list_gy" method="post">
				<!-- style="display: none;"  나중에 넣어서 추가 할것-->
					<c:if test="${p.item_delivery_state == 2}">
					<input type="text" id=ite_boardno name="itemboard_no" value="${p.itemboard_no }">
					<input type="text" id="pageNo" name="pageNo" value=${SellModel2.requestPage }>
					<input type="text" id="item_no" name="item_no" value=${p.item_no } >
					<input type="submit" id="purchaseDetermin" class="btn" value="판매승인버튼" >
					</c:if>
					<br>
					<a href="/fleamarket/payment/mystoreReview"><input class="btn" value="내가 판 물품 리뷰확인하기"></a>
				</form>

				</td>
			</tr>

	</c:forEach>


	</table>
		<!-- 페이지 메이커 사용 -->

	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a
					href="sell_list_gy${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="sell_list_gy${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="sell_list_gy${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
		</div>

</body>
</html>