package com.korail.persistence;

import com.korail.dto.LoginDTO;

import java.util.Map;

import com.korail.domain.UserVO;

public interface UserDAO {

	 public UserVO login(String member_loginid,String member_pw)throws Exception;
}
