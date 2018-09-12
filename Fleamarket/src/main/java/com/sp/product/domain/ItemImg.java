package com.sp.product.domain;

import java.io.Serializable;

public class ItemImg implements Serializable{
	
	private String thum_Img;
	private String big_Img;
	
	
	public String getThum_Img() {
		return thum_Img;
	}
	public void setThum_Img(String thum_Img) {
		this.thum_Img = thum_Img;
	}
	public String getBig_Img() {
		return big_Img;
	}
	public void setBig_Img(String big_Img) {
		this.big_Img = big_Img;
	}
	
}
