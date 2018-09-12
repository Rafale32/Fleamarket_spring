package com.sp.mainDetail.domain;

public class MemberDTO {
	private String email; // 현재 로그인 중인 ID 로그인중이 아니라면 null 이겠지
	private String name; // 현재 로그인중인 회원의 닉네임 로그인 중이 아니면 null 이겠지
	
	public MemberDTO(){}

  public MemberDTO(String email, String name) {
    super();
    this.email = email;
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
	
}
