package com.sp.safepay.domain;

import java.io.Serializable;

public class SpellDTO_jh implements Serializable {
  private int spell_no;       // 주문번호
  private String spell_date;  // 주문날짜
  private String email;       // 구매자 이메일
  private int item_no;        // 상품번호
  
  public SpellDTO_jh(){}

  public SpellDTO_jh(int spell_no, String spell_date, String email, int item_no) {
    super();
    this.spell_no = spell_no;
    this.spell_date = spell_date;
    this.email = email;
    this.item_no = item_no;
  }

  public int getSpell_no() {
    return spell_no;
  }

  public void setSpell_no(int spell_no) {
    this.spell_no = spell_no;
  }

  public String getSpell_date() {
    return spell_date;
  }

  public void setSpell_date(String spell_date) {
    this.spell_date = spell_date;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getItem_no() {
    return item_no;
  }

  public void setItem_no(int item_no) {
    this.item_no = item_no;
  }
  
  
  

}
