package com.korail.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korail.domain.AddFileVO;

@Repository
public class AddFileDAOImpl implements AddFileDAO {

	@Inject
	private SqlSession session;

	@Override
	public void create(AddFileVO addFileVO) throws Exception {
		session.insert("file.create",addFileVO);
	}

	@Override
	public void update(AddFileVO addFileVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(String Id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AddFileVO> Select(String Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddFileVO> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
