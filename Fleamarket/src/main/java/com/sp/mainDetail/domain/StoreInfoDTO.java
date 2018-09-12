package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;

public class StoreInfoDTO implements Serializable{
  private int itemboard_no;
  private String member_no;
  private int itemboard_viewcount;
  private String store_open_date;
  private String store_name;
  private int store_no;
  private String store_contents;
  private String member_name;
  private int itemCount;
  private List<ItemDetailDTO> itemList;
  
  public StoreInfoDTO(){}

	public StoreInfoDTO(int itemboard_no, String member_no, int itemboard_viewcount, String store_open_date,
			String store_name, int store_no, String store_contents, String member_name, int itemCount,
			List<ItemDetailDTO> itemList) {
		super();
		this.itemboard_no = itemboard_no;
		this.member_no = member_no;
		this.itemboard_viewcount = itemboard_viewcount;
		this.store_open_date = store_open_date;
		this.store_name = store_name;
		this.store_no = store_no;
		this.store_contents = store_contents;
		this.member_name = member_name;
		this.itemCount = itemCount;
		this.itemList = itemList;
	}

	public int getItemboard_no() {
		return itemboard_no;
	}

	public void setItemboard_no(int itemboard_no) {
		this.itemboard_no = itemboard_no;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public int getItemboard_viewcount() {
		return itemboard_viewcount;
	}

	public void setItemboard_viewcount(int itemboard_viewcount) {
		this.itemboard_viewcount = itemboard_viewcount;
	}

	public String getStore_open_date() {
		return store_open_date;
	}

	public void setStore_open_date(String store_open_date) {
		this.store_open_date = store_open_date;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public int getStore_no() {
		return store_no;
	}

	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}

	public String getStore_contents() {
		return store_contents;
	}

	public void setStore_contents(String store_contents) {
		this.store_contents = store_contents;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public List<ItemDetailDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDetailDTO> itemList) {
		this.itemList = itemList;
	}

}
