package com.sp.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemImg;
import com.sp.product.service.AddproductService;
import com.sp.product.service.ProductService;
import com.sp.util.MediaUtils;
import com.sp.util.UploadFileUtils;

@RestController
@RequestMapping("/productajax/*")
public class ProductAjax {
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Inject
	private AddproductService service;
	
	@Inject
	private ProductService pService;
	
	@RequestMapping(value = "/getsubcate", method = RequestMethod.POST)
	public ResponseEntity<List<CateSubDTO>> getSubCate(@RequestParam("category_no") Integer category_No){
		
		ResponseEntity<List<CateSubDTO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.getSubCate(category_No), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST)
	public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{
		
		
		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);//파일 확장자
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new  FileInputStream(uploadPath + fileName);
			
			if(mType != null){//이미지 종류중 하나면  
				headers.setContentType(mType);//미디어타입 클래스로 어떤 이미지 타입인지 가지고옴
			}else{//이미지 종류가 아니면 
				
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//다운로드용으로 사용되는 타입임
				//이 APPLICATION_OCTET_STREAM 마임 타입으로 자동으로 다운로드창 열어줌
		        headers.add("Content-Disposition", "attachment; filename=\""+ 
		                new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");//한글 깨짐 방지를 위함
				
			}
			
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), //FileInputStream 으로 파일을 담아서 바이트 형식으로 엔티티 통해서 보낸다.
	                headers, //보내는데 헤더에는 이미지 타입인지 다른 타입인지 구별 해놨지
	                HttpStatus.CREATED);
          }catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
          }finally{
            in.close();
          }
		//System.out.println("파일이름:"+fileName);
        return entity;
	}
	
	  //이건 글 등록 할때와 수정할때 서버상에만 올린 파일 삭제할때 사용하는것 
	  @RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	  public ResponseEntity<String> deleteFile(String fileName){
	    
	    
	    String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	    
	    MediaType mType = MediaUtils.getMediaType(formatName);
	    
	    if(mType != null){
	      
	      String front = fileName.substring(0,12);
	      String end = fileName.substring(14);
	      new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();//이미지 파일의 섬네일 삭제
	    }
	    
	    new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();//원본 파일 삭제 나 원본이미지 삭제
	    
	    
	    return new ResponseEntity<String>("deleted", HttpStatus.OK);
	  }  
	
	  
	  
	  //이건 글 수정할때 서버와 디비에 까지 올린 그림 하나씩 삭제할때 사용
	  @RequestMapping(value = "oneimgdelete", method = RequestMethod.POST)
	  public void oneImgDelete(ItemImg img)throws Exception{
		  
		  File big = new File(uploadPath+img.getBig_Img());
		  File thimg = new File(uploadPath+img.getThum_Img());
		  big.delete();
		  thimg.delete();
		  
		  pService.oneImgDelete(img);
		  
	  }
}
