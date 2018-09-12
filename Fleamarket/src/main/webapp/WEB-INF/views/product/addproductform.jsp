<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
  <script src="../resources/product/jquery-3.1.0.js"></script>
	<script src="../resources/product/addProduct.js"></script>
	<script src="../resources/product/upload.js"></script>
  
    <script type="text/javascript">
	    function addCheck(e) {
	    	if (confirm("상품을 등록 하시겠습니까?")) 
	    	{
	    		
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
    </style>
    
</head>

<body>
	<br>
	
		<form action="/fleamarket/product/addproduct" onsubmit="return addCheck()" method="post" enctype="multipart/form-data" name="multipleUpload">
		
 		   
 		       <p class="title">업로드할 이미지를 선택해 주세요</p>
 		       
 		       
		      <div id="imgfiles">
		       		<input type="file" class="file_tag" id="inputimgs" name="inputimgs"/>
		       </div>
		   <div>
		       <div class="imgs_wrap">
		           
		       </div>
		       <div class="uploadedList">
		       
		       </div>
		   </div>
		   
		   <!-- <div>
 		   <input type="file" id="inputimg1" name="inputimg1"/>
		   <input type="file" id="inputimg2" name="inputimg2"/>
		   <input type="file" id="inputimg3" name="inputimg3"/>  이건 들어가는대 왜 위에거는 안됨?
			</div> -->
			
			<div>
				<label >카테고리:</label>
				<div>
					<select name="subname" id="subname">
						<option>-- 카테고리를 선택해주세요 --</option>
						<c:forEach var="tmp" items="${bean.cateList }">
							<option value="${tmp.category_no }">${tmp.category_title }</option>
						</c:forEach>
					</select>
				</div>
				<div id="cate">

				</div>
			</div>
			<div >
				<label>거래지역:</label>

				<div>
					<input type="text" placeholder="선호 거래 지역" autocomplete="on" value="" name="local">

				</div>
				<div >
					<!-- <button>최근 지역</button> -->
				</div>
				<div >
					<!-- <button>지하철 검색</button> -->
				</div>
				<div>
					<!-- <button>지역 검색</button> -->
				</div>
			</div>
			<div >
				<label>상태:</label>

				<div >
					<select name="item_state">
						<option >새상품</option>
						<option >상</option>
						<option >중</option>
						<option >하</option>
					</select>
				</div>
			</div>
			<div>
				<label >제목(상품명):</label>

				<div>
					<input type="text" class="form-control" id="input_name" placeholder="제목 (최대 100자)" autocomplete="on" 
					name="title"/>
				</div>
			</div>
			<div>
				<label>가격:</label>

				<div >
					<input type="number" placeholder="10000 (가격은 숫자로 만 입력)"  name="price">

					<div>
						<label> <input type="checkbox" name="delivery_fee">택배비포함
						</label>
					</div>
					<div >
						<label> <input id="input_exchg" type="checkbox" name="change_ornot"><i></i>교환가능</label> 
					</div>
				</div>
			</div>
			<div>
				<label>상품 설명:</label>

				<div>
					<textarea class="form-control" rows="30" cols="100"
						placeholder="상품설명은 2000자까지 가능합니다." name="itemboard_contents"></textarea>
				</div>
			</div>
			<div>
				<label>연관태그:</label>
				
				<div>
					<input type="text" placeholder="선택 사항 (예: 아이폰, 케이스)" width="140px" name="tag"/>
				</div>
			</div>
				<label>수량:</label>
				<input type="number" placeholder="1" value="1" name="amount"/>
				
				<br>
				<input type="submit" value="등록">
		</form>

</body>
</html>