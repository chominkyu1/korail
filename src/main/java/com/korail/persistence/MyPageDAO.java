package com.korail.persistence;

import java.util.List;

import com.korail.domain.TipReviewVO;

public interface MyPageDAO {
	public List<TipReviewVO> myScrap(String member_Id)throws Exception;
	public void myScrapdelete(String tipreview_Id)throws Exception;
}
