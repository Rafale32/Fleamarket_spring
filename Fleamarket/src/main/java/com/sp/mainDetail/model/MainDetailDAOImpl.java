package com.sp.mainDetail.model;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MainDetailDAOImpl implements MainDetailDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "MainDetailMapper";
	
	@Override
	public void create() throws Exception {
		//session.insert(namespace + ".create", vo);
	}
	
}
