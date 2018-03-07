package com.korail.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.korail.domain.TOrderVO;
import com.korail.domain.TicketVO;
import com.korail.dto.MyPurchaseDTO;
import com.korail.dto.PurchaseDTO;
import com.korail.persistence.RefundDAO;
import com.korail.persistence.TicketDAO;
import com.korail.persistence.TorderDAO;

@Service
public class PurchaseServiceImpl implements PurchaseService{//구매, 환불, 티켓 서비스 : 한정숙

	@Inject
	private TorderDAO torderDAO;
	
	@Inject
    private TicketDAO ticketDAO;
	
	@Inject
	private RefundDAO refundDAO;
	
	//구매 서비스(주문 + 티켓)
	@Transactional
	@Override
	public void create(TOrderVO tOrderVO,TicketVO ticketVO) {
		String tOrder_Id = torderDAO.orderSeq();
		tOrderVO.settOrder_Id(tOrder_Id);
		
		torderDAO.create(tOrderVO);
		
		ticketVO.settOrder_Id(tOrder_Id);
		String ticket_Name=null;
		int ticket_ValidDate=0;
		if(tOrderVO.gettOrder_Price().equals("60000")) {
			ticket_Name = "일반 내일로5일권";
			ticket_ValidDate = 5;
		}else if(tOrderVO.gettOrder_Price().equals("70000")) {
			ticket_Name = "일반 내일로7일권";
			ticket_ValidDate =7;
		}else if(tOrderVO.gettOrder_Price().equals("110000")) {
			ticket_Name = "일반 내일로5일권";
			ticket_ValidDate = 5;
		}else {//if(tOrderVO.gettOrder_Price().equals("120000")) {
			ticket_Name = "프리미엄 내일로7일권";
			ticket_ValidDate = 7;
		}
		ticketVO.setTicket_Name(ticket_Name);
		ticketVO.setTicket_ValidDate(ticket_ValidDate);
		ticketDAO.create(ticketVO);
	}

	

	@Override
	public void delete(String tOrder_Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MyPurchaseDTO> selectList(String member_Id) {
		return torderDAO.selectList(member_Id);
	}

	@Override
	public TicketVO ticketdetail(String ticket_Id) {
		return ticketDAO.ticketdetail(ticket_Id);
	}

	@Override
	public void ticketUpdate(TicketVO ticketVO) {
		ticketDAO.update(ticketVO);
	}

	@Transactional
	@Override
	public void refund(String tOrder_Id) {//회원이 환불버튼을 클릭했을때, 환불처리, 환불처리중으로 상태변경
		try {
			String refundtOrder_Id = refundDAO.selectrefund(tOrder_Id);
			if(!refundtOrder_Id.equals(null)) {
				torderDAO.stateUpdate(tOrder_Id,"환불처리중");
				refundDAO.create(tOrder_Id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void refundstate(String tOrder_Id) {
		try {
			torderDAO.stateUpdate(tOrder_Id, "취소완료");
			refundDAO.stateUpdate(tOrder_Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	@Override
	public List<PurchaseDTO> selectListALL() {
		return torderDAO.selectListALL() ;
	}



	@Override
	public List<PurchaseDTO> searchPurchase(String type, String keyword) {
		return torderDAO.searchPurchase(type, keyword);
	}

	
}
