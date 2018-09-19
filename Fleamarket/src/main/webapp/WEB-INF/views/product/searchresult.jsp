<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
  request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
  $(function() {
    var searchSubj = '';
    var cnt = 1;

    //파라미터값에 있는 걸 잘라서 값으로 반환 해주는 함수 $.urlParam('searchSubj') 원하는 파람 쓰면 그 파람의 값넘어옴
    $.urlParam = function(name) {
      var results = new RegExp('[\?&]' + name + '=([^&#]*)')
          .exec(window.location.href);
      if (results == null) {
        return null;
      } else {
        return results[1] || 0;
      }
    }

    $("#moreinfo").on("click",function() {
      searchSubj = $(".searchSubj").val();
			$.ajax({
			  url : "/fleamarket/productajax/searchall?searchSubj="+ 
				searchSubj,
				type : "post",
        dataType : "json",
        success : function(data) {

        //alert(cnt+":카운트값"); var all = "<tr>";
        var all = "";
        $.each(data,function(key, value) {
          all = all + "<div class='col-sm-6 col-md-3'>";
// 					if (cnt == 1 || cnt % 4 == 1) {
//             all = all + "<tr>";
//          }
//           var td = "<td>"
//           + "<a href=/fleamarket/maindetail/detailAction?itemboard_no="
//           + value.itemboard_No
//           + ">"
//           + "<img src=/fleamarket/resources/product/upload"+value.thumImg+"/><br>"
//           + value.itemboard_Title + "<br>"
//           + value.item_Price + "<br>"
//           + value.itemboard_Local + "<br></a>"
//           + "</td>";
          
					//  썸네일변환
          var div = "<div class='thumbnail' style='box-shadow: 5px 7px 20px -5px #8a8a8a;'>"
          + "<a href=/fleamarket/maindetail/detail?itemboard_no="
          + value.itemboard_No + ">"
          + "<img src=/fleamarket/resources/product/upload"+value.thumImg
          +" class='img'/>"
          + "<div class='caption text-center'>"
          + "<h4>" + value.itemboard_Title + "</h4>"
          + "<p>" + value.item_Price + "원</p>"
          + "<p>" + value.itemboard_Local + "</p>"
          + "</div></a></div>";

          all = all + div;
          /* if(cnt%4 == 0 ){
          	all = all + "<tr>";
          } */

//           if (cnt % 4 == 0) {
            all = all + "</div>";
//           }
          
//           cnt = cnt + 1;

        }); //each END

      	$(".itemtab").append(all);
      //alert("**********"+all+"--------------------------------------------------"+cnt);
    	}//success END
  	});//AJAX END
	});//moreinfo click END
});//function END
</script>

<title>검색 페이지</title>
</head>
<body>
  <div class="container">
    <h4>'${bean.searchSubj }' 검색</h4>
    <input type="hidden" name="searchSubj" value="${bean.searchSubj }" class="searchSubj">
    <div class="row itemtab">
      <c:forEach items="${bean.itemList }" var="tmp" varStatus="sta">
        
<%--         <c:if test="${sta.count == 1 || sta.count%4 == 1  }"> --%>
        <div class="col-sm-6 col-md-3">
        <a href="/fleamarket/maindetail/detail?itemboard_no=${tmp.itemboard_No }">
<%--         </c:if> --%>
          <div class="thumbnail" style="box-shadow: 5px 7px 20px -5px #8a8a8a;">
            <img src="/fleamarket/resources/product/upload${tmp.thumImg }">
            <div class="caption text-center">
              <h4>${tmp.itemboard_Title }</h4>
              <p><fmt:formatNumber value="${tmp.item_Price }" />원</p>
              <p>${tmp.itemboard_Local }</p>
            </div>
          </div>
<%--         <c:if test="${sta.count%4 == 0  }"> --%>
        </a> 
        </div>
<%--         </c:if> --%>

      </c:forEach>
    </div>

      
      <!-- 버튼 -->
      <div class="text-right">
        <input type="button" value="더보기" id="moreinfo" class="btn btn-info">
      </div>
<!-- 
    <div class="posts" id="flux">
      <input type="hidden" name="searchSubj" value="${bean.searchSubj }" class="searchSubj">
      <table border="1" class="itemtab table">
        <colgroup>
          <col style="width: 61.005682px">
          <col style="width: 61.005682px">
          <col style="width: 61.005682px">
          <col style="width: 65.005682px">  
        </colgroup>
        <tr>
          <th colspan="4">검색된 상품<br> <br> <br> <br>
            <br></th>
        </tr>

        <c:forEach items="${bean.itemList }" var="tmp" varStatus="sta">
          <c:if test="${sta.count == 1 || sta.count%4 == 1  }">
            <tr>
              </c:if>
              <td>
                <a href="/fleamarket/maindetail/detail?itemboard_no=${tmp.itemboard_No }">
                  <img src="/fleamarket/resources/product/upload${tmp.thumImg }">
                  <br>
                  ${tmp.itemboard_Title }
                  <br>
                  ${tmp.item_Price }원
                  <br>
                  거래지역:${tmp.itemboard_Local }
               </a>
              </td>
              <c:if test="${sta.count%4 == 0  }">
           </tr>
              <br>
              </c:if>
        </c:forEach>
        
      </table>
      <div>
        <input type="button" value="더보기" id="moreinfo" class="btn btn-info">
      </div>
    </div>
     -->
  </div>
</body>
</html>