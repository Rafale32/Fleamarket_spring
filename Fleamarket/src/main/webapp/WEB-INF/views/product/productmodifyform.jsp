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
	    	if (confirm("상품을 수정 하시겠습니까?")) 
	    	{
	    		
	    		return true;
	    		//document.getElementById('ff').submit();
	    	} else {
	    		alert("상품수정이 취소 되었습니다.");
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
	
		<form action="/fleamarket/product/productmodify" onsubmit="return addCheck()" method="post" enctype="multipart/form-data" name="multipleUpload">
		
 		   		
 		      <p class="title">업로드할 이미지를 선택해 주세요</p>
 		      
 		      
		      <div id="imgfiles">
		       		<input type="file" class="file_tag" id="inputimgs" name="inputimgs"/>
		       </div>
		   <div>
		       <div class="imgs_wrap">
		           <c:forEach items="${bean.itemDTO.itemImgList }" var="tmp" varStatus="status">
		           		<img src="/fleamarket/resources/product/upload${tmp.thum_Img }" class="img${status.index }">
		           		<button value="${tmp.thum_Img }|${tmp.big_Img }|${status.index }" class="btn" id="btn${status.index }">그림 삭제하기</button>
		           </c:forEach>
		       </div>
		       <div class="uploadedList">
		       		
		       </div>
		   </div>
		   <div class="hiddenimg">
		   		
		   </div>
		   
			
			<div>
				<label >카테고리:</label>
				<div>
					<select name="subname" id="subname">
						<option>-- 카테고리를 선택해주세요 --</option>
						<c:forEach var="tmp" items="${bean.cateList }" >
							<c:choose>
								<c:when test="${tmp.category_no == bean.itemDTO.category_No}">
									<option value="${tmp.category_no }" selected="selected">${tmp.category_title }</option>
								</c:when>
								<c:otherwise>
									<option value="${tmp.category_no }">${tmp.category_title }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div id="cate">
					<select name="subsubname" id="subsubname">
						<c:forEach var="tmp" items="${bean.subCate }" >
							<c:choose>
								<c:when test="${tmp.sub_No == bean.itemDTO.sub_No}">
									<option value="${tmp.sub_No }" selected="selected">${tmp.sub_Title }</option>
								</c:when>
								<c:otherwise>
									<option value="${tmp.sub_No }">${tmp.sub_Title }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>		
					</select>			
				</div>
			</div>
			<div >
				<label>거래지역:</label>

				<div>
					<input type="text" placeholder="선호 거래 지역" autocomplete="on" value="${bean.itemDTO.itemboard_Local }" name="itemboard_Local">

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
						<c:choose>
							<c:when test="${bean.itemDTO.item_State == 0 }">
								<option selected="selected" value="0">새상품</option>
								<option value="1">상</option>
								<option value="2">중</option>
								<option value="3">하</option>
							</c:when>
							<c:when test="${bean.itemDTO.item_State == 1 }">
								<option value="0">새상품</option>
								<option selected="selected" value="1">상</option>
								<option value="2">중</option>
								<option value="3">하</option>
							</c:when>
							<c:when test="${bean.itemDTO.item_State == 2 }">
								<option value="0">새상품</option>
								<option value="1">상</option>
								<option selected="selected" value="2">중</option>
								<option value="3">하</option>
							</c:when>
							<c:when test="${bean.itemDTO.item_State == 3 }">
								<option value="0">새상품</option>
								<option value="1">상</option>
								<option value="2">중</option>
								<option selected="selected" value="3">하</option>
							</c:when>
						</c:choose>
					</select>
				</div>
			</div>
			<div>
				<label >제목(상품명):</label>

				<div>
					<input type="text" class="form-control" id="input_name" placeholder="제목 (최대 100자)" autocomplete="on" 
					name="itemboard_Title" value="${bean.itemDTO.itemboard_Title }"/>
				</div>
			</div>
			<div>
				<label>가격:</label>

				<div >
					<input type="number" placeholder="10000 (가격은 숫자로 만 입력)"  value="${bean.itemDTO.item_Price }" name="item_Price">

					<div>
						<label> 
							<c:if test="${bean.itemDTO.item_Delivery_B == 1 }">
								<input type="checkbox" name="deliveryIs" checked="checked">
							</c:if>
							<c:if test="${bean.itemDTO.item_Delivery_B == 0 }">
								<input type="checkbox" name="deliveryIs">
							</c:if>
						택배비포함 </label>
					</div>
					<div >
						<label> 
							<c:if test="${bean.itemDTO.itemboard_Change_b == 1 }">
								<input id="input_exchg" type="checkbox" name="changeIs" checked="checked"> 
							</c:if>
							<c:if test="${bean.itemDTO.itemboard_Change_b == 0 }">
								<input id="input_exchg" type="checkbox" name="changeIs"> 
							</c:if>
						교환가능</label> 
					</div>
				</div>
			</div>
			<div>
				<label>상품 설명:</label>

				<div>
					<textarea class="form-control" rows="30" cols="100"
						placeholder="상품설명은 2000자까지 가능합니다." name="itemboard_Contents">${bean.itemDTO.itemboard_Contents }</textarea>
				</div>
			</div>
			<div>
				<label>연관태그:</label>
				
				<div>
					<input type="text" placeholder="선택 사항 (예: 아이폰, 케이스)" value="${bean.itemDTO.tag_Name }" width="140px" name="tag_Name"/>
				</div>
			</div>
				<label>수량:</label>
				<input type="number" placeholder="1" value="${bean.itemDTO.item_Amount }"  name="item_Amount"/>
				
				<br>
				<input type="submit" value="등록">
		</form>

</body>
</html>