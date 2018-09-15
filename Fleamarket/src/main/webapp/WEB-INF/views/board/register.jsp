<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@include file="../include/header.jsp"%> --%>
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<!-- 폼테그에 액션이 없으면 현재 경로로 되어있는 /board/register 로 다시 가게된다 물론 post 니까 post 로넘어 가겠지 -->
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">글 번호</label> <input
								name='notice_no' class="form-control" placeholder="임시 번호 입력란">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">제목</label> <input type="text"
								name='notice_title' class="form-control" placeholder="제목 입력">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">카테고리</label> <input type="text"
								name="notice_category" class="form-control" placeholder="카테고리 입력">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">내용 </label>
							<textarea class="form-control" name="notice_contents" rows="3"
								placeholder="내용을 입력하세요."></textarea>
						</div>

					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">등 록</button>
					</div>
				</form>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%-- <%@include file="../include/footer.jsp"%> --%>
