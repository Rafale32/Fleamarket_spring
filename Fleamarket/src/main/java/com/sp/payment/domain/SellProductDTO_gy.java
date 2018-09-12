package com.sp.payment.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

public class SellProductDTO_gy implements Serializable{
	

	String title =""; // 판매 물품의 제목
	String store_name =""; // 어떤 상점인지
	int delivery_state; // 배송상태 1 이전, 2 결제완료후 준비중 , 3 배송중(판매자 판매승인) , 4 구매자 구매완료 =거래완료
	int item_no;
	String thum_img =""; // 썸네일 이미지.
	int price;
	String pay_date= ""; //날자
	
	public SellProductDTO_gy(){}


	public SellProductDTO_gy(String title, String store_name, int delivery_state, int item_no, String thum_img,
			int price, String pay_date) {
		super();
		this.title = title;
		this.store_name = store_name;
		this.delivery_state = delivery_state;
		this.item_no = item_no;
		this.thum_img = thum_img;
		this.price = price;
		this.pay_date = pay_date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getStore_name() {
		return store_name;
	}


	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}


	public int getDelivery_state() {
		return delivery_state;
	}


	public void setDelivery_state(int delivery_state) {
		this.delivery_state = delivery_state;
	}


	public int getItem_no() {
		return item_no;
	}


	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}


	public String getThum_img() {
		return thum_img;
	}


	public void setThum_img(String thum_img) {
		this.thum_img = thum_img;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getPay_date() {
		return pay_date;
	}


	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}



}
