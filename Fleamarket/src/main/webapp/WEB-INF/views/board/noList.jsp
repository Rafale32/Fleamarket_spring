<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
  var result = '${msg}';
  if (result == 'SUCCESS') {
    alert("작업이 처리되었습니다.");
  }
</script>
<style type="text/css">
.BTd{
  font-weight: bolder;
}
</style>
<title>공지 목록</title>
</head>
<body>
  <div class="container">
    <div class="text-center">
      <c:choose>
        <c:when test="${member.member_email eq 'admin@admin.com'}">
          <h1>공지 관리</h1>
        </c:when>
        <c:otherwise>
          <h1>공지사항</h1>
        </c:otherwise>
      </c:choose>
    </div>
    
    <br>
    <section class="content">
        <table class="table text-center">
          <tr class="BTd">
            <td>글 번호</td>
            <td>카테고리</td>
            <td>제 목</td>
            <td>작성 시간</td>
          </tr>

          <c:forEach items="${list}" var="boardDTO">
            <tr>
              <td>${boardDTO.notice_no}</td>
              <td>${boardDTO.notice_category}</td>
              <td><a href='/fleamarket/board/read?notice_no=${boardDTO.notice_no}'>${boardDTO.notice_title}</a></td>
              <td>
                <c:set var="s_date" value=" ${boardDTO.notice_date}"></c:set>
                  ${fn:substring(s_date, 0, 11)}
              </td>
            </tr>
          </c:forEach>
          <tr><td colspan="4"></td></tr>
        </table>
        
        <div class="text-right">
          <c:if test="${member.member_email eq 'admin@admin.com'}">
            <a href='/fleamarket/board/register'><input type="button" value="공지 작성" class="btn btn-primary"></a>
          </c:if>
        </div>
    </section>
  </div><!--   container -->
</body>
</html>
