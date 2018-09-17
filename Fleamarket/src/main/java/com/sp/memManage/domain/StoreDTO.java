package com.sp.memManage.domain;

import java.io.Serializable;

public class StoreDTO implements Serializable {
	
	private int store_no; //스토어 넘버
	private String store_name; // 스토어 이름
	private String store_contents; //스토어 소개글
	private String store_open_date; //스토어 오픈일
	private int store_viewcount; //스토어 방문수
	private String member_no; //맴버 회원번호
	private String member_email;// 멤버 이메일
	
	public StoreDTO(){}

	public StoreDTO(int store_no, String store_name, String store_contents, String store_open_date, int store_viewcount,
			String member_no, String member_email) {
		super();
		this.store_no = store_no;
		this.store_name = store_name;
		this.store_contents = store_contents;
		this.store_open_date = store_open_date;
		this.store_viewcount = store_viewcount;
		this.member_no = member_no;
		this.member_email = member_email;
	}

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

	public String getStore_contents() {
		return store_contents;
	}

	public void setStore_contents(String store_contents) {
		this.store_contents = store_contents;
	}

	public String getStore_open_date() {
		return store_open_date;
	}

	public void setStore_open_date(String store_open_date) {
		this.store_open_date = store_open_date;
	}

	public int getStore_viewcount() {
		return store_viewcount;
	}

	public void setStore_viewcount(int store_viewcount) {
		this.store_viewcount = store_viewcount;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	@Override
	public String toString() {
		return "StoreDTO [store_no=" + store_no + ", store_name=" + store_name + ", store_contents=" + store_contents
				+ ", store_open_date=" + store_open_date + ", store_viewcount=" + store_viewcount + ", member_no="
				+ member_no + ", member_email=" + member_email + "]";
	}

}