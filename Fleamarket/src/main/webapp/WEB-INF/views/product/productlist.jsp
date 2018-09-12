<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function deleteCheck(itemboard_No) {
		if (confirm("삭제 하시겠습니까?")) {
			var url = "/fleamarket/product/productdelete.do?itemboard_No="+itemboard_No;
			location.href = url;
		} else {
			alert("삭제 취소 되었습니다.");
			return;
		}
		return null;
	}
</script>
<style type="text/css">
	#tab{
		text-align: center;
		vertical-align: middle;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="tab">
	
	<table border="1">
		<tr> <td>상품사진</td> <td>물품명</td> <td>가격</td> <td>찜/댓글</td> <td>최근 수정일</td> <td>기능</td> </tr>
		<c:forEach items="${bean.itemList }" var="tmp">
			<tr> <td width="100px" height="100px"> 
				<c:forEach items="${tmp.itemImgList }" var="tmp2" begin="0" end="0">
					<img src="/fleamarket/productimg/${tmp2.thum_Img }" width="200px" height="150">
				</c:forEach> 
			</td> 
			 <td><a href="/fleamarket/maindetail/detailAction.do?itemboard_No=${tmp.itemboard_No }" >${tmp.itemboard_Title }</a></td>  
			 <td>${tmp.price }</td> <td>${tmp.favCount } / ${tmp.itemQnaCount }</td> <td>${tmp.itemboard_Date }</td> 
		<c:choose>
			<c:when test="${param.store_Name != null}">
				
			</c:when>
			<c:when test="${param.member_email != '' }">
				<td><a href="/fleamarket/product/productmodifyform.do?itemboard_No=${tmp.itemboard_No }">수정</a> 
				<input type="button" onclick="deleteCheck(${tmp.itemboard_No })" value="삭제">
				<%-- <a href="/fleamarket/product/productdelete.do?itemboard_No=${tmp.itemboard_No }" onclick="deleteCheck(${tmp.itemboard_No })">삭제</a>  --%>
				</td> 
			</tr>
			</c:when>
		</c:choose>
			 
		</c:forEach>
	</table>

	<c:if test="${member.member_email != null && bean.itemDTO.store_name == null}">
		<c:if test="${bean.pageModel.startPage>5 }">
			<a href="/fleamarket/product/productlist.do?member_email=${member.member_email }&pageNum=${bean.pageModel.startPage - 1 }">[이전]</a>
		</c:if>
		
		<c:forEach var="pageNo"  begin="${bean.pageModel.startPage}" end="${bean.pageModel.endPage }">
			<c:if test="${bean.pageModel.requestPage == pageNo }"><b></c:if>
			<a href="/fleamarket/product/productlist.do?member_email=${member.member_email }&pageNum=${pageNo }">[${pageNo }]</a>
			<c:if test="${bean.pageModel.requestPage == pageNo }"></b></c:if>
		</c:forEach>
		
		<c:if test="${bean.pageModel.endPage < bean.pageModel.totalPageCount}">
			<a href="/fleamarket/product/productlist.do?member_email=${member.member_email }&pageNum=${bean.pageModel.startPage + 5 }">[이후]</a>
		</c:if>
	</c:if>
	
	<c:if test="${param.store_name != null }">
		<c:if test="${bean.pageModel.startPage>5 }">
			<a href="/fleamarket/product/productlist.do?store_Name=${bean.itemDTO.store_Name }&pageNum=${bean.pageModel.startPage - 1 }">[이전]</a>
		</c:if>
		
		<c:forEach var="pageNo"  begin="${bean.pageModel.startPage}" end="${bean.pageModel.endPage }">
			<c:if test="${bean.pageModel.requestPage == pageNo }"><b></c:if>
			<a href="/fleamarket/product/productlist.do?store_Name=${bean.itemDTO.store_Name }&pageNum=${pageNo }">[${pageNo }]</a>
			<c:if test="${bean.pageModel.requestPage == pageNo }"></b></c:if>
		</c:forEach>
		
		<c:if test="${bean.pageModel.endPage < bean.pageModel.totalPageCount}">
			<a href="/fleamarket/product/productlist.do?store_Name=${bean.itemDTO.store_Name }&pageNum=${bean.pageModel.startPage + 5 }">[이후]</a>
		</c:if>
	</c:if>
	
	</div>
</body>
</html>