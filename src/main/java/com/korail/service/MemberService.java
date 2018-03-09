package com.korail.service;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;

import com.korail.dto.PwsearchDTO;

public interface MemberService {
	
	public MemberVO login(String member_Loginid,String member_Pw)throws Exception;
	public void insert(MemberVO MemberVO) throws Exception;
	public void createAuthorize(AuthorizeVO authorizeVO) throws Exception;
	public String selectAuthId(String member_Email, String tempCode) throws Exception;
	public int validID(String keyword) throws Exception;
	
	

}
