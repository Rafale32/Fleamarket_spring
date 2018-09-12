package com.sp.mainDetail.domain;

public class Criteria {
	private int page;
	private int perPageNum;

	public Criteria(){
		this.page = 1;
		this.perPageNum = 5;
	}
	
	public void setPage(int page){
		if(page <= 0){
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum){
		if(perPageNum <= 0 || perPageNum > 50){
			this.perPageNum = 5;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage(){
		return page;
	}
	
	public int getPageStart(){
		return (this.page -1) * perPageNum;
	}
	
	
}
