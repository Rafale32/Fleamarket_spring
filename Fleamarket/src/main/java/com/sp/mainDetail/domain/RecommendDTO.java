package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;

public class RecommendDTO implements Serializable{
  private int item_no;
  private String itemboard_title;
  private int item_price;
  private String itemboard_date;
  private int item_delivery_B;
  private int itemboard_no;
  private int item_state;
  private List<ItemImgDTO> imgList;
  
  public RecommendDTO(){}

	public RecommendDTO(int item_no, String itemboard_title, int item_price, String itemboard_date, int item_delivery_B,
			int itemboard_no, int item_state, List<ItemImgDTO> imgList) {
		super();
		this.item_no = item_no;
		this.itemboard_title = itemboard_title;
		this.item_price = item_price;
		this.itemboard_date = itemboard_date;
		this.item_delivery_B = item_delivery_B;
		this.itemboard_no = itemboard_no;
		this.item_state = item_state;
		this.imgList = imgList;
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

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItemboard_date() {
		return itemboard_date;
	}

	public void setItemboard_date(String itemboard_date) {
		this.itemboard_date = itemboard_date;
	}

	public int getItem_delivery_B() {
		return item_delivery_B;
	}

	public void setItem_delivery_B(int item_delivery_B) {
		this.item_delivery_B = item_delivery_B;
	}

	public int getItemboard_no() {
		return itemboard_no;
	}

	public void setItemboard_no(int itemboard_no) {
		this.itemboard_no = itemboard_no;
	}

	public int getItem_state() {
		return item_state;
	}

	public void setItem_state(int item_state) {
		this.item_state = item_state;
	}

	public List<ItemImgDTO> getImgList() {
		return imgList;
	}

	public void setImgList(List<ItemImgDTO> imgList) {
		this.imgList = imgList;
	}

}
