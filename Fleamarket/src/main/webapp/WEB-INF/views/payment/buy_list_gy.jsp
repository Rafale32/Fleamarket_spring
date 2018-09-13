
<%@page import="javax.xml.crypto.KeySelector.Purpose"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("utf-8");

	//request.setAttribute("purchaseModel", list);
	/* 새로운 코드 */
	/* 	PaymentPagingService_gy daoservice = PaymentPagingService_gy.getInstance();
		PaymentPagingDTO_gy dao2 = new PaymentPagingDTO_gy();
		dao2 = daoservice.listBoardService(2, request);
		request.setAttribute("purchaseModel", dao2);  */
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
</script>
<style type="text/css">
</style>
<script type="text/javascript"
	src="../resources/payment/js/cangeDeliveryst_gy.js"></script>
<script type="text/javascript"></script>

</head>
<body>

	<%-- ${purchaseModel.list} --%>
	<table id="sell_list_table" frame="void" class="table">
		<c:forEach var="p" items="${list}">
			<tr id="date_tabletop">
				<td colspan="4" class="date">날자 :${p.pay_date}</td>
			</tr>
			

			<!-- 테이블 내용-->
			<tr>
				<%-- 왼쪽이미지 ${p.thum_img}   width="200px" height="150px"--%>
				<td><img alt="물품임시이미지"
					src="/fleamarket/resources/payment/img/${p.thum_img}.jpg"
					width="200px" height="150px" style="margin-left: 50px;"></td>

				<td>
					<!-- 거래 상태를 볼수 있는 코드 1~4까지 있고 설명을 적어 놓았고 나중에 이미지 파일로 변경하면 됨  --> <c:choose>
						<c:when test="${p.item_delivery_state== 1}">
							<img alt="배송이미지" src="/fleamarket/resources/payment/img/d1.png">
							<!-- 1 = 판매중인 상태 -->
						</c:when>
						<c:when test="${p.item_delivery_state == 2}">
							<img alt="배송이미지" src="/fleamarket/resources/payment/img/d2.png">
							<!-- 	2 = 결제완료후 준비중 -->
						</c:when>
						<c:when test="${p.item_delivery_state == 3}">
							<img alt="배송이미지" src="/fleamarket/resources/payment/img/d3.png">
							<!-- 	3 = 배송중(판매자 판매승인) -->
						</c:when>
						<c:when test="${p.item_delivery_state == 4}">
							<img alt="배송이미지" src="/fleamarket/resources/payment/img/d4.png">
							<!-- 4 = 구매자 구매완료 =거래완료 -->
						</c:when>
						<c:otherwise>
					 제대로된 상태가 아닙니다.
					</c:otherwise>

					</c:choose>

				</td>

				<td>
					<!-- 구매 상점으로 이동하기  -->
					<!-- 상품명 클릭시 해당 하는 상품글 이동 -->
					<a href="/fleamarket/maindetail/detail?itemboard_no=${p.item_no }">  <h2>제목(상품명) ${p.itemboard_title}</h2> </a>
					<h2> ${p.itemboard_no }</h2>
					<h4>구매상점 ${p.store_name }</h4>
					<!-- 상품가격 클릭시 해당 하는 상품결제 상세로 갈것 -->
					<a href="/safepay/order_detail?item_no=${p.item_no }"><h3>구매가격: ${p.item_price}</h3></a>
				</td>

				<td>
					<!-- 	<form action="/Fleamarket3/payment/changeDeliveryChack_gy.do"> -->

					<form action="/fleamarket/payment/buy_list_gy" method="post">
						<!-- style="display: none;"  나중에 넣어서 추가 할것-->
						<input type="text" value="${p.itemboard_no }">
						<input type="text" name="purchaseNo" value="${p.item_no}"
							style="display: none">
						<c:if test="${p.item_delivery_state == 3}">
							<input type="text" id="pageNo" name="pageNo"
								value="${purchaseModel.requestPage }" style="display: none">
							<input type="text" id="item_no" name="item_no"
								value="${p.item_no}" style="display: none">
							<input type="submit" id="purchaseDetermin" class="btn"
								value="구매확정버튼">
						</c:if>
					</form> 
					<a href="/fleamarket/payment/purchasestoreReview2?store_no=${p.store_no }"><input class="btn"
						value="리뷰확인하러가기"></a> <!-- 버튼 시험작 만들기-->
				</td>
			</tr>
			
		</c:forEach>

	</table>

	<!-- 페이지 메이커 사용 -->

	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a
					href="buy_list_gy${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="buy_list_gy${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="buy_list_gy${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
		</div>
</body>
</html>