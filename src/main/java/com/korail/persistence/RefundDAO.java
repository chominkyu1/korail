package com.korail.persistence;

public interface RefundDAO {
	public void create(String tOrder_Id) throws Exception;
	public void stateUpdate(String tOrder_Id) throws Exception;
	public String selectrefund(String tOrder_Id) throws Exception;
	
}
