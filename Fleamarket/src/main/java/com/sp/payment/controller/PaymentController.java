package com.sp.payment.controller;

import java.awt.Desktop;
import java.net.URI;
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
import com.sp.payment.domain.Criteria2;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PageMaker;
import com.sp.payment.domain.PuerchaseDTO_gy;
import com.sp.payment.service.PaymentService;


@Controller
@RequestMapping("/payment/*")
public class PaymentController {
	
	@Inject
	private PaymentService service;
	
	
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void home(Locale locale, Model model) {
	
		Bean bean = new Bean();
		
		model.addAttribute("bean", bean );
	
		
		
	}
	
	@RequestMapping(value = "/buy_list_gy", method = RequestMethod.GET)
	public void buyList(Model model,HttpSession session, Criteria2 cri) throws Exception {
		
		Bean bean = new Bean();
		
		
		model.addAttribute("bean", bean );

		
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listPuerchase(dto2,cri);
		model.addAttribute("list", list);
		
		//return "/payment/buy_list_gy";
		
		
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
         //pagemaker.setTotalCount(131);
       
		 
		 int a = service.puerchasecounting(dto2);

		 
         pagemaker.setTotalCount(a);
         model.addAttribute("pageMaker",pagemaker);

		
		
	}
	
	@RequestMapping(value = "/buy_list_gy", method = RequestMethod.POST)
	public void buyset(Model model,HttpSession session,DeliveryDTO_gy dto,Criteria2 cri,PuerchaseDTO_gy pdto) throws Exception {
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
	
		service.changDeliverState(dto);
		pdto.setInform_contents(4);
		service.registerPerchaseAlram(pdto);
		
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listPuerchase(dto2,cri);
		model.addAttribute("list", list);
		
	
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
        //pagemaker.setTotalCount(131);
      
		 int a = service.puerchasecounting(dto2);
        pagemaker.setTotalCount(a);
        model.addAttribute("pageMaker",pagemaker);
	}
	
	
	@RequestMapping(value = "/sell_list_gy", method = RequestMethod.GET)
	public void SellList(Model model,HttpSession session,Criteria2 cri) throws Exception {
		Bean bean = new Bean();
		
		
		model.addAttribute("bean", bean );
		
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listSell(dto2,cri);
		model.addAttribute("list", list);
		
		//return "/payment/buy_list_gy";
		
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
		 int a = service.sellListcounting(dto2);
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
		
		
	}
	
	@RequestMapping(value = "/sell_list_gy", method = RequestMethod.POST)
	public void chagesDeriSell(Model model,HttpSession session,DeliveryDTO_gy dto, Criteria2 cri,PuerchaseDTO_gy pdto) throws Exception {
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		
		service.changDeliverState2(dto);
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listSell(dto2,cri);
		model.addAttribute("list", list);
		
		
		
		pdto.setInform_contents(3);
		service.registerPerchaseAlram(pdto);
		
		
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
       //pagemaker.setTotalCount(131);
		 int a = service.sellListcounting(dto2);
		 System.out.println(a + " : �뿉�씠 媛�");
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
	}
	
	
	
	
	//�궡�긽�젏 由щ럭蹂닿린濡� 媛�湲�
	@RequestMapping(value = "/mystoreReview", method = RequestMethod.GET)
	public void mystoreReview(Model model,HttpSession session,Criteria2 cri) throws Exception{
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		
		
		
		 MystoreDTO_gy storedto= service.SearchMystore(dto2);
		
		 List<MystoreReviewDTO_gy> list = (List<MystoreReviewDTO_gy>) service.MystoreReview(storedto,cri);
		
		 
		 model.addAttribute("list2", list);
		 
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
       //pagemaker.setTotalCount(131);
		 int a = service.mystoreReviewCounting(storedto);
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
		 
	}
	
	@RequestMapping(value = "/pstoreReview", method = RequestMethod.GET)
	public void pstoreReview(Model model,HttpSession session,Criteria2 cri,@RequestParam("store_Name") String storename) throws Exception{
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
	
		
		
		 MystoreDTO_gy storedto = new MystoreDTO_gy();
		 storedto.setStore_Name(storename);
		
		 
		 List<MystoreReviewDTO_gy> list = (List<MystoreReviewDTO_gy>) service.MystoreReview(storedto,cri);
		
		 
		 
		 model.addAttribute("list2", list);
		 
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
		 int a = service.mystoreReviewCounting(storedto);
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
       

	}
	
	@RequestMapping(value = "/purchasestoreReview2", method = RequestMethod.GET)
	public void purchasestoreReview2(Model model,HttpSession session,Criteria2 cri,@RequestParam("store_name") String storename) throws Exception{
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
	
		
		
		 MystoreDTO_gy storedto = new MystoreDTO_gy();
		 storedto.setStore_Name(storename);
		
		 
		 List<MystoreReviewDTO_gy> list = (List<MystoreReviewDTO_gy>) service.MystoreReview(storedto,cri);
		
		 
		 
		 model.addAttribute("list2", list);
		 
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
		 int a = service.mystoreReviewCounting(storedto);
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
       

	}
	
	
	
	@RequestMapping(value = "/tempalram", method = RequestMethod.GET)
	public void tempalram(Model model,HttpSession session,Criteria2 cri) throws Exception{
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listPuerchase(dto2,cri);
		model.addAttribute("list", list);
		//return "/payment/buy_list_gy";
		System.out.println(list.get(0).toString());
		//�럹�씠吏�
		
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
         //pagemaker.setTotalCount(131);
         //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 
		 int a = service.puerchasecounting(dto2);
		 
         pagemaker.setTotalCount(a);
         model.addAttribute("pageMaker",pagemaker);
		
	}
	
	
	@RequestMapping(value = "/favoritpage", method = RequestMethod.GET)
	public void favoritpage(Model model,HttpSession session, Criteria2 cri) throws Exception {
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		
		
		List<PuerchaseDTO_gy> list	= service.listFavorit(dto2,cri);
		model.addAttribute("list", list);
		
		//return "/payment/buy_list_gy";
		
		//�럹�씠吏�
		
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
         //pagemaker.setTotalCount(131);
         //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 
		 int a = service.puerchasecounting(dto2);
		 
         pagemaker.setTotalCount(a);
         model.addAttribute("pageMaker",pagemaker);

		
		
	}
	
	@RequestMapping(value = "/favoritpage", method = RequestMethod.POST)
	public void favoritdeletepage(Model model,HttpSession session, Criteria2 cri,PuerchaseDTO_gy pdto) throws Exception {
		
		System.out.println(pdto.getItemboard_no() + " itemboard_no");
		
		service.deletfavorit(pdto);
		
		
	}
		
		
	
	
	
	
/*	@RequestMapping(value = "/img/*", method = RequestMethod.GET)
	public void img(Model model,HttpSession session) throws Exception {
		System.out.println("�젙留� �씠履쎌쑝濡� �샃�땲源�?");
		
	}
*/
}
