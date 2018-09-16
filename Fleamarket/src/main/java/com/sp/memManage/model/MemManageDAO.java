package com.sp.memManage.model;

import java.util.List;
import java.util.Map;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.domain.StoreDTO;

public interface MemManageDAO {
	
	//로그인 체크
	public MemManageDTO checkLogin(MemManageDTO dto)throws Exception;
	//회원 등록
	public void register(MemManageDTO memManageDTO)throws Exception;
	//회원 정보
	public MemManageDTO detail(String member_email)throws Exception;
	//회원 수정
	public void update(MemManageDTO memManageDTO)throws Exception;
	//회원 삭제
	public void delete(String member_email)throws Exception;
	
	//이메일 중복체크
	public Integer emailcheck(String member_email)throws Exception;
	
	//스토어 생성
	public void registerStore(StoreDTO storeDTO)throws Exception;

	//스토어 이름 변경
	public void storeUpdate(StoreDTO storeDTO)throws Exception;
	
	//중복된 상점명 찾기
	public List<StoreDTO> listStore()throws Exception;
	
}
