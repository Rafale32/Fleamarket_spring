package com.sp.product.model;

import java.util.List;
import com.sp.product.domain.ItemDTO;

public interface ProductListDAO {
	
	public int countItemBoard(String email);
	
	public List<ItemDTO> productList(String email, int startRow);
	
	public int countItemBoardByStore(String store_name);
	
	public List<ItemDTO> productListByStore(String storeName, int startRow);
	
}
