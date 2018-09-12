<?xml version="1.0" encoding="UTF-8" ?>

<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<div>
		
		<div>
			<h5>내용 확인</h5>
		</div>
		<table width="500" border="1" cellpadding="0" cellspacing="0">
		<form action="update.do">
		<tr>
			<td><div>번 호<input type="hidden" name="node_no" value="${sede.notice_no }">
			<td>${sede.notice_no }</td></td></input></div></td>
			</tr>
			<tr>
		<td><div>구 분<input type="hidden" name="catede" value="${sede.category }">
		<td>${sede.category }</td></input></div></td>
		</tr>
		<tr>
		<td><div>제 목<input type="hidden" name="tide" value="${sede.title }">
		<td>${sede.title }</td></input></div></td>
		</tr>
		<tr>
		<td><div>생성일<input type="hidden" name="dade" value="${sede.notice_date }">
		<td>${sede.notice_date }</td></input></div></td>
		</tr>
		<td><div>내 용<input type="hidden" name="code" value="${sede.contents }">
		<td>${sede.contents }</td></input></div></td>
		<input type="submit" value="글 수정"/>
		</form>
		<button id="declick" onclick="">글 삭제</button>
		</table>
	</div>
</body>
</html>