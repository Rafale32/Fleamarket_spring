package com.sp.product.model;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.product.domain.ItemDTO;
import com.sp.product.service.ProductListService;
import com.sp.product.service.ProductListServiceImpl;

@Repository
public class ProductListDAOImpl implements ProductListDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "ProductMapper";

	@Override
	public int countItemBoard(String email) {
		// return session.getMapper(ProductMapper.class).countItemBoard(email);
		// // 이거 이렇게 해서 동작함?
		return session.selectOne(namespace + ".countItemBoard", email);
	}

	@Override
	public List<ItemDTO> productList(String email, int startRow) {

		List<ItemDTO> list = null;

		list = session.selectList(namespace + ".itemList", email,
				new RowBounds(startRow, ProductListServiceImpl.PAGE_SIZE));

		for (ItemDTO tmp : list) {
			if (tmp.getItemboard_No() != 0) {
				tmp.setItemImgList(session.selectList(namespace + ".itemImgList", tmp.getItemboard_No()));
			}
			
			tmp.setPrice(session.selectOne(namespace + ".itemPrice", tmp.getItem_No()));
			tmp.setFavCount(session.selectOne(namespace + ".favCount", tmp.getItemboard_No()));
			tmp.setItemQnaCount(session.selectOne(namespace + ".itemQnaCount", tmp.getItemboard_No()));
			
		}

		return list;
	}
	
	@Override
	public int countItemBoardByStore(String store_name) {
		int cnt = 0;

		cnt = session.selectOne(namespace+".countItemBoardByStore", store_name);

		return cnt;
	}
	
	@Override
	public List<ItemDTO> productListByStore(String storeName, int startRow) {

		List<ItemDTO> list = null;

		list = session.selectList(namespace + ".itemListByStore", storeName ,new RowBounds(startRow, ProductListServiceImpl.PAGE_SIZE));

		for (ItemDTO tmp : list) {
			if (tmp.getItemboard_No() != 0) {
				tmp.setItemImgList(session.selectList(namespace+".itemImgList" , tmp.getItemboard_No()));
			}
			
			tmp.setPrice(session.selectOne(namespace + ".itemPrice", tmp.getItem_No()));
			tmp.setFavCount(session.selectOne(namespace + ".favCount", tmp.getItemboard_No()));
			tmp.setItemQnaCount(session.selectOne(namespace + ".itemQnaCount", tmp.getItemboard_No()));

		}
		return list;
	}

}
