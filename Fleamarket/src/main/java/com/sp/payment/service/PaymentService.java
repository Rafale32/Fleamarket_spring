package com.sp.payment.service;

import java.util.List;

import com.sp.payment.domain.Criteria2;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;


public interface PaymentService {
	
	public void regist()throws Exception;
	
	//구매 내역을 뽑는것
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	
	//판매내역
	
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception;
	
	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception;
	
	//내상점 찾기
	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception;
	
	//리뷰 찾기
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto,Criteria2 cri)throws Exception;
	
	//카운팅 페이지
	public int puerchasecounting(DeliveryDTO_gy dto) throws Exception;
	
	public int sellListcounting(DeliveryDTO_gy dto) throws Exception;
	
	public int mystoreReviewCounting(MystoreDTO_gy sdto) throws Exception;
	
	//insert_inform
	
	public void registerPerchaseAlram(PuerchaseDTO_gy pdto) throws Exception;
	
	
	public List<PuerchaseDTO_gy> listFavorit(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	public void deletfavorit(PuerchaseDTO_gy pdto) throws Exception;
}
