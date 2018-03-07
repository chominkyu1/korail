package com.korail.persistence;

import java.util.List;

import com.korail.domain.DiscountVO;
import com.korail.domain.StationVO;

public interface DiscountDAO {
	public void create(DiscountVO discountVO) throws Exception;

	public void update(DiscountVO discountVO) throws Exception;

	public void delete(String discount_Id) throws Exception;

	public List<DiscountVO> listAll() throws Exception;

	public DiscountVO read(String discount_Id) throws Exception;

	public void countUp(String discount_Id) throws Exception;

	public StationVO station(String station_Id) throws Exception;

	public List<String> stationList(String station_Type);

	public String selectStation_Id(String station_Station);
	public String discountSeq();

}