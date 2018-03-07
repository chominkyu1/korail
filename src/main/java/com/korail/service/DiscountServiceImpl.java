package com.korail.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korail.domain.AddFileVO;
import com.korail.domain.DiscountVO;
import com.korail.domain.StationVO;
import com.korail.persistence.AddFileDAO;
import com.korail.persistence.DiscountDAO;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Inject
	private DiscountDAO discountDAO;
	
	private AddFileDAO addfileDAO;

	@Transactional
	@Override
	public void create(DiscountVO discountVO, AddFileVO addFileVO) throws Exception {
		String discount_Id = discountDAO.discountSeq();
		
		discountVO.setDiscount_Id(discount_Id);
		discountDAO.create(discountVO);
		
		//addFileVO.setDiscount_Id(discount_Id);
		//addfileDAO.create(addFileVO);
	}

	@Override
	public void update(DiscountVO discountVO) throws Exception {
		discountDAO.update(discountVO);
	}

	@Override
	public void delete(String discount_Id) throws Exception {
		discountDAO.delete(discount_Id);
	}
	
	@Override
	public List<DiscountVO> listAll() throws Exception {
		return discountDAO.listAll();
	}

	@Override
	public DiscountVO read(String discount_Id) throws Exception {
		//discountDAO.countUp(discount_Id); 게시물 조회시 회원이 클릭했다면 조회수 1 증가 
		return discountDAO.read(discount_Id);
	}

	@Override
	public StationVO station(String station_Id) throws Exception {
		return discountDAO.station(station_Id);
	}

	@Override
	public List<String> stationList(String station_Type) throws Exception {
		return discountDAO.stationList(station_Type);
	}

	@Override
	public String selectStation_Id(String station_Station) {
		return discountDAO.selectStation_Id(station_Station);
	}

	

}
