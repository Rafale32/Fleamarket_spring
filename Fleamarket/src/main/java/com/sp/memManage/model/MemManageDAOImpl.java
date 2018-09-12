package com.sp.memManage.model;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.memManage.domain.MemManageDTO;

@Repository
public class MemManageDAOImpl implements MemManageDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "MemManageMapper";
	
	@Override
	public void create() throws Exception {
		//session.insert(namespace + ".create", vo);
	}
	
	@Override
	public MemManageDTO checkLogin(MemManageDTO dto) throws Exception {
		
		return session.selectOne(namespace+".loginMember", dto);
	}
	
}
