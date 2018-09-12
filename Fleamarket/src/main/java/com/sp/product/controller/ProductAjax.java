package com.sp.product.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sp.product.domain.CateSubDTO;
import com.sp.product.service.AddproductService;

@RestController
@RequestMapping("/productajax/*")
public class ProductAjax {
	
	@Inject
	private AddproductService service;
	
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
		
		System.out.println(file.getOriginalFilename()+"----파일내임");
		
		return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/displayFile", method = RequestMethod.POST)
	public ResponseEntity<byte[]> displayFile(MultipartFile file)throws Exception{
		
		System.out.println(file.getOriginalFilename()+"----파일내임");
		
		return new ResponseEntity<byte[]>( HttpStatus.CREATED);
	}
	
	
}
