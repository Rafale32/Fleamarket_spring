package com.sp.product.service;

import java.util.List;

import com.sp.bean.Bean;
import com.sp.product.domain.ItemDTO;

public interface ProductListService {
	
	public List<ItemDTO> productListService(String email, String storeName, int requestPage , Bean bean);
	
}
