package com.sp.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sp.board.domain.BoardDTO;
import com.sp.board.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public void registerGET(BoardDTO board, Model model)throws Exception{
		System.out.println();
		System.out.println("register get..........");
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public String registPOST(BoardDTO board, Model model, RedirectAttributes rttr)throws Exception{
		System.out.println();
		System.out.println("regist post..........");
		System.out.println(board.toString());
		
		service.regist(board);
		rttr.addFlashAttribute("msg","SUCCESS"); 
		
		return "redirect:/board/noList";
	} 
	
	@RequestMapping(value = "/noList", method = RequestMethod.GET)
	public void noList(Model model) throws Exception{
		System.out.println();
		System.out.println("notice list..........");
		
		model.addAttribute("list", service.noList());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("notice_no") int notice_no, Model model) throws Exception{
		System.out.println();
		System.out.println("review move............");
		
		model.addAttribute(service.read(notice_no));
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("notice_no") int notice_no, RedirectAttributes rttr) throws Exception{
		System.out.println();
		System.out.println("remove..................");
		
		service.remove(notice_no);
		rttr.addFlashAttribute("msg","SUCCESS"); 
		
		return "redirect:/board/noList";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int notice_no, Model model)throws Exception{
		System.out.println();
		System.out.println("modify GET.............");
		model.addAttribute(service.read(notice_no));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardDTO board, RedirectAttributes attr)throws Exception{
		System.out.println();
		System.out.println("modify post..........");
		
		service.modify(board);
		
		attr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/noList";
	}
	
	
//	@RequestMapping(value = "/example", method = RequestMethod.GET)
//	public void home(Locale locale, Model model) {
//		Bean bean = new Bean();
//		
//		model.addAttribute("bean", bean );
//		
//	}

}
