package com.korail.domain;

import java.util.Arrays;

public class WithScheVO {

	private String withsche_Id;
	private String withsche_Station;
	private String withsche_Startdate;
	private String withsche_Enddate;
	private String withsche_Content;
	private String withboard_Id;
	private String withsche_Addr;

	public WithScheVO(String withsche_Id, String withsche_Station, String withsche_Startdate, String withsche_Enddate,
			String withsche_Content, String withboard_Id, String withsche_Addr) {
		super();
		this.withsche_Id = withsche_Id;
		this.withsche_Station = withsche_Station;
		this.withsche_Startdate = withsche_Startdate;
		this.withsche_Enddate = withsche_Enddate;
		this.withsche_Content = withsche_Content;
		this.withboard_Id = withboard_Id;
		this.withsche_Addr = withsche_Addr;
	}
	public WithScheVO() {
		super();
	}
	public String getWithsche_Id() {
		return withsche_Id;
	}
	public void setWithsche_Id(String withsche_Id) {
		this.withsche_Id = withsche_Id;
	}
	public String getWithsche_Station() {
		return withsche_Station;
	}
	public void setWithsche_Station(String withsche_Station) {
		this.withsche_Station = withsche_Station;
	}
	public String getWithsche_Startdate() {
		return withsche_Startdate;
	}
	public void setWithsche_Startdate(String withsche_Startdate) {
		this.withsche_Startdate = withsche_Startdate;
	}
	public String getWithsche_Enddate() {
		return withsche_Enddate;
	}
	public void setWithsche_Enddate(String withsche_Enddate) {
		this.withsche_Enddate = withsche_Enddate;
	}
	public String getWithsche_Content() {
		return withsche_Content;
	}
	public void setWithsche_Content(String withsche_Content) {
		this.withsche_Content = withsche_Content;
	}
	public String getWithboard_Id() {
		return withboard_Id;
	}
	public void setWithboard_Id(String withboard_Id) {
		this.withboard_Id = withboard_Id;
	}
	public String getWithsche_Addr() {
		return withsche_Addr;
	}
	public void setWithsche_Addr(String withsche_Addr) {
		this.withsche_Addr = withsche_Addr;
	}
	@Override
	public String toString() {
		return "WithScheVO [withsche_Id=" + withsche_Id + ", withsche_Station=" + withsche_Station
				+ ", withsche_Startdate=" + withsche_Startdate + ", withsche_Enddate=" + withsche_Enddate
				+ ", withsche_Content=" + withsche_Content + ", withboard_Id=" + withboard_Id + ", withsche_Addr="
				+ withsche_Addr + "]";
	}

}
