package com.korail.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;
import com.korail.dto.PwsearchDTO;
import com.korail.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDAO;

	@Override
	public MemberVO login(String member_Loginid, String member_Pw) throws Exception {
		return memberDAO.login(member_Loginid, member_Pw);
	}

	@Override
	public void insert(MemberVO MemberVO) throws Exception {
		memberDAO.insert(MemberVO);

	}


	@Override
	public void createAuthorize(AuthorizeVO authorizeVO) throws Exception {
		memberDAO.createAuthorize(authorizeVO);
		
	}

	@Override
	public String selectAuthId(String member_Email, String tempCode) throws Exception {
		return memberDAO.selectAuthId(member_Email,tempCode);
	}

	@Override
	public int validID(String keyword) throws Exception {
		
		return memberDAO.validID(keyword);
	}

	

}
