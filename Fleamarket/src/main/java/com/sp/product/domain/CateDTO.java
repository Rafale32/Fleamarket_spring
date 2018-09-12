package com.sp.product.domain;

import java.io.Serializable;
import java.util.List;

public class CateDTO implements Serializable {
	private int category_no; // 대 카테고리 번호
	private String category_title; // 대 카테고리 이름

	public CateDTO() {
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

}
