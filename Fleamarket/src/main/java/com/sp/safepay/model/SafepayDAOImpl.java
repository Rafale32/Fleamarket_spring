package com.sp.safepay.model;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.memManage.domain.MemManageDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.ItemImgDTO_jh;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;

@Repository
public class SafepayDAOImpl implements SafepayDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "SafepayMapper";

  /* 주문 */
  // 구매자 정보
  @Override
  // public MemManageDTO selectMember(Integer member_no) throws Exception {
  // return session.selectOne(namespace+".selectMember",member_no);
  public MemManageDTO selectMember(String member_email) throws Exception {
    return session.selectOne(namespace + ".selectMember", member_email);
  }

  // 상품정보
  @Override
  public ItemDTO selectItem(int item_no) throws Exception {
    return session.selectOne(namespace + ".selectItem", item_no);
  }

  // 주문번호가져오기
  @Override
  public int selectOrderNo() throws Exception {
    return session.selectOne(namespace + ".selectOrderNo");
  }

  // 주문 정보 입력
  @Override
  public void insertOrder(OorderDTO oorderDTO) throws Exception {
    session.insert(namespace + ".insertOrder", oorderDTO);
  }

  // 결제 정보 입력
  @Override
  public void insertPayment(PaymentDTO paymentDTO) throws Exception {
    session.insert(namespace + ".insertPayment", paymentDTO);
  }

  // 배송 정보 입력
  @Override
  public void insertDelivery(DeliveryDTO deliveryDTO) throws Exception {
    session.insert(namespace + ".insertDelivery", deliveryDTO);
  }

  // 상품 배송상태 수정
  @Override
  public void updateItemDeliveryState(int item_no) throws Exception {
    session.update(namespace + ".updateItemDeliveryState", item_no);
  }

  // 회원 포인트 수정
  @Override
  public void updateMemberPoint(MemManageDTO memManageDTO) throws Exception {
    session.update(namespace + ".updateMemberPoint", memManageDTO);
  }

  /* 주문상세내역 */
  // 주문내역 불러오기
  @Override
  public OorderDTO findOrder(int item_no) throws Exception {
    return session.selectOne(namespace + ".findOrder", item_no);
  }

  // 상품정보 불러오기
  @Override
  public ItemDTO findItem(int item_no) throws Exception {
    return session.selectOne(namespace + ".findItem", item_no);
  }

  // 결제내역 불러오기
  @Override
  public PaymentDTO findPayment(int item_no) throws Exception {
    return session.selectOne(namespace+".findPayment",item_no);
  }

  // 배송정보 불러오기
  @Override
  public DeliveryDTO findDeli(int item_no) throws Exception {
    return session.selectOne(namespace+".findDeli",item_no);
  }
  
  //상품 이미지 불러오기
  @Override
  public ItemImgDTO_jh findImg(int item_no) throws Exception {
    return session.selectOne(namespace+".findImg",item_no);
  }


}
