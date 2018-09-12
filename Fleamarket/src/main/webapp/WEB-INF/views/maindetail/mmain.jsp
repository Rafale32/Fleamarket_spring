<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.home-recommend-item {
	width: 1024px;
}

.hot-item {
	width: 1024px;
	height: auto;
	display: block;
	margin: 0 auto;
}

.recommend-title {
	width: 1024px;
	height: 36px;
	padding-top: 50px;
	padding-bottom: 22px;
}

.carousel {
	width: 1024px;
}

.title {
	font-size: 23px;
	font-weight: bolder;
}

.item-wrapper {
	width: 244px;
	height: 360px;
	margin-right: 16px;
}

.recommend-item {
	width: 244px;
	padding-top: 30px;
}

.recommend-img {
	width: 194px;
	height: 194px;
	margin: auto;
	margin-bottom: 16px;
}

.img {
	width: 194px;
	height: 194px;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-7isi {
	font-weight: bold;
	font-size: 14px;
	background-color: #efefef;
	color: #333333;
	border-color: #343434;
	text-align: center;
	vertical-align: top
}

.tg .tg-i5o6 {
	font-size: 100%;
	background-color: #efefef;
	color: #000000;
	border-color: #343434;
	text-align: center;
	vertical-align: top
}

.tg .tg-p5e1 {
	font-size: 10px;
	background-color: #efefef;
	color: #333333;
	border-color: #343434;
	text-align: center;
	vertical-align: top
}

.tg2 {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg2 td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: white;
}

.tg2 th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: white;
}

.tg2 .tg-7isi {
	font-weight: bold;
	font-size: 14px;
	background-color: #efefef;
	color: #333333;
	border-color: #343434;
	text-align: center;
	vertical-align: top
}

.tg2 .tg-i5o6 {
	font-size: 100%;
	background-color: #efefef;
	color: #000000;
	border-color: #343434;
	text-align: center;
	vertical-align: top
}

.tg2 .tg-p5e1 {
	font-size: 10px;
	background-color: #efefef;
	color: #333333;
	border-color: #343434;
	text-align: center;
	vertical-align: top
}

.reco-item {
	width: 200px;
	margin-right: 20px;
	display: inline-block;
	margin-bottom: 20px;
	text-align: center;
}

body {
	margin: 0 auto;
}

.cate-title {
	display: block;
}

.home {
	width: 1024px;
	height: auto;
	display: block;
	margin: 0 auto;
}

.main {
	width: auto;
	height: auto;
	margin: 0 auto;
}

.main2 {
	width: auto;
	height: auto;
	margin: 0 auto;
	background: #f0f0f0;
}
.cate-title a{
	text-decoration: blink;
}
</style>
</head>
<body>
	<div class="main">
		<div class="home">
			<div class="home-recommend-item">
				<div class="recommend-title">
					<div class="title">플리마켓 추천상품</div>
				</div>
				<c:forEach var="reList" items="${bean.recommend}">
					<a href="detailAction.do?itemboard_no=${reList.itemboard_no}">
						<div class="reco-item">
							<table class="tg">
								<tr>
									<c:forEach var="img" items="${reList.imgList}" begin="0"
										end="0">
										<th class="tg-c3ow" colspan="2"><img class="img" alt=""
											src="../productimg/${img.thum_img}"></th>
									</c:forEach>
								</tr>
								<tr>
									<td class="tg-phtq" colspan="2">${reList.itemboard_title}</td>
								</tr>
								<tr>
									<c:choose>
										<c:when test="${reList.item_delivery_B eq 1}">
											<td class="tg-0pky" colspan="2">무료배송</td>
										</c:when>
										<c:otherwise>
											<td class="tg-0pky" colspan="2">배송비별도</td>
										</c:otherwise>
									</c:choose>
								</tr>
								<tr>
									<td class="tg-phtq"><fmt:formatNumber
											value="${reList.item_price}" />원</td>
									<td class="tg-phtq">${reList.itemboard_date }</td>
								</tr>
							</table>
						</div>
					</a>
				</c:forEach>
				<br>
			</div>
		</div>
	</div>
	<div class="main2">
		<div class="category-list">
			<h3>카테고리 목록</h3>
			<c:forEach var="categoryList" items="${bean.hotList}">
			${categoryList.category_title}
			<a
					href="categoryItemListAction.do?category_no=${categoryList.category_no}">전체보기</a>
			</c:forEach>
		</div>
		<div class="hot-item">
			<div class="hot-title">
				<h2>카테고리별 인기 상품</h2>
			</div>
			<c:forEach var="list" items="${bean.hotList}">
				<br>
				<div class="cate-title">
					<a href="categoryItemListAction.do?category_no=${list.category_no}">
						${list.category_title}
					</a>
				</div>
				<br>
				<c:forEach var="itemList" items="${list.hotList}">
					<a href="/fleamarket/maindetail/detail?itemboard_no=${itemList.itemboard_no}">
						<div class="reco-item">
							<table class="tg2">
								<!-- style="table-layout: fixed; width: 140px" -->
								<%-- <colgroup>
									<col style="width: 71px">
									<col style="width: 69px">
								</colgroup> --%>
								<tr>
									<th class="tg-oe15" colspan="2"><c:forEach var="img"
											items="${itemList.imgList}" begin="0" end="0">
											<img class="img" alt="" src="../productimg/${img.thum_img}">
										</c:forEach></th>
								</tr>
								<tr>
									<td class="tg-oe15" colspan="2">${itemList.itemboard_title}</td>
								</tr>
								<tr>
									<td class="tg-oe15">${itemList.item_price}</td>
									<td class="tg-c1kk">${itemList.itemboard_date}</td>
								</tr>
							</table>
						</div>
					</a>
				</c:forEach>
				<br>
			</c:forEach>
		</div>
	</div>

</body>
</html>