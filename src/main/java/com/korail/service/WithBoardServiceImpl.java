package com.korail.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korail.domain.Criteria;
import com.korail.domain.MemberVO;
import com.korail.domain.SearchCriteria;
import com.korail.domain.WithAskVO;
import com.korail.domain.WithBoardVO;
import com.korail.domain.WithScheVO;
import com.korail.dto.WithSearchDTO;
import com.korail.persistence.WithBoardDao;


@Service
public class WithBoardServiceImpl implements WithBoardService {
	@Inject
	private WithBoardDao dao;

	@Override
	public WithBoardVO readWithBoard(String withboard_Id) throws Exception {
		return dao.readWithBoard(withboard_Id);
	}

	@Override
	public List<WithScheVO> readSche(String withboard_Id) throws Exception {
		return dao.readWithSche(withboard_Id);
	}

	@Override
	public List<WithBoardVO> listAllBoard() throws Exception {
		return dao.listWithBoard();
	}

	public MemberVO writerInfo(String member_Id) throws Exception {
		return dao.writerInfo(member_Id);
	}

	@Transactional
	@Override
	public void writeWithBoard(WithBoardVO withBoardVO) throws Exception {

		dao.writeWithBoard(withBoardVO);

		for (int i = 0; i < withBoardVO.getWithsche_Content().length; i++) {
			WithScheVO scheVO = new WithScheVO("", withBoardVO.getWithsche_Station()[i],
					withBoardVO.getWithsche_Startdate()[i], withBoardVO.getWithsche_Enddate()[i],
					withBoardVO.getWithsche_Content()[i], "", // withBoardVO.getWithboard_Id(),
					withBoardVO.getWithsche_Addr()[i]);
			dao.writeWithSche(scheVO);
		}

	}

	@Transactional
	@Override
	public void remove(String withboard_Id) throws Exception {
		dao.deleteWithSche(withboard_Id);
		dao.deleteWithBoard(withboard_Id);
	}

	@Override
	public void modify(WithBoardVO withBoardVO) throws Exception {
		dao.updateWithBoard(withBoardVO);
		for (int i = 0; i < withBoardVO.getWithsche_Content().length; i++) {
			WithScheVO scheVO = new WithScheVO("", withBoardVO.getWithsche_Station()[i],
					withBoardVO.getWithsche_Startdate()[i], withBoardVO.getWithsche_Enddate()[i],
					withBoardVO.getWithsche_Content()[i], "", // withBoardVO.getWithboard_Id(),
					withBoardVO.getWithsche_Addr()[i]);
			dao.updateWithSche(scheVO);
		}

	}

	@Override
	public List<WithBoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCnt() throws Exception {
		return dao.totalCnt();
	}

	@Override
	public List<WithBoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);

	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void ask(WithAskVO withAskVO) throws Exception {
		dao.ask(withAskVO);
	}

	@Override
	public List<HashMap<String, String>> askList(String Sender_Id) throws Exception {
		return dao.askList(Sender_Id);
	}

	@Override
	public void updateState(Map<String, String> map) throws Exception {

		dao.updateState(map);
	}

	@Override
	public String searchCode(String StationName) throws Exception {
		return dao.searchCode(StationName);
	}

	@Override
	public List<WithBoardVO> listSearch2(WithSearchDTO dto) throws Exception {
		return dao.listSearch2(dto);
	}

}
