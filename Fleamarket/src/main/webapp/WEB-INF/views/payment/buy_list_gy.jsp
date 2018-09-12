
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


<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet"
  type="text/css" />
<script type="text/javascript"> </script>
<style type="text/css">
</style>
<script type="text/javascript" src="../resources/payment/js/cangeDeliveryst_gy.js"></script>
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
				<td> 
				
				<img alt="물품임시이미지" src="/fleamarket/resources/payment/img/${p.thum_img}.jpg" width="200px" height="150px" style="margin-left: 50px;">
				
				</td>

				<td>
				<!-- 거래 상태를 볼수 있는 코드 1~4까지 있고 설명을 적어 놓았고 나중에 이미지 파일로 변경하면 됨  -->
				 <c:choose>
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
				<a href="">  <h2>제목(상품명) ${p.itemboard_title}</h2> </a>	
					<h4>구매상점 ${p.store_name }</h4>
					<h3>구매가격 : ${p.item_price }</h3>

				</td>

				<td>
			<!-- 	<form action="/Fleamarket3/payment/changeDeliveryChack_gy.do"> -->
			
				<form action="/fleamarket/payment/buy_list_gy" method="post">
				<!-- style="display: none;"  나중에 넣어서 추가 할것-->
					<input type="text" name="purchaseNo" value="${p.item_no}" style="display: none;" >
					<c:if test="${p.item_delivery_state == 3}">
					<input type="text" id="pageNo" name="pageNo" value="${purchaseModel.requestPage }">
					<input type="text" id="item_no" name="item_no" value="${p.item_no}" >
					<input type="submit" id="purchaseDetermin" class="btn" value="구매확정버튼" >
					</c:if>
				</form>
					<a href="/fleamarket/payment/mystoreReview"><input class="btn" value="내가쓴리뷰확인하기"></a>

				</td>
			</tr>

		</c:forEach>
		
	</table>
	
	<!-- 5페이지 이동 바꿀수 있음 전체 페이지가 나오기위해 5보다 크면되잖아? 스타트 페이지가-->
	<c:if test="${purchaseModel.startPage > 5 }">
	<a href="PaymentPagingAction_gy.gy?pageNum=${purchaseModel.requestPage-5}"> [ 이 전 페이지로...]</a>
	</c:if>
	
	<c:if test="${purchaseModel.requestPage >= 2 }">
		<a href="PaymentPagingAction_gy.gy?pageNum=${purchaseModel.requestPage-1}"> [ 이 전 ]</a>
		</c:if>
		
	<!-- 목록 출력을 위한 코드 -->
	<c:forEach var="pageNo" begin="${purchaseModel.startPage }" end="${purchaseModel.endPage }">
	<!-- 현제 페이지 굵게 -->
	<c:if test="${pageNo == purchaseModel.requestPage}" > <b></c:if>
		<a href="PaymentPagingAction_gy.gy?pageNum=${pageNo}"> ${pageNo}</a>
		<c:if test="${pageNo == purchaseModel.requestPage}" > </b></c:if>
		
		</c:forEach>
		
		<c:if test="${purchaseModel.requestPage < purchaseModel.endPage}">
		<a href="PaymentPagingAction_gy.gy?pageNum=${purchaseModel.requestPage+1}"> [ 다 음 ]</a>
		</c:if>
		
		<!-- 5개 이동  -->
		<c:if test="${purchaseModel.totalPageCount > purchaseModel.endPage }">
		<a href="PaymentPagingAction_gy.gy?pageNum=${purchaseModel.requestPage+5}"> [ 다 음 페이지로...]</a>
		</c:if>

</body>
</html>