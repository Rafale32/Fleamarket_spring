package com.sp.payment.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.sp.board.model.BoardDAO;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;
import com.sp.payment.model.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Inject
	private PaymentDAO dao;

	@Override
	public void regist() throws Exception {
		// TODO Auto-generated method stub
		dao.create();
	}

	@Override
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto) throws Exception {
		
		return dao.listPuerchase(dto);
	}

	
	@Override
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception {
		dao.changDeliverState(dto);
		
	}

	
	@Override
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSell(dto);
	}

	@Override
	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception {
		dao.changDeliverState2(dto);
		
	}
	
	//내상점 찾기
	@Override
	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception {
		
		return dao.SearchMystore(dto);
	}

	@Override
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.MystoreReview(sdto);
	}


}
