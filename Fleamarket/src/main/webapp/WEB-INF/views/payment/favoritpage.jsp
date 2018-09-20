<%@ page language="java" contentType="text/html; charset=EUC-KR"
  pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ��� ��ȸ</title>
<!-- �������� -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- ��Ʈ��Ʈ�� -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
table td {
  vertical-align: middle !important;
}
</style>
</head>
<body>
  <div class="container">
  <br>
    <table id="favorit_list_table" frame="void" class="table text-center">
      <tr><td colspan="5"></td></tr>
      <tr>
        <td>��ǰ����</td>
        <td>��ǰ��</td>
        <td>��ǰ����</td>
        <td>�ŷ���������</td>
        <td>���</td>
      </tr>
      
      <c:forEach var="p" items="${list}">
        <tr>
          <!-- ��ǰ�̹��� -->
          <td width="100px" height="100px">
            <img alt="��ǰ�ӽ��̹���" width="200px" height="150px"
              src="/fleamarket/resources/payment/img/${p.thum_img}.jpg">
          </td>
          <!-- ��ǰ �̸�, ��ũ -->
          <td>
            <!-- ���� �������� �̵��ϱ�  --> <!-- ��ǰ�� Ŭ���� �ش� �ϴ� ��ǰ�� �̵� -->
            <a href="/fleamarket/maindetail/detail?itemboard_no=${p.item_no }">
              ${p.itemboard_title}
            </a> <%-- <h2> ${p.itemboard_no }</h2> --%>
          </td>
          <!-- ���� -->
          <td>
            <fmt:formatNumber value="${p.item_price}" />��
          </td>
          <!-- �ŷ����� -->
          <td>
            ${p.itemboard_local }
          </td>
          <!-- ��� -->
          <td>
            <form action="/fleamarket/payment/favoritpage" method="post">
              <!-- style="display: none;"  ���߿� �־ �߰� �Ұ�-->
              <input type="text" name="itemboard_no" value="${p.itemboard_no }" style="display: none">
              <input type="submit" id="purchaseDetermin" class="btn btn-warning" value="�� ����">
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
    
    <!-- ����¡ -->
    <div class="text-center">
      <ul class="pagination">
      
        <!-- ���� -->
<%--         <c:if test="${pageMaker.prev}"> --%>
        <c:choose>
          <c:when test="${pageMaker.cri.page == 1}">
            <li class="disabled">
          </c:when>
          <c:otherwise>
            <li>
          </c:otherwise>
        </c:choose>
            <a href="favoritpage${pageMaker.makeSearch(pageMaker.startPage - 1) }">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          
<%--         </c:if> --%>
        
        <!-- ���������� -->
        <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
          <li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
            <a href="favoritpage${pageMaker.makeSearch(idx)}">${idx}</a>
          </li>
        </c:forEach>
       
        <!-- ����  -->
        <c:choose>
          <c:when test="${pageMaker.next && pageMaker.endPage > 0}">
            <li >
          </c:when>
          <c:otherwise>
            <li class="disabled">
          </c:otherwise>
        </c:choose>
<%--         <c:if test="${pageMaker.next && pageMaker.endPage > 0}"> --%>
            <a href="favoritpage${pageMaker.makeSearch(pageMaker.endPage +1) }">
                <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
<%--         </c:if> --%>
      </ul>
    </div><!--  page -->
  </div><!-- container -->
</body>
</html>