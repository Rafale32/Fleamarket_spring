package com.sp.mainDetail.domain;

import java.io.Serializable;

public class ItemQnaDTO implements Serializable{
  private int item_qna_no;
  private int itemboard_no;
  private int store_no;
  private String store_name;
  private String contents;
  private String qna_date;
  private String email;
  
  public ItemQnaDTO(){}


  public ItemQnaDTO(int item_qna_no, int itemboard_no, int store_no, String store_name, String contents,
      String qna_date, String email) {
    super();
    this.item_qna_no = item_qna_no;
    this.itemboard_no = itemboard_no;
    this.store_no = store_no;
    this.store_name = store_name;
    this.contents = contents;
    this.qna_date = qna_date;
    this.email = email;
  }

  public String getstore_name() {
    return store_name;
  }

  public void setstore_name(String store_name) {
    this.store_name = store_name;
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

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public String getQna_date() {
    return qna_date;
  }

  public void setQna_date(String qna_date) {
    this.qna_date = qna_date;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getStore_no() {
    return store_no;
  }

  public void setStore_no(int store_no) {
    this.store_no = store_no;
  }

  @Override
  public String toString() {
    return "ItemQnaDTO [item_qna_no=" + item_qna_no + ", itemboard_no=" + itemboard_no + ", store_no=" + store_no
        + ", contents=" + contents + ", qna_date=" + qna_date + ", email=" + email + "]";
  }
  
}
