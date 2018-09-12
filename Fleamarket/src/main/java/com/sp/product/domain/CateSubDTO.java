package com.sp.product.domain;

import java.io.Serializable;

public class CateSubDTO implements Serializable{
	private Integer sub_No;
	private Integer category_No;
	private String sub_Title;
	
	public CateSubDTO() {	}
	
	public Integer getSub_No() {
		return sub_No;
	}
	public void setSub_No(Integer sub_No) {
		this.sub_No = sub_No;
	}
	public Integer getCategory_No() {
		return category_No;
	}
	public void setCategory_No(Integer category_No) {
		this.category_No = category_No;
	}
	public String getSub_Title() {
		return sub_Title;
	}
	public void setSub_Title(String sub_Title) {
		this.sub_Title = sub_Title;
	}
	@Override
	public String toString() {
		return "CateSubDTO [sub_No=" + sub_No + ", category_No=" + category_No + ", sub_Title=" + sub_Title + "]";
	}
	
	
}
