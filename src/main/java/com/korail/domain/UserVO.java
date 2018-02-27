package com.korail.domain;

import java.sql.Date;

public class UserVO {
	private String member_id;
	private String member_loginid;
	private String member_pw;
	private String member_name;
	private String member_ques;
	private String member_answer;
	private String member_addr;
	private String member_gender;
	private Date member_birth;
    private String member_profile;
    private Date member_regidate;
    private String member_type;
    
    public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String member_id, String member_loginid, String member_pw, String member_name, String member_ques,
			String member_answer, String member_addr, String member_gender, Date member_birth, String member_type,
			String member_profile, Date member_regidate) {
		super();
		this.member_id = member_id;
		this.member_loginid = member_loginid;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_ques = member_ques;
		this.member_answer = member_answer;
		this.member_addr = member_addr;
		this.member_gender = member_gender;
		this.member_birth = member_birth;
		this.member_type = member_type;
		this.member_profile = member_profile;
		this.member_regidate = member_regidate;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_ques() {
		return member_ques;
	}

	public void setMember_ques(String member_ques) {
		this.member_ques = member_ques;
	}

	public String getMember_answer() {
		return member_answer;
	}

	public void setMember_answer(String member_answer) {
		this.member_answer = member_answer;
	}

	public String getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public Date getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(Date member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_type() {
		return member_type;
	}

	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	public String getMember_profile() {
		return member_profile;
	}

	public void setMember_profile(String member_profile) {
		this.member_profile = member_profile;
	}

	public Date getMember_regidate() {
		return member_regidate;
	}

	public void setMember_regidate(Date member_regidate) {
		this.member_regidate = member_regidate;
	}

	@Override
	public String toString() {
		return "UserVO [member_id=" + member_id + ", member_loginid=" + member_loginid + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_ques=" + member_ques + ", member_answer=" + member_answer
				+ ", member_addr=" + member_addr + ", member_gender=" + member_gender + ", member_birth=" + member_birth
				+ ", member_type=" + member_type + ", member_profile=" + member_profile + ", member_regidate="
				+ member_regidate + "]";
	}

	
    
    
}
