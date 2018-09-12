package com.sp.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.product.domain.CateDTO;
import com.sp.product.domain.CateSubDTO;
import com.sp.product.model.AddproductDAO;

@Service
public class AddproductServiceImpl implements AddproductService{
	
	@Inject
	private AddproductDAO dao;
	
	@Override
	public List<CateDTO> getCateDTO() {
		
		return dao.getCateDTO();
	}

	@Override
	public List<CateSubDTO> getSubCate(Integer category_No) {
		
		return dao.getSubCate(category_No);
	}

}
