package com.korail.persistence;

import java.util.List;

import com.korail.domain.DiscountVO;
import com.korail.domain.MemberVO;
import com.korail.domain.WithBoardVO;


public interface ManagerDAO {
	
	public List<MemberVO> memberSearchAll()throws Exception; 
	public List<MemberVO> memberSearchLoginid(String searchText)throws Exception; 
	public List<MemberVO> memberSearchName(String searchText)throws Exception; 
	public List<MemberVO> memberSearchRegidate(String searchText)throws Exception;
	public MemberVO memberSearchDetail(String member_Id)throws Exception;
	public List<WithBoardVO> memberwithboard(String member_Id)throws Exception; 
	public List<DiscountVO> discountAll()throws Exception; 
}
