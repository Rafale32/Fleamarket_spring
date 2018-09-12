package com.sp.memManage.service;

import com.sp.memManage.domain.MemManageDTO;


public interface MemManageService {
	
	//로그인 체크
	public MemManageDTO checkLogin(MemManageDTO dto)throws Exception;
	//회원등록
	public void registerMember(MemManageDTO memManageDTO) throws Exception;
	//회원 정보
	public MemManageDTO detailMember(String member_email) throws Exception;
	//회원 수정
	public void updateMember(String member_email) throws Exception;
	//회원 삭제
	public void deleteMember(String member_email) throws Exception;
	
}
