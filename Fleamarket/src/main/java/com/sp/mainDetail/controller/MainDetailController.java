package com.sp.mainDetail.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.bean.Bean;
import com.sp.mainDetail.service.MainDetailService;

@Controller
@RequestMapping("/maindetail/*")
public class MainDetailController {
	
	@Inject
	private MainDetailService service;
	
	//뷰단의 파일 이름 형식은 각각의 상단의 (상위 이름/하단의 메소드 벨류이름) 으로 결정됨 
	@RequestMapping(value = "/mmain", method = RequestMethod.GET)
	public void mmain(Locale locale, Model model) throws Exception {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		bean.setRecommend(service.recommend());
		bean.setHotList(service.hotList());
		
		model.addAttribute("bean", bean );
		
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public void detail(@RequestParam("itemboard_no") Integer itemboard_no, Model model)throws Exception{
		Bean bean = new Bean();
		
		bean.setItemDetail(service.itemDetail(itemboard_no));
		bean.setItemImgList(service.itemImgList(itemboard_no));
		
		model.addAttribute("bean",bean);
		
		System.out.println(bean.getItemDetail().getItemboard_title());
	}
	
}
