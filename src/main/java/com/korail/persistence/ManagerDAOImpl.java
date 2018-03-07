package com.korail.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korail.domain.DiscountVO;
import com.korail.domain.MemberVO;
import com.korail.domain.WithBoardVO;


@Repository
public class ManagerDAOImpl implements ManagerDAO {

	@Inject
	private SqlSession session;

	@Override
	public List<MemberVO> memberSearchAll() throws Exception {
		return session.selectList("manager.membersearch1");
	}

	@Override
	public List<MemberVO> memberSearchLoginid(String searchText) throws Exception {
		return session.selectList("manager.membersearch2",searchText);
	}

	@Override
	public List<MemberVO> memberSearchName(String searchText) throws Exception {
		return session.selectList("manager.membersearch3",searchText);
	}

	@Override
	public List<MemberVO> memberSearchRegidate(String searchText) throws Exception {
		return session.selectList("manager.membersearch4",searchText);
	}

	@Override
	public MemberVO memberSearchDetail(String member_Id) throws Exception {
		return session.selectOne("manager.membersearchdetail",member_Id);
	}

	@Override
	public List<WithBoardVO> memberwithboard(String member_Id) throws Exception {
		return session.selectList("manager.memberwithboard", member_Id);
	}

	@Override
	public List<DiscountVO> discountAll() throws Exception {
		return session.selectList("manager.discountAll");
	}

	

}
