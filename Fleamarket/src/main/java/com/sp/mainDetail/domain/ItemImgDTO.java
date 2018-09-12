package com.sp.mainDetail.domain;

import java.io.Serializable;

public class ItemImgDTO implements Serializable{
  private int itemboard_no;
  private int img_no;
  private String thum_img;
  private String big_img; 
  
  public ItemImgDTO(){}

  public ItemImgDTO(int itemboard_no, int img_no, String thum_img, String big_img) {
    super();
    this.itemboard_no = itemboard_no;
    this.img_no = img_no;
    this.thum_img = thum_img;
    this.big_img = big_img;
  }

  public int getItemboard_no() {
    return itemboard_no;
  }

  public void setItemboard_no(int itemboard_no) {
    this.itemboard_no = itemboard_no;
  }

  public int getimg_no() {
    return img_no;
  }

  public void setimg_no(int img_no) {
    this.img_no = img_no;
  }

  public String getThum_img() {
    return thum_img;
  }

  public void setThum_img(String thum_img) {
    this.thum_img = thum_img;
  }

  public String getBig_img() {
    return big_img;
  }

  public void setBig_img(String big_img) {
    this.big_img = big_img;
  }
  
  
}
