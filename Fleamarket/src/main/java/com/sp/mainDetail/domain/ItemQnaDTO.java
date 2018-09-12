package com.sp.mainDetail.domain;

import java.io.Serializable;

public class ItemQnaDTO implements Serializable{
  private int item_qna_no;
  private int itemboard_no;
  private int store_no;
  private String store_name;
  private String item_qna_contents;
  private String item_qna_date;
  private String member_no;
  
  public ItemQnaDTO(){}

	public ItemQnaDTO(int item_qna_no, int itemboard_no, int store_no, String store_name, String item_qna_contents,
			String item_qna_date, String member_no) {
		super();
		this.item_qna_no = item_qna_no;
		this.itemboard_no = itemboard_no;
		this.store_no = store_no;
		this.store_name = store_name;
		this.item_qna_contents = item_qna_contents;
		this.item_qna_date = item_qna_date;
		this.member_no = member_no;
	}

	public int getItem_qna_no() {
		return item_qna_no;
	}

	public void setItem_qna_no(int item_qna_no) {
		this.item_qna_no = item_qna_no;
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

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getItem_qna_contents() {
		return item_qna_contents;
	}

	public void setItem_qna_contents(String item_qna_contents) {
		this.item_qna_contents = item_qna_contents;
	}

	public String getItem_qna_date() {
		return item_qna_date;
	}

	public void setItem_qna_date(String item_qna_date) {
		this.item_qna_date = item_qna_date;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	
  
}
