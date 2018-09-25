package com.sp.payment.domain;

import java.io.Serializable;

public class MystoreReviewDTO_gy implements Serializable {
	
	int store_no;
	String pay_date;
	String review_contents;
	String store_name;
	String member_email;
	int review_star;
	int member_no;
	String member_name;
	String itemboard_title;
	String thum_img;
	int item_no;
	int itemboard_no;
	
	 
	
	
	public MystoreReviewDTO_gy(){}




	public MystoreReviewDTO_gy(int store_no, String pay_date, String review_contents, String store_name,
			String member_email, int review_star, int member_no, String member_name, String itemboard_title,
			String thum_img, int item_no, int itemboard_no) {
		super();
		this.store_no = store_no;
		this.pay_date = pay_date;
		this.review_contents = review_contents;
		this.store_name = store_name;
		this.member_email = member_email;
		this.review_star = review_star;
		this.member_no = member_no;
		this.member_name = member_name;
		this.itemboard_title = itemboard_title;
		this.thum_img = thum_img;
		this.item_no = item_no;
		this.itemboard_no = itemboard_no;
	}






	public int getItemboard_no() {
		return itemboard_no;
	}






	public void setItemboard_no(int itemboard_no) {
		this.itemboard_no = itemboard_no;
	}






	@Override
	public String toString() {
		return "MystoreReviewDTO_gy [store_no=" + store_no + ", pay_date=" + pay_date + ", review_contents="
				+ review_contents + ", store_name=" + store_name + ", member_email=" + member_email + ", review_star="
				+ review_star + ", member_no=" + member_no + ", member_name=" + member_name + ", itemboard_title="
				+ itemboard_title + ", thum_img=" + thum_img + ", item_no=" + item_no + ", itemboard_no=" + itemboard_no
				+ "]";
	}






	public int getItem_no() {
		return item_no;
	}




	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}




	public String getItemboard_title() {
		return itemboard_title;
	}




	public void setItemboard_title(String itemboard_title) {
		this.itemboard_title = itemboard_title;
	}




	public String getThum_img() {
		return thum_img;
	}




	public void setThum_img(String thum_img) {
		this.thum_img = thum_img;
	}




	public int getStore_no() {
		return store_no;
	}



	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}



	public String getPay_date() {
		return pay_date;
	}



	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}



	public String getReview_contents() {
		return review_contents;
	}



	public void setReview_contents(String review_contents) {
		this.review_contents = review_contents;
	}



	public String getStore_name() {
		return store_name;
	}



	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}



	public String getMember_email() {
		return member_email;
	}



	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}



	public int getReview_star() {
		return review_star;
	}



	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}



	public int getMember_no() {
		return member_no;
	}



	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}



	public String getMember_name() {
		return member_name;
	}



	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	
	
	
}
