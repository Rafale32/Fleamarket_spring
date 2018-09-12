package com.sp.safepay.domain;

import java.io.Serializable;

public class OorderDTO implements Serializable {
  private int oorder_no;       // 주문번호
  private int member_no;       // 구매자 회원번호
  private int item_no;         // 상품번호
  private String oorder_date;  // 주문날짜
  
  public OorderDTO(){}

  public OorderDTO(int oorder_no, int member_no, int item_no, String oorder_date) {
    super();
    this.oorder_no = oorder_no;
    this.member_no = member_no;
    this.item_no = item_no;
    this.oorder_date = oorder_date;
  }

  public int getOorder_no() {
    return oorder_no;
  }

  public void setOorder_no(int oorder_no) {
    this.oorder_no = oorder_no;
  }

  public int getMember_no() {
    return member_no;
  }

  public void setMember_no(int member_no) {
    this.member_no = member_no;
  }

  public int getItem_no() {
    return item_no;
  }

  public void setItem_no(int item_no) {
    this.item_no = item_no;
  }

  public String getOorder_date() {
    return oorder_date;
  }

  public void setOorder_date(String oorder_date) {
    this.oorder_date = oorder_date;
  }

  


}
