package com.korail.service;

import com.korail.domain.MemberVO;
import com.korail.dto.IdsearchDTO;
import com.korail.dto.PwsearchDTO;

public interface UserService {
	
	public MemberVO login(String member_Loginid,String member_Pw)throws Exception;
	public void insert(MemberVO memberVO)throws Exception;
	public void insert1()throws Exception;
	public String idSearch(IdsearchDTO idsearchDTO)throws Exception;
	public void pwSearch(PwsearchDTO pwsearchDTO)throws Exception;
	public void memberSecession(String member_id)throws Exception;

}
