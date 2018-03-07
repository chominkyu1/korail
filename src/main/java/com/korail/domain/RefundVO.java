package com.korail.domain;

public class RefundVO {
	private String refund_Id;
	private String refund_Date;
	private String refund_State;
	private int refund_Sum;
	private String tOrder_Id;

	@Override
	public String toString() {
		return "RefundVO [refund_Id=" + refund_Id + ", refund_Date=" + refund_Date + ", refund_State=" + refund_State
				+ ", refund_Sum=" + refund_Sum + ", tOrder_Id=" + tOrder_Id + "]";
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

	
	public String gettOrder_Id() {
		return tOrder_Id;
	}

	public void settOrder_Id(String tOrder_Id) {
		this.tOrder_Id = tOrder_Id;
	}

	
}
