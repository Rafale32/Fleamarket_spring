package com.sp.memManage.model;

import com.sp.memManage.domain.MemManageDTO;

public interface MemManageDAO {
	
	public void create()throws Exception;
	
	public MemManageDTO checkLogin(MemManageDTO dto)throws Exception;
}
