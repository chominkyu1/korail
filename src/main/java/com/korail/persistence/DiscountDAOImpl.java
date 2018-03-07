package com.korail.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korail.domain.DiscountVO;
import com.korail.domain.StationVO;

@Repository
public class DiscountDAOImpl implements DiscountDAO {

	
	@Inject
	private SqlSession session;
	
	

	@Override
	public void create(DiscountVO discountVO) {
		session.insert("discount.create", discountVO);
		
	}

	@Override
	public void update(DiscountVO discountVO) {
		session.update("discount.update", discountVO);
		
	}

	@Override
	public void delete(String discount_Id) {
		System.out.println("���� �ٿ� �����̴� ���� �����Ѵ� ������??>>"+discount_Id);
		int t =session.delete("discount.delete",discount_Id);
		System.out.println("�����̳� ���г� �װ��� �����δ� >>"+t);
		
	}
	
	@Override
	public List<DiscountVO> listAll() {
		return session.selectList("discount.listAll");
	}

	@Override
	public DiscountVO read(String discount_Id) {
		return session.selectOne("discount.read", discount_Id);
	}

	@Override
	public void countUp(String discount_Id) throws Exception {
		session.update("discount.countUp", discount_Id);
	}

	@Override
	public StationVO station(String station_Id) throws Exception {
		System.out.println("���� �ٿ� ���� : ����ϰ��� �ϴ� ��ȣ >>" +station_Id);
		return session.selectOne("discount.station", station_Id);
	}

	@Override
	public List<String> stationList(String station_Type) {
		return session.selectList("discount.stationList", station_Type);
	}

	@Override
	public String selectStation_Id(String station_Station) {

		return session.selectOne("discount.stationId", station_Station);
	}

	@Override
	public String discountSeq() {
		return session.selectOne("discount.discountSeq") ;
	}
	
 

}
