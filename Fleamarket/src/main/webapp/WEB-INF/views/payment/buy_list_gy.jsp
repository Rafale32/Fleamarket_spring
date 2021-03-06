<%@page import="javax.xml.crypto.KeySelector.Purpose"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  request.setCharacterEncoding("utf-8");
  //request.setAttribute("purchaseModel", list);
  /* 새로운 코드 */
  /*    PaymentPagingService_gy daoservice = PaymentPagingService_gy.getInstance();
     PaymentPagingDTO_gy dao2 = new PaymentPagingDTO_gy();
     dao2 = daoservice.listBoardService(2, request);
     request.setAttribute("purchaseModel", dao2);  */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매내역</title>

<script type="text/javascript"
  src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>

<!-- <script type="text/javascript"
  src="../resources/payment/js/cangeDeliveryst_gy.js"></script> -->
<style type="text/css">
.itemStateImg{
  width: 100px;
  height: 100px;
}
table td {
  vertical-align: middle !important;
}
</style>
</head>
<body>
 <div class="container">
    <br>
    <table class="table text-center" id="sell_list_table" frame="void">
      <tr><td colspan="6"></td></tr>
      <tr>
        <td>상품사진</td>
        <td>상품명</td>
        <td>상품가격</td>
        <td>거래상태</td>
        <td>구매일</td>
        <td>기능</td>
      </tr>
      
      <c:forEach var="p" items="${list4}">
<%--       <tr><td colspan="6">${p.store_name }</td></tr> --%>
        <tr>
          <!--  상품이미지 -->
          <td width="100px" height="100px">
            <img alt="물품이미지" width="200px" height="150px"
                 src="/fleamarket/resources/product/upload${p.thum_img}">
          </td>
          <!-- 상품 이름, 링크-->
          <td>
            <a href="/fleamarket/maindetail/detail?itemboard_no=${p.item_no }">
              ${p.itemboard_title}
            </a>
          </td>
          <!-- 상품가격 클릭시 해당 하는 상품결제 상세로 갈것 -->
          <td>            
            <a href="/fleamarket/safepay/order_detail?item_no=${p.item_no }">
              <fmt:formatNumber value="${p.item_price}" />원
            </a>
          </td>
          <!-- 거래상태 -->
          <td>
          <!-- 거래 상태를 볼수 있는 코드 1~4까지 있고 설명을 적어 놓았고 나중에 이미지 파일로 변경하면 됨  -->
            <!-- 1 = 판매중인 상태 -->
            <!-- 2 = 결제완료후 준비중 -->
            <!-- 3 = 배송중(판매자 판매승인) -->
            <!-- 4 = 구매자 구매완료 =거래완료 -->
            <c:choose>
              <c:when test="${p.item_delivery_state== 1}">
                <img class="itemStateImg" alt="배송이미지"
                  src="/fleamarket/resources/payment/img/d1.png">
              </c:when>
              <c:when test="${p.item_delivery_state == 2}">
                <img  class="itemStateImg" alt="배송이미지"
                  src="/fleamarket/resources/payment/img/d2.png">
              </c:when>
              <c:when test="${p.item_delivery_state == 3}">
                <img  class="itemStateImg" alt="배송이미지"
                  src="/fleamarket/resources/payment/img/d3.png">
              </c:when>
              <c:when test="${p.item_delivery_state == 4}">
                <img  class="itemStateImg" alt="배송이미지"
                  src="/fleamarket/resources/payment/img/d4.png">
              </c:when>
              <c:otherwise>
                제대로된 상태가 아닙니다.
              </c:otherwise>
            </c:choose>
          </td>
          <!-- 구매일 -->
          <td>
            <c:set var="s_date" value="${fn:substring(p.pay_date, 0, 10)}"></c:set>
              ${s_date }
          </td>
          <td>
            <!--  <form action="/Fleamarket3/payment/changeDeliveryChack_gy.do"> -->
            <form action="/fleamarket/payment/buy_list_gy" method="post">
              <!-- style="display: none;"  나중에 넣어서 추가 할것-->
              <input type="text" name="itemboard_no"
                value="${p.itemboard_no }" style="display: none">
                
              <c:if test="${p.item_delivery_state == 3}">
                <input type="text" id="pageNo" name="pageNo"
                  value="${purchaseModel.requestPage }"
                  style="display: none">
                <input type="text" id="item_no" name="item_no"
                  value="${p.item_no}" style="display: none">
                <input type="submit" id="purchaseDetermin" class="btn btn-success"
                  value="구매확정">
              </c:if>
            </form>
            
            <a href="/fleamarket/payment/purchasestoreReview2?store_name=${p.store_name }">
              <input type="button" class="btn btn-info" value="리뷰확인">
            </a> <!-- 버튼 시험작 만들기-->
              
          </td>
        </tr>
      </c:forEach>
    </table>

    <!-- 페이징 -->
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
<%--         <c:if test="${pageMaker.prev}"> --%>
            <a href="buy_list_gy${pageMaker.makeSearch(pageMaker.startPage - 1) }">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>

        <!-- 현재페이지 -->
        <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
          <li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
            <a href="buy_list_gy${pageMaker.makeSearch(idx)}">${idx}</a>
          </li>
        </c:forEach>
        
        <!-- 이후 -->
        <c:choose>
<%--           <c:when test="${pageMaker.next && pageMaker.endPage > 0}"> --%>
          <c:when test="${pageMaker.next && pageMaker.endPage > 0}">
            <li >
          </c:when>
          <c:otherwise>
            <li class="disabled">
          </c:otherwise>
        </c:choose>
               <a href="buy_list_gy${pageMaker.makeSearch(pageMaker.endPage +1) }">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
      </ul>
    </nav>
  </div>
</body>
</html>