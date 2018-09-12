package com.sp.memManage.service;

import java.util.List;

import com.sp.memManage.domain.MemManageDTO;


public interface MemManageService {
	
	public void regist()throws Exception;
	
	public MemManageDTO checkLogin(MemManageDTO dto)throws Exception;
	
}
