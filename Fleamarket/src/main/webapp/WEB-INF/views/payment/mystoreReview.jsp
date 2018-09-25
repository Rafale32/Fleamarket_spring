<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
  src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../gy_css/buySellTable.css" type="text/css">
<script src="../resources/payment/cangeDeliveryst_gy.js"
  type="text/javascript"></script>
<style type="text/css">
.starImg {
  width: 110px;
  height: 20px;
}
table td {
  vertical-align: middle !important;
}

</style>
<title>상점후기</title>
</head>
<body>
  <div class="container">
    <br>
    <table id="Mystore_review" class="table text-center">
        <tr>
          <td>상품사진</td>
          <td>상품명</td>
          <td>상점명</td>
          <td>별점</td>
          <td>구매일</td>
        </tr>
      <c:forEach var="p" items="${list2}">
        <tr>
          <!-- 이미지 -->
          <td rowspan="2">
            <img alt="물품임시이미지" width="200px" height="150px"
              src="/fleamarket/resources/product/upload${p.thum_img}">
          </td>
          <!-- 상품명 -->
          <td>${p.itemboard_title}</td>
          <!-- 상점명 -->
          <td>${p.store_name}</td>
          <!-- 별점 -->
          <td>
            <c:choose>
              <c:when test="${p.review_star == 0}">
                <img class="starImg" alt="별점이미지"
                  src="/fleamarket/resources/payment/img/star0.png">
              </c:when>

              <c:when test="${p.review_star == 1}">
                <img class="starImg" alt="별점이미지"
                  src="/fleamarket/resources/payment/img/star1.png">

              </c:when>
              <c:when test="${p.review_star == 2}">
                <img class="starImg" alt="별점이미지"
                  src="/fleamarket/resources/payment/img/star2.png">

              </c:when>
              <c:when test="${p.review_star == 3}">
                <img class="starImg" alt="별점이미지"
                  src="/fleamarket/resources/payment/img/star3.png">

              </c:when>
              <c:when test="${p.review_star == 4}">
                <img class="starImg" alt="별점이미지"
                  src="/fleamarket/resources/payment/img/star4.png">
              </c:when>
              <c:when test="${p.review_star == 5}">
                <img class="starImg" alt="별점이미지"
                  src="/fleamarket/resources/payment/img/star5.png">
              </c:when>
              <c:otherwise>
                제대로된 상태가 아닙니다.
              </c:otherwise>
            </c:choose>
          </td>
          <!-- 날짜 -->
          <td class="date">
            <c:set var="s_date"
              value="${fn:substring(p.pay_date, 0, 10)}"></c:set>
              ${s_date }
          </td>
        </tr>
        <!-- 리뷰 -->
        <tr>
          <td colspan="4" rowspan="1">${p.review_contents}</td>
        </tr>
      </c:forEach>
    </table>

    <!-- paging -->
    <nav class="text-center">
      <ul class="pagination">
        <!-- 이전 -->
        <c:choose>
        <c:when test="${pageMaker.cri.page == 1}">
          <li class="disabled">
        </c:when>
        <c:otherwise>
          <li>
        </c:otherwise>
      </c:choose>
            <a href="mystoreReview${pageMaker.makeSearch(pageMaker.startPage - 1) }">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          
        <!-- 현재페이지 -->
        <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
          <li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
            <a href="mystoreReview${pageMaker.makeSearch(idx)}">${idx}</a>
          </li>
        </c:forEach>
        
        <!-- 이후 -->
      <c:choose>
        <c:when test="${pageMaker.next && pageMaker.endPage > 0}">
          <li >
        </c:when>
        <c:otherwise>
          <li class="disabled">
        </c:otherwise>
      </c:choose>
          <li>
            <a href="mystoreReview${pageMaker.makeSearch(pageMaker.endPage +1) }">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
      </ul>
    </nav>
    
  </div>
</body>
</html>