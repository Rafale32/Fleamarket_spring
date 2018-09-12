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
	
	//로그인 체크
	@Override
	public MemManageDTO checkLogin(MemManageDTO dto) throws Exception {
		
		return session.selectOne(namespace+".loginMember", dto);
	}
	//회원 등록
	@Override
	public void register(MemManageDTO memManageDTO) throws Exception {
		session.insert(namespace+".registerMember", memManageDTO);
	}
	//회원 상세
	@Override
	public MemManageDTO detail(String member_email) throws Exception {
		return session.selectOne(namespace+".detailMember", member_email);
	}
	//회원 수정
	@Override
	public void update(String member_email) throws Exception {
		session.update(namespace+".updateMember", member_email);
		System.out.println("끄아아아악");
	}
	//회원 삭제
	@Override
	public void delete(String member_email) throws Exception {
		session.delete(namespace+".deleteMember", member_email);
	}

	
}
