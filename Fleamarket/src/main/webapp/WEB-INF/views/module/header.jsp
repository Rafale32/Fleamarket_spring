<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
#searchForm {
  margin-left: 200px;
}
</style>
</head>

<body>
  <div class="container">
    <nav class="navbar navbar-default">
<!--     <div class="container-fluid"> -->
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <a class="navbar-brand" href="/fleamarket/maindetail/mmain">Flea</a>
      </div>

      <div class="collapse navbar-collapse"
        id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <!--         <li class="active"> -->
          <!--           <a href="#">공지사항 <span class="sr-only">(current)</span></a> -->
          <!--         </li> -->
          <li><a href="/fleamarket/board/noList" id="notice">공지사항</a></li>
          <!--         <li class="dropdown"> -->
          <!--           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a> -->
          <!--           <ul class="dropdown-menu" role="menu"> -->
          <!--             <li><a href="#">Action</a></li> -->
          <!--             <li><a href="#">Another action</a></li> -->
          <!--             <li><a href="#">Something else here</a></li> -->
          <!--             <li class="divider"></li> -->
          <!--             <li><a href="#">Separated link</a></li> -->
          <!--             <li class="divider"></li> -->
          <!--             <li><a href="#">One more separated link</a></li> -->
          <!--           </ul> -->
          <!--         </li> -->
        </ul>
        <!-- 검색 -->
        <form class="navbar-form navbar-left" role="search"
          action="/fleamarket/search/searchall" id="searchForm" method="post">
          <div class="form-group">
            <input type="text" class="form-control search-box-input"
              placeholder="상품명" name="searchSubj">
          </div>
          <button type="submit" class="btn btn-default icon-search"
            id="subbtn">검색</button>
        </form>

        <ul class="nav navbar-nav navbar-right">
          <!-- 회원 이름 -->
          <c:if test="${member != null }">
            <li><a>[${member.member_name }]</a></li>
          </c:if>
          <!-- 로그인상태 -->
          <c:choose>
            <c:when test="${member.member_name == null }">
              <li><a href="/fleamarket/memmanage/login">로그인</a></li>
              <li><a href="/fleamarket/memmanage/register">회원가입</a></li>
            </c:when>
            <c:when test="${member.member_name != null }">
              <li><a href="/fleamarket/memmanage/logout">로그아웃</a></li>
            </c:when>
          </c:choose>
          <!-- 메뉴 -->
          <c:if test="${member != null }">
            <li class="dropdown"><a href="#"
              class="dropdown-toggle" data-toggle="dropdown"
              role="button" aria-expanded="false"> 메뉴 <span
                class="caret"></span>
            </a>
              <ul class="dropdown-menu" role="menu">
                <li><a
                  href="/fleamarket/memmanage/detail?member_email=${member.member_email }">
                    내 정보 </a></li>
                <li><a
                  href="/fleamarket/product/productlist?member_email=${member.member_email }">
                    내 상점 </a></li>
                <!--             <li class="divider"></li> -->
                <!--             <li><a href="#">Separated link</a></li> -->
              </ul></li>
          </c:if>
        </ul>

      </div>
      <!-- /.navbar-collapse -->
<!--     </div> -->
    <!-- /.container-fluid -->
    </nav>
  </div>
  <!-- container -->
</body>
</html>