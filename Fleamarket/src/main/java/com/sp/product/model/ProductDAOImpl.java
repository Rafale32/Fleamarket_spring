package com.sp.product.model;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.ItemImg;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ProductMapper";

	@Override
	public ItemDTO itemNboardNtag(int itemboard_No) throws Exception {
		
		return session.selectOne(namespace+".itemNboardNtag", itemboard_No);
	}

	@Override
	public List<CateSubDTO> getSubCate(int category_No) throws Exception {
		
		return session.selectList(namespace+".getSubCate", category_No);
	}

	@Override
	public List<ItemImg> getImgList(int itemboard_No) throws Exception {
		
		return session.selectList(namespace+".itemImgList", itemboard_No);
	}

	@Override
	public void oneImgDelete(ItemImg img) throws Exception {
		
		session.delete(namespace+".oneImgDelete", img);
		
	}
	

	
}
