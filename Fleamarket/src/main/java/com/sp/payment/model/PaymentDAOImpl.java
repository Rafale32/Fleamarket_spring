package com.sp.payment.model;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements PaymentDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "PaymentMapper";
	
	@Override
	public void create() throws Exception {
		//session.insert(namespace + ".create", vo);
	}
	
}
