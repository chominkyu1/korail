package com.korail.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.korail.domain.TOrderVO;
import com.korail.dto.MyPurchaseDTO;
import com.korail.dto.PurchaseDTO;

@Repository
public class TorderDAOImpl implements TorderDAO{

	

	@Inject
	private SqlSession session;
	
	
	
	@Override
	public void create(TOrderVO tOrderVO) {
		session.insert("purchase.orderCreate",tOrderVO);
		
	}

	@Override
	public void update(TOrderVO tOrderVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String tOrder_Id) {
		
		
	}

	@Override
	public List<MyPurchaseDTO> selectList(String member_Id) {
		return session.selectList("purchase.selectList", member_Id);
	}

	@Override
	public String orderSeq() {		
		return session.selectOne("purchase.orderSeq");
	}

	@Override
	public void stateUpdate(String tOrder_Id,String state) {//환불처리중으로 상태변경 
		Map<String, String> map = new HashMap<>();
		map.put("tOrder_Id", tOrder_Id);
		if(state.equals("환불처리중")) {
			map.put("state", "2");
		}else if(state.equals("취소완료")) {
			map.put("state", "3");
		}
		session.update("purchase.stateUpdate", map);
	}

	@Override
	public List<PurchaseDTO> selectListALL() {
		
		return session.selectList("purchase.listAll");
	}

	@Override
	public List<PurchaseDTO> searchPurchase(String type, String keyword) {
		Map<String, String> map = new HashMap<>();
		List<PurchaseDTO> list = null;
		map.put("keyword","%"+keyword+"%");
		
		if(type.equals("member_Id")) {
			map.put("member_Id", type);
			//list=session.selectList("purchase.searchlist",map);
		}else if(type.equals("tOrder_Id")){
			map.put("tOrder_Id", type);
			//list=session.selectList("purchase.searchlist",map);
		}//else if(type.equals("refund_Id")) {}
		
		list=session.selectList("purchase.searchlist",map);
		
		return list;
	}
	
	

}
