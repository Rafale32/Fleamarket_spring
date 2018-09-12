package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;


public class ItemDetailDTO implements Serializable{ //마이바티스는 DTO 로 사용하는 객체 무조건 시리얼라이즈 필수적으로 해줘야함  
	private int itemboard_no;
  private String itemboard_title;
	private int item_price;
	private int fav_no;
	private int itemboard_viewcount;
	private String itemboard_date;
	private int item_state;
	private int itemboard_change_B;
	private int item_delivery_B;
	private int item_delivery_state;
	private String itemboard_local;
	private String itemboard_contents;
	private String category_title;
	private String sub_title;
	private String tag_name;
	private List<String> tagList;


	private List<ItemImgDTO> imgList;

	private String thum_img;
	private int item_no; //재헌 요청으로 추가
	
	public ItemDetailDTO(){}

	public ItemDetailDTO(int itemboard_no, String itemboard_title, int item_price, int fav_no,
			int itemboard_viewcount, String itemboard_date, int item_state, int itemboard_change_B, int item_delivery_B,
			int item_delivery_state, String itemboard_local, String itemboard_contents, String category_title,
			String sub_title, String tag_name, List<String> tagList, List<ItemImgDTO> imgList, String thum_img, int item_no) {
		super();
		this.itemboard_no = itemboard_no;
		this.itemboard_title = itemboard_title;
		this.item_price = item_price;
		this.fav_no = fav_no;
		this.itemboard_viewcount = itemboard_viewcount;
		this.itemboard_date = itemboard_date;
		this.item_state = item_state;
		this.itemboard_change_B = itemboard_change_B;
		this.item_delivery_B = item_delivery_B;
		this.item_delivery_state = item_delivery_state;
		this.itemboard_local = itemboard_local;
		this.itemboard_contents = itemboard_contents;
		this.category_title = category_title;
		this.sub_title = sub_title;
		this.tag_name = tag_name;
		this.tagList = tagList;
		this.imgList = imgList;
		this.thum_img = thum_img;
		this.item_no = item_no;
	}

	public int getItemboard_no() {
		return itemboard_no;
	}

	public void setItemboard_no(int itemboard_no) {
		this.itemboard_no = itemboard_no;
	}

	public String getItemboard_title() {
		return itemboard_title;
	}

	public void setItemboard_title(String itemboard_title) {
		this.itemboard_title = itemboard_title;
	}

	public int getitem_price() {
		return item_price;
	}

	public void setitem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getFav_no() {
		return fav_no;
	}

	public void setFav_no(int fav_no) {
		this.fav_no = fav_no;
	}

	public int getItemboard_viewcount() {
		return itemboard_viewcount;
	}

	public void setItemboard_viewcount(int itemboard_viewcount) {
		this.itemboard_viewcount = itemboard_viewcount;
	}

	public String getItemboard_date() {
		return itemboard_date;
	}

	public void setItemboard_date(String itemboard_date) {
		this.itemboard_date = itemboard_date;
	}

	public int getItem_state() {
		return item_state;
	}

	public void setItem_state(int item_state) {
		this.item_state = item_state;
	}

	public int getItemboard_change_B() {
		return itemboard_change_B;
	}

	public void setItemboard_change_B(int itemboard_change_B) {
		this.itemboard_change_B = itemboard_change_B;
	}

	public int getItem_delivery_B() {
		return item_delivery_B;
	}

	public void setItem_delivery_B(int item_delivery_B) {
		this.item_delivery_B = item_delivery_B;
	}

	public int getItem_delivery_state() {
		return item_delivery_state;
	}

	public void setItem_delivery_state(int item_delivery_state) {
		this.item_delivery_state = item_delivery_state;
	}

	public String getItemboard_local() {
		return itemboard_local;
	}

	public void setItemboard_local(String itemboard_local) {
		this.itemboard_local = itemboard_local;
	}

	public String getItemboard_contents() {
		return itemboard_contents;
	}

	public void setItemboard_contents(String itemboard_contents) {
		this.itemboard_contents = itemboard_contents;
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

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public List<ItemImgDTO> getImgList() {
		return imgList;
	}

	public void setImgList(List<ItemImgDTO> imgList) {
		this.imgList = imgList;
	}

	public String getThum_img() {
		return thum_img;
	}

	public void setThum_img(String thum_img) {
		this.thum_img = thum_img;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	
}
