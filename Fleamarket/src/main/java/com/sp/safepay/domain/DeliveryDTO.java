package com.sp.safepay.domain;

import java.io.Serializable;

// 배송 정보 저장 되는 애
public class DeliveryDTO implements Serializable {
  private int delivery_no;          // 배송번호
  private String delivery_name;     // 수령인
  private String delivery_ph;       // 수령인 연락처
  private String delivery_address;  // 주소
  private String delivery_address2; // 상세주소
  private String delivery_contents; // 배송시 요청사항
  private int oorder_no;            // 주문번호

  public DeliveryDTO() {
  }

  public int getDelivery_no() {
    return delivery_no;
  }

  public void setDelivery_no(int delivery_no) {
    this.delivery_no = delivery_no;
  }

  public String getDelivery_name() {
    return delivery_name;
  }

  public void setDelivery_name(String delivery_name) {
    this.delivery_name = delivery_name;
  }

  public String getDelivery_ph() {
    return delivery_ph;
  }

  public void setDelivery_ph(String delivery_ph) {
    this.delivery_ph = delivery_ph;
  }

  public String getDelivery_address() {
    return delivery_address;
  }

  public void setDelivery_address(String delivery_address) {
    this.delivery_address = delivery_address;
  }

  public String getDelivery_address2() {
    return delivery_address2;
  }

  public void setDelivery_address2(String delivery_address2) {
    this.delivery_address2 = delivery_address2;
  }

  public String getDelivery_contents() {
    return delivery_contents;
  }

  public void setDelivery_contents(String delivery_contents) {
    this.delivery_contents = delivery_contents;
  }

  public int getOorder_no() {
    return oorder_no;
  }

  public void setOorder_no(int oorder_no) {
    this.oorder_no = oorder_no;
  }



}
