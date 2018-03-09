package com.korail.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;
import com.korail.dto.IdsearchDTO;
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
	public void insert(MemberVO memberVO) throws Exception {
		memberDAO.insert(memberVO);

	}

	@Override
	public String idSearch(IdsearchDTO idsearchDTO) throws Exception {
		return memberDAO.idSearch(idsearchDTO);
	}

	@Override
	public void pwSearch(PwsearchDTO pwsearchDTO) throws Exception {
		memberDAO.pwSearch(pwsearchDTO);

	}

	@Override
	public void insert1() throws Exception {
		memberDAO.insert1();

	}

	@Override
	public void memberSecession(String member_id) throws Exception {
		memberDAO.memberSecession(member_id);
	}

	@Override
	public void createAuthorize(AuthorizeVO authorizeVO) throws Exception {
		memberDAO.createAuthorize(authorizeVO);
		
	}

}
