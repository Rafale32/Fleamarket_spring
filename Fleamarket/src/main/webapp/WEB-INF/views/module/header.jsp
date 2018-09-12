<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
헤더 부분
	<div id="topmenu">
		<ul>
			<li><a href="/fleamarket/board/customerCenterList.do" id="notice">NOTICE</a></li>
			<c:if test="${member != null }">
				<li>[${member.member_name }]</li>
			</c:if>
			<c:choose>
				<c:when test="${member.member_name == null }">
					<li class="detailmenu"><a href="/fleamarket/memmanage/login">LOGIN</a></li>
					<li class="detailmenu"><a href="/fleamarket/memmanage/joinform">JOIN</a></li>
				</c:when>
				<c:when test="${member.member_name != null }">
					<li class="detailmenu"><a href="/fleamarket/memmanage/logout">LOGOUT</a></li>
				</c:when>
			</c:choose>
		</ul>
	</div>
	
	
	
	<div id="bottommenu">
    <ul>
      <li id="market"><a
        href="http://localhost:8081/fleamarket/maindetail/mmain">FleaMarket</a>
      </li>
      <li>
        <form action="/fleamarket/product/searchall" id="searchForm">
          <input type="text" placeholder="상품명" class="search-box-input" name="searchSubj">
          <input type="submit" value="검 색" class="icon-search" id="subbtn">
        </form>
      </li>
      <div id="secondmenu">
        <c:if test="${member != null }">
          <li class="detailmenu"><a href="/fleamarket/product/productlist?member_email=${member.member_email }" class="btn">MYSTORE</a></li>
          <li class="detailmenu"><a href="/fleamarket/memmanage/detailAction?member_email=${member.member_email }" class="btn">MYINFO</a></li>
        </c:if>
      </div>
      <!--       secondmenu -->
    </ul>
  </div>
  <!--   bottommenu -->
	

</body>
</html>