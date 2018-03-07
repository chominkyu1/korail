package com.korail.dto;

public class IdsearchDTO {
	private String member_Name;
	private String member_Ques;
	private String member_Answer;
    private String member_Phone;
    
    public IdsearchDTO() {
		// TODO Auto-generated constructor stub
	}

	public IdsearchDTO(String member_Name, String member_Ques, String member_Answer, String member_Phone) {
		super();
		this.member_Name = member_Name;
		this.member_Ques = member_Ques;
		this.member_Answer = member_Answer;
		this.member_Phone = member_Phone;
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

	public String getMember_Phone() {
		return member_Phone;
	}

	public void setMember_Phone(String member_Phone) {
		this.member_Phone = member_Phone;
	}

	@Override
	public String toString() {
		return "IdsearchDTO [member_Name=" + member_Name + ", member_Ques=" + member_Ques + ", member_Answer="
				+ member_Answer + ", member_Phone=" + member_Phone + "]";
	}
    
    
	
}
