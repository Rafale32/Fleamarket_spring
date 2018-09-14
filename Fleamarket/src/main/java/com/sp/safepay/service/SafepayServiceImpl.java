package com.sp.safepay.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.ItemImgDTO_jh;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;
import com.sp.safepay.model.SafepayDAO;

@Service
public class SafepayServiceImpl implements SafepayService {
	
	@Inject
	private SafepayDAO dao;

	/*주문*/
	// 회원정보 불러오기
	@Override
	//	public MemManageDTO selectMember(Integer member_no) throws Exception {
	public MemManageDTO selectMember(String member_email) throws Exception {
		return dao.selectMember(member_email);
	}

	// 상품정보 불러오기
	@Override
	public ItemDTO selectItem(int item_no) throws Exception {
	  return dao.selectItem(item_no);
	}
	
	// 주문번호
	@Override
	public int selectOrderNo() throws Exception {
	  return dao.selectOrderNo();
	}
	
	// 주문내역 입력
	@Override
	public void insertOrder(OorderDTO oorderDTO) throws Exception {
	 dao.insertOrder(oorderDTO);
	}
	
	// 결제내역 입력
	@Override
	public void insertPayment(PaymentDTO paymentDTO) throws Exception {
	  dao.insertPayment(paymentDTO);
	}
	
	// 배송정보 입력
	@Override
	public void insertDelivery(DeliveryDTO deliveryDTO) throws Exception {
	  dao.insertDelivery(deliveryDTO);
	}
	
	// 상품 배송상태 수정
  @Override
  public void updateItemDeliveryState(int item_no) throws Exception {
    dao.updateItemDeliveryState(item_no);
  }
  
  // 회원 포인트 수정
  @Override
  public void updateMemberPoint(MemManageDTO memManageDTO) throws Exception {
    dao.updateMemberPoint(memManageDTO);
  }
  
  /*주문상세*/
  //주문내역 불러오기
  @Override
  public OorderDTO findOrder(int item_no) throws Exception {
    return dao.findOrder(item_no);
  }

  //상품정보 불러오기
  @Override
  public ItemDTO findItem(int item_no) throws Exception {
    return dao.findItem(item_no);
  }
  
  //결제내역 불러오기
  @Override
  public PaymentDTO findPayment(int item_no) throws Exception {
    return dao.findPayment(item_no);
  }
  
  //배송정보 불러오기
  @Override
  public DeliveryDTO findDeli(int item_no) throws Exception {
    return dao.findDeli(item_no);
  }
  
  //상품이미지 불러오기
  @Override
  public ItemImgDTO_jh findImg(int item_no) throws Exception {
    return dao.findImg(item_no);
  }
  
  
  
}




