package com.korail.persistence;

import java.util.List;

import com.korail.domain.AddFileVO;

public interface AddFileDAO {
	public void create(AddFileVO addFileVO) throws Exception;
	public void update(AddFileVO addFileVO) throws Exception;
	public void Delete(String Id) throws Exception;
	public List<AddFileVO> Select(String Id) throws Exception;
	public List<AddFileVO> selectAll() throws Exception;

}
