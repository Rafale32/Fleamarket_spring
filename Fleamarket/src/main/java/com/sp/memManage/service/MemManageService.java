package com.sp.memManage.service;

import java.util.List;
import java.util.Map;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.domain.StoreDTO;


public interface MemManageService {
	
	//로그인 체크
	public MemManageDTO checkLogin(MemManageDTO dto)throws Exception;
	//회원등록
	public void registerMember(MemManageDTO memManageDTO) throws Exception;
	//회원 정보
	public MemManageDTO detailMember(String member_email) throws Exception;
	//회원 수정
	public void updateMember(MemManageDTO memManageDTO) throws Exception;
	//회원 삭제
	public void deleteMember(String member_email) throws Exception;
	//이메일 중복체크
//	public int emailcheck(Map<String, Object> map) throws Exception;
	
	public int emailcheck(String member_email) throws Exception;
	
	//스토어 생성
	public void registerStore(StoreDTO storeDTO)throws Exception;
	//랜던 상정명 생성
	public void randomStore(StoreDTO storeDTO)throws Exception;
	//중복된 상점명 찾기
	public List<StoreDTO> listStoreService()throws Exception;
}
