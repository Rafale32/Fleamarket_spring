package com.sp.mainDetail.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mainDetail.domain.Criteria_jy;
import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.domain.PageMaker_jy;
import com.sp.mainDetail.service.ReplyService;

@RestController
@RequestMapping("/qna")
public class ReplyController {
	@Inject
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ItemQnaDTO qna){
		
		ResponseEntity<String> entity = null;
		try {
			/*qna.setItem_qna_no(service.maxQnaNo(qna.getItemboard_no())+1);
			System.out.println(service.maxQnaNo(qna.getItemboard_no()));
			System.out.println(qna.getItem_qna_no());*/
			service.createQna(qna);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{item_qna_no}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("item_qna_no") Integer item_qna_no,
																			 @RequestBody ItemQnaDTO qna){
		ResponseEntity<String> entity = null;
		try {
			qna.setItem_qna_no(item_qna_no);
			service.updateQna(qna);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{item_qna_no}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("item_qna_no") Integer item_qna_no){
		ResponseEntity<String> entity = null;
		try {
			service.deleteQna(item_qna_no);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/all/{itemboard_no}", method=RequestMethod.GET)
	public ResponseEntity<List<ItemQnaDTO>> list(
			@PathVariable("itemboard_no") Integer itemboard_no){
		ResponseEntity<List<ItemQnaDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listQna(itemboard_no), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//페이징처리
	@RequestMapping(value="/{itemboard_no}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable("itemboard_no") Integer itemboard_no,
			@PathVariable("page") Integer page){
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			Criteria_jy cri = new Criteria_jy();
			cri.setPage(page);
			
			PageMaker_jy pageMaker = new PageMaker_jy();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ItemQnaDTO> list = service.listQnaPage(itemboard_no, cri);
			
			map.put("list", list);
			
			int qnaCount = service.count(itemboard_no);
			pageMaker.setTotalCount(qnaCount);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
