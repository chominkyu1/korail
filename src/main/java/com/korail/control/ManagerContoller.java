package com.korail.control;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korail.domain.DiscountVO;
import com.korail.dto.SearchDTO;
import com.korail.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerContoller {
	@Inject
	private ManagerService managerService;
	
	@RequestMapping("/memberList")
	public void memberList(SearchDTO searchDTO,Model m) throws Exception {
		//System.out.println(searchDTO);
		m.addAttribute("memberList", managerService.memberSearch(searchDTO));
	}
	@RequestMapping("/memberDetail")
	public void memberDetail(String member_Id,Model m) throws Exception {
		System.out.println(member_Id);
		m.addAttribute("memberDetail",managerService.memberSearchDetail(member_Id));
		m.addAttribute("memberwithboard",managerService.memberwithboard(member_Id));
		
	}
	@RequestMapping("/saleBoardList")
	public void saleBoardList(Model m) throws Exception {
		m.addAttribute("discountAll",managerService.discountAll());
		List<DiscountVO> discountVO = managerService.discountAll();
		for(int i = 0;i<discountVO.size();i++) {
			System.out.println(discountVO.get(2));
		}
	
	}
	

}
