package com.sp.mainDetail.domain;

public class PageMaker_jy {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	private Criteria_jy cri;
	
	public void setCri(Criteria_jy cri){
		this.cri = cri;
	}
}
