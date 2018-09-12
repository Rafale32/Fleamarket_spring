package com.sp.product.model;

import java.util.List;

import com.sp.product.domain.CateDTO;
import com.sp.product.domain.CateSubDTO;

public interface AddproductDAO {
	
	public List<CateDTO> getCateDTO();
	
	public List<CateSubDTO> getSubCate(Integer category_No);
	
}
