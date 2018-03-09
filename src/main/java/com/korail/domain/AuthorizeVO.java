package com.korail.domain;


public class AuthorizeVO {
	private String authorize_Id;
	private String authorize_Mail;
	private String authorize_Code;
	private String authorize_Date;
	public String getAuthorize_Id() {
		return authorize_Id;
	}
	public void setAuthorize_Id(String authorize_Id) {
		this.authorize_Id = authorize_Id;
	}
	public String getAuthorize_Mail() {
		return authorize_Mail;
	}
	public void setAuthorize_Mail(String authorize_Mail) {
		this.authorize_Mail = authorize_Mail;
	}
	public String getAuthorize_Code() {
		return authorize_Code;
	}
	public void setAuthorize_Code(String authorize_Code) {
		this.authorize_Code = authorize_Code;
	}
	public String getAuthorize_Date() {
		return authorize_Date;
	}
	public void setAuthorize_Date(String authorize_Date) {
		this.authorize_Date = authorize_Date;
	}
	@Override
	public String toString() {
		return "AuthorizeVO [authorize_Id=" + authorize_Id + ", authorize_Mail=" + authorize_Mail + ", authorize_Code="
				+ authorize_Code + ", authorize_Date=" + authorize_Date + "]";
	}
	
	
	
}
