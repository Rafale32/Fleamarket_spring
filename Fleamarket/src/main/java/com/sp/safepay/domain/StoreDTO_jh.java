package com.sp.safepay.domain;

public class StoreDTO_jh {
  private int store_no;
  private String store_name;
  private String email;
  private String open_date;
  private String contents;
  private int hits;
  
  public StoreDTO_jh(){}

  public int getStore_no() {
    return store_no;
  }

  public void setStore_no(int store_no) {
    this.store_no = store_no;
  }

  public String getStore_name() {
    return store_name;
  }

  public void setStore_name(String store_name) {
    this.store_name = store_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOpen_date() {
    return open_date;
  }

  public void setOpen_date(String open_date) {
    this.open_date = open_date;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }
  
  
  
}
