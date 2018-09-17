<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>

<section class="content">
<div class="row">
	<!-- left column -->
	<div class="col-md-12">
		<!-- general form elements -->

		<div class="box">
			<div class="box-header with-border">
				<h2 class="box-title">고객센터</h2>
				<h3 class="box-title">
					[공지사항]
					<c:if test="${member.member_email eq 'admin@admin.com'}">
						<a href='/fleamarket/board/register'>공지 작성</a>
					</c:if>
				</h3>


			</div>
			<div class="box-body">
				<table class="table table-bordered">
					<tr>
						<th>글 번호</th>
						<th>카테고리</th>
						<th>제 목</th>
						<th>작성 시간</th>
					</tr>

					<c:forEach items="${list}" var="boardDTO">

						<tr>
							<td>${boardDTO.notice_no}</td>
							<td>${boardDTO.notice_category}</td>
							<td><a
								href='/fleamarket/board/read?notice_no=${boardDTO.notice_no}'>${boardDTO.notice_title}</a></td>
							<td>${boardDTO.notice_date}</td>
						</tr>

					</c:forEach>

				</table>
				<div>
					<c:if test="${member.member_email eq 'admin@admin.com'}">
						<a href='/fleamarket/board/register'>공지 작성</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
</section>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("작업이 처리되었습니다.");
	}
</script>