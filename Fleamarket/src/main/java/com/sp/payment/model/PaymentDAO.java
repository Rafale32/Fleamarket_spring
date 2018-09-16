package com.sp.payment.model;

import java.util.List;

import com.sp.payment.domain.Criteria2;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;

public interface PaymentDAO {
	
	public void create()throws Exception;
	
	//援щℓ �궡�뿭�쓣 戮묐뒗寃�
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	
	//�뙋留ㅻ궡�뿭
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	
	//援щℓ�옄 援щℓ�솗�젙, �뵜由щ쾭由� �뒪�뀒�씠�듃 蹂�寃�
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception;
	
	//�뙋留ㅼ옄 �뙋留ㅼ듅�씤, �뵜由щ쾭由� �뒪�뀒�씠�듃 蹂�寃�
	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception;
	
	//�뒪�넗�뼱 李얘린, 由щ럭 李얘린 , 移댁슫�똿
	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception;
	
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto,Criteria2 cri)throws Exception;
	
	public int MystoreReviewcounting(MystoreDTO_gy sdto) throws Exception;
	
	//移댁슫�똿 �럹�씠吏�
	
	public int puerchasecounting(DeliveryDTO_gy dto) throws Exception;
	
	public int sellListcounting(DeliveryDTO_gy dto) throws Exception;
	
	//�엯�젰 inform �븘 諛붽씀�뒗嫄� 泥섎━�뻽�쓬
	public void registerPerchaseAlram(PuerchaseDTO_gy pdto) throws Exception;
	

	public List<PuerchaseDTO_gy> listFavorit(DeliveryDTO_gy dto,Criteria2 cri) throws Exception;
	
	public void deletfavorit(PuerchaseDTO_gy pdto) throws Exception;
	
}
