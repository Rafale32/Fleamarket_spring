package com.sp.safepay.domain;

import java.io.Serializable;

public class ItemImgDTO_jh implements Serializable{
  private int img_no;       // 이미지번호
  private int itemboard_no; // 게시글번호
  private String thum_img;  // 썸네일이미지 파일명
  private String big_img;   // 이미지 파일명
  
  
  public ItemImgDTO_jh(){}


  public int getImg_no() {
    return img_no;
  }


  public void setImg_no(int img_no) {
    this.img_no = img_no;
  }


  public int getItemboard_no() {
    return itemboard_no;
  }


  public void setItemboard_no(int itemboard_no) {
    this.itemboard_no = itemboard_no;
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
