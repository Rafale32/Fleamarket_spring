package com.sp.product.service;

import java.util.List;

import com.sp.bean.Bean;
import com.sp.product.domain.ItemImg;


public interface ProductService {
	
	public void productModifyForm(int itemboard_No, Bean bean)throws Exception;
	
	public void oneImgDelete(ItemImg img)throws Exception;

}
