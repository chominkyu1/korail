package com.korail.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.korail.domain.MemberVO;
import com.korail.dto.IdsearchDTO;
import com.korail.dto.PwsearchDTO;
import com.korail.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO userDAO;

	@Override
	public MemberVO login(String member_Loginid, String member_Pw) throws Exception {
		return userDAO.login(member_Loginid, member_Pw);
	}

	@Override
	public void insert(MemberVO memberVO) throws Exception {
		userDAO.insert(memberVO);

	}

	@Override
	public String idSearch(IdsearchDTO idsearchDTO) throws Exception {
		return userDAO.idSearch(idsearchDTO);
	}

	@Override
	public void pwSearch(PwsearchDTO pwsearchDTO) throws Exception {
		userDAO.pwSearch(pwsearchDTO);

	}

	@Override
	public void insert1() throws Exception {
		userDAO.insert1();

	}

	@Override
	public void memberSecession(String member_id) throws Exception {
		userDAO.memberSecession(member_id);
	}

}
