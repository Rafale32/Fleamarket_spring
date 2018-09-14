package com.sp.product.model;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.product.domain.CateDTO;
import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.ItemImg;

@Repository
public class AddproductDAOImpl implements AddproductDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ProductMapper";

	@Override
	public List<CateDTO> getCateDTO() {
		
		return session.selectList(namespace+".getCate");
	}
	
	@Override
	public List<CateSubDTO> getSubCate(Integer category_No) {
		
		return session.selectList(namespace+".getSubCate", category_No);
	}

	
	@Override
	public void insertItem(ItemDTO itemDTO) {
		session.insert(namespace + ".insertItem", itemDTO);
	}

	@Override
	public void insertItemBoard(ItemDTO itemDTO) {
		session.insert(namespace + ".insertItemBoard", itemDTO);
	}

	@Override
	public void insertImgs(ItemImg img) {
		session.insert(namespace + ".insertImgs", img);
	}
	
	@Override
	public void insertTags(String tag) {
		session.insert(namespace+".insertTag", tag);	
	}
	

}
