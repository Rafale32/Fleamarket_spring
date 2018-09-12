package com.sp.payment.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.sp.board.model.BoardDAO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Inject
	private BoardDAO dao;

	@Override
	public void regist() throws Exception {
		// TODO Auto-generated method stub
		dao.create();
	}


}
