<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
 <script type="text/javascript">
  window.onload = function() {
	  var header = document.getElementById('purchaseDetermin');
		 header.onclick = function (){
		  var con_test = confirm("�� �׸��� ���� �Ͻðڽ��ϱ�?");
		  if(con_test == true){
		    alert("���� �Ǿ����ϴ�.");
		  }
		  else if(con_test == false){
		    alert("��� �Ǿ����ϴ�.");
		    return false;
		  }
		};
	  
  };
  
  </script>
</head>
<body>
	<table id="favorit_list_table" frame="void" class="table">
	
		<c:forEach var="p" items="${list}">
		<tr>
			<td>
			<img alt="��ǰ�ӽ��̹���"
					src="/fleamarket/resources/payment/img/${p.thum_img}.jpg"
					width="200px" height="150px" style="margin-left: 50px;"></td>
					
					
				<td>
					<!-- ���� �������� �̵��ϱ�  --> <!-- ��ǰ�� Ŭ���� �ش� �ϴ� ��ǰ�� �̵� --> <a
					href="/fleamarket/maindetail/detail?itemboard_no=${p.item_no }">
						<h2>����(��ǰ��) ${p.itemboard_title}</h2>
				</a> <%-- <h2> ${p.itemboard_no }</h2> --%>
					<h3>����:	${p.item_price}</h3>
					<h2>�ŷ� ���� ���� : ${p.itemboard_local }</h2>
				</td>
				
			<td>
				<form action="/fleamarket/payment/favoritpage" method="post">
						<!-- style="display: none;"  ���߿� �־ �߰� �Ұ�-->
						<input type="text" name="itemboard_no" value="${p.itemboard_no }" style="display: none">
							<input type="submit" id="purchaseDetermin" class="btn"
								value="�� ����">
					</form>
			</td>
			</tr>
		</c:forEach>
		
		</table>
		
		<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a
					href="favoritpage${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="favoritpage${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="favoritpage${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>