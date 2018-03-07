package com.korail.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.korail.domain.Criteria;
import com.korail.domain.MemberVO;
import com.korail.domain.SearchCriteria;
import com.korail.domain.WithAskVO;
import com.korail.domain.WithBoardVO;
import com.korail.domain.WithScheVO;
import com.korail.dto.WithSearchDTO;



public interface WithBoardService {
	public WithBoardVO readWithBoard(String withboard_Id) throws Exception;// 글 한 개 조회

	public List<WithBoardVO> listAllBoard() throws Exception;// 글 한 개 조회

	public List<WithScheVO> readSche(String withboard_Id) throws Exception;// 일정 조회

	public MemberVO writerInfo(String member_Id) throws Exception;

	public void writeWithBoard(WithBoardVO withBoardVO) throws Exception;

	public void modify(WithBoardVO withBoardVO) throws Exception;

	public void remove(String withboard_Id) throws Exception;

	public List<WithBoardVO> listCriteria(Criteria cri) throws Exception;// 특정 페이지 조회

	public int totalCnt() throws Exception;

	public List<WithBoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;

	public void ask (WithAskVO withAskVO) throws Exception;
	
	public List<HashMap<String, String>> askList(String Sender_Id) throws Exception;
	
	public void updateState(Map<String,String> map) throws Exception;
	
	public String searchCode(String StationName) throws Exception ;

	public List<WithBoardVO> listSearch2(WithSearchDTO dto) throws Exception;
}
