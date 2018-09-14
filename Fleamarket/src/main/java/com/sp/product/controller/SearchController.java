package com.sp.product.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.bean.Bean;
import com.sp.product.domain.ItemDTO;
import com.sp.product.service.ProductService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	public static final int row = 5;
	
	@Inject
	private ProductService service;
	
	@RequestMapping("/searchall")
	public void searchAll(@RequestParam("searchSubj")String subj, Model model)throws Exception{
		Bean bean = new Bean();
		
		List<ItemDTO> itemDTO =  service.searchAll(subj); //itemboard_No, thumImg , itemboard_Local  ,item_Price , itemboard_Title
		
		bean.setItemList(itemDTO);
		
		model.addAttribute("bean", bean);
	}
	
}
