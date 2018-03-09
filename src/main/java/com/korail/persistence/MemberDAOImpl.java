package com.korail.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;
import com.korail.dto.IdsearchDTO;
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
	public void insert(MemberVO memberVO) throws Exception {
		System.out.println("dao>>" + memberVO);
		session.insert("member.insert", memberVO);

	}

	@Override
	public String idSearch(IdsearchDTO idsearchDTO) throws Exception {
		return session.selectOne("member.idsearch", idsearchDTO);
	}

	@Override
	public void pwSearch(PwsearchDTO pwsearchDTO) throws Exception {
		session.update("member.pwsearch", pwsearchDTO);

	}

	@Override
	public void insert1() throws Exception {
		session.insert("member.insert");
	}

	@Override
	public void memberSecession(String member_id) throws Exception {
		session.delete("member.membersecession", member_id);
	}

	@Override
	public void createAuthorize(AuthorizeVO authorizeVO) throws Exception {
		session.insert("member.createAuth",authorizeVO);
		
	}

}
