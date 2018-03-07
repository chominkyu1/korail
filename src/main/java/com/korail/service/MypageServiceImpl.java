package com.korail.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.korail.domain.TipreviewVO;
import com.korail.persistence.MyPageDAO;
@Service
public class MypageServiceImpl implements MypageService {
	@Inject
	private MyPageDAO myPageDAO;
	

	@Override
	public void myScrapdelete(String tipreview_Id) throws Exception {
		myPageDAO.myScrapdelete(tipreview_Id);
	}

	@Override
	public List<TipreviewVO> myScrap(String member_Id) throws Exception {
		return myPageDAO.myScrap(member_Id);
	}

}
