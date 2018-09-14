package com.sp.memManage.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.domain.StoreDTO;

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
	public void update(MemManageDTO memManageDTO) throws Exception {
		session.update(namespace+".updateMember", memManageDTO);
	}
	//회원 삭제
	@Override
	public void delete(String member_email) throws Exception {
		session.delete(namespace+".deleteMember", member_email);
	}
	//이메일 중복체크
//	@Override
//	public int emailCheck(Map<String, Object> map) throws Exception{
//		
//		Map<String, Object> resultMap = (Map<String, Object>)session.selectOne(namespace+".emailcheck", map);
//		
//		int result = Integer.valueOf(String.valueOf(resultMap.get("RESULT")));
//		
//		return result;
//	}
	
	//이메일 체크
	@Override
	public int emailchekc(String member_email)throws Exception{
		return session.selectOne(namespace+".emailCheck", member_email);
	}
	
	//스토어 생성
	@Override
	public void registerStore(StoreDTO storeDTO)throws Exception{
		session.insert(namespace+".registerStore", storeDTO);
	}
	//랜덤 스토어명 생성
	@Override
	public void randomStore(StoreDTO storedDTO)throws Exception{
		session.update(namespace+".randomName", storedDTO);
	}
	//중복된 상점명 찾기
	@Override
	public List<StoreDTO> listStore() throws Exception{
		return session.selectList(namespace+".listStore");
	}
	

	
}
