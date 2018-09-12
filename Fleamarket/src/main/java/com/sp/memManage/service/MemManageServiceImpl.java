package com.sp.memManage.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.model.MemManageDAO;

@Service
public class MemManageServiceImpl implements MemManageService {
	
	@Inject
	private MemManageDAO dao;

	@Override
	public void regist() throws Exception {
		// TODO Auto-generated method stub
		dao.create();
	}
	
	@Override
	public MemManageDTO checkLogin(MemManageDTO dto) throws Exception {
		
		return dao.checkLogin(dto);
	}


}
