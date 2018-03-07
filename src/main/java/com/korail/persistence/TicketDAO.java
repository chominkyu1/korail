package com.korail.persistence;

import java.util.List;

import com.korail.domain.TicketVO;

public interface TicketDAO {
	public void create(TicketVO ticketVO);
	public void update(TicketVO ticketVO);
	public void delete(String ticket_Id);
	public List<TicketVO> ticketlist(String member_Id);//멤버의 티켓리스트
	public TicketVO ticketdetail(String ticket_Id);
}
