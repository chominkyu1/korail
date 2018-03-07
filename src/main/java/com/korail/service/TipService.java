package com.korail.service;

import java.util.List;

import com.korail.domain.SearchCriteria;
import com.korail.domain.TipReviewVO;

public interface TipService {
	
   public void regist(TipReviewVO vo)throws Exception;
   
   public void modify(TipReviewVO vo)throws Exception;
   
   public boolean remove(String tipreview_Id)throws Exception;
   
   public TipReviewVO read(String tipreview_Id)throws Exception;
   
   public List<TipReviewVO> listAll()throws Exception;

   public List<TipReviewVO> listSearchCriteria(SearchCriteria cri)throws Exception;
   
   public int listSearchCount(SearchCriteria cri)throws Exception;
   
}
