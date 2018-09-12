package com.sp.payment.domain;

import java.util.List;

public class PaymentPagingDTO_gy {
	
	private List<PuerchaseDTO_gy> list;
	private int requestPage; //현제 페이지
	private int totalPageCount; // 총 페이지수
	private int startPage; // 시작페이지
	private int endPage; // 끝페이지
	
	public PaymentPagingDTO_gy(){}

	public PaymentPagingDTO_gy(List<PuerchaseDTO_gy> list, int requestPage, int totalPageCount, int startPage,
			int endPage) {
		super();
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public List<PuerchaseDTO_gy> getList() {
		return list;
	}

	public void setList(List<PuerchaseDTO_gy> list) {
		this.list = list;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	

}
