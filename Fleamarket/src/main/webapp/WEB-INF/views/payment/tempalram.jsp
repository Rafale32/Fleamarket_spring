<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
 <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link rel="stylesheet" href="../gy_css/buySellTable.css" type="text/css">
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
  
  <script src="/resources/payment/cangeDeliveryst_gy.js" type="text/javascript"> 
  </script>
</head>
<body>


<!-- 알람 테이블 추후에 헤더에 넣는 부분이 될듯 -->
<h1>도착확인용3</h1>
<div name="alram_table">
	<table id="sell_list_table" class="table">
		<%-- <c:forEach var = "p" items="${list}">
		<tr>
			<td colspan="4" class="date">날자부 :${p.pay_date }</td>
		</tr>
		</c:forEach> --%>
	</table>

</div>

</body>
</html>