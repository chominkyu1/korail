package com.korail.service;

import java.util.List;

import com.korail.domain.TipReviewVO;

public interface MypageService {
	public List<TipReviewVO>myScrap(String member_Id)throws Exception;	
	public void myScrapdelete(String tipreview_Id)throws Exception;

}
