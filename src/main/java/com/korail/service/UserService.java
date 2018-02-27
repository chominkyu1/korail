package com.korail.service;

import com.korail.dto.LoginDTO;

import java.util.Map;

import com.korail.domain.UserVO;

public interface UserService {
	
	public UserVO login(String member_loginid,String member_pw)throws Exception;

}
