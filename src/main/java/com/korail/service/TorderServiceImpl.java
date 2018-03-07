package com.korail.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korail.domain.TOrderVO;
import com.korail.domain.TicketVO;
import com.korail.persistence.TicketDAO;
import com.korail.persistence.TorderDAO;

@Service
public class TorderServiceImpl implements TorderService{
	
	@Inject
	private TorderDAO torderDAO;
	
	@Inject
    private TicketDAO ticketDAO;
	
	
	//구매 서비스(주문 + 티켓)
	@Transactional
	@Override
	public void create(TOrderVO tOrderVO,TicketVO ticketVO) {
		String tOrder_Id = torderDAO.orderSeq();
		tOrderVO.settOrder_Id(tOrder_Id);
		
		torderDAO.create(tOrderVO);
		
		ticketVO.settOrder_Id(tOrder_Id);
		ticketDAO.create(ticketVO);
		
	}

	@Override
	public void update(TOrderVO tOrderVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String tOrder_Id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void select(String member_Id) {
		// TODO Auto-generated method stub
		
	}

	
}
