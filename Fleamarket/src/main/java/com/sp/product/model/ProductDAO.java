package com.sp.product.model;

import java.util.List;

import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.ItemImg;

public interface ProductDAO {
	
	public ItemDTO itemNboardNtag(int itemboard_No)throws Exception;
	
	public List<CateSubDTO> getSubCate(int category_No)throws Exception;
	
	public List<ItemImg> getImgList(int itemboard_No)throws Exception;
	
	public void oneImgDelete(ItemImg img)throws Exception;
	
	public void itemModify(ItemDTO itemDTO)throws Exception;
	
	public void itemBoardModify(ItemDTO itemDTO)throws Exception;
	
	public void tagModify(ItemDTO itemDTO)throws Exception;
	
	public List<ItemDTO> searchAll(String subj, int startRow, int rowSize)throws Exception;
	
	public String getOneImg(int itemboard_No)throws Exception;
}
