package com.sp.memManage.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.domain.StoreDTO;
import com.sp.memManage.model.MemManageDAO;
import com.sp.memManage.model.MemManageDAOImpl;

import sun.print.resources.serviceui;

@Service
public class MemManageServiceImpl implements MemManageService {
	
	@Inject
	private MemManageDAO memManageDAO;
	
	@Inject MemManageDAOImpl memManageDAOImpl;
	
	//로그인 체크
	@Override
	public MemManageDTO checkLogin(MemManageDTO dto) throws Exception {
		
		return memManageDAO.checkLogin(dto);
	}
	//회원 등록
	@Override
	public void registerMember(MemManageDTO memManageDTO) throws Exception {
		memManageDAO.register(memManageDTO);
//		MemManageDTO mem = memManageDAO.detail(memManageDTO.getMember_email());
//		StoreDTO store = new StoreDTO();
//		store.setMember_email(mem.getMember_email());
//		store.setMember_no(Integer.parseInt(mem.getMember_no()));
//		
//		memManageDAO.joinStore(storeDTO);
	}
	//회원 정보
	@Override
	public MemManageDTO detailMember(String member_email) throws Exception {
		return memManageDAO.detail(member_email);
	}
	//회원 수정
	@Override
	public void updateMember(MemManageDTO memManageDTO) throws Exception {
		
		memManageDAO.update(memManageDTO);
		System.out.println("나는 서비스");
	}
	//회원 삭제
	@Override
	public void deleteMember(String member_email) throws Exception {
		memManageDAO.delete(member_email);
	}
//	//이메일 중복체크
//	@Override
//	public String emailcheck(String str) throws Exception{
//		
//		System.out.println("인증 중");
//		  if(memManageDAO.emailCheck(str) ==null) {
//		    return "T";
//		  }else {
//		    return "F";
//		  }
//		
//	}
	
//	@Override
//	public int emailcheck(Map<String, Object> map) throws Exception{
//		return memManageDAO.emailCheck(map);
//	}
	
	@Override
	public Integer emailcheck(String member_email) throws Exception{		
		
		int cnt = memManageDAOImpl.emailcheck(member_email);
		System.out.println(cnt);
		return cnt;

	}
	
	//스토어 생성
	@Override
	public void registerStore(StoreDTO storeDTO)throws Exception{
		memManageDAO.registerStore(storeDTO);
	}
	
	//스토어명 변경
	@Override
	public void storeUpdate(StoreDTO storeDTO)throws Exception{
		memManageDAO.storeUpdate(storeDTO);
	}

	//중복된 상점명 찾기
	public List<StoreDTO> listStoreService()throws Exception{
	
		return memManageDAO.listStore();
	}


	
}
