package com.sp.product.model;

import java.util.List;

import com.sp.product.domain.CateDTO;
import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.ItemImg;

public interface AddproductDAO {
	
	public List<CateDTO> getCateDTO();
	
	public List<CateSubDTO> getSubCate(Integer category_No);
	
	public void insertItem(ItemDTO itemDTO);
	
	public void insertItemBoard(ItemDTO itemDTO);
	
	public void insertImgs(ItemImg img);
	
	public void insertTags(String tag);
	
}
