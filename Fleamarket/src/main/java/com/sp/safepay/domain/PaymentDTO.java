package com.sp.safepay.domain;

import java.io.Serializable;

public class PaymentDTO implements Serializable{
	private int pay_no;      // 결제번호
	private int pay_price;   // 결제 총 금액
	private int pay_usepoint;// 소모포인트 추가
	private String pay_date; // 결제날짜
	private int oorder_no;   // 주문번호

	public PaymentDTO(){}

  public int getPay_no() {
    return pay_no;
  }

  public void setPay_no(int pay_no) {
    this.pay_no = pay_no;
  }

  public String getPay_date() {
    return pay_date;
  }

  public void setPay_date(String pay_date) {
    this.pay_date = pay_date;
  }

  public int getPay_price() {
    return pay_price;
  }

  public void setPay_price(int pay_price) {
    this.pay_price = pay_price;
  }

  public int getOorder_no() {
    return oorder_no;
  }

  public void setOorder_no(int oorder_no) {
    this.oorder_no = oorder_no;
  }

  public int getPay_usepoint() {
    return pay_usepoint;
  }

  public void setPay_usepoint(int pay_usepoint) {
    this.pay_usepoint = pay_usepoint;
  }
	
	
  
 
	
}
