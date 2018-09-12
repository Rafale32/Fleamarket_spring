package com.sp.memManage.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sp.bean.Bean;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.service.MemManageService;


@Controller
@RequestMapping("/memmanage/*")
public class MemManageController {
	
	@Inject
	private MemManageService service;
	
	//뷰단의 파일 이름 형식은 각각의 상단의 (상위 이름/하단의 메소드 벨류이름) 으로 결정됨 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(Model model) {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		
		
		
		model.addAttribute("bean", bean );
		
	}
	
	@RequestMapping(value = "/loginpost" , method = RequestMethod.POST)
	public String loginPost(MemManageDTO dto , Model model, HttpSession session)throws Exception{
		
		MemManageDTO memManageDTO  = service.checkLogin(dto);
		
/*		if(member != null){
			return "redirect:/maindetail/mmain";
		}else{
			return "redirect:/memmanage/login";
		}*/
		
		if(memManageDTO == null){ return "redirect:/memmanage/login";	}
		
		model.addAttribute("memManageDTO", memManageDTO);
		
		return "redirect:/maindetail/mmain";
	}
	
	
	
	
	
	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public void joinForm(Model model) {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		
		model.addAttribute("bean", bean );
		
	}

}
