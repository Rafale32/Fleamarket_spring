package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;

public class RecommendDTO implements Serializable{
  private int item_no;
  private String title;
  private int price;
  private String itemboard_date;
  private int delivery_fee;
  private int itemboard_no;
  private int item_state;
  private List<ItemImgDTO> imgList;
  
  public RecommendDTO(){}

  public RecommendDTO(int item_no, String title, int price, String itemboard_date, int delivery_fee, int itemboard_no,
      int item_state, List<ItemImgDTO> imgList) {
    super();
    this.item_no = item_no;
    this.title = title;
    this.price = price;
    this.itemboard_date = itemboard_date;
    this.delivery_fee = delivery_fee;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getItemboard_date() {
    return itemboard_date;
  }

  public void setItemboard_date(String itemboard_date) {
    this.itemboard_date = itemboard_date;
  }

  public int getDelivery_fee() {
    return delivery_fee;
  }

  public void setDelivery_fee(int delivery_fee) {
    this.delivery_fee = delivery_fee;
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
