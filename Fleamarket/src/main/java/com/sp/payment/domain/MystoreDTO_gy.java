package com.sp.payment.domain;

import java.io.Serializable;

public class MystoreDTO_gy implements Serializable {
	
	int Store_No;
	String Store_Name;
	String Member_Email;
	String Store_Contents;
	
	
	public MystoreDTO_gy(){}
	
	
	
	public MystoreDTO_gy(int store_No, String store_Name, String member_Email, String store_Contents) {
		super();
		Store_No = store_No;
		Store_Name = store_Name;
		Member_Email = member_Email;
		Store_Contents = store_Contents;
	}



	public int getStore_No() {
		return Store_No;
	}
	public void setStore_No(int store_No) {
		Store_No = store_No;
	}
	public String getStore_Name() {
		return Store_Name;
	}
	public void setStore_Name(String store_Name) {
		Store_Name = store_Name;
	}
	public String getMember_Email() {
		return Member_Email;
	}
	public void setMember_Email(String member_Email) {
		Member_Email = member_Email;
	}
	public String getStore_Contents() {
		return Store_Contents;
	}
	public void setStore_Contents(String store_Contents) {
		Store_Contents = store_Contents;
	}

}
