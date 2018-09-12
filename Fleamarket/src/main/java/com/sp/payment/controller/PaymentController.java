package com.sp.payment.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.sp.bean.Bean;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;
import com.sp.payment.service.PaymentService;


@Controller
@RequestMapping("/payment/*")
public class PaymentController {
	
	@Inject
	private PaymentService service;
	
	
	
	//뷰단의 파일 이름 형식은 각각의 상단의 (상위 이름/하단의 메소드 벨류이름) 으로 결정됨 
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void home(Locale locale, Model model) {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		
		model.addAttribute("bean", bean );
		
		System.out.println("들어왔나 확인");
		
		
	}
	
	@RequestMapping(value = "/buy_list_gy", method = RequestMethod.GET)
	public void buyList(Model model,HttpSession session) throws Exception {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		
		
		model.addAttribute("bean", bean );
		System.out.println("옴?");  
		
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listPuerchase(dto2);
		model.addAttribute("list", list);
		
		//return "/payment/buy_list_gy";
		
		
	}
	
	@RequestMapping(value = "/buy_list_gy", method = RequestMethod.POST)
	public void buyset(Model model,HttpSession session,DeliveryDTO_gy dto) throws Exception {
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		// dto2에 다 넣기
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		//이제 바꾸는 것 넣고 서비스 가저온것으로
		service.changDeliverState(dto);
		//다시 뽑기
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listPuerchase(dto2);
		model.addAttribute("list", list);
	}
	
	
	@RequestMapping(value = "/sell_list_gy", method = RequestMethod.GET)
	public void SellList(Model model,HttpSession session) throws Exception {
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		
		
		model.addAttribute("bean", bean );
		System.out.println("옴?");  
		
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listSell(dto2);
		model.addAttribute("list", list);
		
		//return "/payment/buy_list_gy";
		
		
	}
	
	@RequestMapping(value = "/sell_list_gy", method = RequestMethod.POST)
	public void chagesDeriSell(Model model,HttpSession session,DeliveryDTO_gy dto) throws Exception {
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		// dto2에 다 넣기
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		
		//이제 바꾸는 것 넣고 서비스 가저온것으로
		service.changDeliverState2(dto);
		//다시 뽑기
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listSell(dto2);
		model.addAttribute("list", list);
	}
	
	
	//내상점 리뷰보기로 가기
	@RequestMapping(value = "/mystoreReview", method = RequestMethod.GET)
	public void mystoreReview(Model model,HttpSession session) throws Exception{
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		// dto2에 다 넣기
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		
		
		//아이디로 상점 넘버 찾기 이걸로 내상점 리뷰로 가는것이 가능
		
		 MystoreDTO_gy storedto= service.SearchMystore(dto2);
		
		//서비스 만들기 내 상점에 대한 리뷰 쿼리부터 만들것
		 System.out.println("가즈아~~1111");
		 List<MystoreReviewDTO_gy> list = (List<MystoreReviewDTO_gy>) service.MystoreReview(storedto);
		
		 System.out.println(list.get(0).getPay_date() + "페데");
		 
		 
		 model.addAttribute("list", list);
		 
	}
	
	
	
	
	
	
	
/*	@RequestMapping(value = "/img/*", method = RequestMethod.GET)
	public void img(Model model,HttpSession session) throws Exception {
		System.out.println("정말 이쪽으로 옵니까?");
		
	}
*/
}
