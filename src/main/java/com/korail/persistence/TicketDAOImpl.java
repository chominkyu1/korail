package com.korail.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korail.domain.TicketVO;

@Repository
public class TicketDAOImpl implements TicketDAO{

	@Inject
	private SqlSession session;

	@Override
	public void create(TicketVO ticketVO) {
		session.insert("purchase.ticketCreate", ticketVO);
		
	}

	@Override
	public void update(TicketVO ticketVO) {//발권지 설정
		System.out.println("ticket_Id>>" +ticketVO.getTicket_Id());
		System.out.println("ticket_Station>>"+ticketVO.getTicket_Station());
		System.out.println("ticket_StartDate>>"+ticketVO.getTicket_StartDate());
		session.update("purchase.updateticket", ticketVO);
	}

	@Override
	public void delete(String ticket_Id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<TicketVO> ticketlist(String member_Id) {
		return null;
		
	}

	@Override
	public TicketVO ticketdetail(String ticket_Id) {
		return session.selectOne("purchase.ticketone", ticket_Id);
	}
	
	
}
