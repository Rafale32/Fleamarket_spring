package com.sp.memManage.domain;

import java.io.Serializable;

public class MemManageDTO implements Serializable { // 마이바티스는 DTO 로 사용하는 객체 무조건
	// 시리얼라이즈 필수적으로 해줘야함
	
	private Integer member_no; //멤버 번호
	private String member_email; // 이메일
	private String member_pw; // 패스워드
	private String member_name; // 이름
	private String member_phone; // 전화번호
	private String member_address; // 주소
	private String member_address2; // 상세주소
	private Integer member_point; // 포인트
	private String member_state; // 회원 상태
	private String member_stop_start_date; // 정지 시작일
	private String member_stop_end; // 정지 종료일
	private Integer member_admin; // 관리자 상태확인

	public Integer getMember_no(){
		return member_no;
	}
	
	public void setMember_no(Integer member_no){
		this.member_no = member_no;
	}
	
	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_address2() {
		return member_address2;
	}

	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}

	public Integer getMember_point() {
		return member_point;
	}

	public void setMember_point(Integer member_point) {
		this.member_point = member_point;
	}

	public String getMember_state() {
		return member_state;
	}

	public void setMember_state(String member_state) {
		this.member_state = member_state;
	}

	public String getMember_stop_start_date() {
		return member_stop_start_date;
	}

	public void setMember_stop_start_date(String member_stop_start_date) {
		this.member_stop_start_date = member_stop_start_date;
	}

	public String getMember_stop_end() {
		return member_stop_end;
	}

	public void setMember_stop_end(String member_stop_end) {
		this.member_stop_end = member_stop_end;
	}

	public Integer getMember_admin() {
		return member_admin;
	}

	public void setMember_admin(Integer member_admin) {
		this.member_admin = member_admin;
	}

}
