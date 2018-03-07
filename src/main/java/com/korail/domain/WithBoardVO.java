package com.korail.domain;

public class WithBoardVO {
	private String withboard_Id;
	private String withboard_Title;
	private String withboard_Startdate;
	private String withboard_Enddate;
	private String withboard_Regidate;
	private int withboard_Gender;
	private String withboard_Content;
	private String member_Id;
	private String[] withsche_Id;
	private String[] withsche_Station;
	private String[] withsche_Startdate;
	private String[] withsche_Enddate;
	private String[] withsche_Content;
	private String[] withsche_Addr;

	public WithBoardVO(String[] withsche_Id, String[] withsche_Station, String[] withsche_Startdate,
			String[] withsche_Enddate, String[] withsche_Content, String[] withsche_Addr) {
		super();
		this.withsche_Id = withsche_Id;
		this.withsche_Station = withsche_Station;
		this.withsche_Startdate = withsche_Startdate;
		this.withsche_Enddate = withsche_Enddate;
		this.withsche_Content = withsche_Content;
		this.withsche_Addr = withsche_Addr;
	}

	public WithBoardVO() {
		super();
	}

	public WithBoardVO(String withboard_Id, String withboard_Title, String withboard_Startdate,
			String withboard_Enddate, String withboard_Regidate, int withboard_Gender, String withboard_Content,
			String member_Id) {
		super();
		this.withboard_Id = withboard_Id;
		this.withboard_Title = withboard_Title;
		this.withboard_Startdate = withboard_Startdate;
		this.withboard_Enddate = withboard_Enddate;
		this.withboard_Regidate = withboard_Regidate;
		this.withboard_Gender = withboard_Gender;
		this.withboard_Content = withboard_Content;
		this.member_Id = member_Id;
	}

	@Override
	public String toString() {
		return "WithBoardVO [withboard_Id=" + withboard_Id + ", withboard_Title=" + withboard_Title
				+ ", withboard_Startdate=" + withboard_Startdate + ", withboard_Enddate=" + withboard_Enddate
				+ ", withboard_Regidate=" + withboard_Regidate + ", withboard_Gender=" + withboard_Gender
				+ ", withboard_Content=" + withboard_Content + ", member_Id=" + member_Id + "]";
	}

	public String[] getWithsche_Id() {
		return withsche_Id;
	}

	public void setWithsche_Id(String[] withsche_Id) {
		this.withsche_Id = withsche_Id;
	}

	public String[] getWithsche_Station() {
		return withsche_Station;
	}

	public void setWithsche_Station(String[] withsche_Station) {
		this.withsche_Station = withsche_Station;
	}

	public String[] getWithsche_Startdate() {
		return withsche_Startdate;
	}

	public void setWithsche_Startdate(String[] withsche_Startdate) {
		this.withsche_Startdate = withsche_Startdate;
	}

	public String[] getWithsche_Enddate() {
		return withsche_Enddate;
	}

	public void setWithsche_Enddate(String[] withsche_Enddate) {
		this.withsche_Enddate = withsche_Enddate;
	}

	public String[] getWithsche_Content() {
		return withsche_Content;
	}

	public void setWithsche_Content(String[] withsche_Content) {
		this.withsche_Content = withsche_Content;
	}

	public String[] getWithsche_Addr() {
		return withsche_Addr;
	}

	public void setWithsche_Addr(String[] withsche_Addr) {
		this.withsche_Addr = withsche_Addr;
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

	public String getWithboard_Startdate() {
		return withboard_Startdate;
	}

	public void setWithboard_Startdate(String withboard_Startdate) {
		this.withboard_Startdate = withboard_Startdate;
	}

	public String getWithboard_Enddate() {
		return withboard_Enddate;
	}

	public void setWithboard_Enddate(String withboard_Enddate) {
		this.withboard_Enddate = withboard_Enddate;
	}

	public String getWithboard_Regidate() {
		return withboard_Regidate;
	}

	public void setWithboard_Regidate(String withboard_Regidate) {
		this.withboard_Regidate = withboard_Regidate;
	}

	public int getWithboard_Gender() {
		return withboard_Gender;
	}

	public void setWithboard_Gender(int withboard_Gender) {
		this.withboard_Gender = withboard_Gender;
	}

	public String getWithboard_Content() {
		return withboard_Content;
	}

	public void setWithboard_Content(String withboard_Content) {
		this.withboard_Content = withboard_Content;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

}
