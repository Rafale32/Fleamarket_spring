package com.sp.product.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.sp.bean.Bean;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.ItemImg;
import com.sp.product.model.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductDAO dao;

	@Override
	public void productModifyForm(int itemboard_No, Bean bean) throws Exception {
		
		ItemDTO dto = dao.itemNboardNtag(itemboard_No);
		dto.setItemImgList(dao.getImgList(itemboard_No));
		bean.setItemDTO(dto);
		bean.setSubCate(dao.getSubCate(dto.getCategory_No()));
		
		
		bean.getItemDTO().setCategory_No(bean.getSubCate().get(0).getCategory_No());
		System.out.println(dto.getItem_Amount());
		
	}

	@Override
	public void oneImgDelete(ItemImg img) throws Exception {
		dao.oneImgDelete(img);
		
	}


}
