package com.sp.product.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.bean.Bean;
import com.sp.product.domain.ItemDTO;
import com.sp.product.service.ProductService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
   public static final int rowSize = 12; //한번에 몇개씩로우 가지고 올건지
   
   public static int startRow = 0;//로우가 시작하는 시작 로우값 인데 일부러 스테틱으로 해놨음  
   //아작스 처리 할때 시작 로우가 5이면 세션값 초기화 해서 사용해야 되기 때문에 이렇게 해둠
   
   @Inject
   private ProductService service;
   
   @RequestMapping(value="/searchall", method = RequestMethod.POST)
   public void searchAll(@RequestParam("searchSubj")String subj, Model model)throws Exception{
      //int startRow = 0 ; //시작 로우
      //int rowSize = 6 ;
      startRow = 0;
      Bean bean = new Bean();
      
      List<ItemDTO> itemDTO =  service.searchAll(subj, startRow, rowSize); //itemboard_No, thumImg , itemboard_Local  ,item_Price , itemboard_Title
      
      bean.setItemList(itemDTO);
      
      bean.setSearchSubj(subj);
      
      model.addAttribute("bean", bean);
      
      startRow = rowSize; 
      
      
   }
   
   @RequestMapping(value="/searchall", method = RequestMethod.GET)
   public void searchAllGet(@RequestParam("searchSubj")String subj, Model model)throws Exception{
      //int startRow = 0 ; //시작 로우
      //int rowSize = 6 ;
      startRow = 0;
      Bean bean = new Bean();
      
      List<ItemDTO> itemDTO =  service.searchAll(subj, startRow, rowSize); //itemboard_No, thumImg , itemboard_Local  ,item_Price , itemboard_Title
      
      bean.setItemList(itemDTO);
      
      bean.setSearchSubj(subj);
      
      model.addAttribute("bean", bean);
      
      startRow = rowSize; 
      
      
   }
   
   
   
   
   
}
