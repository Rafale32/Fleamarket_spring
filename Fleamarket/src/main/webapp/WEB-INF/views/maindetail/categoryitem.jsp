<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#del{
color: red;
}
.img1{
   width: 250px !important;
   height: 220px !important;
}
</style>
</head>
<body>

	<div class="container">
			<h2>${title}</h2>
			<br><br>
		<div class="row">
    <c:forEach var="reList" items="${bean.categoryItemList}">
    <a href="/fleamarket/maindetail/detail?itemboard_no=${reList.itemboard_no}">
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <c:forEach var="img" items="${reList.imgList}" begin="0" end="0">
            <img class="img1" src="/fleamarket/resources/product/upload${img.big_img}" alt="추천상품이미지">
          </c:forEach>
          <div class="caption">
          	<div style="text-overflow:ellipsis; overflow:hidden; width:234.5px; height: 30px;">
              <h4>${reList.itemboard_title}</h4>
						</div>
              <p>
                <c:choose>
                  <c:when test="${reList.item_delivery_B eq 1}"><div id="del">무료배송</div></c:when>
                  <c:otherwise><div>배송비별도</div></c:otherwise>
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
	</div>
</body>
</html>
