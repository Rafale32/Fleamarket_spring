<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<script src="../resources/product/jquery-3.1.0.js"></script>
    <!-- 부트스트랩 -->
	<link href="../resources/boot/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(function() {
	var searchSubj = '';
	var cnt = 0;
	
	//파라미터값에 있는 걸 잘라서 값으로 반환 해주는 함수 $.urlParam('searchSubj') 원하는 파람 쓰면 그 파람의 값넘어옴
	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null){
	       return null;
	    }
	    else{
	       return results[1] || 0;
	    }
	}
	
	
  	$(window).bind('scroll', function() {
	    if($(window).scrollTop() >= $('.posts').offset().top + $('.posts').outerHeight() - window.innerHeight) {
	    	
	    	//alert($(window).scrollTop() + "  " + $(document).height() + "  "  + $(window).height());
	    	
	        
	        searchSubj = $(".searchSubj").val();
	        
 	        	$.ajax({
				url: "/fleamarket/productajax/searchall?searchSubj="+searchSubj,
				type: "post",
				dataType: "json",
				success: function(data){
					var cnt = 1;
					
					
					//alert(cnt+":카운트값");
					var all = "<tr>";
					$.each(data,function(key,value) {
						
						if(cnt%5 == 0 ){
							all = all + "<tr>";
						} 
						
						var td = "<td>"+ "<a href=/fleamarket/maindetail/detailAction?itemboard_no="+ value.itemboard_No +">"
								+ "<img src=/fleamarket/resources/product/upload"+value.thumImg+"><br>" 
								+ value.itemboard_Title + "<br>" 
								+ value.item_Price + "<br>" 
								+ value.itemboard_Local + "<br>" 
								+ "</td>";
								
						all = all + td;
						/* if(cnt%4 == 0 ){
							all = all + "<tr>";
						} */
						
						if(cnt%5 == 0){
							all = all + "</tr>";
						}
						cnt = cnt + 1;
						
						//$(".itemtab").append("</tr>");
						//alert(all);
					});
					
					$(".itemtab").append(all);
					
				}//success END
			});//AJAX END
	    }//IF END
	});//SCROLL END
	
});//function END


</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="posts" id="flux" style="text-align: center; vertical-align: middle;">
	<input type="hidden" name="searchSubj" value="${bean.searchSubj }" class="searchSubj">
		<table style="undefined;table-layout: fixed; width: 1020px" class="itemtab">
			<colgroup>
				<col style="width: 61.005682px">
				<col style="width: 61.005682px">
				<col style="width: 61.005682px">
				<col style="width: 65.005682px">
				<col style="width: 66.005682px">
			</colgroup>
		  <tr>
		    <th colspan="2">검색된 상품<br><br><br><br><br></th>
		  </tr>
		  
		  <c:forEach items="${bean.itemList }" var="tmp" varStatus="sta">
		  		<c:if test="${sta.count == 1 || sta.count%4 == 1  }"><tr></c:if>
			  	<td>
			  		<a href="/fleamarket/maindetail/detail?itemboard_no=${tmp.itemboard_No }">
			  			<img src="/fleamarket/resources/product/upload${tmp.thumImg }"> <br>
			  			${tmp.itemboard_Title } <br>
			  			${tmp.item_Price }원<br>
			  			거래지역:${tmp.itemboard_Local }
			  		</a>
			  	</td>
			    
			 	<c:if test="${sta.count%4 == 0  }"></tr><br></c:if>
		  </c:forEach>
		</table>
	
	</div>
</body>
</html>