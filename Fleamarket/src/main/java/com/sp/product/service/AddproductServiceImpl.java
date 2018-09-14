package com.sp.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.product.domain.CateDTO;
import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.ItemImg;
import com.sp.product.model.AddproductDAO;

@Service
public class AddproductServiceImpl implements AddproductService {

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

	@Transactional
	@Override
	public void addProduct(ItemDTO itemDTO) {
		// 2. 아이템 넣기 아이템보드 넣기 파일 이름 처리까지해서 이미지 넣기 테그 넣기
		// 교환, 배달비 포함 처리

		if (itemDTO.isDeliveryIs()) {
			itemDTO.setItem_Delivery_B(1);
		} else {
			itemDTO.setItem_Delivery_B(0);
		}
		if(itemDTO.isChangeIs()){
			itemDTO.setItemboard_Change_b(1);
		}else{
			itemDTO.setItemboard_Change_b(0);
		}
		
		dao.insertItem(itemDTO);
		dao.insertItemBoard(itemDTO);
		//이미지와 썸 이미지 이름 처리
		for(String tmp : itemDTO.getFiles()){
			
			if(tmp != null){
				ItemImg img = new ItemImg();
				img.setThum_Img(tmp);
				String left = tmp.substring(0, 12);
				String right = tmp.substring(14,tmp.length());
				String withoutThum = left+right;
				
				img.setBig_Img(withoutThum);
				
				dao.insertImgs(img);
				
			}
		}
		
		if(itemDTO.getTag_Name() != null){
			String tmp = itemDTO.getTag_Name();
			String[] tags = tmp.split(",");
			
			String allTags = "";
			if(tags.length >= 2){
				for(String tmp2:tags){
					allTags += tmp2.trim()+",";
				}
				itemDTO.setTag_Name(allTags);
			}
		}
		
		dao.insertTags(itemDTO.getTag_Name());
	}

}
