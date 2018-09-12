/*var sel_files = [];

$(document).ready(function() {
	$("#input_imgs").on("change", handleImgsFilesSelect);
});

function handleImgsFilesSelect(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);

	filesArr.forEach(function(f) {
		if (!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}

		sel_files.push(f);

		var reader = new FileReader();
		reader.onload = function(e) {
			var img_html = "<img src=\"" + e.target.result + "\" />";
			$(".imgs_wrap").append(img_html);
		}
		reader.readAsDataURL(f);
	});
}*/



/*var sel_files = [];
var cnt = 0;

$(document).ready(function() {
	$("#imgfiles").on("change", handleImgsFilesSelect);
	
	$(".imgs_wrap").on("click", function() {
		alert("ASdf");
	});
	
	
	$("#subname").on("change", function(e) {
		
		var tmp = $("#subname").val();
		$("#cate").empty();
		
		$.ajax({
			url: "/fleamarket/product/addproductform?catename="+tmp,
			type: "post",
			dataType: "json",
			success: function(data){
				$("#cate").append("<select name='subsubname' id='subsubname'>");
				$.each(data,function(key,value) {
					
				//	$("#subsubname").empty();
				//	alert('key:'+key+', name:'+value.cate);
					$("#subsubname").append( "<option value='"+ value.cate +"'>"+ value.cate +"</option>" );
					
				});
				$("#cate").append("</select>");
			}
		});
		
	});
	
	
});

function handleImgsFilesSelect(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	
	filesArr.forEach(function(f) {
		if (!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}

		sel_files.push(f);

		var reader = new FileReader();
		reader.onload = function(e) {
			var img_html = "<img src=\"" + e.target.result + "\"" +  'id=img'+ cnt + "/>";
			$(".imgs_wrap").append(img_html);
			
			cnt++;
			var img_input = "<input type='file' id='inputimgs"+ cnt +"' name='inputimgs"+cnt+"'/>";
			$("#imgfiles").append(img_input);
			
			//disabled="disabled"
			//var inputName = "inputimgs"+(cnt-1);
			//$("#"+inputName).attr("disabled","disabled");
			
		}
		reader.readAsDataURL(f);
	});
}*/


var sel_files = [];
var cnt = 0;

$(document).ready(function() {
	$("#imgfiles").on("change", handleImgsFilesSelect);
	
/*	$(".imgs_wrap").on("click", function() {
		alert("ASdf");
	});*/
	
	$("#subname").on("change", function(e) {
		
		var tmp = $("#subname").val();//대 카테고리 번호가 넘어옴
		$("#cate").empty();
		
		$.ajax({
			url: "/fleamarket/productajax/getsubcate?category_no="+tmp,
			type: "post",
			dataType: "json",
			success: function(data){
				
				$("#cate").append("<select name='subsubname' id='subsubname'>");
				$.each(data,function(key,value) {
					
				//	$("#subsubname").empty();
					//alert('key:'+key+', name:'+value.cate);
					$("#subsubname").append( "<option value='"+ value.sub_No +"'>"+ value.sub_Title +"</option>" );
					
				});
				$("#cate").append("</select>");
			}
		});
		
	});
});

function handleImgsFilesSelect(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	
	filesArr.forEach(function(f) {
		if (!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}

		sel_files.push(f);

		var reader = new FileReader();
		reader.onload = function(e) {
			var img_html = "<img src=\"" + e.target.result + "\"" +  'id=img'+ cnt + "/>";
			$(".imgs_wrap").append(img_html);
			
			cnt++;
//			var img_input = "<input type='file' id='inputimgs"+ cnt +"' name='inputimgs"+cnt+"'/>";
//			$("#imgfiles").append(img_input);
			
			//disabled="disabled"
			//var inputName = "inputimgs"+(cnt-1);
			//$("#"+inputName).attr("disabled","disabled");
			
		}
		reader.readAsDataURL(f);
	});
}

//아작스로 그림파일 지우고 디비값도 지우기
$(function() {
	
	/*$('.imgs_wrap.btn').on('click', function(e) {
		var a = this.attr('type');
		alert(a);
		return false;
	});*/

	$('body').on('click','.imgs_wrap_now .btn', function(){
		var img = $(this).val();
		var b =img.split('/');
		var big_Img , thum_Img, index;
		var cnt=0;
		for (let tmp of b) {
			if(cnt==0){
				thum_Img=tmp;
			}
			if(cnt==1){
				big_Img=tmp;
			}
			if(cnt==2){
				index=tmp;
			}
			cnt++;
		}
		
		//alert(big_Img+":::::::::"+thum_Img);
		
		if(confirm("이미지를 삭제 하시겠습니까?")){
			$.ajax({
				url: "/fleamarket/product/imgdelete?big_Img="+big_Img+"&thum_Img="+thum_Img,
				type: "post",
				success: function(){
					$(".img"+index).remove();
					$("#btn"+index).remove();
				}
			});
		}
		
		//기본이벤트 취소
		return false;
	});
})


//이미지 추가시 파일 서버와 디비에 업데이트
$(function() {
	$("#inputimgs").change( function(event) {
		alert("asdf");
		
		event.preventDefault();
		
		
		//var files = event.originalEvent.dataTransfer.files;
		//var file = files[0];

		var formData = new FormData();
		
		formData.append("file", $(".file_tag")[0].files[0]);	
		
		
		$.ajax({
			  url: '/fleamarket/productajax/uploadAjax',
			  data: formData,
			  dataType:'text',
			  processData: false,
			  contentType: false,
			  type: 'POST',
			  success: function(data){
				  
/*				  var fileInfo = getFileInfo(data);
				  alert(fileInfo);
				  
				  var html = template(fileInfo);
				  
				  $(".uploadedList").append(html);*/
				  var str ="";
				  
				  if(checkImageType(data)){//getImageLink 메소드에서 썸네일이아닌넘의 파일이름 처리를 해줌 
					  str ="<div><a href=displayFile?fileName="+getImageLink(data)+">"
							  +"<img src='/fleamarket/productajax/displayFile?fileName="+data+"'/>"
							  +"</a><small data-src="+data+">X</small></div>";
				  }else{
					  str = "<div><a href='displayFile?fileName="+data+"'>" 
							  + getOriginalName(data)+"</a>"
							  +"<small data-src="+data+">X</small></div></div>";
				  }
				  
				  $(".uploadedList").append(str);
			  }
		});	
		
	});
});
