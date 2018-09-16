package com.sp.product.service;

import java.util.List;

import com.sp.product.domain.CateDTO;
import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemDTO;

public interface AddproductService {
	
	public List<CateDTO> getCateDTO();
	
	public List<CateSubDTO> getSubCate(Integer category_No);
	
	public void addProduct(ItemDTO itemDTO);
	
	
}
