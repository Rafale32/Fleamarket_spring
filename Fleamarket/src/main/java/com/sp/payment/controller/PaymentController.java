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
	
	
	
	//酉곕떒�쓽 �뙆�씪 �씠由� �삎�떇�� 媛곴컖�쓽 �긽�떒�쓽 (�긽�쐞 �씠由�/�븯�떒�쓽 硫붿냼�뱶 踰⑤쪟�씠由�) �쑝濡� 寃곗젙�맖 
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void home(Locale locale, Model model) {
		//而⑦듃濡ㅻ윭�뿉�꽌 鍮� �뙆�씪�뿉 �븘�슂�븳 媛앹껜 �떞���썑 紐⑤뜽�뿉 鍮덉쓣 �떞�븘�꽌 酉곗뿉�꽌 �궗�슜
		Bean bean = new Bean();
		
		model.addAttribute("bean", bean );
		
		System.out.println("�뱾�뼱�솕�굹 �솗�씤");
		
		
	}
	
	@RequestMapping(value = "/buy_list_gy", method = RequestMethod.GET)
	public void buyList(Model model,HttpSession session, Criteria2 cri) throws Exception {
		//而⑦듃濡ㅻ윭�뿉�꽌 鍮� �뙆�씪�뿉 �븘�슂�븳 媛앹껜 �떞���썑 紐⑤뜽�뿉 鍮덉쓣 �떞�븘�꽌 酉곗뿉�꽌 �궗�슜
		Bean bean = new Bean();
		
		
		model.addAttribute("bean", bean );
		System.out.println("�샂?");  
		
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listPuerchase(dto2,cri);
		model.addAttribute("list", list);
		
		//return "/payment/buy_list_gy";
		
		//�럹�씠吏�
		
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
         //pagemaker.setTotalCount(131);
         //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 
		 int a = service.puerchasecounting(dto2);
		 System.out.println(a + " : �뿉�씠 媛�");
		 
         pagemaker.setTotalCount(a);
         model.addAttribute("pageMaker",pagemaker);

		
		
	}
	
	@RequestMapping(value = "/buy_list_gy", method = RequestMethod.POST)
	public void buyset(Model model,HttpSession session,DeliveryDTO_gy dto,Criteria2 cri,PuerchaseDTO_gy pdto) throws Exception {
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		// dto2�뿉 �떎 �꽔湲�
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		
		//�씠�젣 諛붽씀�뒗 寃� �꽔怨� �꽌鍮꾩뒪 媛����삩寃껋쑝濡�
		service.changDeliverState(dto);
		// �뿬湲곕떎媛� �긽���렪�뿉寃� �븣由쇱쓣 蹂대궡�뒗 �꽌鍮꾩뒪媛� �뱾�뼱媛��빞 �븯寃좊꽕...�씈...
		System.out.println(pdto.getItem_no() + " pdto�븘�꽆");
		//
		pdto.setInform_contents(4);
		service.registerPerchaseAlram(pdto);
		
		
		//�떎�떆 戮묎린
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listPuerchase(dto2,cri);
		model.addAttribute("list", list);
		
		//�럹�씠吏�
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
        //pagemaker.setTotalCount(131);
        //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 int a = service.puerchasecounting(dto2);
		 System.out.println(a + " : �뿉�씠 媛�");
        pagemaker.setTotalCount(a);
        model.addAttribute("pageMaker",pagemaker);
	}
	
	
	@RequestMapping(value = "/sell_list_gy", method = RequestMethod.GET)
	public void SellList(Model model,HttpSession session,Criteria2 cri) throws Exception {
		//而⑦듃濡ㅻ윭�뿉�꽌 鍮� �뙆�씪�뿉 �븘�슂�븳 媛앹껜 �떞���썑 紐⑤뜽�뿉 鍮덉쓣 �떞�븘�꽌 酉곗뿉�꽌 �궗�슜
		Bean bean = new Bean();
		
		
		model.addAttribute("bean", bean );
		System.out.println("�샂?");  
		
		
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		MemManageDTO dto = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto.getMember_email();
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listSell(dto2,cri);
		model.addAttribute("list", list);
		
		//return "/payment/buy_list_gy";
		
		//�럹�씠吏�
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
		 //pagemaker.setTotalCount(131);
		 //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 int a = service.sellListcounting(dto2);
		 System.out.println(a + " : �뿉�씠 媛�");
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
		
		
	}
	
	@RequestMapping(value = "/sell_list_gy", method = RequestMethod.POST)
	public void chagesDeriSell(Model model,HttpSession session,DeliveryDTO_gy dto, Criteria2 cri,PuerchaseDTO_gy pdto) throws Exception {
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		// dto2�뿉 �떎 �꽔湲�
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		
		//�씠�젣 諛붽씀�뒗 寃� �꽔怨� �꽌鍮꾩뒪 媛����삩寃껋쑝濡�
		service.changDeliverState2(dto);
		//�떎�떆 戮묎린
		dto2.setMember_email(loginEmail);
		List<PuerchaseDTO_gy> list	= service.listSell(dto2,cri);
		model.addAttribute("list", list);
		
		
		
		//�븣由쇨� 異붽�遺�遺�
		System.out.println(pdto.getItemboard_no() + " pdto�븘�꽆");
		System.out.println(pdto.getItem_no() + " pdto�븘�꽆");
		//
		pdto.setInform_contents(3);
		service.registerPerchaseAlram(pdto);
		
		
		//�럹�씠吏�
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
       //pagemaker.setTotalCount(131);
       //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 int a = service.sellListcounting(dto2);
		 System.out.println(a + " : �뿉�씠 媛�");
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
	}
	
	
	//�궡�긽�젏 由щ럭蹂닿린濡� 媛�湲�
	@RequestMapping(value = "/mystoreReview", method = RequestMethod.GET)
	public void mystoreReview(Model model,HttpSession session,Criteria2 cri) throws Exception{
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
		// dto2�뿉 �떎 �꽔湲�
		MemManageDTO dto0 = (MemManageDTO) session.getAttribute("member");
		String loginEmail = dto0.getMember_email();
		dto2.setMember_email(loginEmail);
		
		
		//�븘�씠�뵒濡� �긽�젏 �꽆踰� 李얘린 �씠嫄몃줈 �궡�긽�젏 由щ럭濡� 媛��뒗寃껋씠 媛��뒫
		
		 MystoreDTO_gy storedto= service.SearchMystore(dto2);
		
		//�꽌鍮꾩뒪 留뚮뱾湲� �궡 �긽�젏�뿉 ���븳 由щ럭 荑쇰━遺��꽣 留뚮뱾寃�
		 System.out.println("媛�利덉븘~~1111");
		 List<MystoreReviewDTO_gy> list = (List<MystoreReviewDTO_gy>) service.MystoreReview(storedto,cri);
		
		 System.out.println(list.get(0).getPay_date() + "�럹�뜲");
		 
		 
		 model.addAttribute("list2", list);
		 
			//�럹�씠吏�
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
       //pagemaker.setTotalCount(131);
       //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 int a = service.mystoreReviewCounting(storedto);
		 System.out.println(a + " : �뿉�씠 媛�");
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
		 
	}
	
	
	@RequestMapping(value = "/purchasestoreReview2", method = RequestMethod.GET)
	public void purchasestoreReview2(Model model,HttpSession session,Criteria2 cri,@RequestParam("store_no") int storeno) throws Exception{
		DeliveryDTO_gy dto2 = new DeliveryDTO_gy();
	
		//�뒪�넗�뼱 �꽆踰�
		
		System.out.println(storeno +" : �뒪�넗�뼱 �꽆 ");
		
		//�븘�씠�뵒濡� �긽�젏 �꽆踰� 李얘린 �씠嫄몃줈 �궡�긽�젏 由щ럭濡� 媛��뒗寃껋씠 媛��뒫
		
		 MystoreDTO_gy storedto = new MystoreDTO_gy();
		 storedto.setStore_No(storeno);
		
		//�꽌鍮꾩뒪 留뚮뱾湲� �궡 �긽�젏�뿉 ���븳 由щ럭 荑쇰━遺��꽣 留뚮뱾寃�
		 System.out.println("媛�利덉븘~~@@");
		 
		 List<MystoreReviewDTO_gy> list = (List<MystoreReviewDTO_gy>) service.MystoreReview(storedto,cri);
		
		 System.out.println(list.get(0).getPay_date() + "�럹�뜲");
		 
		 
		 model.addAttribute("list2", list);
		 
			//�럹�씠吏�
		 PageMaker pagemaker = new PageMaker();
		 pagemaker.setCri(cri);
       //pagemaker.setTotalCount(131);
       //�뿬湲곌� 以묒슂 service.puerchasecounting(dto2)
		 int a = service.mystoreReviewCounting(storedto);
		 System.out.println(a + " : �뿉�씠 媛�");
       pagemaker.setTotalCount(a);
       model.addAttribute("pageMaker",pagemaker);
       

	}
	
	
	//�빐�옄
	
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
		 System.out.println(a + " : �뿉�씠 媛�");
		 
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
		 System.out.println(a + " : �뿉�씠 媛�");
		 
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
