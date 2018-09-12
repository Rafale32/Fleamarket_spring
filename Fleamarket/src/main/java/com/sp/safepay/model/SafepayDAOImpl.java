package com.sp.safepay.model;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;

@Repository
public class SafepayDAOImpl implements SafepayDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "SafepayMapper";
	
  // 구매자 정보
	@Override
//	public MemManageDTO selectMember(Integer member_no) throws Exception {
	  public MemManageDTO selectMember(String member_email) throws Exception {
//	  return session.selectOne(namespace+".selectMember",member_no);
	  return session.selectOne(namespace+".selectMember",member_email);
	}
	
	@Override
	public ItemDTO selectItem(int item_no) throws Exception {
	  return session.selectOne(namespace+".selectItem",item_no);
	}
	//	주문번호가져오기
	@Override
	public int selectOrderNo() throws Exception {
	  return session.selectOne(namespace+".selectOrderNo");
	}
	
	// 주문 정보 입력
	@Override
	public void insertOrder(OorderDTO oorderDTO) throws Exception {
	 session.insert(namespace+".insertOrder", oorderDTO);
	}
	
	@Override
	public void insertPayment(PaymentDTO paymentDTO) throws Exception {
	 session.insert(namespace+".insertPayment", paymentDTO);
	}
	
  @Override
  public void insertDelivery(DeliveryDTO deliveryDTO) throws Exception {
    session.insert(namespace+".insertDelivery", deliveryDTO);
  }	
  
  @Override
  public void updateItemDeliveryState(ItemDTO itemDTO) throws Exception {
    session.update(namespace+".updateItemDeliveryState", itemDTO);
  }
	
}
