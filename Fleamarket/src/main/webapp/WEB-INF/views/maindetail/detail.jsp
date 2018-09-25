<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/maindetail/detail.css" type="text/css">
<link rel="stylesheet" href="../resources/maindetail/rotation/css/main.css" type="text/css">
<link rel="stylesheet" href="../resources/maindetail/rotation/css/normalize.css" type="text/css">
<script type="text/javascript" src="../resources/maindetail/rotation/js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
<script type="text/javascript" src="../resources/maindetail/rotation/js/main.js"></script>
<script type="text/javascript" src="../resources/maindetail/rotation/js/vendor/modernizr.custom.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script id="template" type="text/x-handlebars-template">
<li class="replyLi" data-item_qna_no={{item_qna_no}}>
<div class="comments-wrapper">
   <div class="comment-item">
      <div class="comment-item-wrapper">
         <div class="comment-info-wrapper">
            <div class="comment-info-header">
               <div class="comment-writer-name">
                  <a href="/fleamarket/product/productlist?store_Name={{store_name}}">{{store_name}}</a>
               </div>
               <div class="comment-date">{{item_qna_date}}</div>
            </div>
            <div class="comment-content">{{item_qna_contents}}</div>
               <a id="replyDelBtn">
                  <label class="hidden" id="qnaNo">{{item_qna_no}}</label>
                  <div class="delete-qna">삭제</div>
               </a>
            <div class="split"></div>
         </div>
      </div>
   </div>
</div>
</li>
</script>

<script id="template2" type="text/x-handlebars-template">
<li class="replyLi" data-item_qna_no={{item_qna_no}}>
<div class="comments-wrapper">
   <div class="comment-item">
      <div class="comment-item-wrapper">
         <div class="comment-info-wrapper">
            <div class="comment-info-header">
               <div class="comment-writer-name">
                  <a href="/fleamarket/product/productlist?store_Name={{store_name}}">{{store_name}}</a>
               </div>
               <div class="comment-date">{{item_qna_date}}</div>
            </div>
            <div class="comment-content">{{item_qna_contents}}</div>
            <div class="split"></div>
         </div>
      </div>
   </div>
</div>
</li>
</script>


<script>

var printData = function(replyArr, target, templateObject){
   
   var template = Handlebars.compile(templateObject.html());
   
   var html = template(replyArr);
    $(".replyLi").remove();
   target.after(html);
}
</script>

<script type="text/javascript">
$(document).ready(function(){
var itemboard_noObj = $("#itemboard_no");
var itemboard_no = itemboard_noObj.val();
console.log($("#itemboard_no").val());

var qnaCnt = 4;
var qnaCheck = 0;
getAllList();

var favCheck = false; //찜 여부 확인하기 위한 변수
var fav_no = 0; //
getFav();

/* if($("#replies li").size() > 1){
   return;
} */

//댓글목록리스트
 function getAllList(){
   $.getJSON("/fleamarket/qna/all/"+itemboard_no, function(data){ 
     
      var member_noObj = $("#member_no");
      var member_no = member_noObj.val();
      var cnt = 0;
      
      $("#ccnt").remove();
      $(".replyLi").remove();
      $.each(data, function(index, item) {
         cnt++;
         
         if(member_no == item.member_no){
            var source = $("#template").html();
            var template = Handlebars.compile(source);
            $("#repliesDiv").after(template(item));
         }else{
            var source = $("#template2").html();
            var template = Handlebars.compile(source);
            $("#repliesDiv").after(template(item));
         }
      });
      
      var str = "<span id='ccnt' class='comments-count'>"+cnt+"</span>"
      $("#comment-title").append(str);
   }); 
	}

/* function getAllList(){
  $.getJSON("/fleamarket/qna/all/"+itemboard_no, function(data){ 
    
     var member_noObj = $("#member_no");
     var member_no = member_noObj.val();
     var cnt = 0;
     
     $("#ccnt").remove();
     if(qnaCheck > 0){
//      	 $(".replyLi").remove();
  	 }
     $.each(data, function(index, item) {
        cnt++;
        if(index >= qnaCheck && index < qnaCnt){
        	console.log(index);
        	if(member_no == item.member_no){
            var source = $("#template").html();
            var template = Handlebars.compile(source);
            $("#repliesDiv").after(template(item));
          }else{
            var source = $("#template2").html();
            var template = Handlebars.compile(source);
            $("#repliesDiv").after(template(item));
          }
        }
     });
     
     var str = "<span id='ccnt' class='comments-count'>"+cnt+"</span>"
     
     if(qnaCheck == 0){
    	 $("#comment-title").append(str);
     }
     else{
    	 $("#replies>li:first-child").after(str);
     }
     qnaCheck = qnaCnt;
     qnaCnt= qnaCnt + 4;
  }); 
}

	$("#qnaBtn").on("click", function(){
		getAllList();
	}); */
/* //스크롤처리
	$(window).bind('scroll', function() {
  	if($(window).scrollTop() >= $('body').offset().top + $('body').outerHeight() - window.innerHeight) {
  	  alert("Dz"); 
//   		getAllList();
 	 }
	}); */
   
  $(document).ready(function(){
      $('.btn-call').click(function(){
        var email = $(this).val();
        console.log($(this).val());
         if(email.length == 0){
            alert("로그인 해주세요.");  
         } 
      });
  });

  //댓글등록
  $("#replyAddBtn").on("click", function(){

     var itemboard_noObj = $("#itemboard_no");
     var member_noObj = $("#member_no");
     var item_qna_contentsObj = $("#item_qna_contents");
     
     var itemboard_no = itemboard_noObj.val();
     var member_no = member_noObj.val();
     var item_qna_contents = item_qna_contentsObj.val();
     
     $.ajax({
        type:'post',
        url:'/fleamarket/qna',
        headers :{
           "Content-Type" : "application/json",
           "X-HTTP-Method-Override" : "POST"
        },
        dataType : 'text',
        data : JSON.stringify({
           itemboard_no : itemboard_no,
           member_no : member_no,
           item_qna_contents : item_qna_contents
        }),
        success : function(result){
           console.log("result: "+result);
           if(result == 'SUCCESS'){
              alert("등록되었습니다.");
              getAllList();
//               member_noObj.val("");
//               item_qna_contentsObj.val("");
           }
        }
     });
  });

  //댓글수정
  $("#replies").on("click", ".replyLi button", function(){
     var reply = $(this).parent();
     
     var item_qna_no = reply.attr("data-item_qna_no");
     var item_qna_contents = reply.text();
     
     alert(item_qna_no + " : " + item_qna_contents);
     
  });
  
  //댓글삭제
  $("body").on("click",' #replyDelBtn',function(){
     var item_qna_no = $(this).find('label').text()
     item_qna_no *= 1;
     
     $.ajax({
        type:'delete',
        url:'/fleamarket/qna/'+item_qna_no,
        headers :{
           "Content-Type" : "application/json",
           "X-HTTP-Method-Override" : "DELETE"},
        dateType:'text',
        success : function(result){
           console.log("result: "+result);
           if(result == 'SUCCESS'){
              alert("삭제 되었습니다.");
//               $(".replyLi").remove();
               $(this).find('.replyLi').remove();
              getAllList();
           }
        }
     });
  });
  
  //찜하기, 찜 취소하기
  $(function() {
    $('#fav-btn').click(function() {
       var itemboard_noObj = $("#itemboard_no");
       var member_noObj = $("#member_no");
       var itemboard_no = itemboard_noObj.val();
       var member_no = member_noObj.val();
       
       if(member_no == 0){
          alert("로그인 해주세요.");
          return;
       }
       
       if(favCheck){
          $.ajax({
            type:'delete',
            url:'/fleamarket/fav/'+fav_no,
            headers :{
               "Content-Type" : "application/json",
               "X-HTTP-Method-Override" : "DELETE"},
            dateType:'text',
            success : function(result){
               console.log("result: "+result);
               if(result == 'SUCCESS'){
                  alert("찜 취소되었습니다.");
                  getFav();
                  favCheck = false;
               }
            }
         });
       }else{
          $.ajax({
             type:'post',
             url:'/fleamarket/fav',
             headers :{
                "Content-Type" : "application/json",
                "X-HTTP-Method-Override" : "POST"
             },
             dataType : 'text',
             data : JSON.stringify({
                itemboard_no : itemboard_no,
                member_no : member_no,
             }),
             success : function(result){
                console.log("result: "+result);
                if(result == 'SUCCESS'){
                   alert("찜 등록되었습니다.");
                   getFav();
                }
             }
          });
       }   
     });
  });
     
     //찜목록 가져오는 함수
    function getFav(){
       $.getJSON("/fleamarket/fav/all/"+itemboard_no, function(data){ 
         
          var member_noObj = $("#member_no");
          var member_no = member_noObj.val();
          
          var cntNum = 0;
          
          $.each(data, function(index, item){
             cntNum++;
             if(member_no == item.member_no){
                favCheck = true;
                fav_no = item.fav_no;
             }
          });
          $('#cnt').remove();
          str = "<span id='cnt' class='faved-cnt'>  "+cntNum+"</span>";
          $(".faved-cnt").after(str);
          
          $('#cnt2').remove();
          str2 = "<span id='cnt2' class='text-pick'>찜 "+cntNum+"</span>";
          $("#product-fav").prepend(str2);
          
          if(favCheck){
             $('.faved-cnt').css("color","yellow");
          }else{
             $('.faved-cnt').css("color","white");
          }
       });
    }
     
     
		//이미지 슬라이드
		$(function(){
	var $container = $('.slideshow'); //슬라이드쇼 전체컨테이너
	var $slideGroup = $('.slideshow-slides');//슬라이더 그룹
	var $slides = $slideGroup.find('.slide');//각각의 슬라이더 4개
	var $nav = $container.find('.slideshow-nav');//네비게이션(prev, next)
	var $indicator = $container.find('.slideshow-indicator');//인디게이터
	
	var currentIndex = 0; //현재 슬라이드의 인덱스를 저장하는 변수
	var indicatorHTML = '';
	var timer;
	
	$slides.each(function(i){
		$(this).css({
			left: 100 * i + '%'
		});
		
		indicatorHTML += '<a href="#">'+(i+1)+'</a>'
	});
	
	$indicator.html(indicatorHTML);
	
	//슬라이더 이동함수
	function goToSlide(index){
		$slideGroup.animate({
			left: -100 * index + '%'
		},/*시간간격*/ 500);
		currentIndex = index;
		updateNav();
	}
	
	//인디케이터 이벤트
	//indicator의 a태그는 원래 있던 태그가 아니라
	//함수로 만든 태그이기 때문에 click이 아닌
	//부모인 indicator에 on함수로 이벤트 적용
	/*$indicator.on('hover','a', function(event){
		event.preventDefault();
		//.index : 몇번째 인덱스인지 반환
		goToSlide($(this).index());
	});*/
	$indicator.find('a').hover(function(event){
		event.preventDefault();
		goToSlide($(this).index());
	});
	//네비게이션 이벤트
	$nav.find('a').click(function(event){
		event.preventDefault();
		if($(this).hasClass('prev')){
			goToSlide(currentIndex -1);
		}else{
			goToSlide(currentIndex +1);
		}
		
		updateNav();
	})
	
	//네비게이션 업데이트 함수
	function updateNav(){
		var $navPrev = $nav.find('.prev');
		var $navNext = $nav.find('.next');
		
		if(currentIndex == 0){
			$navPrev.addClass('disabled');
		}else{
			$navPrev.removeClass('disabled');
		}
		
		if(currentIndex == 3){
			$navNext.addClass('disabled');
		}else{
			$navNext.removeClass('disabled');
		}
		
		//해당 인디게이터에게 'active' 클래스 적용
		$indicator.find('a').removeClass('active')
			.eq(currentIndex).addClass('active');
	}
	
	//마우스 관련 이벤트
	$container.on({ //이벤트 여러개 걸때
		mouseenter : stopTimer,
		mouseleave : startTimer
	});
	
	//타이머 시작함수
	function startTimer(){
		//주기적으로 호출하는 함수
		timer = setInterval(function(){
			var nextIndex = (currentIndex + 1) % 4;
			goToSlide(nextIndex);
		}, 2000);
	}
	
	//타이머 정지함수
	function stopTimer(){
		clearInterval(timer);
	}
	
	updateNav();
	startTimer();
});
});
</script>
<style type="text/css">
</style>
</head>
<body>
   <div class="main">
      <div class="category">
         <h3>카테고리목록</h3>
         <div role="menu" class="category-menu"></div>
         <c:forEach var="list" items="${bean.categoryList}">
            <div class="cate">
               <a class="cate-btn" href="">${list.category_title }</a>
            </div>
            <%-- <c:forEach var="subList" items="${list.subCategory}">
            <a href="">${subList.sub_title }</a>
         </c:forEach>  --%>
         </c:forEach>
      </div>
      <div class="itemDetail">
         <div class="item-detail-wrapper">
            <div class="product-summary-wrapper">
               <div class="product-image-slide">
                  <%-- <c:forEach var="imgList" items="${bean.itemImgList}" begin="0"
                     end="0" step="1">
                     <img class="image" alt="" src="/fleamarket/resources/product/upload${imgList.big_img}">
                  </c:forEach> --%>
                  <div class="slideshow">
   									<div class="slideshow-slides">
<!--         							<a href="./" class="slide" id="slide-1"><img src="./img/slide-1.jpg" alt="" width="1600" height="465"></a> -->
        							<c:forEach var="imgList" items="${bean.itemImgList}" varStatus="i">
                     		<a href="./" class="slide" id="slide-${i}">
                     			<img alt="" src="/fleamarket/resources/product/upload${imgList.big_img}" width="434" height="434">
                     		</a>	
                  		</c:forEach>
    								</div>
    								<div class="slideshow-nav">
        							<a href="#" class="prev">Prev</a>
        							<a href="#" class="next">Next</a>
    								</div>
    								<div class="slideshow-indicator"></div>
									</div>
               </div>
               <div class="product-summary">
                  <div class="product-summary">
                     <div class="product-summary__title">
                        <h2>${bean.itemDetail.itemboard_title }</h2>
                        <h3>
                           <fmt:formatNumber value="${bean.itemDetail.item_price}" />
                           <small>원</small>
                        </h3>
                     </div>
                     <div id="product-fav" class="product-summary__assistant">
                        <%-- <span class="text-pick"><div class="icon icon pick"></div>
                           찜 ${bean.itemDetail.fav_no} </span> --%> <span class="split"></span> <span
                           class="text-eye"><div class="icon icon eye"></div> 조회수
                           ${bean.itemDetail.itemboard_viewcount } </span> <span class="split"></span> <span
                           class="text-time"><div class="icon icon time"></div>
                           ${bean.itemDetail.itemboard_date } </span>
                     </div>
                     <ul class="product-summary__assistant-2nd">
                        <li class="status"><strong>상품상태</strong> <span
                           class="value"> <c:choose>
                                 <c:when test="${bean.itemDetail.item_state eq 0}">새상품</c:when>
                                 <c:when test="${bean.itemDetail.item_state eq 1}">중고(상)</c:when>
                                 <c:when test="${bean.itemDetail.item_state eq 2}">중고(중)</c:when>
                                 <c:when test="${bean.itemDetail.item_state eq 3}">중고(하)</c:when>
                              </c:choose>
                        </span></li>
                        <li class="exchange"><strong>교환여부</strong> <span
                           class="value"> <c:choose>
                                 <c:when test="${bean.itemDetail.itemboard_change_B eq 0}">교환불가</c:when>
                                 <c:when test="${bean.itemDetail.itemboard_change_B eq 1}">교환가능</c:when>
                              </c:choose>
                        </span></li>
                        <li class="shipping"><strong>배송비</strong> <span
                           class="value"> <c:choose>
                                 <c:when test="${bean.itemDetail.item_delivery_B eq 0}">배송비 별도</c:when>
                                 <c:when test="${bean.itemDetail.item_delivery_B eq 1}">무료배송</c:when>
                              </c:choose>
                        </span></li>
                        <li class="location"><strong>거래지역</strong> <span
                           class="value"><div class="icon location-sm"></div>
                              ${bean.itemDetail.itemboard_local}</span></li>
                     </ul>
                     <div class="button-container">
                        <c:choose>
                           <c:when test="${member.member_name ne null}">
                              <button id="fav-btn" class="btn-faved">
                              <div class="icon icon-faved pick-white"></div>
                              <span id="fav" class="faved-cnt">찜</span>
                              <!---->
                              </button>
                           </c:when>
                           <c:otherwise>
                              <button id="fav-btn" class="btn-faved"
                                    onclick="location.href = '/fleamarket/memmanage/login'">
                              <div class="icon icon-faved pick-white"></div>
                              <span class="faved-cnt">찜</span>
                              <!---->
                              </button>
                           </c:otherwise>
                        </c:choose>
                        

                        <c:choose>
                           <c:when test="${bean.itemDetail.item_delivery_state eq 1 }">
                              <c:choose>
                                 <c:when test="${member.member_name ne null}">
                                    <button   onclick="location.href = '/fleamarket/safepay/order?item_no=${bean.itemDetail.item_no}'"
                                       class="btn-call" value="${member.member_name}">안심결제</button>
                                 </c:when>
                                 <c:otherwise>
                                    <button
                                       onclick="location.href = '/fleamarket/memmanage/login'"
                                       class="btn-call">안심결제</button>
                                 </c:otherwise>
                              </c:choose>
                           </c:when>
                           <c:otherwise>
                              <button class="btn-call">판매완료</button>
                           </c:otherwise>
                        </c:choose>

                        <!---->
                     </div>
                     <!---->
                  </div>
               </div>
               <!--             </div> -->
            </div>

            <br> <br>
            <div class="itemDetail2">
               <div class="detail-tab-content-wrapper">
                  <div class="product-content">
                     <div class="product-info-wrapper">
                        <div class="product-info">
                           <div class="title">상품정보</div>
                           <div class="description">${bean.itemDetail.itemboard_contents}</div>
                           <ul class="assistant-list">
                              <li class="assistant"><strong>거래지역</strong><br> <span
                                 class="value">${bean.itemDetail.itemboard_local}</span></li>
                              <li class="assistant"><strong>카테고리</strong>
                              	<a href="/fleamarket/maindetail/categoryitem?category_title=${bean.itemDetail.category_title}">
                              		<div>${bean.itemDetail.category_title}</div>
                              	</a>
                              <li class="assistant"><strong>상품태그</strong>
                                 <div>
                                    <c:if test="${bean.itemDetail.tagList ne null}">
                                       <c:forEach var="list" items="${bean.itemDetail.tagList}">
                                          <a href="/fleamarket/search/searchall?searchSubj=${list}">#${list }</a>
                                       </c:forEach>
                                    </c:if>
                                 </div></li>
                           </ul>
                        </div>
                     </div>
                   <div class="product-comments-wrapper">
                        <div class="product-comments">
                           <div id="comment-title" class="title">
                              상품문의 <span class="comments-count"></span>
                           </div>
                           <div class="comments-input-wrapper">
                              <c:if test="${member.member_name ne null}">
                                 <div class="comment-input">
                                    <div class="input-wrapper">
                                       <textarea type="text" id="item_qna_contents" rows="2" placeholder="문의내용을 입력해주세요."></textarea>
                                       <button type="button" class="write-btn" id="replyAddBtn">등록</button>
                                    </div>
                                 </div>
                              </c:if>
                              <input type="hidden" id="itemboard_no" value="${bean.itemDetail.itemboard_no}">
                              <input type="hidden" id="member_no" value="${member.member_no}">
                           </div>
                           <ul id="replies">
                              <li id="repliesDiv">
                           <%-- <div class="comments-wrapper">
                              <div class="comment-item">
                                 <c:forEach var="qnaList" items="${bean.itemQnaList}">
                                    <div class="comment-item-wrapper">
                                       <div class="comment-info-wrapper">
                                          <div class="comment-info-header">
                                             <div class="comment-writer-name">
                                                <a href="">${qnaList.store_name }</a>
                                             </div>
                                          </div>
                                          <div class="comment-content">${qnaList.contents}</div>
                                          <c:if test="${member.email eq qnaList.email }">
                                             <a
                                                href="deleteQnaAction.do?item_qna_no=${qnaList.item_qna_no}&itemboard_no=${bean.itemDetail.itemboard_no}">
                                                <div class="delete-qna">삭제하기</div>
                                             </a>
                                          </c:if>
                                          <div class="split"></div>
                                       </div>
                                    </div>
                                 </c:forEach>
                              </div>
                           </div> --%>
                              </li>
                           </ul>
                           <button id="qnaBtn">더보기</button>
                           <div class='text-center'>
                              <ul id="pagination">

                              </ul>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="seller-content">
                     <div class="product-seller-wrapper">
                        <div class="product-seller">
                           <div class="title">상점정보</div>
                           <div class="product-seller-wrapper">
                              <div class="seller-info">
                                 <div class="seller-profile">
                                    <div class="seller-basic-info">
                                       <a class="seller-name"
                                          href="/fleamarket/product/productlist?store_Name=${bean.storeInfo.store_name}">${bean.storeInfo.store_name }</a>
                                       <div class="seller-count">
                                          <a class="seller-product-count">${bean.storeInfo.itemCount }
                                             개 판매중</a>
                                       </div>
                                    </div>
                                 </div>
                                 <!-- 판매상품 미니 이미지 반복 -->
                                 <div class="seller-products">
                                    <div class="seller-popular-product">
                                       <a> <c:forEach var="itemList"
                                             items="${bean.storeInfo.itemList}" begin="0" end="1"
                                             step="1">
                                             <a
                                                href="/fleamarket/maindetail/detail?itemboard_no=${itemList.itemboard_no}">
                                                <div class="small-product">
                                                   <c:forEach var="img" items="${itemList.imgList }"
                                                      begin="0" end="0">
                                                     	<div class="seller-popular-product">
                                                      <img alt="" src="/fleamarket/resources/product/upload${img.thum_img}">
                                                      </div>
                                                   </c:forEach>
                                                   <div class="product-price">
                                                      <div class="seller-popular-product">
                                                         <span class="bold"> <fmt:formatNumber
                                                               value="${itemList.item_price}" /> <small>원</small>
                                                         </span>
                                                      </div>
                                                   </div>
                                                </div>
                                             </a>
                                          </c:forEach>
                                       </a>
                                    </div>
                                 </div>
                                 <br><br><br><br><br>
                                 <a class="seller-name"
                                       href="/fleamarket/product/productlist?store_Name=${bean.storeInfo.store_name}">
                                       <div class="seller-product-more">
                                       <c:if test="${bean.storeInfo.itemCount > 2}">
                                          <span class="product-count">${bean.storeInfo.itemCount-2}</span>개
                                             상품 더보기
                                       </c:if>
                                       </div>
                                    </a>
                              </div>
                              <div class="product-detail-btns">
                                 <c:choose>
                                    <c:when test="${bean.itemDetail.item_delivery_state == 1 }">
                                       <c:choose>
                                          <c:when test="${member.member_name ne null}">
                                             <button   onclick="location.href = '/fleamarket/safepay/order?item_no=${bean.itemDetail.item_no}'"
                                       class="btn-call" value="${member.member_name}">안심결제</button>
                                          </c:when>
                                          <c:otherwise>
                                             <button
                                             onclick="location.href = '/fleamarket/memmanage/login'"
                                             class="btn-call">안심결제</button>
                                          </c:otherwise>
                                       </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                       <button class="btn-call">판매완료</button>
                                    </c:otherwise>
                                 </c:choose>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div> 
               </div>
            </div>
         </div>
      </div>
   </div>
</body>
</html>