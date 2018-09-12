package com.sp.board.domain;

import java.io.Serializable;

public class MyBoard implements Serializable {
	private int notice_no;
	private String category;
	private String title;
	private String contents;
	private String notice_date;
	
	public MyBoard(){}

	public MyBoard(int notice_no, String category, String title, String contents, String notice_date) {
		super();
		this.notice_no = notice_no;
		this.category = category;
		this.title = title;
		this.contents = contents;
		this.notice_date = notice_date;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}

	@Override
	public String toString() {
		return "myBoard [notice_no=" + notice_no + ", category=" + category + ", title=" + title + ", contents="
				+ contents + ", notice_date=" + notice_date + "]";
	}
	
	
}
