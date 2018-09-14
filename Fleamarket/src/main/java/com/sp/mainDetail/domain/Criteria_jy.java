package com.sp.mainDetail.domain;

public class Criteria_jy {
	private int page;
	private int perPageNum;

	public Criteria_jy(){
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
	
	//method for MyBatis SQL Mapper -
	public int getPageStart(){
		return (this.page -1) * perPageNum;
	}
	
//method for MyBatis SQL Mapper -
	public int getPerPageNum(){
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria_jy [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}
