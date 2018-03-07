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
public class PurchaseServiceImpl implements PurchaseService{//����, ȯ��, Ƽ�� ���� : ������

	@Inject
	private TorderDAO torderDAO;
	
	@Inject
    private TicketDAO ticketDAO;
	
	@Inject
	private RefundDAO refundDAO;
	
	//���� ����(�ֹ� + Ƽ��)
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
			ticket_Name = "�Ϲ� ���Ϸ�5�ϱ�";
			ticket_ValidDate = 5;
		}else if(tOrderVO.gettOrder_Price().equals("70000")) {
			ticket_Name = "�Ϲ� ���Ϸ�7�ϱ�";
			ticket_ValidDate =7;
		}else if(tOrderVO.gettOrder_Price().equals("110000")) {
			ticket_Name = "�Ϲ� ���Ϸ�5�ϱ�";
			ticket_ValidDate = 5;
		}else {//if(tOrderVO.gettOrder_Price().equals("120000")) {
			ticket_Name = "�����̾� ���Ϸ�7�ϱ�";
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
	public void refund(String tOrder_Id) {//ȸ���� ȯ�ҹ�ư�� Ŭ��������, ȯ��ó��, ȯ��ó�������� ���º���
		try {
			String refundtOrder_Id = refundDAO.selectrefund(tOrder_Id);
			if(!refundtOrder_Id.equals(null)) {
				torderDAO.stateUpdate(tOrder_Id,"ȯ��ó����");
				refundDAO.create(tOrder_Id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void refundstate(String tOrder_Id) {
		try {
			torderDAO.stateUpdate(tOrder_Id, "��ҿϷ�");
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
