package com.sp.payment.model;

import java.util.List;

import com.sp.payment.domain.Criteria2;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;

public interface PaymentDAO {
	
	public void create()throws Exception;
	

	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	

	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception;

	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception;
	

	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception;
	
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto,Criteria2 cri)throws Exception;
	
	public int MystoreReviewcounting(MystoreDTO_gy sdto) throws Exception;
	

	
	public int puerchasecounting(DeliveryDTO_gy dto) throws Exception;
	
	public int sellListcounting(DeliveryDTO_gy dto) throws Exception;
	

	public void registerPerchaseAlram(PuerchaseDTO_gy pdto) throws Exception;
	

	public List<PuerchaseDTO_gy> listFavorit(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	public void deletfavorit(PuerchaseDTO_gy pdto) throws Exception;
	
	public int favListcounting(DeliveryDTO_gy dto) throws Exception;
	
}
