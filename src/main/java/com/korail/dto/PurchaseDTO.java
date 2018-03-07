package com.korail.dto;

public class PurchaseDTO {

	private String tOrder_Id;
	private String member_Id;
	private String tOrder_Date;
	private String tOrder_Price;
	private String tOrder_PayType;
	private String tOrder_State;
	private String refund_Id;
	private String refund_Date;
	private String refund_State;
	private int refund_Sum;

	
	@Override
	public String toString() {
		return "PurchaseDTO [tOrder_Id=" + tOrder_Id + ", member_Id=" + member_Id + ", tOrder_Date=" + tOrder_Date
				+ ", tOrder_Price=" + tOrder_Price + ", tOrder_PayType=" + tOrder_PayType + ", tOrder_State="
				+ tOrder_State + ", refund_Id=" + refund_Id + ", refund_Date=" + refund_Date + ", refund_State="
				+ refund_State + ", refund_Sum=" + refund_Sum + "]";
	}

	public String gettOrder_Id() {
		return tOrder_Id;
	}

	public void settOrder_Id(String tOrder_Id) {
		this.tOrder_Id = tOrder_Id;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
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

	public String getRefund_Id() {
		return refund_Id;
	}

	public void setRefund_Id(String refund_Id) {
		this.refund_Id = refund_Id;
	}

	public String getRefund_Date() {
		return refund_Date;
	}

	public void setRefund_Date(String refund_Date) {
		this.refund_Date = refund_Date;
	}

	public String getRefund_State() {
		return refund_State;
	}

	public void setRefund_State(String refund_State) {
		this.refund_State = refund_State;
	}

	public int getRefund_Sum() {
		return refund_Sum;
	}

	public void setRefund_Sum(int refund_Sum) {
		this.refund_Sum = refund_Sum;
	}

}
