package com.korail.dto;

public class WithSearchDTO {
	public String getWithsche_Station() {
		return withsche_Station;
	}

	public void setWithsche_Station(String withsche_Station) {
		this.withsche_Station = withsche_Station;
	}

	public String getWithboard_Startdate() {
		return withboard_Startdate;
	}

	public void setWithboard_Startdate(String withboard_Startdate) {
		this.withboard_Startdate = withboard_Startdate;
	}

	public String getSearch_Keyword() {
		return search_Keyword;
	}

	public void setSearch_Keyword(String search_Keyword) {
		this.search_Keyword = search_Keyword;
	}

	public String getSearch_Category() {
		return search_Category;
	}

	public void setSearch_Category(String search_Category) {
		this.search_Category = search_Category;
	}

	public String getWithboard_Gender() {
		return withboard_Gender;
	}

	public void setWithboard_Gender(String withboard_Gender) {
		this.withboard_Gender = withboard_Gender;
	}

	public String getMember_loginId() {
		return member_loginId;
	}

	public void setMember_loginId(String member_loginId) {
		this.member_loginId = member_loginId;
	}

	public WithSearchDTO() {
		super();
	}

	public WithSearchDTO(String withsche_Station, String withboard_Startdate, String search_Keyword,
			String search_Category, String withboard_Gender, String member_loginId) {
		super();
		this.withsche_Station = withsche_Station;
		this.withboard_Startdate = withboard_Startdate;
		this.search_Keyword = search_Keyword;
		this.search_Category = search_Category;
		this.withboard_Gender = withboard_Gender;
		this.member_loginId = member_loginId;
	}

	@Override
	public String toString() {
		return "WithSearchDTO [withsche_Station=" + withsche_Station + ", withboard_Startdate=" + withboard_Startdate
				+ ", search_Keyword=" + search_Keyword + ", search_Category=" + search_Category + ", withboard_Gender="
				+ withboard_Gender + ", member_loginId=" + member_loginId + "]";
	}

	private String withsche_Station;
	private String withboard_Startdate;
	private String search_Keyword;
	private String search_Category;
	private String withboard_Gender;
	private String member_loginId;

}
