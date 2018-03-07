package com.korail.service;

import com.korail.domain.TOrderVO;
import com.korail.domain.TicketVO;

public interface TorderService {
 public void create(TOrderVO tOrderVO,TicketVO ticketVO);
 public void update(TOrderVO tOrderVO);
 public void delete(String tOrder_Id);
 public void select(String member_Id);
 
}
