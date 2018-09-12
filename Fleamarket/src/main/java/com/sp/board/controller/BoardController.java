package com.sp.board.controller;

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
		
		service.regist(board);
		
		System.out.println(board.toString());
		
//		model.addAttribute("result", "success");
		rttr.addFlashAttribute("msg","SUCCESS"); 
		
		//return "/board/success";
		return "redirect:/board/list";
	} 
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception{
		System.out.println("show all list..........");
		
		model.addAttribute("list", service.list());
	}
	
	
	
	
	
//	@RequestMapping(value = "/example", method = RequestMethod.GET)
//	public void home(Locale locale, Model model) {
//		Bean bean = new Bean();
//		
//		model.addAttribute("bean", bean );
//		
//	}

}
