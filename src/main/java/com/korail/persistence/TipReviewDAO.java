package com.korail.persistence;

import java.util.List;

import com.korail.domain.SearchCriteria;
import com.korail.domain.TipReviewVO;

public interface TipReviewDAO {
	public void insert(TipReviewVO vo) throws Exception;

	public void update(TipReviewVO vo) throws Exception;
	
	public boolean delete(String tipreview_Id) throws Exception;
	
	public TipReviewVO select(String tipreview_Id) throws Exception;
	
	public List<TipReviewVO> listAll() throws Exception;
	
	public List<TipReviewVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}