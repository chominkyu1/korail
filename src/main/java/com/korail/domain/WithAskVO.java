package com.korail.domain;

import java.sql.Date;

public class WithAskVO {


	private String withAsk_Id;

	public WithAskVO() {
		super();
	}

	public WithAskVO(String withAsk_Id, String withAsk_Content, Date withAsk_Date, String sender_Id,
			String withboard_Id, String withAsk_State) {
		super();
		this.withAsk_Id = withAsk_Id;
		this.withAsk_Content = withAsk_Content;
		this.withAsk_Date = withAsk_Date;
		this.sender_Id = sender_Id;
		this.withboard_Id = withboard_Id;
		this.withAsk_State = withAsk_State;
	}

	@Override
	public String toString() {
		return "WithAskVO [withAsk_Id=" + withAsk_Id + ", withAsk_Content=" + withAsk_Content + ", withAsk_Date="
				+ withAsk_Date + ", sender_Id=" + sender_Id + ", withboard_Id=" + withboard_Id + ", withAsk_State="
				+ withAsk_State + "]";
	}

	public String getWithAsk_Id() {
		return withAsk_Id;
	}

	public void setWithAsk_Id(String withAsk_Id) {
		this.withAsk_Id = withAsk_Id;
	}

	public String getWithAsk_Content() {
		return withAsk_Content;
	}

	public void setWithAsk_Content(String withAsk_Content) {
		this.withAsk_Content = withAsk_Content;
	}

	public Date getWithAsk_Date() {
		return withAsk_Date;
	}

	public void setWithAsk_Date(Date withAsk_Date) {
		this.withAsk_Date = withAsk_Date;
	}

	public String getSender_Id() {
		return sender_Id;
	}

	public void setSender_Id(String sender_Id) {
		this.sender_Id = sender_Id;
	}

	public String getWithboard_Id() {
		return withboard_Id;
	}

	public void setWithboard_Id(String withboard_Id) {
		this.withboard_Id = withboard_Id;
	}

	public String getWithAsk_State() {
		return withAsk_State;
	}

	public void setWithAsk_State(String withAsk_State) {
		this.withAsk_State = withAsk_State;
	}

	private String withAsk_Content;
	private Date withAsk_Date;
	private String sender_Id;
	private String withboard_Id;
	private String withAsk_State;
}
