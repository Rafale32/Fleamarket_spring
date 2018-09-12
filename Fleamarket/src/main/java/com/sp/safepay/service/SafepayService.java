package com.sp.safepay.service;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;


public interface SafepayService {

//	public MemManageDTO selectMember(Integer member_no)throws Exception;
	public MemManageDTO selectMember(String member_email)throws Exception;
	
	public ItemDTO selectItem(int item_no)throws Exception;
	
	public int selectOrderNo()throws Exception;
	
	public void insertOrder(OorderDTO oodrderDTO)throws Exception;
	
	public void insertPayment(PaymentDTO paymentDTO)throws Exception;
	
	public void insertDelivery(DeliveryDTO deliveryDTO)throws Exception;
	
	public void updateItemDeliveryState(ItemDTO itemDTO)throws Exception;

}
