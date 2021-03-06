package com.korail.domain;


public class TipReviewVO {

	   private String tipreview_Id;
	   private String tipreview_Title; 
	   private String tipreview_Content; 
	   private String tipreview_Count; 
	   private String tipreview_Type;
	   private String tipreview_Regidate;
	   private String member_Id;

	   public TipReviewVO() {
	}

	public TipReviewVO(String tipreview_Id, String tipreview_Title, String tipreview_Content, String tipreview_Count,
			String tipreview_Type, String tipreview_Regidate, String member_Id) {
		super();
		this.tipreview_Id = tipreview_Id;
		this.tipreview_Title = tipreview_Title;
		this.tipreview_Content = tipreview_Content;
		this.tipreview_Count = tipreview_Count;
		this.tipreview_Type = tipreview_Type;
		this.tipreview_Regidate = tipreview_Regidate;
		this.member_Id = member_Id;
	}

	public String getTipreview_Id() {
		return tipreview_Id;
	}

	public void setTipreview_Id(String tipreview_Id) {
		this.tipreview_Id = tipreview_Id;
	}

	public String getTipreview_Title() {
		return tipreview_Title;
	}

	public void setTipreview_Title(String tipreview_Title) {
		this.tipreview_Title = tipreview_Title;
	}

	public String getTipreview_Content() {
		return tipreview_Content;
	}

	public void setTipreview_Content(String tipreview_Content) {
		this.tipreview_Content = tipreview_Content;
	}

	public String getTipreview_Count() {
		return tipreview_Count;
	}

	public void setTipreview_Count(String tipreview_Count) {
		this.tipreview_Count = tipreview_Count;
	}

	public String getTipreview_Type() {
		return tipreview_Type;
	}

	public void setTipreview_Type(String tipreview_Type) {
		this.tipreview_Type = tipreview_Type;
	}

	public String getTipreview_Regidate() {
		return tipreview_Regidate;
	}

	public void setTipreview_Regidate(String tipreview_Regidate) {
		this.tipreview_Regidate = tipreview_Regidate;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	@Override
	public String toString() {
		return "TipReviewVO [tipreview_Id=" + tipreview_Id + ", tipreview_Title=" + tipreview_Title
				+ ", tipreview_Content=" + tipreview_Content + ", tipreview_Count=" + tipreview_Count
				+ ", tipreview_Type=" + tipreview_Type + ", tipreview_Regidate=" + tipreview_Regidate + ", member_Id="
				+ member_Id + "]";
	}


}
