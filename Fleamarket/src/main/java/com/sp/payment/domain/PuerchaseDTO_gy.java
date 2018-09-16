package com.sp.payment.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

public class PuerchaseDTO_gy implements Serializable {

	int itemboard_no;
	String member_email;
	String itemboard_title =""; // 판매 물품의 제목
	int item_delivery_state; // 배송상태 1 이전, 2 결제완료후 준비중 , 3 배송중(판매자 판매승인) , 4 구매자 구매완료 =거래완료
	int item_price;//바
	int item_no;
	String store_name =""; // 어떤 상점인지
	String thum_img =""; // 썸네일 이미지.
	String pay_date= ""; //날자
	int store_no;
	int inform_contents;//inform컨텐츠
	String itemboard_local;
	
	
	public PuerchaseDTO_gy(){}
	
	



	public PuerchaseDTO_gy(int itemboard_no, String member_email, String itemboard_title, int item_delivery_state,
			int item_price, int item_no, String store_name, String thum_img, String pay_date, int store_no,
			int inform_contents, String itemboard_local) {
		super();
		this.itemboard_no = itemboard_no;
		this.member_email = member_email;
		this.itemboard_title = itemboard_title;
		this.item_delivery_state = item_delivery_state;
		this.item_price = item_price;
		this.item_no = item_no;
		this.store_name = store_name;
		this.thum_img = thum_img;
		this.pay_date = pay_date;
		this.store_no = store_no;
		this.inform_contents = inform_contents;
		this.itemboard_local = itemboard_local;
	}


	


	public String getItemboard_local() {
		return itemboard_local;
	}





	public void setItemboard_local(String itemboard_local) {
		this.itemboard_local = itemboard_local;
	}





	public int getInform_contents() {
		return inform_contents;
	}



	public void setInform_contents(int inform_contents) {
		this.inform_contents = inform_contents;
	}



	public int getItemboard_no() {
		return itemboard_no;
	}


	public void setItemboard_no(int itemboard_no) {
		this.itemboard_no = itemboard_no;
	}

	public int getStore_no() {
		return store_no;
	}


	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}








	public String getMember_email() {
		return member_email;
	}





	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}





	public String getItemboard_title() {
		return itemboard_title;
	}


	public void setItemboard_title(String itemboard_title) {
		this.itemboard_title = itemboard_title;
	}


	public int getItem_delivery_state() {
		return item_delivery_state;
	}


	public void setItem_delivery_state(int item_delivery_state) {
		this.item_delivery_state = item_delivery_state;
	}


	public int getItem_price() {
		return item_price;
	}


	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}


	public int getItem_no() {
		return item_no;
	}


	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}


	public String getStore_name() {
		return store_name;
	}


	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}


	public String getThum_img() {
		return thum_img;
	}


	public void setThum_img(String thum_img) {
		this.thum_img = thum_img;
	}


	public String getPay_date() {
		return pay_date;
	}


	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	@Override
	public String toString() {
		return "PuerchaseDTO_gy [itemboard_no=" + itemboard_no + ", member_email=" + member_email + ", itemboard_title="
				+ itemboard_title + ", item_delivery_state=" + item_delivery_state + ", item_price=" + item_price
				+ ", item_no=" + item_no + ", store_name=" + store_name + ", thum_img=" + thum_img + ", pay_date="
				+ pay_date + ", store_no=" + store_no + ", inform_contents=" + inform_contents + "]";
	}

	

	
	
	

}
