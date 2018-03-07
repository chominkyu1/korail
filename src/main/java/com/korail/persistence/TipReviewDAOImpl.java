package com.korail.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korail.domain.SearchCriteria;
import com.korail.domain.TipReviewVO;

@Repository
public class TipReviewDAOImpl implements TipReviewDAO{
	@Inject
	private SqlSession session;

	@Override
	public void insert(TipReviewVO vo) throws Exception {
		session.insert("tip.insert", vo);
		System.out.println("다오임프 입력성공!");
	}

	@Override
	public void update(TipReviewVO vo) throws Exception {
		session.update("tip.update", vo);
		
	}

	@Override
	public boolean delete(String tipreview_Id) throws Exception {
		session.delete("tip.delete", tipreview_Id);
		return false;
	}

	@Override
	public TipReviewVO select(String tipreview_Id) throws Exception {
		
		return session.selectOne("tip.select", tipreview_Id);
	}

	@Override
	public List<TipReviewVO> listAll() throws Exception {
		
		return session.selectList("tip.selectAll");
	}

	@Override  //검색어에 대한 조회
	public List<TipReviewVO> listSearch(SearchCriteria cri) throws Exception {
	
		return session.selectList("tip.listSearch", cri);
	}
	
	@Override //검색어에 대한 레코드 수
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne("tip.listSearchCount", cri);

	}
	
}