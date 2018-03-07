package com.korail.persistence;

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



public interface WithBoardDao {

	  //추가
		public void writeWithBoard(WithBoardVO withBoardVO) throws Exception;
		public void writeWithSche( WithScheVO scheVO) throws Exception ;
		//수정
		public void updateWithBoard(WithBoardVO withBoardVO) throws Exception;
		public void updateWithSche(WithScheVO scheVO) throws Exception;
		//(특정게시물 한개)삭제
		public void deleteWithBoard(String withboard_Id)throws Exception;
		public void deleteWithSche(String withboard_Id)throws Exception;
		//(특정게시물 한개)조회  ----> 사용: 수정폼
		public WithBoardVO readWithBoard(String withboard_id)throws Exception;
		public  List<WithScheVO> readWithSche(String withboard_id)throws Exception;
		//(전체게시물)조회 ----> 사용: 리스트
		public List<WithBoardVO> listWithBoard()throws Exception;	
		public MemberVO writerInfo (String member_id) throws Exception;
		
		public List<WithBoardVO> listPage(int page) throws Exception;
		public List<WithBoardVO> listCriteria(Criteria cri) throws Exception;
		//전체레코드수 조회
		public int totalCnt()throws Exception;
		
		public List<WithBoardVO> listSearch(SearchCriteria cri) throws Exception;
		public int listSearchCount(SearchCriteria cri) throws Exception ;
		public void ask(WithAskVO askVO) throws Exception;
		public List<HashMap<String, String>> askList(String Sender_Id) throws Exception;
		public void updateState(Map<String, String> map) throws Exception;
		public String searchCode(String StationName) throws Exception;
		public List<WithBoardVO> listSearch2(WithSearchDTO dto) throws Exception;
}
