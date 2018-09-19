<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 20180822 재헌-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- css -->
<link rel="stylesheet" href="../resources/safepay/css/order_detailCSS.css" type="text/css">
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<title>주문 상세 내역</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-offset-2 col-sm-7 col-md-8">
  <c:set var="item_no" value="${bean.itemDTO.item_No}"></c:set>
  <input type="hidden"  name="item_no" value="${item_no}"> 
  <h1>주문 상세 내역</h1>
  <!-- 주문정보 -->
  <div>
    <hr>
    <table border="0" class="order_table">
    <tr><td colspan="3"><h2>주문정보</h2></td></tr>
    <tr>
      <td colspan="2">주문상태</td>
      <td class="right_text">
        <c:set var="d_state" value="${bean.itemDTO.item_delivery_State}"></c:set>
        <c:choose>
          <c:when test="${d_state == '1'}">
            판매중
          </c:when>
          <c:when test="${d_state == '2'}">
            준비중
          </c:when>
          <c:when test="${d_state == '3'}">
            배송중
          </c:when>
          <c:when test="${d_state == '4'}">
            거래완료
          </c:when>
        </c:choose>
      </td>
    </tr>
     
    <tr>
      <td colspan="2">주문번호</td>
      <td class="right_text">T${bean.oorderDTO.oorder_no+11100}</td>
    </tr>
    
    <tr>
      <td colspan="2" >주문일자</td>
      <td class="right_text">
        <c:set var="s_date" value="${bean.oorderDTO.oorder_date}"></c:set>
        ${fn:substring(s_date, 0, 10)}
      </td>
    </tr>
    <tr><td colspan="3"><hr></td></tr>
    
    <!-- 물품정보 -->
    <tr>
      <td colspan="3"><h4>${bean.itemDTO.store_Name}</h4></td>
    </tr>
    
    <tr>
      <td rowspan="2">
        <c:set var="img" value="${bean.itemImgDTO_jh.thum_img }"></c:set>
        <a href="/fleamarket/maindetail/detail?itemboard_no=${bean.itemDTO.itemboard_No}">
          <img src="/fleamarket/resources/product/upload/${img}" width="200px" height="150px">
        </a>
      </td>
      <td>상품명</td>
      <td class="right_text">
        <a href="/fleamarket/maindetail/detail?itemboard_no=${bean.itemDTO.itemboard_No}">
          ${bean.itemDTO.itemboard_Title}
        </a>
      </td>
    </tr>
    
    <tr>
      <td>가격</td>
      <td class="right_text">
        <c:set var="price" value="${bean.itemDTO.item_Price}"></c:set>
        <fmt:formatNumber value="${price}" />원
      </td>
    </tr>
  </table>
  </div>

  <!--   결제정보 -->
  <div>
    <hr>
    <table border="0" class="order_table">
      <tr><td colspan="2"><h2>결제정보</h2></td></tr>
      <tr>
        <td>상품금액</td>
        <td class="right_text"><fmt:formatNumber value="${price}" />원</td>
      </tr>
      
      <tr>
        <td>배송비</td>
        <td class="right_text">
        <!--  배송 유무 확인 -->
          <c:choose>
            <c:when test="${bean.itemDTO.item_Delivery_B == '1'}">
              <c:set var="deli_fee" value="2500"></c:set>
              <fmt:formatNumber value="${deli_fee}" />원
            </c:when>
            <c:otherwise>
              <c:set var="deli_fee" value="0"></c:set>
               무료배송
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
      
      <tr>
        <td>사용포인트</td>
        <td class="right_text">
          <c:set var="point" value="${bean.paymentDTO.pay_usepoint}"></c:set>
          <fmt:formatNumber value="${point}"/>원
        </td>
      </tr>
      
      <tr>
        <td>수수료</td>
        <td class="right_text">
          <c:set var="fee" value="${price*0.03+1000}"></c:set>
          <fmt:formatNumber value="${fee}" />원
        </td>
      </tr>
      
      <tr>
        <td><h2><b>최종결제금액</b></h2></td>
        <td class="right_text">
          <c:set var="total" value="${bean.paymentDTO.pay_price}"></c:set>
            <h2><b><fmt:formatNumber value="${total}"/>원</b></h2>
        </td>
      </tr>
    </table>
  </div>

  <!--   배송지 -->
  <div>
    <hr>
    
    <table border="0" class="order_table">
    <tr><td colspan="2"><h2>배송지</h2></td></tr>
      <tr>
        <td>수령인</td>
        <td class="right_text">${bean.deliveryDTO.delivery_name}</td>
      </tr>
      <tr>
        <td>연락처</td>
        <td class="right_text">${bean.deliveryDTO.delivery_ph}</td>
      </tr>
      <tr>
        <td rowspan="2">배송지</td>
        <td class="right_text">${bean.deliveryDTO.delivery_address}</td>
      </tr>
      <tr>
        <td class="right_text">${bean.deliveryDTO.delivery_address2}</td>
      </tr>
      <tr>
        <td>요청사항</td>
        <td class="right_text">${bean.deliveryDTO.delivery_contents}</td>
      </tr>
    </table>
  </div>
  </div>
  </div>

  <!--   버튼 -->
<!--   <div> -->
<!--     <input type="button" value="리뷰쓰기"> -->
<!--   </div> -->
<br><br><br>
</div><!-- container -->
</body>
</html>





