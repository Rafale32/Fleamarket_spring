package com.sp.payment.service;

import java.util.List;

import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;


public interface PaymentService {
	
	public void regist()throws Exception;
	
	//구매 내역을 뽑는것
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto) throws Exception;
	
	
	//판매내역
	
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto) throws Exception;
	
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception;
	
	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception;
	
	//내상점 찾기
	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception;
	
	//리뷰 찾기
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto)throws Exception;
	
}
