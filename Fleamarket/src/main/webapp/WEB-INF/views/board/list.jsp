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
							<th style="width: 10px">번 호</th>
							<th>카테고리</th>
							<th>제 목</th>
							<th style="width: 40px">작성 시간</th>
						</tr>
					</table>

					<c:forEach items="${list}" var="boardDTO">

						<tr>
							<td>번호${boardDTO.notice_no}</td>
							<td>카테${boardDTO.notice_category}</td>
							<td><a href='/board/read?bno=${boardDTO.notice_no}'>제목${boardDTO.notice_title}</a></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardDTO.notice_date}" /></td>
						</tr>

					</c:forEach>


					<script>
						var result = '${msg}';

						if (result == 'SUCCESS') {
							alert("작성한 글이 등록이 되었습니다.");
						}
					</script>
