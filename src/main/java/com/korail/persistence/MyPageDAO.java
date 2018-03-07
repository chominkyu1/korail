package com.korail.persistence;

import java.util.List;

import com.korail.domain.TipreviewVO;

public interface MyPageDAO {
	public List<TipreviewVO> myScrap(String member_Id)throws Exception;
	public void myScrapdelete(String tipreview_Id)throws Exception;
}
