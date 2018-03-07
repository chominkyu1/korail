package com.korail.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.korail.domain.Criteria;
import com.korail.domain.MemberVO;
import com.korail.domain.SearchCriteria;
import com.korail.domain.WithAskVO;
import com.korail.domain.WithBoardVO;
import com.korail.domain.WithScheVO;
import com.korail.dto.WithSearchDTO;

@Repository
public class WithBoardDaoImpl implements WithBoardDao {
	@Inject
	private SqlSession session;

	/* 읽기 */
	@Override
	public WithBoardVO readWithBoard(String withboard_id) throws Exception {
		return session.selectOne("withboard.readWithBoard", withboard_id);
	}

	@Override
	public List<WithScheVO> readWithSche(String withboard_id) throws Exception {
		return session.selectList("withboard.readWithSche", withboard_id);
	}

	/* 목록조회 */
	@Override
	public List<WithBoardVO> listWithBoard() throws Exception {
		return session.selectList("withboard.listWithBoard");
	}

	/* 쓰기 */
	@Override
	public MemberVO writerInfo(String member_id) throws Exception {
		return session.selectOne("member.writerInfo", member_id);
	}

	@Override
	public void writeWithBoard(WithBoardVO withBoardVO) throws Exception {
		session.insert("withboard.writeWithBoard", withBoardVO);

	}

	@Override
	public void writeWithSche(WithScheVO scheVO) throws Exception {
		session.insert("withboard.writeWithSche", scheVO);
	}

	/* 삭제 */
	@Override
	public void deleteWithBoard(String withboard_Id) throws Exception {

		session.delete("withboard.deleteWithBoard", withboard_Id);
	}

	@Override
	public void deleteWithSche(String withboard_Id) throws Exception {
		session.delete("withboard.deleteWithSche", withboard_Id);

	}

	/* 수정 */
	@Override
	public void updateWithBoard(WithBoardVO withBoardVO) throws Exception {

		session.update("withboard.updateWithBoard", withBoardVO);
	}

	@Override
	public void updateWithSche(WithScheVO scheVO) throws Exception {
		session.update("withboard.updateWithSche", scheVO);

	}

	@Override
	public List<WithBoardVO> listPage(int page) throws Exception {

		int skip = (page - 1) * 10;// 1페이지:0 2페이지:10 3페이지:20
		// 0,10,20 ----> 스킵할 행의 수를 표현

		int limit = 10;// 조회할 최대 행의 수 (뷰에서는 한 화면에 보여질 최대게시물 수)

		RowBounds bounds = new RowBounds(skip, limit);

		return session.selectList("withboard.listWithBoard", null, bounds);
	}

	@Override
	public List<WithBoardVO> listCriteria(Criteria cri) throws Exception {
		RowBounds bounds = new RowBounds(cri.getPageStart(), cri.getPerPageNum());
		return session.selectList("withboard.listWithBoard", null, bounds);
	}

	@Override
	public int totalCnt() throws Exception {
		return session.selectOne("withboard.totalCnt");
	}

	@Override
	public List<WithBoardVO> listSearch(SearchCriteria cri) throws Exception {
		RowBounds bounds = new RowBounds(cri.getPageStart(), cri.getPerPageNum());
		return session.selectList("withboard.listSearch", null, bounds);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne("withboard.listSearchCount", cri);
	}

	@Override
	public void ask(WithAskVO withAskVO) throws Exception {
		session.insert("withboard.ask", withAskVO);

	}

	@Override
	public List<HashMap<String, String>> askList(String Sender_Id) throws Exception {
		return session.selectList("withboard.askList", Sender_Id);
	}

	public void updateState(Map<String, String> map) throws Exception {
		System.out.println(map);
		session.update("withboard.askState", map);
	}

	@Override
	public  String  searchCode(String StationName) throws Exception {
		return session.selectOne("withboard.selectCode", StationName);
	}

	@Override
	public List<WithBoardVO> listSearch2(WithSearchDTO dto) throws Exception {
	return session.selectList("withboard.searchsearch", dto);
	}
}
