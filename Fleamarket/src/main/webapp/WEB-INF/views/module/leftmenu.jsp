<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
왼쪽 메뉴
	<c:choose>
		<c:when test="${param.store_name != null}">
			<a href="#">상품</a>
			<a href="#">상점후기</a>
		</c:when>
		<c:when test="${param.member_email != '' }">
			<a href="/fleamarket/product/productlist?member_email=${member.member_email }">내 상품</a>
			<a href="/fleamarket/product/addproductform">물품등록</a>
			<a href="#">찜</a><!-- 내가 찜한 상품들 일종의 장바구니 -->
			<a href="#">상점후기</a>
			<a href="/fleamarket/jh_gy/gy_view/PaymentPagingAction_gy">구매내역</a>
			<a href="/fleamarket/jh_gy/gy_view/PaymentPagingSellController_gy">판매내역</a>
			<a href="#">정산</a>
		</c:when>
	</c:choose>
</body>
</html>