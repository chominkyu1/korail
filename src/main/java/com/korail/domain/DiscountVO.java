package com.korail.domain;

import java.sql.Date;

public class DiscountVO {
	
	private String discount_Id;
	private String discount_Title;
	private String discount_Price;
	private String discount_Content;
	private String discount_Shopname;
	private String discount_Shophone;
	private String discount_Map;
	private Date discount_Regidate;
	private int discount_Count;
	private String member_Id;
	private String station_Id;
	
	public DiscountVO() {
		// TODO Auto-generated constructor stub
	}

	public DiscountVO(String discount_Id, String discount_Title, String discount_Price, String discount_Content,
			String discount_Shopname, String discount_Shophone, String discount_Map, Date discount_Regidate,
			int discount_Count, String member_Id, String station_Id) {
		super();
		this.discount_Id = discount_Id;
		this.discount_Title = discount_Title;
		this.discount_Price = discount_Price;
		this.discount_Content = discount_Content;
		this.discount_Shopname = discount_Shopname;
		this.discount_Shophone = discount_Shophone;
		this.discount_Map = discount_Map;
		this.discount_Regidate = discount_Regidate;
		this.discount_Count = discount_Count;
		this.member_Id = member_Id;
		this.station_Id = station_Id;
	}

	public String getDiscount_Id() {
		return discount_Id;
	}

	public void setDiscount_Id(String discount_Id) {
		this.discount_Id = discount_Id;
	}

	public String getDiscount_Title() {
		return discount_Title;
	}

	public void setDiscount_Title(String discount_Title) {
		this.discount_Title = discount_Title;
	}

	public String getDiscount_Price() {
		return discount_Price;
	}

	public void setDiscount_Price(String discount_Price) {
		this.discount_Price = discount_Price;
	}

	public String getDiscount_Content() {
		return discount_Content;
	}

	public void setDiscount_Content(String discount_Content) {
		this.discount_Content = discount_Content;
	}

	public String getDiscount_Shopname() {
		return discount_Shopname;
	}

	public void setDiscount_Shopname(String discount_Shopname) {
		this.discount_Shopname = discount_Shopname;
	}

	public String getDiscount_Shophone() {
		return discount_Shophone;
	}

	public void setDiscount_Shophone(String discount_Shophone) {
		this.discount_Shophone = discount_Shophone;
	}

	public String getDiscount_Map() {
		return discount_Map;
	}

	public void setDiscount_Map(String discount_Map) {
		this.discount_Map = discount_Map;
	}

	public Date getDiscount_Regidate() {
		return discount_Regidate;
	}

	public void setDiscount_Regidate(Date discount_Regidate) {
		this.discount_Regidate = discount_Regidate;
	}

	public int getDiscount_Count() {
		return discount_Count;
	}

	public void setDiscount_Count(int discount_Count) {
		this.discount_Count = discount_Count;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	public String getStation_Id() {
		return station_Id;
	}

	public void setStation_Id(String station_Id) {
		this.station_Id = station_Id;
	}

	@Override
	public String toString() {
		return "DiscountVO [discount_Id=" + discount_Id + ", discount_Title=" + discount_Title + ", discount_Price="
				+ discount_Price + ", discount_Content=" + discount_Content + ", discount_Shopname=" + discount_Shopname
				+ ", discount_Shophone=" + discount_Shophone + ", discount_Map=" + discount_Map + ", discount_Regidate="
				+ discount_Regidate + ", discount_Count=" + discount_Count + ", member_Id=" + member_Id
				+ ", station_Id=" + station_Id + "]";
	}	
}
