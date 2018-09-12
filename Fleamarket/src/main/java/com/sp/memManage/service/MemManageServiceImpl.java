package com.sp.memManage.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.model.MemManageDAO;

@Service
public class MemManageServiceImpl implements MemManageService {
	
	@Inject
	private MemManageDAO memManageDAO;
	
	//로그인 체크
	@Override
	public MemManageDTO checkLogin(MemManageDTO dto) throws Exception {
		
		return memManageDAO.checkLogin(dto);
	}
	//회원 등록
	@Override
	public void registerMember(MemManageDTO memManageDTO) throws Exception {
		memManageDAO.register(memManageDTO);
	}
	//회원 정보
	@Override
	public MemManageDTO detailMember(String member_email) throws Exception {
		return memManageDAO.detail(member_email);
	}
	//회원 수정
	@Override
	public void updateMember(String member_email) throws Exception {
		
		memManageDAO.update(member_email);
		System.out.println("나는 서비스");
	}
	//회원 삭제
	@Override
	public void deleteMember(String member_email) throws Exception {
		memManageDAO.delete(member_email);
	}

}
