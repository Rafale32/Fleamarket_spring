package com.sp.board.domain;

import java.io.Serializable;
import java.util.Date;

public class BoardDTO {  
	private int    notice_no;
	private String notice_title;
	private String notice_contents;
	private Date   notice_date;
	private String notice_category;
	
	public BoardDTO(){}
	
	public BoardDTO(int notice_no, String notice_title, String notice_contents,
			Date notice_date, String notice_category) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_contents = notice_contents;
		this.notice_date = notice_date;
		this.notice_category = notice_category;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_contents() {
		return notice_contents;
	}

	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	
	public String getNotice_category() {
		return notice_category;
	}

	public void setNotice_category(String notice_category) {
		this.notice_category = notice_category;
	}

	@Override
	public String toString() {
		return "BoardDTO [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_contents="
				+ notice_contents + ", notice_date=" + notice_date + ", notice_category=" + notice_category + "]";
	}

	
}

