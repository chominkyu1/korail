package com.korail.dto;

public class MyPurchaseDTO {
	
	private String tOrder_Id;
	private String tOrder_Date;
	private String tOrder_Price;
	private String tOrder_PayType;
	private String tOrder_State;
	private String member_Id;
	private String ticket_Name;

	
	@Override
	public String toString() {
		return "MyPurchaseDTO [tOrder_Id=" + tOrder_Id + ", tOrder_Date=" + tOrder_Date + ", tOrder_Price="
				+ tOrder_Price + ", tOrder_PayType=" + tOrder_PayType + ", tOrder_State=" + tOrder_State
				+ ", member_Id=" + member_Id + ", ticket_Name=" + ticket_Name + "]";
	}

	public String gettOrder_Id() {
		return tOrder_Id;
	}
	
	public void settOrder_Id(String tOrder_Id) {
		this.tOrder_Id = tOrder_Id;
	}
	
	public String gettOrder_Date() {
		return tOrder_Date;
	}
	
	public void settOrder_Date(String tOrder_Date) {
		this.tOrder_Date = tOrder_Date;
	}
	
	public String gettOrder_Price() {
		return tOrder_Price;
	}
	
	public void settOrder_Price(String tOrder_Price) {
		this.tOrder_Price = tOrder_Price;
	}
	
	public String gettOrder_PayType() {
		return tOrder_PayType;
	}
	
	public void settOrder_PayType(String tOrder_PayType) {
		this.tOrder_PayType = tOrder_PayType;
	}
	
	public String gettOrder_State() {
		return tOrder_State;
	}
	
	public void settOrder_State(String tOrder_State) {
		this.tOrder_State = tOrder_State;
	}
	
	public String getMember_Id() {
		return member_Id;
	}
	
	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}
	
	public String getTicket_Name() {
		return ticket_Name;
	}
	
	public void setTicket_Name(String ticket_Name) {
		this.ticket_Name = ticket_Name;
	}
	
	
}
