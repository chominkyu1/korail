package com.korail.dto;

public class PwsearchDTO {
	private String member_Name;
	private String member_Loginid;
    private String member_Phone;
    private String member_Email;
    private String member_Pw;
    
    public PwsearchDTO() {
    	
    }

	public PwsearchDTO(String member_Name, String member_Loginid, String member_Phone, String member_Email,
			String member_Pw) {
		super();
		this.member_Name = member_Name;
		this.member_Loginid = member_Loginid;
		this.member_Phone = member_Phone;
		this.member_Email = member_Email;
		this.member_Pw = member_Pw;
	}

	public String getMember_Name() {
		return member_Name;
	}

	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}

	public String getMember_Loginid() {
		return member_Loginid;
	}

	public void setMember_Loginid(String member_Loginid) {
		this.member_Loginid = member_Loginid;
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

	public String getMember_Pw() {
		return member_Pw;
	}

	public void setMember_Pw(String member_Pw) {
		this.member_Pw = member_Pw;
	}

	@Override
	public String toString() {
		return "PwsearchDTO [member_Name=" + member_Name + ", member_Loginid=" + member_Loginid + ", member_Phone="
				+ member_Phone + ", member_Email=" + member_Email + ", member_Pw=" + member_Pw + "]";
	}

	
	
	
}
