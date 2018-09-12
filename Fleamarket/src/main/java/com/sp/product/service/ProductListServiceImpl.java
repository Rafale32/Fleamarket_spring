package com.sp.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.bean.Bean;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.PageModel;
import com.sp.product.model.ProductListDAO;

@Service
public class ProductListServiceImpl implements ProductListService{
	
	public static final int PAGE_SIZE = 4;//페이지당 2개씩 나중에 값늘어나면 5개씩
	
	@Inject
	ProductListDAO dao;

	@Override
	public List<ItemDTO> productListService(String email, String storeName, int requestPage, Bean bean) {
		
	    PageModel pageModel ;
		if(storeName != null){
			
			//상점이름 으로 검색한 전체 갯수
			int totalCount = dao.countItemBoardByStore(storeName);
			//총페이지수 구하기
			int totalPageCount = totalCount / PAGE_SIZE;
			
			//남은 나머지가 있으면 페이지가 하나 더 있어야하니까 
		    if (totalCount % PAGE_SIZE > 0) {
		        totalPageCount++;
		      }
		    
			//표시되는 시작 페이지 구하기      시작페이지 = 현재페이지  - (현재페이지 - 1 ) %5
			int startPage = requestPage -(requestPage - 1) % 5;
			
			//표시되는 끝 페이지
			int endPage = startPage + 4;
			System.out.println("startpage =   " + startPage +"endpage= "+endPage);
			
			//끝페이지가 넘치지 않게 해줘야지
		    if(endPage > totalPageCount) {
		        endPage = totalPageCount;
		      }
			
			//시작글 구하기 : (현재페이지 -1) * 페이지당 글 갯수
		    int startRow = (requestPage-1) * PAGE_SIZE;
		    
			List<ItemDTO> list = dao.productListByStore(storeName, startRow);
			pageModel = new PageModel( requestPage, totalPageCount, startPage, endPage);
			bean.setPageModel(pageModel);
			
			if(list != null){
				ItemDTO item = new ItemDTO();
				item.setStore_Name(list.get(0).getStore_Name());
				System.out.println(item.getStore_Name());
				bean.setItemDTO(item);
			}
			
			return list;
		}else if(email != null){
			//이메일로 검색한 전체 갯수
			int totalCount = dao.countItemBoard(email);
			
			//총페이지수 구하기
			int totalPageCount = totalCount / PAGE_SIZE;
			
			//남은 나머지가 있으면 페이지가 하나 더 있어야하니까 
		    if (totalCount % PAGE_SIZE > 0) {
		        totalPageCount++;
		      }
		    
			//표시되는 시작 페이지 구하기      시작페이지 = 현재페이지  - (현재페이지 - 1 ) %5
			int startPage = requestPage -(requestPage - 1) % 5;
			
			//표시되는 끝 페이지
			int endPage = startPage + 4;
			System.out.println("startpage =   " + startPage +"endpage= "+endPage);
			
			//끝페이지가 넘치지 않게 해줘야지
		    if(endPage > totalPageCount) {
		        endPage = totalPageCount;
		      }
			
			//시작글 구하기 : (현재페이지 -1) * 페이지당 글 갯수
		    int startRow = (requestPage-1) * PAGE_SIZE;
			
			List<ItemDTO> list = dao.productList(email , startRow);
			pageModel = new PageModel( requestPage, totalPageCount, startPage, endPage);
			bean.setPageModel(pageModel);
			
			return list;
		}
	    
		return null;
	}
	
}
