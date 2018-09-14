package com.sp.safepay.service;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.ItemImgDTO_jh;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;


public interface SafepayService {
  /*주문*/
  /*GET*/
  //public MemManageDTO selectMember(Integer member_no)throws Exception;
  //회원정보
  public MemManageDTO selectMember(String member_email)throws Exception;
  //상품정보
  public ItemDTO selectItem(int item_no)throws Exception;
  //주문번호
  public int selectOrderNo()throws Exception;
  
  /*POST*/
  //주문내역입력
  public void insertOrder(OorderDTO oorderDTO)throws Exception;
  //결제내역입력
  public void insertPayment(PaymentDTO paymentDTO)throws Exception;
  //배송정보입력
  public void insertDelivery(DeliveryDTO deliveryDTO)throws Exception;
  //상품 배송상태 수정
  public void updateItemDeliveryState(int item_no)throws Exception;
  //회원 포인트 수정
  public void updateMemberPoint(MemManageDTO memManageDTO)throws Exception;
  
  /*주문상세*/
  //주문내역 불러오기
  public OorderDTO findOrder(int item_no)throws Exception;
  //상품정보 불러오기
  public ItemDTO findItem(int item_no)throws Exception;
  //결제내역 불러오기
  public PaymentDTO findPayment(int item_no)throws Exception;
  //배송정보 불러오기
  public DeliveryDTO findDeli(int item_no)throws Exception;
  //상품 이미지 불러오기
  public ItemImgDTO_jh findImg(int item_no)throws Exception;
}
