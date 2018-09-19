<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
  $(document).ready(function() {
    
    var formObj = $("form[role='form']");

    console.log(formObj);

    $(".btn-primary").on("click", function() {
      formObj.submit();
    });

    $(".btn-warning").on("click", function() {
      self.location = "/fleamarket/board/noList";
    });
  });
  
  $(document).ready(function() {
    $('#cate li > a').on('click', function() {
      $('#cateBtn').text($(this).text());
      $('#hiddenCate').val($(this).text());
    });
  });
</script>

<title>공지 수정</title>
</head>
<body>
  <div class="container">
    <div class="page-header  text-center">
      <h1>공지 수정</h1>
    </div>
    <div class="col-md-6 col-md-offset-3">
      <form role="form" method="post">

        <div class="form-group">
          <label for="exampleInputEmail1">글 번호</label> <input
            type="text" name='notice_no' class="form-control"
            value="${boardDTO.notice_no}" readonly="readonly">
        </div>

        <div class="form-group">
          <label for="exampleInputEmail1">카테고리</label>
          <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" id="cateBtn"
              value="title" type="button" data-toggle="dropdown"
              aria-expanded="true">
              카테고리 <span class="caret"></span>
            </button>
            <ul id="cate" class="dropdown-menu" role="menu"
              aria-labelledby="searchType">
              <li role="presentation"><a role="menuitem"
                tabindex="-1" href="#" value="공지사항">공지사항</a></li>
              <li role="presentation"><a role="menuitem"
                tabindex="-1" href="#" value="구매안내">구매안내</a></li>
              <li role="presentation"><a role="menuitem"
                tabindex="-1" href="#" value="판매안내">판매안내</a></li>
              <li role="presentation"><a role="menuitem"
                tabindex="-1" href="#" value="이벤트">이벤트</a></li>
            </ul>
          </div>

          <input type="hidden" name="notice_category"
            class="form-control" value="${boardDTO.notice_category}"
            id="hiddenCate">
        </div>

        <div class="form-group">
          <label for="exampleInputEmail1">제 목</label> <input type="text"
            name='notice_title' class="form-control"
            value="${boardDTO.notice_title}">
        </div>

        <div class="form-group">
          <label for="exampleInputPassword1">글 내용</label>
          <textarea class="form-control" name="notice_contents" rows="5">${boardDTO.notice_contents}</textarea>
        </div>

      </form>

      <div class="text-center">
        <button type="submit" class="btn btn-primary">변경 저장</button>
        <button type="submit" class="btn btn-warning">변경 취소</button>
      </div>


    </div>
  </div>
</body>
</html>