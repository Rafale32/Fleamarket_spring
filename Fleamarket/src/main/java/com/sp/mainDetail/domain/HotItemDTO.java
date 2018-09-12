package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;

public class HotItemDTO implements Serializable{
  private int itemboard_no; //상품번호
  private String category_title;  //대 카테고리 이름
  private String sub_title; //소 카테고리 이름
  private String title; //상품 이름
  private int price; //가격
  private String itemboard_date; //작성일자
  private int delivery_fee; //무료배송 여부
  private int hits; //조회수
  private int ranking; //조회수 순위
  private int delivery_date;
  private List<ItemImgDTO> imgList;
  
  public HotItemDTO(){}

  public HotItemDTO(int itemboard_no, String category_title, String sub_title, String title, int price,
      String itemboard_date, int delivery_fee, int hits, int ranking, int delivery_date, List<ItemImgDTO> imgList) {
    super();
    this.itemboard_no = itemboard_no;
    this.category_title = category_title;
    this.sub_title = sub_title;
    this.title = title;
    this.price = price;
    this.itemboard_date = itemboard_date;
    this.delivery_fee = delivery_fee;
    this.hits = hits;
    this.ranking = ranking;
    this.delivery_date = delivery_date;
    this.imgList = imgList;
  }

  public int getDelivery_date() {
    return delivery_date;
  }

  public void setDelivery_date(int delivery_date) {
    this.delivery_date = delivery_date;
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

  public List<ItemImgDTO> getImgList() {
    return imgList;
  }

  public void setImgList(List<ItemImgDTO> imgList) {
    this.imgList = imgList;
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

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }

  public int getRanking() {
    return ranking;
  }

  public void setRanking(int ranking) {
    this.ranking = ranking;
  }

  public int getItemboard_no() {
    return itemboard_no;
  }

  public void setItemboard_no(int itemboard_no) {
    this.itemboard_no = itemboard_no;
  }

}
