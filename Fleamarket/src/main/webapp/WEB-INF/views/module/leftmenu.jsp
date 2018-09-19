<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
  <div class="container">
    <div class="btn-group btn-group-justified" role="group" aria-label="...">
      <c:choose>
        <c:when test="${param.store_Name != null}">
          <div class="btn-group" role="group">
            <a href="/fleamarket/product/productlist?store_Name=${param.store_Name }">
              <button type="button" class="btn btn-info">상품</button>
            </a>
          </div>
          <div class="btn-group" role="group">
            <a href="/fleamarket/payment/pstoreReview?store_Name=${param.store_Name }">
              <button type="button" class="btn btn-info">상점후기</button>
            </a>
          </div>
        </c:when>

        <c:when test="${param.member_email != '' }">
          <div class="btn-group" role="group">
            <a
              href="/fleamarket/product/productlist?member_email=${member.member_email }">
              <button type="button" class="btn btn-info">내상품</button>
            </a>
          </div>

          <div class="btn-group" role="group">
            <a href="/fleamarket/product/addproductform">
              <button type="button" class="btn btn-info">물품등록</button>
            </a>
          </div>

          <div class="btn-group" role="group">
            <a href="/fleamarket/payment/favoritpage">
              <button type="button" class="btn btn-info">찜</button>
            </a>
          </div>

          <div class="btn-group" role="group">
            <a href="/fleamarket/payment/mystoreReview">
              <button type="button" class="btn btn-info">상점후기</button>
            </a>
          </div>

          <div class="btn-group" role="group">
            <a href="/fleamarket/payment/buy_list_gy">
              <button type="button" class="btn btn-info">구매내역</button>
            </a>
          </div>

          <div class="btn-group" role="group">
            <a href="/fleamarket/payment/sell_list_gy">
              <button type="button" class="btn btn-info">판매내역</button>
            </a>
          </div>
          <!-- 미구현 -->
<!--           <div class="btn-group" role="group"> -->
<!--             <a href="#"> -->
<!--               <button type="button" class="btn btn-info">정산</button> -->
<!--             </a> -->
<!--           </div> -->
        </c:when>
      </c:choose>
    </div>

  </div>
</body>
</html>