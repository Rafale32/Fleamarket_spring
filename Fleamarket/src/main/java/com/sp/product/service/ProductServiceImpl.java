package com.sp.product.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.bean.Bean;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.ItemImg;
import com.sp.product.model.AddproductDAO;
import com.sp.product.model.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductDAO dao;
	
	@Inject
	private AddproductDAO apDAO;

	@Override
	public void productModifyForm(int itemboard_No, Bean bean) throws Exception {
		
		ItemDTO dto = dao.itemNboardNtag(itemboard_No);
		dto.setItemImgList(dao.getImgList(itemboard_No));
		bean.setItemDTO(dto);
		bean.setSubCate(dao.getSubCate(dto.getCategory_No()));
		
		
		bean.getItemDTO().setCategory_No(bean.getSubCate().get(0).getCategory_No());
		
	}

	@Override
	public void oneImgDelete(ItemImg img) throws Exception {
		dao.oneImgDelete(img);
		
	}

	@Transactional
	@Override
	public void productModify(ItemDTO itemDTO) throws Exception {
		//아이템  아이템 보드 태그 
		dao.itemModify(itemDTO);
		dao.itemBoardModify(itemDTO);
		dao.tagModify(itemDTO);
		
		if(itemDTO.getFiles() != null){
			for(String tmp : itemDTO.getFiles()){
				
				if(tmp != null){
					ItemImg img = new ItemImg();
					img.setThum_Img(tmp);
					String left = tmp.substring(0, 12);
					String right = tmp.substring(14,tmp.length());
					String withoutThum = left+right;
					
					img.setBig_Img(withoutThum);
					
					apDAO.insertImgs(img);
					
				}
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
		
		dao.tagModify(itemDTO);
		
	}

	@Override
	public List<ItemDTO> searchAll(String subj) throws Exception {
		List<ItemDTO> dtoList = dao.searchAll(subj);
		
		for(ItemDTO tmp : dtoList){
			tmp.setThumImg(dao.getOneImg(tmp.getItemboard_No()));
		}
		
		return dtoList;
	}


}
