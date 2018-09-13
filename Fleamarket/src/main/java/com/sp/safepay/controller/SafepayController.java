package com.sp.safepay.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.bean.Bean;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;
import com.sp.safepay.service.SafepayService;


@Controller
@RequestMapping("/safepay/*")
public class SafepayController {
  
  @Inject
  private SafepayService service;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public void orderGET(@RequestParam("item_no") int item_no,HttpSession session, Locale locale, Model model) throws Exception {
	  
	  
	  System.out.println("orderGET");
		Bean bean = new Bean();
		//test user
//		bean.setMemManageDTO(service.selectMember("user00@user.com"));
		Object obj = session.getAttribute("member");
    MemManageDTO member = (MemManageDTO) obj;
    bean.setMemManageDTO(service.selectMember(member.getMember_email()));

		// 상품번호
		bean.setItemDTO(service.selectItem(item_no));
		
    // 주문번호
		OorderDTO oorderDTO = new OorderDTO();
		oorderDTO.setOorder_no(service.selectOrderNo());
		bean.setOorderDTO(oorderDTO);

		model.addAttribute("bean", bean );
		
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String orderPOST(
	    ItemDTO itemDTO,
	    OorderDTO oorderDTO,
	    PaymentDTO paymentDTO,
	    DeliveryDTO deliveryDTO,
	    Locale locale, Model model,
	    HttpServletRequest request)throws Exception {
	  System.out.println("orderPOST"); 
    request.setCharacterEncoding("UTF8");
	    // 주문정보입력
	    System.out.println("*주문정보*");
	    System.out.println("주문번호 : " + oorderDTO.getOorder_no());
	    System.out.println("회원번호 : " + oorderDTO.getMember_no());
      System.out.println("상품번호 : " + oorderDTO.getItem_no());
	    System.out.println("주문날짜 : " + oorderDTO.getOorder_date());
	    
	    service.insertOrder(oorderDTO);

	    // 결제정보입력
	    System.out.println("*결제정보*");
	    System.out.println("결제번호 : " + paymentDTO.getPay_no());
	    System.out.println("결제가격 : " + paymentDTO.getPay_price());
	    System.out.println("소모포인트 : " + paymentDTO.getPay_usepoint());
	    System.out.println("결제날짜 : " + paymentDTO.getPay_date());
	    System.out.println("주문번호 : " + paymentDTO.getOorder_no());
	    
	    service.insertPayment(paymentDTO);

	    // 배송정보입력
	    System.out.println("*배송정보*");
	    System.out.println("배송번호 : " + deliveryDTO.getDelivery_no());
	    System.out.println("수 령 인 : " + deliveryDTO.getDelivery_name());
	    System.out.println("연 락 처 : " + deliveryDTO.getDelivery_ph());
	    System.out.println("주    소 : " + deliveryDTO.getDelivery_address());
	    System.out.println("상세주소 : " + deliveryDTO.getDelivery_address2());
	    System.out.println("요청사항 : " + deliveryDTO.getDelivery_contents());
	    System.out.println("주문번호 : " + deliveryDTO.getOorder_no());
	    
	    service.insertDelivery(deliveryDTO);
	    
	    // 상품 배송진행상태 수정
	    System.out.println("*상품 배송진행상태 수정*");
	    service.updateItemDeliveryState(oorderDTO.getItem_no());

	    // 멤버 포인트 소모 및 적립 수정
	    System.out.println("*회원 포인트 소모 및 적립 수정");
	    service.updateMemberPoint(oorderDTO.getMember_no());
    

	  
	  
//	  model.addAttribute("bean", bean );
	  return "redirect:/safepay/order_detail";
	}
	
	
	
	
	
	@RequestMapping(value = "/order_detail", method = RequestMethod.GET)
	public void order_detail(Locale locale, Model model) {
	  Bean bean = new Bean();
	  
	  model.addAttribute("bean", bean );
	  
	}

}
