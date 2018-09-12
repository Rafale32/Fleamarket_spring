<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="itemList">
		<c:forEach var="list" items="${bean.categoryItemList}">
			<c:forEach var="img" items="${list.imgList}" begin="0" end="0">
				${img.thum_img}
			</c:forEach>
			<a href="detailAction.do?itemboard_no=${list.itemboard_no}">${list.title}</a>
			${list.price}
		</c:forEach>
	</div>
</body>
</html>