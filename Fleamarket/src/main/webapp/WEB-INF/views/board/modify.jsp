<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">글 수정</h3><dr/>
				</div>
				<!-- /.box-header -->

<form role="form" method="post">

	<div class="box-body">

		<div class="form-group">
			<label for="exampleInputEmail1">글 번호</label> <input type="text"
				name='notice_no' class="form-control" value="${boardDTO.notice_no}"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">카테고리</label> <input
				type="text" name="notice_category" class="form-control"
				value="${boardDTO.notice_category}"> 
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">제 목</label> <input type="text"
				name='notice_title' class="form-control" value="${boardDTO.notice_title}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">글 내용</label>
			<textarea class="form-control" name="notice_contents" rows="3">${boardDTO.notice_contents}</textarea>
		</div>
<%-- 		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> <input
				type="text" name="writer" class="form-control"
				value="${boardVO.writer}"> 
		</div>--%>
	</div>
	<!-- /.box-body -->
</form>


<div class="box-footer">
	<button type="submit" class="btn btn-primary">변경 저장</button>
	<button type="submit" class="btn btn-warning">변경 취소</button>
</div>

<script>
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
</script>
</body>
</html>