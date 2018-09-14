<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" method="post">

	<input type='hidden' name='notice_no' value="${boardDTO.notice_no}">

</form>

<div class="box-body">
	<div class="form-group">
	<label>글번호 </label><br/>
	<input type="text"
			name='notice_title' class="form-control" value="${boardDTO.notice_no}"
			readonly="readonly">
	</div><br/>
	<div class="form-group">
		<label for="exampleInputEmail1">제목</label><br/> 
		<input type="text"
			name='notice_title' class="form-control" value="${boardDTO.notice_title}"
			readonly="readonly">
	</div><br/>
	<div class="form-group">
		<label for="exampleInputPassword1">글 내용</label><br/>
		<textarea class="form-control" name="notice_contents" rows="3"
			readonly="readonly">${boardDTO.notice_contents}</textarea>
	</div><br/>
<%-- 	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label> <input type="text"
			name="writer" class="form-control" value="${boardVO.writer}"
			readonly="readonly">
	</div> --%>
</div>
<!-- /.box-body -->

<div class="box-footer">
	<button type="submit" class="btn btn-warning">수 정</button>
	<button type="submit" class="btn btn-danger">글 삭 제</button>
	<button type="submit" class="btn btn-primary">공지 사항</button>
</div>

<script>
				
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/modify");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/remove");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		self.location = "/board/noList";
	});
	
});

</script>