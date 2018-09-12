package com.sp.payment.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public class DeliveryDTO_gy {
// 배송상태 업데이트를 위한 객체  이메일까지
	
	
	int item_no;
	String member_email;
	
	
	public String getMember_email() {
		return member_email;
	}

	public DeliveryDTO_gy(int item_no, String member_email) {
		super();
		this.item_no = item_no;
		this.member_email = member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public DeliveryDTO_gy(){}

	public DeliveryDTO_gy(int item_no) {
		super();
		this.item_no = item_no;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	
}
