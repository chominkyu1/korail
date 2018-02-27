package com.korail.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.korail.dto.LoginDTO;
import com.korail.domain.UserVO;
import com.korail.persistence.UserDAO;
@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO userDAO;

	@Override
	public UserVO login(String member_loginid,String member_pw) throws Exception {
		return userDAO.login(member_loginid,member_pw);
	}

}
