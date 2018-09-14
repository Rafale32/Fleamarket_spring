package com.sp.product.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ItemDTO implements Serializable { // 마이바티스는 DTO 로 사용하는 객체 무조건
                                    // 시리얼라이즈 필수적으로 해줘야함

   // 이미지 여러게 담는곳
   private List<ItemImg> itemImgList;

   private String[] files;

   private String member_email;// 현재 사용자 아이디
   private int sub_No; // 섭카테고리 넘버
   private int category_No;// 대카테고리 넘버
   private String category_Title; // 대 카테고리 이름 CATEGORY_TITLE
   private String sub_Title; // 소 카테고리 이름
   private Date itemboard_Date; // 등록일자
   private String itemboard_Local; // 거래지역
   private String itemboard_Title; // 상품게시판 의 상품 제목
   private String itemboard_Contents; // 상품게시판의 상품설명 //여기에 잠시 담자 썸네일 이미지 하나짜리
   private String tag_Name;// 태그
   private int itemboard_Viewcount; // 조회수
   private int itemboard_Recommend_b; // 추천상품 구현안할듯 지금은
   private int itemboard_Change_b; // 교환 가능 여부

   private boolean deliveryIs;// 택배비포함여부 뷰단값
   private boolean changeIs;// 교환 가능 뷰단 값

   private int item_No; // 상품 번호
   private int itemboard_No = 0; // 게시판글 번호
   private int store_No; // 상점 번호
   private int itemboard_Delete_B;// 삭제 유무

   private int price; // 물품 가격
   private int item_Price;
   
   private String thumImg;//하나의 섬네일 이미지 검색에서 담기위한놈

   private int favCount; // 다른사람이 찜 한 횟수

   private int itemQnaCount; // 상품문의 리플 수

   private int item_State; // 상품의 상태 새상품 상중하
   private int item_Delivery_B;// 배송비 포함 여부
   private int item_Amount; // 상품 수량

   // 20180818 재헌 상점이름, 배송 유무
   private String store_Name;
   // private String delivery_fee;
   // 20180818 재헌 배송진행상태
   private int item_delivery_State;

   public ItemDTO() {
   }

   public String getThumImg() {
      return thumImg;
   }

   public void setThumImg(String thumImg) {
      this.thumImg = thumImg;
   }

   public List<ItemImg> getItemImgList() {
      return itemImgList;
   }

   public void setItemImgList(List<ItemImg> itemImgList) {
      this.itemImgList = itemImgList;
   }

   public String[] getFiles() {
      return files;
   }

   public void setFiles(String[] files) {
      this.files = files;
   }

   public String getMember_email() {
      return member_email;
   }

   public void setMember_email(String member_email) {
      this.member_email = member_email;
   }

   public int getSub_No() {
      return sub_No;
   }

   public void setSub_No(int sub_No) {
      this.sub_No = sub_No;
   }

   public int getCategory_No() {
      return category_No;
   }

   public void setCategory_No(int category_No) {
      this.category_No = category_No;
   }

   public String getCategory_Title() {
      return category_Title;
   }

   public void setCategory_Title(String category_Title) {
      this.category_Title = category_Title;
   }

   public String getSub_Title() {
      return sub_Title;
   }

   public void setSub_Title(String sub_Title) {
      this.sub_Title = sub_Title;
   }

   public Date getItemboard_Date() {
      return itemboard_Date;
   }

   public void setItemboard_Date(Date itemboard_Date) {
      this.itemboard_Date = itemboard_Date;
   }

   public String getItemboard_Local() {
      return itemboard_Local;
   }

   public void setItemboard_Local(String itemboard_Local) {
      this.itemboard_Local = itemboard_Local;
   }

   public String getItemboard_Title() {
      return itemboard_Title;
   }

   public void setItemboard_Title(String itemboard_Title) {
      this.itemboard_Title = itemboard_Title;
   }

   public String getItemboard_Contents() {
      return itemboard_Contents;
   }

   public void setItemboard_Contents(String itemboard_Contents) {
      this.itemboard_Contents = itemboard_Contents;
   }

   public String getTag_Name() {
      return tag_Name;
   }

   public void setTag_Name(String tag_Name) {
      this.tag_Name = tag_Name;
   }

   public int getItemboard_Viewcount() {
      return itemboard_Viewcount;
   }

   public void setItemboard_Viewcount(int itemboard_Viewcount) {
      this.itemboard_Viewcount = itemboard_Viewcount;
   }

   public int getItemboard_Recommend_b() {
      return itemboard_Recommend_b;
   }

   public void setItemboard_Recommend_b(int itemboard_Recommend_b) {
      this.itemboard_Recommend_b = itemboard_Recommend_b;
   }

   public int getItemboard_Change_b() {
      return itemboard_Change_b;
   }

   public void setItemboard_Change_b(int itemboard_Change_b) {
      this.itemboard_Change_b = itemboard_Change_b;
   }

   public boolean isDeliveryIs() {
      return deliveryIs;
   }

   public void setDeliveryIs(boolean deliveryIs) {
      this.deliveryIs = deliveryIs;
   }

   public boolean isChangeIs() {
      return changeIs;
   }

   public void setChangeIs(boolean changeIs) {
      this.changeIs = changeIs;
   }

   public int getItem_No() {
      return item_No;
   }

   public void setItem_No(int item_No) {
      this.item_No = item_No;
   }

   public int getItemboard_No() {
      return itemboard_No;
   }

   public void setItemboard_No(int itemboard_No) {
      this.itemboard_No = itemboard_No;
   }

   public int getStore_No() {
      return store_No;
   }

   public void setStore_No(int store_No) {
      this.store_No = store_No;
   }

   public int getItemboard_Delete_B() {
      return itemboard_Delete_B;
   }

   public void setItemboard_Delete_B(int itemboard_Delete_B) {
      this.itemboard_Delete_B = itemboard_Delete_B;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getItem_Price() {
      return item_Price;
   }

   public void setItem_Price(int item_Price) {
      this.item_Price = item_Price;
   }

   public int getFavCount() {
      return favCount;
   }

   public void setFavCount(int favCount) {
      this.favCount = favCount;
   }

   public int getItemQnaCount() {
      return itemQnaCount;
   }

   public void setItemQnaCount(int itemQnaCount) {
      this.itemQnaCount = itemQnaCount;
   }

   public int getItem_State() {
      return item_State;
   }

   public void setItem_State(int item_State) {
      this.item_State = item_State;
   }

   public int getItem_Delivery_B() {
      return item_Delivery_B;
   }

   public void setItem_Delivery_B(int item_Delivery_B) {
      this.item_Delivery_B = item_Delivery_B;
   }

   public int getItem_Amount() {
      return item_Amount;
   }

   public void setItem_Amount(int item_Amount) {
      this.item_Amount = item_Amount;
   }

   public String getStore_Name() {
      return store_Name;
   }

   public void setStore_Name(String store_Name) {
      this.store_Name = store_Name;
   }

   public int getItem_delivery_State() {
      return item_delivery_State;
   }

   public void setItem_delivery_State(int item_delivery_State) {
      this.item_delivery_State = item_delivery_State;
   }

   @Override
   public String toString() {
      return "ItemDTO [itemImgList=" + itemImgList + ", files=" + Arrays.toString(files) + ", member_email="
            + member_email + ", sub_No=" + sub_No + ", category_No=" + category_No + ", category_Title="
            + category_Title + ", sub_Title=" + sub_Title + ", itemboard_Date=" + itemboard_Date
            + ", itemboard_Local=" + itemboard_Local + ", itemboard_Title=" + itemboard_Title
            + ", itemboard_Contents=" + itemboard_Contents + ", tag_Name=" + tag_Name + ", itemboard_Viewcount="
            + itemboard_Viewcount + ", itemboard_Recommend_b=" + itemboard_Recommend_b + ", itemboard_Change_b="
            + itemboard_Change_b + ", deliveryIs=" + deliveryIs + ", changeIs=" + changeIs + ", item_No=" + item_No
            + ", itemboard_No=" + itemboard_No + ", store_No=" + store_No + ", itemboard_Delete_B="
            + itemboard_Delete_B + ", price=" + price + ", item_Price=" + item_Price + ", thumImg=" + thumImg
            + ", favCount=" + favCount + ", itemQnaCount=" + itemQnaCount + ", item_State=" + item_State
            + ", item_Delivery_B=" + item_Delivery_B + ", item_Amount=" + item_Amount + ", store_Name=" + store_Name
            + ", item_delivery_State=" + item_delivery_State + "]";
   }

}