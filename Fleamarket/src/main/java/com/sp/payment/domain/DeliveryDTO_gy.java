package com.sp.payment.domain;

public class DeliveryDTO_gy {
// 배송상태 업데이트를 위한 객체 
	
	int item_no;
	
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
