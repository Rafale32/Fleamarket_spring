package com.sp.payment.model;

import java.util.List;

import com.sp.payment.domain.Criteria2;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;

public interface PaymentDAO {
	
	public void create()throws Exception;
	
	//구매 내역을 뽑는것
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	
	//판매내역
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	
	//구매자 구매확정, 딜리버리 스테이트 변경
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception;
	
	//판매자 판매승인, 딜리버리 스테이트 변경
	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception;
	
	//스토어 찾기, 리뷰 찾기 , 카운팅
	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception;
	
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto,Criteria2 cri)throws Exception;
	
	public int MystoreReviewcounting(MystoreDTO_gy sdto) throws Exception;
	
	//카운팅 페이지
	
	public int puerchasecounting(DeliveryDTO_gy dto) throws Exception;
	
	public int sellListcounting(DeliveryDTO_gy dto) throws Exception;
	
	//입력 inform 아 바꾸는걸 처리했음
	public void registerPerchaseAlram(PuerchaseDTO_gy pdto) throws Exception;
	
	//원하는 아이템 보드로 땡겨오는것
	
	
}
