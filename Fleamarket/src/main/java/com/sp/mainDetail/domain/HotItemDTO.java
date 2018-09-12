package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;

public class HotItemDTO implements Serializable{
  private int itemboard_no; //상품번호
  private String category_title;  //대 카테고리 이름
  private String sub_title; //소 카테고리 이름
  private String itemboard_title; //상품 이름
  private int item_price; //가격
  private String itemboard_date; //작성일자
  private int item_delivery_B; //무료배송 여부
  private int itemboard_viewcount; //조회수
  private int ranking; //조회수 순위
  private int delivery_date;
  private List<ItemImgDTO> imgList;
  
  public HotItemDTO(){}

	public HotItemDTO(int itemboard_no, String category_title, String sub_title, String itemboard_title, int item_price,
			String itemboard_date, int item_delivery_B, int itemboard_viewcount, int ranking, int delivery_date,
			List<ItemImgDTO> imgList) {
		super();
		this.itemboard_no = itemboard_no;
		this.category_title = category_title;
		this.sub_title = sub_title;
		this.itemboard_title = itemboard_title;
		this.item_price = item_price;
		this.itemboard_date = itemboard_date;
		this.item_delivery_B = item_delivery_B;
		this.itemboard_viewcount = itemboard_viewcount;
		this.ranking = ranking;
		this.delivery_date = delivery_date;
		this.imgList = imgList;
	}

	public int getItemboard_no() {
		return itemboard_no;
	}

	public void setItemboard_no(int itemboard_no) {
		this.itemboard_no = itemboard_no;
	}

	public String getCategory_title() {
		return category_title;
	}

	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
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

	public int getItemboard_viewcount() {
		return itemboard_viewcount;
	}

	public void setItemboard_viewcount(int itemboard_viewcount) {
		this.itemboard_viewcount = itemboard_viewcount;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(int delivery_date) {
		this.delivery_date = delivery_date;
	}

	public List<ItemImgDTO> getImgList() {
		return imgList;
	}

	public void setImgList(List<ItemImgDTO> imgList) {
		this.imgList = imgList;
	}
  
}
