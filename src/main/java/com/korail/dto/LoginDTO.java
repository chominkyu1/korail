package com.korail.dto;

public class LoginDTO {
	private String member_loginid;
	private String member_pw;
	//private boolean useCookie;

	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String member_loginid, String member_pw, boolean useCookie) {
		super();
		this.member_loginid = member_loginid;
		this.member_pw = member_pw;
		//this.useCookie = useCookie;
	}

	public String getMember_loginid() {
		return member_loginid;
	}

	public void setMember_loginid(String member_loginid) {
		this.member_loginid = member_loginid;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	@Override
	public String toString() {
		return "LoginDTO [member_loginid=" + member_loginid + ", member_pw=" + member_pw + "]";
	}

	/*public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}*/

	
	
	
}
