<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>

<script>
  $(document).ready(function() {

    var formObj = $("form[role='form']");

    console.log(formObj);

    $(".btn-warning").on("click", function() {
      formObj.attr("action", "/fleamarket/board/modify");
      formObj.attr("method", "get");
      formObj.submit();
    });

    $(".btn-danger").on("click", function() {
      formObj.attr("action", "/fleamarket/board/remove");
      formObj.submit();
    });

    $(".btn-primary").on("click", function() {
      self.location = "/fleamarket/board/noList";
    });

  });
</script>

<style type="text/css">
</style>
<title>공지 상세 페이지</title>
</head>
<body>
  <div class="container">
    <div class="text-center">
      <h1>공지 상세 페이지</h1>
    </div>
    <br>

    <div class="col-md-6 col-md-offset-3">
      <form role="form" method="post">
        <input type='hidden' name='notice_no'
          value="${boardDTO.notice_no}">
      </form>

      <div class="form-group">
        <label for="exampleInputEmail1">카테고리</label>
        <input type="text" name='notice_category' class="form-control"
          value="${boardDTO.notice_category}" readonly="readonly">
      </div>

      <div class="form-group">
        <label for="exampleInputEmail1">제 목</label>
        <input type="text" name='notice_title' class="form-control"
          value="${boardDTO.notice_title}" readonly="readonly">
      </div>

      <div class="form-group">
        <label for="exampleInputPassword1">글 내용</label>
        <textarea class="form-control" name="notice_contents" rows="5"
          readonly="readonly">${boardDTO.notice_contents}</textarea>
      </div>

      <div class="text-center">
        <c:if test="${member.member_email eq 'admin@admin.com'}">
          <button type="submit" class="btn btn-warning">글 수정</button>
          <button type="submit" class="btn btn-danger">글 삭제</button>
        </c:if>
        <button type="submit" class="btn btn-primary">목록 가기</button>
      </div>
    </div>
  </div>
</body>
</html>