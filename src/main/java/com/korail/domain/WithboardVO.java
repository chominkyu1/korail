package com.korail.domain;

import java.sql.Date;

public class WithboardVO {
	private String withboard_Id;
	private String withboard_Title;
    private Date withboard_Startdate;
    private Date withboard_Enddate;
    private Date withboard_Regidate;
    private String withboard_Gender;
    private String withboard_Content;
    private String withboard_Map;
    private String member_Id;
    public WithboardVO() {
		// TODO Auto-generated constructor stub
	}
	public WithboardVO(String withboard_Id, String withboard_Title, Date withboard_Startdate, Date withboard_Enddate,
			Date withboard_Regidate, String withboard_Gender, String withboard_Content, String withboard_Map,
			String member_Id) {
		super();
		this.withboard_Id = withboard_Id;
		this.withboard_Title = withboard_Title;
		this.withboard_Startdate = withboard_Startdate;
		this.withboard_Enddate = withboard_Enddate;
		this.withboard_Regidate = withboard_Regidate;
		this.withboard_Gender = withboard_Gender;
		this.withboard_Content = withboard_Content;
		this.withboard_Map = withboard_Map;
		this.member_Id = member_Id;
	}
	public String getWithboard_Id() {
		return withboard_Id;
	}
	public void setWithboard_Id(String withboard_Id) {
		this.withboard_Id = withboard_Id;
	}
	public String getWithboard_Title() {
		return withboard_Title;
	}
	public void setWithboard_Title(String withboard_Title) {
		this.withboard_Title = withboard_Title;
	}
	public Date getWithboard_Startdate() {
		return withboard_Startdate;
	}
	public void setWithboard_Startdate(Date withboard_Startdate) {
		this.withboard_Startdate = withboard_Startdate;
	}
	public Date getWithboard_Enddate() {
		return withboard_Enddate;
	}
	public void setWithboard_Enddate(Date withboard_Enddate) {
		this.withboard_Enddate = withboard_Enddate;
	}
	public Date getWithboard_Regidate() {
		return withboard_Regidate;
	}
	public void setWithboard_Regidate(Date withboard_Regidate) {
		this.withboard_Regidate = withboard_Regidate;
	}
	public String getWithboard_Gender() {
		return withboard_Gender;
	}
	public void setWithboard_Gender(String withboard_Gender) {
		this.withboard_Gender = withboard_Gender;
	}
	public String getWithboard_Content() {
		return withboard_Content;
	}
	public void setWithboard_Content(String withboard_Content) {
		this.withboard_Content = withboard_Content;
	}
	public String getWithboard_Map() {
		return withboard_Map;
	}
	public void setWithboard_Map(String withboard_Map) {
		this.withboard_Map = withboard_Map;
	}
	public String getMember_Id() {
		return member_Id;
	}
	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}
	@Override
	public String toString() {
		return "WithboardVO [withboard_Id=" + withboard_Id + ", withboard_Title=" + withboard_Title
				+ ", withboard_Startdate=" + withboard_Startdate + ", withboard_Enddate=" + withboard_Enddate
				+ ", withboard_Regidate=" + withboard_Regidate + ", withboard_Gender=" + withboard_Gender
				+ ", withboard_Content=" + withboard_Content + ", withboard_Map=" + withboard_Map + ", member_Id="
				+ member_Id + "]";
	}
    
	
}
