package com.sp.memManage.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.activation.CommandMap;
import javax.inject.Inject;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sp.bean.Bean;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.domain.StoreDTO;
import com.sp.memManage.service.MemManageService;


@Controller
@RequestMapping("/memmanage/*")
public class MemManageController {
	
	@Inject
	private MemManageService service;
	
	//로그인
	//뷰단의 파일 이름 형식은 각각의 상단의 (상위 이름/하단의 메소드 벨류이름) 으로 결정됨 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(Model model) {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		
		model.addAttribute("bean", bean );
	}
	//로그인체크
	@RequestMapping(value = "/loginpost" , method = RequestMethod.POST)
	public String loginPOST(MemManageDTO dto , Model model, HttpSession session)throws Exception{
		
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
	//로그아웃
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception{
		
		Object obj = session.getAttribute("member");
		session.removeAttribute("member");
		session.invalidate();
		
		return "redirect:/maindetail/mmain";
	}
	
//	//이메일 중복체크
//	@RequestMapping(value = "/emailcheck", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//	public @ResponseBody String emailcheck(HttpServletResponse response,  @RequestParam("member_email") String member_email, Model model)throws Exception {
//
//		System.out.println("들어오냐");
//		  String msg = service.emailcheck(member_email);
//		  System.out.println(msg);
//		  String responseMsg;
//
//		  if(msg == "T") {
//		        responseMsg = "{\"msg\":\""+"사용가능한 이메일 입니다."+"\"}";
//		  }else {
//		    responseMsg = "{\"msg\":\""+"사용이 불가한 이메일 입니다."+"\"}";
//		  }
//		  System.out.println("들어오냐2222");
//		   URLEncoder.encode(responseMsg , "UTF-8");
//
////			model.addAttribute("msg", service.authenticate(email));
//		   System.out.println("들어오냐3333");
//		  System.out.println(member_email);
//		
//		  return responseMsg;
//		  
//		}
	
	//이메일 중복체크
//	@RequestMapping(value="/emailcheck")
//	@ResponseBody
//	public int emailcheck(CommandMap commandMap, Map<String, Object> map) throws Exception{
//		
//		int checkResult = service.emailcheck(map);
//		
//		return checkResult;
//	}
	
//	@RequestMapping(value="/emailcheck")
//	@ResponseBody
//	public int emailcheck(@RequestParam("member_email") String member_email) throws Exception{
//		
//		int checkResult = service.emailcheck(member_email);
//		return checkResult;
//	}
//	
//	@RequestMapping(value="/emailcheck", method=RequestMethod.POST)
//	public @ResponseBody int emailcheck(@RequestParam("member_email") String member_email) {
//		
//		return service.emailcheck(member_email).size();
//	}
		
	//회원등록 
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(MemManageDTO memManageDTO, Model model) throws Exception {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		
		Bean bean = new Bean();
		
		model.addAttribute("bean", bean );
		
	}
	//회원등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(MemManageDTO memManageDTO, StoreDTO storeDTO, Model model) throws Exception {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();

		
		service.registerMember(memManageDTO);
		service.registerStore(storeDTO);
	//	service.randomStore(storeDTO);
		
		model.addAttribute("bean", bean );
		
		return "redirect:/memmanage/login";
	}
	//회원 정보보기
	@RequestMapping(value ="/detail", method = RequestMethod.GET)
	public void read(@RequestParam("member_email") String member_email, Model model) throws Exception{
		
		Bean bean = new Bean();
		
		model.addAttribute(service.detailMember(member_email));
		
		model.addAttribute("bean", bean);
	}
	//회원 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET) 
	public void updateGET(@RequestParam("member_email") String member_email, Model model) throws Exception{
		
		model.addAttribute(service.detailMember(member_email));
	
	}
	//회원수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(MemManageDTO memManageDTO, Model model) throws Exception{
		 
		service.updateMember(memManageDTO);
		System.out.println(memManageDTO);
		return "redirect:/memmanage/detail?member_email="+memManageDTO.getMember_email();
	}
	//회원 삭제
	@RequestMapping(value ="/delete")
	public void  deletePOST(@RequestParam("member_email") String member_email, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		Bean bean = new Bean();
		
		service.deleteMember(member_email);
		
		rttr.addFlashAttribute("bean", bean);
		
		session.invalidate();
		
		//return "redirect:/maindetail/mmain";
		
		//return "redirect:/memmanage/delete";
	}
	
	
}

