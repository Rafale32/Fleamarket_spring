package com.sp.mainDetail.service;

import java.util.List;

import com.sp.mainDetail.domain.CategoryDTO;
import com.sp.mainDetail.domain.HotItemDTO;
import com.sp.mainDetail.domain.HotListDTO;
import com.sp.mainDetail.domain.ItemDetailDTO;
import com.sp.mainDetail.domain.ItemImgDTO;
import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.domain.RecommendDTO;
import com.sp.mainDetail.domain.StoreInfoDTO;


public interface MainDetailService {
	
	public List<RecommendDTO> recommend()throws Exception;
	
	public List<HotItemDTO> hotItemList() throws Exception;
	
	public List<CategoryDTO> categoryList() throws Exception;
	
	public List<ItemImgDTO> itemImgList(Integer itemboard_no)throws Exception;
	
	public ItemDetailDTO itemDetail(Integer itemboard_no)throws Exception;
	
	public List<HotListDTO> hotList()throws Exception;
	
	public StoreInfoDTO storeInfo(Integer itemboard_no) throws Exception;
	
	public List<ItemQnaDTO> itemQnaList(Integer itemboard_no)throws Exception;
	
	public void insertQna(ItemQnaDTO qna)throws Exception;
	
	public void deleteQna(Integer item_qna_no)throws Exception;
	
}
