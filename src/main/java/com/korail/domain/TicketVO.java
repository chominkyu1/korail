package com.korail.domain;

public class TicketVO {
	private String ticket_Id;
	private String ticket_Name;
	private String ticket_Station;
	private String ticket_StartDate;
	private int ticket_ValidDate;
	               
	private String tOrder_Id;
	
	public TicketVO() {
		// TODO Auto-generated constructor stub
	}

	public TicketVO(String ticket_Id, String ticket_Name, String ticket_Station, String ticket_StartDate,
			int ticket_ValidDate, String tOrder_Id) {
		super();
		this.ticket_Id = ticket_Id;
		this.ticket_Name = ticket_Name;
		this.ticket_Station = ticket_Station;
		this.ticket_StartDate = ticket_StartDate;
		this.ticket_ValidDate = ticket_ValidDate;
		this.tOrder_Id = tOrder_Id;
	}

	public String getTicket_Id() {
		return ticket_Id;
	}

	public void setTicket_Id(String ticket_Id) {
		this.ticket_Id = ticket_Id;
	}

	public String getTicket_Name() {
		return ticket_Name;
	}

	public void setTicket_Name(String ticket_Name) {
		this.ticket_Name = ticket_Name;
	}

	public String getTicket_Station() {
		return ticket_Station;
	}

	public void setTicket_Station(String ticket_Station) {
		this.ticket_Station = ticket_Station;
	}

	public String getTicket_StartDate() {
		return ticket_StartDate;
	}

	public void setTicket_StartDate(String ticket_StartDate) {
		this.ticket_StartDate = ticket_StartDate;
	}

	public int getTicket_ValidDate() {
		return ticket_ValidDate;
	}

	public void setTicket_ValidDate(int ticket_ValidDate) {
		this.ticket_ValidDate = ticket_ValidDate;
	}

	public String gettOrder_Id() {
		return tOrder_Id;
	}

	public void settOrder_Id(String tOrder_Id) {
		this.tOrder_Id = tOrder_Id;
	}

	@Override
	public String toString() {
		return "TicketVO [ticket_Id=" + ticket_Id + ", ticket_Name=" + ticket_Name + ", ticket_Station="
				+ ticket_Station + ", ticket_StartDate=" + ticket_StartDate + ", ticket_ValidDate=" + ticket_ValidDate
				+ ", tOrder_Id=" + tOrder_Id + "]";
	}
	
	
	
	
}
