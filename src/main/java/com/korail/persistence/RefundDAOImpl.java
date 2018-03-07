package com.korail.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RefundDAOImpl implements RefundDAO{

	@Inject
	private SqlSession session;

	@Override
	public void create(String tOrder_Id) throws Exception {
		session.insert("purchase.createRefund",tOrder_Id);
	}

	@Override
	public void stateUpdate(String tOrder_Id) throws Exception {
		session.update("purchase.refundState", tOrder_Id);
		
	}

	@Override
	public String selectrefund(String tOrder_Id) throws Exception {//order_id로 환불 가능한지 조회 
		return session.selectOne("purchase.refundOrder", tOrder_Id);
	}
	
	
}
