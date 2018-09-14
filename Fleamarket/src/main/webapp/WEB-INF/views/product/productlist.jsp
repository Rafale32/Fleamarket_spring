<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
   function deleteCheck(itemboard_No) {
      if (confirm("삭제 하시겠습니까?")) {
         var url = "/fleamarket/product/productdelete?itemboard_No="+itemboard_No;
         location.href = url;
      } else {
         alert("삭제 취소 되었습니다.");
         return;
      }
      return null;
   }
</script>
<style type="text/css">
table td {
  vertical-align: middle !important;
}

.nav{
  margin: 0 auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <br>
    <table class="table text-center">
      <tr>
        <td>상품사진</td>
        <td>물품명</td>
        <td>가격</td>
        <td>찜/댓글</td>
        <td>최근 수정일</td>
        <td>기능</td>
      </tr>
      <c:forEach items="${bean.itemList }" var="tmp">
        <tr>
          <td width="100px" height="100px">
            <c:forEach items="${tmp.itemImgList }" var="tmp2" begin="0" end="0">
              <img src="/fleamarket/resources/product/upload${tmp2.thum_Img }" width="200px" height="150">
            </c:forEach>
          </td>
          <td><a href="/fleamarket/maindetail/detail?itemboard_no=${tmp.itemboard_No }">${tmp.itemboard_Title }</a></td>
          <td><fmt:formatNumber value="${tmp.price }" />원</td>
          <td>${tmp.favCount }/ ${tmp.itemQnaCount }</td>
          <td>${tmp.itemboard_Date }</td>
          <c:choose>
            <c:when test="${param.store_Name != null}">

            </c:when>
            <c:when test="${param.member_email != '' }">
              <td>
                <a href="/fleamarket/product/productmodifyform?itemboard_No=${tmp.itemboard_No }">
                  <input type="button" class="btn btn-warning" value="수정">
                </a>
                <input type="button" onclick="deleteCheck(${tmp.itemboard_No })" value="삭제" class="btn btn-danger">
                <%-- <a href="/fleamarket/product/productdelete?itemboard_No=${tmp.itemboard_No }" onclick="deleteCheck(${tmp.itemboard_No })">삭제</a>  --%>
              </td>
            </c:when>
          </c:choose>
        </tr>
      </c:forEach>
    </table>

    <!-- 페이징 -->
    <nav>
      <ul class="pagination">
        <c:if test="${member.member_email != null && bean.itemDTO.store_name == null}">
          <!-- 이전 -->
          <c:choose>
            <c:when test="${bean.pageModel.startPage <= 5 }">
              <li class="disabled">
            </c:when>
            <c:otherwise>
              <li>
            </c:otherwise>
          </c:choose>
                <a href="/fleamarket/product/productlist?member_email=${member.member_email }&pageNum=${bean.pageModel.startPage - 1 }" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
          <!-- 이전 -->
        
        
          <!-- 현재페이지 -->
          <c:forEach var="pageNo" begin="${bean.pageModel.startPage}" end="${bean.pageModel.endPage }">
            <c:choose>
              <c:when test="${bean.pageModel.requestPage == pageNo }">
                <li class="active">
              </c:when>
              <c:otherwise>
                <li>
              </c:otherwise>
            </c:choose>
              <a href="/fleamarket/product/productlist?member_email=${member.member_email }&pageNum=${pageNo }">
                ${pageNo }<span class="sr-only">(current)</span>
              </a>
            </li>
          </c:forEach>
          <!-- 현재페이지 -->
        

          <!-- 이후 -->
          <c:choose>
            <c:when test="${bean.pageModel.endPage >= bean.pageModel.totalPageCount}">
              <li class="disabled">
            </c:when>
            <c:otherwise>
              <li>
            </c:otherwise>
          </c:choose>
              <a href="/fleamarket/product/productlist?member_email=${member.member_email }&pageNum=${bean.pageModel.startPage + 5 }" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
          </li>
          <!-- 이후 -->
        </c:if>
        
        
        <c:if test="${param.store_name != null }">
        <!-- 이전 -->
          <c:choose>
            <c:when test="${bean.pageModel.startPage <= 5 }">
              <li class="disabled">
            </c:when>
            <c:otherwise>
              <li>
            </c:otherwise>
          </c:choose>
              <a href="/fleamarket/product/productlist?store_Name=${bean.itemDTO.store_Name }&pageNum=${bean.pageModel.startPage - 1 }" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
          </li>
        <!-- 이전 -->
        
        <!-- 현재페이지 -->
          <c:forEach var="pageNo" begin="${bean.pageModel.startPage}" end="${bean.pageModel.endPage }">
          <c:choose>
            <c:when test="${bean.pageModel.requestPage == pageNo }">
              <li class="active">
            </c:when>
            <c:otherwise>
              <li>
            </c:otherwise>
          </c:choose>
             <a href="/fleamarket/product/productlist?store_Name=${bean.itemDTO.store_Name }&pageNum=${pageNo }">${pageNo }</a>
          </li>
          </c:forEach>
        <!-- 현재페이지 -->
        
        <!-- 이후 -->
          <c:choose>
            <c:when test="${bean.pageModel.endPage >= bean.pageModel.totalPageCount}">
              <li class="disabled">
            </c:when>
            <c:otherwise>
              <li>
            </c:otherwise>
          </c:choose>
              <a href="/fleamarket/product/productlist?store_Name=${bean.itemDTO.store_Name }&pageNum=${bean.pageModel.startPage + 5 }" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
          </li>
        <!-- 이후 -->  
        </c:if>
      </ul>
    </nav>

    <!-- 페이징 -->


  </div>
</body>
</html>