package com.sp.payment.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

public class PuerchaseDTO_gy implements Serializable {


	
	String itemboard_title =""; // 판매 물품의 제목
	int item_delivery_state; // 배송상태 1 이전, 2 결제완료후 준비중 , 3 배송중(판매자 판매승인) , 4 구매자 구매완료 =거래완료
	int item_price;//바
	int item_no;
	String store_name =""; // 어떤 상점인지
	String thum_img =""; // 썸네일 이미지.
	String pay_date= ""; //날자
	
	
	public PuerchaseDTO_gy(){}


	public PuerchaseDTO_gy(String itemboard_title, int item_delivery_state, int item_price, int item_no,
			String store_name, String thum_img, String pay_date) {
		super();
		this.itemboard_title = itemboard_title;
		this.item_delivery_state = item_delivery_state;
		this.item_price = item_price;
		this.item_no = item_no;
		this.store_name = store_name;
		this.thum_img = thum_img;
		this.pay_date = pay_date;
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

	

	
	
	

}
