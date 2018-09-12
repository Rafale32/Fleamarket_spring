package com.sp.mainDetail.domain;

import java.io.Serializable;
import java.util.List;

public class HotListDTO implements Serializable{
  private int category_no;  //대 카테고리 번호
  private String category_title;  //대 카테고리 이름
  private List<HotItemDTO> hotList; //대 카테고리별 인기상품정보 리스트
  
  public HotListDTO(){}

  public HotListDTO(int category_no, String category_title, List<HotItemDTO> hotList) {
    super();
    this.category_no = category_no;
    this.category_title = category_title;
    this.hotList = hotList;
  }

  public int getCategory_no() {
    return category_no;
  }

  public void setCategory_no(int category_no) {
    this.category_no = category_no;
  }

  public String getCategory_title() {
    return category_title;
  }

  public void setCategory_title(String category_title) {
    this.category_title = category_title;
  }

  public List<HotItemDTO> getHotList() {
    return hotList;
  }

  public void setHotItemList(List<HotItemDTO> hotList) {
    this.hotList = hotList;
  }

  
  
}
