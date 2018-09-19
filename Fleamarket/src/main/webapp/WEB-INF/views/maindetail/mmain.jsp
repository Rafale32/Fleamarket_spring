<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.red{
color: red;
}

.img1{
 width: 250px;
 height: 220px;
}
</style>
<script>
   function fnMove(seq){
      var offset = $("#cate"+seq).offset();
      $('html, body').animate({scrollTop : offset.top}, 400);
   }
</script>
</head>
<body>
  <div class="container">
    <!-- 슬라이더 -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 100%">

      <!--페이지-->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <!--페이지-->

      <div class="carousel-inner">
        <!--슬라이드1-->
        <div class="item active">
          <img src="http://seoul-p-studio.bunjang.net/images/nocrop/253037543.jpg"
            style="width: 100%" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
            </div>
          </div>
        </div>
        <!--슬라이드1-->

        <!--슬라이드2-->
        <div class="item">
          <img src="http://seoul-p-studio.bunjang.net/images/nocrop/256279251.jpg"
            style="width: 100%" data-src="" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
            </div>
          </div>
        </div>
        <!--슬라이드2-->

        <!--슬라이드3-->
        <div class="item">
          <img src="http://seoul-p-studio.bunjang.net/images/nocrop/256255308.jpg"
            style="width: 100%" data-src="" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
            </div>
          </div>
        </div>
        <!--슬라이드3-->
      </div>

      <!--이전, 다음 버튼-->
      <a class="left carousel-control" href="#myCarousel"
        data-slide="prev"> <span
        class="glyphicon glyphicon-chevron-left"></span>
      </a> <a class="right carousel-control" href="#myCarousel"
        data-slide="next"> <span
        class="glyphicon glyphicon-chevron-right"></span>
      </a>
    </div>
    <!-- 슬라이더 -->
    
    
    
    <!-- 추천상품 -->
    <h3>추천상품</h3>
    <div class="row">
    <c:forEach var="reList" items="${bean.recommend}">
    <a href="/fleamarket/maindetail/detail?itemboard_no=${reList.itemboard_no}">
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <c:forEach var="img" items="${reList.imgList}" begin="0" end="0">
            <img src="/fleamarket/resources/product/upload${img.big_img}" alt="추천상품이미지">
          </c:forEach>
          <div class="caption">
              <h4>${reList.itemboard_title}</h4>
              <p>
                <c:choose>
                  <c:when test="${reList.item_delivery_B eq 1}"><div class="red">무료배송</div></c:when>
                  <c:otherwise>배송비별도</c:otherwise>
                </c:choose>
                <!-- <a href="#" class="btn btn-primary" role="button">Button</a> -->
                <!-- <a href="#" class="btn btn-default" role="button">Button</a> -->
              </p>
              <p><fmt:formatNumber value="${reList.item_price}" />원</p>
              <p>${reList.itemboard_date }</p>
            
          </div>
        </div>
      </div>
     </a>
    </c:forEach>
    </div><!--row -->  
    <!-- 추천상품 -->
    
    
    
    <!-- 카테고리 -->
    <h3>카테고리별 인기상품</h3>
    <div class="btn-group btn-group-justified" role="group" aria-label="...">
      <c:forEach var="categoryList" items="${bean.hotList}" varStatus="status">
        <div class="btn-group" role="group">
          <button onclick="fnMove('${status.count}')" type="button" class="btn btn-default">${categoryList.category_title}</button>
        </div>

      </c:forEach>
    </div><br>
    <!-- 카테고리 -->
    
    
    
    <!-- 카테고리별 인기상품 -->
    <c:forEach var="list" items="${bean.hotList}" varStatus="status">
      <h4 style="display:inline-block;" id="cate${status.count}">${list.category_title}</h4>
      <a href="/fleamarket/maindetail/categoryitem?category_title=${list.category_title}">전체보기</a>
      <div class="row">
        <c:forEach var="itemList" items="${list.hotList}">
        <a href="/fleamarket/maindetail/detail?itemboard_no=${itemList.itemboard_no}">
          <div class="col-sm-6 col-md-3">
            <div class="thumbnail">
              <c:forEach var="img" items="${itemList.imgList}" begin="0" end="0">
                <img class="img1" alt="카테고리별 인기상품 이미지" src="/fleamarket/resources/product/upload${img.big_img}">
              </c:forEach>
            <div class="caption">
                <h4>${itemList.itemboard_title}</h4>
                <p>
                <c:choose>
                  <c:when test="${itemList.item_delivery_B eq 1}"><div class="red">무료배송</div></c:when>
                  <c:otherwise>배송비별도</c:otherwise>
                </c:choose>
                <!-- <a href="#" class="btn btn-primary" role="button">Button</a> -->
                <!-- <a href="#" class="btn btn-default" role="button">Button</a> -->
              </p>
              <p> <fmt:formatNumber value="${itemList.item_price}" />원 </p>
              <p> ${itemList.itemboard_date} </p>
          </div>
        </div>
      </div>
      </a>
      </c:forEach>
      </div><!--row -->
      <hr>
    </c:forEach>  
    <!-- 카테고리별 인기상품 -->
  </div>
</body>
</html>