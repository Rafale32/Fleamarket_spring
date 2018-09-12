package com.sp.mainDetail.model;

import java.util.List;

import com.sp.mainDetail.domain.CategoryDTO;
import com.sp.mainDetail.domain.HotItemDTO;
import com.sp.mainDetail.domain.HotListDTO;
import com.sp.mainDetail.domain.ItemDetailDTO;
import com.sp.mainDetail.domain.ItemImgDTO;
import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.domain.RecommendDTO;
import com.sp.mainDetail.domain.StoreInfoDTO;
import com.sp.mainDetail.domain.SubCategoryDTO;

public interface MainDetailDAO {
	
	public List<RecommendDTO>	recommend()throws Exception;
	
	public List<HotItemDTO> hotItemList()throws Exception;
	
	public List<HotListDTO> hotList()throws Exception;
	
	public List<CategoryDTO> categoryList() throws Exception;
	
	public List<SubCategoryDTO> subCategoryList() throws Exception;
	
	public ItemDetailDTO itemDetail(Integer itemboard_no)throws Exception;
	
	public List<ItemImgDTO> itemImgList(Integer itemboard_no)throws Exception;
	
	public StoreInfoDTO storeInfo(Integer itemboard_no)throws Exception;
	
	public List<ItemDetailDTO> storeItemList(Integer store_no, Integer itemboard_no)throws Exception;
	
	public List<ItemQnaDTO> listQna(Integer itemboard_no)throws Exception;
	
	public void insertQna(ItemQnaDTO itemQna)throws Exception;
	
	public ItemQnaDTO storeNoInfo(String name)throws Exception;
	
	public void deleteQna(Integer itemQnaNo)throws Exception;
	
	public List<ItemDetailDTO> categoryItemList(Integer category_no)throws Exception;
	
}
