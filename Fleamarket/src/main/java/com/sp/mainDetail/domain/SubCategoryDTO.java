package com.sp.mainDetail.domain;

import java.io.Serializable;

public class SubCategoryDTO implements Serializable{
  private int category_no;
  private int sub_no;
  private String sub_title;
  
  public SubCategoryDTO(){}

  public SubCategoryDTO(int category_no, int sub_no, String sub_title) {
    super();
    this.category_no = category_no;
    this.sub_no = sub_no;
    this.sub_title = sub_title;
  }

  public int getCategory_no() {
    return category_no;
  }

  public void setCategory_no(int category_no) {
    this.category_no = category_no;
  }

  public int getSub_no() {
    return sub_no;
  }

  public void setSub_no(int sub_no) {
    this.sub_no = sub_no;
  }

  public String getSub_title() {
    return sub_title;
  }

  public void setSub_title(String sub_title) {
    this.sub_title = sub_title;
  }
  
}
