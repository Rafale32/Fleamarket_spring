package com.sp.mainDetail.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mainDetail.domain.FavDTO;
import com.sp.mainDetail.service.MainDetailService;

@RestController
@RequestMapping("/fav")
public class FavController {
	@Inject
	private MainDetailService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody FavDTO fav){
		
		ResponseEntity<String> entity = null;
		try {
			service.addFav(fav);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{fav_no}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("fav_no") Integer fav_no){
		ResponseEntity<String> entity = null;
		try {
			service.removeFav(fav_no);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/all/{itemboard_no}", method=RequestMethod.GET)
	public ResponseEntity<List<FavDTO>> list(
			@PathVariable("itemboard_no") Integer itemboard_no){
		ResponseEntity<List<FavDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listFav(itemboard_no), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
}
