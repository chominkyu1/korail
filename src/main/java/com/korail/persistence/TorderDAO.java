package com.korail.persistence;

import java.util.List;


import com.korail.domain.TOrderVO;
import com.korail.dto.MyPurchaseDTO;
import com.korail.dto.PurchaseDTO;

public interface TorderDAO {
	 public void create(TOrderVO tOrderVO);
	 public void update(TOrderVO tOrderVO);
	 public void stateUpdate(String tOrder_Id,String state);
	 public void delete(String tOrder_Id);
	 public List<MyPurchaseDTO> selectList(String member_Id);
	 public List<PurchaseDTO> selectListALL();
	 public List<PurchaseDTO> searchPurchase(String type, String keyword);
	 public String orderSeq();
	
	 
}
