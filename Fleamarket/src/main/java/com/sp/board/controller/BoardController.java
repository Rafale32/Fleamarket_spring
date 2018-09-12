package com.sp.board.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sp.bean.Bean;
import com.sp.board.domain.BoardDTO;
import com.sp.board.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public void registerGET(BoardDTO board, Model model)throws Exception{
		System.out.println("register get..........");
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public String registPOST(BoardDTO board, Model model, RedirectAttributes rttr)throws Exception{
		System.out.println("regist post..........");
		System.out.println(board.toString());
//		service.regist(board);
		//model.addAttribute("result", "success");
		
		rttr.addFlashAttribute("msg","SUCCESS"); //由� �떎�씠�젆�듃�떆 RedirectAttributes.addFlashAttribute() �씠�슜�븯�뿬  �뼱�듃由щ럭�듃 異붽��븯硫� 由щ떎�씠�젆�듃 
		//�븯�뜑�씪�씪�룄 由щ떎�젆 �떆�젏�뿉 �븳踰덈쭔 �궗�슜�븷 媛믪쓣 URL �뿉 �끂異쒗븯吏��븡怨� �떎�쓬 �럹�씠吏��뿉 �쟾�넚�쓣 �븷 �닔媛��엳�떎. 
		
		return "/board/success";
	}
	
	
	
//	@RequestMapping(value = "/example", method = RequestMethod.GET)
//	public void home(Locale locale, Model model) {
//		Bean bean = new Bean();
//		
//		model.addAttribute("bean", bean );
//		
//	}

}
