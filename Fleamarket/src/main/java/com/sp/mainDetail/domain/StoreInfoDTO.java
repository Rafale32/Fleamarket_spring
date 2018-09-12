package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;

public class StoreInfoDTO implements Serializable{
  private int itemboard_no;
  private String email;
  private int hits;
  private String open_date;
  private String store_name;
  private int store_no;
  private String contents;
  private String name;
  private int itemCount;
  private List<ItemDetailDTO> itemList;
  
  public StoreInfoDTO(){}

  public StoreInfoDTO(int itemboard_no, String email, int hits, String open_date, String store_name, int store_no,
      String contents, String name, int itemCount, List<ItemDetailDTO> itemList) {
    super();
    this.itemboard_no = itemboard_no;
    this.email = email;
    this.hits = hits;
    this.open_date = open_date;
    this.store_name = store_name;
    this.store_no = store_no;
    this.contents = contents;
    this.name = name;
    this.itemCount = itemCount;
    this.itemList = itemList;
  }

  public int getItemboard_no() {
    return itemboard_no;
  }

  public void setItemboard_no(int itemboard_no) {
    this.itemboard_no = itemboard_no;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }

  public String getOpen_date() {
    return open_date;
  }

  public void setOpen_date(String open_date) {
    this.open_date = open_date;
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

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
}
