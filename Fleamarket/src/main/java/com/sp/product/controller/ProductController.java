package com.sp.product.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.bean.Bean;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.product.service.AddproductService;
import com.sp.product.service.ProductListService;


@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Inject
	private ProductListService service;
	
	@Inject
	private AddproductService addService;
	
	//뷰단의 파일 이름 형식은 각각의 상단의 (상위 이름/하단의 메소드 벨류이름) 으로 결정됨 
	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public void productList(Model model, HttpServletRequest request, HttpSession session){
		
		/*@RequestParam("store_name") String storeName
		@RequestParam("pageNum") Integer pageNum*/
		//컨트롤러에서 빈 파일에 필요한 객체 담은후 모델에 빈을 담아서 뷰에서 사용
		Bean bean = new Bean();
		
		/*		Bean requestBean = (Bean)request.getAttribute("requestBean");
		Bean bean = null;
		
		if(requestBean == null){
			System.out.println("빈이 생성됨");
			requestBean = new Bean();
			bean = requestBean;
			request.setAttribute("requestBean", requestBean);
		}else{
			bean = requestBean;
		}*/
		
		
/*		MemManageDTO mmDTO = (MemManageDTO)session.getAttribute("member");
		
		if(pageNum == null){
			pageNum = 1;
		}
		
		int requestPage = pageNum;*/
		String storeName =  request.getParameter("store_name");
		
		
		MemManageDTO mmDTO = (MemManageDTO)session.getAttribute("member");
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null){
			pageNum = "1";
		}
		
		int requestPage = Integer.parseInt(pageNum);
		
		List<ItemDTO> resultList;
		
		if(mmDTO == null){
			resultList = service.productListService(null, storeName,requestPage , bean);
		}else{
			resultList = service.productListService(mmDTO.getMember_email(), storeName,requestPage , bean);
		}
		
		//이미지 경로는 이렇게 전체 리얼패스를 쓰는게 아니라 프로젝트 상의 경로로 써야함  /Fleamarket/productimg/${tmp2.thum_Img } 이런식으로
/*		String realPath = request.getRealPath("/productimg");
		for(ItemDTO tmp : resultList){
			for(ItemImg tmp2 : tmp.getItemImgList()){
				tmp2.setRealThumImg(realPath+"\\"+tmp2.getThum_Img());
			}
		}*/
		
		bean.setItemList(resultList);
		
		model.addAttribute("bean", bean );
		
	}
	
	@RequestMapping( value = "addproductform", method = RequestMethod.GET)//물품 추가 폼 페이지 가는부분 대 카테로리만 필요
	public void addProductFrom(Model model){
		Bean bean = new Bean();
		
		bean.setCateList(addService.getCateDTO());
		
		model.addAttribute(bean);
	}

}
