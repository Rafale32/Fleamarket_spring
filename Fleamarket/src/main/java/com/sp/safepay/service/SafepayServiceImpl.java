package com.sp.safepay.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;
import com.sp.safepay.model.SafepayDAO;

@Service
public class SafepayServiceImpl implements SafepayService {
	
	@Inject
	private SafepayDAO dao;

	@Override
	//	public MemManageDTO selectMember(Integer member_no) throws Exception {
	public MemManageDTO selectMember(String member_email) throws Exception {
		return dao.selectMember(member_email);
	}

	@Override
	public ItemDTO selectItem(int item_no) throws Exception {
	  return dao.selectItem(item_no);
	}
	
	@Override
	public int selectOrderNo() throws Exception {
	  return dao.selectOrderNo();
	}
	
	@Override
	public void insertOrder(OorderDTO oorderDTO) throws Exception {
	 dao.insertOrder(oorderDTO);
	}
	
	@Override
	public void insertPayment(PaymentDTO paymentDTO) throws Exception {
	  dao.insertPayment(paymentDTO);
	}
	
	@Override
	public void insertDelivery(DeliveryDTO deliveryDTO) throws Exception {
	  dao.insertDelivery(deliveryDTO);
	}
	
  @Override
  public void updateItemDeliveryState(ItemDTO itemDTO) throws Exception {
    dao.updateItemDeliveryState(itemDTO);
  }
}
