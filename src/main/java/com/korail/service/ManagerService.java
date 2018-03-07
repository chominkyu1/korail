package com.korail.service;

import java.util.List;

import com.korail.domain.DiscountVO;
import com.korail.domain.MemberVO;
import com.korail.domain.WithboardVO;
import com.korail.dto.SearchDTO;

public interface ManagerService {
	public List<MemberVO> memberSearch(SearchDTO searchDTO)throws Exception;
	public MemberVO memberSearchDetail(String member_Id)throws Exception;
	public List<WithboardVO> memberwithboard(String member_Id)throws Exception;
	public List<DiscountVO> discountAll()throws Exception;
	
}
