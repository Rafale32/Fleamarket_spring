<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
var itemboard_no = 1;

$.getJSON("/fleamarket/qna/all/"+itemboard_no, function(data){ 
		
	console.log(data.length);
}); 
</script> 
<title>Insert title here</title>
</head>
<body>
<h2>Ajax</h2>

<ul id="replies">

</ul>
</body>
</html>