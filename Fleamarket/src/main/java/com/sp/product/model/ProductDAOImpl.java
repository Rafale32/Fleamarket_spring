package com.sp.product.model;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ProductMapper";
	
	@Override
	public void create() throws Exception {
		//session.insert(namespace + ".create", vo);
	}
	
}
