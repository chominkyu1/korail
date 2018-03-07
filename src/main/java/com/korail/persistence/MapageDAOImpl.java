package com.korail.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korail.domain.TipreviewVO;
@Repository
public class MapageDAOImpl implements MyPageDAO {
	@Inject
	SqlSession session;
	@Override
	public void myScrapdelete(String tipreview_Id) throws Exception {
		session.delete("mypage.scrapdelete", tipreview_Id);
	}
	@Override
	public List<TipreviewVO> myScrap(String member_Id) throws Exception {
		System.out.println("dao>>"+member_Id);
		return session.selectList("mypage.mypagescrap", member_Id);
	}

}
