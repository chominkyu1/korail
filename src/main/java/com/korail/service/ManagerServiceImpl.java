package com.korail.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.korail.domain.DiscountVO;
import com.korail.domain.MemberVO;
import com.korail.domain.WithBoardVO;
import com.korail.dto.SearchDTO;
import com.korail.persistence.ManagerDAO;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Inject
	private ManagerDAO managerDAO;

	@Override
	public List<MemberVO> memberSearch(SearchDTO searchDTO) throws Exception {
		String searchType = searchDTO.getSearchType();
		String searchText = searchDTO.getSearchText();
		System.out.println("searchType>>" + searchType);

		if (searchType.equals("all")) {
			return managerDAO.memberSearchAll();
		} else if (searchType.equals("id")) {
			return managerDAO.memberSearchLoginid(searchText);
		} else if (searchType.equals("name")) {
			return managerDAO.memberSearchName(searchText);
		} else if (searchType.equals("date")) {
			return managerDAO.memberSearchRegidate(searchText);
		}
		return null;
	}

	@Override
	public MemberVO memberSearchDetail(String member_Id) throws Exception {
		return managerDAO.memberSearchDetail(member_Id);
	}

	@Override
	public List<WithBoardVO> memberwithboard(String member_Id) throws Exception {
		return managerDAO.memberwithboard(member_Id);
	}

	@Override
	public List<DiscountVO> discountAll() throws Exception {
		return managerDAO.discountAll();
	}

}
