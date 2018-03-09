package com.korail.persistence;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;
import com.korail.dto.IdsearchDTO;
import com.korail.dto.PwsearchDTO;

public interface MemberDAO {

	 public MemberVO login(String member_Loginid,String member_Pw)throws Exception;
	 public void insert(MemberVO memberVO)throws Exception;
	 public void createAuthorize(AuthorizeVO authorizeVO)throws Exception;
	 public void insert1()throws Exception;
	 public String idSearch(IdsearchDTO idsearchDTO)throws Exception;
	 public void pwSearch(PwsearchDTO pwsearchDTO)throws Exception;
	 public void memberSecession(String member_id)throws Exception;
}
