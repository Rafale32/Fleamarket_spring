package com.sp.mainDetail.domain;

import java.io.Serializable;

public class FavDTO implements Serializable{
	private int fav_no;
	private int member_no;
	private int itemboard_no;
	
	public FavDTO(){}

	public FavDTO(int fav_no, int member_no, int itemboard_no) {
		super();
		this.fav_no = fav_no;
		this.member_no = member_no;
		this.itemboard_no = itemboard_no;
	}

	public int getFav_no() {
		return fav_no;
	}

	public void setFav_no(int fav_no) {
		this.fav_no = fav_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getItemboard_no() {
		return itemboard_no;
	}

	public void setItemboard_no(int itemboard_no) {
		this.itemboard_no = itemboard_no;
	}
	
	
}
