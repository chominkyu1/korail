package com.korail.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.korail.domain.SearchCriteria;
import com.korail.domain.TipReviewVO;
import com.korail.persistence.TipReviewDAO;


@Service
public class TipServiceImpl implements TipService {
	
	@Inject
	private TipReviewDAO dao;
	
	@Override
	public void regist(TipReviewVO vo) throws Exception {
       System.out.println("등록성공>>"+ vo);
       dao.insert(vo);

	}

	@Override
	public void modify(TipReviewVO vo) throws Exception {
	   dao.update(vo);
	}


	@Override
	public List<TipReviewVO> listAll() throws Exception {
		
		return dao.listAll();
	}

	@Override
	public TipReviewVO read(String tipreview_Id) throws Exception {
	
		return dao.select(tipreview_Id);
	}

	@Override
	public boolean remove(String tipreview_Id) throws Exception {
	
		return dao.delete(tipreview_Id);
		
	}

	@Override
	public List<TipReviewVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}


}
