package com.korail.domain;

import java.sql.Date;

public class UserVO {
	private String MEMBER_ID;
	private String MEMBER_LOGINID;
	private String MEMBER_PW;
	private String MEMBER_NAME;
	private String MEMBER_QUES;
	private String MEMBER_ANSWER;
	private String MEMBER_ADDR;
	private String MEMBER_GENDER;
	private Date MEMBER_BIRTH;
    private String MEMBER_TYPE;
    private String MEMBER_PROFILE;
    private Date MEMBER_REGIDATE;
    
    public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String mEMBER_ID, String mEMBER_LOGINID, String mEMBER_PW, String mEMBER_NAME, String mEMBER_QUES,
			String mEMBER_ANSWER, String mEMBER_ADDR, String mEMBER_GENDER, Date mEMBER_BIRTH, String mEMBER_TYPE,
			String mEMBER_PROFILE, Date mEMBER_REGIDATE) {
		super();
		MEMBER_ID = mEMBER_ID;
		MEMBER_LOGINID = mEMBER_LOGINID;
		MEMBER_PW = mEMBER_PW;
		MEMBER_NAME = mEMBER_NAME;
		MEMBER_QUES = mEMBER_QUES;
		MEMBER_ANSWER = mEMBER_ANSWER;
		MEMBER_ADDR = mEMBER_ADDR;
		MEMBER_GENDER = mEMBER_GENDER;
		MEMBER_BIRTH = mEMBER_BIRTH;
		MEMBER_TYPE = mEMBER_TYPE;
		MEMBER_PROFILE = mEMBER_PROFILE;
		MEMBER_REGIDATE = mEMBER_REGIDATE;
	}

	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public String getMEMBER_LOGINID() {
		return MEMBER_LOGINID;
	}

	public void setMEMBER_LOGINID(String mEMBER_LOGINID) {
		MEMBER_LOGINID = mEMBER_LOGINID;
	}

	public String getMEMBER_PW() {
		return MEMBER_PW;
	}

	public void setMEMBER_PW(String mEMBER_PW) {
		MEMBER_PW = mEMBER_PW;
	}

	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}

	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}

	public String getMEMBER_QUES() {
		return MEMBER_QUES;
	}

	public void setMEMBER_QUES(String mEMBER_QUES) {
		MEMBER_QUES = mEMBER_QUES;
	}

	public String getMEMBER_ANSWER() {
		return MEMBER_ANSWER;
	}

	public void setMEMBER_ANSWER(String mEMBER_ANSWER) {
		MEMBER_ANSWER = mEMBER_ANSWER;
	}

	public String getMEMBER_ADDR() {
		return MEMBER_ADDR;
	}

	public void setMEMBER_ADDR(String mEMBER_ADDR) {
		MEMBER_ADDR = mEMBER_ADDR;
	}

	public String getMEMBER_GENDER() {
		return MEMBER_GENDER;
	}

	public void setMEMBER_GENDER(String mEMBER_GENDER) {
		MEMBER_GENDER = mEMBER_GENDER;
	}

	public Date getMEMBER_BIRTH() {
		return MEMBER_BIRTH;
	}

	public void setMEMBER_BIRTH(Date mEMBER_BIRTH) {
		MEMBER_BIRTH = mEMBER_BIRTH;
	}

	public String getMEMBER_TYPE() {
		return MEMBER_TYPE;
	}

	public void setMEMBER_TYPE(String mEMBER_TYPE) {
		MEMBER_TYPE = mEMBER_TYPE;
	}

	public String getMEMBER_PROFILE() {
		return MEMBER_PROFILE;
	}

	public void setMEMBER_PROFILE(String mEMBER_PROFILE) {
		MEMBER_PROFILE = mEMBER_PROFILE;
	}

	public Date getMEMBER_REGIDATE() {
		return MEMBER_REGIDATE;
	}

	public void setMEMBER_REGIDATE(Date mEMBER_REGIDATE) {
		MEMBER_REGIDATE = mEMBER_REGIDATE;
	}

	@Override
	public String toString() {
		return "UserVO [MEMBER_ID=" + MEMBER_ID + ", MEMBER_LOGINID=" + MEMBER_LOGINID + ", MEMBER_PW=" + MEMBER_PW
				+ ", MEMBER_NAME=" + MEMBER_NAME + ", MEMBER_QUES=" + MEMBER_QUES + ", MEMBER_ANSWER=" + MEMBER_ANSWER
				+ ", MEMBER_ADDR=" + MEMBER_ADDR + ", MEMBER_GENDER=" + MEMBER_GENDER + ", MEMBER_BIRTH=" + MEMBER_BIRTH
				+ ", MEMBER_TYPE=" + MEMBER_TYPE + ", MEMBER_PROFILE=" + MEMBER_PROFILE + ", MEMBER_REGIDATE="
				+ MEMBER_REGIDATE + "]";
	}
    
    
}
