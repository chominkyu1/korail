package com.korail.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korail.dto.LoginDTO;
import com.korail.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	
	@Override
	public UserVO login(String member_loginid,String member_pw) throws Exception {
		System.out.println("dao");
		Map<String, Object> map = new HashMap<>();
		map.put("member_loginid", member_loginid);
		map.put("member_pw", member_pw);
		System.out.println("map>>"+map);
		return session.selectOne("user.login", map);
	}

}
