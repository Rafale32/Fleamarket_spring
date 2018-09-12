package com.sp.safepay.model;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SafepayDAOImpl implements SafepayDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "SafepayMapper";
	
	@Override
	public void create() throws Exception {
		//session.insert(namespace + ".create", vo);
	}
	
}
