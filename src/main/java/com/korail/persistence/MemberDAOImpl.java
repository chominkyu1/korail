package com.korail.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;
import com.korail.dto.PwsearchDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession session;

	@Override
	public MemberVO login(String member_Loginid, String member_Pw) throws Exception {
		System.out.println("dao");
		Map<String, Object> map = new HashMap<>();
		map.put("member_Loginid", member_Loginid);
		map.put("member_Pw", member_Pw);
		System.out.println("map>>" + map);
		return session.selectOne("member.login", map);
	}

	@Override
	public void insert(MemberVO MemberVO) throws Exception {
		System.out.println("dao>>" + MemberVO);
		session.insert("member.insert", MemberVO);

	}

	@Override
	public void createAuthorize(AuthorizeVO authorizeVO) throws Exception {
		session.insert("member.createAuth",authorizeVO);
		
	}

	@Override
	public String selectAuthId(String member_Email, String tempCode) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("authorie_Mail", member_Email);
		map.put("authorie_Code", tempCode);
		
		return session.selectOne("member.selectAuthId", map);
	}

	@Override
	public int validID(String keyword) throws Exception {
		return session.selectOne("member.validID", keyword);
	}

}
