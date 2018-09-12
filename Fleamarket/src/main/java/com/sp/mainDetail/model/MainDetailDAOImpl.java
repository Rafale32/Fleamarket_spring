package com.sp.mainDetail.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.mainDetail.domain.CategoryDTO;
import com.sp.mainDetail.domain.HotItemDTO;
import com.sp.mainDetail.domain.HotListDTO;
import com.sp.mainDetail.domain.ItemDetailDTO;
import com.sp.mainDetail.domain.ItemImgDTO;
import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.domain.RecommendDTO;
import com.sp.mainDetail.domain.StoreInfoDTO;
import com.sp.mainDetail.domain.SubCategoryDTO;

@Repository
public class MainDetailDAOImpl implements MainDetailDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "MainDetailMapper";

	@Override
	public List<RecommendDTO> recommend() throws Exception {
		return session.selectList(namespace+".recommend");
	}

	@Override
	public List<HotItemDTO> hotItemList() throws Exception {
		return session.selectList(namespace+".hotItemList");
	}

	@Override
	public List<HotListDTO> hotList() throws Exception {
		return session.selectList(namespace+".hotList");
	}

	@Override
	public List<CategoryDTO> categoryList() throws Exception {
		return session.selectList(namespace+".categoryList");
	}

	@Override
	public List<SubCategoryDTO> subCategoryList() throws Exception {
		return session.selectList(namespace+".subCategoryList");
	}

	@Override
	public ItemDetailDTO itemDetail(Integer itemboard_no) throws Exception {
		session.update(namespace+".updateHits", itemboard_no);
		return session.selectOne(namespace+".itemDetail", itemboard_no);
	}

	@Override
	public List<ItemImgDTO> itemImgList(Integer itemboard_no) throws Exception {
		return session.selectList(namespace+".itemImgList", itemboard_no);
	}

	@Override
	public StoreInfoDTO storeInfo(Integer itemboard_no) throws Exception {
		return session.selectOne(namespace+".storeInfo", itemboard_no);
	}

	@Override
	public List<ItemDetailDTO> storeItemList(Integer store_no, Integer itemboard_no) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("store_no", store_no);
		paramMap.put("itemboard_no", itemboard_no);
		
		return session.selectList(namespace+".storeItem", paramMap);
	}

	@Override
	public List<ItemQnaDTO> listQna(Integer itemboard_no) throws Exception {
		return session.selectList(namespace+".listQna", itemboard_no);
	}

	@Override
	public void insertQna(ItemQnaDTO itemQna) throws Exception {
		session.insert(namespace+".insertQna",itemQna);
	}

	@Override
	public ItemQnaDTO storeNoInfo(String name) throws Exception {
		return session.selectOne(namespace+".storeNoInfo", name);
	}

	@Override
	public void deleteQna(Integer itemQnaNo) throws Exception {
		session.delete(namespace+".deleteQna", itemQnaNo);
	}

	@Override
	public List<ItemDetailDTO> categoryItemList(Integer category_no) throws Exception {
		return session.selectList(namespace+".categoryItemList", category_no);
	}
	
	
}
