<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="content">
<div class="row">
	<!-- left column -->
	<div class="col-md-12">
		<!-- general form elements -->

		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">고객센터 [공지사항]</h3>
			</div>
			<div class="box-body">
				<table class="table table-bordered">
					<tr>
						<th>글 번호</th>
						<th>제 목</th>
						<th>카테고리</th>
						<th>작성 시간</th>
					</tr>

					<c:forEach items="${list}" var="boardDTO">

						<tr>
							<td>${boardDTO.notice_no}</td>
							<td><a href='/fleamarket/board/read?notice_no=${boardDTO.notice_no}'>${boardDTO.notice_title}</a></td>
							<td>${boardDTO.notice_category}</td>
						    <td>${boardDTO.notice_date}</td>
						</tr>

					</c:forEach>

				</table>

				<script>
					var result = '${msg}';

					if (result == 'SUCCESS') {
						alert("작성한 글이 등록이 되었습니다.");
					}
				</script>