<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>

<script src="../resources/product/addProduct.js"></script>
<script src="../resources/product/upload.js"></script>

<script type="text/javascript">
  function addCheck(e) {
    if (confirm("상품을 등록 하시겠습니까?")) {

      return true;
      //document.getElementById('ff').submit();
    } else {
      alert("상품등록이 취소 되었습니다.");
      //e.preventDefault();
      return false;
    }
  }
</script>
<style type="text/css">
.imgs_wrap {
  width: 600px;
  margin-top: 50px;
}

.imgs_wrap img {
  max-width: 200px;
  max-height: 200px;
}

.filebox label {
 display: inline-block;
 padding: .5em .75em;
 color: #999;
 font-size: inherit;
 line-height: normal;
 vertical-align: middle;
 background-color: #fdfdfd;
 cursor: pointer;
 border: 1px solid #ebebeb;
 border-bottom-color: #e2e2e2;
 border-radius: .25em;
}
.filebox input[type="file"] {
 /* 파일 필드 숨기기 */
 position: absolute;
 width: 1px;
 height: 1px;
 padding: 0;
 margin: -1px;
 overflow: hidden;
 clip:rect(0,0,0,0);
 border: 0;
 }
 
.filebox.bs3-primary label {
  color: #fff;
  background-color: #337ab7;
  border-color: #2e6da4;
}


</style>

</head>

<body>
  <div class="container">
    <div class="page-header text-center">
      <h1> 상품등록 </h1>
    </div>
    
    <div class="col-md-6 col-md-offset-3">
      <!-- 이미지 -->
      <label>이미지</label><span>업로드할 이미지를 선택해 주세요</span>
      <form action="/fleamarket/product/addproduct" onsubmit="return addCheck()"
        method="post" enctype="multipart/form-data" name="multipleUpload">
      
      
      <div id="imgfiles" class="filebox bs3-primary">
        <label for="inputimgs">업로드</label>
        <input type="file" class="file_tag" id="inputimgs" name="inputimgs" />
        <span>업로드할 이미지를 선택해 주세요</span>
      </div>
      <div>
        <div class="imgs_wrap"></div>
        <div class="uploadedList"></div>
      </div>
      <div class="hiddenimg"></div>

      <!-- <div>
         <input type="file" id="inputimg1" name="inputimg1"/>
         <input type="file" id="inputimg2" name="inputimg2"/>
         <input type="file" id="inputimg3" name="inputimg3"/>  이건 들어가는대 왜 위에거는 안됨?
        </div> --> 
      
        
    
      
    <!-- 카테고리 -->
    <!-- Single button -->
    <br>
    <div>
      <label>카테고리</label>&nbsp;&nbsp;&nbsp;
<!--       <div> -->
        <select name="subname" id="subname" style="display: inline-block;">
          <option>-- 카테고리를 선택해주세요 --</option>
          <c:forEach var="tmp" items="${bean.cateList }">
            <option value="${tmp.category_no }">${tmp.category_title }</option>
          </c:forEach>
        </select>
<!--       </div> -->
      <div id="cate" style="display: inline-block;"></div>
    </div>
    <br>
    <!-- 제목 -->
    <div>
      <label>제목(상품명)</label>&nbsp;&nbsp;&nbsp;
      <div style="display: inline-block;">
        <input type="text" class="form-control" id="input_name" placeholder="제목 (최대 100자)" autocomplete="on" name="itemboard_Title" />
      </div>
    </div>
    <br>
    <!-- 거래지역 -->
      <div style="display: inline-block;">
      <label>거래지역</label>&nbsp;&nbsp;&nbsp;
      <div style="display: inline-block;">
        <input type="text" placeholder="선호 거래 지역" autocomplete="on" value="" name="itemboard_Local">
      </div>
      <div>
        <!-- <button>최근 지역</button> -->
      </div>
      <div>
        <!-- <button>지하철 검색</button> -->
      </div>
      <div>
        <!-- <button>지역 검색</button> -->
      </div>
    </div>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <!--  상태 -->
      <div style="display: inline-block;">
      <label>상태</label>&nbsp;&nbsp;&nbsp;
      <div style="display: inline-block;">
        <select name="item_State">
          <option value="0">새상품</option>
          <option value="1">상</option>
          <option value="2">중</option>
          <option value="3">하</option>
        </select>
      </div>
    </div>
    <br><br>
    
    <!-- 가격 -->
    <div>
      <label>가격</label>&nbsp;&nbsp;&nbsp;
      <div style="display: inline-block;">
        <input type="number" placeholder="10000 (가격은 숫자만 입력)" name="item_Price">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div style="display: inline-block;">
            <input type="checkbox" name="deliveryIs">
              <label>택배비포함 </label>
        </div>
        <div style="display: inline-block;">
            <input id="input_exchg" type="checkbox" name="changeIs"><i></i>
            <label>교환가능</label>
        </div>
      </div>
    </div>
    <br>
    <div>
      <!-- 연관태그 -->
      <div style="display: inline-block; ">
        <label>연관태그</label>&nbsp;&nbsp;&nbsp;
        <input type="text" placeholder="선택사항(예: 아이폰, 케이스)" name="tag_Name" />
      </div>
      <!-- 수량 -->
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <div style="display: inline-block; ">
        <label>수량</label>&nbsp;&nbsp;&nbsp;
        <input type="number" placeholder="1" value="1" name="item_Amount"  /> <br>
      </div>
    </div>
    <br>
    <!-- 상품설명 -->
    <div>
      <label>상품 설명</label>&nbsp;&nbsp;&nbsp;
      <div>
        <textarea class="form-control" rows="20" placeholder="상품설명은 2000자까지 가능합니다." name="itemboard_Contents"></textarea>
      </div>
    </div>
    <br>

    <!-- 버튼 -->
    <input type="submit" value="등록" class="btn btn-info" style="display: block; margin: 0 auto;">
  </form>
  
  </div><!--   size -->
</div><!-- container -->
</body>
</html>