package com.korail.domain;

public class MemberVO {
	private String member_Id;
	private String member_Loginid;
	private String member_Pw;
	private String member_Name;
	private String member_Ques;
	private String member_Answer;
	private String member_Addr;
	private String member_Gender;
	private String member_Birth;
	private String member_Profile;
	private String member_Regidate;
	private String member_Type;
	private String member_Phone;
	private String member_Email;
	private String authorize_Id;
	public String getMember_Id() {
		return member_Id;
	}
	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}
	public String getMember_Loginid() {
		return member_Loginid;
	}
	public void setMember_Loginid(String member_Loginid) {
		this.member_Loginid = member_Loginid;
	}
	public String getMember_Pw() {
		return member_Pw;
	}
	public void setMember_Pw(String member_Pw) {
		this.member_Pw = member_Pw;
	}
	public String getMember_Name() {
		return member_Name;
	}
	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}
	public String getMember_Ques() {
		return member_Ques;
	}
	public void setMember_Ques(String member_Ques) {
		this.member_Ques = member_Ques;
	}
	public String getMember_Answer() {
		return member_Answer;
	}
	public void setMember_Answer(String member_Answer) {
		this.member_Answer = member_Answer;
	}
	public String getMember_Addr() {
		return member_Addr;
	}
	public void setMember_Addr(String member_Addr) {
		this.member_Addr = member_Addr;
	}
	public String getMember_Gender() {
		return member_Gender;
	}
	public void setMember_Gender(String member_Gender) {
		this.member_Gender = member_Gender;
	}
	public String getMember_Birth() {
		return member_Birth;
	}
	public void setMember_Birth(String member_Birth) {
		this.member_Birth = member_Birth;
	}
	public String getMember_Profile() {
		return member_Profile;
	}
	public void setMember_Profile(String member_Profile) {
		this.member_Profile = member_Profile;
	}
	public String getMember_Regidate() {
		return member_Regidate;
	}
	public void setMember_Regidate(String member_Regidate) {
		this.member_Regidate = member_Regidate;
	}
	public String getMember_Type() {
		return member_Type;
	}
	public void setMember_Type(String member_Type) {
		this.member_Type = member_Type;
	}
	public String getMember_Phone() {
		return member_Phone;
	}
	public void setMember_Phone(String member_Phone) {
		this.member_Phone = member_Phone;
	}
	public String getMember_Email() {
		return member_Email;
	}
	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}
	public String getAuthorize_Id() {
		return authorize_Id;
	}
	public void setAuthorize_Id(String authorize_Id) {
		this.authorize_Id = authorize_Id;
	}
	@Override
	public String toString() {
		return "MemberVO [member_Id=" + member_Id + ", member_Loginid=" + member_Loginid + ", member_Pw=" + member_Pw
				+ ", member_Name=" + member_Name + ", member_Ques=" + member_Ques + ", member_Answer=" + member_Answer
				+ ", member_Addr=" + member_Addr + ", member_Gender=" + member_Gender + ", member_Birth=" + member_Birth
				+ ", member_Profile=" + member_Profile + ", member_Regidate=" + member_Regidate + ", member_Type="
				+ member_Type + ", member_Phone=" + member_Phone + ", member_Email=" + member_Email + ", authorize_Id="
				+ authorize_Id + "]";
	}
	
	
}
