package com.korail.service;

import java.util.List;


import com.korail.domain.TOrderVO;
import com.korail.domain.TicketVO;
import com.korail.dto.MyPurchaseDTO;
import com.korail.dto.PurchaseDTO;

public interface PurchaseService {

	 public void create(TOrderVO tOrderVO,TicketVO ticketVO);
	 public void refund(String tOrder_Id);
	 public void refundstate(String tOrder_Id);
	 public void ticketUpdate(TicketVO ticketVO);
	 public void delete(String tOrder_Id);
	 public List<MyPurchaseDTO> selectList(String member_Id);
	 public TicketVO ticketdetail(String ticket_Id);
	 public List<PurchaseDTO> selectListALL();
	 public List<PurchaseDTO> searchPurchase(String type,String keyword);
	 
	 
}
