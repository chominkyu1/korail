package com.korail.domain;


public class AuthorizeVO {
	private String authorie_Id;
	private String authorie_Mail;
	private String authorie_Code;
	private String authorie_Date;
	
	
	public String getAuthorie_Id() {
		return authorie_Id;
	}
	public void setAuthorie_Id(String authorie_Id) {
		this.authorie_Id = authorie_Id;
	}
	public String getAuthorie_Mail() {
		return authorie_Mail;
	}
	public void setAuthorie_Mail(String authorie_Mail) {
		this.authorie_Mail = authorie_Mail;
	}
	public String getAuthorie_Code() {
		return authorie_Code;
	}
	public void setAuthorie_Code(String authorie_Code) {
		this.authorie_Code = authorie_Code;
	}
	public String getAuthorie_Date() {
		return authorie_Date;
	}
	public void setAuthorie_Date(String authorie_Date) {
		this.authorie_Date = authorie_Date;
	}
	
	@Override
	public String toString() {
		return "AuthorizeVO [authorie_Id=" + authorie_Id + ", authorie_Mail=" + authorie_Mail + ", authorie_Code="
				+ authorie_Code + ", authorie_Date=" + authorie_Date + "]";
	}
	
	
}
