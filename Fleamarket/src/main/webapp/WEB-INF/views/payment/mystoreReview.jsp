<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link rel="stylesheet" href="../gy_css/buySellTable.css" type="text/css">
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<script src="/resources/payment/cangeDeliveryst_gy.js"
	type="text/javascript">	
</script>
</head>
<body>

	<h1>도착확인용</h1>
	
	<div>
	<table id="Mystore_review" class="table" border="1">
		<c:forEach var="p" items="${list}">
			<tr>
				<td class="date">구매 날자 :${p.pay_date}</td>
				<td>구매자 이름 :${p.member_name}</td>
			</tr>
			<tr><td colspan="2">구매 title: ${p.itemboard_title}</td></tr>
			<tr><td colspan="2">리뷰 별점 :${p.review_star}</td></tr>
			<tr>
				<td colspan="2" height="50%"><c:choose>

						<c:when test="${p.review_star == 0}">
							<img alt="별점이미지"
								src="/fleamarket/resources/payment/img/star0.png">
						</c:when>

						<c:when test="${p.review_star == 1}">
							<img alt="별점이미지"
								src="/fleamarket/resources/payment/img/star1.png">

						</c:when>
						<c:when test="${p.review_star == 2}">
							<img alt="별점이미지"
								src="/fleamarket/resources/payment/img/star2.png">

						</c:when>
						<c:when test="${p.review_star == 3}">
							<img alt="별점이미지"
								src="/fleamarket/resources/payment/img/star3.png">

						</c:when>
						<c:when test="${p.review_star == 4}">
							<img alt="별점이미지"
								src="/fleamarket/resources/payment/img/star4.png">

						</c:when>
						<c:otherwise>
					 제대로된 상태가 아닙니다.
					</c:otherwise>

					</c:choose></td>
</tr>

				<tr><td colspan="2">리뷰 :${p.review_contents}</td></tr>

			<tr></tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>